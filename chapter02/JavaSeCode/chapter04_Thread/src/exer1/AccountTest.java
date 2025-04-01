package exer1;

/**
 * ClassName: AccountTest
 * Package: exer1
 * Description:创建于 2025/4/1 14:24
 *
 * @Author lyl
 * @Version 1.0
 */
public class AccountTest {
    public static void main (String[] args) {
        Account1 account1 = new Account1();
        Costumer c1 = new Costumer(account1);
        Costumer c2 = new Costumer(account1);
        c1.setName("甲");
        c2.setName("乙");

        c1.start();
        c2.start();
    }
}

class Account1 {
    private double balance;

    public synchronized void deposit (double atm) {
        if (atm > 0)
            balance += atm;
        System.out.println(Thread.currentThread().getName() + "存款1000元，余额为：" + balance);

    }


}

class Costumer extends Thread {
    Account1 account;

    public Costumer (Account1 account) {
        this.account = account;
    }

    @Override
    public void run () {
        for (int i = 0 ; i < 3 ; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            account.deposit(1000);
        }
    }
}