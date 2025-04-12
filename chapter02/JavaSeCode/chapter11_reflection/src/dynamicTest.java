import ClassTest.User;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * ClassName: dynamicTest
 * Package: PACKAGE_NAME
 * Description:创建于 2025/4/12 14:54
 *
 * @Author lyl
 * @Version 1.0
 */
public class dynamicTest {
    //静态
    public User getInstance () {
        return new User();
    }

    //动态
    public <T> T getInstance (String className) throws Exception {
        Class cls = Class.forName(className);
        Constructor con = cls.getDeclaredConstructor();
        con.setAccessible(true);
        return (T) con.newInstance();
    }

    @Test
    public void test1 () throws Exception {
        User u1 = getInstance();
        System.out.println(u1);

        User u2 = getInstance("ClassTest.User");
        System.out.println(u2);

        Date date = getInstance("java.util.Date");
        System.out.println(date);
    }


    public Object invoke (String className , String methodName) throws Exception {
        Class cls = Class.forName(className);
        Constructor con = cls.getDeclaredConstructor();
        Object obj = con.newInstance();

        Method method = cls.getDeclaredMethod(methodName);
        return method.invoke(obj);
    }

    @Test
    public void test2() throws Exception {
        System.out.println(invoke("ClassTest.User" , "show"));

    }
}

