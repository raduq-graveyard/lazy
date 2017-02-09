package com.raduq.lazy.executions.executables;

import java.util.function.Predicate;

/**
 * Created by Raduq on 09/02/2017.
 */
public interface ThrowableConditional <T> {

    void when(Predicate<T> consumer);
}
