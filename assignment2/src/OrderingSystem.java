import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderingSystem {
    List<Builder> listBuilder = new ArrayList<Builder>();
    Scanner input = new Scanner(System.in);
    public void MenuShow() {
        System.out.println("Type numbers for your favourite shake");
        System.out.println("1. Chocolate Shake");
        System.out.println("2. Coffee Shake");
        System.out.println("3. Strawberry Shake");
        System.out.println("4. Vanilla Shake");
        System.out.println("5. Zero Shake");
        System.out.println("6. Next Step");
    }

    public void GradientShow() {
        System.out.println("Type a character between 'a' and 'd'");
        System.out.println("a. Almond Milk (For Lactose Free Shake)");
        System.out.println("b. Candy");
        System.out.println("c. Cookies");
        System.out.println("d. Next Step");
    }

    public void CallMenu(Director direct) {
        MenuShow();
        boolean next = false;
        while (!next) {
            System.out.printf("Choose Item No: ");
            char shake = input.next().charAt(0);
            Builder build = new Builder();
            switch (shake) {
                case '1': {
                    direct.ChocolateShake(build);
                    listBuilder.add(build);
                    break;
                }
                case '2': {
                    direct.CoffeeShake(build);
                    listBuilder.add(build);
                    break;
                }
                case '3': {
                    direct.StrawberryShake(build);
                    listBuilder.add(build);
                    break;
                }
                case '4': {
                    direct.VanillaShake(build);
                    listBuilder.add(build);
                    break;
                }
                case '5': {
                    direct.ZeroShake(build);
                    listBuilder.add(build);
                    break;
                }
                case '6': {
                    next = true;
                    break;
                }
                default: {
                    System.out.println("Invalid Operation");
                }
            }
        }
    }

    public void CallIngredients(Director direct) {
        GradientShow();
        boolean next = false;
        while (!next) {
            System.out.printf("Choose Ingredients No: ");
            char gradients = input.next().charAt(0);
            switch (gradients) {
                case 'a': {
                    for (int i = 0; i < listBuilder.size(); i++) {
                        direct.AddIngredients(listBuilder.get(i), "Almond Milk", "60");
                    }
                    break;
                }
                case 'b': {
                    for (int i = 0; i < listBuilder.size(); i++) {
                        direct.AddIngredients(listBuilder.get(i), "Candy", "50");
                    }
                    break;
                }
                case 'c': {
                    for (int i = 0; i < listBuilder.size(); i++) {
                        direct.AddIngredients(listBuilder.get(i), "Cookies", "40");
                    }
                    break;
                }
                case 'd': {
                    next = true;
                    break;
                }

                default: {
                    System.out.println("Invalid Operation");
                }
            }
        }
    }

    public void PrintPriceList() {
        System.out.println("Price List----------");
        double totalprice = 0;
        for (int i = 0; i < listBuilder.size(); i++) {
            Shake obj = listBuilder.get(i).getObject();
            totalprice += Double.parseDouble(obj.getBasePrice());
            System.out.println(obj.getType() + "--------" + "Price: " + obj.getBasePrice());
        }
        Shake shake = listBuilder.get(0).getObject();
        for (int j = 0; j < shake.getAddIngredients().size(); j++) {
            System.out.println(listBuilder.size()*Double.parseDouble(shake.getPriceList().get(j)) + " Taka added for  "+shake.getAddIngredients().get(j));
            totalprice += listBuilder.size() * Double.parseDouble(shake.getPriceList().get(j));
        }
        //System.out.println();
        System.out.println("Total Prices Of The Order: " + totalprice);
    }

    public void PrintIngredients() {
        for (int i = 0; i < listBuilder.size(); i++) {
            Shake obj = listBuilder.get(i).getObject();
            System.out.println("Shake: " + obj.getType());
            System.out.println("Base Ingredients are--------");
            for (int k = 0; k < obj.getBaseIngredients().size(); k++) {
                System.out.println((k + 1) + " : " + obj.getBaseIngredients().get(k));
            }
        }
        System.out.println("Added Ingredients are--------");
        Shake shake = listBuilder.get(0).getObject();
        for (int j = 0; j < shake.getAddIngredients().size(); j++) {
            System.out.println((j + 1) + " : " + shake.getAddIngredients().get(j));
        }
    }

    public void Print() {
        System.out.printf("Type '1' for confirm order: ");
        String check=input.next();
        if(check.equals("1"))
        {
            PrintIngredients();
            PrintPriceList();
           // System.out.println("Type 'e' to close the order");
        }
        else {
            System.out.println("Invalid Operation");
        }
    }
}
