package Class_Advanced.Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ClassName: MyAnnotation
 * Package: Class_Advanced.Annotation
 * Description:创建于 2025/3/28 21:00
 *
 * @Author lyl
 * @Version 1.0
 */
@Target({ElementType.TYPE ,ElementType.FIELD})
@Retention (RetentionPolicy.SOURCE)
public @interface MyAnnotation {
    String value() default "Hello";
}
