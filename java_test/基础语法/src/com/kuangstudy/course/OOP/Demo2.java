package com.kuangstudy.course.OOP;

public class Demo2 {

    //引用传递
    public static void main(String[] args) {
        Student student = new Student();
        System.out.println("before: name = " + student.name); //null
        changeName(student);
        System.out.println("after: name = " + student.name); //tom
    }

    public static void changeName(Student student) {
//student是一个对象:指向的---> Student student = new Student();这是一个具体的人，可以改变属性!
        student.name = "tom";
    }
}

class Student {
    String name;
}