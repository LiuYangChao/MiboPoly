package com.cssrc.mibopoly.presenter;

import android.util.Log;

import com.cssrc.mibopoly.model.api.ApiService;
import com.cssrc.mibopoly.model.entity.OpenEyeEntity;
import com.cssrc.mibopoly.model.entity.OpenEyeItem;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Author liuyangchao
 * Date on 2017/4/10.19:33
 */

public class OpenEyePresenter implements OpenEyeContract.Presenter {

    private OpenEyeContract.View view;
    private ApiService apiService;

    @Inject
    public OpenEyePresenter(OpenEyeContract.View view, ApiService apiService){
        this.view = view;
        this.apiService = apiService;
    }

    @Override
    public void getOpenEyeEntityList() {
        apiService.getOpenEye().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<OpenEyeItem>() {
                    @Override
                    public void onCompleted() {
                        Log.i("openeye", "com");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("openeye", e.toString());
                    }

                    @Override
                    public void onNext(OpenEyeItem openEyeItem) {
                        List<OpenEyeEntity> openEyeEntityListResult = new ArrayList<OpenEyeEntity>();
                        List<OpenEyeEntity> openEyeEntityList = openEyeItem.getItemList();
                        for(OpenEyeEntity openEyeEntity : openEyeEntityList){
                            if(openEyeEntity.getType()!=null && openEyeEntity.getType().equals("video")){
                                openEyeEntityListResult.add(openEyeEntity);
                            }
                        }
                        view.showRecyclerView(openEyeEntityListResult, openEyeItem.getNextPageUrl());
                    }
                });
    }

    /**
     * @param url       请求的URL
     * @param currentOpenEyeEntityList      当前数据列表
     * @param scrollPosition                        当前数据刷新方向
     */
    @Override
    public void loadScrollerData(String url,
                                 final List<OpenEyeEntity> currentOpenEyeEntityList,
                                 final String scrollPosition) {
        apiService.getOpenEyeTopOrBottom(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<OpenEyeItem>() {
                    @Override
                    public void onCompleted() {
                        Log.i("scroll", "scrollcom");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("scroll", e.toString());
                    }

                    @Override
                    public void onNext(OpenEyeItem openEyeItem) {
                        List<OpenEyeEntity> openEyeEntityListResult = new ArrayList<OpenEyeEntity>();
                        List<OpenEyeEntity> openEyeEntityList = openEyeItem.getItemList();
                        for(OpenEyeEntity openEyeEntity : openEyeEntityList){
                            if(openEyeEntity.getType()!=null && openEyeEntity.getType().equals("video")){
                                openEyeEntityListResult.add(openEyeEntity);
                            }
                        }
                        if(!scrollPosition.isEmpty() && scrollPosition.equals("top")){
                            currentOpenEyeEntityList.addAll(0, openEyeEntityListResult);
                        }else if(!scrollPosition.isEmpty() && scrollPosition.equals("bottom")){
                            currentOpenEyeEntityList.addAll(openEyeEntityListResult);
                        }
                        view.showRecyclerView(currentOpenEyeEntityList, openEyeItem.getNextPageUrl());
                    }
                });
    }

}
