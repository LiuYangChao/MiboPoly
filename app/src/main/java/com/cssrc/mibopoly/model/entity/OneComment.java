package com.cssrc.mibopoly.model.entity;

import java.util.List;

/**
 * Author liuyangchao
 * Date on 2017/4/17.15:40
 */

public class OneComment {
    int res;
    dataBean data;

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }

    public dataBean getData() {
        return data;
    }

    public void setData(dataBean data) {
        this.data = data;
    }

    public static class dataBean {
        int count;
        List<dataBean2> data;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public List<dataBean2> getData() {
            return data;
        }

        public void setData(List<dataBean2> data) {
            this.data = data;
        }

        public static class dataBean2 {
            String id;
            String quote;
            String content;
            int praisenum;
            String updated_at;
            userBean user;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getQuote() {
                return quote;
            }

            public void setQuote(String quote) {
                this.quote = quote;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public int getPraisenum() {
                return praisenum;
            }

            public void setPraisenum(int praisenum) {
                this.praisenum = praisenum;
            }

            public String getUpdated_at() {
                return updated_at;
            }

            public void setUpdated_at(String updated_at) {
                this.updated_at = updated_at;
            }

            public userBean getUser() {
                return user;
            }

            public void setUser(userBean user) {
                this.user = user;
            }

            public static class userBean {
                String user_id;
                String user_name;
                String web_url;

                public String getUser_id() {
                    return user_id;
                }

                public void setUser_id(String user_id) {
                    this.user_id = user_id;
                }

                public String getUser_name() {
                    return user_name;
                }

                public void setUser_name(String user_name) {
                    this.user_name = user_name;
                }

                public String getWeb_url() {
                    return web_url;
                }

                public void setWeb_url(String web_url) {
                    this.web_url = web_url;
                }
            }

        }

    }

}
