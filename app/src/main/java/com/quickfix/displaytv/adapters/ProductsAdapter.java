package com.quickfix.displaytv.adapters;


import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.quickfix.displaytv.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ViewHolder> {
    private Context context;
    private ArrayList<HashMap<String, Object>> pArrayList;

    public ProductsAdapter(Context context, ArrayList<HashMap<String, Object>> pArrayList) {
        this.context = context;
        this.pArrayList = pArrayList;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.row_products, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        try {
            holder.txtName.setText((String) pArrayList.get(position).get("productName"));
            holder.txtDPrice.setText((String) pArrayList.get(position).get("discountedPrice")+" $");
            holder.txtPrice.setText((String) pArrayList.get(position).get("price"));
            String image = (String) pArrayList.get(position).get("productImage");
            holder.txtPrice.setPaintFlags(holder.txtPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

            Picasso.get().load(image).into(holder.imgProduct);
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
        public TextView txtName;
        public TextView txtDPrice;

        public ViewHolder(View itemView) {
            super(itemView);
            this.imgProduct = itemView.findViewById(R.id.imgProduct);
            this.txtPrice = itemView.findViewById(R.id.txtPrice);
            this.txtName = itemView.findViewById(R.id.txtProduct);
            this.txtDPrice = itemView.findViewById(R.id.txtDPrice);
        }
    }

}
