package com.eightkdata.jmx;

import com.eightkdata.jmx.beans.SystemStatsMBean;

import javax.management.MBeanServerConnection;
import javax.management.MBeanServerInvocationHandler;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import java.io.IOException;

public class JMXClientApp {

    public static void main(String[] args) {
        try {
            JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:9010/jmxrmi");
            JMXConnector connector = JMXConnectorFactory.connect(url);
            MBeanServerConnection serverConnection = connector.getMBeanServerConnection();

            ObjectName mbeanName = new ObjectName("com.eightkdata.jmx:type=SystemStats");
            SystemStatsMBean statsProxy = MBeanServerInvocationHandler
                    .newProxyInstance(serverConnection, mbeanName, SystemStatsMBean.class, true);

            do {
                System.out.println("Current writes = " + statsProxy.getTotalWrites());
                System.out.println("Current threads = " + statsProxy.getThreads());

                keepHealthy(statsProxy);

                Thread.sleep(5000);
            } while(true);
        } catch (IOException | MalformedObjectNameException | InterruptedException e) {
            // Don't do this at home kids (just for the demo)
            e.printStackTrace();
        }
    }

    private static void keepHealthy(SystemStatsMBean statsProxy) {
        statsProxy.setThreads(statsProxy.getThreads() + 1);

        if (statsProxy.getThreads() > 10)
            statsProxy.setThreads(5);
    }

}
