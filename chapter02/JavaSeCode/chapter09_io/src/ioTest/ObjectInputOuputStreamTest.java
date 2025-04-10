package ioTest;

import org.junit.Test;

import java.io.*;

/**
 * ClassName: ObjectInputOuputStreamTest
 * Package: ioTest
 * Description:创建于 2025/4/10 14:00
 *
 * @Author lyl
 * @Version 1.0
 */
public class ObjectInputOuputStreamTest {
    @Test
    public void test1 () throws IOException {
        File file = new File("object.txt");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(new Person("Tom" , 19 , new Account(19000)));
        oos.flush();
        oos.close();
    }

    @Test
    public void test2 () throws IOException, ClassNotFoundException {
        File file = new File("object.txt");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        Person person = (Person) ois.readObject();
        System.out.println(person);
        ois.close();
    }
}

class Person implements Serializable {
    transient private String name;
    static private int age;
    private Account account;

    private static final long serialVersionUID = - 684974667710L;

    public Person () {
    }

    public Person (String name , int age) {
        this.name = name;
        this.age = age;
    }

    public Person (String name , int age , Account account) {
        this.name = name;
        this.age = age;
        this.account = account;
    }

    @Override
    public String toString () {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", account=" + account +
                '}';
    }
}

class Account implements Serializable  {
    private double balance;
    private static final long serialVersionUID = - 684667710L;

    public Account (double balance) {
        this.balance = balance;
    }

    @Override
    public String toString () {
        return "Account{" +
                "balance=" + balance +
                '}';
    }
}