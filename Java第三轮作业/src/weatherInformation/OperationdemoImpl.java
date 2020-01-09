package weatherInformation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class OperationdemoImpl implements Operationdemo {
    public  void Insert (Forecast fc){
        Connection conn=null;
        PreparedStatement pstmt=null;
        try{
            //注册驱动+连接数据库
            conn =JDBCUtils.getConnection();
            //创建执行语句
            String sql = "insert into weather_forecast values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            for(int i=0;i<4;i++){
                pstmt.setString(1,fc.getCity());
                pstmt.setString(2,fc.getProvince());
                pstmt.setString(3,fc.getReporttime());
                pstmt.setString(4,fc.getCasts().get(i).getDate());
                pstmt.setString(5,fc.getCasts().get(i).getWeek());
                pstmt.setString(6,fc.getCasts().get(i).getDayweather());
                pstmt.setString(7,fc.getCasts().get(i).getDaytemp());
                pstmt.setString(8,fc.getCasts().get(i).getDaywind());
                pstmt.setString(9,fc.getCasts().get(i).getDaypower());
                pstmt.setString(10,fc.getCasts().get(i).getNightweather());
                pstmt.setString(11,fc.getCasts().get(i).getNighttemp());
                pstmt.setString(12,fc.getCasts().get(i).getNightwind());
                pstmt.setString(13,fc.getCasts().get(i).getNightpower());
                pstmt.executeUpdate();
            }

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            //System.out.println("关闭资源");
            JDBCUtils.closeAll(conn,pstmt,null);
        }
    }


    public void Get(String city){
        Connection conn=null;
        PreparedStatement pstmt=null;
        try{
            //注册驱动+连接数据库
            conn =JDBCUtils.getConnection();
            //创建执行语句
            String sql = "select * from weather_forecast where city='"+city+"'";
            pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next())
            {
                String rs_city;
                String rs_daytemp;
                String rs_nighttemp;
                rs_city=rs.getString(1);
                rs_daytemp=rs.getString(7);
                rs_nighttemp=rs.getString(11);

                System.out.println(rs_city+"的天气信息为："+"白天温度"+rs_daytemp+",夜晚温度"+rs_nighttemp);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            //System.out.println("关闭资源");
            JDBCUtils.closeAll(conn,pstmt,null);
        }
    }
}
