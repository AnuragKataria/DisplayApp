package com.quickfix.displaytv.global;


import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;

public class AppLifecycleListener implements DefaultLifecycleObserver {
    Context context;
    Intent backGroundService;

    public AppLifecycleListener(Context context) {
        this.context = context;
    }

    @Override
    public void onDestroy(@NonNull LifecycleOwner owner) {
        DefaultLifecycleObserver.super.onDestroy(owner);
        Log.d("Destroy", "Going into Killed");
    }

    @Override
    public void onStart(@NonNull LifecycleOwner owner) {
        Log.d("Start", "Going into foreground");
    }
    @Override
    public void onStop(@NonNull LifecycleOwner owner) {
        Log.d("Stop", "Going into background");

    }
}