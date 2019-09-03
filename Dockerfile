FROM gradle:jdk10 as builder
COPY --chown=gradle:gradle . /customerAPIGradle
WORKDIR /customerAPIGradle
RUN gradle bootJar

FROM openjdk:8-jdk-alpine
EXPOSE 8080
VOLUME /tmp
ARG LIBS=customerAPIGradle/build/libs
COPY --from=builder ${LIBS}/ /customerAPIGradle/lib
ENTRYPOINT ["java","-jar","/customerAPIGradle/lib/customerAPIGradle-0.0.1-SNAPSHOT.jar"]


#build new docker image 'docker build -t dockerexample .'

#check status of docker image 'docker images'

#run docker image 'docker run -it dockerexample .'
