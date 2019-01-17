package com.java8.stream;

import com.java8.pojo.Employee;
import com.java8.util.StatusEnum;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 〈功能简述〉<br>
 * 〈
 * 终止操作
 * <p>
 * allMatch——检查是否匹配所有元素
 * anyMatch——检查是否至少匹配一个元素
 * noneMatch——检查是否没有匹配的元素
 * findFirst——返回第一个元素
 * findAny——返回当前流中的任意元素
 * count——返回流中元素的总个数
 * max——返回流中最大值
 * min——返回流中最小值
 * <p>
 * 归约
 * reduce(T identity, BinaryOperator)
 * reduce(BinaryOperator)
 * 可以将流中元素反复结合起来，得到一个值。
 * <p>
 * 收集
 * collect：将流转换为其他形式，接受一个Collector接口的实现，用于给
 * Stream中的元素做汇总的方法
 * 〉
 *
 * @author Administrator
 * @create 2019/1/15
 */
public class StreamAPI3Test {
    List<Employee> emps = Arrays.asList(
            new Employee("李四", 59, 6666.66, StatusEnum.BUSY),
            new Employee("张三", 18, 9999.99, StatusEnum.FREE),
            new Employee("王五", 28, 3333.33, StatusEnum.VOCATION),
            new Employee("赵六", 8, 7777.77, StatusEnum.FREE),
            new Employee("田七", 38, 5555.55, StatusEnum.FREE),
            new Employee("田七", 38, 5555.55, StatusEnum.FREE)
    );

    @Test
    public void test01() {
        //allMatch：是否匹配所有元素
        boolean b1 = emps.stream()
                .allMatch((e) -> e.getStatusEnum().equals(StatusEnum.FREE));
        System.out.println(b1);

        //anyMatch：是否至少有一个匹配的元素
        boolean b2 = emps.stream()
                .anyMatch((e) -> e.getStatusEnum().equals(StatusEnum.FREE));
        System.out.println(b2);

        //noneMatch：是否没有匹配的元素
        boolean b3 = emps.stream()
                .noneMatch((e) -> e.getStatusEnum().equals(StatusEnum.FREE));
        System.out.println(b3);
    }

    @Test
    public void test02() {
        //findFirst：返回流中第一个元素
        Optional<Employee> op1 = emps.stream()
                .sorted((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()))
                .findFirst();
        System.out.println(op1.get());

        //findAny：返回流中任意一个元素
        Optional<Employee> op2 = emps.parallelStream()
                .filter((e) -> e.getStatusEnum().equals(StatusEnum.FREE))
                .findAny();
        System.out.println(op2.get());
    }

    @Test
    public void test03() {
        //count：统计流元素的个数
        long count = emps.stream()
                .count();

        //max：返回流中的最大值
        Optional<Double> op1 = emps.stream()
                .map(Employee::getSalary)
                .max(Double::compare);
        System.out.println(op1.get());

        //min：返回流中的最小值
        Optional<Double> op2 = emps.stream()
                .map(Employee::getSalary)
                .min(Double::compare);
        System.out.println(op2.get());
    }


    @Test
    public void test04() {
        //reduce：将流中的元素结合起来，得到一个值
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer result = list.stream()
                .reduce(0, (x, y) -> x + y);
        System.out.println(result);

        System.out.println("---------------------");

        Optional<Double> sum = emps.stream()
                .map(Employee::getSalary)
                .reduce(Double::max);
        System.out.println(sum.get());
    }

    /**
     * collect
     */
    @Test
    public void test05() {
        //toList(); 返回List
        List<String> list = emps.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());
        list.forEach(System.out::println);
        System.out.println("---------------------------");
        //toSet(); 返回Set
        Set<String> set = emps.stream()
                .map(Employee::getName)
                .collect(Collectors.toSet());
        set.forEach(System.out::println);
        System.out.println("---------------------------");
        //toCollection();
        HashSet<String> hashSet = emps.stream()
                .map(Employee::getName)
                .collect(Collectors.toCollection(HashSet::new));
        hashSet.forEach(System.out::println);
        System.out.println("---------------------------");

        Optional<Double> max = emps.stream()
                .map(Employee::getSalary)
                .collect(Collectors.maxBy(Double::compare));
        System.out.println("最大值：" + max.get());

        Optional<Double> min = emps.stream()
                .map(Employee::getSalary)
                .collect(Collectors.minBy(Double::compare));
        System.out.println("最小值：" + min);

        Double sum = emps.stream()
                .collect(Collectors.summingDouble(Employee::getSalary));
        System.out.println("和：" + sum);

        Double avg = emps.stream()
                .collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println("平均值：" + avg);

        Long count = emps.stream()
                .collect(Collectors.counting());
        System.out.println("统计：" + count);

        DoubleSummaryStatistics dss = emps.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println("最大值：" + dss.getMax());
        System.out.println("最小值：" + dss.getMin());
        System.out.println("和：" + dss.getSum());
        System.out.println("平均值：" + dss.getAverage());
        System.out.println("统计：" + dss.getCount());
    }


    /**
     * 分区
     */
    @Test
    public void test06() {
        Map<Boolean, List<Employee>> map = emps.stream()
                .collect(Collectors.partitioningBy((e) -> e.getSalary() > 5000));
        System.out.println(map);
    }

    /**
     * groupingBy：分组
     */
    @Test
    public void test07() {
        Map<StatusEnum, List<Employee>> map = emps.stream()
                .collect(Collectors.groupingBy(Employee::getStatusEnum));
        System.out.println(map);

        System.out.println("--------------------------");

        Map<StatusEnum, Map<String, List<Employee>>> map2 = emps.stream()
                .collect(Collectors.groupingBy(Employee::getStatusEnum, Collectors.groupingBy((e) -> {
                    if (e.getAge() >= 60) {
                        return "老年";
                    } else if (e.getAge() >= 30) {
                        return "中年";
                    } else {
                        return "青年";
                    }
                })));
        System.out.println(map2);
    }


}
