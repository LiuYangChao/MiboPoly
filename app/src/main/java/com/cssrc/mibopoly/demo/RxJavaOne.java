package com.cssrc.mibopoly.demo;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Author liuyangchao
 * Date on 2017/4/20.16:04
 */

public class RxJavaOne {

    public void test1(){
//        Observable.create(new Observable.OnSubscribe<Integer>(){
//            @Override
//            public void call(Subscriber<? super Integer> subscriber) {
//                subscriber.onNext(1);
//                subscriber.onCompleted();
//            }
//        })
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .map(new Func1<Integer, Integer>() {
//                    @Override
//                    public Integer call(Integer integer) {
//                        return null;
//                    }
//                })
    }

}
