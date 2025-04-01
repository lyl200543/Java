package ThreadSafe;

/**
 * ClassName: TicketTest
 * Package: ThreadSafe
 * Description:创建于 2025/3/31 20:10
 *
 * @Author lyl
 * @Version 1.0
 */
//实现接口方式：

//public class TicketTest {
//    public static void main (String[] args) {
//        SellTicket s = new SellTicket();
//        Thread t1 = new Thread(s);
//        t1.setName("窗口1");
//        Thread t2 = new Thread(s);
//        t2.setName("窗口2");
//        Thread t3 = new Thread(s);
//        t3.setName("窗口3");
//
//        t1.start();
//        t2.start();
//        t3.start();
//
//
//    }
//}
//
//class SellTicket implements Runnable {
//    private int ticket = 100;
//
//    @Override
//    public void run () {
//        //不能将while(true)包裹在内，否则出现一个线程执行到底的情况
//        while (true) {
//            synchronized (this) {
//                if (ticket > 0) {
//                    try {
//                        Thread.sleep(10);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println(Thread.currentThread().getName() + "售票成功，票号为" + ticket);
//                    ticket--;
//                } else
//                    break;
//            }
//        }
//    }
//}

//继承Thread类的方式：

public class TicketTest {
    public static void main (String[] args) {
        Window1 w1 = new Window1();
        Window1 w2 = new Window1();
        Window1 w3 = new Window1();

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

    @Override
    public void run () {
        while (true) {
            synchronized (Window1.class) {  //同步检测器知识涉及反射
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + "成功售票，票号为" + ticket);
                    ticket--;
                } else
                    break;
            }
        }
    }
}
