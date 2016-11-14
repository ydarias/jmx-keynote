package com.eightkdata.jmx.beans;

import com.eightkdata.core.Configuration;
import com.eightkdata.metrics.Metrics;

public class SystemStats implements SystemStatsMBean {

    private Metrics metrics;

    private Configuration configuration;

    public SystemStats(Metrics metrics, Configuration configuration) {
        this.metrics = metrics;
        this.configuration = configuration;
    }

    public long getTotalWrites() {
        return metrics.getTotalWrites();
    }

    @Override
    public int getThreads() {
        return configuration.getCurrentThreads();
    }

    @Override
    public void setThreads(int threadsAmount) {
        configuration.resetThreads(threadsAmount);
    }

}
