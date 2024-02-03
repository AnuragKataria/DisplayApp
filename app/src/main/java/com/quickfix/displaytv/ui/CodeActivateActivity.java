package com.quickfix.displaytv.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.util.Util;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.quickfix.displaytv.R;
import com.quickfix.displaytv.global.DisplayApplication;
import com.quickfix.displaytv.utils.Utils;
import com.quickfix.displaytv.viewpagertransformation.HomeActivity;

import org.w3c.dom.Text;

import java.util.HashMap;

public class CodeActivateActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView title;
    private Button btnActivate;
    private Context context;
    private DisplayApplication displayApplication;
    private EditText edCode;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activate_code);
        context = this;
        displayApplication = (DisplayApplication) getApplicationContext();
        btnActivate = findViewById(R.id.btnActivate);
        edCode = findViewById(R.id.edCode);
        title = findViewById(R.id.title);
        btnActivate.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnActivate:
                boolean isNetworkAvailable = Utils.isInternetAvailable(context);
                if (isNetworkAvailable) {
                    try {
                        String code = edCode.getText().toString().trim();
                        if (TextUtils.isEmpty(code)) {
                            Toast.makeText(context, "Please enter licence key", Toast.LENGTH_SHORT).show();
                        } else {
                            code = "APP_" + code;
                            activateScreen(code);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    Toast.makeText(context, Utils.NETWORK_MESSAGE, Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    private void activateScreen(String licenceKey) {
        displayApplication.getDatabaseReference().child("screens").child(licenceKey).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                try {
                    if (snapshot.getValue() != null) {

                        HashMap<String, Object> data = (HashMap<String, Object>) snapshot.getValue();
                        boolean isActivated = (boolean) data.get("isActivated");
                        String deviceID = (String) data.get("deviceId");
                        String expiryOn = (String) data.get("expiryOn");
                        int expireDays = 0;
                        if (expiryOn != null) {
                            if (expiryOn.equalsIgnoreCase("7 Days")) {
                                expireDays = 7;
                            } else if (expiryOn.equalsIgnoreCase("1 Month")) {
                                expireDays = 30;
                            } else if (expiryOn.equalsIgnoreCase("6 Months")) {
                                expireDays = 182;
                            } else if (expiryOn.equalsIgnoreCase("1 Year")) {
                                expireDays = 365;
                            } else if (expiryOn.equalsIgnoreCase("2 Years")) {
                                expireDays = 730;
                            } else if (expiryOn.equalsIgnoreCase("5 Years")) {
                                expireDays = 1825;
                            } else if (expiryOn.equalsIgnoreCase("Never")) {
                                expireDays = 30000;
                            } else {
                                expireDays = 7;

                            }
                        } else {
                            expireDays = 7;

                        }
                        Utils.setExpiryOn(context, expireDays);

//                        String uID = (String) data.get("assignedTo");
//                        String vID = (String) data.get("createdBy");
//                        Utils.setLicenseKey(context, licenceKey);
//                        Utils.setUserId(context, uID);
//                        Utils.setVendorId(context, vID);
//                        Toast.makeText(context, "Screen Activated Successfully", Toast.LENGTH_SHORT).show();
//                        Utils.setScreenActivated(context, true);
//                        startActivity(new Intent(context, HomeActivity.class));
//                        finish();
                        if (!deviceID.equals("N/A")) {
                            if (deviceID.equals(Utils.getDeviceID(context))) {
                                String uID = (String) data.get("assignedTo");
                                String vID = (String) data.get("createdBy");
                                Utils.setUserId(context, uID);
                                Utils.setVendorId(context, vID);
                                Utils.setLicenseKey(context, licenceKey);
                                Toast.makeText(context, "Screen Activated Successfully", Toast.LENGTH_SHORT).show();
                                Utils.setScreenActivated(context, true);
                                startActivity(new Intent(context, HomeActivity.class));
                                finish();
                            } else {
                                Toast.makeText(context, "This License has already been used in another Device", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            if (isActivated) {
                                Toast.makeText(context, "This License has already been used", Toast.LENGTH_SHORT).show();
                            } else {
                                String uID = (String) data.get("assignedTo");
                                String vID = (String) data.get("createdBy");
                                Utils.setUserId(context, uID);
                                Utils.setVendorId(context, vID);
                                HashMap<String, Object> a = new HashMap<>();
                                a.put("deviceId", Utils.getDeviceID(context));
                                a.put("isActivated", true);
                                a.put("licenseKey", licenceKey);
                                a.put("timeOfActivation", System.currentTimeMillis());
                                Utils.setLicenseKey(context, licenceKey);
                                displayApplication.getDatabaseReference().child("screens").child(licenceKey).updateChildren(a);
                                displayApplication.getDatabaseReference().child("vendor").child(Utils.getVendorId(context)).child("restaurants").child(Utils.getUserId(context))
                                        .child("screen")
                                        .child(Utils.getLicenseKey(context)).updateChildren(a);
                                Toast.makeText(context, "Screen Activated Successfully", Toast.LENGTH_SHORT).show();
                                Utils.setScreenActivated(context, true);
                                startActivity(new Intent(context, HomeActivity.class));
                                finish();
                            }
                        }


                    } else {
                        Toast.makeText(context, "Invalid License key", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                try {
                    Toast.makeText(context, error.getMessage(), Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

    }

}
