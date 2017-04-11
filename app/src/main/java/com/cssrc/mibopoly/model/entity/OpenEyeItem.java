package com.cssrc.mibopoly.model.entity;

import java.util.List;

/**
 * Author liuyangchao
 * Date on 2017/4/10.12:30
 */

public class OpenEyeItem {

    List<OpenEyeEntity> itemList;
    int count;
    int total;
    String nextPageUrl;
    long date;
    long nextPublishTime;
    String dialog;

    public List<OpenEyeEntity> getItemList() {
        return itemList;
    }

    public void setItemList(List<OpenEyeEntity> itemList) {
        this.itemList = itemList;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getNextPageUrl() {
        return nextPageUrl;
    }

    public void setNextPageUrl(String nextPageUrl) {
        this.nextPageUrl = nextPageUrl;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public long getNextPublishTime() {
        return nextPublishTime;
    }

    public void setNextPublishTime(long nextPublishTime) {
        this.nextPublishTime = nextPublishTime;
    }

    public String getDialog() {
        return dialog;
    }

    public void setDialog(String dialog) {
        this.dialog = dialog;
    }
}
