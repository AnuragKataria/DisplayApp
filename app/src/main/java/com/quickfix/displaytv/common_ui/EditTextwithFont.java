package com.quickfix.displaytv.common_ui;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;

public class EditTextwithFont extends AppCompatEditText {


    public EditTextwithFont(Context context) {
        super(context);
        setTypeFace(context);
    }

    public EditTextwithFont(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setTypeFace(context);
    }

    public EditTextwithFont(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setTypeFace(context);
    }


    private void setTypeFace(Context context) {
        Typeface face = Typeface.createFromAsset(context.getAssets(), "fonts/font_text_.ttf");
        setTypeface(face);
    }
}
