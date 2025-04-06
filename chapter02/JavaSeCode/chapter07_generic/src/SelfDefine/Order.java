package SelfDefine;

import java.util.ArrayList;

/**
 * ClassName: Order
 * Package: SelfDefine
 * Description:创建于 2025/4/6 16:58
 *
 * @Author lyl
 * @Version 1.0
 */
public class Order<T> {
    T t;
    int anInt;

    public Order () {
    }

    public Order (T t , int anInt) {
        this.t = t;
        this.anInt = anInt;
    }

    public T getT () {
        return t;
    }

    public void setT (T t) {
        this.t = t;
    }

    public int getAnInt () {
        return anInt;
    }

    public void setAnInt (int anInt) {
        this.anInt = anInt;
    }

    @Override
    public String toString () {
        return "Order{" +
                "t=" + t +
                ", anInt=" + anInt +
                '}';
    }

    public static <E> ArrayList<E> fromArrayToList (E[] e) {
        ArrayList<E> list = new ArrayList<>();
        for (E value : e) {
            list.add(value);
        }
        return list;
    }
}
