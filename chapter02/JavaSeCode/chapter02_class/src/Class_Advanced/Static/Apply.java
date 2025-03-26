package Class_Advanced.Static;

/**
 * ClassName: Apply
 * Package: Class_Advanced.Static
 * Description:创建于 2025/3/23 20:04
 *
 * @Author lyl
 * @Version 1.0
 */
public class Apply {
    public static void main (String[] args) {
        Circle c1=new Circle();
        System.out.println(c1);
        Circle c2=new Circle();
        System.out.println(c2);
        Circle c3=new Circle(2.3);
        System.out.println(c3);
    }
}

class Circle{
    private double radius;
    private int id;
    private static int total;
//    private static int init=(int)(Math.random()*101);
    private static int init=1001;
    public Circle(){
        id=init;
        init++;
        total++;
    }
    public Circle(double radius){
        this();
        this.radius=radius;
    }

    @Override
    public String toString () {
        return "Circle{" +
                "radius=" + radius +
                ", id=" + id +
                '}';
    }
}