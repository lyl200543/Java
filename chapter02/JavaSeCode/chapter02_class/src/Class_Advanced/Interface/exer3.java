package Class_Advanced.Interface;

/**
 * ClassName: exer3
 * Package: Class_Advanced.Interface
 * Description:创建于 2025/3/26 16:38
 *
 * @Author lyl
 * @Version 1.0
 */
public class exer3 {
    public static void main (String[] args) {
        Developer developer =new Developer();
        Vehicle[] vehicles =new Vehicle[3];
        vehicles[0]=new Bicycle("捷安特","蓝色");
        vehicles[1]=new ElectricVehicle("雅迪","白色");
        vehicles[2]=new Car("奔驰","黑色","88888");
        for(int i=0;i<vehicles.length;i++){
            developer.takintVehicle(vehicles[i]);
            if(vehicles[i] instanceof IPower){
                ((IPower) vehicles[i]).power();
            }
        }
    }
}

abstract class Vehicle{
    private String brand;
    private String color;

    public abstract void run();

    public Vehicle () {
    }

    public Vehicle (String brand , String color) {
        this.brand = brand;
        this.color = color;
    }

    public String getBrand () {
        return brand;
    }

    public void setBrand (String brand) {
        this.brand = brand;
    }

    public String getColor () {
        return color;
    }

    public void setColor (String color) {
        this.color = color;
    }
}

class Bicycle extends Vehicle{
    @Override
    public void run () {
        System.out.println("骑自行车");
    }

    public Bicycle () {
    }

    public Bicycle (String brand , String color) {
        super(brand , color);
    }
}

class ElectricVehicle extends Vehicle implements IPower{
    @Override
    public void run () {
        System.out.println("驾驶电车");
    }

    @Override
    public void power () {
        System.out.println("消耗电能");
    }

    public ElectricVehicle () {
    }

    public ElectricVehicle (String brand , String color) {
        super(brand , color);
    }
}

class Car extends Vehicle implements IPower {
    private String carNumber;
    @Override
    public void run () {
        System.out.println("驾驶汽车");
    }

    @Override
    public void power () {
        System.out.println("消耗燃料");
    }

    public Car () {
    }

    public Car (String brand , String color , String carNumber) {
        super(brand , color);
        this.carNumber = carNumber;
    }

    public String getCarNumber () {
        return carNumber;
    }

    public void setCarNumber (String carNumber) {
        this.carNumber = carNumber;
    }
}
class Developer{
    private String name;
    private int age;

    void takintVehicle(Vehicle vehicle){
        vehicle.run();
    }

    public Developer () {
    }

    public Developer (String name , int age) {
        this.name = name;
        this.age = age;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public int getAge () {
        return age;
    }

    public void setAge (int age) {
        this.age = age;
    }
}

interface IPower{
    void power();
}