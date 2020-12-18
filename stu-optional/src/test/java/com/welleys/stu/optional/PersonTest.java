package com.welleys.stu.optional;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class PersonTest {
    @Test
    public void givenOptional_whenFlatMapWorks_thenCorrect2() {
        Person person = new Person("john", 26, null);
        Optional<Person> personOptional = Optional.of(person);

        Optional<Optional<Optional<String>>> nameOptionalWrapper
                = personOptional.map(Person::getName);
        Optional<String> nameOptional
                = nameOptionalWrapper.orElse(Optional.empty()).orElseThrow(IllegalArgumentException::new);
        String name1 = nameOptional.orElse("");
        assertEquals("john", name1);

        String name = personOptional
                .flatMap(Person::getName)
                .orElse(Optional.empty())
                .orElse("");
        assertEquals("john", name);
    }
}