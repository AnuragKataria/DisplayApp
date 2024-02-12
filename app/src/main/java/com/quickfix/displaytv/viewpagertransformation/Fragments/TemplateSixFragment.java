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

public class TemplateSixFragment extends Fragment {
    private Map<String, Object> productMap;
    private ArrayList<Map<String, Object>> pArrayList;
    private ImageView img_cate_1_prod_1;
    private ImageView img_cate_1_prod_2;
    private ImageView img_cate_1_prod_3;
    private ImageView img_cate_1_prod_4;
    private ImageView img_cate_1_prod_5;
    private TextView txt_cate_1_Title_1;
    private TextView txt_cate_1_Title_2;
    private TextView txt_cate_1_Title_3;
    private TextView txt_cate_1_Title_4;
    private TextView txt_cate_1_Title_5;
    private TextView txt_cate_1_desc_1;
    private TextView txt_cate_1_desc_2;
    private TextView txt_cate_1_desc_3;
    private TextView txt_cate_1_desc_4;
    private TextView txt_cate_1_desc_5;
    private TextView txt_cate_1_price_1;
    private TextView txt_cate_1_price_2;
    private TextView txt_cate_1_price_3;
    private TextView txt_cate_1_price_4;
    private TextView txt_cate_1_price_5;
    private TextView txt_cate_1;
    private TextView txt_cate_2;
    private TextView txt_cate_3;

    private ImageView img_cate_2_prod_1;
    private ImageView img_cate_2_prod_2;
    private ImageView img_cate_2_prod_3;
    private ImageView img_cate_2_prod_4;
    private ImageView img_cate_2_prod_5;
    private TextView txt_cate_2_Title_1;
    private TextView txt_cate_2_Title_2;
    private TextView txt_cate_2_Title_3;
    private TextView txt_cate_2_Title_4;
    private TextView txt_cate_2_Title_5;
    private TextView txt_cate_2_desc_1;
    private TextView txt_cate_2_desc_2;
    private TextView txt_cate_2_desc_3;
    private TextView txt_cate_2_desc_4;
    private TextView txt_cate_2_desc_5;

    private TextView txt_cate_2_price_1;
    private TextView txt_cate_2_price_2;
    private TextView txt_cate_2_price_3;
    private TextView txt_cate_2_price_4;
    private TextView txt_cate_2_price_5;
    private TextView txt_extra;


    public TemplateSixFragment(Map<String, Object> productMap) {
        this.productMap = productMap;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_template_6, container, false);
        return v;
    }

    private void assignIds(View v) {
        img_cate_1_prod_1 = v.findViewById(R.id.img_cate_1_prod_1);
        img_cate_1_prod_2 = v.findViewById(R.id.img_cate_1_prod_2);
        img_cate_1_prod_3 = v.findViewById(R.id.img_cate_1_prod_3);
        img_cate_1_prod_4 = v.findViewById(R.id.img_cate_1_prod_4);
        img_cate_1_prod_5 = v.findViewById(R.id.img_cate_1_prod_5);
        txt_cate_1_Title_1 = v.findViewById(R.id.txt_cate_1_Title_1);
        txt_cate_1_Title_2 = v.findViewById(R.id.txt_cate_1_Title_2);
        txt_cate_1_Title_3 = v.findViewById(R.id.txt_cate_1_Title_3);
        txt_cate_1_Title_4 = v.findViewById(R.id.txt_cate_1_Title_4);
        txt_cate_1_Title_5 = v.findViewById(R.id.txt_cate_1_Title_5);
        txt_cate_1_desc_1 = v.findViewById(R.id.txt_cate_1_desc_1);
        txt_cate_1_desc_2 = v.findViewById(R.id.txt_cate_1_desc_2);
        txt_cate_1_desc_3 = v.findViewById(R.id.txt_cate_1_desc_3);
        txt_cate_1_desc_4 = v.findViewById(R.id.txt_cate_1_desc_4);
        txt_cate_1_desc_5 = v.findViewById(R.id.txt_cate_1_desc_5);
        txt_cate_1_price_1 = v.findViewById(R.id.txt_cate_1_price_1);
        txt_cate_1_price_2 = v.findViewById(R.id.txt_cate_1_price_2);
        txt_cate_1_price_3 = v.findViewById(R.id.txt_cate_1_price_3);
        txt_cate_1_price_4 = v.findViewById(R.id.txt_cate_1_price_4);
        txt_cate_1_price_5 = v.findViewById(R.id.txt_cate_1_price_5);
        txt_cate_1 = v.findViewById(R.id.txt_cate_1);

        img_cate_2_prod_1 = v.findViewById(R.id.img_cate_2_prod_1);
        img_cate_2_prod_2 = v.findViewById(R.id.img_cate_2_prod_2);
        img_cate_2_prod_3 = v.findViewById(R.id.img_cate_2_prod_3);
        img_cate_2_prod_4 = v.findViewById(R.id.img_cate_2_prod_4);
        img_cate_2_prod_5 = v.findViewById(R.id.img_cate_2_prod_5);
        txt_cate_2_Title_1 = v.findViewById(R.id.txt_cate_2_Title_1);
        txt_cate_2_Title_2 = v.findViewById(R.id.txt_cate_2_Title_2);
        txt_cate_2_Title_3 = v.findViewById(R.id.txt_cate_2_Title_3);
        txt_cate_2_Title_4 = v.findViewById(R.id.txt_cate_2_Title_4);
        txt_cate_2_Title_5 = v.findViewById(R.id.txt_cate_2_Title_5);
        txt_cate_2_desc_1 = v.findViewById(R.id.txt_cate_2_desc_1);
        txt_cate_2_desc_2 = v.findViewById(R.id.txt_cate_2_desc_2);
        txt_cate_2_desc_3 = v.findViewById(R.id.txt_cate_2_desc_3);
        txt_cate_2_desc_4 = v.findViewById(R.id.txt_cate_2_desc_4);
        txt_cate_2_desc_5 = v.findViewById(R.id.txt_cate_2_desc_5);
        txt_cate_2_price_1 = v.findViewById(R.id.txt_cate_2_price_1);
        txt_cate_2_price_2 = v.findViewById(R.id.txt_cate_2_price_2);
        txt_cate_2_price_3 = v.findViewById(R.id.txt_cate_2_price_3);
        txt_cate_2_price_4 = v.findViewById(R.id.txt_cate_2_price_4);
        txt_cate_2_price_5 = v.findViewById(R.id.txt_cate_2_price_5);
        txt_cate_2 = v.findViewById(R.id.txt_cate_2);
        txt_cate_3 = v.findViewById(R.id.txt_cate_3);
        txt_extra = v.findViewById(R.id.txt_extra);

        Map<String, Object> extras = (Map<String, Object>) productMap.get("extras");
        String extrasName = (String) extras.get("categoryName");
        ArrayList<Map<String, String>> Arrayproducts = (ArrayList<Map<String, String>>) extras.get("products");
        txt_cate_3.setText(extrasName);

        for (int i = 0; i < Arrayproducts.size(); i++) {
            txt_extra.setText(txt_extra.getText()+"\n"+Arrayproducts.get(i).get("productName"));
        }
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
                    }

                }else{
                    txt_cate_2.setText(categoryName);
                    switch (j) {
                        case 0:
                            txt_cate_2_desc_1.setText(productDescription);
                            txt_cate_2_Title_1.setText(productName);
                            txt_cate_2_price_1.setText(productPrice +" $");
                            Picasso.get().load(productImage).into(img_cate_2_prod_1);
                            break;
                        case 1:
                            txt_cate_2_desc_2.setText(productDescription);
                            txt_cate_2_Title_2.setText(productName);
                            txt_cate_2_price_2.setText(productPrice +" $");
                            Picasso.get().load(productImage).into(img_cate_2_prod_2);
                            break;
                        case 2:
                            txt_cate_2_desc_3.setText(productDescription);
                            txt_cate_2_Title_3.setText(productName);
                            txt_cate_2_price_3.setText(productPrice +" $");
                            Picasso.get().load(productImage).into(img_cate_2_prod_3);
                            break;
                        case 3:
                            txt_cate_2_desc_4.setText(productDescription);
                            txt_cate_2_Title_4.setText(productName);
                            txt_cate_2_price_4.setText(productPrice +" $");
                            Picasso.get().load(productImage).into(img_cate_2_prod_4);
                            break;
                        case 4:
                            txt_cate_2_desc_5.setText(productDescription);
                            txt_cate_2_Title_5.setText(productName);
                            txt_cate_2_price_5.setText(productPrice +" $");
                            Picasso.get().load(productImage).into(img_cate_2_prod_5);
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
