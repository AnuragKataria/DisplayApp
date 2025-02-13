package com.quickfix.displaytv.global;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

import androidx.lifecycle.ProcessLifecycleOwner;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DisplayApplication extends Application {

    public DatabaseReference getDatabaseReference() {
        return databaseReference;
    }

    public void setDatabaseReference(DatabaseReference databaseReference) {
        this.databaseReference = databaseReference;
    }

    private DatabaseReference databaseReference;
    private FirebaseDatabase firebaseDatabase;
    private Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        FirebaseApp.initializeApp(context);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
        setDatabaseReference(databaseReference);


        ProcessLifecycleOwner.get().getLifecycle().addObserver(new AppLifecycleListener(this));
        //Thread.setDefaultUncaughtExceptionHandler(onRuntimeError);


    }

    public Thread.UncaughtExceptionHandler onRuntimeError = new Thread.UncaughtExceptionHandler() {
        public void uncaughtException(Thread thread, Throwable ex) {
            try {
                    Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.quickfix.displaytv");
                    if (launchIntent != null) {
                        startActivity(launchIntent);
                        System.exit(0);
                    }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    };
}
