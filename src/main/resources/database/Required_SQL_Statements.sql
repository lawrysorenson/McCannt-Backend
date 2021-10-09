-- Register a new user
INSERT INTO User(username, firstname, lastname) VALUES ('griffirg23', 'Griffin', 'Holt');

SELECT id FROM User
WHERE username = 'griffirg23';

INSERT INTO Password Values (1, 'fkjsh8469b5');

-- Check the hashed password of a user
SELECT EXISTS(
    SELECT * FROM Password 
    WHERE (userID = 1 AND hashedPassword = 'fkjsh8469b5')
);

-- Add auth token
INSERT INTO AuthToken(authToken, userID, timestamp) VALUES ('76tgbnhj765trfvbn', 1, datetime('2021-10-09 10:23:32')); -- YYYY-MM-DD HH:MM:SS

-- Check an auth token
SELECT timestamp FROM AuthToken 
WHERE (userID = 1 AND authToken = '76tgbnhj765trfvbn');

-- Get all available languages
SELECT * FROM Language;

-- Add user language
INSERT INTO UserLanguage(userID, relationType, languageID) VALUES (1, 1, 'eng'), (1, 0, 'spa'); -- 0 Secondary 1 Primary

-- Query primary user language for specific user
SELECT languageID FROM UserLanguage 
WHERE (userID = 1 AND relationType = 1);

-- Query all secondary user languages for specific user
SELECT languageID FROM UserLanguage 
WHERE (userID = 1 AND relationType = 0);

-- Switch spanish and english primary and secondary
UPDATE UserLanguage 
SET relationType = 0
WHERE (userID = 1 AND relationType = 1);
UPDATE UserLanguage 
SET relationType = 1
WHERE (userID = 1 AND relationType = 0 AND languageID = 'spa');

-- Add a user statistic
INSERT INTO UserStat VALUES (1, 2, 'eng', 'spa', 32), (1, 39, 'eng', 'spa', 42);

-- Update a user statistic
UPDATE UserStat
SET statCount = 55
WHERE (userID = 1 AND mappingID = 2 AND srcLangID = 'eng' AND targLangID = 'spa');

-- Query all mappings & stats for user statistic for a specific source and target
SELECT mappingID, statCount FROM UserStat
WHERE (userID = 1 AND srcLangID = 'eng' AND targLangID = 'spa');