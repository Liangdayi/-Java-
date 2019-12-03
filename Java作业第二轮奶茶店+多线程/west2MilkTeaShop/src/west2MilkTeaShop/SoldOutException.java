package west2MilkTeaShop;

public class SoldOutException extends Exception{
    public SoldOutException(){
        super();
    }
    public String toString(){
        return "同学不好意思,该配料已售完~";
    }
}
