package com.vikas;
public class Logger {
    public static void log(String message){
        System.out.println("INFO: "+DriverManager.getTestName()+": "+ message);
    }
    public static void err(String message){
        System.err.println("ERROR: "+DriverManager.getTestName()+": "+ message);
    }
    public static void warn(String message){
        System.err.println("WARN: "+DriverManager.getTestName()+": "+ message);
    }
    
}
