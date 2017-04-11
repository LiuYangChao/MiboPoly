package com.cssrc.mibopoly.presenter;

/**
 * Author liuyangchao
 * Date on 2017/4/10.11:30
 */

public interface MainContract {

    interface Presenter{
        void initData();
    }

    interface View{
        void showError(String errorStr);
    }

}
