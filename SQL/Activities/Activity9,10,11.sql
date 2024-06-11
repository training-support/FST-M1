REM   Script: Activity 9,10,11
REM   monalika

Activity1 


CREATE TABLE salesman ( 
    salesman_id int, 
    salesman_name varchar2(32), 
    salesman_city varchar2(32), 
    commission int 
);

Activity2 


INSERT INTO salesman VALUES(5002, 'Nail Knite', 'Paris', 13);

INSERT ALL 
    INTO salesman VALUES(5005, 'Pit Alex', 'London', 11) 
    INTO salesman VALUES(5006, 'McLyon', 'Paris', 14) 
    INTO salesman VALUES(5007, 'Paul Adam', 'Rome', 13) 
    INTO salesman VALUES(5003, 'Lauson Hen', 'San Jose', 12) 
SELECT 1 FROM DUAL;

SELECT * FROM salesman;

Activity3: 


SELECT salesman_id, salesman_city FROM salesman;

SELECT * FROM salesman WHERE salesman_city='Paris';

SELECT salesman_id, commission FROM salesman WHERE salesman_name='Paul Adam';

Activity4: 


ALTER TABLE salesman ADD grade int;

UPDATE salesman SET grade=100;

SELECT * FROM salesman;

Activity5: 


UPDATE salesman SET grade=200 WHERE salesman_city='Rome';

UPDATE salesman SET grade=300 WHERE salesman_name='James Hoog';

UPDATE salesman SET salesman_name='Pierre' WHERE salesman_name='McLyon';

SELECT * FROM salesman;

Acivity6: 


create table orders( 
    order_no int primary key, purchase_amount float, order_date date, 
    customer_id int, salesman_id int);

INSERT ALL 
    INTO orders VALUES(70001, 150.5, TO_DATE('2012/10/05', 'YYYY/MM/DD'), 3005, 5002)  
    INTO orders VALUES(70009, 270.65, TO_DATE('2012/09/10', 'YYYY/MM/DD'), 3001, 5005) 
    INTO orders VALUES(70002, 65.26, TO_DATE('2012/10/05', 'YYYY/MM/DD'), 3002, 5001) 
    INTO orders VALUES(70004, 110.5, TO_DATE('2012/08/17', 'YYYY/MM/DD'), 3009, 5003) 
    INTO orders VALUES(70007, 948.5, TO_DATE('2012/09/10', 'YYYY/MM/DD'), 3005, 5002) 
    INTO orders VALUES(70005, 2400.6, TO_DATE('2012/07/27', 'YYYY/MM/DD'), 3007, 5001) 
    INTO orders VALUES(70008, 5760, TO_DATE('2012/08/15', 'YYYY/MM/DD'), 3002, 5001) 
    INTO orders VALUES(70010, 1983.43, TO_DATE('2012/10/10', 'YYYY/MM/DD'), 3004, 5006) 
    INTO orders VALUES(70003, 2480.4, TO_DATE('2012/10/10', 'YYYY/MM/DD'), 3009, 5003) 
    INTO orders VALUES(70012, 250.45, TO_DATE('2012/06/27', 'YYYY/MM/DD'), 3008, 5002) 
    INTO orders VALUES(70011, 75.29, TO_DATE('2012/08/17', 'YYYY/MM/DD'), 3003, 5007) 
    INTO orders VALUES(70013, 3045.6, TO_DATE('2012/04/25', 'YYYY/MM/DD'), 3002, 5001) 
SELECT 1 FROM DUAL;

Activity7: 


select SUM(purchase_amount) AS "Total sum" from orders;

select AVG(purchase_amount) AS "Average" from orders;

select MAX(purchase_amount) AS "Maximum" from orders;

select MIN(purchase_amount) AS "Minumum" from orders;

select COUNT(distinct salesman_id) AS "Total count" from orders;

Activity8: 


SELECT customer_id, MAX(purchase_amount) AS "Max Amount" FROM orders GROUP BY customer_id;

SELECT salesman_id, order_date, MAX(purchase_amount) AS "Max Amount" FROM orders  
WHERE order_date=To_DATE('2012/08/17', 'YYYY/MM/DD') GROUP BY salesman_id, order_date;

SELECT customer_id, order_date, MAX(purchase_amount) AS "Max Amount" FROM orders 
GROUP BY customer_id, order_date 
HAVING MAX(purchase_amount) IN(2030, 3450, 5760, 6000);

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

SELECT customer_id, customer_name FROM customers a 
WHERE 1<(SELECT COUNT(*) FROM orders b WHERE a.customer_id = b.customer_id) 
UNION 
SELECT salesman_id, name FROM salesman a 
WHERE 1<(SELECT COUNT(*) FROM orders b WHERE a.salesman_id = b.salesman_id) 
ORDER BY customer_name;

SELECT a.salesman_id, name, order_no, 'highest on', order_date FROM salesman a, orders b 
WHERE a.salesman_id=b.salesman_id 
AND b.purchase_amount=(SELECT MAX(purchase_amount) FROM orders c WHERE c.order_date = b.order_date) 
UNION 
SELECT a.salesman_id, name, order_no, 'lowest on', order_date FROM salesman a, orders b 
WHERE a.salesman_id=b.salesman_id 
AND b.purchase_amount=(SELECT MIN(purchase_amount) FROM orders c WHERE c.order_date = b.order_date);

