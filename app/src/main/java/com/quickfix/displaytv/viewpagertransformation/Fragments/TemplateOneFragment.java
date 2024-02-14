package com.quickfix.displaytv.viewpagertransformation.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.quickfix.displaytv.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Map;
import java.util.Map;

public class TemplateOneFragment extends Fragment {
    private Map<String, Object> productMap;
    private ImageView img_cate_1_prod_1;
    private ImageView img_cate_1_prod_2;
    private ImageView img_cate_1_prod_3;
    private ImageView img_cate_1_prod_4;
    private ImageView img_cate_1_prod_5;
    private ImageView img_cate_1_prod_6;
    private ImageView img_cate_1_prod_7;
    private ImageView img_cate_1_prod_8;
    private ImageView img_cate_1_prod_9;
    private ImageView img_cate_1_prod_10;
    private ImageView img_cate_1_prod_11;
    private ImageView img_cate_1_prod_12;
    private TextView txt_cate_1_Title_1;
    private TextView txt_cate_1_Title_2;
    private TextView txt_cate_1_Title_3;
    private TextView txt_cate_1_Title_4;
    private TextView txt_cate_1_Title_5;
    private TextView txt_cate_1_Title_6;
    private TextView txt_cate_1_Title_7;
    private TextView txt_cate_1_Title_8;
    private TextView txt_cate_1_Title_9;
    private TextView txt_cate_1_Title_10;
    private TextView txt_cate_1_Title_11;
    private TextView txt_cate_1_Title_12;
    private TextView txt_cate_1_desc_1;
    private TextView txt_cate_1_desc_2;
    private TextView txt_cate_1_desc_3;
    private TextView txt_cate_1_desc_4;
    private TextView txt_cate_1_desc_5;
    private TextView txt_cate_1_desc_6;
    private TextView txt_cate_1_desc_7;
    private TextView txt_cate_1_desc_8;
    private TextView txt_cate_1_desc_9;
    private TextView txt_cate_1_desc_10;
    private TextView txt_cate_1_desc_11;
    private TextView txt_cate_1_desc_12;
    private TextView txt_cate_1_price_1;
    private TextView txt_cate_1_price_2;
    private TextView txt_cate_1_price_3;
    private TextView txt_cate_1_price_4;
    private TextView txt_cate_1_price_5;
    private TextView txt_cate_1_price_6;
    private TextView txt_cate_1_price_7;
    private TextView txt_cate_1_price_8;
    private TextView txt_cate_1_price_9;
    private TextView txt_cate_1_price_10;
    private TextView txt_cate_1_price_11;
    private TextView txt_cate_1_price_12;
    private TextView txt_cate_1;






    public TemplateOneFragment(Map<String, Object> productMap) {
        this.productMap = productMap;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_template_1, container, false);
        return v;
    }

    private void assignIds(View v) {
        img_cate_1_prod_1 = v.findViewById(R.id.img_cate_1_prod_1);
        img_cate_1_prod_2 = v.findViewById(R.id.img_cate_1_prod_2);
        img_cate_1_prod_3 = v.findViewById(R.id.img_cate_1_prod_3);
        img_cate_1_prod_4 = v.findViewById(R.id.img_cate_1_prod_4);
        img_cate_1_prod_5 = v.findViewById(R.id.img_cate_1_prod_5);
        img_cate_1_prod_6 = v.findViewById(R.id.img_cate_1_prod_6);
        img_cate_1_prod_7 = v.findViewById(R.id.img_cate_1_prod_7);
        img_cate_1_prod_8 = v.findViewById(R.id.img_cate_1_prod_8);
        img_cate_1_prod_9 = v.findViewById(R.id.img_cate_1_prod_9);
        img_cate_1_prod_10 = v.findViewById(R.id.img_cate_1_prod_10);
        img_cate_1_prod_11 = v.findViewById(R.id.img_cate_1_prod_11);
        img_cate_1_prod_12 = v.findViewById(R.id.img_cate_1_prod_12);
        txt_cate_1_Title_1 = v.findViewById(R.id.txt_cate_1_Title_1);
        txt_cate_1_Title_2 = v.findViewById(R.id.txt_cate_1_Title_2);
        txt_cate_1_Title_3 = v.findViewById(R.id.txt_cate_1_Title_3);
        txt_cate_1_Title_4 = v.findViewById(R.id.txt_cate_1_Title_4);
        txt_cate_1_Title_5 = v.findViewById(R.id.txt_cate_1_Title_5);
        txt_cate_1_Title_6 = v.findViewById(R.id.txt_cate_1_Title_6);
        txt_cate_1_Title_7 = v.findViewById(R.id.txt_cate_1_Title_7);
        txt_cate_1_Title_8 = v.findViewById(R.id.txt_cate_1_Title_8);
        txt_cate_1_Title_9 = v.findViewById(R.id.txt_cate_1_Title_9);
        txt_cate_1_Title_10 = v.findViewById(R.id.txt_cate_1_Title_10);
        txt_cate_1_Title_11 = v.findViewById(R.id.txt_cate_1_Title_11);
        txt_cate_1_Title_12 = v.findViewById(R.id.txt_cate_1_Title_12);
        txt_cate_1_desc_1 = v.findViewById(R.id.txt_cate_1_desc_1);
        txt_cate_1_desc_2 = v.findViewById(R.id.txt_cate_1_desc_2);
        txt_cate_1_desc_3 = v.findViewById(R.id.txt_cate_1_desc_3);
        txt_cate_1_desc_4 = v.findViewById(R.id.txt_cate_1_desc_4);
        txt_cate_1_desc_5 = v.findViewById(R.id.txt_cate_1_desc_5);
        txt_cate_1_desc_6 = v.findViewById(R.id.txt_cate_1_desc_6);
        txt_cate_1_desc_7 = v.findViewById(R.id.txt_cate_1_desc_7);
        txt_cate_1_desc_8 = v.findViewById(R.id.txt_cate_1_desc_8);
        txt_cate_1_desc_9 = v.findViewById(R.id.txt_cate_1_desc_9);
        txt_cate_1_desc_10 = v.findViewById(R.id.txt_cate_1_desc_10);
        txt_cate_1_desc_11 = v.findViewById(R.id.txt_cate_1_desc_11);
        txt_cate_1_desc_12 = v.findViewById(R.id.txt_cate_1_desc_12);
        txt_cate_1_price_1 = v.findViewById(R.id.txt_cate_1_price_1);
        txt_cate_1_price_2 = v.findViewById(R.id.txt_cate_1_price_2);
        txt_cate_1_price_3 = v.findViewById(R.id.txt_cate_1_price_3);
        txt_cate_1_price_4 = v.findViewById(R.id.txt_cate_1_price_4);
        txt_cate_1_price_5 = v.findViewById(R.id.txt_cate_1_price_5);
        txt_cate_1_price_6 = v.findViewById(R.id.txt_cate_1_price_6);
        txt_cate_1_price_7 = v.findViewById(R.id.txt_cate_1_price_7);
        txt_cate_1_price_8 = v.findViewById(R.id.txt_cate_1_price_8);
        txt_cate_1_price_9 = v.findViewById(R.id.txt_cate_1_price_9);
        txt_cate_1_price_10 = v.findViewById(R.id.txt_cate_1_price_10);
        txt_cate_1_price_11 = v.findViewById(R.id.txt_cate_1_price_11);
        txt_cate_1_price_12 = v.findViewById(R.id.txt_cate_1_price_12);
        txt_cate_1 = v.findViewById(R.id.txt_cate_1);


        ArrayList<Map<String, Object>> categories = (ArrayList<Map<String, Object>>) productMap.get("categories");
        for (int i = 0; i < categories.size(); i++) {
            String categoryName = (String) categories.get(i).get("categoryName");
            ArrayList<Map<String, String>> products = (ArrayList<Map<String, String>>) categories.get(i).get("products");
            for (int j = 0; j < products.size(); j++) {
                String productDescription = products.get(j).get("productDescription");
                String productImage = products.get(j).get("productImage");
                String productName = products.get(j).get("productName");
                String productPrice = products.get(j).get("productPrice");
                if(i == 0){
                    txt_cate_1.setText(categoryName);

                    switch (j) {
                        case 0:
                            txt_cate_1_desc_1.setText(productDescription);
                            txt_cate_1_Title_1.setText(productName);
                            txt_cate_1_price_1.setText(productPrice +" $");
                            Picasso.get().load(productImage).into(img_cate_1_prod_1);
                            break;
                        case 1:
                            txt_cate_1_desc_2.setText(productDescription);
                            txt_cate_1_Title_2.setText(productName);
                            txt_cate_1_price_2.setText(productPrice +" $");
                            Picasso.get().load(productImage).into(img_cate_1_prod_2);
                            break;
                        case 2:
                            txt_cate_1_desc_3.setText(productDescription);
                            txt_cate_1_Title_3.setText(productName);
                            txt_cate_1_price_3.setText(productPrice +" $");
                            Picasso.get().load(productImage).into(img_cate_1_prod_3);
                            break;
                        case 3:
                            txt_cate_1_desc_4.setText(productDescription);
                            txt_cate_1_Title_4.setText(productName);
                            txt_cate_1_price_4.setText(productPrice +" $");
                            Picasso.get().load(productImage).into(img_cate_1_prod_4);
                            break;
                        case 4:
                            txt_cate_1_desc_5.setText(productDescription);
                            txt_cate_1_Title_5.setText(productName);
                            txt_cate_1_price_5.setText(productPrice +" $");
                            Picasso.get().load(productImage).into(img_cate_1_prod_5);
                            break;
                        case 5:
                            txt_cate_1_desc_6.setText(productDescription);
                            txt_cate_1_Title_6.setText(productName);
                            txt_cate_1_price_6.setText(productPrice +" $");
                            Picasso.get().load(productImage).into(img_cate_1_prod_6);
                            break;

                        case 6:
                            txt_cate_1_desc_7.setText(productDescription);
                            txt_cate_1_Title_7.setText(productName);
                            txt_cate_1_price_7.setText(productPrice +" $");
                            Picasso.get().load(productImage).into(img_cate_1_prod_7);
                            break;

                        case 7:
                            txt_cate_1_desc_8.setText(productDescription);
                            txt_cate_1_Title_8.setText(productName);
                            txt_cate_1_price_8.setText(productPrice +" $");
                            Picasso.get().load(productImage).into(img_cate_1_prod_8);
                            break;
                        case 8:
                            txt_cate_1_desc_9.setText(productDescription);
                            txt_cate_1_Title_9.setText(productName);
                            txt_cate_1_price_9.setText(productPrice +" $");
                            Picasso.get().load(productImage).into(img_cate_1_prod_9);
                            break;
                        case 9:
                            txt_cate_1_desc_10.setText(productDescription);
                            txt_cate_1_Title_10.setText(productName);
                            txt_cate_1_price_10.setText(productPrice +" $");
                            Picasso.get().load(productImage).into(img_cate_1_prod_10);
                            break;
                        case 10:
                            txt_cate_1_desc_11.setText(productDescription);
                            txt_cate_1_Title_11.setText(productName);
                            txt_cate_1_price_11.setText(productPrice +" $");
                            Picasso.get().load(productImage).into(img_cate_1_prod_11);
                            break;
                        case 11:
                            txt_cate_1_desc_12.setText(productDescription);
                            txt_cate_1_Title_12.setText(productName);
                            txt_cate_1_price_12.setText(productPrice +" $");
                            Picasso.get().load(productImage).into(img_cate_1_prod_12);
                            break;
                    }

                }



            }

        }


    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        assignIds(view);
    }


    private void setDataOnView(int position) {
    }

}
