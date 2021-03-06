package com.cssrc.mibopoly.view.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.cssrc.mibopoly.R;
import com.cssrc.mibopoly.adapter.OneSeatAdapter;
import com.cssrc.mibopoly.app.miboApplication;
import com.cssrc.mibopoly.di.components.DaggerOneSeatComponent;
import com.cssrc.mibopoly.di.modules.OneSeatModule;
import com.cssrc.mibopoly.di.modules.OpenEyeModule;
import com.cssrc.mibopoly.model.entity.OneDetailEntity;
import com.cssrc.mibopoly.model.entity.OneEntity;
import com.cssrc.mibopoly.presenter.OneSeatContract;
import com.cssrc.mibopoly.presenter.OneSeatPresenter;
import com.cssrc.mibopoly.view.activity.OneSeatDetailActivity;
import com.cssrc.mibopoly.view.listener.ItemClickListener;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class OneSeatFragment extends Fragment implements OneSeatContract.View {

    @Bind(R.id.recyclerview)
    RecyclerView recyclerView;

    OneSeatAdapter oneSeatAdapter;

    @Inject
    OneSeatPresenter oneSeatPresenter;

    public static OneSeatFragment newInstance(){
        OneSeatFragment fragmentCommon=new OneSeatFragment();
        Bundle bundle=new Bundle();
        fragmentCommon.setArguments(bundle);
        return fragmentCommon;
    }

    public OneSeatFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_one_seat, container, false);
        ButterKnife.bind(this, view);
        initPresenter();
        initData();
        initTest();
        return view;
    }

    private void initPresenter(){
        DaggerOneSeatComponent.builder()
                .netComponent(miboApplication.get(this.getActivity()).getNetComponent())
                .oneSeatModule(new OneSeatModule(this))
                .build()
                .inject(this);
    }

    private void initData(){
        oneSeatAdapter = new OneSeatAdapter(this.getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(oneSeatAdapter);
        recyclerView.addOnItemTouchListener(new ItemClickListener(this.getContext(),
                new ItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        List<OneEntity.dataBean> oneList = oneSeatAdapter.getData();
                        OneEntity.dataBean oneData = oneList.get(position);
                        oneSeatPresenter.getOneDetail(oneData.getItem_id());
                    }

                    @Override
                    public void onLongClick(View view, int posotion) {
                    }
                }));
    }

    private void initTest(){
        oneSeatPresenter.getOneSeatEntityList();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void showRecyclerView(List<OneEntity.dataBean> oneEntityList) {
        oneSeatAdapter.setData(oneEntityList);
    }

    @Override
    public void jumpToOneSeatDetailActivity(OneDetailEntity oneDetailEntity) {
        Intent intent = new Intent(this.getContext(), OneSeatDetailActivity.class);
        intent.putExtra("itemId", oneDetailEntity.getData().getContent_id());
        intent.putExtra("one_detail_title", oneDetailEntity.getData().getHp_title());
        intent.putExtra("profile_image", oneDetailEntity.getData().getAuthor().get(0).getWeb_url());
        intent.putExtra("one_detail_author", oneDetailEntity.getData().getAuthor().get(0).getUser_name());
        intent.putExtra("one_detail_content", oneDetailEntity.getData().getHp_content());
        this.startActivity(intent);
    }

}
