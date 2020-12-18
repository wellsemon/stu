package com.welleys.stu.optional;

import java.util.ArrayList;
import java.util.List;

public class PersonUtil {
    public static List<Person> getPersons() {
        List<Person> persons = new ArrayList<>();

        Person a = new Person("zs", 18, "123");
        Person b = new Person("ls", 20, "456");
        Person c = new Person("ww", 25, "789");

        persons.add(a);
        persons.add(b);
        persons.add(c);

        return persons;
    }
}
