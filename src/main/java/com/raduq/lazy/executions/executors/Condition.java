package com.raduq.lazy.executions.executors;

import com.raduq.lazy.executions.executables.Conditional;
import com.raduq.lazy.executions.executables.Executable;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by Raduq on 09/02/2017.
 */
public class Condition <T,R> implements Conditional<T,R>{

    private final Executable<T,R> executable;
    private Function<T,R> lambda;

    public Condition(Executable<T,R> executable, Function<T,R> lambda){
        this.executable = executable;
        this.lambda = lambda;
    }

    @Override
    public Optional<R> when(Predicate<T> condition) {
        if(condition.test(executable.getValue())){
            return executable.doIt(lambda);
        }
        return Optional.empty();
    }

    @Override
    public Executable<T,R> getExecutable() {
        return this.executable;
    }


}



