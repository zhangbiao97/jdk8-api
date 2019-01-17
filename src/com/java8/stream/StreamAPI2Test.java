package com.java8.stream;

import com.java8.pojo.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 〈功能简述〉<br>
 * 〈 中间操作
 * 1、筛选与切片
 * filter——接收 Lambda ， 从流中排除某些元素。
 * limit——截断流，使其元素不超过给定数量。
 * skip(n) —— 跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素不足 n 个，则返回一个空流。与 limit(n) 互补
 * distinct——筛选，通过流所生成元素的 hashCode() 和 equals() 去除重复元素
 * <p>
 * 2、映射
 * map——接收Lambda表达式，将元素转换成其他形式或提取信息。接受一个函数作为参数，
 * 该函数会被应用到每个元素上，并将其映射成一个新的元素。
 * flatMap——接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有
 * 流连接成一个流。
 * <p>
 * 3、排序
 * sorted()——自然排序
 * sorted(Comparator com)——定制排序
 * 〉
 *
 * @author Administrator
 * @create 2019/1/9
 */
public class StreamAPI2Test {

    List<Employee> emps = Arrays.asList(
            new Employee("李四", 59, 6666.66),
            new Employee("张三", 18, 9999.99),
            new Employee("王五", 28, 3333.33),
            new Employee("赵六", 8, 7777.77),
            new Employee("赵六", 8, 7777.77),
            new Employee("赵六", 8, 7777.77),
            new Employee("田七", 38, 5555.55)
    );

    List<String> strList = Arrays.asList("aa", "bbb", "cc", "dd", "eeee");


    /**
     * filter：在流执行的过程中通过filter可以过滤某些数据
     */
    @Test
    public void test01() {
        emps.stream().filter((x) -> x.getSalary() > 5000)
                .forEach(System.out::println);
    }

    /**
     * limit：在流的执行过程中通过给定的参数来限制输出数据的数量
     */
    @Test
    public void test02() {
        emps.stream().limit(2)
                .forEach(System.out::println);
    }

    /**
     * skip：跳过元素
     */
    @Test
    public void test03() {
        emps.stream().skip(2)
                .forEach(System.out::println);
    }

    /**
     * distinct：去掉重复数据
     */
    @Test
    public void test04() {
        emps.stream().distinct()
                .forEach(System.out::println);
    }

    /**
     * map：把流中的数据筛选出来生成一个新的流
     */
    @Test
    public void test05() {
        strList.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);
        System.out.println("------------------------");
        Stream<Stream<Character>> stream1 = strList.stream()
                .map(StreamAPI2Test::myMap);
        stream1.forEach((sm) -> sm.forEach(System.out::println));
    }


    /**
     * flatMap：把多个流合并到一个流中
     */
    @Test
    public void test06() {
        Stream<Character> chStream = strList.stream()
                .flatMap(StreamAPI2Test::myMap);
        chStream.forEach(System.out::println);
    }

    /**
     * sorted()
     * sorted(Comparator com)
     */
    @Test
    public void test07() {
        //sorted()
        strList.stream()
                .sorted()
                .forEach(System.out::println);
        System.out.println("------------------------");
        //sorted(Comparator com)
        emps.stream()
                .sorted((x, y) -> {
                    if (x.getAge().equals(y.getAge())) {
                        return x.getName().compareTo(y.getName());
                    } else {
                        return -x.getAge().compareTo(y.getAge());
                    }
                })
                .forEach(System.out::println);
    }

    public static Stream<Character> myMap(String str) {
        List<Character> characterList = new ArrayList<>();
        for (int i = 0; i < str.toCharArray().length; i++) {
            characterList.add(str.toCharArray()[i]);
        }
        return characterList.stream();
    }
}
