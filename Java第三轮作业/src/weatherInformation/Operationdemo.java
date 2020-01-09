package weatherInformation;

public interface Operationdemo {
    public void Insert(Forecast fc);//将数据写入数据库

    public void Get(String city);//从数据库查询天气信息
}
