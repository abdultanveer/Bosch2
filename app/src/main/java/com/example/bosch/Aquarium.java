package com.example.bosch;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public class Aquarium {

  // Constructor takes Application and lifecycle
  public Aquarium(final Application app,
                  Lifecycle lifecycle) {
    lifecycle.addObserver(new LifecycleObserver() {
      @OnLifecycleEvent(Lifecycle.Event.ON_START)
      public void start() {
        Log.i("Aquarium","lights on --activity has started");
      }

      @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
      public void myownOnStop(){
        Log.i("Aquarium","lights off --activity has stopped");

      }
    });


  }
}
