package io.github.michaelbui99.manhwanexus.exporter.common;

import java.util.List;

public class ExporterConfig {
    private String baseUrl;
    private ReleaseConfig release;
    private NewsConfig news;

    static class ReleaseConfig {
        private List<String> manhwas;

        public ReleaseConfig(List<String> manhwas) {
            this.manhwas = manhwas;
        }

        public ReleaseConfig() {
        }

        public List<String> getManhwas() {
            return manhwas;
        }

        public void setManhwas(List<String> manhwas) {
            this.manhwas = manhwas;
        }
    }

    static class NewsConfig {
    }

    public ExporterConfig() {
    }

    public ExporterConfig(String baseUrl, ReleaseConfig release, NewsConfig news) {
        this.baseUrl = baseUrl;
        this.release = release;
        this.news = news;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public ReleaseConfig getRelease() {
        return release;
    }

    public NewsConfig getNews() {
        return news;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public void setRelease(ReleaseConfig release) {
        this.release = release;
    }

    public void setNews(NewsConfig news) {
        this.news = news;
    }
}
