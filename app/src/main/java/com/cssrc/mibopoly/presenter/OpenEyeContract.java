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

        /**
         * @param url
         * @param currentOpenEyeEntityList
         * @param scrollPosition            "top/bottom"
         */
        void loadScrollerData(String url, List<OpenEyeEntity> currentOpenEyeEntityList, String scrollPosition);
    }

    interface View{
        /**
         * @param openEyeEntityList     返回的数据集合
         * @param url                           下一页的数据链接
         */
        void showRecyclerView(List<OpenEyeEntity> openEyeEntityList, String url);
    }

}
