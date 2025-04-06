package SelfDefine;

/**
 * ClassName: SubOrder4
 * Package: SelfDefine
 * Description:创建于 2025/4/6 17:06
 * SubOrder4是泛型类
 * @Author lyl
 * @Version 1.0
 */
public class SubOrder4<E> extends Order <Integer >{
    E e;

    public E getE () {
        return e;
    }

    public void setE (E e) {
        this.e = e;
    }
}
