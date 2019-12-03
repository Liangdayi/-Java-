package west2MilkTeaShop;

import java.util.ArrayList;
import java.util.Calendar;

public class TeaShop implements Shop{
    private ArrayList<Bubble> Blist=new ArrayList<Bubble>();
    private ArrayList<Coconut> Clist=new ArrayList<Coconut>();
    /*进货——添加配料的私有方法*/
    private void addIngredient(Bubble b){Blist.add(b);}
    private void addIngredient(Coconut c){Clist.add(c);}

    public void buy(Ingredient i){
        if(i instanceof Bubble){
            addIngredient((Bubble)i);
        }
        if(i instanceof Coconut){
            addIngredient((Coconut)i);
        }
    }
    public void sell(String teaName,String ingredientName) throws SoldOutException{
        Calendar cal=Calendar.getInstance();
        long dis=0;
        if(ingredientName.equals("Bubble")){
            //判断过期
            dis=(cal.getTimeInMillis()-Blist.get(0).getProduceDate().getTimeInMillis())/(1000*60*60*24);
            while(dis>=Blist.get(0).getSellByDate()){
                Blist.remove(0);//从列表中移除掉过期的配料；
                if(Blist.size()==0)break;
                dis=(cal.getTimeInMillis()-Blist.get(0).getProduceDate().getTimeInMillis())/(1000*60*60*24);
            }
            if(Blist.size()!=0){
                MilkTea milkTea=new MilkTea(teaName,Blist.get(0));
                System.out.println("同学您好，您的奶茶:");
                System.out.println(milkTea.toString());
                Blist.remove(0);
            }
            else{
                throw new SoldOutException();//抛出售完异常
            }
        }
        if(ingredientName.equals("Coconut")){
            //判断过期
            dis=(cal.getTimeInMillis()-Clist.get(0).getProduceDate().getTimeInMillis())/(1000*60*60*24);
            while(dis>=Clist.get(0).getSellByDate()){
                Clist.remove(0);//从列表中移除掉过期的配料；
                if(Clist.size()==0)break;
                dis=(cal.getTimeInMillis()-Clist.get(0).getProduceDate().getTimeInMillis())/(1000*60*60*24);
            }
            if(Clist.size()!=0){
                MilkTea milkTea=new MilkTea(teaName,Clist.get(0));
                System.out.println("同学您好，您的奶茶:");
                System.out.println(milkTea.toString());
                Clist.remove(0);
            }
            else{
                throw new SoldOutException();//抛出售完异常
            }
        }
    }
}
