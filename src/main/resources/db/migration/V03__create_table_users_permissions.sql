----------------------------------------
-- Author: Sergio Artero              --
-- Since: 03/02/2022                  --
----------------------------------------
-- Process table users_permission     --
----------------------------------------
CREATE TABLE users_permission
(
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
	id_user BIGINT FOREIGN KEY REFERENCES user_app(id),
	id_permission BIGINT FOREIGN KEY REFERENCES permission_app(id)
);