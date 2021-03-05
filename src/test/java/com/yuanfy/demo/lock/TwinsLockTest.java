package com.yuanfy.demo.lock;

import org.junit.Test;

import java.util.concurrent.locks.Lock;

/**
 * @author maple.yuan
 * @date 2020-03-08 10:08
 */
public class TwinsLockTest {

   public static void main(String[] args) throws InterruptedException {
        final Lock lock = new TwinsLock();
        class Worker extends Thread {
            @Override
            public void run() {
                while(true) {
                    lock.lock();
                    try {
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName());
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }
            }
        }

        for (int i = 0; i < 10; i ++) {
            Worker w = new Worker();
            w.setDaemon(true);
            w.start();
        }

        for (int i = 0; i < 10; i ++) {
            Thread.sleep(1000);
            System.out.println();
        }
    }
}
