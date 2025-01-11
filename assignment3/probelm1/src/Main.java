import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Passenger current = null;
        boolean flag=true;
        String str;
        Scanner input = new Scanner(System.in);
        while (flag)
        {
            str=input.next();
            if(str.equals("login"))
            {
                String user= input.next();
                if(user.substring(0,3).equals("imp"))
                {
                    current=new Imposter(new BasicPassenger());
                    current.logIn();
                }
                else if(user.substring(0,4).equals("crew"))
                {
                   current=new BasicPassenger();
                   current.logIn();
                }
            }
            else if(str.equals("work"))
            {
                if(current!=null)
                {
                    current.work();
                }
                else {
                    System.out.println("Invalid Login");
                }

            }
            else if(str.equals("repair"))
            {
                if(current!=null)
                {
                    current.repair();
                }
                else {
                    System.out.println("Invalid Login");
                }
            }
            else if(str.equals("logout"))
            {
                if(current!=null)
                {
                    current.logOut();
                    current=null;
                }
                else {
                    System.out.println("Invalid Login");
                }
            }
            else if(str.equals("close"))
            {
                flag=false;
            }
        }
    }
}