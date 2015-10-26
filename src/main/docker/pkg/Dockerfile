FROM debian:8

COPY maven/* /maven/
WORKDIR /maven

ENV DEBIAN_FRONTEND noninteractive

RUN set -x \
 && apt-get update \
 && apt-get install -y --no-install-recommends openjdk-7-jre-headless \
 && dpkg -i *.deb \
 && apt-get clean \
 && rm -rf /var/lib/apt/lists/* /tmp/* /var/tmp/*

EXPOSE 8080

CMD ["/usr/bin/java", "-jar", "/usr/share/maven-jdeb-docker-sample/maven-jdeb-docker-sample.jar", "server", "/etc/maven-jdeb-docker-sample.yaml"]

