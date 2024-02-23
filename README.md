# Веб-сервис для клуба "EdTech Startup Club" РГПУ им. А. И. Герцена
Стек: 
* JDK 17+
* Maven 3+
* Spring Boot
* JWT
* Postgres

1. POST /register
регистрация пользователя
2. POST /login вход

тестовые данные: логин test, пароль 123456

3. http://localhost:3000/profile профиль пользователя
4. http://localhost:3000/about о клубе
5. http://localhost:3000/home события клуба
6. http://localhost:3000/ads поиск команды
7. http://localhost:3000/addNews добавить объявление

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
