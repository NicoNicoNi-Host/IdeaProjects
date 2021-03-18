//package com.kuangstudy.course.OOP.instance1of;
//
//public class Instance {
//    public static void main(String[] args) {
//
//        //Object > String
//        //Object > Person > Teacher
//        //Object > Person > Student
//
//        Object obj = new Student();
//        System.out.println(obj instanceof Student);//true
//        System.out.println(obj instanceof Person);//true
//        System.out.println(obj instanceof Object);//true
//        System.out.println(obj instanceof Teacher);//false
//        System.out.println(obj instanceof String);//false
////---------------------------
//        Person per = new Student();
//        System.out.println(per instanceof Student);//true
//        System.out.println(per instanceof Person);//true
//        System.out.println(per instanceof Object);//true
//        System.out.println(per instanceof Teacher);//false
////编译报错 同级关系
////        System.out.println(per instanceof String);
////---------------------------
//        Student stu = new Student();
//        System.out.println(stu instanceof Student);//true
//        System.out.println(stu instanceof Person);//true
//        System.out.println(stu instanceof Object);//true
////编译报错
////        System.out.println(o instanceof Teacher);
////编译报错
////        System.out.println(o instanceof String);
//    }
//}
//
//class Person {
//    public void run() {
//    }
//}
//
//class Student extends Person {
//}
//
//class Teacher extends Person {
//}
//
//
//
