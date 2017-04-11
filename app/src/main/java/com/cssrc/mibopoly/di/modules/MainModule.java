package com.cssrc.mibopoly.di.modules;

import com.cssrc.mibopoly.presenter.MainContract;

import dagger.Module;
import dagger.Provides;

/**
 * Author liuyangchao
 * Date on 2017/4/10.11:29
 */
@Module
public class MainModule {

    private final MainContract.View view;

    public MainModule(MainContract.View view){
        this.view = view;
    }

    @Provides
    public MainContract.View provideView(){
        return view;
    }
}
