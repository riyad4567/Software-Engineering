import java.util.List;

public interface Employees {
    void LookUp(Accounts obj);

    String getName();
    void Approved(Bank obj);
    void ChangeRate(Accounts obj, String type, double rate);
    void SeeFund(Bank obj);


}

class Manager implements Employees {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    Manager(String name) {
        this.name = name;
    }

    Student stuOBJ = new Student();
    Savings saOBJ = new Savings();
    FixedDeposit fOBJ = new FixedDeposit();

    public void Approved(Bank obj) {
        List<RequestLoan> list = obj.getRequestList();
        for (RequestLoan object : list) {
            Accounts ob = object.getObj();
            ob.setDeposit(ob.getDeposit() + object.getLoan());
            ob.setLoan(object.getLoan());
            System.out.println("Loan for " + ob.getName() + " has approved");
        }
        obj.EmptyRequestList();
    }

    public void ChangeRate(Accounts obj, String type, double rate) {
        if (type.equalsIgnoreCase("Student")) {
            stuOBJ.setInterestRate(rate);
            System.out.println("Interest Rate has benn changed");
        } else if (type.equalsIgnoreCase("Savings")) {
            saOBJ.setInterestRate(rate);
            System.out.println("Interest Rate has benn changed");
        } else {
            fOBJ.setInterestRate(rate);
            System.out.println("Interest Rate has benn changed");
        }
    }

    public void LookUp(Accounts obj) {

        System.out.println(obj.getName() + "'s current balance " + obj.getDeposit() + "$");

    }

    public void SeeFund(Bank obj) {
        System.out.println("Internal Fund is: " + obj.getFund() + "$");
    }

}


class Officer implements Employees {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    Officer(String name) {
        this.name = name;
    }

    public void Approved(Bank obj) {
        List<RequestLoan> list = obj.getRequestList();
        for (RequestLoan object : list) {
            Accounts ob = object.getObj();
            ob.setDeposit(ob.getDeposit() + object.getLoan());
            ob.setLoan(object.getLoan());
            System.out.println("Loan for " + ob.getName() + " has approved");
        }
        obj.EmptyRequestList();
    }

    public void LookUp(Accounts obj) {

        System.out.println(obj.getName() + "'s current balance " + obj.getDeposit() + "$");

    }
    public void ChangeRate(Accounts obj, String type, double rate) {
        System.out.println("You don't have permission for this operation");
    }
    public void SeeFund(Bank obj)
    {
        System.out.println("You don't have permission for this operation");
    }
}

class Cashier implements Employees {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    Cashier(String name) {
        this.name = name;
    }

    public void LookUp(Accounts obj) {

        System.out.println(obj.getName() + "'s current balance " + obj.getDeposit() + "$");

    }
    public void Approved(Bank obj) {
        System.out.println("You don't have permission for this operation");
    }
    public void ChangeRate(Accounts obj, String type, double rate) {
        System.out.println("You don't have permission for this operation");
    }
    public void SeeFund(Bank obj)
    {
        System.out.println("You don't have permission for this operation");
    }
}