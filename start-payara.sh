#!/bin/bash

mvn clean package -Ppayara

java -jar ./target/payara-micro.jar --deploy ./target/micro-javaee.war