package ThreadSafe;

/**
 * ClassName: TicketTest1
 * Package: ThreadSafe
 * Description:创建于 2025/3/31 21:39
 *
 * @Author lyl
 * @Version 1.0
 */
//实现接口方式：

public class TicketTest1 {
    public static void main (String[] args) {
        SellTicket1 s = new SellTicket();
        Thread t1 = new Thread(s);
        t1.setName("窗口1");
        Thread t2 = new Thread(s);
        t2.setName("窗口2");
        Thread t3 = new Thread(s);
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();


    }
}

class SellTicket1 implements Runnable {
    private int ticket = 100;

    @Override
    public void run () {
        while (true) {

            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + "售票成功，票号为" + ticket);
                ticket--;
            } else
                break;

        }
    }
}
