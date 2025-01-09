package com.tut.db.util;

import com.tut.db.Config;
import jdk.jshell.spi.ExecutionControl;

public class PrintableFactory {

    public static Printable getPrintable(){

        String printable = Config.getProperty("PRINTABLE");
        return new Console();
    }

}
