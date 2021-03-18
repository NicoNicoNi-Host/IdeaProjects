package com.kuangstudy.course.OOP.Demo3;

public class Person_1 {

    String name;

    //实例化初始的
//1. 使用new关键字,本质是在调用构造器
//1. 用来初始化值
    public Person_1(){
        this.name="明";
    }

    //有参构造：一旦定义了有参构造,无参就必须显式定义
    public Person_1(String name){
        this.name = name;

    }

}
