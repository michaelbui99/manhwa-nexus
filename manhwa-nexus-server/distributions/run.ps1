$jar = Get-ChildItem -Path . -Filter manhwa-nexus-server-*.jar -r
java --add-opens java.base/java.time = ALL-UNNAMED -jar $jar
