CREATE DATABASE iF NOT EXISTS expensetracker;
USE expensetracker;

CREATE TABLE Users(
	userid INT PRIMARY KEY auto_increment,
    name VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    username VARCHAR(100)NOT NULL ,
    password VARCHAR(100) NOT NULL,
    phone VARCHAR(100)NOT NULL,
    active_yn INT DEFAULT 1,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
    );

CREATE TABLE Categories(
	categoryid INT PRIMARY KEY AUTO_INCREMENT,
	userid INT NOT NULL,
	name VARCHAR(50) NOT NULL,
	description VARCHAR(200),
	icon_url VARCHAR(255),
	type ENUM('INCOME','EXPENSE') NOT NULL DEFAULT 'EXPENSE',
	active_yn TINYINT DEFAULT 1,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

	FOREIGN KEY (userid) REFERENCES Users(userid) ON DELETE CASCADE
);

CREATE TABLE Transactions(
	transactionid BIGINT AUTO_INCREMENT PRIMARY KEY,
	userid INT NOT NULL,
	categoryid INT,
	amount DECIMAL(10,2) NOT NULL,
	note VARCHAR(255),
	transaction_date DATE NOT NULL,

	active_yn TINYINT DEFAULT 1,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

	FOREIGN KEY (userid) REFERENCES Users(userid) ON DELETE CASCADE,
	FOREIGN KEY (categoryid) REFERENCES Categories(categoryid) ON DELETE SET NULL
);


INSERT INTO Users (name, email, username, password, phone)
VALUES
('Amit Sharma', 'amit@gmail.com', 'amit123', 'pass123', '9876543210'),
('Neha Verma', 'neha@gmail.com', 'neha_v', 'pass456', '9876501234'),
('Rahul Mehta', 'rahul@gmail.com', 'rahul_m', 'pass789', '9123456780');

INSERT INTO Categories (userid, name, description, type)
VALUES
(1, 'Salary', 'Monthly salary', 'INCOME'),
(1, 'Food', 'Daily food expenses', 'EXPENSE'),
(2, 'Travel', 'Office & personal travel', 'EXPENSE');

INSERT INTO Transactions (userid, categoryid, amount, note, transaction_date)
VALUES
(1, 1, 50000.00, 'August Salary', '2025-08-01'),
(1, 2, 350.50, 'Lunch', '2025-08-20'),
(2, 3, 1200.00, 'Cab fare', '2025-08-18');


