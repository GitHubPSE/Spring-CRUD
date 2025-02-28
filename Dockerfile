FROM openjdk:17
ARG JAR_FILE=build/libs/crud-demo-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar

# ✅ Docker 실행 시 '-Dspring.profiles.active=docker' 사용
ENTRYPOINT ["java","-Dspring.profiles.active=docker","-jar","/app.jar"]