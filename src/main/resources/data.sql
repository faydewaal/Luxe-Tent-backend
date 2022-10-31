INSERT INTO users (username, password, email, enabled) VALUES ('user', '$2a$10$6Zmwiq/5uCBwDZDKUiU8LOn5Nf07wIcFKd/gVPITf7sjlx3uhofoe','user@test.nl', TRUE);
INSERT INTO users (username, password, email, enabled) VALUES ('admin', '$2a$10$6Zmwiq/5uCBwDZDKUiU8LOn5Nf07wIcFKd/gVPITf7sjlx3uhofoe', 'admin@test.nl', TRUE);
INSERT INTO users (username, password, email, enabled) VALUES ('Kris', '$2a$10$CwTycUXWue0Thq9StjUM0uPsVNaUCv7ZO9dvxzswRpDl0HkG9DcBe', 'kris@test.nl', TRUE);


INSERT INTO authorities (username, authority) VALUES ('user', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_ADMIN');