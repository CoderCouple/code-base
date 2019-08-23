package com.log4j.example;

import org.apache.log4j.Logger;

/**
 * Hello world!
 *
 */
public class App 
{

    public static final Logger LOGGER = Logger.getLogger(App.class);
    public static void main( String[] args )
    {
        for(int i=0; i<Integer.MAX_VALUE; i++){
            LOGGER.info("This a log for class App");
            System.out.println( "Hello World!" );
        }

    }
}
