package com.zb.stream;

import com.zb.pojo.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * 〈功能简述〉<br>
 * 〈
 *      筛选与切片
 * 		filter——接收 Lambda ， 从流中排除某些元素。
 * 		limit——截断流，使其元素不超过给定数量。
 * 		skip(n) —— 跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素不足 n 个，则返回一个空流。与 limit(n) 互补
 * 		distinct——筛选，通过流所生成元素的 hashCode() 和 equals() 去除重复元素
 *  〉
 *
 * @author Administrator
 * @create 2019/1/9
 */
public class StreamAPI2Test {

    List<Employee> emps = Arrays.asList(
            new Employee( "李四", 59, 6666.66),
            new Employee( "张三", 18, 9999.99),
            new Employee("王五", 28, 3333.33),
            new Employee("赵六", 8, 7777.77),
            new Employee("赵六", 8, 7777.77),
            new Employee("赵六", 8, 7777.77),
            new Employee("田七", 38, 5555.55)
    );

    /**
     * filter：在流执行的过程中通过filter可以过滤某些数据
     */
    @Test
    public void test01(){
        emps.stream().filter((x) -> x.getSalary()>5000)
                .forEach(System.out::println);
    }

    /**
     * limit：在流的执行过程中通过给定的参数来限制输出数据的数量
     */
    @Test
    public void test02(){
        emps.stream().limit(2)
                .forEach(System.out::println);
    }

    /**
     * skip：跳过元素
     */
    @Test
    public void test03(){
        emps.stream().skip(2)
                .forEach(System.out::println);
    }

    /**
     * distinct：去掉重复数据
     */
    @Test
    public void test04(){
        emps.stream().distinct()
                .forEach(System.out::println);
    }
}
