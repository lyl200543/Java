package Class_Advanced;

import org.junit.Test;

import java.util.Scanner;

/**
 * ClassName: JunitTest
 * Package: Class_Advanced
 * Description:创建于 2025/3/29 9:24
 *
 * @Author lyl
 * @Version 1.0
 */
public class JunitTest {
    @Test 
    public void test(){
        System.out.println("hello");
    }

    @Test
    public void test1(){
        method();
    }

    void method(){
        for (int i = 0 ; i < 3 ; i++) {
            System.out.println("lyl");
        }
    }
    
    @Test 
    public void test2(){
        Scanner scanner =new Scanner(System.in);
        System.out.println("请输入：");
        int num=scanner.nextInt();
        System.out.println(num);
        scanner.close();
    }
}
