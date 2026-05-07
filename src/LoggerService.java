//service class to handle logging operations
import java.util.logging.Level;
import java.util.logging.Logger;

//package com.app.logger;

class LoggerService {
    int x; //just for example
    //private static final Logger logger = Logger.getLogger(LoggerService.class.getName());

    public LoggerService(int y){
        x = y;    
    }


    public void disable(Class<?> c) {
        Logger.getLogger(c.getName()).setLevel(Level.OFF);
    }

    public void enableInfo(Class<?> c) {
        Logger.getLogger(c.getName()).setLevel(Level.INFO);
    }


    public void run(){
        System.out.println("Running logger service with x = " + x);
        //logger.info("yo whats up");
    }
}

