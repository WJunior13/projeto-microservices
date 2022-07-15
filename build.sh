#!/bin/bash

cd ./financas-app/api-balance-service/&& mvn clean install package -DskipTests

cd ..


docker build -f ./api-balance-service/Dockerfile -t wjcarrer/api-balance-service:1.0 .

docker push wjcarrer/api-balance-service:1.0