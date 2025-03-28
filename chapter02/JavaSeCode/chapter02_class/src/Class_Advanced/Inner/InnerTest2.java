package Class_Advanced.Inner;

/**
 * ClassName: InnerTest2
 * Package: Class_Advanced.Inner
 * Description:创建于 2025/3/27 14:19
 *
 * @Author lyl
 * @Version 1.0
 */

//匿名内部类的使用：
public class InnerTest2 {
    public static void main (String[] args) {
        //1.抽象类的匿名内部类（子类）
        B b=new B();
        b.method();

        new A(){
            @Override
            public void method () {
                System.out.println("抽象类的匿名内部类调用的方法");
            }
        }.method();

        //2.接口的匿名内部类（实现类）
        D d=new D();
        d.method1();

        new C(){
            @Override
            public void method1 () {
                System.out.println("接口的匿名内部类调用的方法");
            }
        }.method1();

        //3.普通类的匿名内部类(子类)
        new E(){
            public void method3(){
                System.out.println("普通类的匿名内部类");
            }
        }.method3();
    }
}

abstract class A{
    public abstract void method();
}

class B extends A{
    @Override
    public void method () {
        System.out.println("SubB");
    }
}

interface C{
    public void method1();
}

class D implements C{
    @Override
    public void method1 () {
        System.out.println("SubD");
    }
}

class E{

}