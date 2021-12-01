package domain;



/**
 * Loan
 */
public interface Loan {
    //贷款方法
public void requestLoan(double amount);
    //还贷
    void payLoan(double amount);
    //获取贷款额
    double getLoan();
}