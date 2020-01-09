package weatherInformation;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Test {
    private static List<String> adcodeList= Arrays.asList("110000","120000","310000","500000","810000","820000","130100","140100","150100","210100","220100","230100","320100","330100","340100","350100","360100","370100","410100","420100","430100","440100","450100","460100","510100","520100","530100","540100","610100","620100","630100","640100","650100");

    public static void Create()    //创建Student表
    {
        Connection conn=null;//连接数据库
        PreparedStatement pstmt=null;
        String sql = "CREATE TABLE `weather`.`weather_forecast` (\n" +
                "  `city` VARCHAR(45) NULL,\n" +
                "  `province` VARCHAR(45) NULL,\n" +
                "  `report_time` VARCHAR(45) NULL,\n" +
                "  `forecast_date` VARCHAR(45) NULL,\n" +
                "  `weekday` VARCHAR(45) NULL,\n" +
                "  `dayweather` VARCHAR(45) NULL,\n" +
                "  `daytemp` VARCHAR(45) NULL,\n" +
                "  `daywind` VARCHAR(45) NULL,\n" +
                "  `daywind_power` VARCHAR(45) NULL,\n" +
                "  `nightweather` VARCHAR(45) NULL,\n" +
                "  `nighttemp` VARCHAR(45) NULL,\n" +
                "  `nightwind` VARCHAR(45) NULL,\n" +
                "  `nightwind_power` VARCHAR(45) NULL);\n";
        try
        {
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
        } catch(Exception e){
            e.printStackTrace();
        }finally{
            System.out.println("关闭资源");
            JDBCUtils.closeAll(conn,pstmt,null);
        }
    }



    public static void main(String[] args) {
        Operationdemo operationdemo=new OperationdemoImpl();
        //Create();
        int n;
        for(n=0;n<adcodeList.size();n++)
        {
            JSONObject jsontest=new JSONObject();
            jsontest= Weatherget.result(adcodeList.get(n));
            JSONArray jsonForecasts=jsontest.getJSONArray("forecasts");
            JSONObject jb=jsonForecasts.getJSONObject(0);

            /*对所读取的数据转化为java对象*/
            Forecast forecast=new Forecast();
            forecast.setCity(jb.getString("city"));
            forecast.setAdcode(jb.getString("adcode"));
            forecast.setProvince(jb.getString("province"));
            forecast.setReporttime(jb.getString("reporttime"));
            List<Castdata> castdataList = new ArrayList<>();
            JSONArray casts=jb.getJSONArray("casts");
            int i;
            for(i=0;i<4;i++)
            {
                JSONObject jsoncast=casts.getJSONObject(i);
                Castdata castdata=new Castdata();
                castdata.setDate(jsoncast.getString("date"));
                castdata.setWeek(jsoncast.getString("week"));
                castdata.setDayweather(jsoncast.getString("dayweather"));
                castdata.setNightweather(jsoncast.getString("nightweather"));
                castdata.setDaytemp(jsoncast.getString("daytemp"));
                castdata.setNighttemp(jsoncast.getString("nighttemp"));
                castdata.setDaywind(jsoncast.getString("daywind"));
                castdata.setNightwind(jsoncast.getString("nightwind"));
                castdata.setDaypower(jsoncast.getString("daypower"));
                castdata.setNightpower(jsoncast.getString("nightpower"));
                castdataList.add(castdata);
            }
            forecast.setCasts(castdataList);
            /////////////////////////////////////////////////////
            operationdemo.Insert(forecast);
        }
        System.out.println("数据成功导入数据库");
        System.out.println("请输入想要查询天气的城市:");
        Scanner in = new Scanner(System.in);
        String city = in.next();
        operationdemo.Get(city);

    }
}
