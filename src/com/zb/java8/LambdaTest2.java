package com.zb.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2019/1/9
 */
public class LambdaTest2 {

    /**
     * 消费型接口：Consumer
     * 有参数，无返回值
     */
    @Test
    public void test01() {
        happy(100, (x) -> System.out.println("消费：" + x + "元"));
    }

    public void happy(double money, Consumer<Double> consumer) {
        consumer.accept(money);
    }

    /**
     * 供给型接口：Supplier
     * 无参数，有返回值
     */
    @Test
    public void test02() {
        List<Integer> numList = getNumList(10, () -> (int) (Math.random() * 100));
        for (Integer num : numList) {
            System.out.println(num);
        }
    }

    public List<Integer> getNumList(int num, Supplier<Integer> sup) {
        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            numList.add(sup.get());
        }
        return numList;
    }

    /**
     * 函数型接口：Function
     * 有参数，有返回值
     */
    @Test
    public void test03() {
        String newStr = strHandler("\t\t\t哈哈哈\t\t", (x) -> x.trim());
        System.out.println(newStr);
    }

    public String strHandler(String str, Function<String, String> fun) {
        return fun.apply(str);
    }


    /**
     * 断言型接口：Predicate
     * 有参数，有返回值
     */
    @Test
    public void test04() {
        List<String> strList = Arrays.asList("hahha", "www", "ok", "yes", "xixixi");
        List<String> newStrList = filterStr(strList, (x) -> x.length() > 3);
        for (String str : newStrList) {
            System.out.println(str);
        }
    }

    public List<String> filterStr(List<String> strList, Predicate<String> pre) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < strList.size(); i++) {
            if (pre.test(strList.get(i))) {
                list.add(strList.get(i));
            }
        }
        return list;
    }

}
