package domain;

public final class Bank {
    Account[] accounts = new Account[10];// 当前所有的账户对象的集合,存放在数组中

    public int count = 0;// 当前账户数量
    // 用户开户,需要的参数:id,密码,密码确认,姓名,身份证号码,邮箱,账户类型(int),返回新创建的Account对象

    // 懒汉式，没调用之前就已经创建好了对象
    // public static final Bank bank = new Bank();

    // public static Bank getBank() {

    // return bank;

    // }

    // 饿汉式，用的时候再造
    public static Bank bank = null;

    public static final Bank getBank() {

        if (bank == null) {
            bank = new Bank();
        }
        return bank;
    }

    public Account openAccount(long id, String password, String confirm, String name, String personId, String email,
            int accountType) {
        if (!password.equals(confirm)) {
            System.out.println("两次密码不一致，请重新输入！");
            return null;
        }

        Account acc = null;
        if (accountType == 1) {// 1refers to SavingAccount

            acc = new SavingAccount(name, password, personId, email, 0);

        } else if (accountType == 2) {
            acc = new CreditAccount(name, password, personId, email, 0, 0);
        }
        accounts[count++] = acc;
        return acc;
    }

    // 用户登录,参数:id,密码 返回Account对象,提示 用s1.equals(s2)判断s1和s2两个字符串内容是否相等
    public Account login(Long id, String password) {
        Account acc = getAccount(id);
        if (acc != null && acc.getPassword().equals(password)) {
            return acc;
        }
        System.out.println("密码有误，请重新输入！");
        return null;
    }

    // 用户存款,参数:id,存款数额,返回修改过的Account对象
    public Account deposit(Long id, double amount) {
        Account acc = getAccount(id);
        acc.deposit(amount);
        return acc;
    }

    // 用户取款,参数:id,取款数额,返回修改过的Account对象
    public Account withdraw(Long id, double amount) {
        Account acc = getAccount(id);
        acc.withdraw(amount);
        return acc;
    }

    public Account setCeiling(Long id, double ceiling) {
        Account acc = getAccount(id);
        if (!(acc instanceof CreditAccount)) {
            System.out.println("此账户非信用账户，无法设置信用额！");
            return null;
        }
        // CreditAccount creditAccount=(CreditAccount)acc;
        // creditAccount.setCeiling(ceiling);
        ((CreditAccount) acc).setCeiling(ceiling);
        return acc;
    }

    // 统计银行所有账户余额总数
    public double calcTotalBalance() {
        double sum = 0;

        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] != null) {
                sum += accounts[i].getBalance();
            }
        }
        return sum;
    }

    public double calcTotalCeiling() {
        double sum = 0;
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] != null && accounts[i] instanceof CreditAccount) {
                sum += ((CreditAccount) accounts[i]).getCeiling();
            }
        }
        return sum;
    }

    public Account getAccount(Long id) {
        for (int i = 0; i < accounts.length; i++) {
            Account acc = accounts[i];
            if (acc != null && acc.getId().equals(id)) {
                return acc;
            }

        }
        return null;
    }

    public Account requestLoan(Long id, double amount) {
        Account acc = getAccount(id);
        if (acc != null && acc instanceof Loan) {
            ((Loan) acc).requestLoan(amount);
            return acc;
        }
        return null;
    }

   

    public Account payLoan(Long id, double amount) {
        Account acc = getAccount(id);
        if (acc != null && (acc instanceof Loan)) {
            ((Loan) acc).payLoan(amount);
            return acc;
        }
        return null;
    }

    public double calcTotalLoan() {
        double sum = 0;
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] != null && accounts[i] instanceof Loan) {
                sum += ((Loan) accounts[i]).getLoan();
            }
        }
        return sum;
    }
}