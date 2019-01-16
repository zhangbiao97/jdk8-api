package com.java8.pojo;

import com.java8.util.StatusEnum;

import java.util.Objects;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2019/1/9
 */
public class Employee {
    private String name;
    private Integer age;
    private Double salary;
    private StatusEnum statusEnum;

    public Employee() {
    }

    public Employee(String name) {
        this.name = name;
    }

    public Employee(String name, Integer age, Double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public Employee(String name, Integer age, Double salary, StatusEnum statusEnum) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.statusEnum = statusEnum;
    }

    public StatusEnum getStatusEnum() {
        return statusEnum;
    }

    public void setStatusEnum(StatusEnum statusEnum) {
        this.statusEnum = statusEnum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) &&
                Objects.equals(age, employee.age) &&
                Objects.equals(salary, employee.salary) &&
                statusEnum == employee.statusEnum;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, salary, statusEnum);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", statusEnum=" + statusEnum +
                '}';
    }
}
