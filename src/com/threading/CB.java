package com.threading;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Cyclic Barrier Example
 *
 * @author Karthikeyan.
 */
public class CB implements  Runnable {

    CyclicBarrier cyclicBarrier;

    public CB(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                cyclicBarrier.await();
                Thread.sleep(2000);
            }
        } catch (InterruptedException | BrokenBarrierException e) {
            System.err.println("Exception" + e.getCause());
        }
    }

    public static void main(String []args) {
        CyclicBarrier barrier = new CyclicBarrier(3);
        CB cb = new CB(barrier);
        for(int i=0; i<3; i++) {
            new Thread(cb).start();
        }
    }
}
