package com.kuangstudy.course.scanner;

public class Demo_xunhuan {
    public static void main(String[] args) {

////        1、while 循环
//    while (布尔表达式) {
//    //循环内容
//    }
//
//
////        2、do…while 循环
//    do {
//    //代码语句
//    } while (布尔表达式);
//
//
////        3、For循环
//
//    for (初始化; 布尔表达式; 更新) {
//    //代码语句
//    }


//【练习1：计算0到100之间的奇数和偶数的和】
        int oddSum = 0; //用来保存奇数的和
        int evenSum = 0; //用来存放偶数的和
        for (int i = 0; i <= 100; i++) {
            if (i % 2 != 0) {
                oddSum += i;
            } else {
                evenSum += i;
            }
        }
        System.out.println("奇数的和：" + oddSum);
        System.out.println("偶数的和：" + evenSum);
//【练习2：用while或for循环输出1-1000之间能被5整除的数，并且每行输出3个】

        for (int j = 1; j <= 1000; j++) {
            if (j % 5 == 0) {
                System.out.print(j + "\t");
            }
//            可以加一个counter变量记录一 行有多少个，到3个则复位并换行
            if (j % (5 * 3) == 0) {
                System.out.println();
            }
        }

        System.out.println();
        for (int i = 1; i <= 5; i++) {
            for (int j = 5; j > i; j--) {
                System.out.print(" ");
            }
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            for (int j = 1; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();

        }

/*
1*1=1
1*2=2	2*2=4
1*3=3	2*3=6	3*3=9
1*4=4	2*4=8	3*4=12	4*4=16
1*5=5	2*5=10	3*5=15	4*5=20	5*5=25
1*6=6	2*6=12	3*6=18	4*6=24	5*6=30	6*6=36
1*7=7	2*7=14	3*7=21	4*7=28	5*7=35	6*7=42	7*7=49
1*8=8	2*8=16	3*8=24	4*8=32	5*8=40	6*8=48	7*8=56	8*8=64
1*9=9	2*9=18	3*9=27	4*9=36	5*9=45	6*9=54	7*9=63	8*9=72	9*9=81
*/
        int[] numbers = {10, 20, 30, 40, 50};
        for (int x : numbers) {  //numbers.for快速生成
            System.out.print(x);
            System.out.print(",");
        }
        System.out.print("\n");
        String[] names = {"James", "Larry", "Tom", "Lacy"};
        for (String name : names) {
            System.out.print(name);
            System.out.print(",");
        }


//        练习:打印101-150之间所有的质数

        int count = 0;
        outer:
        for (int i = 101; i < 150; i++) {
            for (int j = 2; j < i / 2; j++) {
                if (i % j == 0)
                    continue outer;
            }
            System.out.print(i + "\t");
        }

        System.out.println();
        for (int i = 1; i <= 5; i++) {
            for (int j = 5; j >= i; j--) {//空格
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {//三角形左半部分+1
                System.out.print("*");
            }
            for (int j = 1; j < i; j++) {//三角形右半部分
                System.out.print("*");
            }
//        for (int j = 1; j <= 2 * i - 1; j++) {//后面两个for循环可以合并
//            System.out.print("*");
//        }

            System.out.println();
        }

    }
}
