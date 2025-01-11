import java.util.ArrayList;
import java.util.List;

public class Shake {
    private String basePrice;
    private String type;
    private List<String> baseIngredients = new ArrayList<>();
    private List<String> addIngredients = new ArrayList<>();
    private List<String> priceList = new ArrayList<>();


    public Shake(String basePrice,List<String>priceList, String type, List<String> baseIngredients, List<String> addIngredients) {
        this.basePrice = basePrice;
        this.priceList=priceList;
        this.type = type;
        this.baseIngredients = baseIngredients;
        this.addIngredients = addIngredients;
    }

    public String getBasePrice() {
        return basePrice;
    }

    public List<String> getPriceList() {
        return priceList;
    }

    public List<String> getBaseIngredients() {
        return baseIngredients;
    }

    public List<String> getAddIngredients() {
        return addIngredients;
    }

    public String getType() {
        return type;
    }
}