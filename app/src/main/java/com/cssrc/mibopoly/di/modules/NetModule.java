package com.cssrc.mibopoly.di.modules;

import com.cssrc.mibopoly.BuildConfig;
import com.cssrc.mibopoly.model.api.ApiService;
import com.cssrc.mibopoly.utils.EntityUtils;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Author liuyangchao
 * Date on 2017/4/10.9:54
 */
@Module
public class NetModule {

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(){
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(20,TimeUnit.SECONDS)
                .addInterceptor(loggingInterceptor)
                .build();
        return okHttpClient;
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(OkHttpClient okHttpClient){
        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("http://baobab.kaiyanapp.com/")
//                .addConverterFactory(StringConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(EntityUtils.gson))
//                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit;
    }

    @Provides
    @Singleton
    public ApiService provideApiService(Retrofit retrofit){
        return retrofit.create(ApiService.class);
    }
}
