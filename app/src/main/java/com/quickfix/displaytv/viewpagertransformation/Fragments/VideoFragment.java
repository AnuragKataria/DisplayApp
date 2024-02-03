package com.quickfix.displaytv.viewpagertransformation.Fragments;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.VideoView;

import androidx.fragment.app.Fragment;

import com.quickfix.displaytv.R;
import com.quickfix.displaytv.global.DisplaySingleTone;


public class VideoFragment extends Fragment {

    String video;
    private VideoView videoView;

    public VideoFragment(String video) {
        this.video = video;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        if(isVisibleToUser){
            try {
                playVideo();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }else{
            if(videoView!=null){
                videoView.pause();
                videoView.stopPlayback();
            }

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_video, container, false);
      assignIds(v);
        return v;

    }
    private void assignIds(View v) {
        try {
            videoView = v.findViewById(R.id.videoView);
            if(DisplaySingleTone.getInstance().getFirstType() ==1){
                playVideo();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void playVideo(){
        videoView.setVideoURI(Uri.parse(video));
        videoView.start();
    }
}