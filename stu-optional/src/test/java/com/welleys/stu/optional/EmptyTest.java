package com.welleys.stu.optional;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EmptyTest {
    @Test
    public void whenCreatesEmptyOptional_thenCorrect() {
        Object obj = null;
        Optional<Object> objOpt = Optional.ofNullable(obj);
        // don't use Optional.empty() to compare with other empty Optional instances
        // because they may not be same
        assertTrue(Optional.empty() == objOpt);

        Optional<Object> empty = Optional.empty();
        assertFalse(empty.isPresent());

    }
}
