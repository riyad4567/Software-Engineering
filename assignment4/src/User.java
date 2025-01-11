import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User extends Observer implements Serializable {
    private String username;
    public User(String username) {
        this.username = username;
        subscribedList=new ArrayList<>();
        notificationList=new ArrayList<>();
    }

    @Override
    public void subscribe(Stock stock) {
        this.stock = stock;
        this.stock.addUser(this);
        subscribedList.add(this.stock);
    }

    @Override
    public boolean unsubscribe(Stock stock) {
        this.stock = stock;
        for(Stock obj:subscribedList)
        {
            if(obj.equals(stock))
            {
                this.stock.removeUser(this);
                subscribedList.remove(this.stock);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Stock> view() {
        return subscribedList;
    }

    @Override
    public void getUpdate(String stockName, int count, double price) {
        System.out.println("Current States of Stock " + stockName + " is: price '" + price + "' count '" + count + "'");
        //SocketWrapper obj=userWithSocket.get(sto)
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
