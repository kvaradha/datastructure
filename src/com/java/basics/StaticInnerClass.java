package com.java.basics;

/**
 * Static Inner Class.
 *
 * @author Karthikeyan.
 */
public class StaticInnerClass {

    /**
     * Static inner class example.
     */
    public static class StaticInnerClassExample {
        public void print() {
            System.out.println("Static inner class example");
        }
    }

    public void print() {
        System.out.println("Static inner class");
    }

    public static void main(String []args) {
        // static inner class does not requires instance of parent class.
        StaticInnerClass.StaticInnerClassExample staticInnerClassExample = new StaticInnerClass.StaticInnerClassExample();
        staticInnerClassExample.print();
    }
}
