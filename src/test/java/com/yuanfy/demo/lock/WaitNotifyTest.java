package com.yuanfy.demo.lock;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author maple.yuan
 * @date 2021-03-23 09:42
 */
public class WaitNotifyTest {
    private static volatile boolean flag = true;
    private static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread waitObj = new Thread(new WaitObj());
        waitObj.start();

        Thread.sleep(2);

        Thread notifyObj = new Thread(new NotifyObj());
        notifyObj.start();
    }

    static class WaitObj implements Runnable {

        @Override
        public void run() {
            synchronized(lock) {
                while (flag) {
                    System.out.println(Thread.currentThread().getName() + " wait, @" +
                            new SimpleDateFormat("HH:MM:SS").format(new Date()));
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println(Thread.currentThread().getName() + " success, @" +
                        new SimpleDateFormat("HH:MM:SS").format(new Date()));
            }
        }
    }

    static class NotifyObj implements Runnable {

        @Override
        public void run() {
            synchronized(lock) {

                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                lock.notify();

                System.out.println(Thread.currentThread().getName() + " notify, @" +
                        new SimpleDateFormat("HH:MM:SS").format(new Date()));
            }

            synchronized(lock) {


                System.out.println(Thread.currentThread().getName() + " lock again, @" +
                        new SimpleDateFormat("HH:MM:SS").format(new Date()));
            }
        }
    }

}
