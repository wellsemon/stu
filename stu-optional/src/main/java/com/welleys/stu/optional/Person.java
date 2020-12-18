package com.welleys.stu.optional;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

import java.util.Optional;

@Setter
@AllArgsConstructor
public class Person {
    private String name;
    private Integer age;
    private String password;

    public Optional<Optional<String>> getName() {
        return Optional.ofNullable(Optional.ofNullable(name));
    }

    public Optional<Integer> getAge() {
        return Optional.ofNullable(age);
    }

    public Optional<String> getPassword() {
        return Optional.ofNullable(password);
    }
}
