package exer;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * ClassName: exer2
 * Package: exer
 * Description:创建于 2025/4/10 15:00
 * 测试第三方工具
 *
 * @Author lyl
 * @Version 1.0
 */
public class exer2 {
    @Test
    public void test1 () throws IOException {
        File srcfile = new File("test.png");
        File destfile = new File("test_copy3.png");
        FileUtils.copyFile(srcfile , destfile);
    }

}
