package com.kuangstudy.course.method;

public class Demo4 {

    //    【演示：利用代码计算5的乘阶！】
    public static void main(String[] args) {

        System.out.println(jc(5));
        System.out.println(jcc(5));
    }

    public static int jcc(int i) {
        int result = 1;
        if(i>0)
        result= i*jcc(i-1);

        return result;
    }


    public static int jc(int i) {
        int result = 1;
        if (i != 1) {
            result = i * jc(i - 1);//也可以result = i*jc(--i);
        }
        return result;
    }

    //在递的过程中，result一直为1，归的过程中，result的值一层层增加
    //5*f(4) -> 5*4*f(3) -> 5*4*3*f(2) -> 5*4*3*2*f(1)-> 5*4*3*2*1
    public static int f(int n) {
        if (1 == n)
            return 1;
        else
            return n * f(n - 1);
    }
}
