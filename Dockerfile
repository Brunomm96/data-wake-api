FROM gradle:7.3.1-jdk11 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon

FROM openjdk:11
LABEL mainteiner="sergio@ds2u.com.br"
ENV LANG C.UTF-8
RUN mkdir /app
RUN mkdir /app/certificado
WORKDIR /app
COPY --from=build /home/gradle/src/build/libs/datawakeapi-0.0.1-SNAPSHOT.jar /app/app.jar

CMD java -jar app.jar $APP_OPTIONS