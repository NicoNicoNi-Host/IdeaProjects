package com.kuangstudy.course.method;

public class Demo2 {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            System.out.println("args[" + i + "]: " + args[i]);
        }
    }
}

/*
文件目录： /Users/andrew/IdeaProjects/java_test/src/com/kuangstudy/course/method
如果在 .java所在文件目录下直接对文件 javac java会报错；错误: 找不到或无法加载主类 Demo2
需要退几个目录，如src目录，把包名囊括； 可用 ../返回，也可直接输绝对路径

➜  src javac com/kuangstudy/course/method/Demo2.java
➜  src  java com/kuangstudy/course/method/Demo2 this is me  //传参执行
args[0]: this
args[1]: is
args[2]: me

*/
