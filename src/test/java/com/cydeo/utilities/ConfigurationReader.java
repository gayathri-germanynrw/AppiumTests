package com.cydeo.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader{
    //1 . Create property object
    // Make it  " private " so we are limiting access of the object
    // "static" is to make sure its created and loaded before everything else
    private static Properties properties = new Properties();


    static{
        // 2. File open using the fileInputStream
        try {
            FileInputStream file = new FileInputStream("configuration.properties");

            // 3. Load the "properties" object
            properties.load(file);

            // close the file
            file.close();
        }catch(IOException e){
            System.out.println("FILE NOT FOUND IN GIVEN PATH !!!" );
            e.printStackTrace();

        }

    }

    // 4. Use the "properties" object  to read from the file(read properties)
    public static String getProperty(String key){
        return properties.getProperty(key);
    }
}