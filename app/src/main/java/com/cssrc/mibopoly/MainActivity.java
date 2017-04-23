package com.cssrc.mibopoly;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.cssrc.mibopoly.app.miboApplication;
import com.cssrc.mibopoly.di.components.DaggerMainComponent;
import com.cssrc.mibopoly.di.modules.MainModule;
import com.cssrc.mibopoly.presenter.MainContract;
import com.cssrc.mibopoly.presenter.MainPresenter;
import com.cssrc.mibopoly.view.fragment.TuChongFragment;
import com.cssrc.mibopoly.view.fragment.OneSeatFragment;
import com.cssrc.mibopoly.view.fragment.OpenEyeFragment;
import com.cssrc.mibopoly.view.fragment.SettingFragment;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainContract.View,
        BottomNavigationBar.OnTabSelectedListener{

    @Bind(R.id.bottom_navigation_bar)
    BottomNavigationBar bottomNavigationBar;
    @Bind(R.id.toolBar)
    Toolbar toolbar;

    TuChongFragment tuChongFragment;
    OneSeatFragment oneSeatFragment;
    OpenEyeFragment openEyeFragment;
    SettingFragment settingFragment;
    int lastSelectedPosition = 0;

    @Inject
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initFragment();
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

    private void initFragment(){
        FragmentManager fragmentManager = this.getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        openEyeFragment = new OpenEyeFragment();
        transaction.replace(R.id.fragment, openEyeFragment);
        transaction.commit();
    }

    private void initView(){
        bottomNavigationBar.clearAll();
        bottomNavigationBar
                .setMode(BottomNavigationBar.MODE_FIXED);
        bottomNavigationBar
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        bottomNavigationBar.setTabSelectedListener(this);
        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.ic_action_pic, "Home").setActiveColorResource(R.color.orange))
                .addItem(new BottomNavigationItem(R.drawable.ic_action_article, "Books").setActiveColorResource(R.color.teal))
                .addItem(new BottomNavigationItem(R.drawable.ic_action_movie, "Music").setActiveColorResource(R.color.blue))
                .addItem(new BottomNavigationItem(R.drawable.ic_action_me, "Movies & TV").setActiveColorResource(R.color.brown))
//                .addItem(new BottomNavigationItem(R.drawable.ic_videogame_asset_white_24dp, "Games").setActiveColorResource(R.color.grey))
                .setFirstSelectedPosition(lastSelectedPosition)
                .initialise();
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


    private void switchFragment(int position){
        FragmentManager fragmentManager = this.getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        hideFragments(transaction);
        switch (position) {
            case 0:
                if(openEyeFragment == null){
                    openEyeFragment = new OpenEyeFragment();
                    transaction.add(R.id.fragment, openEyeFragment);
                }else{
                    transaction.show(openEyeFragment);
                }
                break;
            case 1:
                if(oneSeatFragment == null){
                    oneSeatFragment = new OneSeatFragment();
                    transaction.add(R.id.fragment, oneSeatFragment);
                }else{
                    transaction.show(oneSeatFragment);
                }
                break;
            case 2:
                if(tuChongFragment == null){
                    tuChongFragment = new TuChongFragment();
                    transaction.add(R.id.fragment, tuChongFragment);
                }else{
                    transaction.show(tuChongFragment);
                }
                break;
            case 3:
                if(settingFragment == null){
                    settingFragment = new SettingFragment();
                    transaction.add(R.id.fragment, settingFragment);
                }else{
                    transaction.show(settingFragment);
                }
                break;
            default:
                if(openEyeFragment == null){
                    openEyeFragment = new OpenEyeFragment();
                    transaction.add(R.id.fragment, openEyeFragment);
                }else{
                    transaction.show(openEyeFragment);
                }
        }
        transaction.commit();
    }

    /**
     * 隐藏所有的Fragment，避免fragment混乱
     *
     * @param
     */
    private void hideFragments(FragmentTransaction transaction) {
        if (tuChongFragment != null) {
            transaction.hide(tuChongFragment);
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

    @Override
    public void onTabSelected(int position) {
        switchFragment(position);
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {
        switchFragment(position);
    }
}
