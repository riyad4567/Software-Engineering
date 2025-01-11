import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank bankOBJ = new Bank();
        Accounts ob = new Accounts();
        Savings saOB = new Savings();
        Student stuOB = new Student();
        FixedDeposit fOB = new FixedDeposit();
        HelpClass helpObj = new HelpClass();
        Scanner scan = new Scanner(System.in);
        // int count=0;
        String current = "";
        String input = "";

        while (!input.equalsIgnoreCase("Exit")) {
            input = scan.nextLine();
            String[] array = input.split(" ");
            String first = array[0];
            List<Accounts> accountsArr = bankOBJ.getAccList();
            List<Employees> employeeArr = bankOBJ.getEmpList();

            switch (first) {
                case "Create": {
                    ob = helpObj.Create(accountsArr, array,ob);
                    if (ob != null) {
                        current = "user";
                        //accountsArr.add(ob);
                        bankOBJ.AddAccount(ob);
                        accountsArr = bankOBJ.getAccList();
                    }
                    break;
                }
                case "Deposit": {
                    if(current.equalsIgnoreCase("user"))
                    {
                        helpObj.DepositSet(array,ob);
                    }
                    else{
                        System.out.println("Invalid Operation");
                    }
                    break;
                }
                case "Withdraw": {
                    if(current.equalsIgnoreCase("user"))
                    {
                        helpObj.Withdraw(array,ob,bankOBJ);
                    }
                    else{
                        System.out.println("Invalid Operation");
                    }
                    break;
                }
                case "Query": {
                    ob = ob.getCurrent();
                    if (ob == null) {
                        System.out.println("Invalid operation");
                    } else {
                        ob.QueryDeposit(ob);
                    }
                    break;
                }
                case "Request": {
                    if(current.equalsIgnoreCase("user"))
                    {
                        helpObj.Request(array,ob,bankOBJ);
                    }
                    else{
                        System.out.println("Invalid Operation");
                    }
                    break;

                }
                case "INC": {
                    bankOBJ.Increment();
                    saOB.Deduction(accountsArr);
                    stuOB.Deduction(accountsArr);
                    fOB.Deduction(accountsArr);
                    break;
                }
                case "Lookup": {
                    helpObj.LookUpAccounts(accountsArr, array,current,employeeArr,ob);
                    break;
                }
                case "See":{
                     if(helpObj.Instance(current,employeeArr)==null)
                     {
                         System.out.println("You don't have permission for this operation");
                     }
                     else{
                         Employees empOBJ=helpObj.Instance(current,employeeArr);
                         empOBJ.SeeFund(bankOBJ);
                     }

                    break;
                }
                case "Change":{
                    if(helpObj.Instance(current,employeeArr)==null)
                    {
                        System.out.println("You don't have permission for this operation");
                    }
                    else{
                        Employees empOBJ=helpObj.Instance(current,employeeArr);
                        double rate=Double.parseDouble(array[2]);
                        empOBJ.ChangeRate(ob,array[1],rate);
                    }
                    break;
                }
                case "Approve":{
                   helpObj.ApproveLoan(current,employeeArr,bankOBJ);
                   break;
                }
                case "Open":{
                    List<RequestLoan>requestList=bankOBJ.getRequestList();
                  current=helpObj.LogIn(accountsArr,array[1],employeeArr,requestList,ob);
                  break;
                }
                case "Close":
                {
                   helpObj.CloseCurrent(current,ob);
                   current="";
                   break;
                }
                default:
                    System.out.println("Invalid Operation");
            }
        }
    }
}
