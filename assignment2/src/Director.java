import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Director {
    List<String> baseList=new ArrayList<>();
    public void ChocolateShake(Builder builder)
    {
        builder.setType("Chocolate Shake");
        baseList=Arrays.asList("Chocolate syrup","Chocolate ice cream","Regular Milk","Sugar");
        builder.setBaseIngredients(baseList);
        builder.setBasePrice("230");
    }
    public void CoffeeShake(Builder builder)
    {
        builder.setType("Coffee Shake");
        baseList=Arrays.asList("Coffee","Jello","Regular Milk","Sugar");
        builder.setBaseIngredients(baseList);
        builder.setBasePrice("250");
    }
    public void StrawberryShake(Builder builder)
    {
        builder.setType("Strawberry Shake");
        baseList=Arrays.asList("Strawberry syrup","Strawberry ice cream","Regular Milk","Sugar");
        builder.setBaseIngredients(baseList);
        builder.setBasePrice("200");
    }
    public void VanillaShake(Builder builder)
    {
        builder.setType("Vanilla Shake");
        baseList=Arrays.asList("Vanilla flavoring","Jello","Regular Milk","Sugar");
        builder.setBaseIngredients(baseList);
        builder.setBasePrice("190");
    }
    public void ZeroShake(Builder builder)
    {
        builder.setType("Zero Shake");
        baseList=Arrays.asList("Vanilla flavoring","Sugar-free jello","Regular Milk","Sweetener");
        builder.setBaseIngredients(baseList);
        builder.setBasePrice("240");
    }
    public void AddIngredients(Builder builder,String addIngredient,String price)
    {
        if(addIngredient.equals("Almond Milk"))
        {
            List<String>baselocalList=builder.getBaseIngredients();
            baselocalList.set(2,"Almond Milk");
            builder.setBaseIngredients(baselocalList);
        }
        builder.setAddIngredients(addIngredient);
        builder.setPriceList(price);
    }

}
