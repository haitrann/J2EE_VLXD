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

CREATE TABLE IF NOT EXISTS Category(
	id INT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(255) DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS Customer(
	id INT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(255) DEFAULT NULL,
	address VARCHAR(255) DEFAULT NULL,
	phone VARCHAR(255) DEFAULT NULL,
	email VARCHAR(255) DEFAULT NULL,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS Product(
	id INT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(255) DEFAULT NULL,
	price VARCHAR(255) DEFAULT NULL,
	unit VARCHAR(255) DEFAULT NULL,
	category_id INT DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS Goods_Receipt(
	id INT,
	total VARCHAR(255) DEFAULT NULL,
	paid VARCHAR(255) DEFAULT NULL,
	vendor_id INT,
	created_by INT,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	status INT DEFAULT 0
);

CREATE TABLE IF NOT EXISTS Goods_Receipt_Details(
	id INT,
	total VARCHAR(255) DEFAULT NULL,
	unit_price VARCHAR(255) DEFAULT NULL,
	quantity INT,
	goods_receipt_id INT,
	product_id INT
);

CREATE TABLE IF NOT EXISTS Warehouse(
	id INT,
	product_id INT,
	quantity_in_stock INT
);

CREATE TABLE IF NOT EXISTS Selling_Bill(
	id INT AUTO_INCREMENT PRIMARY KEY,
	agency_id INT,
	created_by INT,
	total_amount VARCHAR(255) DEFAULT NULL,
	total_paid VARCHAR(255) DEFAULT NULL,
	total_amount VARCHAR(255) NULL,
	total_paid VARCHAR(255) NULL,
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

