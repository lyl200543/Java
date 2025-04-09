package ioTest;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * ClassName: ReaderWriterTest
 * Package: ioTest
 * Description:创建于 2025/4/9 15:20
 *
 * @Author lyl
 * @Version 1.0
 */
public class FileReaderWriterTest {
    //FileReader读数据
    @Test
    public void test1 () {
        FileReader fileReader = null;
        try {
            File file = new File("hello.txt");
            fileReader = new FileReader(file);  //异常
            //read()：一个一个字符读取，返回值为字符的编码值（int）
            //如果返回值为-1时，表示到达文件末尾
            int ret;
            while ((ret = fileReader.read()) != - 1) {  //异常
                System.out.print((char) ret);
            }
            //为保证流资源被关闭并且处理异常，使用try-catch-finall
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //可能在还没创建流对象之前抛出异常，如果直接关闭流资源，会导致空指针异常
                if (fileReader != null)
                    fileReader.close();  //异常
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    //一个一个读取文件中的字符效率太低，与磁盘交互频繁
    //改进：一次读取多个字符（字符数组）
    @Test
    public void test2 () {
        FileReader fileReader = null;
        try {
            File file = new File("hello.txt");
            fileReader = new FileReader(file);
            //read(char[] cbuf):一次读取多个字符，返回读取字符的个数
            //如果到达文件末尾，则返回-1
            char[] cbuffer = new char[5];
            int len;
            while ((len = fileReader.read(cbuffer)) != - 1) {
                for (int i = 0 ; i < len ; i++) {
                    System.out.print(cbuffer[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileReader != null)
                    fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //FileWriter写入数据：
    @Test
    public void test3 () {
        FileWriter fw = null;
        try {
            File file = new File("info.txt");
            //fw = new FileWriter(file);
            //fw = new FileWriter(file , false);
            fw = new FileWriter(file , true);
            fw.write("I Love You!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fw != null)
                    fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void test4 () {
        FileReader fr = null;
        FileWriter fw = null;
        try {
            File file = new File("hello.txt");
            File file1 = new File("info.txt");

            fr = new FileReader(file);
            fw = new FileWriter(file1);

            char[] cbuffer = new char[5];
            int len;
            while ((len = fr.read(cbuffer)) != - 1) {
                fw.write(cbuffer , 0 , len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fr!=null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fw!=null)
                    fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
