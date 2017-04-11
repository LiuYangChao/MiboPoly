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

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class OpenEyeFragment extends Fragment implements OpenEyeContract.View, SwipeRefreshLayout.OnRefreshListener {
    @Bind(R.id.openeye_recyclerview)
    RecyclerView openeye_recyclerview;

    Context context;
    OpenEyeAdapter openEyeAdapter;

    @Inject
    OpenEyePresenter openEyePresenter;

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
        openeye_recyclerview.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false));
//        openeye_recyclerview.addItemDecoration(new DividerItemDecoration(this.getContext(), 1));
        openeye_recyclerview.setAdapter(openEyeAdapter);
//        openeye_recyclerview.addOnScrollListener(new RecyclerView.OnScrollListener() {
//            @Override
//            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
//                if (newState == RecyclerView.SCROLL_STATE_IDLE && !isRefresh && hasMore && (lastVisibleItem+1  == recycleViewAdapter.getItemCount())){
//                    loadData(page, mode, recycleViewAdapter.getLastItemId(),deviceId, recycleViewAdapter.getLastItemCreateTime());
//                }
//            }
//
//            @Override
//            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
//                lastVisibleItem = ((LinearLayoutManager) recyclerView.getLayoutManager()).findLastVisibleItemPosition();
//            }
//        });

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

    }

    @Override
    public void showRecyclerView(List<OpenEyeEntity> openEyeEntityList) {
        openEyeAdapter.setData(openEyeEntityList);
    }
}
