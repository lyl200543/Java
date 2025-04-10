package TCPTest;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ClassName: TCPTest2
 * Package: TCPTest
 * Description:创建于 2025/4/10 21:10
 * 例题2:客户端发送文件给服务端，服务端将文件保存在本地。
 * @Author lyl
 * @Version 1.0
 */
public class TCPTest2 {
    @Test
    public void client () throws IOException {
        InetAddress addr = InetAddress.getByName("127.0.0.1");
        Socket socket = new Socket(addr , 9090);
        OutputStream os = socket.getOutputStream();

        File file = new File("pic.jpg");
        FileInputStream fis = new FileInputStream(file);

        byte[] arr = new byte[1024];
        int len;
        while ((len = fis.read(arr)) != - 1) {
            os.write(arr , 0 , len);
        }
        System.out.println("数据传输完毕");

        os.close();
        fis.close();
        socket.close();
    }

    @Test
    public void server () throws IOException {
        ServerSocket serverSocket = new ServerSocket(9090);
        Socket socket = serverSocket.accept();
        InputStream is = socket.getInputStream();

        File file = new File("pic_copy.jpg");
        FileOutputStream fos = new FileOutputStream(file);

        byte[] arr = new byte[1024];
        int len;
        while ((len = is.read(arr)) != - 1) {
            fos.write(arr , 0 , len);
        }
        System.out.println("数据接收完毕");

        fos.close();
        is.close();
        socket.close();
        serverSocket.close();
    }
}
