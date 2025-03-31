package ThreadTest;

/**
 * ClassName: ThreadTest.exer1
 * Package: PACKAGE_NAME
 * Description:创建于 2025/3/31 11:41
 *
 * @Author lyl
 * @Version 1.0
 */
public class exer1 {
    public static void main (String[] args) {
        //方法一：
        EvenPrint e = new EvenPrint();
        SinglePrint s = new SinglePrint();
        e.start();
        s.start();

        //方法二：匿名子类
//        new Thread() {
//            public void run () {
//                for (int i = 1 ; i < 100 ; i++) {
//                    if (i % 2 == 0)
//                        System.out.println(Thread.currentThread().getName() + ":" + i);
//                }
//            }
//        }.start();
//        new Thread() {
//            public void run () {
//                for (int i = 1 ; i < 100 ; i++) {
//                    if (i % 2 != 0)
//                        System.out.println(Thread.currentThread().getName() + ":" + i);
//                }
//            }
//        }.start();
    }
}

class EvenPrint extends Thread {
    @Override
    public void run () {
        for (int i = 1 ; i < 100 ; i++) {
            if (i % 2 == 0)
                System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}

class SinglePrint extends Thread {
    @Override
    public void run () {
        for (int i = 1 ; i < 100 ; i++) {
            if (i % 2 != 0)
                System.out.println(Thread.currentThread().getName() + ":" + i);

        }
    }
}
