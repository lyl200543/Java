package Class_Advanced.Inner;

/**
 * ClassName: exer
 * Package: Class_Advanced.Inner
 * Description:创建于 2025/3/26 20:39
 * 编写一个匿名内部类，它继承0bject
 * 并在匿名内部类中,声明一个方法public void test()打印尚硅谷
 * 请编写代码调用这个方法
 * @Author lyl
 * @Version 1.0
 */
//public class exer {
//    public static void main (String[] args) {
//        new tool(){
//            @Override
//            public void test () {
//                System.out.println("尚硅谷");
//            }
//        }.test();
//    }
//}
//
//interface tool{
//    public abstract void test();
//}

public class exer{
    public static void main (String[] args) {
       new Object(){
           public void test(){
               System.out.println("尚硅谷");
           }
       }.test();
    }
}




