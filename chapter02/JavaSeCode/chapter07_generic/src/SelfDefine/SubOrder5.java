package SelfDefine;

/**
 * ClassName: SubOrder5
 * Package: SelfDefine
 * Description:创建于 2025/4/6 17:08
 * SubOrder5是泛型类
 *
 * @Author lyl
 * @Version 1.0
 */
public class SubOrder5<T, E> extends Order<T> {
    E e;

    public E getE () {
        return e;
    }

    public void setE (E e) {
        this.e = e;
    }
}
