package com.raduq.lazy.executions.executors;

import com.raduq.lazy.executions.executables.Executable;
import com.raduq.lazy.executions.executables.ThrowableConditional;

import java.util.function.Predicate;

/**
 * Created by Raduq on 09/02/2017.
 */
public class ThrowingCondition<T> implements ThrowableConditional<T> {

    private final String message;
    private final Executable<T, ?> executable;

    public ThrowingCondition(Executable<T, ?> executable, String message) {
        this.executable = executable;
        this.message = message;
    }

    @Override
    public void when(Predicate<T> condition) {
        if (condition.test(executable.getValue())) {
            throw new RuntimeException(message);
        }
    }
}
