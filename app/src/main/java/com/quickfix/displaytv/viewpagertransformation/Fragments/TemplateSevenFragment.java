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

public class TemplateSevenFragment extends Fragment {
    private Map<String, Object> productMap;
    private ArrayList<Map<String, Object>> pArrayList;
    private ImageView img_cate_1_prod_1;
    private ImageView img_cate_1_prod_2;
    private ImageView img_cate_1_prod_3;
    private ImageView img_cate_1_prod_4;
    private ImageView img_cate_1_prod_5;
    private ImageView img_cate_1_prod_6;
    private TextView txt_cate_1_Title_1;
    private TextView txt_cate_1_Title_2;
    private TextView txt_cate_1_Title_3;
    private TextView txt_cate_1_Title_4;
    private TextView txt_cate_1_Title_5;
    private TextView txt_cate_1_Title_6;
    private TextView txt_cate_1_desc_1;
    private TextView txt_cate_1_desc_2;
    private TextView txt_cate_1_desc_3;
    private TextView txt_cate_1_desc_4;
    private TextView txt_cate_1_desc_5;
    private TextView txt_cate_1_desc_6;
    private TextView txt_cate_1_price_1;
    private TextView txt_cate_1_price_2;
    private TextView txt_cate_1_price_3;
    private TextView txt_cate_1_price_4;
    private TextView txt_cate_1_price_5;
    private TextView txt_cate_1_price_6;
    private TextView txt_cate_1;
    private TextView txt_cate_2;
    private TextView txt_cate_3;
    private TextView txt_cate_4;

    private ImageView img_cate_2_prod_1;
    private ImageView img_cate_2_prod_2;
    private ImageView img_cate_2_prod_3;
    private ImageView img_cate_2_prod_4;
    private ImageView img_cate_2_prod_5;
    private ImageView img_cate_2_prod_6;
    private TextView txt_cate_2_Title_1;
    private TextView txt_cate_2_Title_2;
    private TextView txt_cate_2_Title_3;
    private TextView txt_cate_2_Title_4;
    private TextView txt_cate_2_Title_5;
    private TextView txt_cate_2_Title_6;
    private TextView txt_cate_2_desc_1;
    private TextView txt_cate_2_desc_2;
    private TextView txt_cate_2_desc_3;
    private TextView txt_cate_2_desc_4;
    private TextView txt_cate_2_desc_5;
    private TextView txt_cate_2_desc_6;

    private TextView txt_cate_2_price_1;
    private TextView txt_cate_2_price_2;
    private TextView txt_cate_2_price_3;
    private TextView txt_cate_2_price_4;
    private TextView txt_cate_2_price_5;
    private TextView txt_cate_2_price_6;



    private ImageView img_cate_3_prod_1;
    private ImageView img_cate_3_prod_2;
    private ImageView img_cate_3_prod_3;
    private TextView txt_cate_3_Title_1;
    private TextView txt_cate_3_Title_2;
    private TextView txt_cate_3_Title_3;
    private TextView txt_cate_3_desc_1;
    private TextView txt_cate_3_desc_2;
    private TextView txt_cate_3_desc_3;

    private TextView txt_cate_3_price_1;
    private TextView txt_cate_3_price_2;
    private TextView txt_cate_3_price_3;


    private ImageView img_cate_4_prod_1;
    private ImageView img_cate_4_prod_2;
    private ImageView img_cate_4_prod_3;
    private TextView txt_cate_4_Title_1;
    private TextView txt_cate_4_Title_2;
    private TextView txt_cate_4_Title_3;
    private TextView txt_cate_4_desc_1;
    private TextView txt_cate_4_desc_2;
    private TextView txt_cate_4_desc_3;

    private TextView txt_cate_4_price_1;
    private TextView txt_cate_4_price_2;
    private TextView txt_cate_4_price_3;


    public TemplateSevenFragment(Map<String, Object> productMap) {
        this.productMap = productMap;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_template_7, container, false);
        return v;
    }

    private void assignIds(View v) {
        img_cate_1_prod_1 = v.findViewById(R.id.img_cate_1_prod_1);
        img_cate_1_prod_2 = v.findViewById(R.id.img_cate_1_prod_2);
        img_cate_1_prod_3 = v.findViewById(R.id.img_cate_1_prod_3);
        img_cate_1_prod_4 = v.findViewById(R.id.img_cate_1_prod_4);
        img_cate_1_prod_5 = v.findViewById(R.id.img_cate_1_prod_5);
        img_cate_1_prod_6 = v.findViewById(R.id.img_cate_1_prod_6);
        txt_cate_1_Title_1 = v.findViewById(R.id.txt_cate_1_Title_1);
        txt_cate_1_Title_2 = v.findViewById(R.id.txt_cate_1_Title_2);
        txt_cate_1_Title_3 = v.findViewById(R.id.txt_cate_1_Title_3);
        txt_cate_1_Title_4 = v.findViewById(R.id.txt_cate_1_Title_4);
        txt_cate_1_Title_5 = v.findViewById(R.id.txt_cate_1_Title_5);
        txt_cate_1_Title_6 = v.findViewById(R.id.txt_cate_1_Title_6);
        txt_cate_1_desc_1 = v.findViewById(R.id.txt_cate_1_desc_1);
        txt_cate_1_desc_2 = v.findViewById(R.id.txt_cate_1_desc_2);
        txt_cate_1_desc_3 = v.findViewById(R.id.txt_cate_1_desc_3);
        txt_cate_1_desc_4 = v.findViewById(R.id.txt_cate_1_desc_4);
        txt_cate_1_desc_5 = v.findViewById(R.id.txt_cate_1_desc_5);
        txt_cate_1_desc_6 = v.findViewById(R.id.txt_cate_1_desc_6);
        txt_cate_1_price_1 = v.findViewById(R.id.txt_cate_1_price_1);
        txt_cate_1_price_2 = v.findViewById(R.id.txt_cate_1_price_2);
        txt_cate_1_price_3 = v.findViewById(R.id.txt_cate_1_price_3);
        txt_cate_1_price_4 = v.findViewById(R.id.txt_cate_1_price_4);
        txt_cate_1_price_5 = v.findViewById(R.id.txt_cate_1_price_5);
        txt_cate_1_price_6 = v.findViewById(R.id.txt_cate_1_price_6);
        txt_cate_1 = v.findViewById(R.id.txt_cate_1);

        img_cate_2_prod_1 = v.findViewById(R.id.img_cate_2_prod_1);
        img_cate_2_prod_2 = v.findViewById(R.id.img_cate_2_prod_2);
        img_cate_2_prod_3 = v.findViewById(R.id.img_cate_2_prod_3);
        img_cate_2_prod_4 = v.findViewById(R.id.img_cate_2_prod_4);
        img_cate_2_prod_5 = v.findViewById(R.id.img_cate_2_prod_5);
        img_cate_2_prod_6 = v.findViewById(R.id.img_cate_2_prod_6);
        txt_cate_2_Title_1 = v.findViewById(R.id.txt_cate_2_Title_1);
        txt_cate_2_Title_2 = v.findViewById(R.id.txt_cate_2_Title_2);
        txt_cate_2_Title_3 = v.findViewById(R.id.txt_cate_2_Title_3);
        txt_cate_2_Title_4 = v.findViewById(R.id.txt_cate_2_Title_4);
        txt_cate_2_Title_5 = v.findViewById(R.id.txt_cate_2_Title_5);
        txt_cate_2_Title_6 = v.findViewById(R.id.txt_cate_2_Title_6);
        txt_cate_2_desc_1 = v.findViewById(R.id.txt_cate_2_desc_1);
        txt_cate_2_desc_2 = v.findViewById(R.id.txt_cate_2_desc_2);
        txt_cate_2_desc_3 = v.findViewById(R.id.txt_cate_2_desc_3);
        txt_cate_2_desc_4 = v.findViewById(R.id.txt_cate_2_desc_4);
        txt_cate_2_desc_5 = v.findViewById(R.id.txt_cate_2_desc_5);
        txt_cate_2_desc_6 = v.findViewById(R.id.txt_cate_2_desc_6);
        txt_cate_2_price_1 = v.findViewById(R.id.txt_cate_2_price_1);
        txt_cate_2_price_2 = v.findViewById(R.id.txt_cate_2_price_2);
        txt_cate_2_price_3 = v.findViewById(R.id.txt_cate_2_price_3);
        txt_cate_2_price_4 = v.findViewById(R.id.txt_cate_2_price_4);
        txt_cate_2_price_5 = v.findViewById(R.id.txt_cate_2_price_5);
        txt_cate_2_price_6 = v.findViewById(R.id.txt_cate_2_price_6);
        txt_cate_2 = v.findViewById(R.id.txt_cate_2);
        txt_cate_3 = v.findViewById(R.id.txt_cate_3);
        txt_cate_4 = v.findViewById(R.id.txt_cate_4);


        img_cate_3_prod_1 = v.findViewById(R.id.img_cate_3_prod_1);
        img_cate_3_prod_2 = v.findViewById(R.id.img_cate_3_prod_2);
        img_cate_3_prod_3 = v.findViewById(R.id.img_cate_3_prod_3);
        txt_cate_3_Title_1 = v.findViewById(R.id.txt_cate_3_Title_1);
        txt_cate_3_Title_2 = v.findViewById(R.id.txt_cate_3_Title_2);
        txt_cate_3_Title_3 = v.findViewById(R.id.txt_cate_3_Title_3);
        txt_cate_3_desc_1 = v.findViewById(R.id.txt_cate_3_desc_1);
        txt_cate_3_desc_2 = v.findViewById(R.id.txt_cate_3_desc_2);
        txt_cate_3_desc_3 = v.findViewById(R.id.txt_cate_3_desc_3);
        txt_cate_3_price_1 = v.findViewById(R.id.txt_cate_3_price_1);
        txt_cate_3_price_2 = v.findViewById(R.id.txt_cate_3_price_2);
        txt_cate_3_price_3 = v.findViewById(R.id.txt_cate_3_price_3);
        img_cate_4_prod_1 = v.findViewById(R.id.img_cate_4_prod_1);
        img_cate_4_prod_2 = v.findViewById(R.id.img_cate_4_prod_2);
        img_cate_4_prod_3 = v.findViewById(R.id.img_cate_4_prod_3);
        txt_cate_4_Title_1 = v.findViewById(R.id.txt_cate_4_Title_1);
        txt_cate_4_Title_2 = v.findViewById(R.id.txt_cate_4_Title_2);
        txt_cate_4_Title_3 = v.findViewById(R.id.txt_cate_4_Title_3);
        txt_cate_4_desc_1 = v.findViewById(R.id.txt_cate_4_desc_1);
        txt_cate_4_desc_2 = v.findViewById(R.id.txt_cate_4_desc_2);
        txt_cate_4_desc_3 = v.findViewById(R.id.txt_cate_4_desc_3);
        txt_cate_4_price_1 = v.findViewById(R.id.txt_cate_4_price_1);
        txt_cate_4_price_2 = v.findViewById(R.id.txt_cate_4_price_2);
        txt_cate_4_price_3 = v.findViewById(R.id.txt_cate_4_price_3);

        ArrayList<Map<String, Object>> categories = (ArrayList<Map<String, Object>>) productMap.get("categories");
        for (int i = 0; i < categories.size(); i++) {
            String categoryName = (String) categories.get(i).get("categoryName");
            ArrayList<Map<String, String>> products = (ArrayList<Map<String, String>>) categories.get(i).get("products");
            for (int j = 0; j < products.size(); j++) {
                String productDescription = products.get(j).get("productDescription");
                String productImage = products.get(j).get("productImage");
                String productName = products.get(j).get("productName");
                String productPrice = products.get(j).get("productPrice");
                if (i == 0) {
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
                    }

                } else if (i == 1) {
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
                        case 6:
                            txt_cate_2_desc_6.setText(productDescription);
                            txt_cate_2_Title_6.setText(productName);
                            txt_cate_2_price_6.setText(productPrice +" $");
                            Picasso.get().load(productImage).into(img_cate_2_prod_6);
                            break;
                    }

                } else if (i == 2) {
                    txt_cate_3.setText(categoryName);
                    switch (j) {
                        case 0:
                            txt_cate_3_desc_1.setText(productDescription);
                            txt_cate_3_Title_1.setText(productName);
                            txt_cate_3_price_1.setText(productPrice +" $");
                            Picasso.get().load(productImage).into(img_cate_3_prod_1);
                            break;
                        case 1:
                            txt_cate_3_desc_2.setText(productDescription);
                            txt_cate_3_Title_2.setText(productName);
                            txt_cate_3_price_2.setText(productPrice +" $");
                            Picasso.get().load(productImage).into(img_cate_3_prod_2);
                            break;
                        case 2:
                            txt_cate_3_desc_3.setText(productDescription);
                            txt_cate_3_Title_3.setText(productName);
                            txt_cate_3_price_3.setText(productPrice +" $");
                            Picasso.get().load(productImage).into(img_cate_3_prod_3);
                            break;
                    }
                }
                else if (i == 3) {
                    txt_cate_4.setText(categoryName);
                    switch (j) {
                        case 0:
                            txt_cate_4_desc_1.setText(productDescription);
                            txt_cate_4_Title_1.setText(productName);
                            txt_cate_4_price_1.setText(productPrice +" $");
                            Picasso.get().load(productImage).into(img_cate_3_prod_1);
                            break;
                        case 1:
                            txt_cate_4_desc_2.setText(productDescription);
                            txt_cate_4_Title_2.setText(productName);
                            txt_cate_4_price_2.setText(productPrice +" $");
                            Picasso.get().load(productImage).into(img_cate_4_prod_2);
                            break;
                        case 2:
                            txt_cate_4_desc_3.setText(productDescription);
                            txt_cate_4_Title_3.setText(productName);
                            txt_cate_4_price_3.setText(productPrice +" $");
                            Picasso.get().load(productImage).into(img_cate_4_prod_3);
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
