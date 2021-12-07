DROP TABLE IF EXISTS assignments;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
	id SERIAL Primary Key,
	first_name VARCHAR(50) NOT NULL,
	last_name VARCHAR(50) NOT NULL,
	username VARCHAR(20) NOT NULL UNIQUE,
	password VARCHAR(20) NOT NULL,
	user_role VARCHAR(50) NOT NULL
);

INSERT INTO users 
	(first_name, last_name, username, password, user_role)
	
VALUES
	('Jane', 'Doe', 'JaneD', 'password1', 'trainer'),
	('John', 'Doe', 'JDoe', 'password2', 'associate'),
	('Bach', 'Tran', 'bach_tran', 'password3', 'trainer'),
	('Leah', 'Doe', 'LDoe', 'password4', 'associate');
	

CREATE TABLE assignments (
	id SERIAL PRIMARY KEY,
	assignment_name VARCHAR(50) NOT NULL,
	grade INTEGER,
	grader_id INTEGER,
	author_id INTEGER NOT NULL,
	
	CONSTRAINT grade_fk FOREIGN KEY (grader_id) REFERENCES users(id),
	CONSTRAINT author_fk FOREIGN KEY (author_id) REFERENCES users(id)
);

INSERT INTO assignments (
	assignment_name,
	author_id
)

VALUES
('Homework 1.1', 2),
('Homework 1.1', 4),
('Homework 1.2', 2),
('Homework 1.2', 4),
('Homework 1.3', 2),
('Homework 1.3', 4);

SELECT *
FROM users

SELECT *
FROM assignments