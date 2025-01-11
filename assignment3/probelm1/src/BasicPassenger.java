interface Passenger{
    void
    logIn();
    void repair();
    void work();
    void logOut();
}


public class BasicPassenger implements Passenger {
    public void logIn()
    {
        System.out.println("Welcome Crewmate!");
    }
    public void repair()
    {
        System.out.println("Repairing the spaceship.");
    }
    public void work()
    {
        System.out.println("Doing research");
    }
    public void logOut()
    {
        System.out.println("Bye Bye crewmate");
    }
}
