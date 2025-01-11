import java.util.List;

public class HelpClass {
    Savings saOB=new Savings();
    Student stuOB=new Student();
    FixedDeposit fOB=new FixedDeposit();
    public Accounts AccountCheck(List<Accounts>arr, String name)
    {
        for(int i=0;i< arr.size();i++)
        {
            if(arr.get(i).getName().equalsIgnoreCase(name))
            {
                return arr.get(i);
            }
        }
        return null;
    }
    public Accounts Create(List<Accounts>ObjArr, String []array,Accounts ob)
    {
        // System.out.println(array[1]);
        if(AccountCheck(ObjArr,array[1])!=null)
        {
            System.out.println("An account has been created with this name");
            return null;
        }
        else {
            double amount = Double.parseDouble(array[3]);
            ob=ob.CreateAccount(array[1], array[2], amount);
            ob.setCurrent(ob);
            //System.out.println(ob.getCurrent());
            System.out.println(array[2]+" account for "+ob.getName()+" Created; initial balance "+ob.getDeposit()+"$");
            return ob;
        }
    }
    public void DepositSet(String []array,Accounts ob)
    {
        double deposit=Double.parseDouble(array[1]);
        ob=ob.getCurrent();
        if(ob==null)
        {
            System.out.println("Invalid Login");
        }
        else{
              if(ob.getType().equalsIgnoreCase("FixedDeposit"))
              {
                  fOB.Deposit(ob,deposit);
              }
              else if(ob.getType().equalsIgnoreCase("Savings")){
                  saOB.Deposit(ob,deposit);
              }
              else{
                  //System.out.println("Hello");
                  stuOB.Deposit(ob,deposit);
              }
        }
    }
    public void Withdraw(String []array,Accounts ob,Bank bankOBJ)
    {
        double withdraw=Double.parseDouble(array[1]);
        ob=ob.getCurrent();
        if(ob==null)
        {
            System.out.println("Invalid Login");
        }
        else if(ob.getType().equalsIgnoreCase("Student"))
        {
            stuOB.Withdraw(ob,bankOBJ,withdraw);
        }
        else if(ob.getType().equalsIgnoreCase("Savings"))
        {
            saOB.Withdraw(ob,bankOBJ,withdraw);
        }
        else{
            fOB.Withdraw(ob,bankOBJ,withdraw);
        }
    }
    public void Request(String []array,Accounts ob,Bank bankOBJ)
    {
        double loan=Double.parseDouble(array[1]);
        ob=ob.getCurrent();
        if(ob==null)
        {
            System.out.println("Invalid Login");
        }
        else if(ob.getType().equalsIgnoreCase("Student"))
        {
            stuOB.RequestForLoan(ob,loan, bankOBJ);
        }
        else if(ob.getType().equalsIgnoreCase("Savings"))
        {
            saOB.RequestForLoan(ob,loan, bankOBJ);
        }
        else{
            fOB.RequestForLoan(ob,loan, bankOBJ);
        }
    }
    public void LookUpAccounts(List<Accounts>accountsArr,String []array,String current,List<Employees>empArr,Accounts ob )
    {
           if (Instance(current,empArr)!=null) {
               ob = AccountCheck(accountsArr, array[1]);
               if (ob == null) {
                   ob = new Accounts();
                   System.out.println("No Account with this name");
               }
               else {
                   Employees obj=Instance(current,empArr);
                   obj.LookUp(ob);
                   }
               }

           else{
           System.out.println("You don’t have permission for this operation");
           }

    }
    public void ApproveLoan(String type,List<Employees>empArr,Bank bankOBJ)
    {
        if(Instance(type,empArr)==null)
        {
            System.out.println("You don't have permission for this operation");
        }
        else{
            Employees obj=Instance(type,empArr);
            obj.Approved(bankOBJ);
        }
//
    }
    public String LogIn(List<Accounts>ObjArr,String name,List<Employees>empArr, List<RequestLoan>requestList,Accounts ob)
    {
        if(Instance(name,empArr)!=null)
        {
            System.out.print(name+" activated; ");
            if(!requestList.isEmpty())
            {
                System.out.println("there are loan approvals pending");
            }
            else{
                System.out.println();
            }
            return name;
        }
        else {
            ob=AccountCheck(ObjArr,name);
            if(ob!=null)
            {
                System.out.println("Welcome back, "+ob.getName());
                ob.setCurrent(ob);
                return "user";
            }
            else{
                System.out.println("Invalid login");
                return " ";
            }
        }
    }
    public void CloseCurrent(String current,Accounts ob)
    {
        if(current.equalsIgnoreCase("user"))
        {
            System.out.println("Transaction for "+ob.getCurrent().getName()+" closed");
           // ob.setCurrent(null);
        }
        else{
            System.out.println("Operations for "+current+" closed");
        }
    }
    public Employees Instance(String name,List<Employees>empArr)
    {
        for(int i=0;i<empArr.size();i++)
        {
            if(empArr.get(i).getName().equalsIgnoreCase(name))
            {
                return empArr.get(i);
            }
        }
        return null;
    }

}
