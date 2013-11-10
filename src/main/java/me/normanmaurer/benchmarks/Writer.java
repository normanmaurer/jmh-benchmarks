package me.normanmaurer.benchmarks;

import java.nio.channels.ClosedChannelException;

public class Writer {
    private static final ClosedChannelException CLOSED_CHANNEL_EXCEPTION = new ClosedChannelException();
    static {
        CLOSED_CHANNEL_EXCEPTION.setStackTrace(new StackTraceElement[0]);
    }

    void failPendingWritesNew(PendingWrite... writes) {
        for (PendingWrite write: writes) {
            write.setFailure(new ClosedChannelException());
        }
    }

    void failPendingWritesLazy(PendingWrite... writes) {
	if (writes.length == 0) {
            return;
        }
        ClosedChannelException cause = new ClosedChannelException();
        for (PendingWrite write: writes) {
            write.setFailure(cause);
        }
    }

    void failPendingWritesStatic(PendingWrite... writes) {
        for (PendingWrite write: writes) {
            write.setFailure(CLOSED_CHANNEL_EXCEPTION);
        }
    }
}
