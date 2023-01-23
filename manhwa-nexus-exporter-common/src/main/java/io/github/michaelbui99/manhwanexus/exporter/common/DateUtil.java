package io.github.michaelbui99.manhwanexus.exporter.common;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class DateUtil {
    public static long toUnixTime(LocalDateTime localDateTime) {
        return localDateTime.atZone(ZoneId.of("Europe/Copenhagen")).toInstant().toEpochMilli();
    }
}
