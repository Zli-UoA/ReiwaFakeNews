FROM openjdk:8-jdk-alpine as build-stage
ADD . /ReiwaFakeNews
WORKDIR /ReiwaFakeNews
RUN chmod +x ./gradlew && ./gradlew clean shadowJar

FROM openjdk:8-jdk-alpine as exec-stage
COPY --from=build-stage /ReiwaFakeNews/application/build/libs/application-0.0.1-all.jar .
ENTRYPOINT ["java", "-jar", "application-0.0.1-all.jar"]