package west2MilkTeaShop;

import java.util.Calendar;

public abstract class Ingredient {
    protected String name;//配料名
    protected Calendar produceDate;//生产日期
    protected int sellByDate;//保质期
    public void setName(String name) {
        this.name = name;
    }

    public void setProduceDate(Calendar produceDate) {
        this.produceDate = produceDate;
    }

    public void setSellByDate(int sellByDate) {
        this.sellByDate = sellByDate;
    }

    public String getName(){
        return name;
    }
    public Calendar getProduceDate(){
        return produceDate;
    }
    public int getSellByDate(){
        return sellByDate;
    }
    public String toString(){
        return "配料名:"+this.name+"生产日期："+this.produceDate+"保质期："+this.sellByDate;
    }
}
