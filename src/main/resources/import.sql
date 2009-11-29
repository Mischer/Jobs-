/**
INSERT INTO roles (id, authority) VALUES (20, 'ROLE_USER');
INSERT INTO roles (id, authority) VALUES (21, 'ROLE_ADMINISTRATOR');


INSERT INTO users (id, accountexpired, credentialsexpired, email, enabled, pass, username) VALUES (10, '3910-02-01 00:00:00', '3910-02-01 00:00:00', 'test@test.com', true, 'test', 'test');
INSERT INTO users (id, accountexpired, credentialsexpired, email, enabled, pass, username) VALUES (11, '3910-02-01 00:00:00', '3910-02-01 00:00:00', 'admin@admin.com', true, 'admin', 'admin');


INSERT INTO users_roles (users_id, roles_id) VALUES (10, 20);
INSERT INTO users_roles (users_id, roles_id) VALUES (11, 21);
**/