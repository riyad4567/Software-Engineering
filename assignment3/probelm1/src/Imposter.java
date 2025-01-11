public class Imposter extends Decorator{
    public Imposter(Passenger obj)
    {
        super(obj);
    }
    @Override
    public void logIn()
    {
        super.logIn();
        System.out.println("We won’t tell anyone; you are an imposter.");
    }
    @Override
    public void repair()
    {
        super.repair();
        System.out.println("Damaging the spaceship.");
    }
    @Override
    public void work() {
        super.work();
        System.out.println("Trying to kill a crewmate.");
        System.out.println("Successfully killed a crewmate.");
    }

    @Override
    public void logOut() {
        super.logOut();
        System.out.println("See you again Comrade Imposter.");
    }
}
