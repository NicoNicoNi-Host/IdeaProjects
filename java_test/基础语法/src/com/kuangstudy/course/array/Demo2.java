package com.kuangstudy.course.array;


import java.util.Arrays;

public class Demo2 {
public static void main(String[] args) {
    double[] myList = {1.9, 2.9, 9.1, 3.4, 3.5};

    printArray(myList);
    printSum(myList);
    printMax(myList);
    printArray(reverse(myList));
}

// 打印所有数组元素
private static void printArray(double[] array) {
    for (double v : array) {
        System.out.print(v + " ");
    }
    System.out.println();
}

// 计算所有元素的总和
private static void printSum(double[] array) {
    double sum = 0;
    for (double v : array) {
        sum += v;
    }
    System.out.println(sum);
}

public static void printMax(double... numbers) {
    if (numbers.length == 0) {
        System.out.println("No argument passed");
        return;
    }
    double result = numbers[0];
//排序！
    for (int i = 1; i < numbers.length; i++) {
        if (numbers[i] > result) {
            result = numbers[i];
        }
    }
    System.out.println("The max value is " + result);
}


//3、数组作返回值:反转数组
public static double[] reverse(double... list) {
    double[] result = new double[list.length];
    for (int i = 0, j = result.length - 1; i < list.length; i++, j--) {
        result[j] = list[i];
    }
    return result;
}

// 打印所有数组元素
// 计算所有元素的总和
// 查找最大元素
//3、数组作返回值:反转数组
//数组作方法入参:打印 int 数组中元素

    //for循环
    public static void test_1() {
        double[] myList = {1.9, 2.9, 3.4, 3.5};
// 打印所有数组元素
        for (int i = 0; i < myList.length; i++) {
            System.out.println(myList[i] + " ");
        }
// 计算所有元素的总和
        double total = 0;
        for (int i = 0; i < myList.length; i++) {
            total += myList[i];
        }
        System.out.println("Total is " + total);
// 查找最大元素
        double max = myList[0];
        for (int i = 1; i < myList.length; i++) {
            if (myList[i] > max) {
                max = myList[i];
            }
        }
        System.out.println("Max is " + max);
    }
}
