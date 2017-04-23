package com.cssrc.mibopoly.di.components;

import com.cssrc.mibopoly.di.modules.TuChongModule;
import com.cssrc.mibopoly.di.scopes.UserScope;
import com.cssrc.mibopoly.view.fragment.TuChongFragment;

import dagger.Component;

/**
 * Author liuyangchao
 * Date on 2017/4/23.9:13
 */
@UserScope
@Component(modules = TuChongModule.class, dependencies = NetComponent.class)
public interface TuChongComponent {

    void inject(TuChongFragment tuChongFragment);

}
