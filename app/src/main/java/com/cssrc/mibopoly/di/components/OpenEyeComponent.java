package com.cssrc.mibopoly.di.components;

import com.cssrc.mibopoly.di.modules.OpenEyeModule;
import com.cssrc.mibopoly.di.scopes.UserScope;
import com.cssrc.mibopoly.view.fragment.OpenEyeFragment;

import dagger.Component;

/**
 * Author liuyangchao
 * Date on 2017/4/10.20:02
 */
@UserScope
@Component(modules = OpenEyeModule.class, dependencies = NetComponent.class)
public interface OpenEyeComponent {

    void inject(OpenEyeFragment openEyeFragment);

}
