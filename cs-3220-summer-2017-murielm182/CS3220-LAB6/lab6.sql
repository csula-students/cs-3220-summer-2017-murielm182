use cs3220_lab5;

CREATE TABLE food_items (
id int AUTO_INCREMENT PRIMARY KEY, 
name VARCHAR(20),
imageURL VARCHAR(500),
description VARCHAR(50),
price float(10)
);

INSERT INTO food_items 
(id,name,imageURL,description,price)
VALUES
(1,'Hamburger','https://thumbs.dreamstime.com/z/big-hamburger-19922566.jpg','A Hamburger',9.99);

INSERT INTO food_items 
(id,name,imageURL,description,price)
VALUES
(2,'Fries','https://i.ytimg.com/vi/ETTyVQrUZt8/maxresdefault.jpg','Some Fries',4.99);

INSERT INTO food_items 
(id,name,imageURL,description,price)
VALUES
(3,'Coke','https://i.ytimg.com/vi/paUElsgY3Dc/maxresdefault.jpg','Coke Cola',2.99);



