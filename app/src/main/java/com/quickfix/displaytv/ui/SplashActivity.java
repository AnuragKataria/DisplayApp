package com.quickfix.displaytv.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.util.Util;
import com.quickfix.displaytv.R;
import com.quickfix.displaytv.utils.Utils;
import com.quickfix.displaytv.viewpagertransformation.HomeActivity;

public class SplashActivity extends AppCompatActivity {
    private Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        context = this;
        ImageView splash = findViewById(R.id.splash);

        Animation animSlideDown = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_down);

        splash.setVisibility(View.GONE);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                splash.setVisibility(View.VISIBLE);
                splash.startAnimation(animSlideDown);
            }
        }, 500);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Later.. stop the animation
                splash.setAnimation(null);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (!Utils.isScreenActivated(context)) {
                            startActivity(new Intent(context, CodeActivateActivity.class));
                        } else {
                            startActivity(new Intent(context, HomeActivity.class));

                        }


                        finish();
                    }
                }, 1000);
            }
        }, 1500);
    }
}
