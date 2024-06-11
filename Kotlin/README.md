# Gilded Rose starting position in Kotlin

## Run the Text Fixture from Command-Line

```
./gradlew -q test
```

### Specify Number of Days

For e.g. 10 days:

```
./gradlew run --args 10
```

You should make sure the gradle commands shown above work when you execute them in a terminal before trying to use TextTest (see below).

## Run unit tests

There has been added unit tests for each item type.

./gradlew test

## Run the TextTest approval test that comes with this project

There are instructions in the [TextTest Readme](../texttests/README.md) for setting up TextTest. What's unusual for the Java version is there are two executables listed in [config.gr](../texttests/config.gr) for Java. One uses Gradle wrapped in a python script, the other relies on your CLASSPATH being set correctly in [environment.gr](../texttests/environment.gr).

cd ..  # cd into root project containing all language
./start_texttest.sh

## Code quality check
Gradle has been updated to include detekt code quality check. Run the following command to check code quality:

>./gradlew detekt 

## Note

all should work fine with java 11. check your java version

