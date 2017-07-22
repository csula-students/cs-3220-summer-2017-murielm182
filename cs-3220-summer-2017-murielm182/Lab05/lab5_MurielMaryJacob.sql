use cs3220_lab5;

#Create restaurant food item table
CREATE TABLE food_items (
id int(11) PRIMARY KEY,
name VARCHAR(20),
description VARCHAR(50),
price float(10)
);

#Insert default food items into food items table
INSERT INTO food_items 
(id,name,description,price)
VALUES
(1,'Hamburger','A Hamburger',9.99);

INSERT INTO food_items 
(id,name,description,price)
VALUES
(2,'Fries','Some Fries',4.99);

INSERT INTO food_items 
(id,name,description,price)
VALUES
(3,'Coke','Coke Cola',2.99);

SELECT * FROM food_items;

#Create restaurant order statuses table
CREATE TABLE orders (
id int(11) PRIMARY KEY,
customer_name VARCHAR(20),
created DATETIME
);

#Insert default order statuses into order statuses table
INSERT INTO orders 
(id,customer_name,created)
VALUES
(1,'Eric',NOW());

INSERT INTO orders 
(id,customer_name,created)
VALUES
(2,'John',NOW());

INSERT INTO orders 
(id,customer_name,created)
VALUES
(3,'Jane',NOW());

INSERT INTO orders 
(id,customer_name,created)
VALUES
(4,'Alice',NOW());

SELECT * FROM orders;
CREATE TABLE order_foods (
order_id int(11),
food_id int(11),
quantity int(11)
);

INSERT INTO order_foods
(order_id,food_id,quantity)
VALUES
(1,1,1);

INSERT INTO order_foods
(order_id,food_id,quantity)
VALUES
(1,2,2);

INSERT INTO order_foods
(order_id,food_id,quantity)
VALUES
(2,2,2);

INSERT INTO order_foods
(order_id,food_id,quantity)
VALUES
(2,3,1);

INSERT INTO order_foods
(order_id,food_id,quantity)
VALUES
(3,3,1);

INSERT INTO order_foods
(order_id,food_id,quantity)
VALUES
(4,2,1);

INSERT INTO order_foods
(order_id,food_id,quantity)
VALUES
(4,3,2);

#Create restaurant cart table
CREATE TABLE shopping_cart (
id int(11),
customer_name varchar(20),
food_id int(11),
quantity int(11)
);

INSERT INTO shopping_cart
(id,customer_name,food_id,quantity)
VALUES
(1,'Anonymous',1,2);

INSERT INTO shopping_cart
(id,customer_name,food_id,quantity)
VALUES
(1,'Anonymous',2,1);

INSERT INTO shopping_cart
(id,customer_name,food_id,quantity)
VALUES
(1,'Anonymous',2,1);

INSERT INTO shopping_cart
(id,customer_name,food_id,quantity)
VALUES
(2,'Mike',1,1);

INSERT INTO shopping_cart
(id,customer_name,food_id,quantity)
VALUES
(2,'Mike',2,1);

INSERT INTO shopping_cart
(id,customer_name,food_id,quantity)
VALUES
(3,'Bob',3,1);


#Update food item name from "Hamburger" to "Salad"
UPDATE food_items
SET name='Salad'
WHERE id=1;

#Find out which food item has the most orders
SELECT order_foods.food_id AS 'Most Ordered ID',COUNT(food_id) AS 'No.of times Ordered',food_items.name AS 'Food Name'
FROM order_foods 
INNER JOIN food_items
ON order_foods.food_id=food_items.id
GROUP BY food_id 
ORDER BY count(food_id) DESC LIMIT 2;

#Find out which food item in least shopping carts
SELECT shopping_cart.food_id AS 'Least Ordered ID',COUNT(food_id) AS 'No. of Times Ordered',food_items.name AS 'Food Name'
FROM shopping_cart
INNER JOIN food_items
ON food_items.id=shopping_cart.food_id 
GROUP BY food_id ORDER BY count(food_id) ASC LIMIT 1;

#Find out all restaurant food items using SELECT query
SELECT * FROM food_items;

#Find out all restaurant order statuses using SELECT query
SELECT * FROM orders;

#Find out the order statuses that is created today
SELECT * FROM orders WHERE DATE(created) = DATE(NOW());

#DELETE restaurant food items table
DROP TABLE food_items;

#Delete restaurant order statuses table
DROP TABLE orders;

#Delete restaurant cart table
DROP TABLE shopping_cart;


