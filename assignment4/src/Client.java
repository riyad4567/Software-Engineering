import java.io.IOException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        SocketWrapper server = new SocketWrapper("127.0.0.1", 3000);
        //write thread
        new Thread(() -> {
            try {
                while (true) {
                    String[] inputArr = input.nextLine().split(" ");
                    server.write(inputArr);
                }

            } catch (IOException e) {
                System.out.println("disconnected");
            } finally {
                try {
                    server.closeConnection();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

        }).start();


        //read thread
        new Thread(() -> {
            try {
                while (true) {
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
