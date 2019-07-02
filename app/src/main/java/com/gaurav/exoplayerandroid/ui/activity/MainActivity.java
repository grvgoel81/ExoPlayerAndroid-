package com.gaurav.exoplayerandroid.ui.activity;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gaurav.exoplayerandroid.R;
import com.gaurav.exoplayerandroid.model.VideoModel;
import com.gaurav.exoplayerandroid.ui.adapter.VideoRecyclerViewAdapter;
import com.gaurav.exoplayerandroid.util.Data;
import com.gaurav.exoplayerandroid.ui.ExoPlayerView;
import com.gaurav.exoplayerandroid.util.DividerItemDecoration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rvVideoFeeds)
    ExoPlayerView recyclerViewFeed;

    private VideoRecyclerViewAdapter videoRecyclerViewAdapter;
    private boolean firstTime = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        ArrayList<VideoModel> videoModels = new ArrayList<VideoModel>((Collection<? extends VideoModel>) Arrays.asList(Data.VIDEO_MODELS));
        recyclerViewFeed.setvideoList(videoModels);
        videoRecyclerViewAdapter = new VideoRecyclerViewAdapter(MainActivity.this, videoModels);
        recyclerViewFeed.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        Drawable dividerDrawable = ContextCompat.getDrawable(this, R.drawable.divider_drawable);
        recyclerViewFeed.addItemDecoration(new DividerItemDecoration(dividerDrawable));
        recyclerViewFeed.setItemAnimator(new DefaultItemAnimator());
        recyclerViewFeed.setAdapter(videoRecyclerViewAdapter);

        if (firstTime) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    recyclerViewFeed.playVideo();
                }
            });
            firstTime = false;
        }
        recyclerViewFeed.scrollToPosition(0);
    }
}

