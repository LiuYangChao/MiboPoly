package com.cssrc.mibopoly.di.components;

import com.cssrc.mibopoly.di.modules.NetModule;
import com.cssrc.mibopoly.model.api.ApiService;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Author liuyangchao
 * Date on 2017/4/10.9:53
 */
@Component(modules = NetModule.class)
@Singleton
public interface NetComponent {

    ApiService getApiService();

}