#!/bin/bash

mvn clean package -Pswarm

java -jar ./target/micro-javaee-swarm.jar
