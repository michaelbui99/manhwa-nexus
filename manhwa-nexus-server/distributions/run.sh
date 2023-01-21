#!bin/bash
JAR=$(find . -type f -name manhwa-nexus-server-*.jar)
java --add-opens java.base/java.time=ALL-UNNAMED -jar $JAR
