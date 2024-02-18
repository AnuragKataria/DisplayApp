package com.quickfix.displaytv.viewpagertransformation.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.options.IFramePlayerOptions;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import com.quickfix.displaytv.R;
import com.quickfix.displaytv.global.DisplaySingleTone;
import com.quickfix.displaytv.utils.Utils;
import com.squareup.picasso.Picasso;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import okhttp3.internal.Util;


public class YoutubeFragment extends Fragment {

    String video;
    private YouTubePlayerView youTubePlayerView;
    private YouTubePlayer _youTubePlayer;

    public YoutubeFragment(String video) {
        this.video = video;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_youtube, container, false);
        try {
            assignIds(v);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return v;

    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        if (isVisibleToUser) {
            if (youTubePlayerView != null) {
                playV();
            }
        } else {
            if (_youTubePlayer != null) {
                _youTubePlayer.pause();
                _youTubePlayer.seekTo(0);
            }
        }
    }

    // Binding UI with JAVA code


    private void assignIds(View v) {
        youTubePlayerView = v.findViewById(R.id.youtube_player_view);
        getLifecycle().addObserver(youTubePlayerView);
        playVideo();
    }

    private void playVideo() {
        IFramePlayerOptions iFramePlayerOptions = new IFramePlayerOptions.Builder()
                .controls(1)
                .fullscreen(0)
                .controls(0)
                .build();
        youTubePlayerView.initialize(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                try {
                    _youTubePlayer = youTubePlayer;
                    if (DisplaySingleTone.getInstance().getFirstType() == 2) {
                        playV();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }, iFramePlayerOptions);
    }

    private void playV() {
        try {
            _youTubePlayer.loadVideo(getYoutubeId(video), 0);
            _youTubePlayer.addListener(new YouTubePlayerListener() {
                @Override
                public void onReady(@NonNull YouTubePlayer youTubePlayer) {

                }

                @Override
                public void onStateChange(@NonNull YouTubePlayer youTubePlayer, @NonNull PlayerConstants.PlayerState playerState) {
                    if (playerState == PlayerConstants.PlayerState.ENDED) {
                        if (DisplaySingleTone.getInstance().getFirstType() == 2) {
                            if (Utils.getPageSize(getActivity()) == 1) {
                                playV();
                            }

                        }
                    }

                }

                @Override
                public void onPlaybackQualityChange(@NonNull YouTubePlayer youTubePlayer, @NonNull PlayerConstants.PlaybackQuality playbackQuality) {

                }

                @Override
                public void onPlaybackRateChange(@NonNull YouTubePlayer youTubePlayer, @NonNull PlayerConstants.PlaybackRate playbackRate) {

                }

                @Override
                public void onError(@NonNull YouTubePlayer youTubePlayer, @NonNull PlayerConstants.PlayerError playerError) {

                }

                @Override
                public void onCurrentSecond(@NonNull YouTubePlayer youTubePlayer, float v) {

                }

                @Override
                public void onVideoDuration(@NonNull YouTubePlayer youTubePlayer, float v) {

                }

                @Override
                public void onVideoLoadedFraction(@NonNull YouTubePlayer youTubePlayer, float v) {

                }

                @Override
                public void onVideoId(@NonNull YouTubePlayer youTubePlayer, @NonNull String s) {

                }

                @Override
                public void onApiChange(@NonNull YouTubePlayer youTubePlayer) {

                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Getting Youtube video ID from the link
    public static String getYoutubeId(String ytUrl) throws Exception {
        String videoId = "";

        Pattern regex = Pattern.compile("http(?:s)?://(?:www\\.)?youtu(?:\\.be/|be\\.com/(?:watch\\?v=|v/|embed/|user/(?:[\\w#]+/)+))([^&#?\n]+)");
        Matcher regexMatcher = regex.matcher(ytUrl);
        if (regexMatcher.find()) {
            videoId = regexMatcher.group(1);
        }
        Log.i("VIDEODE , ", videoId);
        return videoId;

    }
}