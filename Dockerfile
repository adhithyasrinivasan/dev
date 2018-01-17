FROM openjdk:8-jdk-alpine
VOLUME /data/
ADD hello.jar app.jar
ENV JAVA_OPTS="-Xmx64m"
ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar
EXPOSE 8080
