package com.cssrc.mibopoly.view.listener;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Author liuyangchao
 * Date on 2017/4/17.10:46
 */

public class ItemClickListener extends RecyclerView.SimpleOnItemTouchListener {

    public interface OnItemClickListener{
        void onItemClick(View view, int position);
        void onItemLongClick(View view, int position);
    }

















}
