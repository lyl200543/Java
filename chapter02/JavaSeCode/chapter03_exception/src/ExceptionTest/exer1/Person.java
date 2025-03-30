package ExceptionTest.exer1;

/**
 * ClassName: Person
 * Package: ExceptionTest.exer1
 * Description:创建于 2025/3/30 17:37
 * (2)定义Person类
 * ①属性:名称(name)和生命值(lifeValve)
 * ②提供setter和getter方法:在setLifeValve(int lifeValve)方法中
 * 首先判断，如果 lifeValve为负数,就抛出NoLifeValveException,异常信息为:生命值不能为负数:xx;
 * 然后再给成员lifeValve赋值。
 * ③提供空参构造
 * ④提供有参构造:使用setXxx方法给name和lifeValue赋值
 *
 * @Author lyl
 * @Version 1.0
 */
public class Person {
    private String name;
    private int lifeValve;

    public Person () {
    }

    public Person (String name , int lifeValve) {
        setName(name);
        setLifeValve(lifeValve);
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public int getLifeValve () {
        return lifeValve;
    }

    public void setLifeValve (int lifeValve) {
        if (lifeValve <= 0) {
            throw new NoLifeValveException("生命值不能为负数:" + lifeValve);
        } else
            this.lifeValve = lifeValve;
    }
}
