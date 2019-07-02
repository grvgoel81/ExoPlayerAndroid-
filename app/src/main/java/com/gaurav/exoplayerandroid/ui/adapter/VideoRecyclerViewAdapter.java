package com.gaurav.exoplayerandroid.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.gaurav.exoplayerandroid.R;
import com.gaurav.exoplayerandroid.model.VideoModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VideoRecyclerViewAdapter extends RecyclerView.Adapter<VideoRecyclerViewAdapter.ViewHolder> {

    private final Context context;
    private ArrayList<VideoModel> videoModel;

    public VideoRecyclerViewAdapter(Context context, ArrayList<VideoModel> listViewDTO) {
        super();
        this.context = context;
        this.videoModel = listViewDTO;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_video_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        return videoModel.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvTitle)
        TextView tvTitle;
        @BindView(R.id.tvUserName)
        TextView tvUserName;
        @BindView(R.id.flVideo)
        public FrameLayout flVideo;
        @BindView(R.id.ivCover)
        public ImageView ivCover;

        @BindView(R.id.progressBar)
        public ProgressBar mProgressBar;
        public final View parent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            parent = itemView;
        }

        public void onBind(int position){
            parent.setTag(this);
            VideoModel videoList = videoModel.get(position);
            if(videoList!=null) {
                tvTitle.setText(videoList.getTitle());
                tvUserName.setText(videoList.getUserName());
                Glide.with(context)
                        .load(videoList.getCoverUrl()).apply(new RequestOptions().optionalCenterCrop())
                        .into(ivCover);

            }
        }

    }
}
