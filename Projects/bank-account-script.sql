DROP TABLE IF EXISTS bankAccount;

DROP TABLE IF EXISTS clients;

CREATE TABLE clients (
	client_id SERIAL PRIMARY KEY,
	client_first_name VARCHAR(255) NOT NULL,
	client_last_name VARCHAR(255) NOT NULL
);

INSERT INTO clients
	(client_first_name, client_last_name)
VALUES 
	('John', 'Doe'),
	('Jane', 'Doe');


CREATE TABLE bankAccount (
	account_id SERIAL PRIMARY KEY,
	account_type VARCHAR(100) NOT NULL,
	balance INT NOT NULL,
	client_id INTEGER NOT NULL,
	
	CONSTRAINT fk_clients FOREIGN KEY(client_id)
		REFERENCES clients(client_id)
);

INSERT INTO bankAccount (account_type, balance, client_id)
VALUES
	('Checking', 500, 1),
	('Savings', 10000, 1),
	('Checking', 3000, 2),
	('Savings', 7000, 2);


SELECT *
FROM clients

SELECT *
FROM bankAccount

SELECT * FROM bankAccount WHERE client_id = 1

SELECT * FROM bankAccount WHERE client_id = 1 AND balance >= 1000 AND balance <= 20000