package com.cssrc.mibopoly.presenter;

import com.cssrc.mibopoly.model.entity.OneEntity;
import com.cssrc.mibopoly.model.entity.OpenEyeEntity;

import java.util.List;

/**
 * Author liuyangchao
 * Date on 2017/4/12.19:41
 */

public interface OneSeatContract {

    interface Presenter{
        void getOneSeatEntityList();
    }

    interface View{
        void showRecyclerView(List<OneEntity.dataBean> oneEntityList);
    }

}