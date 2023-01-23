package io.github.michaelbui99.manhwanexus.exporter.common;

public class NewsUpdate {
    private String title;
    private String url;
    private String author;
    private String timestamp;

    public NewsUpdate(String title, String url, String author, String timestamp) {
        this.title = title;
        this.url = url;
        this.author = author;
        this.timestamp = timestamp;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getAuthor() {
        return author;
    }

    public String getTimestamp() {
        return timestamp;
    }
}
