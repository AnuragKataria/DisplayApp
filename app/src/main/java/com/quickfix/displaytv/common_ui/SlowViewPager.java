package com.quickfix.displaytv.common_ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;

import androidx.viewpager.widget.ViewPager;

import java.lang.reflect.Field;

public class SlowViewPager extends ViewPager {

    public SlowViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        initMyScroller();
    }

    private void initMyScroller() {
        try {
            Class<?> viewpager = ViewPager.class;
            Field scroller = viewpager.getDeclaredField("mScroller");
            scroller.setAccessible(true);
            scroller.set(this, new MyScroller(getContext())); // my liner scroller

            Field mFlingDistance = viewpager.getDeclaredField("mFlingDistance");
            mFlingDistance.setAccessible(true);
            mFlingDistance.set(this, 10);//10 dip

            Field mMinimumVelocity = viewpager.getDeclaredField("mMinimumVelocity");
            mMinimumVelocity.setAccessible(true);
            mMinimumVelocity.set(this, 0); //0 velocity

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public class MyScroller extends Scroller {
        public MyScroller(Context context) {
            super(context, new LinearInterpolator()); // my LinearInterpolator
        }

        @Override
        public void startScroll(int startX, int startY, int dx, int dy, int duration) {
            super.startScroll(startX, startY, dx, dy, 2000);//175 duration
        }
    }

}

