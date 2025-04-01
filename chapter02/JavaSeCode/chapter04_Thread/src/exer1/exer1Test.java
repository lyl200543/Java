package exer1;

/**
 * ClassName: exer1Test
 * Package: exer1
 * Description:创建于 2025/4/1 14:03
 * 银行有一个账户
 * 有两个储户分别向同一个账户存3000元，每次存1000，存3次
 * 每次存完打印账户余额
 * 问题:该程序是否有安全问题，如果有，如何解决?
 *
 * @Author lyl
 * @Version 1.0
 */
public class exer1Test {
    public static void main (String[] args) {
        Account a1 = new Account();
        Account a2 = new Account();
        a1.start();
        a2.start();
    }
}
