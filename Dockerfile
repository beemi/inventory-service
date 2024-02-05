# Phase 1: Build Stage
FROM amazoncorretto:17-alpine3.18

COPY target/inventory-service-0.0.1-SNAPSHOT.jar app.jar

ENV JVM_XMX=1G
ENV LOGGING_CONFIG_PATH=classpath:logback-spring.xml

EXPOSE 8090

ENTRYPOINT exec java \
        -Xmx${JVM_XMX} \
        -Xms${JVM_XMX} \
        -Dlogging.config=${LOGGING_CONFIG_PATH} \
        -jar app.jar
