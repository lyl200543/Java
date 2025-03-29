package Class_Advanced.Wrapper;

import org.junit.Test;

/**
 * ClassName: WrapperTest1
 * Package: Class_Advanced.Wrapper
 * Description:创建于 2025/3/29 11:18
 *
 * @Author lyl
 * @Version 1.0
 */
public class WrapperTest1 {
    //基本数据类型、包装类:---> string类型:
    @Test
    public void test1(){
        //调用Strinq的重载的静态方法value0f(xxx xx)
        int num=10;
        String str1 = String.valueOf(num);
        System.out.println(str1);

        Boolean b=true;
        String str2 = String.valueOf(b);
        System.out.println(str2);

        //基本数据类型+""
        String str3=123+"";
        System.out.println(str3);
    }

    //Strinq类型 ---> 基本数据类型、包装类
    @Test
    public void test2(){
        //调用包装类的静态方法:parseXxx()
        int num=Integer.parseInt("123");
        System.out.println(num);

        Float f=Float.parseFloat("3.2");
        System.out.println(f);
    }

}
