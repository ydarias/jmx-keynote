package com.eightkdata.core;

import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;

import java.util.Random;

public class CommandExecutor {

    Meter writeMeter, readMeter;

    public CommandExecutor(MetricRegistry registry) {
        this.writeMeter = registry.meter("writes");
        this.readMeter = registry.meter("reads");
    }

    public void execute() {
        do {
            long timeToSleep = new Random().nextInt(20);
            try {
                Thread.sleep(timeToSleep);
            } catch (InterruptedException e) {
                // Don't do this at home kids (just for the demo)
                e.printStackTrace();
            }

            doWriteOperation();
            doReadOperation();
        } while (true);
    }

    private void doReadOperation() {
        readMeter.mark();
    }

    private void doWriteOperation() {
        writeMeter.mark();
    }

}
