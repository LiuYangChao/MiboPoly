package com.cssrc.mibopoly.view.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.cssrc.mibopoly.R;

import butterknife.Bind;
import butterknife.BindDimen;
import butterknife.ButterKnife;

public class OpenEyeVideoActivity extends AppCompatActivity {

    @Bind(R.id.video_image)
    ImageView video_image;
    @Bind(R.id.video_detail_title)
    TextView video_detail_title;
    @Bind(R.id.video_detail_time)
    TextView video_detail_time;
    @Bind(R.id.video_detail_from)
    TextView video_detail_from;
    @Bind(R.id.video_detail_desc)
    TextView video_detail_desc;
    @Bind(R.id.video_detail_tv_fav)
    TextView video_detail_tv_fav;
    @Bind(R.id.video_detail_tv_share)
    TextView video_detail_tv_share;
    @Bind(R.id.video_detail_tv_reply)
    TextView video_detail_tv_reply;
    @Bind(R.id.video_second)
    LinearLayout video_second;
    @Bind(R.id.video_second_bg)
    ImageView video_second_bg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_eye_video);
        ButterKnife.bind(this);
        initData();
    }

    private void initData(){
        Glide.with(this).load(getIntent().getStringExtra("video_image")).centerCrop().into(video_image);
        video_detail_title.setText(getIntent().getStringExtra("video_detail_title"));
        video_detail_time.setText(getIntent().getStringExtra("video_detail_time"));
        video_detail_from.setText("来源："+getIntent().getStringExtra("video_detail_from"));
        video_detail_desc.setText(getIntent().getStringExtra("video_detail_desc"));
        video_detail_tv_fav.setText(String.valueOf(getIntent().getIntExtra("video_detail_tv_fav", 0)));
        video_detail_tv_share.setText(String.valueOf(getIntent().getIntExtra("video_detail_tv_share", 0)));
        video_detail_tv_reply.setText(String.valueOf(getIntent().getIntExtra("video_detail_tv_reply", 0)));
        Glide.with(this).load(getIntent().getStringExtra("video_second_background")).centerCrop().into(video_second_bg);
    }

}
