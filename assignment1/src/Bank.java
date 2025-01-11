import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Bank {
    private  double fund;
    private int time;
    private List<RequestLoan> arr;
    private List<Accounts>accList;
    private List<Employees>empList;

    public List<RequestLoan> getArr() {
        return arr;
    }

    public List<Accounts> getAccList() {
        return accList;
    }
    public void AddAccount(Accounts obj)
    {
        accList.add(obj);
    }
    public List<Employees> getEmpList() {
        return empList;
    }

    public void setFund(double fund) {
        this.fund = fund;
    }

    public double getFund() {
        return fund;
    }

    Bank()
    {
        fund=1000000;
        time=0;
        accList=new ArrayList<Accounts>();
        empList=new ArrayList<Employees>();
        arr=new ArrayList<RequestLoan>();
        CreateEmployees();

    }
    public void CreateEmployees()
    {
        Manager MD=new Manager("MD");
        empList.add(MD);
        Officer S1=new Officer("S1");
        Officer S2=new Officer("S2");
        empList.add(S1);
        empList.add(S2);
        Cashier []cashArr=new Cashier[5];
        for(int i=1;i<=5;i++)
        {
            String form="C"+i;
            cashArr[i-1]=new Cashier(form);
            empList.add(cashArr[i-1]);

        }
    }

    public void EmptyRequestList()
    {
        arr.clear();
    }
    public List<RequestLoan> getRequestList()
    {
        return arr;
    }
    public void AddRequest(RequestLoan obj)
    {
        arr.add(obj);
        //fund-=obj.getLoan();
    }
    public int getTime() {
        return time;
    }
    public void setTime(int time) {
        this.time = time;
    }
    public void Increment()
    {
        time++;
        System.out.println("1 year passed");
    }
}
class RequestLoan {
    private double loan;
    private Accounts obj;

    public double getLoan() {
        return loan;
    }

    public Accounts getObj() {
        return obj;
    }

    RequestLoan(Accounts obj, double loan)
    {
        this.obj=obj;
        this.loan=loan;
    }
}
