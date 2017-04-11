package com.cssrc.mibopoly.di.components;

import com.cssrc.mibopoly.MainActivity;
import com.cssrc.mibopoly.di.modules.MainModule;
import com.cssrc.mibopoly.di.scopes.UserScope;

import dagger.Component;

/**
 * Author liuyangchao
 * Date on 2017/4/10.11:29
 */
@UserScope
@Component(modules = MainModule.class, dependencies = NetComponent.class)
public interface MainComponent {
    void inject(MainActivity mainActivity);
}
