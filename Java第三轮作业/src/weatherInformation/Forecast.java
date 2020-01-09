package weatherInformation;

import java.util.Date;
import java.util.List;

public class Forecast {
    private String city;
    private String adcode;
    private String province;
    private String reporttime;
    private List<Castdata> casts;

    public void setCity(String city) {
        this.city = city;
    }

    public void setAdcode(String adcode) {
        this.adcode = adcode;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setReporttime(String reporttime) {
        this.reporttime = reporttime;
    }

    public void setCasts(List<Castdata> casts) {
        this.casts = casts;
    }

    public String getCity() {
        return city;
    }

    public String getAdcode() {
        return adcode;
    }

    public String getProvince() {
        return province;
    }

    public String getReporttime() {
        return reporttime;
    }

    public List<Castdata> getCasts() {
        return casts;
    }
}
