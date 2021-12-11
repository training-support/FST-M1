REM   Script: Activity10
REM   Inserting into table

CREATE TABLE salesman 
{  
    salesman_id int, 
    salesman_name  varchar2(20), 
    salesman_city varchar2(20), 
    commission int 
};

CREATE TABLE salesman 
(  
    salesman_id int, 
    salesman_name  varchar2(20), 
    salesman_city varchar2(20), 
    commission int 
);

describe salesman


INSERT INTO salesman VALUES (5001,'James Hoog','New York',15);

INSERT INTO salesman VALUES (5002,'Nail Knite','Paris',13);

INSERT INTO salesman VALUES (5005,'Pit Alex','London',11);

INSERT INTO salesman VALUES (5006,'McLyon','Paris',14);

INSERT INTO salesman VALUES (5007,'Paul Adam','Rome',13);

INSERT INTO salesman VALUES (5003,'Lauson Hen','San Jose',12);

SELECT * FROM salesman;

select salesman_id, salesman_city;

select salesman_id, salesman_city from salesman;

select * from salesman where salesman_city = 'Paris';

select salesman_id, commission from salesman where salesman_name = 'Paul Adam';

alter table salesman add (grade int);

update table salesman set grade = 100;

update salesman set grade = 100;

select * from salesman;

update salesman set grade = 200 where salesman_city = 'Rome';

update salesman set grade = 300 where salesman_name = 'James Hoog';

update salesman set salesman_name = 'Pierre' where salesman_name = 'McLyon';

select * from salesman;

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

select distinct salesman_id;

select distinct salesman_id from orders;

select order_no from orders group by order_date;

select order_no,order_date from orders order by order_date;

select order_no,order_date from orders order by order_date;

select order_no,purchase_amount from orders order by purchase_amount desc;

select * from orders where purchase_amount < 500;

select * from orders where purchase_amount between 1000 and 2000;

select sum(purchase_amount) from orders;

select avg(purchase_amount) from orders;

select max(purchase_amount) from orders;

select min(purchase_amount) from orders;

select count(distinct salesman_id) from orders;

select max(purchase_amount), customer_id from orders group by customer_id;

select max(purchase_amount), salesman_id from orders where order_date ='2012-08-17' group by salesman_id;

select max(purchase_amount), salesman_id, order_date from orders where order_date ='To_DATE('2012/08/17', 'YYYY/MM/DD') group by salesman_id, order_date;

SELECT salesman_id, order_date, MAX(purchase_amount) AS "Max Amount" FROM orders  
WHERE order_date=To_DATE('2012/08/17', 'YYYY/MM/DD') GROUP BY salesman_id, order_date;

select salesman_id, order_date,max(purchase_amount) from orders where order_date ='To_DATE('2012/08/17', 'YYYY/MM/DD') group by salesman_id, order_date;

select salesman_id, order_date,max(purchase_amount) from orders 
where order_date =To_DATE('2012/08/17', 'YYYY/MM/DD') group by salesman_id, order_date;

select salesman_id, order_date,max(purchase_amount) from orders 
where purchase_amount in [2030, 3450, 5760, 6000] group by salesman_id, order_date;

select salesman_id, order_date,max(purchase_amount) from orders 
group by salesman_id, order_date having max(purchase_amount) in (2030, 3450, 5760, 6000);

create table customers ( 
    customer_id int primary key, customer_name varchar(32), 
    city varchar(20), grade int, salesman_id int);

insert into customers values  
(3002, 'Nick Rimando', 'New York', 100, 5001), (3007, 'Brad Davis', 'New York', 200, 5001), 
(3005, 'Graham Zusi', 'California', 200, 5002), (3008, 'Julian Green', 'London', 300, 5002), 
(3004, 'Fabian Johnson', 'Paris', 300, 5006), (3009, 'Geoff Cameron', 'Berlin', 100, 5003), 
(3003, 'Jozy Altidor', 'Moscow', 200, 5007), (3001, 'Brad Guzan', 'London', 300, 5005);

insert into customers values  
(3002, 'Nick Rimando', 'New York', 100, 5001), (3007, 'Brad Davis', 'New York', 200, 5001), 
(3005, 'Graham Zusi', 'California', 200, 5002), (3008, 'Julian Green', 'London', 300, 5002), 
(3004, 'Fabian Johnson', 'Paris', 300, 5006), (3009, 'Geoff Cameron', 'Berlin', 100, 5003), 
(3003, 'Jozy Altidor', 'Moscow', 200, 5007), (3001, 'Brad Guzan', 'London', 300, 5005);

insert all 
insert into customers values  
(3002, 'Nick Rimando', 'New York', 100, 5001), (3007, 'Brad Davis', 'New York', 200, 5001), 
(3005, 'Graham Zusi', 'California', 200, 5002), (3008, 'Julian Green', 'London', 300, 5002), 
(3004, 'Fabian Johnson', 'Paris', 300, 5006), (3009, 'Geoff Cameron', 'Berlin', 100, 5003), 
(3003, 'Jozy Altidor', 'Moscow', 200, 5007), (3001, 'Brad Guzan', 'London', 300, 5005);

insert all 
into table customers values (3002, 'Nick Rimando', 'New York', 100, 5001) 
into table customers values (3007, 'Brad Davis', 'New York', 200, 5001) 
into table customers values (3005, 'Graham Zusi', 'California', 200, 5002) 
into table customers values (3008, 'Julian Green', 'London', 300, 5002) 
into table customers values (3004, 'Fabian Johnson', 'Paris', 300, 5006) 
into table customers values (3009, 'Geoff Cameron', 'Berlin', 100, 5003) 
into table customers values (3003, 'Jozy Altidor', 'Moscow', 200, 5007) 
into table customers values (3001, 'Brad Guzan', 'London', 300, 5005);

insert all 
into customers values (3002, 'Nick Rimando', 'New York', 100, 5001) 
into customers values (3007, 'Brad Davis', 'New York', 200, 5001) 
into customers values (3005, 'Graham Zusi', 'California', 200, 5002) 
into customers values (3008, 'Julian Green', 'London', 300, 5002) 
into customers values (3004, 'Fabian Johnson', 'Paris', 300, 5006) 
into customers values (3009, 'Geoff Cameron', 'Berlin', 100, 5003) 
into customers values (3003, 'Jozy Altidor', 'Moscow', 200, 5007) 
into customers values (3001, 'Brad Guzan', 'London', 300, 5005);

nsert all 


into customers values (3002, 'Nick Rimando', 'New York', 100, 5001) 


into customers values (3007, 'Brad Davis', 'New York', 200, 5001) 


into customers values (3005, 'Graham Zusi', 'California', 200, 5002) 


into customers values (3008, 'Julian Green', 'London', 300, 5002) 


into customers values (3004, 'Fabian Johnson', 'Paris', 300, 5006) 


into customers values (3009, 'Geoff Cameron', 'Berlin', 100, 5003) 


into customers values (3003, 'Jozy Altidor', 'Moscow', 200, 5007) 


into customers values (3001, 'Brad Guzan', 'London', 300, 5005) 


SELECT 1 FROM DUAL;

insert all 
into customers values (3002, 'Nick Rimando', 'New York', 100, 5001) 
into customers values (3007, 'Brad Davis', 'New York', 200, 5001) 
into customers values (3005, 'Graham Zusi', 'California', 200, 5002) 
into customers values (3008, 'Julian Green', 'London', 300, 5002) 
into customers values (3004, 'Fabian Johnson', 'Paris', 300, 5006) 
into customers values (3009, 'Geoff Cameron', 'Berlin', 100, 5003) 
into customers values (3003, 'Jozy Altidor', 'Moscow', 200, 5007) 
into customers values (3001, 'Brad Guzan', 'London', 300, 5005) 
SELECT 1 FROM DUAL;

select cust.customer_name, cust.city, sales.name, sales.commission from customers cust inner join salesman sales on cust.salesman_id=sales.salesman_id;

select cust.customer_name, cust.city, sales.salesman_name, sales.commission from customers cust inner join salesman sales on cust.salesman_id=sales.salesman_id;

select cust.customer_name, cust.city, cust.grade, sales.salesman_name, sales.city FROM customers cust 
left outer join salesman sales ON cust.salesman_id=sales.salesman_id WHERE cust.grade<300  
order by cust.customer_id;

select cust.customer_name, cust.city, cust.grade, sales.salesman_name, sales.salesman_city FROM customers cust 
left outer join salesman sales ON cust.salesman_id=sales.salesman_id WHERE cust.grade<300  
order by cust.customer_id;

create table customers ( 
    customer_id int primary key, customer_name varchar(32), 
    city varchar(20), grade int, salesman_id int);

insert all 
into customers values (3002, 'Nick Rimando', 'New York', 100, 5001) 
into customers values (3007, 'Brad Davis', 'New York', 200, 5001) 
into customers values (3005, 'Graham Zusi', 'California', 200, 5002) 
into customers values (3008, 'Julian Green', 'London', 300, 5002) 
into customers values (3004, 'Fabian Johnson', 'Paris', 300, 5006) 
into customers values (3009, 'Geoff Cameron', 'Berlin', 100, 5003) 
into customers values (3003, 'Jozy Altidor', 'Moscow', 200, 5007) 
into customers values (3001, 'Brad Guzan', 'London', 300, 5005) 
SELECT 1 FROM DUAL;

select cust.customer_name, cust.city, sales.salesman_name, sales.commission from customers cust inner join salesman sales on cust.salesman_id=sales.salesman_id;

select cust.customer_name, cust.city, sales.salesman_name, sales.commission from customers cust inner join salesman sales on cust.salesman_id=sales.salesman_id;

select cust.customer_name, cust.city, cust.grade, sales.salesman_name, sales.salesman_city FROM customers cust 
left outer join salesman sales ON cust.salesman_id=sales.salesman_id WHERE cust.grade<300  
order by cust.customer_id;

select cust.customer_name, cust.city, cust.grade, sales.salesman_name, sales.salesman_city FROM customers cust 
left outer join salesman sales ON cust.salesman_id=sales.salesman_id WHERE cust.grade<300  
order by cust.customer_id;

create table customers ( 
    customer_id int primary key, customer_name varchar(32), 
    city varchar(20), grade int, salesman_id int);

insert all 
into customers values (3002, 'Nick Rimando', 'New York', 100, 5001) 
into customers values (3007, 'Brad Davis', 'New York', 200, 5001) 
into customers values (3005, 'Graham Zusi', 'California', 200, 5002) 
into customers values (3008, 'Julian Green', 'London', 300, 5002) 
into customers values (3004, 'Fabian Johnson', 'Paris', 300, 5006) 
into customers values (3009, 'Geoff Cameron', 'Berlin', 100, 5003) 
into customers values (3003, 'Jozy Altidor', 'Moscow', 200, 5007) 
into customers values (3001, 'Brad Guzan', 'London', 300, 5005) 
SELECT 1 FROM DUAL;

select cust.customer_name, cust.city, sales.salesman_name, sales.commission from customers cust inner join salesman sales on cust.salesman_id=sales.salesman_id;

select cust.customer_name, cust.city, cust.grade, sales.salesman_name, sales.salesman_city FROM customers cust 
left outer join salesman sales ON cust.salesman_id=sales.salesman_id WHERE cust.grade<300  
order by cust.customer_id;

select cust.customer_name, cust.city, sales.salesman_name, sales.commission FROM customers cust 
INNER JOIN salesman sales ON cust.salesman_id=sales.salesman_id  
WHERE sales.commission>12;

create table customers ( 
    customer_id int primary key, customer_name varchar(32), 
    city varchar(20), grade int, salesman_id int);

insert all 
into customers values (3002, 'Nick Rimando', 'New York', 100, 5001) 
into customers values (3007, 'Brad Davis', 'New York', 200, 5001) 
into customers values (3005, 'Graham Zusi', 'California', 200, 5002) 
into customers values (3008, 'Julian Green', 'London', 300, 5002) 
into customers values (3004, 'Fabian Johnson', 'Paris', 300, 5006) 
into customers values (3009, 'Geoff Cameron', 'Berlin', 100, 5003) 
into customers values (3003, 'Jozy Altidor', 'Moscow', 200, 5007) 
into customers values (3001, 'Brad Guzan', 'London', 300, 5005) 
SELECT 1 FROM DUAL;

select cust.customer_name, cust.city, sales.salesman_name, sales.commission from customers cust inner join salesman sales on cust.salesman_id=sales.salesman_id;

select cust.customer_name, cust.city, cust.grade, sales.salesman_name, sales.salesman_city FROM customers cust 
left outer join salesman sales ON cust.salesman_id=sales.salesman_id WHERE cust.grade<300  
order by cust.customer_id;

select cust.customer_name, cust.city, sales.salesman_name, sales.commission FROM customers cust 
INNER JOIN salesman sales ON cust.salesman_id=sales.salesman_id  
WHERE sales.commission>12;

SELECT ord.order_no, ord.order_date, ord.purchase_amount, cust.customer_name, cust.grade, sales.salesman_name, sales.commission FROM orders ord  
INNER JOIN customers cust ON ord.customer_id=cust.customer_id  
INNER JOIN salesman sales ON ord.salesman_id=sales.salesman_id;

SELECT * FROM orders 
WHERE salesman_id=(SELECT DISTINCT salesman_id FROM orders WHERE customer_id=3007);

select * from orders 
where salesman_id in (select salesman_id from salesman where city='New York');

select * from orders 
where salesman_id in (select salesman_id from salesman where salesman_city='New York');

select grade, count(*) from customers group by grade having grade>(select avg(grade) from customers where city='New York');

select order_no, purchase_amount, order_date, salesman_id from orders where salesman_id in( select salesman_id from salesman 
where commission=( select max(commission) from salesman));

