package com.cssrc.mibopoly.presenter;

import android.util.Log;

import com.cssrc.mibopoly.model.api.ApiService;
import com.cssrc.mibopoly.model.entity.OneComment;
import com.cssrc.mibopoly.model.entity.OneEntity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Author liuyangchao
 * Date on 2017/4/17.16:35
 */

public class OneSeatDetailPresenter implements OneSeatDetailContract.Presenter{

    private OneSeatDetailContract.View view;
    private ApiService apiService;

    @Inject
    public OneSeatDetailPresenter(OneSeatDetailContract.View view, ApiService apiService){
        this.view = view;
        this.apiService = apiService;
    }

    @Override
    public void initData(String itemId) {
        apiService.getOneComment("http://v3.wufazhuce.com:8000/api/comment/praiseandtime/essay/"+itemId+
            "/0?channel=wdj&version=4.0.2&uuid=ffffffff-a90e-706a-63f7-ccf973aae5ee&platform=android")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<OneComment>() {
                    @Override
                    public void onCompleted() {
                        Log.i("oneComment", "com");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("oneComment", e.toString());
                    }

                    @Override
                    public void onNext(OneComment oneComment) {
                        view.initComment(oneComment);
                    }
                });
    }

}
