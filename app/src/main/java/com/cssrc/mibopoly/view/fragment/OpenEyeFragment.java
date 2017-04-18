package com.cssrc.mibopoly.view.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cssrc.mibopoly.R;
import com.cssrc.mibopoly.adapter.OpenEyeAdapter;
import com.cssrc.mibopoly.app.miboApplication;
import com.cssrc.mibopoly.di.components.DaggerOpenEyeComponent;
import com.cssrc.mibopoly.di.modules.OpenEyeModule;
import com.cssrc.mibopoly.model.entity.OpenEyeEntity;
import com.cssrc.mibopoly.presenter.OpenEyeContract;
import com.cssrc.mibopoly.presenter.OpenEyePresenter;
import com.cssrc.mibopoly.view.listener.EndLessOnScrollListener;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 刷新规则：
 * 下拉刷新更新内容从头开始
 * 上滑刷新更新内容从尾开始
 * A simple {@link Fragment} subclass.
 */
public class OpenEyeFragment extends Fragment implements OpenEyeContract.View, SwipeRefreshLayout.OnRefreshListener {

    @Bind(R.id.recyclerview)
    RecyclerView openeye_recyclerview;
    @Bind(R.id.swipe_refresh)
    SwipeRefreshLayout swipe_refresh;

    Context context;
    OpenEyeAdapter openEyeAdapter;
    String nextUrl;
    List<OpenEyeEntity> currentOpenEyeEntityList;

    @Inject
    OpenEyePresenter openEyePresenter;

    public static OpenEyeFragment newInstance(){
        OpenEyeFragment fragmentCommon=new OpenEyeFragment();
        Bundle bundle=new Bundle();
        fragmentCommon.setArguments(bundle);
        return fragmentCommon;
    }

    public OpenEyeFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_open_eye, container, false);
        ButterKnife.bind(this, view);
        initPresenter();
        initView();
        initData();
        return view;
    }

    private void initPresenter() {
        DaggerOpenEyeComponent.builder()
                .netComponent(miboApplication.get(this.getActivity()).getNetComponent())
                .openEyeModule(new OpenEyeModule(this))
                .build()
                .inject(this);
    }

    private void initView(){
        openEyeAdapter = new OpenEyeAdapter(this.getContext(), this);
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(
                this.getContext(), LinearLayoutManager.VERTICAL, false);
        openeye_recyclerview.setLayoutManager(mLinearLayoutManager);
//        openeye_recyclerview.addItemDecoration(new DividerItemDecoration(this.getContext(), 1));
        openeye_recyclerview.setAdapter(openEyeAdapter);
        openeye_recyclerview.addOnScrollListener(new EndLessOnScrollListener(mLinearLayoutManager) {
            @Override
            public void onLoadMore(int currentPage) {
                loadMoreData();
            }
        });
        swipe_refresh.setOnRefreshListener(this);
    }

    private void loadMoreData(){
        openEyePresenter.loadTop(nextUrl, currentOpenEyeEntityList);
    }

    private void initData(){
        openEyePresenter.getOpenEyeEntityList();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onRefresh() {
        openEyePresenter.loadBottom(nextUrl, currentOpenEyeEntityList);
    }

    @Override
    public void showRecyclerView(List<OpenEyeEntity> openEyeEntityList,
                                 String nextUrl) {
        openEyeAdapter.setData(openEyeEntityList);
        this.nextUrl = nextUrl;
    }
}
