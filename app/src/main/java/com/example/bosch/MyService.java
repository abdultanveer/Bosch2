package com.example.bosch;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    public static String TAG = MyService.class.getSimpleName();
    LocalBinder localBinder = new LocalBinder();
    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG,"service got created");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
         super.onStartCommand(intent, flags, startId);
         String url = intent.getStringExtra("b2key");
        Log.i(TAG,"downloading from  "+url);
      //  stopSelf();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"service got destroyed");

    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return localBinder;
    }

    public class LocalBinder extends Binder {
        MyService getService() {
            // Return this instance of LocalService so clients can call public methods.
            return MyService.this;
        }
    }

    int add(int a, int b){
        return a + b;
    }

}