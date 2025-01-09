package com.tut.db;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {

    private static Properties properties;

    static{
        properties = new Properties();
        try(FileInputStream input = new FileInputStream("src/main/resources/config.properties")){
                properties.load(input);
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public static String getProperty(String property){
        return properties.getProperty(property);
    }

}
