DROP TABLE dbs;
CREATE TABLE dbs(
                    id INT PRIMARY KEY AUTO_INCREMENT,
                    url VARCHAR(255),
                    username VARCHAR(255),
                    password VARCHAR(255)
);

DROP TABLE pbs;
CREATE TABLE pbs(
                    id INT PRIMARY KEY AUTO_INCREMENT,
                    Title VARCHAR(255),
                    Description VARCHAR(255)
);
INSERT INTO pbs VALUES(1,'test','test');