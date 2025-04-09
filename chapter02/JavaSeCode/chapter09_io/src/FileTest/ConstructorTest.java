package FileTest;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * ClassName: ConstructorTest
 * Package: FileTest
 * Description:创建于 2025/4/8 21:38
 *
 * @Author lyl
 * @Version 1.0
 */
public class ConstructorTest {
    @Test
    public void test1 () {
        //绝对路径
        File file = new File("C:\\Users\\lyl\\Desktop\\JavaSE\\");
        System.out.println(file.getAbsolutePath());
        //相对路径
        File file1 = new File("io/test.txt");
        System.out.println(file1.getAbsolutePath());  //chapter09_io\io\test.txt
    }

    public static void main (String[] args) {
        File file = new File("io/test.txt");
        System.out.println(file.getAbsolutePath());  //JavaSeCode\io\test.txt
    }

    @Test
    public void test2 () {
        File file = new File("io/abc" , "test.txt");
        File file1 = new File("io" , "abc");
        System.out.println(file.getAbsolutePath());
        System.out.println(file1.getAbsolutePath());

        File file2 = new File(file1 , "test.txt");
        System.out.println(file2.getAbsolutePath());
    }

    /**
     * public String getName():获取名称
     * public String getPath():获取路径
     * public String getAbsolutePath():获取绝对路径
     * public File getAbsoluteFile():获取绝对路径表示的文件
     * public String getParent():获取上层文件目录路径。若无，返回null
     * public long length():获取文件长度(即:字节数)。不能获取目录的长度
     * public long lastModified():获取最后一次的修改时间，毫秒值
     */
    @Test
    public void test3 () {
        File file = new File("test.txt");
        System.out.println(file.getName());
        System.out.println(file.getPath());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getAbsoluteFile());
        System.out.println(file.getParent());
        System.out.println(file.getAbsoluteFile().getParent());
        System.out.println(file.length());
        System.out.println(file.lastModified());
        Date date = new Date(1744159673391L);
        System.out.println(date);
    }

    @Test
    public void test4 () {
        File file = new File("C:\\Users\\lyl\\Desktop\\JavaSE\\test.txt");
        System.out.println(file.getName());
        System.out.println(file.getPath());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getAbsoluteFile());
        System.out.println(file.getParent());
        System.out.println(file.getAbsoluteFile().getParent());
        System.out.println(file.length());
        System.out.println(file.lastModified());
    }

    //    public String[] list():返回一个String数组，表示该File目录中的所有子文件或目录。
//    public File[] listFiles():返回一个File数组，表示该File目录中的所有的子文件或目录。
    @Test
    public void test5 () {
        File file = new File("C:\\Users\\lyl\\Desktop");
        String[] list = file.list();
        for (String s : list) {
            System.out.println(s);
        }

        File[] files = file.listFiles();
        for (File f : files) {
            System.out.println(f);
        }
    }


    //public boolean renameTo(File dest):把文件重命名为指定的文件路径
    @Test
    public void test6 () {
        File file = new File("test.txt");
        File file1 = new File("C:\\Users\\lyl\\Desktop\\JavaSE\\test.txt");
        System.out.println(file.renameTo(file1) ? "重命名成功" : "重命名失败");
    }

    //    应用：批量修改某个文件目录下的文件名
    @Test
    public void test7 () {
        File file = new File("C:\\Users\\lyl\\Desktop\\JavaSE\\chapter02\\JavaSeCode\\test");
        File[] files = file.listFiles();
        for (int i = 0 ; i < files.length ; i++) {
            File file1 = new File("C:\\Users\\lyl\\Desktop\\JavaSE\\chapter02\\JavaSeCode\\test\\test" + (i + 1));
            files[i].renameTo(file1);
        }
    }

    //    public boolean exists():此File表示的文件或目录是否实际存在
//    public boolean isDirectory():此File表示的是否为目录。
//    public boolean isFile():此File表示的是否为文件。
//    public boolean canRead():判断是否可读
//    public boolean canWrite():判断是否可写
//    public boolean isHidden():判断是否隐藏
    @Test
    public void test8 () {
        File file = new File("C:\\Users\\lyl\\Desktop\\JavaSE");
        System.out.println(file.exists());
        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
        System.out.println(file.canRead());
        System.out.println(file.canWrite());
        System.out.println(file.isHidden());

    }

    //    public boolean createNewFile():创建文件。若文件存在，则不创建，返回false。
//    public boolean mkdir():创建文件目录。如果此文件目录存在，就不创建了。如果此文件目录的上层目录不存在，也不创建。
//    public boolean mkdirs():创建文件目录。如果上层文件目录不存在，一并创建。
//    public boolean delete():删除文件或者文件夹
//    删除注意事项:① Java中的删除不走回收站。② 要删除一个文件目录，请注意该文件目录内不能包含文件或者文件目录。
    @Test
    public void test9 () throws IOException {
//        File file = new File("C:\\Users\\lyl\\Desktop\\JavaSE\\hello.txt");
//        System.out.println(file.createNewFile() ? "创建成功" : "创建失败");
        File file1 = new File("C:\\Users\\lyl\\Desktop\\JavaSE\\abc\\hello");
        file1.mkdirs();
        File file2 = new File("C:\\Users\\lyl\\Desktop\\JavaSE\\abc");
        System.out.println(file2.delete() ? "删除成功" : "删除失败");
//        System.out.println(file1.delete() ? "删除成功" : "删除失败");


    }
}
