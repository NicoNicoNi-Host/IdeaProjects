package com.kuangstudy.course.exception;

public class MyException extends Exception {
    //    可以看看已经定义好的异常处理源码怎么写的
    private int detail;//传递数字 >10

    MyException(int a) {
        this.detail = a;
    }

//    异常的打印信息
    public String toString() {
        return "MyException [" + detail + "]";
    }

}

//可能存在异常的方法
class TestMyException {
    static void compute(int a) throws MyException {
        System.out.println("Called compute(" + a + ")");
        if (a > 10) {
            throw new MyException(a);
        }
        System.out.println("Normal exit!");
    }

    public static void main(String[] args) {
        try {
            compute(1);
            compute(20);
        } catch (MyException me) {
            System.out.println("Caught " + me);
        }
    }
}