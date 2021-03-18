package com.kuangstudy.course.OOP.xiushifu;

public abstract class CouXiang {
    //约束 有人帮我们实现
//abstract ,抽象方法,只有方法名字,没有方法的实现
    public abstract void doSomething();

}

//1.不能ew这个抽象类,只能靠子类去实现它;约束
//2.抽象类中可以写普通的方法
//3.抽象方法必须在抽象类中

class A extends CouXiang {
    //必须重写父类抽象方法，否则编译器报错
    @Override
    public void doSomething() {

    }
}
//对于这个普通方法来讲:
//        "public void doSomething()"这部分是方法的声明
//        "{...}"这部分是方法的实现,如果大括号中什么都没写,就叫方法的空实现
//        声明类的同时,加上abstract修饰符就是抽象类
//        声明方法的时候,加上abstract修饰符,并且去掉方法的大口号,同时结尾加上分号,该方法就是抽象方法。


