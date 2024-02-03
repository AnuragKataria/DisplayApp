package com.quickfix.displaytv.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.preference.PreferenceManager;
import android.provider.Settings;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Utils {


    public static final String NETWORK_MESSAGE = "Internet is not available";

    public static boolean isInternetAvailable(Context context) {
        ConnectivityManager conMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = conMgr.getActiveNetworkInfo();
        if (netInfo == null) {
            return false;
        } else {
            return true;
        }

    }

    public static boolean isSettingsSaved(Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        boolean isScreenActivated = preferences.getBoolean("SETTINGS", false);
        return isScreenActivated;
    }

    public static void setSettingsSaved(Context context, boolean isScreenActivated) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("SETTINGS", isScreenActivated);
        editor.apply();

    }

    public static String getAnimation(Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        String animation = preferences.getString("ANIMATION", null);
        return animation;
    }

    public static void setAnimation(Context context, String animation) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("ANIMATION", animation);
        editor.apply();

    }

    public static int getExpiryOn(Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        int expiryOn = preferences.getInt("expiryOn", 0);
        return expiryOn;
    }

    public static void setExpiryOn(Context context, int expiryOn) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("expiryOn", expiryOn);
        editor.apply();

    }


    public static boolean isScreenActivated(Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        boolean isScreenActivated = preferences.getBoolean("SCREEN_ACTIVATED", false);
        return isScreenActivated;
    }

    public static void setScreenActivated(Context context, boolean isScreenActivated) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("SCREEN_ACTIVATED", isScreenActivated);
        editor.apply();

    }

    public static String getDeviceID(Context context) {
        String android_id = Settings.Secure.getString(context.getContentResolver(),
                Settings.Secure.ANDROID_ID);
        return android_id;
    }


    public static String getVendorId(Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        String vid = preferences.getString("vid", null);
        return vid;
    }

    public static void setVendorId(Context context, String vid) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("vid", vid);
        editor.apply();

    }


    public static String getLicenseKey(Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        String lKey = preferences.getString("lKey", null);
        return lKey;
    }

    public static void setLicenseKey(Context context, String lKey) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("lKey", lKey);
        editor.apply();

    }


    public static String getUserId(Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        String uid = preferences.getString("uid", null);
        return uid;
    }

    public static void setUserId(Context context, String uid) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("uid", uid);
        editor.apply();

    }


    public static void saveData(Context context, ArrayList<HashMap<String, Object>> arrayList) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        Gson gson = new Gson();
        String json = gson.toJson(arrayList);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("ARRAYLIST", json);
        editor.commit();

    }


    public static ArrayList<HashMap<String, Object>> getData(Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        Gson gson = new Gson();
        String json = preferences.getString("ARRAYLIST", "");
        if (json.isEmpty()) {
            return null;
        } else {
            Type type = new TypeToken<ArrayList<HashMap<String, Object>>>() {
            }.getType();
            ArrayList<HashMap<String, Object>> arrayList = gson.fromJson(json, type);
            return arrayList;

        }
    }
}
