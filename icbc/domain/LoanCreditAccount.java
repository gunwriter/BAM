package domain;

public class LoanCreditAccount extends CreditAccount implements Loan{
private double loan;

public LoanCreditAccount() {
    super();
}

public LoanCreditAccount(String name, String password, String personId, String email, double balance,
        double ceiling,double loan) {
    super(name, password, personId, email, balance, loan);
    
    this.loan=loan;
}

public LoanCreditAccount(Long id, String name, String password, String personId, String email, double balance,
        double ceiling,double loan) {
    super(id, name, password, personId, email, balance, loan);
 
    this.loan=loan;
}
    @Override
    public void requestLoan(double amount) {
        if(amount<=0){
            System.out.println("贷款额输入无效！");
            return;
        }
        loan+=amount;
     
     }

    @Override
    public void payLoan(double amount) {
        double balance=getBalance();
       if(amount<=0){
           System.out.println("输入的还款额无效！");
           return;
       }
       if(balance+getCeiling()<=amount){
           System.out.println("输入的还款额大于账户余额！");
           return;
       }
       this.loan-=amount;
       balance-=amount;
       setBalance(balance);
    }

    @Override
    public double getLoan() {
     
    return loan;
    }
    
}
