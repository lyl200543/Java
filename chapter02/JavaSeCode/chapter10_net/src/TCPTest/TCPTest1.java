package TCPTest;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ClassName: TCPTest
 * Package: PACKAGE_NAME
 * Description:创建于 2025/4/10 19:57
 * 例题1:客户端发送内容给服务端，服务端将内容打印到控制台上。
 *
 * @Author lyl
 * @Version 1.0
 */
public class TCPTest1 {
    @Test
    public void client () {
        Socket socket = null;
        OutputStream os = null;
        try {
            InetAddress inet = InetAddress.getByName("10.165.169.13");
            socket = new Socket(inet , 8980);
            os = socket.getOutputStream();
            os.write("我是客户端，请多多关照".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (os != null) {

                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (socket != null) {

                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void server () {
        ServerSocket ss = null;
        Socket accept = null;
        InputStream is = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();  //底层维护了一个byte[]
        try {
            ss = new ServerSocket(8980);
            accept = ss.accept();
            System.out.println("服务器开始数据传输");
            System.out.println("收到了来自" + accept.getInetAddress().getHostAddress() + "的连接");
            is = accept.getInputStream();
            byte[] str = new byte[5];
            int len;
            while ((len = is.read(str)) != - 1) {

                //如果发送的数据为文字时，这样接收会有问题
//                String s = new String(str , 0 , len);
//                System.out.print(s);

                //正确做法：
                baos.write(str , 0 , len);

            }
            System.out.println(baos.toString());

            System.out.println("服务器数据传输结束");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (ss != null) {

                    ss.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (accept != null) {

                    accept.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (is != null) {

                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (baos != null) {

                    baos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
