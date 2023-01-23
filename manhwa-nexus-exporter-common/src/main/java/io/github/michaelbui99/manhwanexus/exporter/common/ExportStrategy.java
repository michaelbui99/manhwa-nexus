package io.github.michaelbui99.manhwanexus.exporter.common;

import java.util.List;

public interface ExportStrategy {
    List<ReleaseUpdate> exportReleases();
    List<NewsUpdate> exportNews();
}
