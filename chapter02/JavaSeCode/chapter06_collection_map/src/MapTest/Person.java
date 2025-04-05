package MapTest;

import java.util.Objects;

class Person implements Comparable {
    private String name;
    private int age;

    public Person () {
    }

    public Person (String name , int age) {
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

    @Override
    public String toString () {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public final boolean equals (Object o) {
        if (! (o instanceof Person person)) return false;

        return age == person.age && Objects.equals(name , person.name);
    }

    @Override
    public int hashCode () {
        int result = Objects.hashCode(name);
        result = 31 * result + age;
        return result;
    }

    @Override
    public int compareTo (Object o) {
        if (this == o)
            return 0;
        if (o instanceof Person) {
            Person p = (Person) o;
            int value = this.age - p.age;
            if (value != 0)
                return value;
            return this.name.compareTo(p.name);
        }
        throw new RuntimeException("类型不匹配");
    }
}