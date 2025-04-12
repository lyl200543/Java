import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * ClassName: propertiesTest
 * Package: PACKAGE_NAME
 * Description:创建于 2025/4/12 13:18
 *
 * @Author lyl
 * @Version 1.0
 */
public class propertiesTest {
    @Test
    public void test1 () throws IOException {
        Properties properties = new Properties();
        FileInputStream is = new FileInputStream(new File("info.txt"));
        properties.load(is);
        String name = properties.getProperty("name");
        String age = properties.getProperty("age");
        System.out.println(name + ":" + age);
    }


    //使用ClassLoader加载配置文件
    //注意：读取的文件的默认路径为：当前module下
    //通过类的加载器获取的文件的默认路径为：当前module下的src中
    @Test
    public void test2 () throws IOException {
        Properties properties = new Properties();
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("info.txt");
        properties.load(is);
        System.out.println(properties.getProperty("name"));
        System.out.println(properties.getProperty("age"));
    }
}
