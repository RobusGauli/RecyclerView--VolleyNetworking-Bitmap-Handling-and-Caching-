package com.bex.nptunes.loggings;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Robus on 7/19/2015.
 */
public class MyLog {


    public static final String KEY="ROBUS";
    public static void MyToaster(Context context,String message){

        Toast.makeText(context,message,Toast.LENGTH_SHORT).show();

    }

    public static void MyLogger(String message){
        Log.d(KEY,message);
    }

}
