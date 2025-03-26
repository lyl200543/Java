package Class_Advanced.Static;

/**
 * ClassName: Acount
 * Package: Class_Advanced.Static
 * Description:创建于 2025/3/23 20:22
 *
 * @Author lyl
 * @Version 1.0
 */
public class Acount {
    private int id;
    private String password;
    private double balance;
    private static double interestRate=0.045;
    private static double minBalance=100;
    public Acount (String password ,double balance ){
        id=(int)(Math.random()*(9000)+1000);
        this.password =password ;
        this.balance =balance ;
    }

    @Override
    public String toString () {
        return "Acount{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                '}';
    }
}
