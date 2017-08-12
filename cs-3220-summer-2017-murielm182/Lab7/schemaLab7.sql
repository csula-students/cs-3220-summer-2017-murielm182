use lab7;

CREATE TABLE menu (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    description TEXT,
    imagURL TEXT,
    price DOUBLE
);

CREATE TABLE order_foods (
	order_foods_id INTEGER NOT NULL REFERENCES orders(orders_id),
	menu_id INTEGER NOT NULL REFERENCES menu(id)
	
);

CREATE TABLE orders (
	order_id INTEGER AUTO_INCREMENT PRIMARY KEY,
	customer_name VARCHAR(255) NOT NULL,
	status VARCHAR(255) NOT NULL,
	order_time TIMESTAMP NOT NULL
);


INSERT INTO menu (id, name, description, imagURL, price) 
VALUES
(1, "HamBurger", "Oven Roasted Ham", "https://upload.wikimedia.org/wikipedia/commons/thumb/9/9a/Big_Mac_hamburger.jpg/220px-Big_Mac_hamburger.jpg", 5.99),
(2, "Cheese Burger", "Cheesy", "https://i2.wp.com/www.justputzing.com/wp-content/uploads/2013/03/DSC_5357.jpg?resize=600%2C600", 4.99),
(3, "Coker", "Some Coke", "http://i.dailymail.co.uk/i/pix/2015/01/15/0E9D104600000578-0-image-m-42_1421283458358.jpg", 8.99);


INSERT INTO orders (order_id, customer_name, status, order_time) VALUES
(1, "Martha", "COMPLETED", NOW()),
(2, "Nathan", "IN_QUEUE", NOW());


INSERT INTO order_foods (order_foods_id, menu_id) VALUES 
(1, 1),
(1, 2),
(2, 3);

