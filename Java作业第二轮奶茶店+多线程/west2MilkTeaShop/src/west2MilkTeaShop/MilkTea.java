package west2MilkTeaShop;

public class MilkTea {
    private String name;
    private Ingredient i;
    public MilkTea(String name,Ingredient i){
        this.name=name;
        this.i=i;
    }
    public String getName(){
        return name;
    }
    public String toString(){
        return this.name+i.toString();
    }
}
