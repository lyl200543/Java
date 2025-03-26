package Class_Advanced.Interface;

/**
 * ClassName: exer2
 * Package: Class_Advanced.Interface
 * Description:创建于 2025/3/26 15:19
 * 定义一个接口用来实现两个对象的比较
 * interface Compare0bject{
 * //若返回值是0，代表相等;若为正数，代表当前对象大;负数代表当前对象小
 * public int compareTo(0bject o)
 * 定义-个Circle类，声明radius属性，提供getter和setter方法
 * 定义-个ComparableCircle类，继承Circle类并且实现Compare0bject接口。
 * 在Comparablecircle类中给出接口中方法compareTo的实现体，用来比较两个圆的半径大小。
 * 定义一个测试类InterfaceTest，创建两个ComparableCircle对象，调用compareTo方法比较两个类的半径大小。
 * 拓展:参照上述做法定义矩形类Rectangle和ComparableRectangle类，在ComparableRectangle类中给出compareTo方法的实现，比较两个矩形的面积大小。
 * @Author lyl
 * @Version 1.0
 */
public class exer2 {
    public static void main (String[] args) {
        ComparableCircle c1=new ComparableCircle(10);
        ComparableCircle c2=new ComparableCircle(15);
        int ret=c1.compareTo(c2);
        System.out.println(ret);
    }
}

interface CompareObject{
    public int compareTo(Object o);
}
class Circle{
    private double radius;

    public Circle (double radius) {
        this.radius = radius;
    }

    public Circle () {
    }

    public double getRadius () {
        return radius;
    }

    public void setRadius (double radius) {
        this.radius = radius;
    }
}

class ComparableCircle extends Circle implements CompareObject {
    @Override
    public int compareTo (Object o) {
        if(this==o)
            return 0;
        if(o instanceof ComparableCircle){
            Circle circle = (Circle) o;
            if(getRadius()>circle.getRadius())
                return 1;
            else if(getRadius()<circle.getRadius())
                return -1;
            else
                return 0;
        }
        else
            return 2; //后面知识抛出异常
    }

    public ComparableCircle (double radius) {
        super(radius);
    }

    public ComparableCircle () {
    }
}
