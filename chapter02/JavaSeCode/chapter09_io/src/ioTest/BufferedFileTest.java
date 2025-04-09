package ioTest;

import org.junit.Test;

import java.io.*;

/**
 * ClassName: BufferedFileTest
 * Package: ioTest
 * Description:创建于 2025/4/9 17:06
 *
 * @Author lyl
 * @Version 1.0
 */
public class BufferedFileTest {
    @Test
    public void test1 () {
        long start = System.currentTimeMillis();
        //WithBufferedStream("test.png" , "test_copy1.png");
        WithFileStream("test.png" , "test_copy2.png");
        long end = System.currentTimeMillis();
        System.out.println("花费时间为：" + (end - start));
    }

    public void WithBufferedStream (String src , String dest) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            File file = new File(src);
            File file1 = new File(dest);

            fis = new FileInputStream(file);
            fos = new FileOutputStream(file1);
            //将节点流作为参数传入到处理流（缓冲流）中
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);


            byte[] buffer = new byte[50];
            int len;
            while ((len = bis.read(buffer)) != - 1) {
                bos.write(buffer , 0 , len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流资源时，必须先关闭外部流（处理流），再关闭内部流（节点流）
            //关闭外部流时，内部流也被关闭，因此可以只关闭外部流
            try {
                if (bis != null)
                    bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bos != null)
                    bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void WithFileStream (String src , String dest) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File file = new File(src);
            File file1 = new File(dest);

            fis = new FileInputStream(file);
            fos = new FileOutputStream(file1);

            byte[] buffer = new byte[50];
            int len;
            while ((len = fis.read(buffer)) != - 1) {
                fos.write(buffer , 0 , len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
