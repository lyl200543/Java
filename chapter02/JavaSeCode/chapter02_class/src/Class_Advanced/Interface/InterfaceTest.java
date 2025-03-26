package Class_Advanced.Interface;

/**
 * ClassName: InterfaceTest
 * Package: Class_Advanced.Interface
 * Description:创建于 2025/3/26 13:38
 *
 * @Author lyl
 * @Version 1.0
 */
public class InterfaceTest {
    public static void main (String[] args) {
        Bullet b=new Bullet();
        b.fly() ;
        b.attack() ;
        System.out.println(flyable.MIN_SPEED);

        //多继承
        Test t =new Test();
        t.func1();

        //接口的多态
        flyable f =new Bullet();
        f.fly();
//        f.attack();
    }
}

interface flyable{ //接口
    //属性（public static final修饰）
    public static final int MIN_SPEED=0;

    //可以省略public static final
    int MAX_SPEED=7900;

    //方法（public abstract修饰）,可以省略
    public abstract void fly();

}

interface attackable{
    public abstract void attack();
}

class Bullet implements flyable,attackable{
    @Override
    public void attack () {
        System.out.println("子弹射穿身体");
    }

    @Override
    public void fly () {
        System.out.println("让子弹飞");
    }
}

//接口的多继承测试
interface AA{
    void func1();
}

interface BB{
    void func2();
}

interface CC extends AA,BB{

}

class Test implements CC{
    @Override
    public void func1 () {

    }

    @Override
    public void func2 () {

    }
}
