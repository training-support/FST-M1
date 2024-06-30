CREATE TABLE salesman ( 
    salesman_id int, 
   salesman_name varchar2(20), 
    salesman_city varchar2(20), 
   commission int 
);

CREATE TABLE salesman ( 
    salesman_id int, 
   salesman_name varchar2(20), 
    salesman_city varchar2(20), 
   commission int 
);

INSERT INTO salesman 
VALUES ( 5001, James Hoog, New York, 15) 
    VALUES ( 5002, Nail Knite, Paris, 13);

INSERT INTO salesman 
VALUES ( 5001, James Hoog, New York, 15), 
    VALUES ( 5002, Nail Knite, Paris, 13);

INSERT INTO salesman 
VALUES ( 5001, James Hoog, New York, 15), 
 ( 5002, Nail Knite, Paris, 13);

INSERT INTO salesman 
VALUES ( 5001, James Hoog, New York, 15,), 
 ( 5002, Nail Knite, Paris, 13,);

INSERT INTO salesman 
VALUES (5001, James Hoog, New York, 15, 5002, Nail Knite, Paris, 13);

INSERT INTO salesman 
VALUES (5001, James Hoog, New York, 15, 5002, Nail Knite, Paris, 13);

INSERT INTO salesman (salesman_id, salesman_name, salesman_city, commission) 
VALUES (5001, James Hoog, New York, 15,);

INSERT INTO salesman (salesman_id, salesman_name, salesman_city, commission) 
VALUES (5001, "James Hoog", "New York", 15,);

INSERT INTO salesman (salesman_id, salesman_name, salesman_city, commission) 
VALUES (5001, 'James Hoog', 'New York', 15,);

INSERT INTO salesman (salesman_id, salesman_name, salesman_city, commission) 
VALUES (5001, 'James Hoog', 'New York', 15);

select * from salesman;

INSERT INTO salesman (salesman_id, salesman_name, salesman_city, commission)  
VALUES (5002, 'Nail Knite', 'Paris', 13);

INSERT INTO salesman (salesman_id, salesman_name, salesman_city, commission)  
VALUES (5005, 'Pit Alex', 'London', 11);

INSERT INTO salesman (salesman_id, salesman_name, salesman_city, commission)  
VALUES (5006, 'McLyon', 'Paris', 14);

INSERT INTO salesman (salesman_id, salesman_name, salesman_city, commission)  
VALUES (5007, 'Paul Adam', 'Rome', 13);

INSERT INTO salesman (salesman_id, salesman_name, salesman_city, commission)  
VALUES (5003, 'Lauson Hen', 'San Jose', 12);

INSERT INTO salesman (salesman_id, salesman_name, salesman_city, commission)  
VALUES (5003, 'Lauson Hen', 'San Jose', 12);

select * from Salesman table;

select * from salesman table;

select * from salesman table;

select * from salesman table;

INSERT INTO salesman (salesman_id, salesman_name, salesman_city, commission)  
VALUES (5002, 'Nail Knite', 'Paris', 13,);

SELECT * FROM salesman;

