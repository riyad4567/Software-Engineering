
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        boolean exit = false;
        boolean flag=false;
        String choice;
        char ch;
        while (!exit) {
            Scanner input = new Scanner(System.in);
            System.out.println("Press 'o' for new Order, 'c' for exit program ,'e' for close order");
            System.out.printf("Input: ");
            choice = input.next();
            System.out.println();
            ch=choice.charAt(0);
            if(choice.length()==1) {
                switch (ch) {
                    case 'o': {
                        OrderingSystem obj = new OrderingSystem();
                        Director direct = new Director();
                        obj.CallMenu(direct);
                        obj.CallIngredients(direct);
                        obj.Print();
                        flag=true;
                        break;
                    }
                    case 'e': {
                        if(flag)
                        {
                            flag=false;
                            System.out.println("This order has been closed");
                        }
                        else{
                            System.out.println("You should order at least 1 item ");
                        }
                        break;
                    }
                    case 'c': {
                        System.out.println("Program exit....");
                        exit = true;
                        break;
                    }
                    default: {
                        System.out.println("Invalid Operation");
                    }
                }
            }
            else{
                System.out.println("Invalid Operation");
            }
        }
    }
}