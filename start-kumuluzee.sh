#!/bin/bash

mvn clean package -Pkumuluzee

CONTEXT_PATH=/micro-javaee java -cp target/classes:target/dependency/* com.kumuluz.ee.EeApplication