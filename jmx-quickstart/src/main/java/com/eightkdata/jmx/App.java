package com.eightkdata.jmx;

import com.eightkdata.jmx.beans.SystemConfig;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

public class App {

    private static final int DEFAULT_NO_THREADS = 10;

    private static final String DEFAULT_SCHEMA = "default";

    public static void main(String[] args) throws Exception {
        MBeanServer beansServer = ManagementFactory.getPlatformMBeanServer();

        SystemConfig systemConfig = new SystemConfig(DEFAULT_NO_THREADS, DEFAULT_SCHEMA);
        ObjectName systemConfigBeanName = new ObjectName("com.eightkdata.jmx:type=SystemConfig");

        beansServer.registerMBean(systemConfig, systemConfigBeanName);

        do {
            Thread.sleep(3000);


            System.out.println("Thread Count=" + systemConfig.getThreadCount() + ":::Schema Name=" + systemConfig.getSchemaName());
        } while (systemConfig.getThreadCount() != 0);

    }

}
