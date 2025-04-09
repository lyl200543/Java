package ioTest;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * ClassName: FileInputOutputStreamTest
 * Package: ioTest
 * Description:创建于 2025/4/9 16:39
 *
 * @Author lyl
 * @Version 1.0
 */
public class FileInputOutputStreamTest {
    @Test
    public void test1 () {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File file = new File("test.png");
            File file1 = new File("test_copy.png");

            fis = new FileInputStream(file);
            fos = new FileOutputStream(file1);

            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) != - 1) {
                fos.write(buffer , 0 , len);
            }
        } catch (IOException e) {
            e.printStackTrace() ;
        } finally {
            try {
                if(fis!=null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace() ;
            }
            try {
                if(fos!=null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace() ;
            }
        }

    }
    
    @Test 
    public void test2(){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File file = new File("hello.txt");
            File file1 = new File("hello_copy.txt");

            fis = new FileInputStream(file);
            fos = new FileOutputStream(file1);

            byte[] buffer = new byte[5];
            int len;
            while ((len = fis.read(buffer)) != - 1) {
                fos.write(buffer , 0 , len);
            }
        } catch (IOException e) {
            e.printStackTrace() ;
        } finally {
            try {
                if(fis!=null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace() ;
            }
            try {
                if(fos!=null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace() ;
            }
        }
    }
}
