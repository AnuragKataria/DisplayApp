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

public class TemplateThreeFragment extends Fragment {
    private Map<String, Object> productMap;
    private ArrayList<Map<String, Object>> pArrayList;
    private ImageView img_cate_1_prod_1;
    private ImageView img_cate_1_prod_2;
    private ImageView img_cate_1_prod_3;
    private ImageView img_cate_1_prod_4;
    private ImageView img_cate_1_prod_5;
    private ImageView img_cate_1_prod_6;
    private ImageView img_cate_1_prod_7;
    private ImageView img_cate_1_prod_8;
    private TextView txt_cate_1_Title_1;
    private TextView txt_cate_1_Title_2;
    private TextView txt_cate_1_Title_3;
    private TextView txt_cate_1_Title_4;
    private TextView txt_cate_1_Title_5;
    private TextView txt_cate_1_Title_6;
    private TextView txt_cate_1_Title_7;
    private TextView txt_cate_1_Title_8;
    private TextView txt_cate_1_desc_1;
    private TextView txt_cate_1_desc_2;
    private TextView txt_cate_1_desc_3;
    private TextView txt_cate_1_desc_4;
    private TextView txt_cate_1_desc_5;
    private TextView txt_cate_1_desc_6;
    private TextView txt_cate_1_desc_7;
    private TextView txt_cate_1_desc_8;
    private TextView txt_cate_1_price_1;
    private TextView txt_cate_1_price_2;
    private TextView txt_cate_1_price_3;
    private TextView txt_cate_1_price_4;
    private TextView txt_cate_1_price_5;
    private TextView txt_cate_1_price_6;
    private TextView txt_cate_1_price_7;
    private TextView txt_cate_1_price_8;
    private TextView txt_cate_1;
    private TextView txt_cate_2;
    private TextView txt_cate_3;
    private TextView txt_cate_4;
    private TextView txt_cate_5;
    private TextView txt_cate_6;
    private TextView txt_cate_7;
    private TextView txt_cate_8;





    public TemplateThreeFragment(Map<String, Object> productMap) {
        this.productMap = productMap;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_template_3, container, false);
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
        txt_cate_1_Title_1 = v.findViewById(R.id.txt_cate_1_Title_1);
        txt_cate_1_Title_2 = v.findViewById(R.id.txt_cate_1_Title_2);
        txt_cate_1_Title_3 = v.findViewById(R.id.txt_cate_1_Title_3);
        txt_cate_1_Title_4 = v.findViewById(R.id.txt_cate_1_Title_4);
        txt_cate_1_Title_5 = v.findViewById(R.id.txt_cate_1_Title_5);
        txt_cate_1_Title_6 = v.findViewById(R.id.txt_cate_1_Title_6);
        txt_cate_1_Title_7 = v.findViewById(R.id.txt_cate_1_Title_7);
        txt_cate_1_Title_8 = v.findViewById(R.id.txt_cate_1_Title_8);
        txt_cate_1_desc_1 = v.findViewById(R.id.txt_cate_1_desc_1);
        txt_cate_1_desc_2 = v.findViewById(R.id.txt_cate_1_desc_2);
        txt_cate_1_desc_3 = v.findViewById(R.id.txt_cate_1_desc_3);
        txt_cate_1_desc_4 = v.findViewById(R.id.txt_cate_1_desc_4);
        txt_cate_1_desc_5 = v.findViewById(R.id.txt_cate_1_desc_5);
        txt_cate_1_desc_6 = v.findViewById(R.id.txt_cate_1_desc_6);
        txt_cate_1_desc_7 = v.findViewById(R.id.txt_cate_1_desc_7);
        txt_cate_1_desc_8 = v.findViewById(R.id.txt_cate_1_desc_8);
        txt_cate_1_price_1 = v.findViewById(R.id.txt_cate_1_price_1);
        txt_cate_1_price_2 = v.findViewById(R.id.txt_cate_1_price_2);
        txt_cate_1_price_3 = v.findViewById(R.id.txt_cate_1_price_3);
        txt_cate_1_price_4 = v.findViewById(R.id.txt_cate_1_price_4);
        txt_cate_1_price_5 = v.findViewById(R.id.txt_cate_1_price_5);
        txt_cate_1_price_6 = v.findViewById(R.id.txt_cate_1_price_6);
        txt_cate_1_price_7 = v.findViewById(R.id.txt_cate_1_price_7);
        txt_cate_1_price_8 = v.findViewById(R.id.txt_cate_1_price_8);
        txt_cate_1 = v.findViewById(R.id.txt_cate_1);
        txt_cate_2 = v.findViewById(R.id.txt_cate_2);
        txt_cate_3 = v.findViewById(R.id.txt_cate_3);
        txt_cate_4 = v.findViewById(R.id.txt_cate_4);
        txt_cate_5 = v.findViewById(R.id.txt_cate_5);
        txt_cate_6 = v.findViewById(R.id.txt_cate_6);
        txt_cate_7 = v.findViewById(R.id.txt_cate_7);
        txt_cate_8 = v.findViewById(R.id.txt_cate_8);

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
                    txt_cate_2.setText(categoryName);
                    txt_cate_3.setText(categoryName);
                    txt_cate_4.setText(categoryName);
                    txt_cate_5.setText(categoryName);
                    txt_cate_6.setText(categoryName);
                    txt_cate_7.setText(categoryName);
                    txt_cate_8.setText(categoryName);

                    switch (j) {
                        case 0:
                            //txt_cate_1_desc_1.setText(productDescription);
                            txt_cate_1_Title_1.setText(productName);
                            txt_cate_1_price_1.setText(productPrice +" $");
                            Picasso.get().load(productImage).into(img_cate_1_prod_1);
                            break;
                        case 1:
                            //txt_cate_1_desc_2.setText(productDescription);
                            txt_cate_1_Title_2.setText(productName);
                            txt_cate_1_price_2.setText(productPrice +" $");
                            Picasso.get().load(productImage).into(img_cate_1_prod_2);
                            break;
                        case 2:
                            //txt_cate_1_desc_3.setText(productDescription);
                            txt_cate_1_Title_3.setText(productName);
                            txt_cate_1_price_3.setText(productPrice +" $");
                            Picasso.get().load(productImage).into(img_cate_1_prod_3);
                            break;
                        case 3:
                           // txt_cate_1_desc_4.setText(productDescription);
                            txt_cate_1_Title_4.setText(productName);
                            txt_cate_1_price_4.setText(productPrice +" $");
                            Picasso.get().load(productImage).into(img_cate_1_prod_4);
                            break;
                        case 4:
                            //txt_cate_1_desc_5.setText(productDescription);
                            txt_cate_1_Title_5.setText(productName);
                            txt_cate_1_price_5.setText(productPrice +" $");
                            Picasso.get().load(productImage).into(img_cate_1_prod_5);
                            break;
                        case 5:
                           // txt_cate_1_desc_6.setText(productDescription);
                            txt_cate_1_Title_6.setText(productName);
                            txt_cate_1_price_6.setText(productPrice +" $");
                            Picasso.get().load(productImage).into(img_cate_1_prod_6);
                            break;

                        case 6:
                            //txt_cate_1_desc_7.setText(productDescription);
                            txt_cate_1_Title_7.setText(productName);
                            txt_cate_1_price_7.setText(productPrice +" $");
                            Picasso.get().load(productImage).into(img_cate_1_prod_7);
                            break;

                        case 7:
                            //txt_cate_1_desc_8.setText(productDescription);
                            txt_cate_1_Title_8.setText(productName);
                            txt_cate_1_price_8.setText(productPrice +" $");
                            Picasso.get().load(productImage).into(img_cate_1_prod_8);
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
