INSERT INTO usuario (created, isactive, modified, id, email, name, password) VALUES
('2023-11-25', 0, NULL, 1, 'email_1@gmail.com', 'name 1', 'password_1');
INSERT INTO usuario (created, isactive, modified, id, email, name, password) VALUES
('2023-11-25', 0, NULL, 2, 'email_2@gmail.com', 'name 2', 'password_2');
INSERT INTO usuario (created, isactive, modified, id, email, name, password) VALUES
('2023-11-25', 0, NULL, 3, 'email_3@gmail.com', 'name 3', 'password_3');
INSERT INTO usuario (created, isactive, modified, id, email, name, password) VALUES
('2023-11-25', 0, NULL, 4, 'email_4@gmail.com', 'name 4', 'password_4');
INSERT INTO usuario (created, isactive, modified, id, email, name, password) VALUES
('2023-11-25', 0, NULL, 5, 'email_5@gmail.com', 'name 5', 'password_5');
INSERT INTO usuario (created, isactive, modified, id, email, name, password) VALUES
('2023-11-25', 1, NULL, 6, 'email_6@gmail.com', 'name 6', 'password_6');
INSERT INTO usuario (created, isactive, modified, id, email, name, password) VALUES
('2023-11-25', 1, NULL, 7, 'email_7@gmail.com', 'name 7', 'password_7');
INSERT INTO usuario (created, isactive, modified, id, email, name, password) VALUES
('2023-11-25', 1, NULL, 8, 'email_8@gmail.com', 'name 8', 'password_8');
INSERT INTO usuario (created, isactive, modified, id, email, name, password) VALUES
('2023-11-25', 1, NULL, 9, 'email_9@gmail.com', 'name 9', 'password_9');
INSERT INTO usuario (created, isactive, modified, id, email, name, password) VALUES
('2023-11-25', 1, NULL, 10, 'email_10@gmail.com', 'name 10', 'password_10');
INSERT INTO phones (id, citycode, contrycode, number) VALUES
(1, '3', '57', '1234567');
INSERT INTO phones (id, citycode, contrycode, number) VALUES
(2, '3', '57', '1234567');
INSERT INTO phones (id, citycode, contrycode, number) VALUES
(3, '3', '57', '1234567');
INSERT INTO phones (id, citycode, contrycode, number) VALUES
(4, '3', '57', '1234567');
INSERT INTO phones (id, citycode, contrycode, number) VALUES
(5, '3', '57', '1234567');
INSERT INTO phones (id, citycode, contrycode, number) VALUES
(6, '3', '57', '1234567');
INSERT INTO phones (id, citycode, contrycode, number) VALUES
(7, '3', '57', '1234567');
INSERT INTO phones (id, citycode, contrycode, number) VALUES
(8, '3', '57', '1234567');
INSERT INTO phones (id, citycode, contrycode, number) VALUES
(9, '3', '57', '1234567');
INSERT INTO phones (id, citycode, contrycode, number) VALUES
(10, '3', '57', '1234567');
INSERT INTO usuarios_phones (phones_id, usuario_id) VALUES
(1, 1);
INSERT INTO usuarios_phones (phones_id, usuario_id) VALUES
(2, 2);
INSERT INTO usuarios_phones (phones_id, usuario_id) VALUES
(3, 3);
INSERT INTO usuarios_phones (phones_id, usuario_id) VALUES
(4, 4);
INSERT INTO usuarios_phones (phones_id, usuario_id) VALUES
(5, 5);
INSERT INTO usuarios_phones (phones_id, usuario_id) VALUES
(6, 6);
INSERT INTO usuarios_phones (phones_id, usuario_id) VALUES
(7, 7);
INSERT INTO usuarios_phones (phones_id, usuario_id) VALUES
(8, 8);
INSERT INTO usuarios_phones (phones_id, usuario_id) VALUES
(9, 9);
INSERT INTO usuarios_phones (phones_id, usuario_id) VALUES
(10, 10);
COMMIT;