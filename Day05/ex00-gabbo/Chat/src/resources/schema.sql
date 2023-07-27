CREATE TABLE User {
	UserID			int,
	Login			varchar(20),
	Password		varchar(20),
	RoomsCreated	nvarchar(max),
	RoomsUsed		nvarchar(max)
};

CREATE TABLE Chatroom {
	RoomID		int,
	Name		varchar(50),
	Owner		varchar(20),
	Messages	nvarchar(max)
};

CREATE TABLE Message {
	MessageID		int,
	Author			varchar(20),
	Room			varchar(50),
	Content			text,
	Date			datetime
};