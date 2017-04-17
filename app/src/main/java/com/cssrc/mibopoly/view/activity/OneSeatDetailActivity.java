package com.cssrc.mibopoly.view.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.webkit.WebView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.cssrc.mibopoly.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class OneSeatDetailActivity extends Activity {

    @Bind(R.id.one_detail_title)
    TextView one_detail_title;
    @Bind(R.id.profile_image)
    CircleImageView profile_image;
    @Bind(R.id.one_detail_author)
    TextView one_detail_author;
    @Bind(R.id.one_detail_content)
    WebView one_detail_content;
    @Bind(R.id.one_comment_recyclerview)
    RecyclerView one_comment_recyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_seat_detail);
        ButterKnife.bind(this);
        initView();
    }

    private void initView(){
        one_detail_title.setText(getIntent().getStringExtra("one_detail_title"));
        Glide.with(this).load(getIntent().getStringExtra("profile_image")).centerCrop().into(profile_image);
        one_detail_author.setText(getIntent().getStringExtra("one_detail_author"));
        one_detail_content.loadData(getIntent().getStringExtra("one_detail_content"), "text/html; charset=UTF-8", null);
    }

}
