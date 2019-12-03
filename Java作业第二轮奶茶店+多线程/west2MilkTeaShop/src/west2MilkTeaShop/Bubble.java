package west2MilkTeaShop;

import java.util.Calendar;

public class Bubble extends Ingredient {
    public Bubble(int year,int month,int day){
        name="Bubble";
        produceDate= Calendar.getInstance();
        sellByDate=7;
        produceDate.set(year,month-1,day,0,0,0);
    }
    public String toString(){
        int month=this.produceDate.get(Calendar.MONTH)+1;//转化成我们熟悉的日期
        return  "产品信息:"+
                "配料名"+this.name+
                "生产日期："+this.produceDate.get(Calendar.YEAR)+'/'+month+'/'+this.produceDate.get(Calendar.DAY_OF_MONTH)+
                "保质期："+this.sellByDate;
    }

}
