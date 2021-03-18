package com.fly.lambda;

public class TestLambda2 {

    public static void main(String[] args) {

//        1.lambda表示简化
        ILove love = (int a) -> {
            System.out.println("I Love You -->" + a);
        };
//        简化1.参数类型
        love = (a) -> {
            System.out.println("I Love You -->" + a);
        };
//        简化2。简化圆括号
        love = a -> {
            System.out.println("I Love You -->" + a);
        };
//        简化3。简化花括号（只有一行代码时可用）
        love = a -> System.out.println("I Love You -->" + a);

        love.love(520);
    }
}

interface ILove {
    void love(int a);
}

//class Love implements ILover {
//    @Override
//    public void love(int a) {
//        System.out.println("I Love You -->"+a);
//    }
//}