package Communication;

/**
 * ClassName: ProductorAndConsumer
 * Package: Communication
 * Description:创建于 2025/4/2 8:37
 * 案例2:生产者&消费者
 * 生产者(Productor)将产品交给店员(Clerk)，而消费者(Customer)从店员处取走产品
 * 店员一次只能持有固定数量的产品(比如:20)，如果生产者试图生产更多的产品
 * 店员会叫生产者停一下，如果店中有空位放产品了再通知生产者继续生产
 * 如果店中没有产品了，店员会告诉消费者等一下，如果店中有产品了再通知消费者来取走产品
 *
 * @Author lyl
 * @Version 1.0
 */
public class ProductorAndCustomer {
    public static void main (String[] args) {
        Clerk clerk = new Clerk();
        Productor productor = new Productor(clerk);
        Customer customer = new Customer(clerk);

        productor.start();
        customer.start();
    }
}

class Clerk {
    int number = 0;

}

class Productor extends Thread {
    private Clerk clerk;

    public Productor (Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run () {
        while (true) {
            synchronized (clerk) {
                if (clerk.number < 20) {
                    try {
                        sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    clerk.number++;
                    clerk.notify();
                    System.out.println(Thread.currentThread().getName() + ":" + clerk.number);
                } else {
                    try {
                        clerk.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }
}

class Customer extends Thread {
    private Clerk clerk;

    public Customer (Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run () {
        while (true) {
            synchronized (clerk) {
                if (clerk.number > 0) {
                    try {
                        sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    clerk.number--;
                    clerk.notify();
                    System.out.println(Thread.currentThread().getName() + ":" + clerk.number);
                } else {
                    try {
                        clerk.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }
}