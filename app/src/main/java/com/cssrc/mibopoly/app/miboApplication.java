package com.cssrc.mibopoly.app;

import android.app.Application;
import android.content.Context;

import com.cssrc.mibopoly.di.components.DaggerNetComponent;
import com.cssrc.mibopoly.di.components.NetComponent;
import com.cssrc.mibopoly.di.modules.NetModule;

/**
 * Author liuyangchao
 * Date on 2017/4/10.11:14
 */

public class miboApplication extends Application{

    private static miboApplication instance;

    public static miboApplication get(Context context){
        return (miboApplication)context.getApplicationContext();
    }

    private NetComponent netComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        initNet();
        initDatabase();
    }

    private void initNet(){
        netComponent = DaggerNetComponent.builder()
                .netModule(new NetModule())
                .build();
    }
    private void initDatabase(){

    }

    public NetComponent getNetComponent() {
        return netComponent;
    }

    public static miboApplication getInstance() {
        return instance;
    }

}
