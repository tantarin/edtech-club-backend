#!/bin/bash

docker-compose rm -f

# Загружаем последние версии образов
docker-compose pull

# Запускаем контейнеры в фоновом режиме
docker-compose up -d