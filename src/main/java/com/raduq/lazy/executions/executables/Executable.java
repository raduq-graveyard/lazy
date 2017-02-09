package com.raduq.lazy.executions.executables;

import java.util.Optional;
import java.util.function.Function;

/**
 * Created by Raduq on 09/02/2017.
 */
public interface Executable<T, R> {

    Conditional<T, R> doWhen(Function<T, R> consumer);

    T getValue();

    Optional<R> doIt(Function<T, R> consumer);
}
