package com.example.ecoknowledge;

public class MediaItem {
    private String title_news;
    private String img_news;
    private String content_news;
    private String link_news;

    public MediaItem(String title_news, String img_news, String content_news, String link_news) {
        this.title_news = title_news;
        this.img_news = img_news;
        this.content_news = content_news;
        this.link_news = link_news;
    }

    public String getTitle_news() {
        return title_news;
    }

    public String getImg_news() {
        return img_news;
    }

    public String getContent_news() {
        return content_news;
    }

    public String getLink_news() {
        return link_news;
    }


}
