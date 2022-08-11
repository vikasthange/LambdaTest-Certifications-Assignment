package com.vikas;


public class Const {
    public static String LT_GRID_URL="https://hub.lambdatest.com/wd/hub";
    public static String LT_UNAME_KEY="ltUser";
    public static String LT_TOKEN_KEY="ltToken";

    // If no System prop or env then use below 
    public static final String LT_UNAME_DEFAULT="vikasthange";
    public static final String LT_TOKEN_DEFAULT="Fcu6S1cOO6sOY16ca9n9gxmbke3ade5SXdKLOklA983vD30MLt";
    // Setting higher timeout as my current license is only 1 test at a time. 
    public final static int TIMEOUT=90000; // In question 20 seconds has set but due to license issue i can not set small timeout please read below message
    // Even though my code/framework starts parallel tests still second test just waits in a queue. 
    //If I set a small wait of only 20 seconds then second tests is terminated as I do not have parallel license. hence higher wait
    // I hope you consider this while evaluating the assignment
    public static final int ELEMENT_TIMEOUT_SEC = 20;

    public static final String APP_HOME_URL = "https://www.lambdatest.com/";
    public static final String BLOG_PAGE_URL="https://www.lambdatest.com/blog";
    public static final String COMMUNITY_PAGE_URL="https://community.lambdatest.com/";
   

    public static Object getLtUsername() {
        if(System.getProperty(LT_UNAME_KEY)!=null){
            return System.getProperty(LT_UNAME_KEY);
        }
        else if(System.getenv(LT_UNAME_KEY)!=null) {
            return System.getenv(LT_UNAME_KEY);
        }else if(!Const.LT_UNAME_DEFAULT.isEmpty()){
            return Const.LT_UNAME_DEFAULT;
        }
        else{
            System.err.println("Need LT credentials, Please set "+LT_UNAME_KEY+" key");
            throw new RuntimeException("Need LT credentials, Please set "+LT_UNAME_KEY+" key");
        }
    }
    public static Object getLtToken() {
        

        if(System.getProperty(LT_TOKEN_KEY)!=null){
            return System.getProperty(LT_TOKEN_KEY);
        }
        else if(System.getenv(LT_TOKEN_KEY)!=null){
            return System.getenv(LT_TOKEN_KEY);
        }
        else if(!Const.LT_TOKEN_DEFAULT.isEmpty()){
            return Const.LT_TOKEN_DEFAULT;
        }
        else{
            Logger.err("Need LT credentials, Please set "+LT_TOKEN_KEY+" key");
            throw new RuntimeException("Need LT credentials, Please set "+LT_TOKEN_KEY+" key");
        }
    }


    
}
