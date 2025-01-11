public class Decorator implements Passenger{
    private Passenger obj;
    public Decorator(Passenger obj)
    {
        this.obj=obj;
    }
    public void work()
    {
        this.obj.work();
    }
    public void repair()
    {
        this.obj.logIn();
    }
    public void logIn()
    {
        this.obj.logIn();
    }
    public void logOut()
    {
        this.obj.logOut();
    }
}
