package com.eightkdata.core;

import com.eightkdata.jmx.beans.SystemStats;
import com.eightkdata.metrics.Metrics;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;
import java.util.Random;

public class CommandWriter {

    Metrics metrics = new Metrics();

    public CommandWriter() {
        try {
            MBeanServer beansServer = ManagementFactory.getPlatformMBeanServer();
            ObjectName beanName = new ObjectName("com.eightkdata.jmx:type=SystemStats");
            beansServer.registerMBean(new SystemStats(metrics), beanName);
        } catch (Exception e) {
            // Don't do this at home kids (just for the demo)
            e.printStackTrace();
        }
    }

    public void execute() throws InterruptedException {
        do {
            long timeToSleep = new Random().nextInt(20);
            Thread.sleep(timeToSleep);

            doWriteOperation();
        } while (true);
    }

    private void doWriteOperation() {
        metrics.mark();
    }

}
