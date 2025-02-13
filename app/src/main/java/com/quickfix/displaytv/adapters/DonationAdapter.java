package com.quickfix.displaytv.adapters;


import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.quickfix.displaytv.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Map;

public class DonationAdapter extends RecyclerView.Adapter<DonationAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Map<String, String>> donaorsList;


    public DonationAdapter(Context context, ArrayList<Map<String, String>> pArrayList) {
        this.context = context;
        this.donaorsList = pArrayList;


    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.layout_donation, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        try {
            if (position % 2 == 0) {
                holder.linearLayout.setBackgroundColor(Color.parseColor("#BDBDBD"));
            } else {
                holder.linearLayout.setBackgroundColor(Color.parseColor("#FFFFFF"));
            }
            holder.txt_sno.setText((position + 1) + ".");
            holder.txt_fname.setText(donaorsList.get(position).get("firstName") + " " + donaorsList.get(position).get("lastName"));
            holder.txt_mobile_number.setText(donaorsList.get(position).get("mobile"));
            holder.txt_jan.setText(donaorsList.get(position).get("jan"));
            holder.txt_feb.setText(donaorsList.get(position).get("feb"));
            holder.txt_mar.setText(donaorsList.get(position).get("mar"));
            holder.txt_apr.setText(donaorsList.get(position).get("apr"));
            holder.txt_may.setText(donaorsList.get(position).get("may"));
            holder.txt_jun.setText(donaorsList.get(position).get("jun"));
            holder.txt_jul.setText(donaorsList.get(position).get("jul"));
            holder.txt_aug.setText(donaorsList.get(position).get("aug"));
            holder.txt_sept.setText(donaorsList.get(position).get("sept"));
            holder.txt_oct.setText(donaorsList.get(position).get("oct"));
            holder.txt_nov.setText(donaorsList.get(position).get("nov"));
            holder.txt_dec.setText(donaorsList.get(position).get("dec"));
            holder.txt_note.setText(donaorsList.get(position).get("note"));
            holder.txt_pa.setText(donaorsList.get(position).get("promiseAmount"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Override
    public int getItemCount() {
        return donaorsList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txt_sno;
        TextView txt_fname;
        TextView txt_mobile_number;
        TextView txt_note;
        TextView txt_jan;
        TextView txt_feb;
        TextView txt_mar;
        TextView txt_apr;
        TextView txt_may;
        TextView txt_jun;
        TextView txt_jul;
        TextView txt_aug;
        TextView txt_sept;
        TextView txt_oct;
        TextView txt_nov;
        TextView txt_dec;
        TextView txt_pa;
        LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            txt_sno = itemView.findViewById(R.id.txt_sno);
            txt_fname = itemView.findViewById(R.id.txt_fname);
            txt_mobile_number = itemView.findViewById(R.id.txt_mobile_number);
            txt_note = itemView.findViewById(R.id.txt_note);
            txt_jan = itemView.findViewById(R.id.txt_jan);
            txt_feb = itemView.findViewById(R.id.txt_feb);
            txt_mar = itemView.findViewById(R.id.txt_mar);
            txt_apr = itemView.findViewById(R.id.txt_apr);
            txt_may = itemView.findViewById(R.id.txt_may);
            txt_jun = itemView.findViewById(R.id.txt_jun);
            txt_jul = itemView.findViewById(R.id.txt_jul);
            txt_aug = itemView.findViewById(R.id.txt_aug);
            txt_sept = itemView.findViewById(R.id.txt_sept);
            txt_oct = itemView.findViewById(R.id.txt_oct);
            txt_nov = itemView.findViewById(R.id.txt_nov);
            txt_dec = itemView.findViewById(R.id.txt_dec);
            txt_pa = itemView.findViewById(R.id.txt_pa);
            linearLayout = itemView.findViewById(R.id.linearLayout);

        }
    }

}
