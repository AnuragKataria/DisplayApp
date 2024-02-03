package com.quickfix.displaytv.viewpagertransformation.Transformations;

import androidx.viewpager.widget.ViewPager;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;



public class SlowTransformation implements ViewPager.PageTransformer {


    @Override
    public void transformPage(View page, float position) {



        if (position < -1) { // [-Infinity,-1)
            // This page is way off-screen to the left.
            page.setAlpha(0);

        } else if (position <= 1) { // [-1,1]



//            // The 0.5, 1.0, 2.0, 2.5 values you see here are what makes the view move in a different speed.
//            // The bigger the number, the faster the view will translate.
//            // The result float is preceded by a minus because the views travel in the opposite direction of the movement.

        } else { // (1,+Infinity]
            // This page is way off-screen to the right.
            page.setAlpha(0);
        }
    }
}