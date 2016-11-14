package com.eightkdata.jmx.beans;

public interface SystemStatsMBean {

    public long getTotalWrites();

    public int getThreads();

    public void setThreads(int i);

}
