package jvm.methodInvoke;

import java.util.Random;

public class StaticDispatch {

    static abstract class Human {

    }

    static class Woman extends Human{

    }

    static class Man extends Human {

    }

    public void sayHello(Human human) {
        System.out.println("hello guy");
    }

    public void sayHello(Man man) {
        System.out.println("hello man");
    }

    public void sayHello(Woman woman) {
        System.out.println("hello lady");
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();

        StaticDispatch staticDispatch = new StaticDispatch();
        staticDispatch.sayHello(man);
        staticDispatch.sayHello(woman);

        Human human = (new Random()).nextBoolean() ? new Man() : new Woman();
        staticDispatch.sayHello((Man) human);
        staticDispatch.sayHello((Woman) human);
    }


}
