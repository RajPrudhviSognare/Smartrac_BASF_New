package com.experis.smartrac.b;

import android.content.Context;
import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;

public class MyApplication extends MultiDexApplication {

    public MyApplication() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        try{
            MultiDex.install(MyApplication.this);
        }
        catch (Exception e){e.printStackTrace();}
    }

    @Override
    public Context getApplicationContext() {
        return super.getApplicationContext();
    }

}
