package com.eightkdata.jmx.beans;

public interface SystemConfigMBean {

    public void setThreadCount(int noOfThreads);

    public int getThreadCount();

    public void setSchemaName(String schemaName);

    public String getSchemaName();

    public String doConfig();

    public String doConfigChange(int threads);

}
