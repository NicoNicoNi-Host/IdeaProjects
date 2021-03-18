package com.kuangstudy.course.exception;

public class Demo1 {

    public static void main(String[] args) {

        new Demo1().test1();
        new Demo1().test2();
    }


    public void test1() {
        int a = 1;
        int b = 0;
        try { // try监控区域
            if (b == 0) throw new ArithmeticException(); // 通过throw语句抛出异常
            System.out.println("a/b的值是：" + a / b);
            System.out.println("this will not be printed!");
        } catch (ArithmeticException e) { // catch捕捉异常 括号内为想要捕获的异常类型，最高级为Throwable
            System.out.println("程序出现异常，变量b不能为0！" + e);

            e.printStackTrace();//打印错误栈信息
        } catch (Throwable e) {
            System.out.println("最高级的写在最下面" + e);
        } finally {//finally 处理善后工作,如IO资源关闭，可以不要
            System.out.println("程序正常结束。");
        }
    }

    //假设这方法中,处理不了这个异常。方法上抛出异常 方法头throws，方法体throw
    public static void test2() throws NullPointerException {
        try {
            throw new NullPointerException("demo");//主动的地出异常,一般在方法中使用

        } catch (NullPointerException e) {
            System.out.println("Caught inside proc");
            throw e;
        }
    }


}
