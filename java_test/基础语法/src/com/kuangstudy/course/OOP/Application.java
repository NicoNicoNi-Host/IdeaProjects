package com.kuangstudy.course.OOP;

import javax.sound.sampled.Line;

public class Application {

    public static void main(String[] args) {

        //Student 能调用的方法都是自己的或者继承父类的!
        Student_2 s1 = new Student_2();
        //person 父类型,可以指向子类，但是不能调用子类独有的方法
        Person s2 = new Student_2();
        Object s3 = new Student_2();

        s1.eat();
        //对象能执行哪些方法,主要看对象左边的类型
        ((Student_2) s2).eat();// 子类重写了父类的方法,执行了类的方法


    }

}


class Person {
    public void run() {
        System.out.println("run");
    }

}

class Student_2 extends Person {
    @Override
    public void run() {
        super.run();
    }

    public void eat() {
        System.out.println("eat");
    }
}