import org.junit.Test;

import java.net.*;

/**
 * ClassName: UDPTest
 * Package: PACKAGE_NAME
 * Description:创建于 2025/4/11 16:57
 *
 * @Author lyl
 * @Version 1.0
 */
public class UDPTest {
    @Test
    public void Send () throws Exception {
        DatagramSocket ds = new DatagramSocket();
        byte[] arr = "我是发送端".getBytes();
        InetAddress inet = InetAddress.getByName("127.0.0.1");
        DatagramPacket dp = new DatagramPacket(arr , 0 , arr.length , inet , 9090);
        ds.send(dp);
        ds.close();
    }

    @Test
    public void Recieve () throws Exception {
        DatagramSocket ds = new DatagramSocket(9090);
        byte[] arr = new byte[1024];
        DatagramPacket dp = new DatagramPacket(arr , 0 , arr.length);
        ds.receive(dp);
        String s = new String(dp.getData() , 0 , dp.getLength());
        System.out.println(s);
        ds.close();
    }
}
