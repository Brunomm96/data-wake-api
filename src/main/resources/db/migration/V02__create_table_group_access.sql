----------------------------------------
-- Author: Sergio Artero              --
-- Since: 03/02/2022                  --
----------------------------------------
-- Process table permission           --
----------------------------------------
CREATE TABLE [dbo].[group_access_app](
	[id] [bigint] IDENTITY(1,1) PRIMARY KEY,
	[description] [varchar](50) NULL
);