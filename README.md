Build using maven:
==================

You need JDK 1.8 installed.

Run Test Cases
==================
 ./gradlew test

Build Executable Jar File
==================

./gradlew buildApp

Running
==================

An auto executable jar will be available in the ./build/libs/ directory.

Simply run  with the provided data file using:

./gradlew buildApp

java -jar build/libs/robot-app-1.0-RELEASE.jar -f ./test-data.txt
