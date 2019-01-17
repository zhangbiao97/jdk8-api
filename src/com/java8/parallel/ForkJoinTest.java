package com.java8.parallel;

import org.junit.Test;

import java.util.stream.LongStream;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2019/1/16
 */
public class ForkJoinTest {

    @Test
    public void test01() {
        long sum = LongStream.rangeClosed(0, 100000000000L)
                .parallel()
                .reduce(0, Long::sum);
        System.out.println(sum);
    }

}
