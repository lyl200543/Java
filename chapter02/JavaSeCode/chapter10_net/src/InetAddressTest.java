import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * ClassName: InetAddressTest
 * Package: PACKAGE_NAME
 * Description:创建于 2025/4/10 19:32
 *
 * @Author lyl
 * @Version 1.0
 */
public class InetAddressTest {
    @Test
    public void test1 () {
        try {
            InetAddress inet1 = InetAddress.getByName("193.56.85.7");
            System.out.println(inet1);
            InetAddress inet2 = InetAddress.getByName("www.baidu.com");
            System.out.println(inet2);
            InetAddress inet3 = InetAddress.getLocalHost();
            System.out.println(inet3);

            System.out.println();
            System.out.println(inet1.getHostName());
            System.out.println(inet1.getHostAddress());

            System.out.println();
            System.out.println(inet2.getHostName());
            System.out.println(inet2.getHostAddress());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }
}
