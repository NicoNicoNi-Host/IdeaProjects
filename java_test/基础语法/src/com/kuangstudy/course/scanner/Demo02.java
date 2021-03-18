package com.kuangstudy.course.scanner;

import java.util.Scanner;

public class Demo02 {

    //    以输入多个数字，并求其总和与平均数，每输入一个数字用回车确认，通过输入非数字来结束输入并输出执行结果
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        int i = 0;
//        double sum = 0;
//        while (scanner.hasNextDouble()) {
//            i++;
//            sum += scanner.nextDouble();
//        }
//        System.out.println("数字个数：" + i + "\n" + "sum=" + sum + "\n" + "平均数=" + (sum / i));
//
//        scanner.close();
keyInDouble();

    

    }

    public static void keyInDouble() {

//        变量设置
        double average = 0;
        double sum = 0;
        int i = 0; //计数器
        System.out.println("请输入数字以求总和与平均数，输入非数字结束");

//        IO流
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextDouble()) {
            sum += scanner.nextDouble();
            i++;
        }

        average = sum / (double) i;
        System.out.println("数字个数：" + i + "\n" + "sum=" + sum + "\n" + "平均数=" + (average));

//        关闭IO流
        scanner.close();
    }
}
