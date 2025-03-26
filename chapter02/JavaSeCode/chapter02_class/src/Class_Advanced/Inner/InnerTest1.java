package Class_Advanced.Inner;

/**
 * ClassName: InnerTest1
 * Package: Class_Advanced.Inner
 * Description:创建于 2025/3/26 20:38
 *
 * @Author lyl
 * @Version 1.0
 */
//局部内部类的使用
public class InnerTest1 {
    //开发中的场景：
    //Comparable是一个接口，要返回一个Comparable的实现类
    public Comparable getInstance(){
        //1。提供了接口的实现类的匿名对象
//        class MyComparable implements Comparable {
//            @Override
//            public int compareTo (Object o) {
//                return 0;
//            }
//        }
//        return new MyComparable();


        //2.提供了接口的匿名实现类的匿名对象
        return new Comparable(){
            @Override
            public int compareTo (Object o) {
                return 0;
            }
        };
    }
}
