FROM openjdk:8-alpine

ARG JAR_FILE

RUN set -eux; \
    addgroup --gid 1000 java-app; \
    adduser -S -u 1000 -g java-app -h /home/java-app/ -s /bin/sh -D java-app; \
    mkdir -p /home/java-app/lib /home/java-app/etc; \
    chown -R java-app:java-app /home/java-app

COPY --chown=java-app:java-app target/${JAR_FILE} /home/java-app/lib/app.jar

CMD ["java", "-jar", "/home/java-app/lib/app.jar", "/home/java-app/etc/scrape-data.txt"]

EXPOSE 8080
