package com.quickfix.displaytv.adapters;


import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.quickfix.displaytv.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StaggeredAdapter extends RecyclerView.Adapter<StaggeredAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Map<String, String>> pArrayList;
    int height;
    int width;
    public StaggeredAdapter(Context context, ArrayList<Map<String, String>> pArrayList , int height, int width) {
        this.context = context;
        this.pArrayList = pArrayList;
        this.height = height;
        this.width = width;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.row_stag_products, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        try {
            holder.txtName.setText( pArrayList.get(position).get("productName"));
            double p = Double.parseDouble(pArrayList.get(position).get("productPrice"));
            if(p == 0){
                holder.txtPrice.setText("");
            }else{
                holder.txtPrice.setText( pArrayList.get(position).get("productPrice")+" $");
            }
            holder.txtDesc.setText( pArrayList.get(position).get("productDescription"));
            String image =  pArrayList.get(position).get("productImage");
            Picasso.get().load(image).into(holder.imgProduct);
            RelativeLayout.LayoutParams layoutParams;
            switch (getItemCount()){
                case 1:
                    layoutParams = new RelativeLayout.LayoutParams(width, height-35);
                    holder.imgProduct.setLayoutParams(layoutParams);
                    break;
                case 2:
                    layoutParams = new RelativeLayout.LayoutParams(width/2, height-35);
                    holder.imgProduct.setLayoutParams(layoutParams);
                    break;
                case 3:
                    layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, height/2-35);
                    holder.imgProduct.setLayoutParams(layoutParams);
                case 4:
                    layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, height/2-35);
                    holder.imgProduct.setLayoutParams(layoutParams);
                    break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Override
    public int getItemCount() {
        return pArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imgProduct;
        public TextView txtPrice;
        public TextView txtDesc;
        public TextView txtName;

        public ViewHolder(View itemView) {
            super(itemView);
            this.imgProduct = itemView.findViewById(R.id.imgProduct);
            this.txtPrice = itemView.findViewById(R.id.txtPrice);
            this.txtName = itemView.findViewById(R.id.txtProduct);
            this.txtDesc = itemView.findViewById(R.id.txtDesc);
        }
    }

}
