----------------------------------------
-- Author: Sergio Artero              --
-- Since: 03/02/2022                  --
----------------------------------------
-- Process table permission           --
----------------------------------------
CREATE TABLE [dbo].[permission_app](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[description] [varchar](50) NULL,
	[descriptionMenu] [varchar](50) NULL,
	[linkPage] [varchar](200) NULL,
PRIMARY KEY CLUSTERED
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, FILLFACTOR = 90) ON [PRIMARY]
) ON [PRIMARY]