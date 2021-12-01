package domain;

public class SavingAccount extends Account {
    public SavingAccount() {
        super();
    }

    public SavingAccount(long id, String password, String name, String personId, String email, double balance) {
        // 如果不写则调用父类的默认构造函数 super();
        // super 调用父类构造函数
        super(id, password, name, personId, email, balance);
    }

    public SavingAccount(String name, String password, String personId, String email, double balance) {
        super(name, password, personId, email, balance);
    }

    @Override
    public void withdraw(double amount) {
        double balance = getBalance();

        if (amount < 0) {
            System.out.println("输入金额有误，请重新输入！");
            return;
        }
        if (amount < balance) {
            System.out.println("您当前余额为：" + "余额不足！");
            return;

        }
        balance -= amount;
        setBalance(balance);
    }

}
