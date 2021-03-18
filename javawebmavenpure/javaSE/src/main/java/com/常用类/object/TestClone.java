package com.常用类.object;


public class TestClone {

    static class Body implements Cloneable{
        public Head head;

        public Body() {}

        public Body(Head head) {this.head = head;}

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

    }
    static class Head /*implements Cloneable*/{
        public  Face face;

        public Head() {}
        public Head(Face face){this.face = face;}

    }

    class Face {
    }

    public static void main(String[] args) throws CloneNotSupportedException {

        Person p = new Person(23, "zhang");
        Person p1 = p;
        Person p2 = (Person) p.clone();

        System.out.println(p);
        System.out.println(p1);
        System.out.println(p2);

//        ----------------------------------------------------------------------
       String result = p.getName() == p2.getName() ? "clone是浅拷贝的" : "clone是深拷贝的";
        System.out.println(result); //clone方法执行的是浅拷贝

        Body body = new Body(new Head());

        Body body1 = (Body) body.clone();

        System.out.println("body == body1 : " + (body == body1) );

        System.out.println("body.head == body1.head : " +  (body.head == body1.head));
    }
}


class Person implements Cloneable {

    private int age;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public Person() {
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return (Person) super.clone();
    }
}

