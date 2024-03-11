REM   Script: Activity3
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

