package me.normanmaurer.benchmarks;

import org.openjdk.jmh.annotations.GenerateMicroBenchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

@State(Scope.Thread)
public class ThrowableBenchmark {
    // experiment test input
    private PendingWrite[] pendingWrites;

    // Destination buffer, the slayer
    private final Writer writer = new Writer();

    @Setup
    public void init() {
        pendingWrites = new PendingWrite[10000];
        for (int i = 0 ; i < pendingWrites.length; i++) {
            pendingWrites[i] = new PendingWrite();
        }
    }

    @GenerateMicroBenchmark
    public int failPendingWritesNew() {
        writer.failPendingWritesNew(pendingWrites);
        return pendingWrites.length;
    }

    @GenerateMicroBenchmark
    public int failPendingWritesLazy() {
        writer.failPendingWritesLazy(pendingWrites);
        return pendingWrites.length;
    }

    @GenerateMicroBenchmark
    public int failPendingWritesStatic() {
        writer.failPendingWritesStatic(pendingWrites);
        return pendingWrites.length;
    }
    
    @GenerateMicroBenchmark
    public int failPendingWritesStackless() {
        writer.failPendingWritesStackless(pendingWrites);
        return pendingWrites.length;
    }
}
