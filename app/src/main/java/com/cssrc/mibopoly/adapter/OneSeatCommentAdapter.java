package com.cssrc.mibopoly.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.cssrc.mibopoly.R;
import com.cssrc.mibopoly.model.entity.OneComment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Author liuyangchao
 * Date on 2017/4/17.10:17
 */

public class OneSeatCommentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<OneComment.dataBean.dataBean2> oneCommentList = new ArrayList<OneComment.dataBean.dataBean2>();

    public OneSeatCommentAdapter(Context context){
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_comment, parent, false);
        return new OneSeatCommentAdapter.OneSeatHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        OneSeatHolder oneSeatHolder = (OneSeatHolder) holder;
        OneComment.dataBean.dataBean2 oneComment = oneCommentList.get(position);
        Glide.with(context).load(oneComment.getUser().getWeb_url()).centerCrop().into(oneSeatHolder.comment_image);
        oneSeatHolder.comment_author.setText(oneComment.getUser().getUser_name());
        oneSeatHolder.comment_time.setText(oneComment.getUpdated_at());
        oneSeatHolder.comment_content.setText(oneComment.getContent());
    }

    @Override
    public int getItemCount() {
        return oneCommentList.size();
    }

    static class OneSeatHolder extends RecyclerView.ViewHolder{
        @Bind(R.id.comment_image)
        CircleImageView comment_image;
        @Bind(R.id.comment_author)
        TextView comment_author;
        @Bind(R.id.comment_time)
        TextView comment_time;
        @Bind(R.id.comment_content)
        TextView comment_content;

        public OneSeatHolder(View view){
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public void setData(OneComment oneComment){
        this.oneCommentList.clear();
        this.oneCommentList.addAll(oneComment.getData().getData());
        notifyDataSetChanged();
    }
}
