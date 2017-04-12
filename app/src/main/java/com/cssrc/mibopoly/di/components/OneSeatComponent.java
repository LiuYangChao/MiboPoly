package com.cssrc.mibopoly.di.components;

import com.cssrc.mibopoly.di.modules.OneSeatModule;
import com.cssrc.mibopoly.di.scopes.UserScope;
import com.cssrc.mibopoly.view.fragment.OneSeatFragment;

import dagger.Component;

/**
 * Author liuyangchao
 * Date on 2017/4/12.20:06
 */
@UserScope
@Component(modules = OneSeatModule.class, dependencies = NetComponent.class)
public interface OneSeatComponent {

    void inject(OneSeatFragment oneSeatFragment);

}
