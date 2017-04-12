package com.cssrc.mibopoly.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.cssrc.mibopoly.R;
import com.cssrc.mibopoly.model.entity.OneEntity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Author liuyangchao
 * Date on 2017/4/12.10:22
 */

public class OneSeatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<OneEntity.dataBean> oneEntityList = new ArrayList<OneEntity.dataBean>();

    public OneSeatAdapter(Context context){
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_oneseat, parent, false);
        return new OneSeatAdapter.OneSeatHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        OneEntity.dataBean oneEntity = oneEntityList.get(position);
        OneSeatHolder oneSeatHolder = (OneSeatHolder) holder;
        Glide.with(context).load(oneEntity.getImg_url()).centerCrop().into(oneSeatHolder.imageView);
        oneSeatHolder.author.setText(oneEntity.getAuthor().getUser_name());
        oneSeatHolder.des.setText(oneEntity.getForward());
        oneSeatHolder.time.setText(oneEntity.getPost_date());
        oneSeatHolder.title.setText(oneEntity.getTitle());
    }

    @Override
    public int getItemCount() {
        return oneEntityList.size();
    }

    static class OneSeatHolder extends RecyclerView.ViewHolder{
        @Bind(R.id.iv_cover)
        ImageView imageView;
        @Bind(R.id.one_title)
        TextView title;
        @Bind(R.id.one_author)
        TextView author;
        @Bind(R.id.one_des)
        TextView des;
        @Bind(R.id.one_time)
        TextView time;

        public OneSeatHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public void setData(List<OneEntity.dataBean> oneEntityList){
        this.oneEntityList.clear();
        this.oneEntityList = oneEntityList;
        notifyDataSetChanged();
    }

}
