FROM openjdk:8-jdk-alpine as build-stage
ADD . /ReiwaFakeNews
WORKDIR /ReiwaFakeNews
RUN chmod +x ./gradlew && ./gradlew shadowJar

FROM openjdk:8-jdk-alpine as exec-stage
COPY --from=build-stage /ReiwaFakeNews/build/libs/ReiwaFakeNews-0.0.1-all.jar .
ENTRYPOINT ["java", "-jar", "ReiwaFakeNews-0.0.1-all.jar"]