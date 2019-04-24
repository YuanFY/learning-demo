package com.yuanfy.demo.concurrent;

import org.junit.Assert;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author maple.yuan
 * @date 2019-04-14 17:41
 */
public class AtomicProblemTest {


    /**
     * 电影票总数
     */
    private volatile AtomicInteger movieTicketAmount = new AtomicInteger(10000);

    /**
     * 售票
     */
    public void saleTicket(int n) {
        /**
         * 为了让问题能够明显一点，使用减1的操作，重复n次
         */
        int i = 0;
        while (i++ < n) {
            movieTicketAmount.getAndDecrement();
        }
    }

    /**
     * 返回剩余电影票
     * @return int
     */
    public int getMovieTicketAmount() {
        return movieTicketAmount.get();
    }

    public static void main(String[] args) throws InterruptedException {

        final AtomicProblemTest ticket = new AtomicProblemTest();

        // 假设现在有两个用户分别购买5000张电影票
        Thread user1 = new Thread(() -> ticket.saleTicket(5000));

        Thread user2 = new Thread(() -> ticket.saleTicket(5000));

        user1.start();
        user2.start();

        // 等待用户购买完成
        user1.join();
        user2.join();

        // 售了1000张电影票后查验余数，理应还剩0张
        System.out.println(ticket.getMovieTicketAmount());
        Assert.assertEquals(ticket.getMovieTicketAmount(), 0);
    }
}
