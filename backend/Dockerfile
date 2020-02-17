FROM openjdk:8-alpine as jdk8alpine
LABEL maintainer="alexander.an.ivanov@gmail.com"

RUN echo $APP_VERSION
RUN echo $APP_HOST
RUN echo $APP_DB
RUN echo $APP_USER
RUN echo $APP_PASSWORD
#RUN env

ENV TARGET_DIR /tmp/${APP_NAME}

RUN mkdir -p ${TARGET_DIR}
COPY ./ ${TARGET_DIR}
WORKDIR ${TARGET_DIR}

RUN ls -l
RUN ./gradlew build
RUN ls -l
RUN java -jar "${APP_NAME}-${APP_VERSION}".jar

