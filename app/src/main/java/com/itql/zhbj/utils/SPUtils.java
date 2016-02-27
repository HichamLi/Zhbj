package com.itql.zhbj.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by HiChamLi on 2015/11/28.
 */
public class SPUtils {
    private static final String spName="config";

    public static boolean getBoolean(Context context,String key,boolean defaultValue){
        SharedPreferences sharedPreferences=context.getSharedPreferences(spName,Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(key,defaultValue);
    }

    public static void setBoolean(Context context,String key,boolean value){
        SharedPreferences sharedPreferences=context.getSharedPreferences(spName,Context.MODE_PRIVATE);
        sharedPreferences.edit().putBoolean(key,value).commit();
    }
}
