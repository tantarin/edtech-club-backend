CREATE TABLE tags (
                      id SERIAL PRIMARY KEY,
                      name VARCHAR(255) NOT NULL
);

CREATE TABLE ad_tags (
         ad_id INT,
         tag_id INT,
         FOREIGN KEY (ad_id) REFERENCES ads(id),
         FOREIGN KEY (tag_id) REFERENCES tags(id),
         PRIMARY KEY (ad_id, tag_id)
);

INSERT INTO tags (name) VALUES
                ('Frontend'),
                ('Backend'),
                ('Fullstack'),
                ('UXUI'),
                ('Marketing'),
                ('Analysis');

-- Добавляем теги к объявлениям
INSERT INTO ad_tags (ad_id, tag_id) VALUES
                (1, 2), -- Программист (Backend)
                (1, 6), -- Анализ (Analysis)
                (2, 4), -- Куратор образовательных программ
                (2, 5), -- Маркетинг (Marketing)
                (2, 3), -- Fullstack
                (3, 3), -- Fullstack
                (3, 1), -- Frontend
                (4, 5), -- Маркетинг (Marketing)
                (4, 6), -- Анализ (Analysis)
                (5, 6); -- Анализ (Analysis)

