package com.cssrc.mibopoly.di.modules;

import com.cssrc.mibopoly.presenter.OneSeatDetailContract;

import dagger.Module;
import dagger.Provides;

/**
 * Author liuyangchao
 * Date on 2017/4/17.16:41
 */
@Module
public class OneSeatDetailModule {

    private final OneSeatDetailContract.View view;

    public OneSeatDetailModule(OneSeatDetailContract.View view){
        this.view = view;
    }

    @Provides
    public OneSeatDetailContract.View provideView(){
        return view;
    }

}
