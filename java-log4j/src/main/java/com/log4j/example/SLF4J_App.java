package com.log4j.example;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SLF4J_App {

    public static final Logger LOGGER = LoggerFactory.getLogger(App.class);
    public static void main( String[] args )
    {
        for(int i=0; i<Integer.MAX_VALUE; i++){
            LOGGER.info("This a log for class {}", App.class);
            System.out.println( "Hello World!" );
        }

    }
}
