package Class_Advanced.Singleton;

/**
 * ClassName: BankTest
 * Package: Class_Advanced.Singleton
 * Description:创建于 2025/3/24 10:56
 *
 * @Author lyl
 * @Version 1.0
 */

//饿汉式：
public class BankTest {
    public static void main (String[] args) {
        Bank b1=Bank.getInstance();
        Bank b2=Bank.getInstance();
        System.out.println(b1==b2);   //true
    }

}

class Bank{
    //1.类的构造器私有化
    private Bank(){

    }

    //2.在类的内部创建当前类的实例（相当于属性）
    //4.此属性也必须声明为static（才能被静态方法调用）
    private static Bank instance=new Bank();

    //3.使用getXxx()方法获取当前类的实例，必须声明为static
    public static Bank getInstance(){
        return instance;
    }
}
