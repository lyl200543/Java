package Class_Advanced;

/**
 * ClassName: FinalTest
 * Package: Class_Advanced
 * Description:创建于 2025/3/25 20:03
 *
 * @Author lyl
 * @Version 1.0
 */
public class FinalTest {
    public static void main (String[] args) {
        //final修饰局部变量
        final int a;
        a=1;
        System.out.println(a);

    }
//    void func(final int n){
//        n++;
//    }
}

//1.final修饰类，该类不能被继承
//final class A{
//
//}
//class B extends A{
//
//}

//2.final修饰方法，该方法不能被重写
//class A{
//    final public void display(){
//
//    }
//}
//
//class B extends A{
//    public void display(){
//
//    }
//}

//3.final修饰变量，变量相当于常量，不能修改
//final修饰成员变量
//class A {
//    final public int anInt;
//   {
//       anInt=1;
//   }
//
//   A(){
//       anInt=1;
//   }
//
//   public void func(){
//       anInt =1;
//   }
//}




