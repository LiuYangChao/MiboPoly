package com.cssrc.mibopoly.presenter;

import android.util.Log;

import com.cssrc.mibopoly.model.api.ApiService;
import com.cssrc.mibopoly.model.entity.OneDetailEntity;
import com.cssrc.mibopoly.model.entity.OneEntity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Author liuyangchao
 * Date on 2017/4/12.19:41
 */

public class OneSeatPresenter implements OneSeatContract.Presenter {

    private OneSeatContract.View view;
    private ApiService apiService;

    @Inject
    public OneSeatPresenter(OneSeatContract.View view, ApiService apiService){
        this.view = view;
        this.apiService = apiService;
    }

    @Override
    public void getOneSeatEntityList() {
        apiService.getOneSeat("http://v3.wufazhuce.com:8000/api/channel/reading/more/0")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<OneEntity>() {
                    @Override
                    public void onCompleted() {
                        Log.i("oneSeat", "com");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("oneSeat", e.toString());
                    }

                    @Override
                    public void onNext(OneEntity oneEntity) {
                        List<OneEntity.dataBean> oneEntityList = new ArrayList<OneEntity.dataBean>();
                        oneEntityList = oneEntity.getData();
                        view.showRecyclerView(oneEntityList);
                    }
                });
    }

    @Override
    public void getOneDetail(String itemId) {
        apiService.getOneDetailEntity("http://v3.wufazhuce.com:8000/api/essay/"+itemId+
            "?channel=wdj&source=channel_reading&source_id=9264&version=4.0.2&uuid=ffffffff-a90e-706a-63f7-ccf973aae5ee&platform=android")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<OneDetailEntity>() {
                    @Override
                    public void onCompleted() {
                        Log.i("oneSeat", "com");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("oneSeat", e.toString());
                    }

                    @Override
                    public void onNext(OneDetailEntity oneDetailEntity) {
                        view.jumpToOneSeatDetailActivity(oneDetailEntity);
                    }
                });
    }

}
