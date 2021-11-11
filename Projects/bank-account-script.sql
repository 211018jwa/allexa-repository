DROP TABLE IF EXISTS bankAccount;

CREATE TABLE bankAccount (
	client_bank_account_id SERIAL PRIMARY KEY,
	client_first_name VARCHAR(255) NOT NULL,
	client_last_name VARCHAR(255) NOT NULL,
	client_bank_account_type VARCHAR(255) NOT NULL
);

INSERT INTO bankAccount
	(client_first_name, client_last_name, client_bank_account_type)
VALUES 
	('John', 'Doe', 'Checking Account'),
	('John', 'Doe', 'Savings Account');
	
SELECT *
FROM bankAccount