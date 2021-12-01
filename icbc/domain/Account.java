package domain;


public abstract class  Account {
    private long id;
    private String password;
    private String name;
    private String personId;
    private String email;
    private double balance;
    public static long no = 100000;

    public Account() {
        this.password = "88888888";
        this.id = ++no;
    }

    // 有参构造函数
    public Account(String name, String password, String personId, String email, double balance) {
        this();
        this.password = password;

        this.name = name;
        this.personId = personId;
        this.email = email;
        this.balance = balance;
    }

    public Account(long id, String password, String name, String personId, String email, double balance) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.personId = personId;
        this.email = email;
        this.balance = balance;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getPersonId() {
        return personId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String email() {
        return email;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount < 0) {
            System.out.println("输入金额有误，请重新输入！");
            return;
        }
        balance += amount;
    }

    public abstract void  withdraw(double amount) ;

    @Override
    // public boolean equals(Object obj) {
    //     if (this == obj) {
    //         return true;
    //     }
    //     if (this.getClass() == ((Account)obj).getClass()) {
    //         return true;
    //     }
    //     if(id == ((Account)obj).getId()) {
    //         return true;
    //     }
    //     return false;

    // }
    public boolean equals(Object obj) {
       if(this==obj){
           return true;
       }
       if(this.getClass()==((Account)obj).getClass()){
           return true;
       }
       if(id==((Account)obj).getId()){
           return true;
       }
       
       return false;
    }
}
// 写一个账户类(Account),属性:
// id:账户号码 长整数
// password:账户密码
// name:真实姓名
// personId:身份证号码 字符串类型
// email:客户的电子邮箱
// balance:账户余额
// ?
// 方法:
// deposit: 存款方法,参数是double型的金额

// withdraw:取款方法,参数是double型的金额

// 构造方法:
// 有参和无参,有参构造方法用于设置必要的属性