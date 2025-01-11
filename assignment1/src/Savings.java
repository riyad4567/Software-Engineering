import java.util.List;

public class Savings extends Accounts {
    private double interestRate;
    private double loanRate;
    public void Deposit(Accounts obj,double amount)
    {
        obj.setDeposit(obj.getDeposit()+amount);
        System.out.println(amount+"$ deposited, current balnce "+obj.getDeposit()+"$");
    }
    Savings()
    {
        loanRate=0.1;
        interestRate=0.1;
    }
    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getLoanRate() {
        return loanRate;
    }

    public void setLoanRate(double loanRate) {
        this.loanRate = loanRate;
    }

    void Withdraw(Accounts obj,Bank bOBJ, double amount)
    {

        if(obj.getDeposit()>=amount+1000)
        {
            obj.setDeposit(obj.getDeposit()-amount);
            bOBJ.setFund(bOBJ.getFund()-amount);
            System.out.println("Successfully Withdraw; Current balance is "+obj.getDeposit()+"$");
        }
        else{
            System.out.println("Invalid transaction; Current balance "+obj.getDeposit());
        }

    }
    public void RequestForLoan(Accounts obj,double loan,Bank b)
    {
        if(loan<=10000)
        {
            RequestLoan ob=new RequestLoan(obj,loan);
            //obj.setLoan(loan);
            b.AddRequest(ob);
            System.out.println("Loan request successful, sent for approval");
        }
        else{
            System.out.println("Savings account can get max 10000$ loan");
        }
    }
    public void Deduction(List<Accounts> arr)
    {
        for(int i=0;i< arr.size();i++)
        {
            if(arr.get(i).getType().equalsIgnoreCase("savings"))
            {
                double calc= arr.get(i).getDeposit()+getInterestRate()* (arr.get(i).getDeposit())-getLoanRate()* (arr.get(i).getLoan());
                arr.get(i).setDeposit(calc);
                if(arr.get(i).getDeposit()>=500)
                {
                    arr.get(i).setDeposit(arr.get(i).getDeposit()-500);
                }
                else {
                    arr.get(i).setDeposit(0);
                }
            }

        }
    }
}
