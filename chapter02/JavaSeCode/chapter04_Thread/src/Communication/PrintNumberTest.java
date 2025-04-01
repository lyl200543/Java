package Communication;

/**
 * ClassName: PrintNumberTest
 * Package: Communication
 * Description:创建于 2025/4/1 21:30
 * 创建两个线程交替打印1到100的数字
 *
 * @Author lyl
 * @Version 1.0
 */
public class PrintNumberTest {
    public static void main (String[] args) {
        PrintNumber p = new PrintNumber();
        Thread t1 = new Thread(p , "线程1");
        Thread t2 = new Thread(p , "线程2");

        t1.start();
        t2.start();
    }
}

class PrintNumber implements Runnable {
    private static int number = 1;

    @Override
    public void run () {
        while (true) {
            synchronized (this) {
                //唤醒
                this.notify();

                if (number <= 100) {
                    System.out.println(Thread.currentThread().getName() + ":" + number);
                    number++;

                    //等待
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else
                    break;
            }
        }
    }
}