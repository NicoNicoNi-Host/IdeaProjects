package com.kuangstudy.course.OOP.xiushifu;


import com.kuangstudy.course.OOP.Demo4.Person;

//static变量
public class Jingtai {
    private static int age;
    private double score;

    public static void main(String[] args) {
        Jingtai j = new Jingtai();
//推荐使用类名访问静态成员
        System.out.println(Jingtai.age);
//        System.out.println(jingtai.score);/编译报错
        System.out.println(j.age);
        System.out.println(j.score);
    }


    //static方法
    public void run() {
    }

    public static void go() {
    }



    {
//        匿名代码块
        System.out.println("匿名代码块");

    }
   static {
//        静态代码块：加载一些初始化的东西
       System.out.println("静态代码块");//静态先加载，先输出
    }
    public Jingtai(){
        System.out.println("构造方法");
    }
//    输出顺序  ：静态代码块  匿名代码块  构造方法  输出顺序表明加载先后顺序



}


class Student {
    private static int count;
    private int num;

    public void run() {
    }

    public static void go() {
    }

    public static void test() {
//编译通过
        System.out.println(count);
        go();
//编译报错
//        System.out.println(num);
//        run();
    }
}