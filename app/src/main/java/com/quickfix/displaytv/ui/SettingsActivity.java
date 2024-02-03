package com.quickfix.displaytv.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.quickfix.displaytv.R;
import com.quickfix.displaytv.utils.Utils;
import com.quickfix.displaytv.viewpagertransformation.Constant;
import com.quickfix.displaytv.viewpagertransformation.HomeActivity;

public class SettingsActivity extends AppCompatActivity {

    private Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        context = this;
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        Button btnActivate = findViewById(R.id.btnActivate);

        btnActivate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Utils.getAnimation(context) != null) {
                    Utils.setSettingsSaved(context, true);
                    startActivity(new Intent(context, HomeActivity.class));
                    finish();
                }else{
                    Toast.makeText(context, "Please select one animation", Toast.LENGTH_SHORT).show();
                }
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.one:
                        Utils.setAnimation(context, Constant.SIMPLE_TRANSFORMATION);
                        break;
                    case R.id.two:
                        Utils.setAnimation(context, Constant.VERTICAL_FLIP_TRANSFORMATION);
                        break;
                    case R.id.three:
                        Utils.setAnimation(context, Constant.HORIZONTAL_FLIP_TRANSFORMATION);
                        break;
                    case R.id.four:
                        Utils.setAnimation(context, Constant.CUBE_IN_TRANSFORMATION);
                        break;
                    case R.id.five:
                        Utils.setAnimation(context, Constant.VERTICAL_SHUT_TRANSFORMATION);
                        break;
                }
            }
        });

    }
}
