package Class_Advanced.Enum;

/**
 * ClassName: exer1
 * Package: Class_Advanced.Enum
 * Description:创建于 2025/3/28 19:32
 * 使用枚举类实现单例模式
 * @Author lyl
 * @Version 1.0
 */
public class exer1 {
    public static void main (String[] args) {
        System.out.println(GirlFriend.XIAO_LIN);
    }
}

//jdk5.0前
class Bank{
    private Bank(){};
    public final Bank bank=new Bank();
}

//jdk5.0后
enum GirlFriend{
    XIAO_LIN(19);
    private final int age;
    private GirlFriend(int age){
        this.age =age;
    }
}

