## 🧪 Automated Testing: API & Web (Demo)

This repository holds the automated test suite for both the API and the Web user interface (UI). The project is built using Kotlin and is specifically designed for easy execution within Continuous Integration / Continuous Deployment (CI/CD) environments.

### 🚀 Technologies Used
- Language: Kotlin

- Dependency Manager: Gradle (Kotlin DSL: build.gradle)

- API Testing Framework: [Rest Assured]

- Web Testing Framework: [Selenium WebDriver]

- Testing Framework: [JUnit 5, Kotest]

- Design Pattern: [Page Object Model (Web)]

### ⚙️ Local Installation
To run the tests on your local machine, please ensure you have the following prerequisites installed:

- JDK (Java Development Kit) 17+

- Git

- A Kotlin/Gradle compatible IDE (E.g.: IntelliJ IDEA)

#### Steps
1) Clone the repository:
2) Resolve dependencies: Gradle will handle this automatically upon compiling or executing the tests.

### 📝 Running Tests
The project includes two primary scripts for separate execution in the CI/CD pipeline, but you can also run them directly using Gradle commands.

1. Running API Tests
   Execute all tests for the API layer:

```bash
./gradlew api
```

2. Running Web (UI) Tests
   Execute all tests for the user interface (Web):

```bash
./gradlew web
```

### 🤖 CI/CD Scripts
The CI/CD pipeline uses the following scripts, located in the root directory, to ensure an isolated and controlled execution of each suite:

```yaml 
stages:
  - build
  - test

build_app:
  stage: build
  script:
    - echo "Iniciando proceso de build..."
    - echo "Compilando aplicación..."
  # comment: build app
  tags:
    - build

test_api:
  stage: test
  script:
    - bash runApiTests.sh
  tags:
    - tests

test_web:
   stage: test
   script:
      - bash runWebTests.sh
   tags:
      - tests
```
