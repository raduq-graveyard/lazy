package com.raduq.lazy.executions;

import com.raduq.lazy.executions.executors.With;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Raduq on 09/02/2017.
 */
public class WithTest {

    @Test
    @DisplayName("Can execute when condition is valid")
    void canExecute() {
        Optional<Integer> result = new With<Integer, Integer>(0).doWhen(i -> i += 1).when(i -> i <= 0);
        assertAll(() -> assertTrue(result.isPresent()),
                () -> assertEquals(new Integer(1), result.get()));
    }

    @Test
    @DisplayName("Cant execute when condition is not valid")
    void cantExecute() {
        Optional<Integer> result = new With<Integer, Integer>(0).doWhen(i -> i += 1).when(i -> i <= -1);
        assertFalse(result.isPresent());
    }

    @Test
    @DisplayName("Can execute without verify any condition")
    void canExecuteWithoutCondition() {
        Optional<Integer> result = new With<Integer, Integer>(0).doIt(i -> i += 1);
        assertAll(() -> assertTrue(result.isPresent()),
                () -> assertEquals(new Integer(1), result.get()));
    }

    @Test
    @DisplayName("Can throw exception when condition is valid")
    void canThrowException() {
        Throwable exception = assertThrows(RuntimeException.class, () -> {
            new With<String, String>("a").throwThis("Not Today").when(s -> s.equals("a"));
        });
        assertEquals("Not Today", exception.getMessage());
    }
}
