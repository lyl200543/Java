package exer;

import org.junit.Test;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

/**
 * ClassName: exer1
 * Package: exer
 * Description:创建于 2025/4/9 13:44
 * 创建一个与hello.txt文件在相同文件目录下的另一个名为abc.txt文件
 *
 * @Author lyl
 * @Version 1.0
 */
public class exer1 {
    @Test
    public void test1 () throws IOException {
//        File file = new File("C:\\Users\\lyl\\Desktop\\JavaSE");
//        File file1 = new File(file , "hello.txt");
//        File file2 = new File(file , "abc.txt");
//        file1.createNewFile();
//        file2.createNewFile();

        File file = new File("hello.txt");
        File file1 = new File(file.getAbsoluteFile().getParent() , "abc.txt");
        System.out.println(file.getAbsolutePath());
        System.out.println(file1.getAbsolutePath());
    }

    @Test
    public void test2 () {
        // 判断指定目录下是否有后缀名为.jpg的文件，如果有，就输出该文件名称
        File file = new File("C:\\Users\\lyl\\Desktop\\JavaSE");
        //方式1：
//        String[] list = file.list();
//        for (String s : list) {
//            if(s.contains(".jpg"))
//                System.out.println(s);
//        }

        //方式2：
        //public String[] list(FilenameFilter filter)
        String[] list = file.list(new FilenameFilter() {
            @Override
            public boolean accept (File dir , String name) {
                return name.endsWith(".jpg");
            }
        });
        for (String s : list) {
            System.out.println(s);
        }
    }

    @Test
    public void test3 () {
        //遍历指定文件目录下的所有文件的名称，包括子文件目录中的文件，
        //public void printFileName(File file) //file可能是文件，也可能是文件目录
        File file = new File("C:\\Users\\lyl\\Desktop\\JavaSE\\photo");
        printFileName(file);
    }

    public static void printFileName (File file) {
        if (!file.exists()) {
            System.out.println("文件目录不存在");
            return;
        }
        if (file.isFile()) {
            System.out.println(file);
            return;
        }
        File[] files = file.listFiles();
        for (File f : files) {
            printFileName(f);
        }
    }
}
