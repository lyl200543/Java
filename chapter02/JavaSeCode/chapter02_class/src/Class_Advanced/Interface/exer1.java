package Class_Advanced.Interface;

/**
 * ClassName: exer1
 * Package: Class_Advanced.Interface
 * Description:创建于 2025/3/26 15:19
 * 声明接口Eatable，包含抽象方法public abstract void eat()
 * 声明实现类中国人Chinese，重写抽象方法，打印用筷子吃饭
 * 声明实现类美国人American，重写抽象方法，打印用刀叉吃饭
 * 声明实现类印度人Indian，重写抽象方法，打印用手抓饭
 * 声明测试类EatableTest，创建Eatable数组，存储各国人对象，并遍历数组，调用eat()方法
 * @Author lyl
 * @Version 1.0
 */
public class exer1 {
    public static void main (String[] args) {
        Eatable[] e =new Eatable[3];
        e[0]=new Chinese();
        e[1]=new American();
        e[2]=new Indian();
        for(int i=0;i<e.length;i++){
            e[i].eat();
        }
    }
}

interface Eatable{
    public abstract void eat();
}

class Chinese implements Eatable{
    @Override
    public void eat () {
        System.out.println("用筷子吃饭");
    }
}

class American implements Eatable{
    @Override
    public void eat () {
        System.out.println("用刀叉吃饭");
    }
}

class Indian implements Eatable{
    @Override
    public void eat () {
        System.out.println("用手抓饭");
    }
}

