package com.eightkdata.jmx;

import com.eightkdata.jmx.beans.Tutu;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

public class NonConventionApp {

    public static void main(String[] args) {
        try {
            Tutu bean = new Tutu();

            MBeanServer beansServer = ManagementFactory.getPlatformMBeanServer();
            ObjectName beanName = new ObjectName("com.eightkdata.jmx:type=Tutu,name=juanito");
            beansServer.registerMBean(bean, beanName);

            do {
                Thread.sleep(1000);
            } while(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
