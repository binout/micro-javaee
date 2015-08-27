#!/bin/bash

mvn clean package tomee:exec -Ptomee

java -jar ./target/micro-javaee-exec.jar
