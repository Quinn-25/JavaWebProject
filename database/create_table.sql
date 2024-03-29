use newservlet122020;

CREATE TABLE role (
	id bigint NOT NULL PRIMARY KEY auto_increment,
    name VARCHAR(150) NOT NULL,
    code VARCHAR(150) NOT NULL,
    createddate TIMESTAMP NULL,
    modifieddate TIMESTAMP NULL,
    createdby VARCHAR(255) NULL,
    modifiedby VARCHAR(255) NUll
);

CREATE TABLE user (
	id bigint NOT NULL PRIMARY KEY auto_increment,
    name VARCHAR(150) NOT NULL,
    password VARCHAR(150) NOT NULL,
    fullname VARCHAR(150) NOT NULL,
    status int NOT NULL,
    roleid bigint NOT NULL,
    createddate TIMESTAMP NULL,
    modifieddate TIMESTAMP NULL,
    createdby VARCHAR(255) NULL,
    modifiedby VARCHAR(255) NUll
);

ALTER TABLE user ADD CONSTRAINT fk_userrole_user FOREIGN KEY (roleid) REFERENCES role(id);

CREATE TABLE news (
	id bigint NOT NULL PRIMARY KEY auto_increment,
    title VARCHAR(255) NULL,
    thumbnail VARCHAR(255) NULL,
    shortdescription TEXT NULL,
    content TEXT NULL,
    categoryid bigint NOT NULL,
    createddate TIMESTAMP NULL,
    modifieddate TIMESTAMP NULL,
    createdby VARCHAR(255) NULL,
    modifiedby VARCHAR(255) NUll
);

CREATE TABLE category (
	id bigint NOT NULL PRIMARY KEY auto_increment,
	name VARCHAR(150) NOT NULL,
    code VARCHAR(150) NOT NULL,
    createddate TIMESTAMP NULL,
    modifieddate TIMESTAMP NULL,
    createdby VARCHAR(255) NULL,
    modifiedby VARCHAR(255) NUll
);

ALTER TABLE news ADD CONSTRAINT fk_news_category FOREIGN KEY (categoryid) REFERENCES category(id);

CREATE TABLE comment (
	id bigint NOT NULL PRIMARY KEY auto_increment,
	content VARCHAR(150) NOT NULL,
    userid bigint NOT NULL,
    newsid bigint NOT NULL,
    createddate TIMESTAMP NULL,
    modifieddate TIMESTAMP NULL,
    createdby VARCHAR(255) NULL,
    modifiedby VARCHAR(255) NUll
);

ALTER TABLE comment ADD CONSTRAINT fk_comment_user FOREIGN KEY (userid) REFERENCES user(id);
ALTER TABLE comment ADD CONSTRAINT fk_comment_news FOREIGN KEY (newsid) REFERENCES news(id);
ALTER TABLE user CHANGE name username VARCHAR(150) NOT NULL;
