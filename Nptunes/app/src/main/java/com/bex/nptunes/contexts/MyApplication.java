package com.bex.nptunes.contexts;

import android.app.Application;
import android.content.Context;

/*this is application level class and remains same throughout the application life cylce  approach
    myApplicationInstance variable is instantiated with Application object in onCreate()..
    every variables and methods are made static as they are class level members and remains unchanged
    we can define constant values at this class and get anywhere in any activities//
 */
//......................................................................
//and don't forget to mention this class in Manifest file..doing so will instantiate this class whenever you open your application.
//.....................................................................

public class MyApplication extends Application {

    private static MyApplication myApplicationInstance;

    //Instance of MyApplication class is created and onCreate method is called at first at the application level
    @Override
    public void onCreate() {
        super.onCreate();
        myApplicationInstance = this;

    }

    public static MyApplication getMyApplicationInstance(){
        return myApplicationInstance;
    }

    public static Context getMyApplicationContext(){
        return myApplicationInstance.getApplicationContext();

    }
}
