package com.fly.pojo;

public class Person {
    private String name;
    private int age;
//以下方法均自动生成

    //    无参数构造器
    public Person() {
    }

    //    有参数构造器
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
