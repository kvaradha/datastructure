package com.java.basics;

/**
 * Inner Class Example.
 *
 * @author - Karthikeyan
 */
public class InnerClass {

    public class InnerClassExample {
        public void print(){
            System.out.println("I am in inner class example.");
        }
    }

    public void print() {
        System.out.println("I am in Inner class.");
    }

    public static void main(String []args) {
        InnerClass i = new InnerClass();
        i.print();
        // inner class requires instance of parent.
        InnerClass.InnerClassExample innerClassExample = i.new InnerClassExample();
        innerClassExample.print();
    }
}
