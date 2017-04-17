package com.cssrc.mibopoly.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.cssrc.mibopoly.R;
import com.cssrc.mibopoly.model.entity.OpenEyeEntity;
import com.cssrc.mibopoly.utils.TimeUtils;
import com.cssrc.mibopoly.view.activity.OpenEyeVideoActivity;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Author liuyangchao
 * Date on 2017/4/10.20:20
 */

public class OpenEyeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<OpenEyeEntity> openEyeEntityList = new ArrayList<OpenEyeEntity>();

    public OpenEyeAdapter(Context context, Fragment fragment){
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_imagelist, parent, false);
        return new OpenEyeAdapter.OpenEyeHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final OpenEyeHolder openEyeHolder = (OpenEyeHolder) holder;
        final OpenEyeEntity openEyeEntity = openEyeEntityList.get(position);
        Glide.with(context).load(openEyeEntity.getData().getCover().getDetail()).centerCrop().into(openEyeHolder.imageView);
        openEyeHolder.title.setText(openEyeEntity.getData().getTitle());
        openEyeHolder.subtitle.setText(openEyeEntity.getData().getCategory()+" / " + TimeUtils.transDuration(openEyeEntity.getData().getDuration()));
        openEyeHolder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, OpenEyeVideoActivity.class);
                intent.putExtra("video_image", openEyeEntity.getData().getCover().getDetail());
                intent.putExtra("video_detail_title", openEyeEntity.getData().getTitle());
                intent.putExtra("video_detail_time", openEyeHolder.subtitle.getText().toString());
                intent.putExtra("video_detail_from", openEyeEntity.getData().getProvider().getName());
                intent.putExtra("video_detail_desc", openEyeEntity.getData().getDescription());
                intent.putExtra("video_detail_tv_fav", openEyeEntity.getData().getConsumption().getCollectionCount());
                intent.putExtra("video_detail_tv_share", openEyeEntity.getData().getConsumption().getShareCount());
                intent.putExtra("video_detail_tv_reply", openEyeEntity.getData().getConsumption().getReplyCount());
                intent.putExtra("video_second_background", openEyeEntity.getData().getCover().getBlurred());
                intent.putExtra("videoUri", openEyeEntity.getData().getPlayUrl());
                intent.putExtra("videoTitle", openEyeEntity.getData().getTitle());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return openEyeEntityList.size();
    }

    static class OpenEyeHolder extends RecyclerView.ViewHolder{
        @Bind(R.id.iv_cover)
        ImageView imageView;
        @Bind(R.id.open_title)
        TextView title;
        @Bind(R.id.open_time)
        TextView subtitle;

        public OpenEyeHolder(View view){
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    static class OpenEyeHeaderHolder extends RecyclerView.ViewHolder{
        @Bind(R.id.iv_cover)
        ImageView imageView;
        @Bind(R.id.open_title)
        TextView title;
        @Bind(R.id.open_time)
        TextView subtitle;

        public OpenEyeHeaderHolder(View view){
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    static class OpenEyeEndHolder extends RecyclerView.ViewHolder{
        @Bind(R.id.iv_cover)
        ImageView imageView;
        @Bind(R.id.open_title)
        TextView title;
        @Bind(R.id.open_time)
        TextView subtitle;

        public OpenEyeEndHolder(View view){
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public void setData(List<OpenEyeEntity> openEyeEntityList){
        this.openEyeEntityList.clear();
        this.openEyeEntityList.addAll(openEyeEntityList);
        notifyDataSetChanged();
    }
}
