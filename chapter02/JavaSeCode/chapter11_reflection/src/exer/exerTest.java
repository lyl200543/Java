package exer;

import org.junit.Test;

import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.util.Properties;

/**
 * ClassName: exerTest.exer
 * Package: PACKAGE_NAME
 * Description:创建于 2025/4/12 15:56
 * 案例:1榨汁机榨水果汁，水果分别有苹果(Apple)、香蕉(Banana)、桔子(0range)等。
 * 效果如图。
 * 提示:
 * 1、声明(Fruit)水果接口，包含榨汁抽象方法:void squeeze();/skwi:z/
 * 2、声明榨汁机(Juicer)，包含运行方法:public void run(Fruit f)，方法体中，调用f的榨汁方法squeeze
 * 3、声明各种水果类，实现水果接口，并重写squeeze();
 * 4、在src下，建立配置文件:config.properties，并在配置文件中配上fruitName=xxx(其中xx为某种水果的全类名)
 * 5、在FruitTest测试类中，
 * 读取配置文件，获取水果类名，并用反射创建水果对象(1)
 * (2)创建榨汁机对象，并调用run()方法
 *
 * @Author lyl
 * @Version 1.0
 */
public class exerTest {
    @Test
    public void test () throws Exception {
        Properties properties = new Properties();
        //FileInputStream is = new FileInputStream(new File("src\\config.properties"));
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("config.properties");
        properties.load(is);
        String fruitName = properties.getProperty("fruitName");

        Class cls = Class.forName(fruitName);
        Constructor con = cls.getDeclaredConstructor();
        Fruit obj = (Fruit) con.newInstance();
        Juicer juicer = new Juicer();
        juicer.run(obj);
    }

}
