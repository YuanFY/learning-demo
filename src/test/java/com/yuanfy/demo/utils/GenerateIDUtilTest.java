package com.yuanfy.demo.utils;

import org.junit.Test;

/**
 * @author maple.yuan
 * @date 2019-12-21 18:02
 */
public class GenerateIDUtilTest {

    @Test
    public void test() throws Exception {
        GenerateIDUtil util = new GenerateIDUtil();

        for (int i = 0; i < 10; i ++) {
            System.out.println(util.nextId());
        }
    }
}
