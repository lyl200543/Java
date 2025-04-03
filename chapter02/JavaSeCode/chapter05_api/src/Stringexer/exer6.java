package Stringexer;

import java.util.Scanner;

/**
 * ClassName: exer6
 * Package: exer
 * Description:创建于 2025/4/2 19:56
 * 案例:模拟用户登录
 * (1)定义用户类，属性为用户名和密码，提供相关的getter和setter方法，构造器，toString()
 * (2)使用数组存储多个用户对象。
 * (3)录入用户和密码，对比用户信息，匹配成功登录成功，否则登录失败
 * 登录失败时，当用户名错误，提示没有该用户
 * 登录失败时，当密码错误时，提示密码有误。
 *
 * @Author lyl
 * @Version 1.0
 */
public class exer6 {
    public static void main (String[] args) {
        User[] users = new User[3];
        users[0] = new User("zhangsan" , "123456");
        users[1] = new User("wangwu" , "sdfbio");
        users[2] = new User("lisi" , "dsf65g");

        Scanner scanner = new Scanner(System.in);
        System.out.println("*******用户登录*******");
        System.out.print("请输入用户名：");
        String username = scanner.next();
        System.out.print("请输入密码：");
        String password = scanner.next();
        scanner.close();

        int flag = - 1;
        for (int i = 0 ; i < users.length ; i++) {
            if ((users[i].getUsername().equals(username)))
                flag = i;
        }
        if (flag == - 1) {
            System.out.println("登录失败！");
            System.out.println("没有该用户");
        } else {
            if (users[flag].getPassword().equals(password))
                System.out.println("登录成功！");
            else {
                System.out.println("登录失败！");
                System.out.println("密码有误");
            }
        }
    }

}

class User {
    private String username;
    private String password;


    public User () {
    }

    public User (String username , String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername () {
        return username;
    }

    public void setUsername (String username) {
        this.username = username;
    }

    public String getPassword () {
        return password;
    }

    public void setPassword (String password) {
        this.password = password;
    }

    @Override
    public String toString () {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}