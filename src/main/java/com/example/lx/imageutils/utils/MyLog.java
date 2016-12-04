package com.example.lx.imageutils.utils;

import android.util.Log;

/**
 * Created by Administrator on 2016/12/3.
 */

public class MyLog {
    public static String TAG = "Liaoxin";
    public static void d(String tag, String more){
        Log.d(TAG, "["+tag+"] " + more);
    }
    public static void e(String tag, String more){
        Log.e(TAG, "["+tag+"] " + more);
    }
    public static void i(String tag, String more){
        Log.i(TAG, "["+tag+"] " + more);
    }
}
