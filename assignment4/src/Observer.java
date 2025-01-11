import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Observer implements Serializable {
    protected Stock stock;
    protected List<Stock> subscribedList;
    protected List<String> notificationList;
    public abstract void subscribe(Stock stock);
    public abstract boolean unsubscribe(Stock stock);
    public abstract List<Stock> view();
    public abstract void getUpdate(String stockName, int count, double price);



}
