# fabric8-testcontainers-spring-boot-artemis
An example Spring Boot application using Test Containers and an external Artemis JMS queue.

**NOTE:** This requires Docker to be installed and running.

## Artemis

Create an Artemis MQ

```shell
docker container run \
--name artemis-alpine-2.36.0 \
-d \
--restart unless-stopped \
-p 8161:8161 \
-p 9404:9404 \
-p 61616:61616 \
-p 5445:5445 \
-p 5672:5672 \
-p 1883:1883 \
-p 61613:61613 \
orangebees/apache-artemis-alpine:2.36.0
```


## Build and Test

This should build and test the application.

```shell
mvn clean install
```