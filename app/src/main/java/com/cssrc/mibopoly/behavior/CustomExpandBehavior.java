package com.cssrc.mibopoly.behavior;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;

/**
 * Author liuyangchao
 * Date on 2017/4/8.14:50
 */

public class CustomExpandBehavior extends CoordinatorLayout.Behavior {

    CustomExpandBehavior(Context context, AttributeSet attributeSet){
        super(context, attributeSet);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return dependency instanceof AppBarLayout;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        int delta = dependency.getTop();
        child.setTranslationY(-delta);
        return true;
    }
}
