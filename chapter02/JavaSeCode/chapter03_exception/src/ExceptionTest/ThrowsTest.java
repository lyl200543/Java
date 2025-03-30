package ExceptionTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * ClassName: ThrowsTest
 * Package: ExceptionTest
 * Description:创建于 2025/3/30 15:16
 *
 * @Author lyl
 * @Version 1.0
 */
public class ThrowsTest {
    public static void main (String[] args) {
        try {
            method2();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void method2 () throws FileNotFoundException, IOException {
        method1();
    }

    public static void method1 () throws FileNotFoundException, IOException {

        File file = new File("D:\\hello.txt");
        FileInputStream fis = new FileInputStream(file); //可能报FileNotFoundException
        int data = fis.read();//可能报I0Exceptionwhile
        while (data != - 1) {
            System.out.print((char) data);
            data = fis.read();//可能报I0Exception
        }
        fis.close();//可能报I0Exception

    }
}
