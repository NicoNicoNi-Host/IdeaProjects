package com.kuangstudy.course.array;

import java.util.Arrays;
import java.util.List;
//import java.util.DualPivotQuicksort;


public class Demo3 {
/*//1、打印数组
        int[] a = {1, 2, 34, 56, 12, 9};
        System.out.println(a); //[I@1b6d3586
        System.out.println(Arrays.toString(a)); //[1, 2]

//2、数组排序
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));

//3、二分法查找
        Arrays.sort(a); //使用二分法查找，必须先对数组进行排序
        System.out.println("该元素的索引：" + Arrays.binarySearch(a, 12));

//4、元素填充
        Arrays.fill(a, 2, 4, 100); //将2到4索引的元素替换为100
        System.out.println(Arrays.toString(a));

//5、数组转换为List集合
        List<int[]> list = Arrays.asList(a);*/

public static void main(String[] args) {
    int[] a = {2, 5, 1, 6, 4, 9, 8, 5, 3, 1, 2, 0};
    Bubble bubble = new Bubble();
    int[] sort = bubble.sort(a);
    System.out.println(Arrays.toString(sort));


    int[] select = new SelectSort().sort(a);
    System.out.println(Arrays.toString(select));
}

static class Bubble {
    public int[] sort(int[] array) {
        int temp = 0;
// 外层循环，它决定一共走几趟 //-1为了防止溢出
        for (int i = 0; i < array.length - 1; i++) {
            int flag = 0; //通过符号位可以减少无谓的比较，如果已经有序了，就退出循环
//内层循环，它决定每趟走一次
            for (int j = 0; j < array.length - i - 1; j++) {
//如果后一个大于前一个,则换位
                if (array[j + 1] > array[j]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag = 1;
                }
            }
            if (flag == 0) {
                break;
            }
        }
        return array;
    }
}

static class SelectSort {
    public int[] sort(int arr[]) {
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {// 认为目前的数就是最小的, 记录最小数的下标
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {// 修改最小值的下标
                    minIndex = j;
                }
            }// 当退出for就找到这次的最小值,就需要交换位置了
            if (i != minIndex) {//交换当前值和找到的最小值的位置
                temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
        return arr;
    }
}

    //    源代码
    /*
    //1、打印数组
    public static String toString(int[] a) {
        if (a == null)
            return "null";
        int iMax = a.length - 1;
        if (iMax == -1)
            return "[]";

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; ; i++) {
            b.append(a[i]);
            if (i == iMax)
                return b.append(']').toString();
            b.append(", ");
        }
    }

    //2、数组排序
    public static void sort(int[] a) {
        DualPivotQuicksort.sort(a, 0, a.length - 1, null, 0, 0);
    }

    //3、二分法查找
    public static int binarySearch(int[] a, int key) {
        return binarySearch0(a, 0, a.length, key);
    }

    //4、元素填充
    public static void fill(int[] a, int fromIndex, int toIndex, int val) {
        rangeCheck(a.length, fromIndex, toIndex);
        for (int i = fromIndex; i < toIndex; i++)
            a[i] = val;
    }

    //5、数组转换为List集合
    public static <T> List<T> asList(T... a) {
        return new Arrays.ArrayList<>(a);
    }

*/

}