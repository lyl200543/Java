package Class_Improvement.Super;

/**
 * ClassName: interview
 * Package: Class_Improvement.Super
 * Description:创建于 2025/3/23 10:38
 *
 * @Author lyl
 * @Version 1.0
 */

//就近原则：
public class interview {
    public static void main (String[] args) {
        Father f = new Father();
        Son s = new Son();
        System.out.println(f.getInfo());
        System.out.println(s.getInfo());
        s.test();
        System.out.println("-----------------");
        s.setInfo("大硅谷");
        System.out.println(f.getInfo());
        System.out.println(s.getInfo());
        s.test();
    }
}

class Father{
    private String info = "atguigu";
    public void setInfo(String info) {
        this.info = info;
    }
    public String getInfo() {
        return info;
    }
}

class Son extends Father{
    private String info = "尚硅谷";

    public void test(){
        System.out.println(this.getInfo());
        System.out.println(super.getInfo());
    }

//    @Override
//    public String getInfo () {
//        return info;
//    }
//
//    @Override
//    public void setInfo (String info) {
//        this.info = info;
//    }
}



