package ThreadSafeMore;

/**
 * ClassName: SingleTon
 * Package: ThreadSafeMore
 * Description:创建于 2025/4/1 15:05
 * 解决懒汉式单例模式的线程安全问题
 *
 * @Author lyl
 * @Version 1.0
 */
public class SingleTon {
    static Bank b1 = null;
    static Bank b2 = null;

    public static void main (String[] args) {
        Thread t1 = new Thread() {
            @Override
            public void run () {
                b1 = Bank.GetInstance();
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run () {
                b2 = Bank.GetInstance();
            }
        };

        t1.start();
        t2.start();

        //要等t1,t2线程完成后再打印，否则地址为null
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b1 == b2);
    }
}

//懒汉式：
class Bank {
    private Bank () {

    }

    private static Bank instance = null;

    //方式1：
//    public static synchronized Bank GetInstance () {
//        if (instance == null) {
//            //使用sleep显现线程问题

    /// /            try {
    /// /                Thread.sleep(1000);
    /// /            } catch (InterruptedException e) {
    /// /                e.printStackTrace();
    /// /            }
//            instance = new Bank();
//        }
//        return instance;
//    }

    //方式2：
//    public static Bank GetInstance () {
//        synchronized (Bank.class) {
//            if (instance == null) {
//                instance = new Bank();
//            }
//            return instance;
//        }
//    }

    //方式3：优化方式2
    public static Bank GetInstance () {
        //使得后面的线程不必在同步代码块前停留
        if (instance==null) {
            synchronized (Bank.class) {
                if (instance == null) {
                    instance = new Bank();
                }
            }
        }
        return instance;
    }

}
