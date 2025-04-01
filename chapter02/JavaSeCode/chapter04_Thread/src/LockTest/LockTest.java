package LockTest;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ClassName: LockTest
 * Package: LockTest
 * Description:创建于 2025/4/1 20:59
 *
 * @Author lyl
 * @Version 1.0
 */
public class LockTest {
    public static void main (String[] args) {
        Window w1 = new Window();
        Window w2 = new Window();
        Window w3 = new Window();

        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");

        w1.start();
        w2.start();
        w3.start();

    }
}

class Window extends Thread {
    static int ticket = 100;
    private static final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run () {
        while (true) {
            try {
                lock.lock();
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + "成功售票，票号为" + ticket);
                    ticket--;
                } else
                    break;
            } finally {  //确保一定执行
                lock.unlock();
            }
        }
    }
}

