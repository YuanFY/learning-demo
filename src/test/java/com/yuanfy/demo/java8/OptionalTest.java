package com.yuanfy.demo.java8;

import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

/**
 * @author maple.yuan
 * @date 2020-01-05 10:40
 */
public class OptionalTest {

    @Test
    public void test() {
        Optional<String> s = Optional.of("1");


        String str = null;
        str = "1";
        Optional<String> s1 = Optional.ofNullable(str);

        Optional<Object> empty = Optional.empty();

        Assert.assertEquals(s, s1);
        Assert.assertTrue(s1.isPresent());

       // System.out.println(empty.get());

        s1.ifPresent(System.out::println);

    }
}
