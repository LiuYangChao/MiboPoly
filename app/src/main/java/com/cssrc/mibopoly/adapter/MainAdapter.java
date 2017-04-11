package com.cssrc.mibopoly.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.cssrc.mibopoly.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Author liuyangchao
 * Date on 2017/4/8.15:25
 */

public class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {





    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_imagelist, parent, false);
        return new MainHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    static class MainHolder extends RecyclerView.ViewHolder{
        @Bind(R.id.iv_cover)
        ImageView imageView;

        public MainHolder(View view){
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
