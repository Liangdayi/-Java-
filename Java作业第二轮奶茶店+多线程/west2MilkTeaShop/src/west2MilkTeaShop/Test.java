package west2MilkTeaShop;

import java.util.Calendar;

public class Test {
    public static void main(String[] args){
        TeaShop shop=new TeaShop();
        Calendar cal=Calendar.getInstance();//系统日期
        int year=cal.get(Calendar.YEAR);
        int month=cal.get(Calendar.MONTH);
        int day=cal.get(Calendar.DAY_OF_MONTH);
        Ingredient ingredient1=new Bubble(2019,11,10);//用于测试配料过期应该删除
        shop.buy(ingredient1);
        Ingredient ingredient2=new Bubble(year,month,day);
        shop.buy(ingredient2);
        Ingredient ingredient3=new Coconut(year,month,day);
        shop.buy(ingredient3);
        try{
            shop.sell("珍珠奶茶1","Bubble");
        }
        catch (SoldOutException s){
            s.printStackTrace();
        }
        try{
            shop.sell("椰果奶茶1","Coconut");
        }
        catch (SoldOutException s){
            s.printStackTrace();
        }

    }
}
