package com.quickfix.displaytv.viewpagertransformation.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.quickfix.displaytv.R;
import com.squareup.picasso.Picasso;


public class ImageFragment extends Fragment {

    String image;
    private ImageView imageView;

    public ImageFragment(String image) {
        this.image = image;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_image, container, false);
        try {
            assignIds(v);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    private void assignIds(View v) {
        imageView = v.findViewById(R.id.imageView);
        if (image != null) {
            Picasso.get().load(image).into(imageView);
        }
    }
}