package com.tuntasdigital.belajarandroiddasar;
import android.app.Application;
import android.util.Log;

public class MyApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("APP", "Application Created");
    }
}
