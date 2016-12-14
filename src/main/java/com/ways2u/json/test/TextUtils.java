package com.ways2u.json.test;

/**
 * Created by huanglong on 2016/12/14.
 */
public class TextUtils {
    public static boolean isEmpty(String jsonData) {
        if(jsonData==null||jsonData.trim().length()==0){
            return true;
        }
        return false;
    }
}
