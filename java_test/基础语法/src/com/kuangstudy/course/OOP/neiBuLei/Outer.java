package com.kuangstudy.course.OOP.neiBuLei;

public class Outer {
    private int id;//默认初始化0

    public void out() {
        System.out.println("这是外部类方法");
    }

    //【定义一个内部类】
    class Inner {
        private int id=8; //这个id跟外部类的属性id名称一样。
        public void in() {
            System.out.println("这是内部类方法");
        }

        //内部类访问外部类私有的成员变量
        public void useId() {
            System.out.println(id + 3);
        }

        //内部类访问外部类的方法
        public void useOut() {
            out();
        }

        public void test(){
            System.out.println(id);//输出8，内部类中的变量会暂时将外部类的成员变量给隐藏

//如何调用外部类的成员变量呢？通过Outer.this，想要知道为什么能通过这个来调用，就得明白下面这个原理
//想实例化内部类对象，就必须通过外部类对象，当外部类对象来new出内部类对象时，
// 会把自己(外部类对象)的引用传到了内部类中，所以内部类就可以通过Outer.this来访问外部类的属性和方法，
// 到这里，你也就可以知道为什么内部类可以访问外部类的属性和方法，
// 这里由于有两个相同的属性名称，所以需要显示的用Outer.this来调用外部类的属性，
// 平常如果属性名不重复，那么我们在内部类中调用外部类的属性和方法时，前面就隐式的调用了Outer.this。

            System.out.println(Outer.this.id);//输出外部类的属性id。也就是输出0
        }

    }





    public static void main(String[] args) {
        //    【实例化内部类】
//实例化成员内部类分两步
//1、实例化外部类
        Outer outObject = new Outer();
//2、通过外部类调用内部类
        Outer.Inner inObject = outObject.new Inner();
//测试，调用内部类中的方法
        inObject.in();//打印：这是内部类方法


        //测试
        inObject.useId();//打印3，因为id初始化值为0，0+3就为3，其中在内部类就使用了外部类的私有成员变量id
        inObject.useOut();//打印：这是外部类方法

        inObject.test();
    }

}
