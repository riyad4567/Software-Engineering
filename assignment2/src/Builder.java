import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Builder {
    private String basePrice;
    private String type;
    private List<String> baseIngredients=new ArrayList<>();
    private List<String> addIngredients=new ArrayList<>();
    private List<String> priceList = new ArrayList<>();

    public void setBasePrice(String basePrice) {
        this.basePrice = basePrice;
    }


    public void setBaseIngredients(List<String> arrOfIngredients) {
        this.baseIngredients= arrOfIngredients;
    }

    public void setPriceList(String price) {
        this.priceList.add(price);
    }

    public List<String> getBaseIngredients() {
        return baseIngredients;
    }

    public void setAddIngredients(String addIngredient) {
        this.addIngredients.add(addIngredient);
    }

    public void setType(String type) {
        this.type = type;
    }

    public Shake getObject() {
        return new Shake(basePrice,priceList,type,baseIngredients,addIngredients);
    }
}
