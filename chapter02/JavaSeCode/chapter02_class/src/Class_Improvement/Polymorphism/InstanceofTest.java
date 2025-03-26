package Class_Improvement.Polymorphism;

/**
 * ClassName: InstanceofTest
 * Package: Class_Improvement
 * Description:创建于 2025/3/23 13:20
 *
 * @Author lyl
 * @Version 1.0
 */

//在多态的场景下，我们创建了子类的对象,也加载了子类特有的属性和方法
//但是由于声明为父类的引用导致我们没有办法直接调用子类特有的属性和方法
//要想解决这个问题，需要使用向下转型
public class InstanceofTest {
    public static void main (String[] args) {
        //向上转型：多态
        Person p1=new Man();
//        p1.eat();
//        p1.earnmoney();
        //向下转型：
//        Man man = (Man)p1;
//        man.eat();
//        man.earnmoney();

        //instanceof的使用
        //出现类型转换异常(ClassCastException)
//        Woman woman =(Woman)p1;
//        woman.eat();
//        woman.earnmoner();

        if(p1 instanceof Man){
            Man man=(Man)p1;
            man.eat() ;
            man.earnmoney() ;
        }

        if(p1 instanceof Woman ){
            Woman woman =(Woman)p1;
            woman.eat() ;
            woman.earnmoner() ;
        }
    }
}
