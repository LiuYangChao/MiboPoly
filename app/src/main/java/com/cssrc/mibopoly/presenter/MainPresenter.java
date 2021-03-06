package com.cssrc.mibopoly.presenter;

import android.util.Log;

import com.cssrc.mibopoly.model.api.ApiService;
import com.cssrc.mibopoly.model.entity.OpenEyeEntity;
import com.cssrc.mibopoly.model.entity.OpenEyeItem;

import java.util.List;

import javax.inject.Inject;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Author liuyangchao
 * Date on 2017/4/10.11:30
 */

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View view;
    private ApiService apiService;

    @Inject
    public MainPresenter(MainContract.View view, ApiService apiService){
        this.view = view;
        this.apiService = apiService;
    }

    @Override
    public void initData() {
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
                        view.showError(e.toString());
                    }

                    @Override
                    public void onNext(OpenEyeItem openEyeItem) {
                        Log.i("openeye", "next");
                        if(openEyeItem != null){
                            Log.i("eye", openEyeItem.toString());
                        }else{
                            int i = 0;
                        }
                    }

                });
    }
}
