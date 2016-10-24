FROM java:latest
MAINTAINER Hongze Chi <chihz@easemob.com>
COPY build/libs/eldermob-all-1.0-SNAPSHOT.jar ./
WORKDIR ./
CMD ["java", "-jar", "eldermob-all-1.0-SNAPSHOT.jar"]
