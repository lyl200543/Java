import org.junit.Test;

import java.util.Optional;

/**
 * ClassName: OptionalTest
 * Package: PACKAGE_NAME
 * Description:创建于 2025/4/13 14:55
 *
 * @Author lyl
 * @Version 1.0
 */
public class OptionalTest {
    @Test
    public void test () {
        String star = "zhangzeyu";
        star = null;
        //1.实例化：
        Optional<String> originalStar = Optional.ofNullable(star);
        String otherStar = "boom";
        //2.调用方法
        String finalStar = originalStar.orElse(otherStar);
        System.out.println(finalStar.toString());


    }
}


//密封类
sealed class Person permits Student {

}

final class Student extends Person {

}