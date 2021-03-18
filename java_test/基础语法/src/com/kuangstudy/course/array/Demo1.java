package com.kuangstudy.course.array;

public class Demo1 {

    public static void main(String[] args) {
//        静态初始化：创建+赋值
        int[] a1 = {1, 2, 3};

//        动态初始化：包含默认初始化
        int[] a2 = new int[2];
        a2[0] = 1;
        a2[1] = 2;

//        数组的默认初始化
        int[] a = new int[2];
        boolean[] b = new boolean[2];
        String[] s = new String[2];
        System.out.println(a[0] + ":" + a[1]); //0,0
        System.out.println(b[0] + ":" + b[1]); //false,false
        System.out.println(s[0] + ":" + s[1]); //null, null
    }

}
