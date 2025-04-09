package ioTest;

import org.junit.Test;

import java.io.*;

/**
 * ClassName: InputStreamReaderTest
 * Package: ioTest
 * Description:创建于 2025/4/9 20:50
 *
 * @Author lyl
 * @Version 1.0
 */
public class InputStreamReaderTest {
    @Test
    public void test1 () throws IOException {
        File src = new File("electron.txt");
        File dest = new File("electron_gbk1.txt");
        FileInputStream fis = new FileInputStream(src);
        FileOutputStream fos = new FileOutputStream(dest);
        //InputStreamReader为Reader的子类
        InputStreamReader isr = new InputStreamReader(fis , "utf-8");
        OutputStreamWriter osw = new OutputStreamWriter(fos , "gbk");

        int len;
        char[] buffer = new char[50];
        while ((len = isr.read(buffer)) != - 1) {
            osw.write(buffer , 0 , len);
        }

        isr.close();
        osw.close();


    }
}
