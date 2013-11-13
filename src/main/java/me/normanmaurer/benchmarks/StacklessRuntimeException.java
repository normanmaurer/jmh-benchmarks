package me.normanmaurer.benchmarks;

/**
 *
 * @author dapeng
 */
public class StacklessRuntimeException extends RuntimeException {

    StacklessRuntimeException(String message) {
        super(message);
    }

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }
}
