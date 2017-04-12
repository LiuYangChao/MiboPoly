package com.cssrc.mibopoly.di.modules;

import com.cssrc.mibopoly.presenter.OneSeatContract;

import dagger.Module;
import dagger.Provides;

/**
 * Author liuyangchao
 * Date on 2017/4/12.20:07
 */
@Module
public class OneSeatModule {

    private OneSeatContract.View view;

    public OneSeatModule(OneSeatContract.View view){
        this.view = view;
    }

    @Provides
    public OneSeatContract.View provideView(){
        return view;
    }

}
