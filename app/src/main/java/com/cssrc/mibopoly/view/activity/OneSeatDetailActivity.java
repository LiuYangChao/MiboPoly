package com.cssrc.mibopoly.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.webkit.WebView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.cssrc.mibopoly.R;
import com.cssrc.mibopoly.adapter.OneSeatCommentAdapter;
import com.cssrc.mibopoly.app.miboApplication;
import com.cssrc.mibopoly.di.components.DaggerOneSeatDetailComponent;
import com.cssrc.mibopoly.di.modules.OneSeatDetailModule;
import com.cssrc.mibopoly.model.entity.OneComment;
import com.cssrc.mibopoly.presenter.OneSeatDetailContract;
import com.cssrc.mibopoly.presenter.OneSeatDetailPresenter;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class OneSeatDetailActivity extends AppCompatActivity implements OneSeatDetailContract.View{

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

    @Inject
    OneSeatDetailPresenter oneSeatDetailPresenter;
    OneSeatCommentAdapter oneSeatCommentAdapter;

    private String itemId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_seat_detail);
        ButterKnife.bind(this);
        initPresenter();
        initView();
        initData();
    }

    private void initPresenter(){
        DaggerOneSeatDetailComponent.builder()
                .netComponent(miboApplication.get(this).getNetComponent())
                .oneSeatDetailModule(new OneSeatDetailModule(this))
                .build()
                .inject(this);
    }

    private void initView(){
        Intent intent = getIntent();
        one_detail_title.setText(intent.getStringExtra("one_detail_title"));
        Glide.with(this).load(intent.getStringExtra("profile_image")).centerCrop().into(profile_image);
        one_detail_author.setText(intent.getStringExtra("one_detail_author"));
//        one_detail_content.loadData(intent.getStringExtra("one_detail_content"), "text/html; charset=UTF-8", null);
        itemId = intent.getStringExtra("itemId");
        one_detail_content.loadDataWithBaseURL(null, intent.getStringExtra("one_detail_content"), "text/html", "utf-8", null);
        oneSeatCommentAdapter = new OneSeatCommentAdapter(this);
        //解决ScrollerView和RecyclerView的嵌套滑动冲突问题
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
//        one_comment_recyclerview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        one_comment_recyclerview.setLayoutManager(linearLayoutManager);
        one_comment_recyclerview.setAdapter(oneSeatCommentAdapter);

    }

    private void initData(){
        oneSeatDetailPresenter.initData(itemId);
    }

    @Override
    public void initComment(OneComment oneComment) {
        oneSeatCommentAdapter.setData(oneComment);
    }
}
