package com.quickfix.displaytv.viewpagertransformation.Fragments;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
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
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;

public class TemplateDonationFragment extends Fragment {
    private Map<String, Object> productMap;
    private LinearLayout linearTop;
    private RecyclerView recycleViewDonation;

    public TemplateDonationFragment(Map<String, Object> productMap) {
        this.productMap = productMap;
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
    final int speedScroll = 3000;
    final Handler handler = new Handler();

    final Runnable runnable = new Runnable() {
        int count = 0;
        boolean flag = true;
        @Override
        public void run() {
            if(count < donationAdapter.getItemCount()){
                if(count==donationAdapter.getItemCount()-1){
                    flag = false;
                }else if(count == 0){
                    flag = true;
                }
                if(flag) count++;
                else count--;

                recycleViewDonation.smoothScrollToPosition(count);
                handler.postDelayed(this,speedScroll);
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
    private void assignIds(View v) throws Exception {
        linearTop = v.findViewById(R.id.linearTop);
        LayoutInflater vi = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Map<String, Object> donaorsMap = (Map<String, Object>) productMap.get("donars");
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        ArrayList<Map<String, String>> donaorsList = (ArrayList<Map<String, String>>) donaorsMap.get(year+"");
        recycleViewDonation = v.findViewById(R.id.recycleViewDonation);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recycleViewDonation.setLayoutManager(linearLayoutManager);
         donationAdapter = new DonationAdapter(getActivity(),donaorsList );
        recycleViewDonation.setAdapter(donationAdapter);
        handler.postDelayed(runnable,speedScroll);

//        for (int i = 0; i < donaorsList.size(); i++) {
//            View inflaterView = vi.inflate(R.layout.layout_donation, null);
//            LinearLayout linearLayout = inflaterView.findViewById(R.id.linearLayout);
//            if (i % 2 == 0) {
//                linearLayout.setBackgroundColor(Color.parseColor("#BDBDBD"));
//            }else{
//                linearLayout.setBackgroundColor(Color.parseColor("#FFFFFF"));
//
//            }
//            TextView txt_sno = inflaterView.findViewById(R.id.txt_sno);
//            TextView txt_fname = inflaterView.findViewById(R.id.txt_fname);
//            TextView txt_mobile_number = inflaterView.findViewById(R.id.txt_mobile_number);
//            TextView txt_note = inflaterView.findViewById(R.id.txt_note);
//            TextView txt_jan = inflaterView.findViewById(R.id.txt_jan);
//            TextView txt_feb = inflaterView.findViewById(R.id.txt_feb);
//            TextView txt_mar = inflaterView.findViewById(R.id.txt_mar);
//            TextView txt_apr = inflaterView.findViewById(R.id.txt_apr);
//            TextView txt_may = inflaterView.findViewById(R.id.txt_may);
//            TextView txt_jun = inflaterView.findViewById(R.id.txt_jun);
//            TextView txt_jul = inflaterView.findViewById(R.id.txt_jul);
//            TextView txt_aug = inflaterView.findViewById(R.id.txt_aug);
//            TextView txt_sept = inflaterView.findViewById(R.id.txt_sept);
//            TextView txt_oct = inflaterView.findViewById(R.id.txt_oct);
//            TextView txt_nov = inflaterView.findViewById(R.id.txt_nov);
//            TextView txt_dec = inflaterView.findViewById(R.id.txt_dec);
//            txt_sno.setText((i + 1) + ".");
//            txt_fname.setText(donaorsList.get(i).get("firstName") + " " + donaorsList.get(i).get("lastName"));
//            txt_mobile_number.setText(donaorsList.get(i).get("mobile"));
//            txt_jan.setText(donaorsList.get(i).get("jan"));
//            txt_feb.setText(donaorsList.get(i).get("feb"));
//            txt_mar.setText(donaorsList.get(i).get("mar"));
//            txt_apr.setText(donaorsList.get(i).get("apr"));
//            txt_may.setText(donaorsList.get(i).get("may"));
//            txt_jun.setText(donaorsList.get(i).get("jun"));
//            txt_jul.setText(donaorsList.get(i).get("jul"));
//            txt_aug.setText(donaorsList.get(i).get("aug"));
//            txt_sept.setText(donaorsList.get(i).get("sept"));
//            txt_oct.setText(donaorsList.get(i).get("oct"));
//            txt_nov.setText(donaorsList.get(i).get("nov"));
//            txt_dec.setText(donaorsList.get(i).get("dec"));
//            txt_note.setText(donaorsList.get(i).get("note"));
//            linearTop.addView(inflaterView);
//        }
//
    }

}
