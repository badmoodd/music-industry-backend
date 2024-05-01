CREATE TYPE user_role AS ENUM ('ROLE_ADMIN', 'ROLE_USER');
CREATE CAST (VARCHAR AS user_role) WITH INOUT AS IMPLICIT;


CREATE TABLE users
(
    email     VARCHAR(255) PRIMARY KEY,
    username  VARCHAR(255),
    password  VARCHAR(255),
    user_role user_role
);

CREATE TABLE artists
(
    artist_id SERIAL PRIMARY KEY,
    name      VARCHAR(255),
    genre     VARCHAR(255),
    country   VARCHAR(255),
    formed    VARCHAR(255)
);

CREATE TABLE albums
(
    album_id     SERIAL PRIMARY KEY,
    title        VARCHAR(255),
    artist       VARCHAR(255),
    release_date VARCHAR(255),
    record_label VARCHAR(255)
);

CREATE TABLE songs
(
    song_id  SERIAL PRIMARY KEY,
    title    VARCHAR(255),
    album    VARCHAR(255),
    artist   VARCHAR(255),
    duration DECIMAL(18, 2),
    lyrics   TEXT
);

CREATE TABLE genres
(
    genre_id    SERIAL PRIMARY KEY,
    name        VARCHAR(255),
    description TEXT
);

CREATE TABLE concerts
(
    concert_id SERIAL PRIMARY KEY,
    title      VARCHAR(255),
    date       DATE,
    venue      VARCHAR(255),
    city       VARCHAR(255),
    country    VARCHAR(255)
);

CREATE TABLE album_sales
(
    sale_id    SERIAL PRIMARY KEY,
    album      VARCHAR(255),
    quantity   INT,
    sale_date  DATE,
    total_sale DECIMAL(10, 2),
    platform   VARCHAR(255)
);

CREATE TABLE song_sales
(
    sale_id    SERIAL PRIMARY KEY,
    song       VARCHAR(255),
    quantity   INT,
    sale_date  DATE,
    total_sale DECIMAL(10, 2),
    platform   VARCHAR(255)
);

CREATE TABLE streaming_platforms
(
    platform_id          SERIAL PRIMARY KEY,
    name                 VARCHAR(255),
    country              VARCHAR(255),
    monthly_subscription DECIMAL(10, 2)
);

CREATE TABLE playlists
(
    playlist_id     SERIAL PRIMARY KEY,
    name            VARCHAR(255),
    created_by_user VARCHAR(255)
);

CREATE TABLE film_soundtracks
(
    film_id   SERIAL PRIMARY KEY,
    name      VARCHAR(255),
    song_name VARCHAR(255),
    performer VARCHAR(255)
);

-- Таблица "Плейлисты"
INSERT INTO playlists (name, created_by_user)
VALUES ('Workout Mix', 'john_doe_123'),
       ('Chill Vibes', 'musiclover456'),
       ('Road Trip Jams', 'traveler87'),
       ('Study Playlist', 'studentlife22'),
       ('Friday Night Party', 'party_animal99'),
       ('Throwback Hits', 'nostalgiaqueen'),
       ('Rainy Day Tunes', 'rainy_day_dreamer'),
       ('Summer Vibes', 'beachlover23'),
       ('Late Night Drive', 'nightowl_88'),
       ('Feel Good Music', 'positivity_guru');

-- Таблица "Саундтреки к фильмам"
INSERT INTO film_soundtracks (name, song_name, performer)
VALUES ('Guardians of the Galaxy', 'Hooked on a Feeling', 'Blue Swede'),
       ('Pulp Fiction', 'Misirlou', 'Dick Dale and his Del-Tones'),
       ('The Great Gatsby', 'Young and Beautiful', 'Lana Del Rey'),
       ('Trainspotting', 'Born Slippy .NUXX', 'Underworld'),
       ('The Bodyguard', 'I Will Always Love You', 'Whitney Houston'),
       ('Dirty Dancing', '(I’ve Had) The Time of My Life', 'Bill Medley & Jennifer Warnes'),
       ('Footloose', 'Footloose', 'Kenny Loggins'),
       ('Top Gun', 'Take My Breath Away', 'Berlin'),
       ('Saturday Night Fever', 'Stayin’ Alive', 'Bee Gees'),
       ('The Lion King', 'Circle of Life', 'Elton John'),
       ('8 Mile', 'Lose Yourself', 'Eminem'),
       ('Twilight', 'Decode', 'Paramore'),
       ('The Hunger Games', 'Safe & Sound', 'Taylor Swift ft. The Civil Wars'),
       ('A Star is Born', 'Shallow', 'Lady Gaga and Bradley Cooper'),
       ('Frozen', 'Let It Go', 'Idina Menzel');


-- Таблица "Исполнители"
INSERT INTO artists (name, genre, country, formed)
VALUES ('The Beatles', 'Рок', 'Великобритания', '1960-01-01'),
       ('Michael Jackson', 'Поп', 'Соединенные Штаты', '1971-01-01'),
       ('Madonna', 'Поп', 'Соединенные Штаты', '1979-01-01'),
       ('Queen', 'Рок', 'Великобритания', '1970-01-01'),
       ('Elvis Presley', 'Рок-н-ролл', 'Соединенные Штаты', '1954-01-01'),
       ('Beyoncé', 'R&B', 'Соединенные Штаты', '1997-01-01'),
       ('Pink Floyd', 'Прогрессивный рок', 'Великобритания', '1965-01-01'),
       ('Led Zeppelin', 'Хард-рок', 'Великобритания', '1968-01-01'),
       ('Bob Marley', 'Регги', 'Ямайка', '1963-01-01'),
       ('Eminem', 'Хип-хоп', 'Соединенные Штаты', '1992-01-01'),
       ('The Rolling Stones', 'Рок', 'Великобритания', '1962-01-01'),
       ('Adele', 'Поп', 'Великобритания', '2006-01-01'),
       ('Taylor Swift', 'Кантри-поп', 'Соединенные Штаты', '2004-01-01'),
       ('Ed Sheeran', 'Поп', 'Великобритания', '2004-01-01'),
       ('AC/DC', 'Хард-рок', 'Австралия', '1973-01-01');

-- Таблица "Альбомы"
INSERT INTO albums (title, artist, release_date, record_label)
VALUES ('Abbey Road', 'The Beatles', '1969-09-26', 'Apple'),
       ('Thriller', 'Michael Jackson', '1982-11-30', 'Epic'),
       ('Like a Virgin', 'Madonna', '1984-11-12', 'Sire'),
       ('A Night at the Opera', 'Queen', '1975-11-21', 'EMI'),
       ('Elvis Presley', 'Elvis Presley', '1956-03-23', 'RCA Victor'),
       ('Dangerously in Love', 'Beyoncé', '2003-06-20', 'Columbia'),
       ('The Dark Side of the Moon', 'Pink Floyd', '1973-03-01', 'Harvest'),
       ('Led Zeppelin IV', 'Led Zeppelin', '1971-11-08', 'Atlantic'),
       ('Legend', 'Bob Marley & The Wailers', '1984-05-08', 'Island'),
       ('The Marshall Mathers LP', 'Eminem', '2000-05-23', 'Aftermath'),
       ('Sticky Fingers', 'The Rolling Stones', '1971-04-23', 'Rolling Stones'),
       ('21', 'Adele', '2011-01-24', 'XL'),
       ('Fearless', 'Taylor Swift', '2008-11-11', 'Big Machine'),
       ('÷', 'Ed Sheeran', '2017-03-03', 'Asylum'),
       ('Back in Black', 'AC/DC', '1980-07-25', 'Albert/Atlantic');

-- Таблица "Песни"
INSERT INTO songs (title, album, artist, duration, lyrics)
VALUES ('Come Together', 'Abbey Road', 'The Beatles', 4.20, 'Текст песни для Come Together...'),
       ('Billie Jean', 'Thriller', 'Michael Jackson', 4.54, 'Текст песни для Billie Jean...'),
       ('Material Girl', 'Like a Virgin', 'Madonna', 3.53, 'Текст песни для Material Girl...'),
       ('Bohemian Rhapsody', 'A Night at the Opera', 'Queen', 5.55, 'Текст песни для Bohemian Rhapsody...'),
       ('Hound Dog', 'Elvis Presley', 'Elvis Presley', 2.16, 'Текст песни для Hound Dog...'),
       ('Crazy in Love', 'Dangerously in Love', 'Beyoncé', 3.56, 'Текст песни для Crazy in Love...'),
       ('Money', 'The Dark Side of the Moon', 'Pink Floyd', 6.22, 'Текст песни для Money...'),
       ('Stairway to Heaven', 'Led Zeppelin IV', 'Led Zeppelin', 8.02, 'Текст песни для Stairway to Heaven...'),
       ('One Love', 'Legend', 'Bob Marley & The Wailers', 2.51, 'Текст песни для One Love...'),
       ('Stan', 'The Marshall Mathers LP', 'Eminem', 6.44, 'Текст песни для Stan...'),
       ('Brown Sugar', 'Sticky Fingers', 'The Rolling Stones', 3.50, 'Текст песни для Brown Sugar...'),
       ('Rolling in the Deep', '21', 'Adele', 3.48, 'Текст песни для Rolling in the Deep...'),
       ('Love Story', 'Fearless', 'Taylor Swift', 3.55, 'Текст песни для Love Story...'),
       ('Shape of You', '÷', 'Ed Sheeran', 3.53, 'Текст песни для Shape of You...'),
       ('Back in Black', 'Back in Black', 'AC/DC', 4.15, 'Текст песни для Back in Black...');

-- Таблица "Жанры"
INSERT INTO genres (name, description)
VALUES ('Рок',
        'Широкий жанр популярной музыки, возникший как "рок-н-ролл" в Соединенных Штатах в конце 1940-х и начале 1950-х годов.'),
       ('Поп',
        'Жанр популярной музыки, возникший в своем современном виде в середине 1950-х годов в Соединенных Штатах и Великобритании.'),
       ('R&B', 'Жанр популярной музыки, возникший в афроамериканских общинах в 1940-х годах.'),
       ('Прогрессивный рок',
        'Широкий жанр рок-музыки, развившийся в Великобритании и Соединенных Штатах на протяжении середины и конца 1960-х годов.'),
       ('Хард-рок',
        'Относительно определенный поджанр рок-музыки, характеризующийся интенсивным использованием агрессивного вокала, искаженных электрогитар, бас-гитары и ударных, иногда с клавишными.'),
       ('Регги', 'Музыкальный жанр, впервые разработанный на Ямайке в конце 1960-х годов.'),
       ('Хип-хоп',
        'Жанр популярной музыки, возникший в афроамериканских общинах в Бронксе, Нью-Йорк, в 1970-х годах.'),
       ('Кантри-поп',
        'Смешанный жанр кантри-музыки и поп-музыки, разработанный исполнителями кантри.'),
       ('Рок-н-ролл',
        'Жанр популярной музыки, который развился в конце 1940-х и начале 1950-х годов из музыкальных стилей, таких как госпел, джамп-блюз, джаз, буги-вуги и ритм-н-блюз, и кантри-музыка.'),
       ('Фолк',
        'Жанр традиционной музыки, возникший в середине 20-го века и ставший ассоциированным с различными социальными и политическими движениями.');

-- Таблица "Концерты"
INSERT INTO concerts (title, date, venue, city, country)
VALUES ('Live Aid', '1985-07-13', 'Стадион Уэмбли', 'Лондон', 'Великобритания'),
       ('The Bad World Tour', '1988-09-12', 'Токийский Дом', 'Токио', 'Япония'),
       ('The Sticky & Sweet Tour', '2008-08-23', 'Стадион Миллениум', 'Кардифф', 'Великобритания'),
       ('A Night at the Odeon', '1975-12-24', 'Одиум Хаммерсмит', 'Лондон', 'Великобритания'),
       ('Aloha from Hawaii Via Satellite', '1973-01-14', 'Международный центр Гонолулу', 'Гонолулу',
        'Соединенные Штаты'),
       ('Formation World Tour', '2016-04-27', 'Стадион Рэймонда Джеймса', 'Тампа', 'Соединенные Штаты'),
       ('The Wall Tour', '1980-02-07', 'Спортивная арена Лос-Анджелеса', 'Лос-Анджелес', 'Соединенные Штаты'),
       ('The Monsters of Rock Tour', '1981-08-22', 'Парк Донингтон', 'Кастл-Донингтон', 'Великобритания'),
       ('One Love Peace Concert', '1978-04-22', 'Национальный стадион', 'Кингстон', 'Ямайка'),
       ('The Eminem Show Tour', '2002-06-07', 'Парк Комерика', 'Детройт', 'Соединенные Штаты'),
       ('Voodoo Lounge Tour', '1994-08-01', 'Гигантский стадион', 'Ист-Резерфорд', 'Соединенные Штаты'),
       ('Adele Live', '2016-02-29', 'Палау Сан-Жорди', 'Барселона', 'Испания'),
       ('Speak Now World Tour', '2011-02-09', 'Мэдисон-сквер-гарден', 'Нью-Йорк', 'Соединенные Штаты'),
       ('÷ Tour', '2017-03-16', 'SSE Hydro', 'Глазго', 'Великобритания'),
       ('Black Ice World Tour', '2009-03-05', 'Монументальный стадион', 'Сантьяго', 'Чили');

-- Таблица "Продажи альбомов"
INSERT INTO album_sales (album, quantity, sale_date, total_sale, platform)
VALUES ('Thriller', 500000, '1982-12-01', 2500000.00, 'Физический'),
       ('Like a Virgin', 300000, '1985-01-01', 1500000.00, 'Физический'),
       ('Dangerously in Love', 2000000, '2004-07-01', 10000000.00, 'Физический'),
       ('Legend', 1500000, '1985-06-01', 7500000.00, 'Физический'),
       ('The Marshall Mathers LP', 1000000, '2000-06-01', 5000000.00, 'Физический'),
       ('21', 2500000, '2011-02-01', 12500000.00, 'Физический'),
       ('Back in Black', 700000, '1980-08-01', 3500000.00, 'Физический'),
       ('Abbey Road', 500000, '1969-10-01', 2500000.00, 'Физический'),
       ('Led Zeppelin IV', 300000, '1971-12-01', 1500000.00, 'Физический'),
       ('The Dark Side of the Moon', 1000000, '1973-04-01', 5000000.00, 'Физический'),
       ('Sticky Fingers', 400000, '1971-05-01', 2000000.00, 'Физический'),
       ('÷', 2000000, '2017-04-01', 10000000.00, 'Физический'),
       ('Fearless', 1500000, '2009-01-01', 7500000.00, 'Физический'),
       ('Thriller', 200000, '1982-12-01', 1000000.00, 'Цифровой'),
       ('Legend', 500000, '1985-06-01', 2500000.00, 'Цифровой');

-- Таблица "Продажи песен"
INSERT INTO song_sales (song, quantity, sale_date, total_sale, platform)
VALUES ('Billie Jean', 5000000, '1982-12-01', 5000000.00, 'Физический'),
       ('Material Girl', 3000000, '1985-01-01', 3000000.00, 'Физический'),
       ('Crazy in Love', 20000000, '2004-07-01', 20000000.00, 'Физический'),
       ('One Love', 15000000, '1985-06-01', 15000000.00, 'Физический'),
       ('Stan', 10000000, '2000-06-01', 10000000.00, 'Физический'),
       ('Rolling in the Deep', 25000000, '2011-02-01', 25000000.00, 'Физический'),
       ('Back in Black', 7000000, '1980-08-01', 7000000.00, 'Физический'),
       ('Come Together', 5000000, '1969-10-01', 5000000.00, 'Физический'),
       ('Stairway to Heaven', 3000000, '1971-12-01', 3000000.00, 'Физический'),
       ('Money', 10000000, '1973-04-01', 10000000.00, 'Физический'),
       ('Brown Sugar', 4000000, '1971-05-01', 4000000.00, 'Физический'),
       ('Shape of You', 20000000, '2017-04-01', 20000000.00, 'Физический'),
       ('Love Story', 15000000, '2009-01-01', 15000000.00, 'Физический'),
       ('Billie Jean', 2000000, '1982-12-01', 2000000.00, 'Цифровой'),
       ('One Love', 5000000, '1985-06-01', 5000000.00, 'Цифровой');

-- Таблица "Стриминговые платформы"
INSERT INTO streaming_platforms (name, country, monthly_subscription)
VALUES ('Spotify', 'Швеция', 9.99),
       ('Apple Music', 'Соединенные Штаты', 9.99),
       ('Amazon Music', 'Соединенные Штаты', 9.99),
       ('YouTube Music', 'Соединенные Штаты', 9.99),
       ('Deezer', 'Франция', 9.99),
       ('Tidal', 'Соединенные Штаты', 9.99),
       ('Pandora', 'Соединенные Штаты', 4.99),
       ('SoundCloud', 'Германия', 9.99),
       ('Google Play Music', 'Соединенные Штаты', 9.99),
       ('Napster', 'Соединенные Штаты', 9.99);


-- Добавление администратора в таблицу users
INSERT INTO users (email, username, password, user_role)
VALUES ('admin@gmail.com', 'Admin', '$2a$12$aeAsytC/mleJtA3.J8HqRuUIDZNykndDQSisT3q4b7LvQbmZlpnFi', 'ROLE_ADMIN'),
       ('user@gmail.com', 'Test User', '$2a$12$OkpOdefcZIr9kgo0aLXE0e3qWhv6lDuXA828y4Dw5UyCVYCOsoxVO', 'ROLE_USER');
-- first user (admin) 'admin@gmail.com', 'admin'
-- second user (user) 'user@gmail.com', 'user'