----------------------------------------
-- Author: Sergio Artero              --
-- Since: 03/02/2022                  --
----------------------------------------
-- Process table users                --
----------------------------------------
CREATE TABLE user_app
(
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
	name varchar(100) NOT NULL,
	email varchar(100) NOT NULL,
	password varchar(100) NOT NULL
);