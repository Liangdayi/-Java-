package west2MilkTeaShop;

import java.util.Calendar;

public class Coconut extends Ingredient {
    public Coconut(int year,int month,int day){
        name="Coconut";
        produceDate= Calendar.getInstance();
        sellByDate=5;
        produceDate.set(year,month,day,0,0,0);
    }
    public String toString(){
        int month=this.produceDate.get(Calendar.MONTH)+1;//转化成我们熟悉的日期
        return  "产品信息:"+
                "配料名"+this.name+
                "生产日期："+this.produceDate.get(Calendar.YEAR)+'/'+month+'/'+this.produceDate.get(Calendar.DAY_OF_MONTH)+
                "保质期："+this.sellByDate;
    }
}
