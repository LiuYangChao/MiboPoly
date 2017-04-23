package com.cssrc.mibopoly.di.modules;

import com.cssrc.mibopoly.presenter.TuChongContract;

import dagger.Module;
import dagger.Provides;

/**
 * Author liuyangchao
 * Date on 2017/4/23.9:13
 */
@Module
public class TuChongModule {

    private TuChongContract.View view;
    public TuChongModule(TuChongContract.View view){
        this.view = view;
    }

    @Provides
    public TuChongContract.View provideView(){
        return view;
    }

}
