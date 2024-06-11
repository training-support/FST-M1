REM   Script: Activity1,2,3,4,5
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

