package ExceptionTest.exer2;

/**
 * ClassName: BelowZeroException
 * Package: ExceptionTest.exer2
 * Description:创建于 2025/3/30 19:06
 *
 * @Author lyl
 * @Version 1.0
 */
public class BelowZeroException extends RuntimeException {
    static final long serialVersionUID = - 7034897145766939L;

    public BelowZeroException () {
    }

    public BelowZeroException (String message) {

        super(message);
    }
}
