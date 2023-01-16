FROM gradle:jdk17 AS build

WORKDIR /build
COPY . .
RUN ./gradlew build --no-daemon

FROM amazoncorretto:17 AS final

WORKDIR /app

COPY --from=build /build/build/distributions/*-SNAPSHOT.jar ./manhwa-nexus-server.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar"]
CMD ["manhwa-nexus-server.jar"]