package ThreadTest;

/**
 * ClassName: ThreadTest.CreatThread1
 * Package: PACKAGE_NAME
 * Description:创建于 2025/3/31 11:33
 *
 * @Author lyl
 * @Version 1.0
 */
public class CreatThread1 {
    public static void main (String[] args) {
        PrintThread p = new PrintThread();
        p.setPriority(1);
        p.start();
        //p.start();  //出现异常：IllegalThreadStateException
        Thread.currentThread().setPriority(10);
        for (int i = 1 ; i <= 100 ; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
//            if (i % 20 == 0) {
//                try {
//                    p.join();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
        }
        System.out.println(p.isAlive());
    }
}

class PrintThread extends Thread {
    @Override
    public void run () {
        for (int i = 0 ; i < 100 ; i++) {
            if (i % 2 == 0)
                System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}