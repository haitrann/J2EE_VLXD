CREATE TABLE IF NOT EXISTS User(
	id INT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(255) DEFAULT NULL,
	email VARCHAR(255) DEFAULT NULL,
	phone VARCHAR(255) DEFAULT NULL,
    username VARCHAR(255) DEFAULT NULL,
	password VARCHAR(255) DEFAULT NULL,
	role VARCHAR(255) DEFAULT NULL,
	avatar VARCHAR(255) DEFAULT NULL,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status INT DEFAULT 1
);

CREATE TABLE IF NOT EXISTS Vendor(
	id INT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(255) DEFAULT NULL,
	address VARCHAR(255) DEFAULT NULL,
	phone VARCHAR(255) DEFAULT NULL,
	email VARCHAR(255) DEFAULT NULL,
	debt VARCHAR(255) DEFAULT NULL,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS category(
	id INT AUTO_INCREMENT PRIMARY KEY,
<<<<<<< HEAD
	parent_id INT DEFAULT NULL,
	name VARCHAR(255) DEFAULT NULL
=======
	parent_id INT NULL,
	name VARCHAR(255)  NULL
>>>>>>> master
);

CREATE TABLE IF NOT EXISTS Vendor(
	id INT AUTO_INCREMENT PRIMARY KEY,
<<<<<<< HEAD
	name VARCHAR(255) DEFAULT NULL,
	address VARCHAR(255) DEFAULT NULL,
	phone VARCHAR(255) DEFAULT NULL,
	email VARCHAR(255) DEFAULT NULL,
	in_debt_amount VARCHAR(255) DEFAULT NULL
=======
	name VARCHAR(255)  NULL,
	address VARCHAR(255)  NULL,
	phone VARCHAR(255)  NULL,
	email VARCHAR(255)  NULL,
	in_debt_amount VARCHAR(255) NULL
>>>>>>> master
);

CREATE TABLE IF NOT EXISTS Agency(
	id INT AUTO_INCREMENT PRIMARY KEY,
<<<<<<< HEAD
	name VARCHAR(255) DEFAULT NULL,
	address VARCHAR(255) DEFAULT NULL,
	phone VARCHAR(255) DEFAULT NULL,
	email VARCHAR(255) DEFAULT NULL,
	in_debt_amount VARCHAR(255) DEFAULT NULL,
=======
	name VARCHAR(255) NULL,
	address VARCHAR(255) NULL,
	phone VARCHAR(255) NULL,
	email VARCHAR(255) NULL,
	in_debt_amount VARCHAR(255) NULL,
>>>>>>> master
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS Agency_Product(
	id INT AUTO_INCREMENT PRIMARY KEY,
	agency_id INT,
	product_id INT,
	quantity INT
);

CREATE TABLE IF NOT EXISTS Agency_Vendor_Dept(
	id INT AUTO_INCREMENT PRIMARY KEY,
	agency_id INT,
	vendor_id INT,
	in_dept_amount VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS Agency_Customer_Dept(
	id INT AUTO_INCREMENT PRIMARY KEY,
	agency_id INT,
	customer_id INT,
	in_dept_amount VARCHAR(255) NOT NULL
);


CREATE TABLE IF NOT EXISTS Customer(
	id INT AUTO_INCREMENT PRIMARY KEY,
<<<<<<< HEAD
	name VARCHAR(255) DEFAULT NULL,
	address VARCHAR(255) DEFAULT NULL,
	phone VARCHAR(255) DEFAULT NULL,
	email VARCHAR(255) DEFAULT NULL,
=======
	name VARCHAR(255) NULL,
	address VARCHAR(255) NULL,
	phone VARCHAR(255) NULL,
	email VARCHAR(255) NULL,
>>>>>>> master
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS Product(
<<<<<<< HEAD
	id INT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(255) DEFAULT NULL,
	price INT DEFAULT NULL,
	unit VARCHAR(255) DEFAULT NULL,
	import_price INT DEFAULT NULL,
	category_id INT DEFAULT NULL,
=======
	id INT PRIMARY KEY,
	name VARCHAR(255) NULL,
	price INT NULL,
	unit VARCHAR(255) NULL,
	import_price INT NULL,
	category_id INT NULL,
>>>>>>> master
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS Product_Category(
	id INT AUTO_INCREMENT PRIMARY KEY,
	product_id INT,
	category_id INT,
	image VARCHAR(255) NULL
);

CREATE TABLE IF NOT EXISTS Selling_Bill(
	id INT AUTO_INCREMENT PRIMARY KEY,
	agency_id INT,
	created_by INT,
<<<<<<< HEAD
	total_amount VARCHAR(255) DEFAULT NULL,
	total_paid VARCHAR(255) DEFAULT NULL,
=======
	total_amount VARCHAR(255) NULL,
	total_paid VARCHAR(255) NULL,
>>>>>>> master
	customer_id INT,
	status_paid INT
);

CREATE TABLE IF NOT EXISTS Selling_Bill_Detail(
	id INT,
	selling_bill_id INT,
	product_id INT,
	total INT, /*=unit_price*quantity*/
<<<<<<< HEAD
	unit_price VARCHAR(255) DEFAULT NULL,
=======
	unit_price VARCHAR(255) NULL,
>>>>>>> master
	quantity INT
);

CREATE TABLE IF NOT EXISTS Import_Goods_Bill(
	id INT,
	agency_id INT,
	created_by INT,
<<<<<<< HEAD
	total_amount VARCHAR(255) DEFAULT NULL,
	total_paid VARCHAR(255) DEFAULT NULL,
=======
	total_amount VARCHAR(255) NULL,
	total_paid VARCHAR(255) NULL,
>>>>>>> master
	vendor_id INT,
	status INT DEFAULT 0
);

CREATE TABLE IF NOT EXISTS Import_Goods_Bill_Details(
	id INT,
	import_goods_bill_id INT,
	product_id INT,
<<<<<<< HEAD
	total VARCHAR(255) DEFAULT NULL,
	unit_price VARCHAR(255) DEFAULT NULL,
=======
	total VARCHAR(255) NULL,
	unit_price VARCHAR(255) NULL,
>>>>>>> master
	quantity INT,
	vendor_id INT
);

CREATE TABLE IF NOT EXISTS Selling_Transactions(
	id INT,
	selling_bill_id INT,
<<<<<<< HEAD
	amount VARCHAR(255) DEFAULT NULL
=======
	amount VARCHAR(255) NULL
>>>>>>> master
);

CREATE TABLE IF NOT EXISTS Import_Goods_Transaction(
	id INT,
	import_goods_bill_id INT,
<<<<<<< HEAD
	amount VARCHAR(255) DEFAULT NULL
=======
	amount VARCHAR(255) NULL
>>>>>>> master
);

CREATE TABLE IF NOT EXISTS product_image(
	id INT AUTO_INCREMENT PRIMARY KEY,
	product_id INT,
<<<<<<< HEAD
	image VARCHAR(255) DEFAULT NULL
=======
	image VARCHAR(255) NULL
>>>>>>> master
);

