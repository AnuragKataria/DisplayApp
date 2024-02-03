package com.quickfix.displaytv.viewpagertransformation;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import com.quickfix.displaytv.R;
import com.quickfix.displaytv.global.DisplayApplication;
import com.quickfix.displaytv.global.DisplaySingleTone;
import com.quickfix.displaytv.ui.SettingsActivity;
import com.quickfix.displaytv.utils.Utils;
import com.quickfix.displaytv.viewpagertransformation.Fragments.FirstFragment;
import com.quickfix.displaytv.viewpagertransformation.Fragments.ImageFragment;
import com.quickfix.displaytv.viewpagertransformation.Fragments.MainFragment;
import com.quickfix.displaytv.viewpagertransformation.Fragments.TemplateFiveFragment;
import com.quickfix.displaytv.viewpagertransformation.Fragments.TemplateFourFragment;
import com.quickfix.displaytv.viewpagertransformation.Fragments.TemplateOneFragment;
import com.quickfix.displaytv.viewpagertransformation.Fragments.TemplateThreeFragment;
import com.quickfix.displaytv.viewpagertransformation.Fragments.TemplateTwoFragment;
import com.quickfix.displaytv.viewpagertransformation.Fragments.VideoFragment;
import com.quickfix.displaytv.viewpagertransformation.Fragments.YoutubeFragment;
import com.quickfix.displaytv.viewpagertransformation.Transformations.AntiClockSpinTransformation;
import com.quickfix.displaytv.viewpagertransformation.Transformations.Clock_SpinTransformation;
import com.quickfix.displaytv.viewpagertransformation.Transformations.CubeInDepthTransformation;
import com.quickfix.displaytv.viewpagertransformation.Transformations.CubeInRotationTransformation;
import com.quickfix.displaytv.viewpagertransformation.Transformations.CubeInScalingTransformation;
import com.quickfix.displaytv.viewpagertransformation.Transformations.CubeOutDepthTransformation;
import com.quickfix.displaytv.viewpagertransformation.Transformations.CubeOutRotationTransformation;
import com.quickfix.displaytv.viewpagertransformation.Transformations.CubeOutScalingTransformation;
import com.quickfix.displaytv.viewpagertransformation.Transformations.DepthTransformation;
import com.quickfix.displaytv.viewpagertransformation.Transformations.FadeOutTransformation;
import com.quickfix.displaytv.viewpagertransformation.Transformations.FanTransformation;
import com.quickfix.displaytv.viewpagertransformation.Transformations.FidgetSpinTransformation;
import com.quickfix.displaytv.viewpagertransformation.Transformations.GateTransformation;
import com.quickfix.displaytv.viewpagertransformation.Transformations.HingeTransformation;
import com.quickfix.displaytv.viewpagertransformation.Transformations.HorizontalFlipTransformation;
import com.quickfix.displaytv.viewpagertransformation.Transformations.PopTransformation;
import com.quickfix.displaytv.viewpagertransformation.Transformations.SimpleTransformation;
import com.quickfix.displaytv.viewpagertransformation.Transformations.SlowTransformation;
import com.quickfix.displaytv.viewpagertransformation.Transformations.SpinnerTransformation;
import com.quickfix.displaytv.viewpagertransformation.Transformations.TossTransformation;
import com.quickfix.displaytv.viewpagertransformation.Transformations.VerticalFlipTransformation;
import com.quickfix.displaytv.viewpagertransformation.Transformations.VerticalShutTransformation;
import com.quickfix.displaytv.viewpagertransformation.Transformations.ZoomOutTransformation;

import org.json.JSONArray;

import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.stream.Collectors;

import okhttp3.internal.Util;

public class HomeActivity extends AppCompatActivity {
    private Context context;
    private ViewPager viewPager;
    private MyPagerAdapter pagerAdapter;
    private int currentPage = 0;
    private Timer timer;
    private long DELAY_MS = 10000;
    private long PERIOD_MS = 10000;
    private boolean isEnd = false;
    private boolean isStart = false;
    private DisplayApplication displayApplication;
    private int size;

    Dialog expirydialog;
    private Handler myhandler = new Handler();
    private Runnable myrunnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transformation);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED | WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON | WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        context = this;
        expirydialog = new Dialog(context);
        displayApplication = (DisplayApplication) getApplicationContext();
        viewPager = findViewById(R.id.viewpager);
    }

    @Override
    protected void onResume() {
        super.onResume();
        try {
            if (isTimeAutomatic(context)) {

                try {
                    setData();
                    activateScreen(Utils.getLicenseKey(context));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                showTimeZoneDialog();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isTimeAutomatic(Context c) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            return Settings.Global.getInt(c.getContentResolver(), Settings.Global.AUTO_TIME, 0) == 1;
        } else {
            return android.provider.Settings.System.getInt(c.getContentResolver(), android.provider.Settings.System.AUTO_TIME, 0) == 1;
        }
    }

    private void getDataFromServer() {
        Log.i("DATATAT", Utils.getVendorId(context));
        displayApplication.getDatabaseReference().child("vendor").child(Utils.getVendorId(context)).child("restaurants").child(Utils.getUserId(context))
                .child("screen")
                .child(Utils.getLicenseKey(context))
                .child("pages").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        try {
                            size = (int) snapshot.getChildrenCount();
                            pagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
                            if (snapshot.getValue() != null) {
                                ArrayList<HashMap<String, Object>> dataArrayList = new ArrayList<>();
                                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                    HashMap<String, Object> dataObject = (HashMap<String, Object>) dataSnapshot.getValue();
                                    dataArrayList.add(dataObject);
                                    setDataOnViewFirst(dataObject);
                                }

                                Utils.saveData(context, dataArrayList);
                                viewPager.setAdapter(pagerAdapter);
                                Log.i("DATA FROM FIREBASE", dataArrayList.toString());
                                myhandler.postDelayed(myrunnable = new Runnable() {
                                    public void run() {
                                        boolean smoothScroll = true;
                                        if (currentPage == size - 1) {
                                            isEnd = true;
                                            isStart = false;
                                        }
                                        if (currentPage == 0) {
                                            isEnd = false;
                                            isStart = true;
                                        }
                                        if (isEnd) {
                                            currentPage = 0;
                                            smoothScroll = false;

                                        }
                                        if (isStart) {
                                            currentPage++;
                                        }
                                        viewPager.setCurrentItem(currentPage, smoothScroll);
                                        myhandler.postDelayed(myrunnable, DELAY_MS);
                                    }
                                }, DELAY_MS);

                            } else {
                                Toast.makeText(context, "No data available for this User", Toast.LENGTH_SHORT).show();
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

    private void getTimeStampFromServer() {
        displayApplication.getDatabaseReference().child("vendor").child(Utils.getVendorId(context)).child("restaurants").child(Utils.getUserId(context))
                .child("screen")
                .child(Utils.getLicenseKey(context))
                .child("timeOfActivation").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        try {
                            if (snapshot.getValue() != null) {
                                long timestamp = (long) snapshot.getValue();
                                int days = getTimeStampDiff(timestamp);
                                int expiryOn = Utils.getExpiryOn(context);
                                if (days > expiryOn) {
                                    showExpiryDialog();
                                } else {
                                    if (expirydialog != null && expirydialog.isShowing()) {
                                        expirydialog.dismiss();
                                    }

                                }

                            } else {
                                Toast.makeText(context, "No data available for this User", Toast.LENGTH_SHORT).show();
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

    private void setDataOnView(HashMap<String, Object> dataObject) throws IOException {
        String name = (String) dataObject.get("name");
        String selectedAnimation = (String) dataObject.get("selectedAnimation");
        String time = (String) dataObject.get("time");
//        PERIOD_MS = 10000;
//        DELAY_MS = 10000;

        if (time == null) {
            PERIOD_MS = 60000;
            DELAY_MS = 60000;
        } else if (time.contains("30")) {
            PERIOD_MS = 30000;
            DELAY_MS = 30000;
        } else if (time.contains("1")) {
            PERIOD_MS = 60000;
            DELAY_MS = 60000;
        } else if (time.contains("2")) {
            PERIOD_MS = 120000;
            DELAY_MS = 120000;
        } else if (time.contains("3")) {
            PERIOD_MS = 180000;
            DELAY_MS = 180000;
        } else if (time.contains("4")) {
            PERIOD_MS = 240000;
            DELAY_MS = 240000;
        } else if (time.contains("5")) {
            PERIOD_MS = 300000;
            DELAY_MS = 300000;
        } else {
            PERIOD_MS = 60000;
            DELAY_MS = 60000;
        }
        setAnimations(selectedAnimation);
        String template = (String) dataObject.get("template");
        boolean isPublished = (boolean) dataObject.get("isPublish");
        if (isPublished) {
            ArrayList<HashMap<String, String>> images = (ArrayList<HashMap<String, String>>) dataObject.get("styleImages");


            LinkedTreeMap<String, HashMap<String, Object>> productMap = (LinkedTreeMap<String, HashMap<String, Object>>) dataObject.get("products");
            Gson gson = new Gson();
            JsonObject jsonObject = gson.toJsonTree(productMap).getAsJsonObject();


            JsonArray jsonArray = gson.toJsonTree(images).getAsJsonArray();
            Object mapper = new ObjectMapper();
            HashMap<String, HashMap<String, Object>> data = ((ObjectMapper) mapper).readValue(
                    String.valueOf(jsonObject), new TypeReference<HashMap<String, HashMap<String, Object>>>() {
                    });
            ArrayList<HashMap<String, String>> img = ((ObjectMapper) mapper).readValue(
                    String.valueOf(jsonArray), new TypeReference<ArrayList<HashMap<String, String>>>() {
                    });

            Log.i("Product map ", data.toString());
            switch (template) {
                case "-NV0dvLRAz9V0fKXQtqg":
                    pagerAdapter.addFragments(new TemplateOneFragment(data, img, name));
                    break;
                case "-NWi4bcsWu6BjB0kCaWd":
                    pagerAdapter.addFragments(new TemplateTwoFragment(data, img, name));
                    break;
                case "-NWi380WUajWU9pXrCeC":
                    pagerAdapter.addFragments(new TemplateThreeFragment(data, img, name));
                    break;
            }

//            switch (template) {
//                case "-NV0dvLRAz9V0fKXQtqg":
//                    pagerAdapter.addFragments(new TemplateOneFragment(data, images, name));
//                    break;
//                case "-NVJ_MFKgeCDNzduZynf":
//                    pagerAdapter.addFragments(new TemplateTwoFragment(data, images, name));
//                    break;
//                case "-NVW3pILtLwKkYqMY6dd":
//                    pagerAdapter.addFragments(new TemplateThreeFragment(data, images, name));
//                    break;
//            }
        }
    }

    private void activateScreen(String licenceKey) {
        displayApplication.getDatabaseReference().child("screens").child(licenceKey).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                try {
                    if (snapshot.getValue() != null) {
                        HashMap<String, Object> data = (HashMap<String, Object>) snapshot.getValue();
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
                        getTimeStampFromServer();


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

    private void setDataOnViewFirst(HashMap<String, Object> dataObject) {
        String link = (String) dataObject.get("mediaLink");
        String type = (String) dataObject.get("mediaType");
        String time = null;
        setAnimations("VERTICAL_FLIP_TRANSFORMATION");
        if (time == null) {
            PERIOD_MS = 60000;
            DELAY_MS = 60000;
        } else if (time.contains("30")) {
            PERIOD_MS = 30000;
            DELAY_MS = 30000;
        } else if (time.contains("1")) {
            PERIOD_MS = 60000;
            DELAY_MS = 60000;
        } else if (time.contains("2")) {
            PERIOD_MS = 120000;
            DELAY_MS = 120000;
        } else if (time.contains("3")) {
            PERIOD_MS = 180000;
            DELAY_MS = 180000;
        } else if (time.contains("4")) {
            PERIOD_MS = 240000;
            DELAY_MS = 240000;
        } else if (time.contains("5")) {
            PERIOD_MS = 300000;
            DELAY_MS = 300000;
        } else {
            PERIOD_MS = 60000;
            DELAY_MS = 60000;
        }
        switch (type) {
            case "YouTube":
                if (DisplaySingleTone.getInstance().getFirstType() == -1) {
                    DisplaySingleTone.getInstance().setFirstType(2);
                }
                pagerAdapter.addFragments(new YoutubeFragment(link));
                break;
            case "Videos":
                if (DisplaySingleTone.getInstance().getFirstType() == -1) {
                    DisplaySingleTone.getInstance().setFirstType(1);
                }
                pagerAdapter.addFragments(new VideoFragment("https://" + link));
                break;
            case "Images":
                if (DisplaySingleTone.getInstance().getFirstType() == -1) {
                    DisplaySingleTone.getInstance().setFirstType(0);
                }
                pagerAdapter.addFragments(new ImageFragment("https://" + link));
                break;
        }


        //        String name = (String) dataObject.get("name");
//        String time = (String) dataObject.get("time");
//        String selectedAnimation = (String) dataObject.get("selectedAnimation");
//        String template = (String) dataObject.get("template");
//        boolean isPublished = (boolean) dataObject.get("isPublish");
//        if (isPublished) {
//            ArrayList<HashMap<String, String>> images = (ArrayList<HashMap<String, String>>) dataObject.get("styleImages");
//            Log.i("Images", images.toString());
//
//
//            HashMap<String, HashMap<String, Object>> productsMap = (HashMap<String, HashMap<String, Object>>) dataObject.get("products");
//
//
//            switch (template) {
//                case "-NWi5dpoXgG8Cb8qBJk6":
//                    pagerAdapter.addFragments(new TemplateOneFragment(productsMap, images, name));
//                    break;
//                case "-NWi4bcsWu6BjB0kCaWd":
//                    pagerAdapter.addFragments(new TemplateTwoFragment(productsMap, images, name));
//                    break;
//                case "-NWi380WUajWU9pXrCeC":
//                    pagerAdapter.addFragments(new TemplateThreeFragment(productsMap, images, name));
//                    break;
//            }
//
//        }

    }

    private void setAnimations(String animationType) {
        SimpleTransformation simpleTransformation = new SimpleTransformation();
        VerticalFlipTransformation verticalFlipTransformation = new VerticalFlipTransformation();
        HorizontalFlipTransformation horizontalFlipTransformation = new HorizontalFlipTransformation();
        CubeInDepthTransformation cubeInDepthTransformation = new CubeInDepthTransformation();
        VerticalShutTransformation verticalShutTransformation = new VerticalShutTransformation();

        switch (animationType) {
            case "SIMPLE_TRANSFORMATION":
                viewPager.setPageTransformer(true, simpleTransformation);
                Utils.setAnimation(context, Constant.SIMPLE_TRANSFORMATION);
                break;
            case "VERTICAL_FLIP_TRANSFORMATION":
                viewPager.setPageTransformer(true, verticalFlipTransformation);
                Utils.setAnimation(context, Constant.VERTICAL_FLIP_TRANSFORMATION);
                break;
            case "HORIZONTAL_FLIP_TRANSFORMATION":
                viewPager.setPageTransformer(true, horizontalFlipTransformation);
                Utils.setAnimation(context, Constant.HORIZONTAL_FLIP_TRANSFORMATION);
                break;
            case "CUBE_IN_TRANSFORMATION":
                viewPager.setPageTransformer(true, cubeInDepthTransformation);
                Utils.setAnimation(context, Constant.CUBE_IN_TRANSFORMATION);
                break;
            case "VERTICAL_SHUT_TRANSFORMATION":
                viewPager.setPageTransformer(true, verticalShutTransformation);
                Utils.setAnimation(context, Constant.VERTICAL_SHUT_TRANSFORMATION);
                break;
        }
    }

    private int getTimeStampDiff(long timestamp1) {
        long timestamp2 = System.currentTimeMillis();
        long timeDifference = timestamp2 - timestamp1;
        long daysDifference = timeDifference / (24 * 60 * 60 * 1000);
        System.out.println("The difference in days is: " + daysDifference);
        return (int) daysDifference;
    }

    private void showExpiryDialog() {
        expirydialog.setContentView(R.layout.dialog_expiry);
        expirydialog.setCancelable(false);
        expirydialog.show();
        expirydialog.getWindow().setBackgroundDrawable(new ColorDrawable(context.getResources().getColor(android.R.color.transparent)));
    }

    private void showTimeZoneDialog() {
        Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.dialog_automatic_time);
        dialog.setCancelable(false);
        Button btnEnable = dialog.findViewById(R.id.btnEnable);
        btnEnable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                startActivityForResult(new Intent(android.provider.Settings.ACTION_DATE_SETTINGS), 0);
            }
        });
        dialog.show();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(context.getResources().getColor(android.R.color.transparent)));


    }

    private void setData() {
        if (Utils.isInternetAvailable(context)) {
            try {
                getDataFromServer();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }


//        else if (Utils.getData(context) != null) {
//            ArrayList<HashMap<String, Object>> datArrayList = Utils.getData(context);
//            size = datArrayList.size();
//            pagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
//            for (HashMap<String, Object> dataObject : datArrayList) {
//                try {
//                    setDataOnView(dataObject);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            viewPager.setAdapter(pagerAdapter);
//            myhandler.postDelayed(myrunnable = new Runnable() {
//                public void run() {
//                    if (currentPage == size) {
//                        isEnd = true;
//                        isStart = false;
//                    }
//                    if (currentPage == 0) {
//                        isEnd = false;
//                        isStart = true;
//                    }
//                    if (isEnd) {
//                        currentPage--;
//                    }
//                    if (isStart) {
//                        currentPage++;
//                    }
//                    viewPager.setCurrentItem(currentPage, true);
//
//                    myhandler.postDelayed(myrunnable, DELAY_MS);
//
//
//                }
//            }, DELAY_MS);
//        }
//

        else {
            Toast.makeText(context, Utils.NETWORK_MESSAGE, Toast.LENGTH_SHORT).show();

        }
    }

    private void setAnimationExtra() {

//        SlowTransformation slowTransformation = new SlowTransformation();
//        SimpleTransformation simpleTransformation = new SimpleTransformation();
//        DepthTransformation depthTransformation = new DepthTransformation();
//        ZoomOutTransformation zoomOutTransformation = new ZoomOutTransformation();
//        Clock_SpinTransformation clockSpinTransformation = new Clock_SpinTransformation();
//        AntiClockSpinTransformation antiClockSpinTransformation = new AntiClockSpinTransformation();
//        FidgetSpinTransformation fidgetSpinTransformation = new FidgetSpinTransformation();
//        VerticalFlipTransformation verticalFlipTransformation = new VerticalFlipTransformation();
//        HorizontalFlipTransformation horizontalFlipTransformation = new HorizontalFlipTransformation();
//        PopTransformation popTransformation = new PopTransformation();
//        FadeOutTransformation fadeOutTransformation = new FadeOutTransformation();
//        CubeOutRotationTransformation cubeOutRotationTransformation = new CubeOutRotationTransformation();
//        CubeInRotationTransformation cubeInRotationTransformation = new CubeInRotationTransformation();
//        CubeOutScalingTransformation cubeOutScalingTransformation = new CubeOutScalingTransformation();
//        CubeInScalingTransformation cubeInScalingTransformation = new CubeInScalingTransformation();
//        CubeOutDepthTransformation cubeOutDepthTransformation = new CubeOutDepthTransformation();
//        CubeInDepthTransformation cubeInDepthTransformation = new CubeInDepthTransformation();
//        HingeTransformation hingeTransformation = new HingeTransformation();
//        GateTransformation gateTransformation = new GateTransformation();
//        TossTransformation tossTransformation = new TossTransformation();
//        FanTransformation fanTransformation = new FanTransformation();
//        SpinnerTransformation spinnerTransformation = new SpinnerTransformation();
//        VerticalShutTransformation verticalShutTransformation = new VerticalShutTransformation();


//        String transformation = Utils.getAnimation(context);
//        switch (transformation) {
//            case Constant.SLOW_TRANSFORMATION:
//                viewPager.setPageTransformer(true, slowTransformation);
//                break;
//            case Constant.SIMPLE_TRANSFORMATION:
//                viewPager.setPageTransformer(true, simpleTransformation);
//                break;
//            case Constant.DEPTH_TRANSFORMATION:
//                viewPager.setPageTransformer(true, depthTransformation);
//                break;
//            case Constant.ZOOM_OUT_TRANSFORMATION:
//                viewPager.setPageTransformer(true, zoomOutTransformation);
//                break;
//            case Constant.CLOCK_SPIN_TRANSFORMATION:
//                viewPager.setPageTransformer(true, clockSpinTransformation);
//                break;
//            case Constant.ANTICLOCK_SPIN_TRANSFORMATION:
//                viewPager.setPageTransformer(true, antiClockSpinTransformation);
//                break;
//            case Constant.FIDGET_SPINNER_TRANSFORMATION:
//                viewPager.setPageTransformer(true, fidgetSpinTransformation);
//                break;
//            case Constant.VERTICAL_FLIP_TRANSFORMATION:
//                viewPager.setPageTransformer(true, verticalFlipTransformation);
//                break;
//            case Constant.HORIZONTAL_FLIP_TRANSFORMATION:
//                viewPager.setPageTransformer(true, horizontalFlipTransformation);
//                break;
//            case Constant.POP_TRANSFORMATION:
//                viewPager.setPageTransformer(true, popTransformation);
//                break;
//            case Constant.FADE_OUT_TRANSFORMATION:
//                viewPager.setPageTransformer(true, fadeOutTransformation);
//                break;
//            case Constant.CUBE_OUT_TRANSFORMATION:
//                viewPager.setPageTransformer(true, cubeOutRotationTransformation);
//                break;
//            case Constant.CUBE_IN_TRANSFORMATION:
//                viewPager.setPageTransformer(true, cubeInRotationTransformation);
//                break;
//            case Constant.CUBE_OUT_SCALING_TRANSFORMATION:
//                viewPager.setPageTransformer(true, cubeOutScalingTransformation);
//                break;
//            case Constant.CUBE_IN_SCALING_TRANSFORMATION:
//                viewPager.setPageTransformer(true, cubeInScalingTransformation);
//                break;
//            case Constant.CUBE_OUT_DEPTH_TRANSFORMATION:
//                viewPager.setPageTransformer(true, cubeOutDepthTransformation);
//                break;
//            case Constant.CUBE_IN_DEPTH_TRANSFORMATION:
//                viewPager.setPageTransformer(true, cubeInDepthTransformation);
//                break;
//            case Constant.HINGE_TRANSFORMATION:
//                viewPager.setPageTransformer(true, hingeTransformation);
//                break;
//            case Constant.GATE_TRANSFORMATION:
//                viewPager.setPageTransformer(true, gateTransformation);
//                break;
//            case Constant.TOSS_TRANSFORMATION:
//                viewPager.setPageTransformer(true, tossTransformation);
//                break;
//            case Constant.FAN_TRANSFORMATION:
//                viewPager.setPageTransformer(true, fanTransformation);
//                break;
//            case Constant.SPINNER_TRANSFORMATION:
//                viewPager.setPageTransformer(true, spinnerTransformation);
//                break;
//            case Constant.VERTICAL_SHUT_TRANSFORMATION:
//                viewPager.setPageTransformer(true, verticalShutTransformation);
//                break;
//        }
    }

}