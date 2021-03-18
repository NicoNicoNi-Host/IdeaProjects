package com.kuangstudy.course.OOP.instance1of;

public class ex {

    public static void main(String[] args) {
        //类型之间的转化:父   子

//    高             低
        Person p = new Student();
//        p.go();//编译报错,因为p声明的类型Person中没有go方法
//子类转换为父类,可能丢失自己的本来的些方法


        //需要把变量p的类型进行转换 父转子，强制转换
        Student s = (Student) p;
        s.go();


//注意这种形式前面必须要俩个小括号
        ((Student) p).go();


    }
}


class Person {
    public void run() {
        System.out.println("run");
    }
}

class Student extends Person {
    public void go() {
        System.out.println("go");
    }
}

class Teacher extends Person {
}