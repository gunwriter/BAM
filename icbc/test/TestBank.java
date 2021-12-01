
package test;

import domain.Account;
import domain.Bank;

public class TestBank {
  public static void main(String[] args) {
    // Bank bank=new Bank();
    // Account acc=bank.openAccount (1,"2", "2",
    // "gengxin","3212821002","gx@126.com",2);
    // //Account acc2=bank.openAccount (1,"877289", "877289",
    // "chrisgeng","3212821002","gx@126.com",1);

    // acc=bank.login(10001L,"2");
    // //acc2=bank.login(1001L,"877289");
    // // bank.deposit(10001L,2000);
    // bank.withdraw(10001L,100);
    // bank.setCeiling(10001L,100000);
    // bank.withdraw(10001L,20000);
    // System.out.println(acc.getBalance());
    // // System.out.println(acc2.getId());

    Bank bank = Bank.getBank();
    Account acc = bank.openAccount(1, "12345", "12345", "gx", "personId", "email", 2);
    acc = bank.login(100001L, "12345");
    bank.deposit(100001L, 2000);
    System.out.println(acc.getBalance());
  }
}
