package ExceptionTest.exer1;

/**
 * ClassName: NoLifeValveException
 * Package: ExceptionTest.exer1
 * Description:创建于 2025/3/30 17:32
 * (1)自定义异常类NoLifeValveException继承RuntimeException①提供空参和有参构造
 * ②在有参构造中，需要调用父类的有参构造，把异常信息传入
 * @Author lyl
 * @Version 1.0
 */
public class NoLifeValveException extends RuntimeException {
    static final long serialVersionUID = -375169931242248L;

    public NoLifeValveException () {
    }

    public NoLifeValveException (String message) {
        super(message);
    }
}
