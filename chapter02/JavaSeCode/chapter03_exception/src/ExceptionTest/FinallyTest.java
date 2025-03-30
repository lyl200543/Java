package ExceptionTest;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * ClassName: FinallyTest
 * Package: ExceptionTest
 * Description:创建于 2025/3/30 14:48
 *
 * @Author lyl
 * @Version 1.0
 */
public class FinallyTest {
    @Test
    public void test(){
        FileInputStream fis=null;
        try {
            File file = new File("D:\\hello.txt");
            //未创建流对象
            fis = new FileInputStream(file); //可能报FileNotFoundException
            //创建了流对象
            int data = fis.read();//可能报I0Exceptionwhile
            while (data != - 1) {
                System.out.print((char) data);
                data = fis.read();//可能报I0Exception
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(fis!=null)
                    fis.close();//可能报I0Exception
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
