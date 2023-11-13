----------------------------------------
-- Author: Sergio Artero              --
-- Since: 03/03/2022                  --
----------------------------------------
-- Process inserts default            --
----------------------------------------

-- INCLUINDO USUARIO PILOTO
INSERT INTO user_app (name, email, password) values ('Piloto', 'piloto@paranoa.com.br', '$2a$10$UGa5JnFXlpgFbfNGtb7xpuIy7g6QIjY5bPD8jD/HtdMRsYdlEgpAC');

-- INCLUINDO PERMISSOES DA PLATAFORMA DATAWAKE
INSERT INTO permission_app (description) values ('ROLE_POWERBI_MODULO_CONTROLADORIA');
INSERT INTO permission_app (description) values ('ROLE_FTP_TPO');

-- VINCULANDO PERMISSOES AO USUARIO PILOTO
INSERT INTO users_permission ( id_user, id_permission ) values (1, 1);
INSERT INTO users_permission ( id_user, id_permission ) values (1, 2);