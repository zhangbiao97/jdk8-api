package com.java8.lambda;

import com.java8.pojo.Employee;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * 〈功能简述〉<br>
 * 〈
 * 一：方法引用：
 * 1、对象::实例方法名
 * 2、类::静态方法名
 * 3、类::实例方法名
 * 注意：
 * 1、方法引用所引用的方法的参数列表与返回值类型，
 * 需要与函数式接口中抽象方法的参数列表和返回值类型保持一致
 * 2、若Lambda的参数列表的第一个参数，是实例方法的调用者，
 * 第二个参数（或无参）是实例方法的参数时，格式：ClassName::MethodName
 * 二：构造器引用
 * 注意：构造器的参数列表，需要与函数式接口中参数列表保持一致
 * 〉
 *
 * @author Administrator
 * @create 2019/1/9
 */
public class MethodRefExampleTest {

    @Test
    public void test01() {
        /**
         * Lambda表达式方式
         */
        Consumer<String> consumer = (x) -> System.out.println(x);
        consumer.accept("哈哈");
        System.out.println("------------------------------");
        /**
         * 对象的引用方式：对象::实例方法名
         */
        PrintStream ps = System.out;
        Consumer<String> consumer2 = ps::println;
        consumer2.accept("对象::实例方法名");
    }

    @Test
    public void test02() {
        /**
         * Lambda表达式的方式
         */
        Comparator<Integer> comparator = (x, y) -> x.compareTo(y);
        int result = comparator.compare(1, 2);
        System.out.println(result);
        System.out.println("----------------------");
        /**
         * 使用方法引用
         * 类::静态方法名
         */
        Comparator<Integer> comparator2 = Integer::compareTo;
        int result2 = comparator2.compare(1, 2);
        System.out.println(result2);
    }

    @Test
    public void test03() {
        /**
         * Lambda表达式方式
         */
        BiPredicate<String, String> pre = (x, y) -> x.equals(y);
        pre.test("haha", "xixi");
        System.out.println("--------------------------");
        /**
         * 类::实例方法名方式
         */
        BiPredicate<String, String> pre2 = String::equals;
        pre2.test("haha", "xixi");
    }

    /**
     * 构造器引用
     */
    @Test
    public void test04() {
        Function<String, Employee> fun = Employee::new;
        Employee emp = fun.apply("张三");
        System.out.println(emp.getName());
    }
}
