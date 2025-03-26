package Class_Advanced.Static;

/**
 * ClassName: interview
 * Package: Class_Advanced.Static
 * Description:创建于 2025/3/23 20:40
 *
 * @Author lyl
 * @Version 1.0
 */

//静态变量和方法只和类有关，指向null的对象调用变量和方法不报错
public class interview {
    public static void main (String[] args) {
        Order order =null;
        order.func();
        System.out.println(order.count);
    }
}

class Order{
    public static int count=1;
    public static void func(){
        System.out.println("hello");
    }
}
