package com.welleys.stu.optional;

import java.util.ArrayList;
import java.util.List;

public class EmployeeUtil {
    public static List<Employee> getEmployees() {
        List<Employee> employees = new ArrayList<>();

        Employee a = new Employee("zs", 500);
        Employee b = new Employee("ls", 600);
        Employee c = new Employee("ww", 700);

        employees.add(a);
        employees.add(b);
        employees.add(c);

        return employees;
    }
}
