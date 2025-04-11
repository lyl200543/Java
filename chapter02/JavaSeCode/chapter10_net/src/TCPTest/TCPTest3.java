package TCPTest;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ClassName: TCPTest3
 * Package: TCPTest
 * Description:创建于 2025/4/10 21:37
 * 例题2:客户端发送文件给服务端，服务端将文件保存在本地。并返回发送成功给客户端。并关闭相应的连接
 *
 * @Author lyl
 * @Version 1.0
 */
public class TCPTest3 {
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
        //表示客户端不再传输数据，服务端不用等待客户端
        socket.shutdownOutput();

        //接受服务端的信息
        InputStream is = socket.getInputStream();
        byte[] arr1 = new byte[5];
        int len1;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        while ((len1 = is.read(arr1)) != - 1) {
            baos.write(arr1 , 0 , len1);
        }
        System.out.println(baos);

        baos.close();
        is.close();
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

        //向客户端发送信息
        OutputStream os = socket.getOutputStream();
        os.write("发送成功".getBytes());

        os.close();
        fos.close();
        is.close();
        socket.close();
        serverSocket.close();
    }
}
