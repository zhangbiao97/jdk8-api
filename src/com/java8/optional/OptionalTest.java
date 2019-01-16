package com.java8.optional;

import com.java8.pojo.Employee;
import org.junit.Test;

import java.util.Optional;

/**
 * 〈功能简述〉<br>
 * 〈
 *      一、Optional 容器类：用于尽量避免空指针异常
 *   	    Optional.of(T t) : 创建一个 Optional 实例
 *   	    Optional.empty() : 创建一个空的 Optional 实例
 *  	    Optional.ofNullable(T t):若 t 不为 null,创建 Optional 实例,否则创建空实例
 *   	    isPresent() : 判断是否包含值
 *   	    orElse(T t) :  如果调用对象包含值，返回该值，否则返回t
 *   	    orElseGet(Supplier s) :如果调用对象包含值，返回该值，否则返回 s 获取的值
 *   	    map(Function f): 如果有值对其处理，并返回处理后的Optional，否则返回 Optional.empty()
 *   	    flatMap(Function mapper):与 map 类似，要求返回值必须是Optional
 *  〉
 *
 * @author Administrator
 * @create 2019/1/16
 */
public class OptionalTest {

    @Test
    public void test01(){
        //Optional.of(T t) : 创建一个 Optional 实例
        Optional<Employee> op1 = Optional.of(new Employee());
        System.out.println(op1.get());

        //Optional.empty() : 创建一个空的 Optional 实例
        Optional<Object> op2 = Optional.empty();

        //Optional.ofNullable(T t):若 t 不为 null,创建 Optional 实例,否则创建空实例
        Optional<Employee> op3 = Optional.ofNullable(null);
        Optional<Employee> op4 = Optional.ofNullable(new Employee());
        //System.out.println(op3.get());
        System.out.println(op4.get());

        //isPresent() : 判断是否包含值
        System.out.println(op3.isPresent());

        //orElse(T t) :  如果调用对象包含值，返回该值，否则返回t
        Employee emp = op3.orElse(new Employee("张三"));
        System.out.println(emp);

        //orElseGet(Supplier s) :如果调用对象包含值，返回该值，否则返回 s 获取的值
        Employee emp2 = op3.orElseGet(Employee::new);
        System.out.println(emp2);

        //map(Function f): 如果有值对其处理，并返回处理后的Optional，否则返回 Optional.empty()
        Optional<String> str = op3.map(Employee::getName);
        //System.out.println(str.get());

        //flatMap(Function mapper):与 map 类似，要求返回值必须是Optional
        Optional<String> str2 = op3.flatMap((e) -> Optional.of(e.getName()));
        //System.out.println(str2.get());
    }

}
