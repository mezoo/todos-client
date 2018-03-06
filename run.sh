#!/usr/bin/env bash

mvn clean package -DskipTests
java -jar target/todos-client-0.0.1-SNAPSHOT.jar
