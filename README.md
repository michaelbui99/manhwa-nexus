# Manhwa Nexus

The goal of Manhwa Nexus is to provide users a central portal for all things related to Manhwa.

## Development Environment

### Requirements

- Java 17
- Node 16+
- NPM 8+

### Build server jar

To build server jar run the following command at project root:

```cli
$ ./gradlew distribute
```

The server jar will be located in the <PROJECT_ROOT>/build/distributions folder

### Run server

- Build server jar
- Navigate to <PROJECT_ROOT>/build/distributions
- Run:

```cli
$ java -jar manhwa-nexus-server-<VERSION>-SNAPSHOT-all.jar
```

## Analysis

The following is mostly just exploratory analysis to get an understanding over the domain and what features Manhwa Nexus
should have.

### Use cases

<img src="doc/diagrams/use-cases.png">

### Domain entities

<img src="doc/diagrams/domain-entities.png">