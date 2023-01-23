package io.github.michaelbui99.manhwanexus.exporter.common;


import java.time.LocalDateTime;

public class ReleaseUpdate {
    private String manhwaTitle;
    private int chapter;
    private String chapterTitle;
    private String timestamp;
    private String source;

    public ReleaseUpdate(String manhwaTitle, int chapter, String chapterTitle, String timestamp, String source) {
        this.manhwaTitle = manhwaTitle;
        this.chapter = chapter;
        this.chapterTitle = chapterTitle;
        this.timestamp = timestamp;
        this.source = source;
    }

    public String getManhwaTitle() {
        return manhwaTitle;
    }

    public int getChapter() {
        return chapter;
    }

    public String getChapterTitle() {
        return chapterTitle;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getSource() {
        return source;
    }

    public void setManhwaTitle(String manhwaTitle) {
        this.manhwaTitle = manhwaTitle;
    }

    public void setChapter(int chapter) {
        this.chapter = chapter;
    }

    public void setChapterTitle(String chapterTitle) {
        this.chapterTitle = chapterTitle;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
