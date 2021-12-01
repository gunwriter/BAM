package domain;

public class LoanSavingAccount extends SavingAccount implements Loan{


double loan;

public LoanSavingAccount() {
    super();
}
    public LoanSavingAccount(long id, String password, String name, String personId, String email, double balance,double loan) {
        // 如果不写则调用父类的默认构造函数 super();
        // super 调用父类构造函数
        super(id, password, name, personId, email, balance);
        this.loan=loan;
    }

    public LoanSavingAccount(String name, String password, String personId, String email, double balance,double loan) {
        super(name, password, personId, email, balance);
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
       if(balance<=amount){
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
    // public void setLoan(double loan){
    //     this.loan=loan;
    // }
    // public double getLoan(){
    //     return loan;
    // }
    
}
