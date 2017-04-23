package com.cssrc.mibopoly.presenter;

import com.cssrc.mibopoly.model.api.ApiService;

import javax.inject.Inject;

/**
 * Author liuyangchao
 * Date on 2017/4/23.9:14
 */

public class TuChongPresenter implements TuChongContract.Presenter {

    private TuChongContract.View view;
    private ApiService apiService;

    @Inject
    public TuChongPresenter(TuChongContract.View view, ApiService apiService){
        this.view = view;
        this.apiService = apiService;
    }

}
