package com.eightkdata.jmx;

import com.eightkdata.core.CommandWriter;

public class InterfaceImplementationApp {

    public static void main(String[] args) {
        try {
            CommandWriter writer = new CommandWriter();
            writer.execute();
        } catch (InterruptedException e) {
            // Don't do this at home kids (just for the demo)
            e.printStackTrace();
        }
    }

}
