package com.raduq.lazy.executions.executors;

import com.raduq.lazy.executions.executables.Conditional;
import com.raduq.lazy.executions.executables.Exceptionable;
import com.raduq.lazy.executions.executables.Executable;
import com.raduq.lazy.executions.executables.ThrowableConditional;

import java.util.Optional;
import java.util.function.Function;

/**
 * Created by Raduq on 09/02/2017.
 */
public class With<T,R> implements Executable<T,R>,Exceptionable {

    private T value;

    public With(T value) {
        this.value = value;
    }

    @Override
    public Conditional<T,R> doWhen(Function<T, R> lambda) {
        return new Condition<>(this, lambda);
    }

    @Override
    public T getValue() {
        return this.value;
    }

    @Override
    public Optional<R> doIt(Function<T, R> lambda) {
        return Optional.ofNullable(lambda.apply(this.value));
    }

    @Override
    public ThrowableConditional<T> throwThis(String message) {
        return new ThrowingCondition<>(this,message);
    }
}
