package Class_Advanced.Interface;

/**
 * ClassName: USBTest
 * Package: Class_Advanced.Interface
 * Description:创建于 2025/3/26 15:19
 *
 * @Author lyl
 * @Version 1.0
 */
public class USBTest {
    public static void main (String[] args) {
        Computer computer =new Computer();

        //1.创建接口实现类的对象
        Printer printer =new Printer();
        computer.Connection(printer);
        System.out.println();

        //2.创建接口实现类的匿名对象
        computer.Connection(new Cemera());
        System.out.println();

        //3.创建接口匿名实现类的对象
        USB usb1=new USB(){
            public void start(){
                System.out.println("扫描机开始工作");
            }
            public void stop(){
                System.out.println("扫描机停止工作");
            }
        };
        computer.Connection(usb1);
        System.out.println();

        //4.创建接口匿名实现类的匿名对象
        computer.Connection(new USB(){
            public void start(){
                System.out.println("扫描机开始工作");
            }
            public void stop(){
                System.out.println("扫描机停止工作");
            }
        });
    }
}

interface USB{
    public abstract void start();
    void stop();
}

class Printer implements USB{
    @Override
    public void start () {
        System.out.println("打印机开始工作");
    }

    @Override
    public void stop () {
        System.out.println("打印机结束工作");
    }
}
class Cemera implements USB{
    @Override
    public void start () {
        System.out.println("照相机开始工作");
    }

    @Override
    public void stop () {
        System.out.println("照相机结束工作");
    }
}


class Computer{
    public void Connection(USB usb){
        System.out.println("设备连接中...");
        usb.start();
        System.out.println("数据传输中...");
        usb.stop();
    }
}
