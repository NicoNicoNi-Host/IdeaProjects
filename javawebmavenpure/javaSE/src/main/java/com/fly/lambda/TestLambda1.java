package com.fly.lambda;

public class TestLambda1 {
//逐步简化

    //3.静态内部类
    static class Like_2 implements ILike {
        public void lambda() {
            System.out.println("I like lambda_2");
        }
    }

    public static void main(String[] args) {
        Like like = new Like();
        like.lambda();

//       静态内部类
        new Like_2().lambda();

//       4.局部内部类
        class Like_3 implements ILike {
            public void lambda() {
                System.out.println("I like lambda_3");
            }
        }
        new Like_3().lambda();

//        5.匿名内部类,没有类的名称,必须借助接口或者父类
        ILike like_4 = new ILike() {
            public void lambda() {
                System.out.println("I like lambda_4");
            }
        };
        like_4.lambda();

//        6.用lambda简化
        ILike like_5= ()-> {
            System.out.println("I like lambda_5");
        };
        like_5.lambda();

    }
}

//1.定义一个函数式接口
interface ILike {
    void lambda();
}

//2.实现类
class Like implements ILike {
    public void lambda() {
        System.out.println("I like lambda");
    }
}