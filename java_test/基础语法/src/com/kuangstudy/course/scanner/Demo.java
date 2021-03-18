package com.kuangstudy.course.scanner;

import java.util.Scanner;

public class Demo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        double j = 0.0;
        System.out.println("请输入整数：");
        if (scanner.hasNextInt()) {
            i = scanner.nextInt();
            System.out.println("您输入的是：" + i);
        } else {
            System.out.println("输入错误");
        }

        System.out.println("请输入浮点数：");
        if (scanner.hasNextDouble()) {
            j = scanner.nextDouble();
            System.out.println("您输入的是：" + j);
        } else {
            System.out.println("输入错误");
        }
        scanner.close();

    }
}
