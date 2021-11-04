DELETE TABLE IF EXISTS bankAccount;

CREATE TABLE bankAccount (
	client_bank_account_id INTEGER PRIMARY KEY,
	client_first_name VARCHAR(255) NOT NULL,
	client_last_name VARCHAR(255) NOT NULL,
	client_bank_account_type VARCHAR(255) NOT NULL
);

INSERT INTO bankAccount
	(client_bank_account_id, client_first_name, client_last_name, client_bank_account_type)
VALUES 
	(1,'John', 'Doe', 'Checking Account'),
	(2,'John', 'Doe', 'Savings Account');