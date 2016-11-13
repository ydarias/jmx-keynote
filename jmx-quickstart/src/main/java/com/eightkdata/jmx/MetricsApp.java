package com.eightkdata.jmx;

import com.codahale.metrics.JmxReporter;
import com.codahale.metrics.MetricRegistry;
import com.eightkdata.core.CommandExecutor;

public class MetricsApp {

    public static void main(String[] args) {
        MetricRegistry registry = new MetricRegistry();

        JmxReporter reporter = JmxReporter.forRegistry(registry).build();
        reporter.start();

        new CommandExecutor(registry).execute();
    }

}
