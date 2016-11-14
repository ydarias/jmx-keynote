package com.eightkdata.core;

public class Configuration {

    private int threads = 5;

    public int getCurrentThreads() {
        return threads;
    }

    public void resetThreads(int threadsAmount) {
        this.threads = threadsAmount;
    }

}
