package com.kuangstudy.course.OOP.inter1face;

public interface UserService {
    int AGE = 18;

    public abstract void run();

    //可以看到前两个修饰符是灰色的，默认就是public abstract修饰的， 可以直接 void run();
    void test();

    public void go();


    void add(String name);

    void delete(String name);

    void update(String name);

    void query(String name);

}
