# Spring Boot CRUD 프로젝트 (JPA + MyBatis)

이 프로젝트는 **Spring Boot**를 기반으로 **CRUD 기능**을 구현하고, **JPA**와 **MyBatis**를 동시에 사용하는 예제를 포함합니다.  
**Docker**를 이용한 배포 및 **로컬 실행**, **API 테스트(Postman)**까지 전 과정을 다룹니다.

---

## 📌 주요 기술 스택
- Java 17
- Spring Boot 3
- JPA + MyBatis
- MySQL
- Docker, Docker Compose
- Gradle
- Postman (API 테스트)

---

## 🚀 실행 방법

### ✅ 로컬 실행

```bash
# MySQL 실행 (Mac 기준)
brew services start mysql

# IntelliJ에서 실행 (application-local.yaml 사용)
./gradlew bootRun
