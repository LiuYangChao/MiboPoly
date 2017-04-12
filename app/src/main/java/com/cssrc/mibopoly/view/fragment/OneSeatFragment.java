package com.cssrc.mibopoly.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cssrc.mibopoly.R;
import com.cssrc.mibopoly.adapter.OneSeatAdapter;
import com.cssrc.mibopoly.app.miboApplication;
import com.cssrc.mibopoly.di.components.DaggerOneSeatComponent;
import com.cssrc.mibopoly.di.modules.OneSeatModule;
import com.cssrc.mibopoly.di.modules.OpenEyeModule;
import com.cssrc.mibopoly.model.entity.OneEntity;
import com.cssrc.mibopoly.presenter.OneSeatContract;
import com.cssrc.mibopoly.presenter.OneSeatPresenter;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class OneSeatFragment extends Fragment implements OneSeatContract.View {

    @Bind(R.id.oneseat_recyclerview)
    RecyclerView recyclerView;

    OneSeatAdapter oneSeatAdapter;

    @Inject
    OneSeatPresenter oneSeatPresenter;

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
}
