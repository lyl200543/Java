package Class_Improvement.Super;

/**
 * ClassName: Accout
 * Package: Class_Improvement.Super
 * Description:创建于 2025/3/23 9:29
 *
 * @Author lyl
 * @Version 1.0
 */

public class Account {
    private int id;
    private double balance;  //账户余额
    private double annualInterestRate;  //年利率

    public Account (int id , double balance , double annualInterestRate) {
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
    }

    public int getId () {
        return id;
    }

    public void setId (int id) {
        this.id = id;
    }

    public double getBalance () {
        return balance;
    }

    public void setBalance (double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate () {
        return annualInterestRate;
    }

    public void setAnnualInterestRate (double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public double getMonthlyInterestRate(){
        return annualInterestRate /12;
    }

    public void withdraw(double amount){  //取钱
        if(balance>=amount){
            balance-=amount;
        }
        else
            System.out.println("余额不足");
    }

    public void deposit(double amount){   //存钱
        if(amount>0)
            balance+=amount;
    }
}
