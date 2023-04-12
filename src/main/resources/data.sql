INSERT INTO users (username, password, email, enabled)
VALUES ('user', '$2a$10$6Zmwiq/5uCBwDZDKUiU8LOn5Nf07wIcFKd/gVPITf7sjlx3uhofoe','user@test.nl', TRUE);
INSERT INTO users (username, password, email, enabled)
VALUES ('admin', '$2a$10$6Zmwiq/5uCBwDZDKUiU8LOn5Nf07wIcFKd/gVPITf7sjlx3uhofoe', 'admin@test.nl', TRUE);
INSERT INTO users (username, apikey, password, email, enabled)
VALUES ('Fay', 'se0GsSxYcItqXwHxDyVv', '$2a$10$CwTycUXWue0Thq9StjUM0uvKT5gTIfK8VkyI72na/fcS/bimwkNhu', 'fay@gmail.com', TRUE);

INSERT INTO images (file_name, content_type, url)
VALUES ('bos-tent.jpg', 'image/jpg', 'http://localhost:8080/download/bos-tent.jpg');
INSERT INTO images (file_name, content_type, url)
VALUES ('tent-joga.jpeg', 'image/jpeg', 'http://localhost:8080/download/tent-joga.jpeg');
INSERT INTO images (file_name, content_type, url)
VALUES ('vlaggetjes.jpg', 'image/jpg', 'http://localhost:8080/download/vlaggetjes.jpg');
INSERT INTO images (file_name, content_type, url)
VALUES ('tenten.jpg', 'image/jpg', 'http://localhost:8080/download/tenten.jpg');
INSERT INTO images (file_name, content_type, url)
VALUES ('car-tent.jpg', 'image/jpg', 'http://localhost:8080/download/car-tent.jpg');
INSERT INTO images (file_name, content_type, url)
VALUES ('safari-tent.jpg', 'image/jpg', 'http://localhost:8080/download/safari-tent.jpg');
INSERT INTO images (file_name, content_type, url)
VALUES ('chill-tent.jpg', 'image/jpg', 'http://localhost:8080/download/chill-tent.jpg');
INSERT INTO images (file_name, content_type, url)
VALUES ('beach-tent.jpg', 'image/jpg', 'http://localhost:8080/download/beach-tent.jpg');
INSERT INTO images (file_name, content_type, url)
VALUES ('fam-tent.jpg', 'image/jpg', 'http://localhost:8080/download/fam-tent.jpg');
INSERT INTO images (file_name, content_type, url)
VALUES ('groene-caravan.jpg', 'image/jpg', 'http://localhost:8080/download/groene-caravan.jpg');
INSERT INTO images (file_name, content_type, url)
VALUES ('3-tents-bos.jpg', 'image/jpg', 'http://localhost:8080/download/3-tents-bos.jpg');
INSERT INTO images (file_name, content_type, url)
VALUES ('tent-hut-fiets.jpg', 'image/jpg', 'http://localhost:8080/download/tent-hut-fiets.jpg');

INSERT INTO tent (id, title, description, price_per_night, max_number_of_persons, street, city, house_number, province, file_file_name)
VALUES (50, 'Luxe Tent', 'Welkom bij de luxe tent', 99, 2, 'Molenstraat', 'Breda', '4a', 'Noord-Brabant', 'bos-tent.jpg');
INSERT INTO tent (id, title, description, price_per_night, max_number_of_persons, street, city, house_number, province, file_file_name)
VALUES (51, 'Yoga Tent', 'Voor een ontspannen weekend', 130, 2, 'Kerkstraat', 'Woerden', '4', 'Utrecht', 'tent-joga.jpeg');
INSERT INTO tent (id, title, description, price_per_night, max_number_of_persons, street, city, house_number, province, file_file_name)
VALUES (52, 'Tipi Tent', 'Voor een romantisch weekend', 150, 2, 'Hoofdstraat', 'Maasstricht', '4', 'Limburg', 'vlaggetjes.jpg');
INSERT INTO tent (id, title, description, price_per_night, max_number_of_persons, street, city, house_number, province, file_file_name)
VALUES (53, 'Familie Tenten', 'Met de familie bijzonder kamperen', 400, 8, 'Middenstraat', 'Hoogersmilde', '8', 'Drenthe', 'tenten.jpg');
INSERT INTO tent (id, title, description, price_per_night, max_number_of_persons, street, city, house_number, province, file_file_name)
VALUES (54, 'Jeep Tent Texel', 'Met de Jeep op avontuur op een eiland ', 200, 2, 'Pontweg', 'Texel', '51', 'Noord-Holland', 'car-tent.jpg');
INSERT INTO tent (id, title, description, price_per_night, max_number_of_persons, street, city, house_number, province, file_file_name)
VALUES (55, 'Safari Tent in de Veluwe', 'Heerlijk wandelen in de Veluwe en ontspannen in de luxe Safaritent', 180, 4, 'Sportlaan', 'Otterlo', '55', 'Gelderland', 'safari-tent.jpg');
INSERT INTO tent (id, title, description, price_per_night, max_number_of_persons, street, city, house_number, province, file_file_name)
VALUES (56, 'Friese Tipi', 'Op vakantie in eigen land', 120, 2, 'Langdeel', 'Oudega', '314', 'Friesland', 'chill-tent.jpg');
INSERT INTO tent (id, title, description, price_per_night, max_number_of_persons, street, city, house_number, province, file_file_name)
VALUES (57, 'Luxe op het strand', 'Overnacht in luxe op het strand', 220, 2, 'Koolweg', 'Ouddorp', '88', 'Zuid-Holland', 'beach-tent.jpg');
INSERT INTO tent (id, title, description, price_per_night, max_number_of_persons, street, city, house_number, province, file_file_name)
VALUES (58, 'Glamping met de familie', 'Gezellig met de familie camperen in een luxe tent.', 560, 10, 'parklaan', 'Pieterburen', '26', 'Groningen', 'fam-tent.jpg');
INSERT INTO tent (id, title, description, price_per_night, max_number_of_persons, street, city, house_number, province, file_file_name)
VALUES (59, 'De groene caravan', 'Overnacht in een luxe kleurrijke caravan.', 130, 2, 'Beethovenlaan', 'Hasselt', '35', 'Overijssel', 'groene-caravan.jpg');
INSERT INTO tent (id, title, description, price_per_night, max_number_of_persons, street, city, house_number, province, file_file_name)
VALUES (60, 'Luxe tipi in het bos', 'Overnachten in eenLuxe tipi in het bos.', 145, 2, 'Amathistdijk', 'Aagtekerke', '8', 'Zeeland', '3-tents-bos.jpg');
INSERT INTO tent (id, title, description, price_per_night, max_number_of_persons, street, city, house_number, province, file_file_name)
VALUES (61, 'tipi huisje', 'Heerlijk huisje in Flevoland', 170, 4, 'Ijsselstraat', 'Emmeloord', '78', 'Flevoland', 'tent-hut-fiets.jpg');

INSERT INTO tent_options (id, option_name, price)
VALUES (1, 'Fietsverhuur', 20);
INSERT INTO tent_options (id, option_name, price)
VALUES (2, 'Jacuzzi', 30);
INSERT INTO tent_options (id, option_name, price)
VALUES (3, 'Kinderzitje', 5);
INSERT INTO tent_options (id, option_name, price)
VALUES (4, 'Electrische step', 25);
INSERT INTO tent_options (id, option_name, price)
VALUES (5, 'BBQ grill', 20);
INSERT INTO tent_options (id, option_name, price)
VALUES (6, 'Badminton rackets', 5);


INSERT INTO users_tent (user_username, tent_id) VALUES ('Fay', 50);
INSERT INTO users_tent (user_username, tent_id) VALUES ('Fay', 51);

INSERT INTO tent_tent_options (tent_id, tent_options_id) VALUES (50, 1);

INSERT INTO authorities (username, authority) VALUES ('Fay', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('user', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_ADMIN');

