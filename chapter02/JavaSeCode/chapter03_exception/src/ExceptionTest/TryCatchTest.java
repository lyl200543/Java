package ExceptionTest;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * ClassName: TryCatchTest
 * Package: ExceptionTest
 * Description:创建于 2025/3/30 11:26
 *
 * @Author lyl
 * @Version 1.0
 */
public class TryCatchTest {
    @Test
    public void test1 () {

        try {
            Scanner scanner = new Scanner(System.in);
            int num = scanner.nextInt();
            System.out.println(num);
            scanner.close();
        } catch (InputMismatchException e) {
            System.out.println("输入格式不匹配异常");
        } catch (NullPointerException e) {

        } catch (RuntimeException e) {

        }
        System.out.println("异常处理结束，继续执行代码...");
    }

    @Test
    public void test2 () {
        try {
            File file = new File("D:\\hello.txt");
            FileInputStream fis = new FileInputStream(file); //可能报FileNotFoundException
            int data = fis.read();//可能报I0Exceptionwhile
            while (data != - 1) {
                System.out.print((char) data);
                data = fis.read();//可能报I0Exception
            }
            fis.close();//可能报I0Exception
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("end");
    }
}
