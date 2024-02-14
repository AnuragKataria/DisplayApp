package com.quickfix.displaytv.viewpagertransformation.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.quickfix.displaytv.R;
import com.quickfix.displaytv.adapters.StaggeredAdapter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Map;

public class TemplateDynamicFragment extends Fragment {
    private Map<String, Object> productMap;
    private TextView txt_cate_1;

    RecyclerView recyclerView;





    public TemplateDynamicFragment(Map<String, Object> productMap) {
        this.productMap = productMap;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_template_dynamic, container, false);
        return v;
    }

    private void assignIds(View v) {
        txt_cate_1 = v.findViewById(R.id.txt_cate_1);
        recyclerView = v.findViewById(R.id.recycleViewStagged);
        RecyclerView.LayoutManager layoutManager = new StaggeredGridLayoutManager(5, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        ArrayList<Map<String, Object>> categories = (ArrayList<Map<String, Object>>) productMap.get("categories");
        for (int i = 0; i < categories.size(); i++) {
            String categoryName = (String) categories.get(i).get("categoryName");
            ArrayList<Map<String, String>> products = (ArrayList<Map<String, String>>) categories.get(i).get("products");
            txt_cate_1.setText(categoryName);
            // setting adapter here
            StaggeredAdapter staggeredAdapter = new StaggeredAdapter(getActivity() , products);
            recyclerView.setAdapter(staggeredAdapter);

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
