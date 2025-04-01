package exer1;

/**
 * ClassName: Account
 * Package: exer1
 * Description:创建于 2025/4/1 14:04
 *
 * @Author lyl
 * @Version 1.0
 */
public class Account extends Thread {
    private static int balance;

    public void PrintBalance () {
        System.out.println("账户余额为：" + balance);
    }

    @Override
    public void run () {
        for (int i = 0 ; i < 3 ; i++) {
//            synchronized (Account.class) {
//                balance += 1000;
//                PrintBalance();
//            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (Account.class) {
                balance += 1000;
                PrintBalance();
            }
        }
    }
}
