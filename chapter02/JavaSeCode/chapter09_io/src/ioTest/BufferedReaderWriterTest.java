package ioTest;

import org.junit.Test;

import java.io.*;

/**
 * ClassName: BufferedReaderWriterTest
 * Package: ioTest
 * Description:创建于 2025/4/9 19:34
 *
 * @Author lyl
 * @Version 1.0
 */
public class BufferedReaderWriterTest {
    //使用BufferedReader将文件内容打印到控制台上
    @Test
    public void test1 () throws IOException {
        File file = new File("electron.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        char[] buf = new char[50];
        String s = null;

//        int len;
//        while ((len = br.read(buf)) != - 1) {
////            for (int i = 0 ; i < len ; i++) {
////                System.out.print(buf[i]);
////            }
//
//            String s = new String(buf , 0 , len);
//            System.out.print(s);
//        }


        //readLine()每次读取一行文本，返回值类型为String,不包括换行符
        //读到文件末尾时，返回null
        while ((s = br.readLine()) != null) {
            System.out.println(s);
        }
        br.close();
    }


}
