package com.welleys.stu.optional;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class MapTest {
    private final Logger LOGGER = Logger.getLogger(getClass().getName());

    @Test
    public void test() {
        List<Person> persons = PersonUtil.getPersons();

        // modify value of every element
        persons.stream().map(person -> {
            person.setAge(11);
            return person;
        }).collect(Collectors.toList());

        persons.stream().map(Person::getAge).forEach(System.out::println);

        // max age
        // 求最高工资方式1：
        List<Employee> employees = EmployeeUtil.getEmployees();
        Integer maxSalary = employees.stream().reduce(0, (salary, p) -> p.getSalary(), Integer::max);
        // 求最高工资方式2：
        Integer maxSalary2 = employees.stream().reduce(0, (salary, p) -> p.getSalary(),
                (max1, max2) -> max1 > max2 ? max1 : max2);

        Assert.assertTrue(700 == maxSalary);
        Assert.assertTrue(700 == maxSalary2);
    }
}
