import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * ClassName: URLTest
 * Package: PACKAGE_NAME
 * Description:创建于 2025/4/11 17:14
 * 下载指定的URL的资源到本地(了解)
 *
 * @Author lyl
 * @Version 1.0
 */
public class URLTest {
    @Test
    public void test () {
        HttpURLConnection urlConnection = null;
        InputStream is = null;
        FileOutputStream fos = null;
        try {
            URL url = new URL("https://c-ssl.duitang.com/uploads/blog/202111/21/20211121233103_d75c6.jpg");
            urlConnection = (HttpURLConnection) url.openConnection();
            is = urlConnection.getInputStream();
            File file = new File("zeyu.jpg");
            fos = new FileOutputStream(file);
            byte[] arr = new byte[1024];
            int len;
            while ((len = is.read(arr)) != - 1) {
                fos.write(arr , 0 , len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (fos != null) {

                    fos.close();
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
            urlConnection.disconnect();
        }


    }
}
