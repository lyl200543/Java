package ThreadTest;

/**
 * ClassName: ThreadTest.CreatThread2
 * Package: PACKAGE_NAME
 * Description:创建于 2025/3/31 11:56
 *
 * @Author lyl
 * @Version 1.0
 */
public class CreatThread2 {
    public static void main (String[] args) {
        //方式一：
//        ThreadTest.evenNumberPrint t1 = new ThreadTest.evenNumberPrint();
//        Thread thread1 = new Thread(t1);
//        thread1.start();
//
//        for (int i = 0 ; i < 100 ; i++) {
//            if (i % 2 == 0)
//                System.out.println(Thread.currentThread().getName() + ":" + i);
//        }
//
//        //创建另一个线程：
//        Thread thread2 = new Thread(t1);
//        thread2.start();

        //方式二：
        new Thread(new Runnable() {
            @Override
            public void run () {
                for (int i = 0 ; i < 100 ; i++) {
                    if (i % 2 == 0)
                        System.out.println(Thread.currentThread().getName() + ":" + i);
                }
            }
        }).start();

        for (int i = 0 ; i < 100 ; i++) {
            if (i % 2 == 0)
                System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}

class evenNumberPrint implements Runnable {
    @Override
    public void run () {
        for (int i = 0 ; i < 100 ; i++) {
            if (i % 2 == 0)
                System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}