package west2MilkTeaShop;

interface Shop{
    public void buy(Ingredient i);
    public void sell(String teaName,String ingredientName)throws SoldOutException;
}
