package com.cssrc.mibopoly.model.entity;

import java.util.List;

/**
 * Author liuyangchao
 * Date on 2017/4/21.15:16
 */

public class TuChongEntity {

    boolean is_history;
    int counts;
    List<FeedListBeanEntity> feedList;
    String message;
    boolean more;
    String result;

    public boolean is_history() {
        return is_history;
    }

    public void setIs_history(boolean is_history) {
        this.is_history = is_history;
    }

    public int getCounts() {
        return counts;
    }

    public void setCounts(int counts) {
        this.counts = counts;
    }

    public List<FeedListBeanEntity> getFeedList() {
        return feedList;
    }

    public void setFeedList(List<FeedListBeanEntity> feedList) {
        this.feedList = feedList;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isMore() {
        return more;
    }

    public void setMore(boolean more) {
        this.more = more;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
