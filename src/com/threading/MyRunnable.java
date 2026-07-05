package com.threading;

/**
 * My Runnable - Implementing Runnable.
 *
 * @author Karthikeyan
 */
public class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Runnable Thread");
    }

    public static void main(String []args) {
        // Cons: Create the instance first and assign it to the thread instance.
        // Pros: Perfectly fit for Executor service.
        // Pros: You can extends other business logic class. Since this is just implementing runnable.
        // Pros: Perfectly fit for lambda expressions.
        MyRunnable runnable = new MyRunnable();
        Thread t1= new Thread(runnable);
        t1.start();
        Thread t2 = new Thread(runnable);
        t2.start();
    }
}
