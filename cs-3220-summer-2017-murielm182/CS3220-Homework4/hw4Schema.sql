use homework4;

CREATE TABLE Food_Items (
    id int AUTO_INCREMENT PRIMARY KEY,
    name varchar(255),
    imageURL varchar(500),
    description varchar(255),
    price float);

CREATE TABLE orders(
order_id INTEGER auto_increment primary KEY,
customer_name VARCHAR(255),
order_status VARCHAR(255), 
order_time timestamp);

CREATE TABLE order_foods(
order_foods_id integer REFERENCES orders(order_id),
food_id Integer REFERENCES Food_Items(ID),
food_quantity Integer);

#INSERT STATEMENTS
INSERT INTO Food_Items(id, name,imageURL, description,price)
VALUES 
(1, "HamBurger", "https://upload.wikimedia.org/wikipedia/commons/thumb/9/9a/Big_Mac_hamburger.jpg/220px-Big_Mac_hamburger.jpg", "Oven Roasted Ham", 5.99),
(2, "Cheese Burger","https://i2.wp.com/www.justputzing.com/wp-content/uploads/2013/03/DSC_5357.jpg?resize=600%2C600", "Cheesy",  4.99),
(3, "Coker", "http://i.dailymail.co.uk/i/pix/2015/01/15/0E9D104600000578-0-image-m-42_1421283458358.jpg","Some Coke",8.99);

INSERT INTO orders (order_id, customer_name, order_status, order_time) VALUES
(1, "Martha", "COMPLETED", NOW()),
(2, "Kiara", "IN QUEUE", NOW());


INSERT INTO order_foods (order_foods_id, food_id, food_quantity) VALUES 
(1, 3, 5),
(1, 2, 3),
(1, 1, 4);



