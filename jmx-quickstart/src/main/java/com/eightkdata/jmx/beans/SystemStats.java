package com.eightkdata.jmx.beans;

import com.eightkdata.metrics.Metrics;

public class SystemStats implements SystemStatsMBean {

    private Metrics metrics;

    public SystemStats(Metrics metrics) {
        this.metrics = metrics;
    }

    public long getTotalWrites() {
        return metrics.getTotalWrites();
    }

}
