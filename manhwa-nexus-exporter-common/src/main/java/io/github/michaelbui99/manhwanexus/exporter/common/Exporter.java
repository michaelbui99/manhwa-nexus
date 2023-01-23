package io.github.michaelbui99.manhwanexus.exporter.common;

import java.util.List;

public class Exporter {
    private ExportStrategy exportStrategy;

    public Exporter(ExportStrategy exportStrategy) {
        this.exportStrategy = exportStrategy;
    }

    public List<ReleaseUpdate> getReleaseUpdates(){
        return this.exportStrategy.exportReleases();
    }

    public List<NewsUpdate> getNewsUpdates(){
        return this.exportStrategy.exportNews();
    }

    public void setExportStrategy(ExportStrategy strategy){
        if (strategy == null){
            throw new IllegalArgumentException("Export strategy cannot be null");
        }
        this.exportStrategy = strategy;
    }
}
