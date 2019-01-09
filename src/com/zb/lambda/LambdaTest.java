package com.zb.lambda;

import com.zb.dao.MyFun;
import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2019/1/7
 */
public class LambdaTest {

    /**
     * 无参数，无返回值
     */
    @Test
    public void test01() {
        Runnable r = () -> System.out.println("Hello World!");
        r.run();
    }

    /**
     * 有一个参数，无返回值
     */
    @Test
    public void test02() {
        Consumer<String> consumer = x -> System.out.println(x);
        consumer.accept("哈哈");
    }

    /**
     * 多个参数，无返回值
     */
    @Test
    public void test03() {
        Comparator<Integer> comparator = (x, y) -> {
            System.out.println("多个参数，无返回值");
            return Integer.compare(x, y);
        };
        System.out.println(comparator.compare(3, 2));
    }

    /**
     * 多个参数，无返回值
     */
    @Test
    public void test04() {
        Comparator<Integer> comparator = (x, y) -> Integer.compare(x, y);
        System.out.println(comparator.compare(3, 2));
    }

    /**
     * 练习1：通过Lambda表达式进行运算
     */
    @Test
    public void test05() {
        int num = operation(100, (x) -> x + x);
        System.out.println(num);
    }

    public int operation(int num, MyFun fun) {
        return fun.test(num);
    }
}
