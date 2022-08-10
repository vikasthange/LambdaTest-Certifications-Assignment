package com.vikas;

public class Const {
    public static String LT_GRID_URL="https://hub.lambdatest.com/wd/hub";
    public static String LT_UNAME_KEY="ltUser";
    public static String LT_TOKEN_KEY="ltToken";

    public static Object getLtUsername() {
        if(System.getProperty(LT_UNAME_KEY)!=null){
            return System.getProperty(LT_UNAME_KEY);
        }
        else if(System.getenv(LT_UNAME_KEY)!=null) {
            return System.getenv(LT_UNAME_KEY);
        }else{
            System.err.println("Need LT credentials, Please set "+LT_UNAME_KEY+" key");
            throw new RuntimeException("Need LT credentials, Please set "+LT_UNAME_KEY+" key");
        }
    }
    public static Object getLtToken() {
        

        if(System.getProperty(LT_TOKEN_KEY)!=null){
            return System.getProperty(LT_TOKEN_KEY);
        }
        else if(System.getenv(LT_TOKEN_KEY)==null){
            return System.getenv(LT_TOKEN_KEY);
        }
        else{
            System.err.println("Need LT credentials, Please set "+LT_TOKEN_KEY+" key");
            throw new RuntimeException("Need LT credentials, Please set "+LT_TOKEN_KEY+" key");
        }
    }


    
}
