package com.cssrc.mibopoly;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.cssrc.mibopoly.adapter.MainAdapter;
import com.cssrc.mibopoly.app.miboApplication;
import com.cssrc.mibopoly.di.components.DaggerMainComponent;
import com.cssrc.mibopoly.di.modules.MainModule;
import com.cssrc.mibopoly.model.api.ApiService;
import com.cssrc.mibopoly.model.entity.OpenEyeEntity;
import com.cssrc.mibopoly.presenter.MainContract;
import com.cssrc.mibopoly.presenter.MainPresenter;
import com.cssrc.mibopoly.view.fragment.DoubanFragment;
import com.cssrc.mibopoly.view.fragment.OneSeatFragment;
import com.cssrc.mibopoly.view.fragment.OpenEyeFragment;
import com.cssrc.mibopoly.view.fragment.SettingFragment;


import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity implements MainContract.View
//    ,BottomNavigationView.OnNavigationItemSelectedListener
    {

//    @Bind(R.id.rv_content)
//    RecyclerView recyclerView;
    @Bind(R.id.bnv_menu)
    BottomNavigationView bottomNavigationView;
    @Bind(R.id.main_fragment)
    LinearLayout main_fragment;

    private FragmentTransaction transaction;
    private FragmentManager fragmentManager;
    DoubanFragment doubanFragment;
    OneSeatFragment oneSeatFragment;
    OpenEyeFragment openEyeFragment;
    SettingFragment settingFragment;

    MainAdapter mainAdapter;

    @Inject
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
//        mainAdapter = new MainAdapter();
//        recyclerView.setAdapter(mainAdapter);

        initPresenter();
        initView();
        mainPresenter.initData();
    }

    private void initPresenter(){
        DaggerMainComponent.builder()
                .netComponent(miboApplication.get(this).getNetComponent())
                .mainModule(new MainModule(this))
                .build()
                .inject(this);
    }

    private void initView(){
        fragmentManager = getSupportFragmentManager();
//        transaction = fragmentManager.beginTransaction();
//        if(openEyeFragment == null){
//            openEyeFragment = new OpenEyeFragment();
//            transaction.add(R.id.main_fragment, openEyeFragment);
//        }else{
//            transaction.show(openEyeFragment);
//        }
//        transaction.commit();
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        transaction = fragmentManager.beginTransaction();
                        hideFragments(transaction);
                        switch (item.getItemId()) {
                            case R.id.action_pic:
                                if(openEyeFragment == null){
                                    openEyeFragment = new OpenEyeFragment();
                                    transaction.add(R.id.main_fragment, openEyeFragment);
                                }else{
                                    transaction.show(openEyeFragment);
                                }
                                break;
                            case R.id.action_article:
                                if(oneSeatFragment == null){
                                    oneSeatFragment = new OneSeatFragment();
                                    transaction.add(R.id.main_fragment, oneSeatFragment);
                                }else{
                                    transaction.show(oneSeatFragment);
                                }
                                break;
                            case R.id.action_movie:
                                if(doubanFragment == null){
                                    doubanFragment = new DoubanFragment();
                                    transaction.add(R.id.main_fragment, doubanFragment);
                                }else{
                                    transaction.show(doubanFragment);
                                }
                                break;
                            case R.id.action_me:
                                if(settingFragment == null){
                                    settingFragment = new SettingFragment();
                                    transaction.add(R.id.main_fragment, settingFragment);
                                }else{
                                    transaction.show(settingFragment);
                                }
                                break;
                            default:
                                if(openEyeFragment == null){
                                    openEyeFragment = new OpenEyeFragment();
                                    transaction.add(R.id.main_fragment, openEyeFragment);
                                }else{
                                    transaction.show(openEyeFragment);
                                }
                        }
                        transaction.commit();
                        return true;
                    }
                });
    }

    @Override
    public void showError(String errorStr) {
        new AlertDialog.Builder(this)
                .setTitle("Error")
                .setMessage(errorStr)
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .create()
                .show();
    }

//    @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//        transaction = fragmentManager.beginTransaction();
//        hideFragments(transaction);
//        switch(item.getItemId()){
//            case R.id.action_pic:
//                if(openEyeFragment == null){
//                    openEyeFragment = new OpenEyeFragment();
//                    transaction.add(R.id.main_fragment, openEyeFragment);
//                }else{
//                    transaction.show(openEyeFragment);
//                }
//                break;
//            case R.id.action_article:
//                if(oneSeatFragment == null){
//                    oneSeatFragment = new OneSeatFragment();
//                    transaction.add(R.id.main_fragment, oneSeatFragment);
//                }else{
//                    transaction.show(oneSeatFragment);
//                }
//                break;
//            case R.id.action_movie:
//                if(doubanFragment == null){
//                    doubanFragment = new DoubanFragment();
//                    transaction.add(R.id.main_fragment, doubanFragment);
//                }else{
//                    transaction.show(doubanFragment);
//                }
//                break;
//            case R.id.action_me:
//                if(settingFragment == null){
//                    settingFragment = new SettingFragment();
//                    transaction.add(R.id.main_fragment, settingFragment);
//                }else{
//                    transaction.show(settingFragment);
//                }
//                break;
//            default:
//                if(openEyeFragment == null){
//                    openEyeFragment = new OpenEyeFragment();
//                    transaction.add(R.id.main_fragment, openEyeFragment);
//                }else{
//                    transaction.show(openEyeFragment);
//                }
//        }
//        return false;
//    }

    /**
     * 隐藏所有的Fragment，避免fragment混乱
     *
     * @param transaction
     */
    private void hideFragments(FragmentTransaction transaction) {
        if (doubanFragment != null) {
            transaction.hide(doubanFragment);
        }
        if (oneSeatFragment != null) {
            transaction.hide(oneSeatFragment);
        }
        if (openEyeFragment != null) {
            transaction.hide(openEyeFragment);
        }
        if (settingFragment != null) {
            transaction.hide(settingFragment);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

}
