package com.eightkdata.metrics;

public class Metrics {

    long value = 0;

    public void mark() {
        value++;
    }

    public long getTotalWrites() {
        return value;
    }

}
