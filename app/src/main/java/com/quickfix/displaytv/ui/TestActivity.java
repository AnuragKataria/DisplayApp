package com.quickfix.displaytv.ui;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.quickfix.displaytv.R;

public class TestActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_template_donation);
        TextView marqueeText = findViewById(R.id.marqueeText);
        marqueeText.setText("This is a marquee text in Android. It will scroll continuously!This is a marquee text in Android. It will scroll continuously! This is a marquee text in Android. It will scroll continuously!");
        marqueeText.setSelected(true);
    }
}
