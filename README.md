# Веб-сервис для клуба "EdTech Startup Club" РГПУ им. А. И. Герцена
Стек: 
* JDK 17+
* Maven 3+
* Spring Boot
* JWT
* Postgres

| Метод | URL        | Описание               |
|-------|------------|------------------------|
| POST  | /register  | регистрация пользователя |
| POST  | /login     | вход                    |
| GET   | /profile   | профиль пользователя    |
| GET   | /about     | о клубе                 |
| GET   | /news      | события клуба           |
| GET   | /ads       | поиск команды           |
| POST  | /addNews   | добавить объявление     |


   ## Как запустить проект

Должен быть установлен и запущен докер. 

1.
  * скачать файл docker-compose.yml
  * скачать и запустить скрипт run.sh,
  * браузере перейти на http://localhost:3000

3.
 * скачиваем файл docker-compose.yml
 * Запускаем терминал в папке с файлом и вводим следующие команды:
 * docker-compose rm -f
 * docker-compose pull
 * docker-compose up -d
 * в браузере открываем http://localhost:3000
