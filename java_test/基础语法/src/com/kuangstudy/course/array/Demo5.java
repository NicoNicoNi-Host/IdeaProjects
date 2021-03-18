package com.kuangstudy.course.array;

public class Demo5 {

    public static void main(String[] args) {

        //创建一个二维数组 11*11
        //0表示没有棋子，1表示黑棋，2表示蓝棋
        int[][] chessArr = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;

        //输出原始的二维数组
        System.out.println("原始的二维数组：");
        printArray(chessArr);

        //将二维数组转换为稀疏数组
        int[][] sparseArr = arr2sparse(chessArr);

        //输出稀疏数组
        System.out.println("稀疏数组：");
        printArray(sparseArr);
//        for (int i = 0; i < sparseArr.length; i++) {
//            System.out.println(sparseArr[i][0] + "\t" + sparseArr[i][1] + "\t" + sparseArr[i][2]);
//        }

        //将稀疏数组恢复成二维数组
        int[][] chessArr2 = sparse2arr(sparseArr);

        //输出稀疏数组 恢复后的二维数组
        System.out.println("恢复后的二维数组：");
        printArray(chessArr2);
    }


    //输出原始的二维数组
    private static void printArray(int[][] chessArr) {

        for (int[] row : chessArr) {//for-Each
            for (int data : row) {
                System.out.print(data + "\t");
            }
            System.out.println();
        }
/*        for (int i = 0; i < chessArr.length; i++) {
            for (int j = 0; j < chessArr[i].length; j++) {
                System.out.print(chessArr[i][j] + "\t");
            }
            System.out.println();
        }*/
    }

    //将二维数组转换为稀疏数组
    public static int[][] arr2sparse(int[][] chessArr) {
//    public static int[][] arr2sparse(int[]... chessArr) {
        //1.先遍历二维数组得到非零数据的个数
        int sum = 0;
        for (int i = 0; i < chessArr.length; i++) {
            for (int j = 0; j < chessArr[i].length; j++) {
                if (chessArr[i][j] != 0) {
                    sum++;
                }
            }
        }

        //2.创建对应的稀疏数组
        int[][] sparseArr = new int[sum + 1][3];
        //给系数数组赋值
        sparseArr[0][0] = chessArr.length;
        sparseArr[0][1] = chessArr[0].length;
        sparseArr[0][2] = sum;
        //遍历二维数组将非零的值存放到稀疏数组
        int count = 0;
        for (int i = 0; i < chessArr.length; i++) {
            for (int j = 0; j < chessArr[i].length; j++) {
                if (chessArr[i][j] != 0) {//行 列 值
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr[i][j];
                }
            }
        }
        return sparseArr;
    }

    //将稀疏数组恢复成二维数组
    public static int[][] sparse2arr(int[][] sparseArr) {
        //1.先读取稀疏数组的第一行，根据第一行创建二维数组
        int[][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];
        //2.读取稀疏数组后几行赋值给二维数组
        //注意这里是从第二行开始
        for (int i = 1; i < sparseArr.length; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        return chessArr2;
    }

}

