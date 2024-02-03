package com.quickfix.displaytv.global;

import android.app.Application;
import android.content.Context;

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

    }
}
