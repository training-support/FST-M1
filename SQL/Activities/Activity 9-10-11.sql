--Activity9
-- Create the customers table
create table customers (
    customer_id int primary key, customer_name varchar(32),
    city varchar(20), grade int, salesman_id int);

-- Insert values into it
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

SELECT a.customer_name , a.city, b.salesman_name , b.commission FROM customers a INNER JOIN salesman b ON a.salesman_id=b.salesman_id;

SELECT a.customer_name, a.city, a.grade, b.salesman_name, b.salesman_city FROM customers a 
    LEFT OUTER JOIN salesman b ON a.salesman_id=b.salesman_id WHERE a.grade<300 
ORDER BY a.customer_id;

describe salesman;

SELECT a.customer_name , a.city, b.salesman_name, b.commission FROM customers a 
INNER JOIN salesman b ON a.salesman_id=b.salesman_id 
WHERE b.commission>12;

SELECT a.order_no, a.order_date, a.purchase_amount, b.customer_name, b.grade, c.salesman_name, c.commission FROM orders a 
INNER JOIN customers b ON a.customer_id=b.customer_id 
INNER JOIN salesman c ON a.salesman_id=c.salesman_id;


--Activity10
--SELECT * FROM orders WHERE salesman_id=(SELECT DISTINCT salesman_id FROM orders WHERE customer_id=3007);
--SELECT * FROM orders WHERE salesman_id IN (SELECT salesman_id FROM salesman WHERE salesman_city='New York');
--SELECT grade, COUNT(*) FROM customers GROUP BY grade HAVING grade>(SELECT AVG(grade) FROM customers WHERE city='New York');
SELECT order_no, purchase_amount, order_date, salesman_id FROM orders WHERE salesman_id IN( SELECT salesman_id FROM salesman WHERE commission=( SELECT MAX(commission) FROM salesman));

--Activity11
SELECT customer_id, customer_name FROM customers a
WHERE 1<(SELECT COUNT(*) FROM orders b WHERE a.customer_id = b.customer_id)
UNION
SELECT salesman_id, salesman_name FROM salesman a
WHERE 1<(SELECT COUNT(*) FROM orders b WHERE a.salesman_id = b.salesman_id)
ORDER BY customer_name;

SELECT a.salesman_id, salesman_name, order_no, 'highest on', order_date FROM salesman a, orders b
WHERE a.salesman_id=b.salesman_id
AND b.purchase_amount=(SELECT MAX(purchase_amount) FROM orders c WHERE c.order_date = b.order_date)
UNION
SELECT a.salesman_id, salesman_name, order_no, 'lowest on', order_date FROM salesman a, orders b
WHERE a.salesman_id=b.salesman_id
AND b.purchase_amount=(SELECT MIN(purchase_amount) FROM orders c WHERE c.order_date = b.order_date);

