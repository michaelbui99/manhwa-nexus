SET SCHEMA 'manhwa_nexus';

INSERT INTO manhwa (title, synopsis, chapter_count, volume_count, season_count, start_date, end_date, is_adult,
                    source_material, country_of_origin_id, cover_url, status)
VALUES ('Solo Leveling',
        'In a world where awakened beings called “Hunters” must battle deadly monsters to protect humanity, Sung Jinwoo, nicknamed “the weakest hunter of all mankind,” finds himself in a constant struggle for survival',
        179, -1, 2, '2018-03-04', null, false, 'LIGHT_NOVEL', (SELECT id from country_code where code = 'KR'), 'https://upload.wikimedia.org/wikipedia/en/9/99/Solo_Leveling_Webtoon.png', 'FINISHED');
INSERT INTO manhwa_genre(manhwa_id, genre_id)
VALUES ((select id from manhwa where title = 'Solo Leveling'), (select id from genre where genre = 'Action'));


INSERT INTO manhwa (title, synopsis, chapter_count, volume_count, season_count, start_date, end_date, is_adult,
                    source_material, country_of_origin_id, cover_url, status)
VALUES ('BASTARD',
        'There is nowhere that Seon Jin can find solace. At school, he is ruthlessly bullied due to his unsettlingly quiet nature and weak appearance. However, this is not the source of Jins insurmountable terror: the thing that he fears more than anything else is his own father.',
        94, 5, -1, '2014-07-04', '2017-03-20', false, 'LIGHT_NOVEL',
        (SELECT id from country_code where code = 'KR'), 'https://meltingpotsandothercalamities.files.wordpress.com/2017/01/img_5539.png', 'FINISHED');
INSERT INTO manhwa_genre(manhwa_id, genre_id)
VALUES ((select id from manhwa where title = 'BASTARD'), (select id from genre where genre = 'Thriller'));
