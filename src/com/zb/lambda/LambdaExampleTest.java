package com.zb.lambda;

import com.zb.pojo.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2019/1/9
 */
public class LambdaExampleTest {

    List<Employee> employeeList = Arrays.asList(
            new Employee("张三", 20, 3333.33),
            new Employee("李四", 18, 2222.22),
            new Employee("王五", 33, 4444.44),
            new Employee("赵六", 17, 1111.11),
            new Employee("李明", 44, 7777.77)
    );

    @Test
    public void test01() {
        Collections.sort(employeeList, (x, y) -> {
            if (x.getAge().equals(y.getAge())) {
                return x.getName().compareTo(y.getName());
            } else {
                return -Integer.compare(x.getAge(), y.getAge());
            }
        });
        for (Employee emp : employeeList) {
            System.out.println(emp);
        }
    }


}
