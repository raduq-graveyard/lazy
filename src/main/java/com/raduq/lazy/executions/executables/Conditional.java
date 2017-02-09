package com.raduq.lazy.executions.executables;

import java.util.Optional;
import java.util.function.Predicate;

/**
 * Created by Raduq on 09/02/2017.
 */
public interface Conditional<T, R> {

   Optional<R> when(Predicate<T> condition);

   Executable<T,R> getExecutable();

}
