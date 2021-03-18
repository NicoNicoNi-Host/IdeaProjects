package com.kuangstudy.course;


public class Operator {
//    public static void main(String[] args) {
////        long a = 1231321311231231L;
////        int b = 1213;
////        short c = 10;
////        byte d = 8;
////        System.out.println((a+b+c+d)); //Long类型
////        System.out.println((b + c + d));//Int类型
////        System.out.println((c + d));//Int类型,不同类型混合运算无论是赋值还是运算都是向最高位转,类型转换：byte、short、char用运算符运算后自动转型为int类型
////
////
////        double pow = Math.pow(2, 3);  //Math.pow(2,3); ⌥+回车  intruduce local varible
////        Math.pow(2,3);
//
//        operator();
//    }

    public static void main(String[] args) {
//字符串
        String s1 = "Hello 中文!";
        String s2 = 1 + ""; //转换成String
        System.out.println(s2);
//int
        int c = 12;
        System.out.println("c=" + c);


//        三目条件运算符
        int score = 80;
        String type = score < 60 ? "不及格" : "及格";
        System.out.println("type= " + type);
    /*
1
c=12
type= 及格
        */
    }

    /*
        运算结果
    -1474836480
    -1474836480
    20000000000
        */
    public static void operator() {
        // byte
        System.out.println("基本类型：byte 二进制位数：" + Byte.SIZE);
        System.out.println("包装类：java.lang.Byte");
        System.out.println("最小值：Byte.MIN_VALUE=" + Byte.MIN_VALUE);
        System.out.println("最大值：Byte.MAX_VALUE=" + Byte.MAX_VALUE);
        System.out.println();
// short
        System.out.println("基本类型：short 二进制位数：" + Short.SIZE);
        System.out.println("包装类：java.lang.Short");
        System.out.println("最小值：Short.MIN_VALUE=" + Short.MIN_VALUE);
        System.out.println("最大值：Short.MAX_VALUE=" + Short.MAX_VALUE);
        System.out.println();
// int
        System.out.println("基本类型：int 二进制位数：" + Integer.SIZE);
        System.out.println("包装类：java.lang.Integer");
        System.out.println("最小值：Integer.MIN_VALUE=" + Integer.MIN_VALUE);
        System.out.println("最大值：Integer.MAX_VALUE=" + Integer.MAX_VALUE);
        System.out.println();
// long
        System.out.println("基本类型：long 二进制位数：" + Long.SIZE);
        System.out.println("包装类：java.lang.Long");
        System.out.println("最小值：Long.MIN_VALUE=" + Long.MIN_VALUE);
        System.out.println("最大值：Long.MAX_VALUE=" + Long.MAX_VALUE);
        System.out.println();
// float
        System.out.println("基本类型：float 二进制位数：" + Float.SIZE);
        System.out.println("包装类：java.lang.Float");
        System.out.println("最小值：Float.MIN_VALUE=" + Float.MIN_VALUE);
        System.out.println("最大值：Float.MAX_VALUE=" + Float.MAX_VALUE);
        System.out.println();
// double
        System.out.println("基本类型：double 二进制位数：" + Double.SIZE);
        System.out.println("包装类：java.lang.Double");
        System.out.println("最小值：Double.MIN_VALUE=" + Double.MIN_VALUE);
        System.out.println("最大值：Double.MAX_VALUE=" + Double.MAX_VALUE);
        System.out.println();
// char
        System.out.println("基本类型：char 二进制位数：" + Character.SIZE);
        System.out.println("包装类：java.lang.Character");
// 以数值形式而不是字符形式将Character.MIN_VALUE输出到控制台
        System.out.println("最小值：Character.MIN_VALUE="
                + (int) Character.MIN_VALUE);
// 以数值形式而不是字符形式将Character.MAX_VALUE输出到控制台
        System.out.println("最大值：Character.MAX_VALUE="
                + (int) Character.MAX_VALUE);
    }


}
