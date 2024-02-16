#!/bin/bash

docker image prune -f

docker pull tarinskaya/edtech-app-backend:latest

docker run -d -p 8444:8444 --memory=4g --network host -v /etc/letsencrypt/:/etc/letsencrypt/ -v /root/files/:/root/files/ -e FILES_PATH -e POSTGRES_USERNAME -e POSTGRES_PASSWORD -e MAIL_PASS --restart=always tarinskaya/edtech-app-backend:latest
