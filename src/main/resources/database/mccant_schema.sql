DROP TABLE IF EXISTS UserLanguage;
DROP TABLE IF EXISTS UserStat;
DROP TABLE IF EXISTS Language ;
DROP TABLE IF EXISTS AuthToken;
DROP TABLE IF EXISTS Password;
DROP TABLE IF EXISTS User;

CREATE TABLE User 
(
	id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT ,
	username VARCHAR(255) NOT NULL,
    firstName VARCHAR(255),
    lastName VARCHAR(255),
    UNIQUE (username)
);

CREATE TABLE Password
(
	userID INTEGER NOT NULL PRIMARY KEY,
	hashedPassword VARCHAR(255) NOT NULL,
		FOREIGN KEY (userID) REFERENCES User(id) ON DELETE CASCADE
);

CREATE TABLE AuthToken 
(
	authToken VARCHAR(255) NOT NULL PRIMARY KEY,
	userID INTEGER NOT NULL,
	timestamp INTEGER NOT NULL,
		FOREIGN KEY (userID) REFERENCES User(id) ON DELETE CASCADE
);

CREATE TABLE Language 
(
	id CHAR(3) NOT NULL PRIMARY KEY,
	name VARCHAR(255) NOT NULL
);

INSERT INTO Language VALUES ('eng', 'English'), ('spa', 'Spanish');

CREATE TABLE UserLanguage 
(
	userID INTEGER NOT NULL,
	relationType CHAR(1) NOT NULL,
	languageID CHAR(3) NOT NULL,
        PRIMARY KEY (userID, languageID),
		FOREIGN KEY (userID) REFERENCES User(id) ON DELETE CASCADE,
		FOREIGN KEY (languageID) REFERENCES Language(id) ON DELETE CASCADE
);

CREATE TABLE UserStat 
(
	userID INTEGER NOT NULL,
	mappingID INTEGER NOT NULL,
	srcLangID CHAR(3) NOT NULL,
	targLangID CHAR(3) NOT NULL,
	statCount INTEGER NOT NULL,
	    PRIMARY KEY (userID, mappingID, srcLangID, targLangID),
		FOREIGN KEY (userID) REFERENCES User(id) ON DELETE CASCADE,
		FOREIGN KEY (srcLangID) REFERENCES Language(id) ON DELETE CASCADE,
		FOREIGN KEY (targLangID) REFERENCES Language(id) ON DELETE CASCADE
);