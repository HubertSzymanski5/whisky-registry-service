#!/bin/bash

docker container rm whisky-mongo-db
docker run -d -p 27017:27017 --name whisky-mongo-db mongo:latest
