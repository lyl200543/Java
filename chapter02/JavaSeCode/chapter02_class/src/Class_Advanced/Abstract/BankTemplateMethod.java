package Class_Advanced.Abstract;

/**
 * ClassName: BankTemplateMethod
 * Package: Class_Advanced.Abstract
 * Description:创建于 2025/3/26 8:25
 *
 * @Author lyl
 * @Version 1.0
 */
public class BankTemplateMethod {
    public static void main (String[] args) {
        BankTemplate b1=new drawMoney();
        b1.process();

        System.out.println();
        BankTemplate b2=new manageMoney();
        b2.process();
    }
}

abstract class BankTemplate{
    public void takeNumber(){
        System.out.println("取号排队");
    }
    public void evaluate(){
        System.out.println("反馈评分");
    }
    public abstract void transact();

    public void process(){
        takeNumber();
        transact();
        evaluate();
    }
}

class drawMoney extends BankTemplate {
    public void transact(){
        System.out.println("取钱");
    }
}

class manageMoney extends BankTemplate {
    public void transact(){
        System.out.println("理财");
    }
}