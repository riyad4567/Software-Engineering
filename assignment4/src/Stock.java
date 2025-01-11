import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Stock implements Subject{
    private int count;
    private String stockName;
    private double price;
    private List<Observer> users = new ArrayList<>();

    public Stock(int count, double price,String stockName) {
        this.count = count;
        this.price = price;
        this.stockName=stockName;
    }

    public void addUser(Observer user) {
        users.add(user);
    }
    public void removeUser(Observer user) {
        users.remove(user);
    }

    public void notifyUsers(Map<Observer, SocketWrapper> userWithSocket) throws IOException {
        for (Observer user : users) {
            //Stock stock = stocks.get(stockName);
            user.getUpdate(stockName,count,price);
            String str="Current States of Stock " + stockName + " is: price '" + price + "' count '" + count + "'";
            if(userWithSocket.containsKey(user)){
                SocketWrapper client=userWithSocket.get(user);
                client.write(str);
            } else {
                user.notificationList.add(str);
            }

        }

    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
