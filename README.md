## AndroidSauceLabs
This repository contains Challenge for automation test mobile for android

## Prerequisites

-Java 11 or higher
-Maven.3.6 +
-Appium
-IntelliJ or Eclipse

## Project Structure


```
AndroidSauceLabs
|--- src/
|   |---test/
|       |---java/
|       |   |---Hepers                  # Standar clases for some help an utility clases
|       |   |---Hooks                   # Initial configuration for automation
|       |   |---Modules                 # Page Object Model clases
|       |   |---Runner                  # Runner classes for cucumber Junit execuiton
|       |   |___StepDefinitios          # Steps from fetarues files
|       |---resources/
|           |---Config                  # Configuration files
|           |---Features                # Feature files on cucumber
|           |---cucumber.properties     # Extent report file confg
|           |---extent.properties       # Extent report file confg
|           |___spark-config.xml        # Extent report file confg
|___pom.xml                             # Maven dependencies
```

## Setup Instructions

### 1.- Clone repository
```bash
git clone <repository-url>
cd AndroidSauceLabs
```

### 2.- Install dependencies
```bash
mvn clean install
```


## Running Tests

### Run All Tests
```bash
 mvn test -Dtest=RunnerTest test
```

### Run specific Tests
```bash
 mvn test -Dtest=RunnerOneTest test
```


---
**Last Updated**: April 2026
**Framework Version**:1.0.0
