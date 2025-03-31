package ThreadTest;

/**
 * ClassName: ThreadTest.ThreadStructure
 * Package: PACKAGE_NAME
 * Description:创建于 2025/3/31 18:54
 *
 * @Author lyl
 * @Version 1.0
 */
public class ThreadStructure {
    public static void main (String[] args) {

        new Thread("线程1") {
            @Override
            public void run () {
                for (int i = 0 ; i < 100 ; i++) {
//                    try {
//                        sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    System.out.println(Thread.currentThread().getName() + ":" + i);
//                    if (i % 20 == 0)
//                        Thread.yield();
                }
            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run () {
                for (int i = 0 ; i < 100 ; i++) {
                    System.out.println(Thread.currentThread().getName() + ":" + i);
                }
            }
        } , "线程2").start();
    }
}

