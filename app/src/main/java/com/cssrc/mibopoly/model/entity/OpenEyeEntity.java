package com.cssrc.mibopoly.model.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Author liuyangchao
 * Date on 2017/4/10.9:21
 */

public class OpenEyeEntity {

    String type;
    dataBean data;
    String tag;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public dataBean getData() {
        return data;
    }

    public void setData(dataBean data) {
        this.data = data;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public static class dataBean{
        private String dataType;
        private int id;
        private String title;
        private String description;
        private String category;
        private String image;
        private String actionUrl;
        private String adTrack;
        private String shade;
        private String playUrl;
        private int duration;
        long releaseTime;
        private String type;
        private String titlePgc;
        private String descriptionPgc;

        private authorBean author;
        private providerBean provider;
        private coverBean cover;
        private webUrlBean webUrl;
        consumptionBean consumption;

        List<playInfoBean> playInfo;
        List<tagsBean> tags;

        public authorBean getAuthor() {
            return author;
        }

        public void setAuthor(authorBean author) {
            this.author = author;
        }

        public String getDataType() {
            return dataType;
        }

        public void setDataType(String dataType) {
            this.dataType = dataType;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public providerBean getProvider() {
            return provider;
        }

        public void setProvider(providerBean provider) {
            this.provider = provider;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public coverBean getCover() {
            return cover;
        }

        public void setCover(coverBean cover) {
            this.cover = cover;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getActionUrl() {
            return actionUrl;
        }

        public void setActionUrl(String actionUrl) {
            this.actionUrl = actionUrl;
        }

        public String getAdTrack() {
            return adTrack;
        }

        public void setAdTrack(String adTrack) {
            this.adTrack = adTrack;
        }

        public String getShade() {
            return shade;
        }

        public void setShade(String shade) {
            this.shade = shade;
        }

        public String getPlayUrl() {
            return playUrl;
        }

        public void setPlayUrl(String playUrl) {
            this.playUrl = playUrl;
        }

        public int getDuration() {
            return duration;
        }

        public void setDuration(int duration) {
            this.duration = duration;
        }

        public webUrlBean getWebUrl() {
            return webUrl;
        }

        public void setWebUrl(webUrlBean webUrl) {
            this.webUrl = webUrl;
        }

        public long getReleaseTime() {
            return releaseTime;
        }

        public void setReleaseTime(long releaseTime) {
            this.releaseTime = releaseTime;
        }

        public List<playInfoBean> getPlayInfo() {
            return playInfo;
        }

        public void setPlayInfo(List<playInfoBean> playInfo) {
            this.playInfo = playInfo;
        }

        public consumptionBean getConsumption() {
            return consumption;
        }

        public void setConsumption(consumptionBean consumption) {
            this.consumption = consumption;
        }

        public List<tagsBean> getTags() {
            return tags;
        }

        public void setTags(List<tagsBean> tags) {
            this.tags = tags;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getTitlePgc() {
            return titlePgc;
        }

        public void setTitlePgc(String titlePgc) {
            this.titlePgc = titlePgc;
        }

        public String getDescriptionPgc() {
            return descriptionPgc;
        }

        public void setDescriptionPgc(String descriptionPgc) {
            this.descriptionPgc = descriptionPgc;
        }

        public long getDate() {
            return date;
        }

        public void setDate(long date) {
            this.date = date;
        }

        public String getDescriptionEditor() {
            return descriptionEditor;
        }

        public void setDescriptionEditor(String descriptionEditor) {
            this.descriptionEditor = descriptionEditor;
        }

        public boolean isCollected() {
            return collected;
        }

        public void setCollected(boolean collected) {
            this.collected = collected;
        }

        public boolean isPlayed() {
            return played;
        }

        public void setPlayed(boolean played) {
            this.played = played;
        }

        private long date;
        private String descriptionEditor;
        private boolean collected;
        private boolean played;

        public static class authorBean{
            int id;
            String icon;
            String name;
            String description;
            String link;
            long latestReleaseTime;
            int videoNum;
            String adTrack;
            followBean follow;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
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

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
            }

            public long getLatestReleaseTime() {
                return latestReleaseTime;
            }

            public void setLatestReleaseTime(long latestReleaseTime) {
                this.latestReleaseTime = latestReleaseTime;
            }

            public int getVideoNum() {
                return videoNum;
            }

            public void setVideoNum(int videoNum) {
                this.videoNum = videoNum;
            }

            public String getAdTrack() {
                return adTrack;
            }

            public void setAdTrack(String adTrack) {
                this.adTrack = adTrack;
            }

            public followBean getFollow() {
                return follow;
            }

            public void setFollow(followBean follow) {
                this.follow = follow;
            }

            public static class followBean{
                String itemType;
                int itemId;
                boolean followed;

                public String getItemType() {
                    return itemType;
                }

                public void setItemType(String itemType) {
                    this.itemType = itemType;
                }

                public int getItemId() {
                    return itemId;
                }

                public void setItemId(int itemId) {
                    this.itemId = itemId;
                }

                public boolean isFollowed() {
                    return followed;
                }

                public void setFollowed(boolean followed) {
                    this.followed = followed;
                }
            }
        }

        public static class providerBean{
            private String name;
            private String alias;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getAlias() {
                return alias;
            }

            public void setAlias(String alias) {
                this.alias = alias;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            private String icon;
        }
        public static class coverBean{
            private String feed;
            private String detail;
            private String blurred;
            private String sharing;

            public String getFeed() {
                return feed;
            }

            public void setFeed(String feed) {
                this.feed = feed;
            }

            public String getDetail() {
                return detail;
            }

            public void setDetail(String detail) {
                this.detail = detail;
            }

            public String getBlurred() {
                return blurred;
            }

            public void setBlurred(String blurred) {
                this.blurred = blurred;
            }

            public String getSharing() {
                return sharing;
            }

            public void setSharing(String sharing) {
                this.sharing = sharing;
            }
        }
        public static class webUrlBean{
            private String raw;
            private String forWeibo;

            public String getRaw() {
                return raw;
            }

            public void setRaw(String raw) {
                this.raw = raw;
            }

            public String getForWeibo() {
                return forWeibo;
            }

            public void setForWeibo(String forWeibo) {
                this.forWeibo = forWeibo;
            }
        }
        public static class  consumptionBean{
            private int collectionCount;
            private int shareCount;
            private int replyCount;

            public int getCollectionCount() {
                return collectionCount;
            }

            public void setCollectionCount(int collectionCount) {
                this.collectionCount = collectionCount;
            }

            public int getShareCount() {
                return shareCount;
            }

            public void setShareCount(int shareCount) {
                this.shareCount = shareCount;
            }

            public int getReplyCount() {
                return replyCount;
            }

            public void setReplyCount(int replyCount) {
                this.replyCount = replyCount;
            }
        }
        private static class tagsBean{
            private int id;
            private String name;
            private String actionUrl;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getActionUrl() {
                return actionUrl;
            }

            public void setActionUrl(String actionUrl) {
                this.actionUrl = actionUrl;
            }

            public String getAdTrack() {
                return adTrack;
            }

            public void setAdTrack(String adTrack) {
                this.adTrack = adTrack;
            }

            private String adTrack;
        }
        public static class playInfoBean{
            private int height;
            private int width;
            private List<urlListBean> urlList;
            private String name;

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }

            public List<urlListBean> getUrlList() {
                return urlList;
            }

            public void setUrlList(List<urlListBean> urlList) {
                this.urlList = urlList;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
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

            private String type;
            private String url;

            private static class urlListBean{
                private String name;
                private String url;
            }
        }
    }

}
