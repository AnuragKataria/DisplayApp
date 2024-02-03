package com.quickfix.displaytv.viewpagertransformation.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.quickfix.displaytv.R;
import com.quickfix.displaytv.adapters.ProductsAdapter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

public class TemplateFourFragment extends Fragment {

    private HashMap<String, HashMap<String, Object>> productMap;
    private ImageView backImage;
    private String image;
    private RecyclerView recyclerView;

    public TemplateFourFragment(String image, HashMap<String, HashMap<String, Object>> productMap) {
        this.image = image;
        this.productMap = productMap;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_template_4, container, false);


    }

    private void assignIds(View v) {
        backImage = v.findViewById(R.id.backImage);
        Picasso.get().load(image).into(backImage);
        recyclerView = v. findViewById(R.id.recyclerView);
        ArrayList<HashMap<String, Object>> pArrayList = new ArrayList<>();
        for (String key : productMap.keySet()) {
            HashMap<String, Object> pMap = productMap.get(key);
            pArrayList.add(pMap);
        }
        Log.i("ArrayList ", pArrayList.toString());
        if (pArrayList.size() > 0) {
            ProductsAdapter adapter = new ProductsAdapter(getContext(), pArrayList);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
            recyclerView.setAdapter(adapter);
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        assignIds(view);
    }


}
