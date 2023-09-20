REM   Script: activity10
REM   activity10

create table customers ( 
    customer_id int primary key, customer_name varchar(32), 
    city varchar(20), grade int, salesman_id int);

INSERT ALL 
    INTO customers VALUES (3002, 'Nick Rimando', 'New York', 100, 5001) 
    INTO customers VALUES (3007, 'Brad Davis', 'New York', 200, 5001) 
    INTO customers VALUES (3005, 'Graham Zusi', 'California', 200, 5002) 
    INTO customers VALUES (3008, 'Julian Green', 'London', 300, 5002) 
    INTO customers VALUES (3004, 'Fabian Johnson', 'Paris', 300, 5006) 
    INTO customers VALUES (3009, 'Geoff Cameron', 'Berlin', 100, 5003) 
    INTO customers VALUES (3003, 'Jozy Altidor', 'Moscow', 200, 5007) 
    INTO customers VALUES (3001, 'Brad Guzan', 'London', 300, 5005) 
SELECT 1 FROM DUAL;

SELECT * FROM orders 
WHERE salesman_id=(SELECT DISTINCT salesman_id FROM orders WHERE customer_id=3007);

SELECT * FROM orders 
WHERE salesman_id IN (SELECT salesman_id FROM salesman WHERE city='New York');

SELECT grade, COUNT(*) FROM customers 
GROUP BY grade HAVING grade>(SELECT AVG(grade) FROM customers WHERE city='New York');

SELECT order_no, purchase_amount, order_date, salesman_id FROM orders 
WHERE salesman_id IN( SELECT salesman_id FROM salesman 
WHERE commission=( SELECT MAX(commission) FROM salesman));

SELECT * FROM orders 
WHERE salesman_id=(SELECT DISTINCT salesman_id FROM orders WHERE customer_id=3007);

SELECT * FROM customer 
WHERE salesman_id=(SELECT DISTINCT salesman_id FROM orders WHERE customer_id=3007);

SELECT * FROM customer 
WHERE salesman_id=(SELECT DISTINCT salesman_id FROM orders WHERE customer_id=3007);

SELECT * FROM customer 
WHERE salesman_id=(SELECT DISTINCT salesman_id FROM orders WHERE customer_id=3007);

SELECT * FROM customers 
WHERE salesman_id=(SELECT DISTINCT salesman_id FROM orders WHERE customer_id=3007);

SELECT * FROM customers 
WHERE salesman_id=(SELECT DISTINCT salesman_id FROM customers WHERE customer_id=3007);

SELECT * FROM customers 
WHERE salesman_id=(SELECT DISTINCT salesman_id FROM customers WHERE customer_id=3007);

SELECT * FROM customers 
WHERE salesman_id IN (SELECT salesman_id FROM salesman WHERE city='New York');

SELECT * FROM customers 
WHERE salesman_id IN (SELECT salesman_id FROM customers WHERE city='New York');

SELECT order_no, purchase_amount, order_date, salesman_id FROM customers 
WHERE salesman_id IN( SELECT salesman_id FROM salesman 
WHERE commission=( SELECT MAX(commission) FROM salesman));

SELECT order_no, purchase_amount, salesman_id FROM customers 
WHERE salesman_id IN( SELECT salesman_id FROM salesman 
WHERE commission=( SELECT MAX(commission) FROM salesman));

SELECT order_no, salesman_id FROM customers 
WHERE salesman_id IN( SELECT salesman_id FROM salesman 
WHERE commission=( SELECT MAX(commission) FROM salesman));

SELECT * FROM customers 
WHERE salesman_id IN( SELECT salesman_id FROM salesman 
WHERE commission=( SELECT MAX(commission) FROM salesman));

SELECT * FROM customers 
WHERE salesman_id IN( SELECT salesman_id FROM customers 
WHERE commission=( SELECT MAX(commission) FROM customers));

SELECT * FROM customers 
WHERE salesman_id IN( SELECT salesman_id FROM customers 
WHERE commission=(SELECT MAX(commission) FROM customers));

SELECT * FROM customers 
WHERE salesman_id IN( SELECT salesman_id FROM customers 
WHERE SELECT MAX(commission) FROM customers);

SELECT * FROM customers 
WHERE customer_id IN( SELECT customer_id FROM customers 
WHERE SELECT MAX(commission) FROM customers);

SELECT * FROM orders 
WHERE salesman_id IN( SELECT salesman_id FROM salesman 
WHERE commission=( SELECT MAX(commission) FROM salesman));

SELECT * FROM customers 
WHERE salesman_id IN (SELECT salesman_id FROM customers WHERE city='New York');

SELECT * FROM orders 
WHERE salesman_id IN( SELECT salesman_id FROM customers 
WHERE commission=( SELECT MAX(commission) FROM customers));

SELECT * FROM customers 
WHERE salesman_id IN( SELECT salesman_id FROM customers 
WHERE commission=( SELECT MAX(commission) FROM customers));

