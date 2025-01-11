import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(3000);
        //Scanner input = new Scanner(System.in);
        System.out.println("Server Started");
        Map<Observer, SocketWrapper> userWithSocket = new HashMap<>();
        Administrator administrator = new Administrator();
        try {
            Scanner scanner = new Scanner(new File("input.txt"));
            while (scanner.hasNextLine()) {
                String str = scanner.nextLine();
                //allStock += str+"\n";
                String[] arr = str.split(" ");
                int count = Integer.parseInt(arr[1]);
                double price = Double.parseDouble(arr[2]);
                //administrator.addStocks(arr[0], new Stock(count, price,arr[0]));
                administrator.addStocks(new Stock(count, price, arr[0]));
                //System.out.println(line);
            }
            scanner.close();
            //System.out.println("file closed");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (true) {
            Socket clientsocket = server.accept();
            new Thread(() -> {
                SocketWrapper client = null;
                try {
                    client = new SocketWrapper(clientsocket);
                } catch (IOException e) {
                    System.out.println("Server disconnected");
                }
                try {
                    Observer user = null;
                    String allStockStr = "Stock List----" + '\n';
                    boolean userflag = false;
                    boolean adminflag = false;
                    while (true) {
                        //System.out.println("Here");
                        Object recieveData = client.read();
                        String[] inputArr = (String[]) recieveData;
                        if (inputArr[0].equalsIgnoreCase("login")) {
                            if (!userflag) {
                                //System.out.println("A");
                                user = administrator.getUser(inputArr[1]);
                                for (Stock stock : administrator.getListOfStock()) {
                                    allStockStr += stock.getStockName() + " " + stock.getCount() + " " + stock.getPrice() + '\n';
                                }
                                //client.write(user);
                                client.write(allStockStr);
                                userflag = true;
                                userWithSocket.put(user, client);
                                String msg = "";
                                if (!user.notificationList.isEmpty()) {
                                    msg += "Notifications:\n";
                                    for (String notification : user.notificationList) {
                                        msg += notification;
                                    }
                                }
                                client.write(msg);
                            } else {
                                client.write("You are already logged in");
                            }
                        } else if (inputArr[0].equalsIgnoreCase("Admin")) {
                            client.write("Admin Logged In-----");
                            adminflag = true;
                            //userWithSocket.put("Admin",client);
                        } else if (inputArr[0].equals("S") && userflag) {
                            if (administrator.getStock(inputArr[1]) == null) {
                                client.write("This Stock is not in stockMarket ");
                                //System.out.println("This Stock is not in stockMarket ");
                            } else {
                                if (user != null) {
                                    user.subscribe(administrator.getStock(inputArr[1]));
                                    client.write("User Subscription Successful");
                                } else {
                                    client.write("You are not logged in");
                                }
                            }
                        } else if (inputArr[0].equals("V") && userflag) {
                            if (user != null) {
                                List<Stock> arrOfStock = user.view();
                                String msg = "Your Subscribed Stocks are--\n";
                                for (Stock stock : arrOfStock) {
                                    msg += "Stock name: " + stock.getStockName() + " Price: " + stock.getPrice() + " Count: " + stock.getCount() + "\n";
                                    //System.out.println(stock.getStockName());
                                }
                                client.write(msg);
                            } else {
                                client.write("You are not logged in");
                            }

                        } else if (inputArr[0].equals("U") && userflag) {
                            if (administrator.getStock(inputArr[1]) == null) {
                                client.write("This Stock is not in stockMarket ");
                                //System.out.println("This Stock is not in stockMarket ");
                            } else {
                                if (user != null) {
                                    boolean flag = user.unsubscribe(administrator.getStock(inputArr[1]));
                                    if (flag) {
                                        client.write("User unsubscription Successful");
                                    } else {
                                        client.write("User unsubscription is not successful");
                                    }
                                } else {
                                    client.write("You are not logged in");
                                }

                            }
                        } else if (inputArr[0].equalsIgnoreCase("logout")) {

                            userflag = false;
                            // client.closeConnection();
                            userWithSocket.remove(user);
                            user = null;
                            client.write("Logout successful----");
                        } else if (inputArr[0].equals("I") && adminflag) {
                            administrator.changePrice(inputArr[1], Double.parseDouble(inputArr[2]), userWithSocket);
                            client.write("Stock price has been increased");
                        } else if (inputArr[0].equals("D") && adminflag) {
                            administrator.changePrice(inputArr[1], -Double.parseDouble(inputArr[2]), userWithSocket);
                            client.write("Stock price has been decreased");
                        } else if (inputArr[0].equals("C") && adminflag) {
                            //System.out.println("H");
                            administrator.changeCount(inputArr[1], Integer.parseInt(inputArr[2]), userWithSocket);
                            client.write("Stock count has been changed");
                            // System.out.println("G");
                        }else{
                            client.write("Invalid Operation");
                        }
                    }

                } catch (IOException e) {
                    System.out.println("Client disconnected");
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                } finally {
                    try {
                        client.closeConnection();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }).start();
        }
    }
}