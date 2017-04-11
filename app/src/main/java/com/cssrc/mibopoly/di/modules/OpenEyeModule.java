package com.cssrc.mibopoly.di.modules;

import com.cssrc.mibopoly.presenter.OpenEyeContract;

import dagger.Module;
import dagger.Provides;

/**
 * Author liuyangchao
 * Date on 2017/4/10.20:02
 */
@Module
public class OpenEyeModule {

    private OpenEyeContract.View view;

    public OpenEyeModule(OpenEyeContract.View view){
        this.view = view;
    }

    @Provides
    public OpenEyeContract.View provideView(){
        return view;
    }

}
