package Communication;

/**
 * ClassName: TeacherVersion
 * Package: Communication
 * Description:创建于 2025/4/2 13:26
 *
 * @Author lyl
 * @Version 1.0
 */
public class TeacherVersion {
    public static void main (String[] args) {
        Clerk1 clerk = new Clerk1();
        Productor1 productor = new Productor1(clerk);
        Customer1 customer = new Customer1(clerk);

        productor.start();
        customer.start();
    }
}

class Clerk1 {
    private int number = 0;

    public synchronized void AddNumber () {
        if (number >= 20) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            number++;
            System.out.println(Thread.currentThread().getName() + ":" + number);
            notify();
        }

    }

    public synchronized void SubNumber () {
        if (number <= 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            number--;
            System.out.println(Thread.currentThread().getName() + ":" + number);
            notify();
        }

    }

}

class Productor1 extends Thread {
    private Clerk1 clerk;

    public Productor1 (Clerk1 clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run () {
        while (true) {
            clerk.AddNumber();
        }
    }
}

class Customer1 extends Thread {
    private Clerk1 clerk;

    public Customer1 (Clerk1 clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run () {
        while (true) {
            clerk.SubNumber();
        }
    }
}