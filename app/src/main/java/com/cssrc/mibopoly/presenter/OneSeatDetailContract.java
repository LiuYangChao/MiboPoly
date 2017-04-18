package com.cssrc.mibopoly.presenter;

import com.cssrc.mibopoly.model.entity.OneComment;

/**
 * Author liuyangchao
 * Date on 2017/4/17.16:35
 */

public interface OneSeatDetailContract {

    interface Presenter{
        void initData(String itemId);
    }

    interface View{
        void initComment(OneComment oneComment);
    }

}
