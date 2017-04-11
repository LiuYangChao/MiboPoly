package com.cssrc.mibopoly.presenter;

import com.cssrc.mibopoly.model.entity.OpenEyeEntity;

import java.util.List;

/**
 * Author liuyangchao
 * Date on 2017/4/10.19:32
 */

public interface OpenEyeContract {

    interface Presenter{
        void getOpenEyeEntityList();
    }

    interface View{
        void showRecyclerView(List<OpenEyeEntity> openEyeEntityList);
    }

}
