package Class_Improvement.Super;

/**
 * ClassName: AcountTest
 * Package: Class_Improvement.Super
 * Description:创建于 2025/3/23 9:40
 *
 * @Author lyl
 * @Version 1.0
 */
public class AccountTest {
    public static void main (String[] args) {
//        Account acco=new Account(1122,20000,0.045);
//        acco.withdraw(30000);
//        System.out.println("您的账户余额为："+ acco.getBalance());
//        acco.withdraw(2500);
//        acco.deposit(3000);
//        System.out.println("您的账户余额为："+ acco.getBalance());
//        System.out.println("月利率为：" + acco.getMonthlyInterestRate());

        CheckAccount ca=new CheckAccount(1122,20000,0.045,5000);
        ca.withdraw(5000);
        System.out.println(ca.getBalance());
        System.out.println(ca.getOverdraft());
        ca.withdraw(18000);
        System.out.println(ca.getBalance());
        System.out.println(ca.getOverdraft());
        ca.withdraw(3000);
        System.out.println(ca.getBalance());
        System.out.println(ca.getOverdraft());

    }
}
