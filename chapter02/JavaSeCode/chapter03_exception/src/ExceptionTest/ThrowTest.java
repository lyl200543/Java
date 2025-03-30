package ExceptionTest;

/**
 * ClassName: ThrowTest
 * Package: ExceptionTest
 * Description:创建于 2025/3/30 16:56
 *
 * @Author lyl
 * @Version 1.0
 */
public class ThrowTest {
    public static void main (String[] args) {
        try {
            Student student = new Student();
            student.register(- 3);
            System.out.println(student.id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Student {
    int id;

    public void register (int id) throws Exception {
        if (id > 0)
            this.id = id;
        else
            throw new BelowZeroException("id输入有误") ;
    }
}

class BelowZeroException extends Exception {
    static final long serialVersionUID = - 338751124229948L;


    public BelowZeroException () {
    }

    public BelowZeroException (String message) {
        super(message);
    }

    public BelowZeroException (String message , Throwable cause) {
        super(message , cause);
    }
}
