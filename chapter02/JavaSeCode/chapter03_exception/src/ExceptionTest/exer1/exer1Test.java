package ExceptionTest.exer1;

import org.junit.Test;

/**
 * ClassName: exer1
 * Package: ExceptionTest
 * Description:创建于 2025/3/30 17:23
 * 案例:游戏角色
 * 在一款角色扮演游戏中，每一个人都会有名字和生命值，角色的生命值不能为负数。
 * 要求:当一个人物的生命值为负数的时候需要抛出自定义的异常
 * 操作步骤描述:
 * (1)自定义异常类NoLifeValveException继承RuntimeException①提供空参和有参构造
 * ②在有参构造中，需要调用父类的有参构造，把异常信息传入
 * (2)定义Person类
 * ①属性:名称(name)和生命值(lifeValve)
 * ②提供setter和getter方法:在setLifeValve(int lifeValve)方法中，首先判断，如果 lifeValve为负数,就抛出NoLifeValveException,异常信息为:生命值不能为负数:xx;
 * 然后再给成员lifeValve赋值。
 * ③提供空参构造
 * ④提供有参构造:使用setXxx方法给name和lifeValue赋值
 * (3)定义测试类Exer3
 * 使用满参构造方法创建Person对象，生命值传入一个负数
 * 由于一旦遇到异常,后面的代码的将不在执行,所以需要注释掉上面的代码
 * ② 使用空参构造创建Person对象
 * 调用setLifeValue(int lifeValue)方法,传入一个正数,运行程序
 * 调用setLifeValue(int lifeValue)方法,传入一个负数,运行程序
 * ③ 分别对①和②处理异常和不处理异常进行运行看效果
 *
 * @Author lyl
 * @Version 1.0
 */
public class exer1Test {
    @Test
    public void test1 () {

        try {
            Person person = new Person("zhangsan" , - 10);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2 () {
        try {
            Person person1 = new Person();
            person1.setLifeValve(85);
            Person person2 = new Person();
            person2.setLifeValve(- 45);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
