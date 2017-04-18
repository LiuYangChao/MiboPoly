package com.cssrc.mibopoly.di.components;

import com.cssrc.mibopoly.di.modules.OneSeatDetailModule;
import com.cssrc.mibopoly.di.scopes.UserScope;
import com.cssrc.mibopoly.view.activity.OneSeatDetailActivity;

import dagger.Component;

/**
 * Author liuyangchao
 * Date on 2017/4/17.16:41
 */
@UserScope
@Component(modules = OneSeatDetailModule.class, dependencies = NetComponent.class)
public interface OneSeatDetailComponent {

    void inject(OneSeatDetailActivity oneSeatDetailActivity);

}
