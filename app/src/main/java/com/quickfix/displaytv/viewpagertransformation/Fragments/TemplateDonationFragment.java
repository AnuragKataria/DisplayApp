package com.quickfix.displaytv.viewpagertransformation.Fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.quickfix.displaytv.R;
import com.quickfix.displaytv.adapters.DonationAdapter;
import com.quickfix.displaytv.utils.Utils;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;

public class TemplateDonationFragment extends Fragment {
    private Map<String, Object> productMap;
    private LinearLayout linearTop;
    private RecyclerView recycleViewDonation;
    private TextView txt_year;
    private TextView txt_masjid_name;
    private TextView marqueeText;
    private ImageView imgSettings;
    private String ticker;

    public TemplateDonationFragment(Map<String, Object> productMap, String ticker) {
        this.productMap = productMap;
        this.ticker = ticker;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_template_donation, container, false);
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        try {
            assignIds(view);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    DonationAdapter donationAdapter;
    int speedScroll = 300;
    final Handler handler = new Handler();

    final Runnable runnable = new Runnable() {
        int count = 0;
        boolean flag = true;

        @Override
        public void run() {
            try {
                if (count < donationAdapter.getItemCount()) {
                    if (count == donationAdapter.getItemCount() - 1) {

                        flag = false;
                    } else if (count == 0) {
                        flag = true;
                    }
                    if (flag) {
                        count++;
                    } else {
                        count--;
                    }

                    if (count == 15) {
                        speedScroll = 2000;
                    }
                    recycleViewDonation.smoothScrollToPosition(count);
                    handler.postDelayed(this, speedScroll);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    };

    @Override
    public void onStop() {
        super.onStop();
        try {
            handler.removeCallbacks(runnable);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressLint("SetTextI18n")
    private void assignIds(View v) throws Exception {
        linearTop = v.findViewById(R.id.linearTop);
        marqueeText = v.findViewById(R.id.marqueeText);
        imgSettings = v.findViewById(R.id.imgSettings);
        imgSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Settings.ACTION_SETTINGS));
            }
        });
        txt_year = v.findViewById(R.id.txt_year);
        txt_masjid_name = v.findViewById(R.id.txt_masjid_name);
        LayoutInflater vi = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Map<String, Object> donaorsMap = (Map<String, Object>) productMap.get("donars");
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        txt_year.setText(year + " Monthly Contributions");
        marqueeText.setText(ticker);
        marqueeText.setSelected(true);
        String name = Utils.getUserName(getContext());
        txt_masjid_name.setText(name);
        ArrayList<Map<String, String>> donaorsList = (ArrayList<Map<String, String>>) donaorsMap.get(year + "");
        recycleViewDonation = v.findViewById(R.id.recycleViewDonation);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recycleViewDonation.setLayoutManager(linearLayoutManager);
        donationAdapter = new DonationAdapter(getActivity(), donaorsList);
        recycleViewDonation.setAdapter(donationAdapter);
        handler.postDelayed(runnable, speedScroll);
    }

}
