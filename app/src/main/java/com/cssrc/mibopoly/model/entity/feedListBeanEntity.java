package com.cssrc.mibopoly.model.entity;

import java.util.List;

/**
 * Author liuyangchao
 * Date on 2017/4/21.15:17
 */

public class FeedListBeanEntity {

    long post_id;
    String type;
    String url;
    String site_id;
    String author_id;
    String published_at;
    String excerpt;
    int favorites;
    int comments;
    String content;
    String title;
    int image_count;
    String[] tags;

    siteBean site;
    List<imagesBean> images;

    static class imagesBean{
        long img_id;
        long user_id;
        String title;
        int width;
        int height;
        String description;

        public long getImg_id() {
            return img_id;
        }

        public void setImg_id(long img_id) {
            this.img_id = img_id;
        }

        public long getUser_id() {
            return user_id;
        }

        public void setUser_id(long user_id) {
            this.user_id = user_id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }

    static class siteBean{
        String site_id;
        String type;
        String name;
        String description;
        int followers;
        String url;
        String icon;
        boolean verified;

        public String getSite_id() {
            return site_id;
        }

        public void setSite_id(String site_id) {
            this.site_id = site_id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getFollowers() {
            return followers;
        }

        public void setFollowers(int followers) {
            this.followers = followers;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public boolean isVerified() {
            return verified;
        }

        public void setVerified(boolean verified) {
            this.verified = verified;
        }
    }

    public long getPost_id() {
        return post_id;
    }

    public void setPost_id(long post_id) {
        this.post_id = post_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSite_id() {
        return site_id;
    }

    public void setSite_id(String site_id) {
        this.site_id = site_id;
    }

    public String getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(String author_id) {
        this.author_id = author_id;
    }

    public String getPublished_at() {
        return published_at;
    }

    public void setPublished_at(String published_at) {
        this.published_at = published_at;
    }

    public String getExcerpt() {
        return excerpt;
    }

    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
    }

    public int getFavorites() {
        return favorites;
    }

    public void setFavorites(int favorites) {
        this.favorites = favorites;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImage_count() {
        return image_count;
    }

    public void setImage_count(int image_count) {
        this.image_count = image_count;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public siteBean getSite() {
        return site;
    }

    public void setSite(siteBean site) {
        this.site = site;
    }

    public List<imagesBean> getImages() {
        return images;
    }

    public void setImages(List<imagesBean> images) {
        this.images = images;
    }
}
