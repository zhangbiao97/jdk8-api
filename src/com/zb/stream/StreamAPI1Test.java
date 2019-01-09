package com.zb.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 〈功能简述〉<br>
 * 〈
 * Stream API操作步骤：
 * 1. 创建Stream
 * 2. 中间操作
 * 3. 终止操作
 * 〉
 *
 * @author Administrator
 * @create 2019/1/9
 */
public class StreamAPI1Test {

    /**
     * 创建Stream
     */
    @Test
    public void test01() {
        //方式1：Collection提供了两个方法stream()与parallelStream()
        List<Integer> list = new ArrayList<>();
        //顺序流
        Stream<Integer> stream1 = list.stream();
        //并行流
        Stream<Integer> parallelStream = list.parallelStream();

        //方式2：通过Arrays中的stream()获取一个数组流
        Integer[] nums = new Integer[5];
        Stream<Integer> stream2 = Arrays.stream(nums);

        //方式3：通过Stream类中静态方法of()
        Stream<Integer> stream3 = Stream.of(1, 2, 3, 4, 5);

        //方式4：创建无限流
        //迭代
        Stream<Integer> iterateStream = Stream.iterate(0, (x) -> x + 2).limit(10);
        //终止操作
        iterateStream.forEach(System.out::println);

        System.out.println("----------------------------------");

        //生成
        Stream.generate(() -> Math.random())
                .limit(5)
                //终止操作
                .forEach(System.out::println);
    }

}
