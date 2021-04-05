package com.yuanfy.demo.thread;

/**
 * @author maple.yuan
 * @date 2021-04-05 16:56
 */
public class ThreadPollPrintTest {

    static volatile int count = 2;
    static final Object lock = new Object();

    public static void main(String[] args) {
        Thread threadA = new Thread(() -> {
            try {
                synchronized (lock) {
                    while (true) {
                        while (count != 0) {
                            lock.wait();
                        }
                        count = 1;
                        System.out.println("A");
                        lock.notifyAll();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Thread threadB = new Thread(() -> {
            try {
                synchronized (lock) {
                    while (true) {
                        while (count != 1) {
                            lock.wait();
                        }
                        count = 2;
                        System.out.println("B");
                        lock.notifyAll();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Thread threadC = new Thread(() -> {
            try {
                synchronized (lock) {
                    while (true) {
                        while (count != 2) {
                            lock.wait();
                        }
                        count = 0;
                        System.out.println("C");
                        lock.notifyAll();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();
    }

}
