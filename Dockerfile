FROM frolvlad/alpine-java:jre8-slim
MAINTAINER Leonardo Goes (leo.ggoes@hotmail.com)

EXPOSE 8095
ENTRYPOINT ["/usr/bin/java", "-jar", "/usr/share/startuplanches/startuplanches.jar"]

# Add Maven dependencies (not shaded into the artifact; Docker-cached)
#ADD target/lib           /usr/share/startuplanches/lib
# Add the service itself
ARG JAR_FILE
ADD target/${JAR_FILE} /usr/share/startuplanches/startuplanches.jar