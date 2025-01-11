import java.io.IOException;
import java.io.Serializable;
import java.util.*;

public class Administrator implements Serializable {
   // private Map<String, Stock> stocks = new HashMap<>();
    private List<Stock> listOfStock=new ArrayList<>();
    private Map<String, Observer> userWithName = new HashMap<>();

    public void changePrice(String stockName, double price,Map<Observer, SocketWrapper> userWithSocket) throws IOException {
        Stock stock = getStock(stockName);
        if(stock ==null)
        {
            return;
        }
        stock.setPrice(stock.getPrice() + price);
        //System.out.println("Stock price has been changed of "+stockName);
        stock.notifyUsers(userWithSocket);
    }

    public void changeCount(String stockName, int count,Map<Observer, SocketWrapper> userWithSocket) throws IOException {
        Stock stock = getStock(stockName);
        if(stock ==null)
        {
            return;
        }
        stock.setCount(stock.getCount() + count);
        //System.out.println("Stock count has been changed of "+stockName);
        stock.notifyUsers(userWithSocket);
    }

    public void addStocks(Stock stock) {
       listOfStock.add(stock);
    }
    public Observer getUser(String username)
    {
        //System.out.println("Hell");
        if(userWithName.get(username)==null)
        {
            User user=new User(username);
            userWithName.put(username,user);
            return user;
        }
        //System.out.println("Hello");
        return userWithName.get(username);
    }
    public Stock getStock(String stockName)
    {
        for(Stock stock:listOfStock)
        {
            if(stock.getStockName().equals(stockName))
            {
                return stock;
            }
        }
        return null;
    }
    public List<Stock> getListOfStock() {
        return listOfStock;
    }




    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        SocketWrapper server = new SocketWrapper("127.0.0.1", 3000);

        new Thread(() -> {
            try {
                String[] strArr = input.nextLine().split(" ");
                //User obj=new User(s);

                server.write(strArr);
                Object respond = server.read();
                System.out.println((String) respond);
                while (true) {
                    String[] inputArr = input.nextLine().split(" ");
                    server.write(inputArr);
                    Object serverRespond=server.read();
                    System.out.println((String) serverRespond);
                }

            } catch (IOException e) {
                System.out.println("disconnected");
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    server.closeConnection();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

        }).start();
    }
}
