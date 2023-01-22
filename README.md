# Manhwa Nexus

The goal of Manhwa Nexus is to provide users a central portal for all things related to Manhwa.

<img src="doc/img/web-client-index.png">
<img src="doc/img/manhwa-nexus-browse.png">

## Development Environment

### Requirements

-   Java 17
-   Node 16+
-   NPM 8+

### Build server jar

To build server jar run the following command at project root:

```console
$ ./gradlew build
```

The server jar will be located in the <PROJECT_ROOT>/build/distributions folder

### Run server

-   Build server jar
-   Run:

```console
$ java --add-opens java.base/java.time=ALL-UNNAMED -jar ./build/distributions/manhwa-nexus-server-<VERSION>-SNAPSHOT.jar

or 

$ bash ./build/distributions/run.sh
```

## Analysis

The following is mostly just exploratory analysis to get an understanding over the domain and what features Manhwa Nexus
should have.

### Use cases

<img src="doc/diagrams/use-cases.png">

### Domain entities

<img src="doc/diagrams/domain-entities.png">

### News updates concept

<img src="doc/diagrams/news-updates-concept.png">
