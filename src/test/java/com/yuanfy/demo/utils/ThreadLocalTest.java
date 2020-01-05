package com.yuanfy.demo.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author maple.yuan
 * @date 2019-07-28 11:37
 */
public class ThreadLocalTest {

    private static  ThreadLocal<String> builder = new ThreadLocal<>();

    private static class AppendStringThread extends Thread {
        private  static boolean flag = true;
        @Override
        public void run() {
            try {

                if (flag) {
                    builder.set(this.getName() + " hello world");
                    flag = false;
                }
                String str = builder.get();
                System.out.println(this.getName() + ":" + str);
            } finally {
                builder.remove();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        ExecutorService pool = Executors.newFixedThreadPool(1);
        for (int i = 0; i < 2; i ++) {
            pool.execute(new AppendStringThread());

        }
    }
}
