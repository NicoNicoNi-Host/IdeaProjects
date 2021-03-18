package com.kuangstudy.course;

import java.util.Scanner;

public class Hello {
    String str;
    int age;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入狂神：");
        String name=scanner.next();
        switch (name) { //JDK7的新特性，表达式结果可以是字符串！！！
            case "秦疆":
                System.out.println("输入为秦疆");
                break;
            case "狂神":
                System.out.println("输入为狂神");
                break;
            default:
                System.out.println("弄啥嘞！");
                break;
        }

        scanner.close();

    }
}

/*






 * */

