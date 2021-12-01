package domain;

public class CreditAccount extends Account {
    private double ceiling;// 透支额度

    public void setCeiling(double ceiling) {
        this.ceiling = ceiling;
    }

    public double getCeiling() {
        return ceiling;
    }

    public CreditAccount() {
        super();
    }

    public CreditAccount(Long id, String name, String password, String personId, String email, double balance,
            double ceiling) {
        super(id, name, password, personId, email, balance);
        this.ceiling = ceiling;
    }

    public CreditAccount(String name, String password, String personId, String email, double balance,
            double ceiling) {
        super(name, password, personId, email, balance);
        this.ceiling = ceiling;
    }

    @Override
    public void withdraw(double amount) {
        double balance = getBalance();
        if (amount < 0) {
            System.out.println("输入金额有误！");
            return;

        }
        if ((balance + ceiling) < amount) {
            System.out.println("余额和信用值不足");
            return;

        }
        balance -= amount;
        setBalance(balance);
    }

}
