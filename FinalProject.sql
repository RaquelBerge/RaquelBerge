
CREATE TABLE usersLatvia(
personID int not null auto_increment,
pensioner BOOL,
disability BOOL,
minimum double,
grossIncome double,
children int,
PRIMARY KEY (personID)
);

SELECT * FROM usersLatvia;
-- INSERT INTO usersLatvia(pensioner, disability, minimum, grossIncome, children) VALUES (?, ?, ?, ?, ?);
INSERT INTO usersLatvia(pensioner, disability, minimum, grossIncome, children) VALUES (0, 0, 100, 5000, 2);
DROP TABLE IF EXISTS usersLatvia;

CREATE TABLE usersSpain(
personID int not null auto_increment,
grossIncome double,
industry int,
rent double,
mortgage double,
donations double,
PRIMARY KEY (personID)
);

SELECT * FROM usersSpain;
-- INSERT INTO usersSpain (industry, grossIncome, rent, mortgage, donations) VALUES (?, ?, ?, ?, ?);
INSERT INTO usersSpain (industry, grossIncome, rent, mortgage, donations) VALUES (1, 5000, 500, 500, 200);
DROP TABLE IF EXISTS usersSpain;

CREATE TABLE usersVatican(
personID int not null auto_increment,
pop BOOL,
god BOOL,
grossIncome double,
PRIMARY KEY (personID)
);

SELECT * FROM usersVatican;
-- INSERT INTO usersVatican (pop, god, grossIncome) VALUES (?, ?, ?);
INSERT INTO usersVatican (pop, god, grossIncome) VALUES (0, 1, 8000000);
DROP TABLE IF EXISTS usersVatican;

CREATE TABLE usersMonaco (
personID int not null auto_increment,
grossIncome double,
month int,
deposit double,
PRIMARY KEY (personID)
);

SELECT * FROM usersMonaco;
-- INSERT INTO usersMonaco (month, deposit, grossIncome) VALUES (?, ?, ?);
INSERT INTO usersMonaco (month, deposit, grossIncome) VALUES (12, 100, 50000);
DROP TABLE IF EXISTS usersMonaco;

CREATE TABLE usersWonderland (
personID int not null auto_increment,
grossIncome double,
pet int,
PRIMARY KEY (personID)
);

SELECT * FROM usersWonderland;
-- INSERT INTO usersWonderland (pet, grossIncome) VALUES (?, ?);
INSERT INTO usersWonderland (pet, grossIncome) VALUES (0, 5000);
DROP TABLE IF EXISTS usersWonderland;

CREATE TABLE insertName (
personID int not null auto_increment,
name varchar(100),
PRIMARY KEY (personID)
);

