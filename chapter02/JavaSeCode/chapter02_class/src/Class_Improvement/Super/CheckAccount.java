package Class_Improvement.Super;

/**
 * ClassName: CheckAccount
 * Package: Class_Improvement.Super
 * Description:创建于 2025/3/23 9:47
 *
 * @Author lyl
 * @Version 1.0
 */
public class CheckAccount extends Account{
    private double overdraft;  //透支余额

    public CheckAccount (int id , double balance , double annualInterestRate , double overdraft) {
        super(id , balance , annualInterestRate);
        this.overdraft = overdraft;
    }

    public double getOverdraft () {
        return overdraft;
    }

    public void setOverdraft (double overdraft) {
        this.overdraft = overdraft;
    }

    //重写取钱的方法
    public void withdraw(double amount){
        if(getBalance()>=amount){
            //setBalance(getBalance()-amount);
            super.withdraw(amount);
        }
        else if(getBalance()+overdraft>=amount){
            //错误的：第一步取钱后getBalance()==0
//            super.withdraw(getBalance());
//            overdraft-=(amount-getBalance());

            //正确的：
            overdraft-=(amount-getBalance());
            super.withdraw(getBalance());
        }
        else
            System.out.println("透支余额不足");
    }
}
