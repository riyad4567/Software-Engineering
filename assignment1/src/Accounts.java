import java.util.List;

public class Accounts{
    private String name;
    private String type;
    private double deposit;
    private double loan;

    private Accounts current;

    public Accounts getCurrent() {
        return current;
    }

    public void setCurrent(Accounts current) {
        this.current = current;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getLoan() {
        return loan;
    }

    public void setLoan(double loan) {
        this.loan = loan;
    }

    public double getDeposit() {
        return deposit;
    }


    Accounts(String name,String type,double deposit)
    {
        this.name=name;
        this.type=type;
        this.deposit=deposit;
        this.loan=0;
    }

    public Accounts CreateAccount(String name,String type,double deposit)
    {
            Accounts obj=new Accounts(name,type,deposit);
            return obj;
    }

    void QueryDeposit(Accounts obj)
    {
        System.out.println("Current Balance "+obj.getDeposit()+"$, Loan Balance "+obj.getLoan()+"$");
    }
    Accounts(){};

}

