package me.normanmaurer.benchmarks;

public class PendingWrite {
    Throwable cause;
    public void setSuccess() {
        cause = null;
    }

    public void setFailure(Throwable cause) {
        this.cause = cause;
    }
}
