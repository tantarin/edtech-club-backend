INSERT INTO users(id, email, password, username)
VALUES (1, 'test@mail.ru', '$2a$10$Tkb2wARs/N4RJ3nHPrOuSOImwKxP7eSM2xXf5q4k1scWfjqIyhFNa', 'test');

INSERT INTO ads (id, header, content, user_id)
VALUES
    (1, 'Ищем опытного программиста', 'Команда образовательного стартапа ищет опытного программиста для разработки инновационных образовательных решений. Требования: опыт работы с Python, знание фреймворка Django, желание развиваться в образовательной сфере.', 1),
    (2, 'Присоединяйтесь к нашей команде!', 'Стартап в области образования ищет талантливых и преданных профессионалов. Открыты вакансии: программист, дизайнер, куратор образовательных программ. Присоединяйтесь к нам и вместе создадим будущее образования!', 1),
    (3, 'Вакансия: разработчик мобильных приложений', 'Команда стартапа ищет опытного разработчика мобильных приложений для создания инновационных образовательных приложений. Требования: опыт работы с React Native, понимание принципов UI/UX.', 1),
    (4, 'У нас открыта вакансия: куратор образовательных программ', 'Ищем куратора с опытом в образовательной сфере для разработки и внедрения образовательных программ. Если вы готовы внести свой вклад в образование будущего, присоединяйтесь!', 1),
    (5, 'Требуется эксперт по искусственному интеллекту', 'Наш стартап ищет эксперта по искусственному интеллекту для создания образовательных решений с использованием новейших технологий. Опыт в области машинного обучения приветствуется.', 1);


INSERT INTO news (id, header, content, date)
VALUES
    (1, 'Клуб образовательных стартапов открыл свои двери!', 'С радостью объявляем о запуске нашего клуба! Мы приглашаем всех энтузиастов образования, стартаперов и профессионалов в области образования присоединиться к нашему сообществу.', '2024-02-27'),
    (2, 'Встреча с экспертом: будущее образования', 'Приглашаем вас на встречу с ведущим экспертом в области образования. Обсудим текущие тренды, вызовы и возможности для стартапов в образовательной сфере. Не упустите шанс получить ценные знания!', '2024-03-05'),
    (3, 'Развитие наших проектов', 'Мы рады поделиться последними новостями о развитии наших образовательных стартапов. Новые программы, партнерства и достижения – у нас много интересного!', '2024-03-12'),
    (4, 'Стартап дня: Образование 4.0', 'Сегодня выделяем стартап, который представляет инновационный подход к образованию. Узнайте, какие технологии используются в новом образовательном проекте и какие преимущества он приносит.', '2024-03-20'),
    (5, 'Партнерство с ведущими университетами', 'Мы гордимся объявить о партнерстве с ведущими университетами. Совместные проекты и программы помогут студентам и профессионалам расширить свои знания и навыки.', '2024-03-28');
