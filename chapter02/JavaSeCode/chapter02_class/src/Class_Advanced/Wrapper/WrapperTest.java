package Class_Advanced.Wrapper;

import org.junit.Test;

/**
 * ClassName: WrapperTest
 * Package: Class_Advanced.Wrapper
 * Description:创建于 2025/3/29 10:31
 *
 * @Author lyl
 * @Version 1.0
 */
public class WrapperTest {
    //基本数据类型 ---> 包装类:
    //① 使用包装类的构造器（已经移除了）
    //② (建议)调用包装类的value0f(xxx xx)
    @Test
    public void test1(){
        int num=10;
        //Integer num1=new Integer(num);
        Integer num2=Integer.valueOf(num);
        System.out.println(num2.toString());

        float f=3.2f;
        Float f1=Float.valueOf("3.2");
        System.out.println(f1);

        boolean b=true;
        Boolean b1=Boolean.valueOf("123");
        System.out.println(b1);
    }

    //包装类 ---> 基本数据类型:调用包装类的xxxValue()
    @Test
    public void test2(){
        Integer num1=Integer.valueOf(12);
        int num=num1.intValue();
        System.out.println(num);

        Float f1=Float.valueOf(4.8f);
        float f=f1.floatValue();
        System.out.println(f);

        Boolean b1=Boolean.valueOf(true);
        boolean b=b1.booleanValue();
        System.out.println(b);
    }

    @Test
    public void test3(){
        //自动装箱：基本数据类型->包装类
        Integer num=2;
        System.out.println(num);

        Float f=2.2f;
        System.out.println(f);

        Boolean b=true;
        System.out.println(b);

        //自动拆箱：包装类->基本数据类型
        int num1=num;
        System.out.println(num1);

        float f1=f;
        System.out.println(f1);
    }

}
