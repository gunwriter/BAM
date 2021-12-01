import domain.Account;
import domain.CreditAccount;
import domain.SavingAccount;

public class TestObject {
    public static void main(String[] args) {
        Object o=new SavingAccount(100001L,"","","","",0);
        Object o1=new CreditAccount(100001L,"","","","",0,0);
        System.out.println(o.equals(o1));
    }
}
