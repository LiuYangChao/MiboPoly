package com.cssrc.mibopoly.model.api;

import com.cssrc.mibopoly.model.entity.OneEntity;
import com.cssrc.mibopoly.model.entity.OpenEyeEntity;
import com.cssrc.mibopoly.model.entity.OpenEyeItem;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Author liuyangchao
 * Date on 2017/4/10.10:55
 */

public interface ApiService {

    /**
     * http://baobab.kaiyanapp.com/api/v4/tabs/selected?udid=11111
     * &vc=168&vn=3.3.1&deviceModel=Huawei6&first_channel=eyepetizer_baidu_market&last_channel=eyepetizer_baidu_market&system_version_code=20
     * @return
     */
    @GET("api/v4/tabs/selected")
    Observable<OpenEyeItem> getOpenEye();

    /**
     * http://v3.wufazhuce.com:8000/
     * http://v3.wufazhuce.com:8000/api/channel/reading/more/0
     * @param url
     * @return
     */
    @GET
    Observable<OneEntity> getOneSeat(@Url String url);

}
