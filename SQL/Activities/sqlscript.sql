REM   Script: All_Activity
REM   Insert data in to New DB

create table testing_Group (firstname varchar(32),lastname varchar(52));

create table testing_Group1 (firstname varchar(32),lastname varchar(52));

create table testing_Group1 (firstname varchar(32),lastname varchar(52));

delete table testing_Group1;

delete table testing_Group1;

select * from testing_Group1;

create table testing_Group1 (firstname varchar(32),lastname varchar(52));

delete table testing_Group1;

select * from testing_Group;

desc testing_Group


create table testing_Group1 (firstname varchar(32),lastname varchar(52));

delete table testing_Group1;

select * from testing_Group;

desc testing_Group


CREATE table salesman (salesman_id int ,salesman_name varchar2(20),salesman_city varchar2(20),commission int);

CREATE table salesman (salesman_id int ,salesman_name varchar2(20),salesman_city varchar2(20),commission int);

select * from salesman;

desc salesman


CREATE table salesman (salesman_id int ,salesman_name varchar2(20),salesman_city varchar2(20),commission int);

select * from salesman;

desc salesman


INSERT INTO salesman VALUES(0001, 'Basi', 'Gun', 10);

INSERT INTO salesman VALUES(0001, 'Basi', 'Gun', 10);

INSERT ALL 
    INTO salesman VALUES(0002, 'Ram', 'Gurazala', 11) 
    INTO salesman VALUES(0003, 'raja', 'Gun', 14) 
    INTO salesman VALUES(0004, 'Gopi', 'Hyd', 13) 
    INTO salesman VALUES(0005, 'Akki', 'Bang', 12);

INSERT ALL 
    INTO salesman VALUES(0002, 'Ram', 'Gurazala', 11) 
    INTO salesman VALUES(0003, 'raja', 'Gun', 14) 
    INTO salesman VALUES(0004, 'Gopi', 'Hyd', 13) 
    INTO salesman VALUES Select;

INSERT ALL 
    INTO salesman VALUES(0002, 'Ram', 'Gurazala', 11) 
    INTO salesman VALUES(0003, 'raja', 'Gun', 14) 
    INTO salesman VALUES(0004, 'Gopi', 'Hyd', 13) 
    INTO salesman VALUES(0005, 'Akki', 'Bang', 12) Select ;

Select * from salesman;

delete  from salesman where Salesmaqn_name='Basi';

delete  from salesman where Salesman_name='Basi';

INSERT ALL 
    INTO salesman VALUES(0001, 'Basi', 'Gurazala', 10) 
    INTO salesman VALUES(0002, 'Ram', 'Gurazala', 11) 
    INTO salesman VALUES(0003, 'raja', 'Gun', 14) 
    INTO salesman VALUES(0004, 'Gopi', 'Hyd', 10) 
    INTO salesman VALUES(0005, 'Akki', 'Bang', 12) SELECT 1 FROM DUAL ;

Select * from salesman;

DEsc salesman


 Select SALESMAN_ID,SALESMAN_CITY from salesman;

select * from salesman where SALESMAN_CITY='Gurazala';

 Select * from SALESMAN_ID,COMMISSION from salesman where SALESMAN_NAME='Ram';

select * from salesman where SALESMAN_CITY='Gurazala';

 Select * from SALESMAN_ID,COMMISSION from salesman  
    where SALESMAN_NAME='Ram';

Select * from SALESMAN_ID,COMMISSION from salesman  
    where salesman_name='Ram';

 DEsc salesman


Select SALESMAN_ID,SALESMAN_CITY from salesman;

    select * from salesman where SALESMAN_CITY='Gurazala';

    Select * from SALESMAN_ID,COMMISSION from salesman  
    where SALESMAN_NAME='Ram';

Select * from SALESMAN_ID,COMMISSION from salesman;

 Select SALESMAN_ID,SALESMAN_CITY from salesman;

    select * from salesman where SALESMAN_CITY='Gurazala';

    Select  SALESMAN_ID,COMMISSION from salesman  
    where SALESMAN_NAME='Ram';

Alter salesman add grade int;

Alter table salesman add grade int;

update salesman set grade='100';

select * from salesman;

update salesman set grade='90' where SALESMAN_NAME ='Basi';

    select * from salesman;

    update salesman set grade='80' where SALESMAN_NAME ='Ram';

    select * from salesman;

update salesman set grade='70' where SALESMAN_NAME ='raja';

    update salesman set grade='60' where SALESMAN_NAME ='Gopi';

select * from salesman;

update salesman set SALESMAN_NAME='reddy' where SALESMAN_NAME='raja';

 select * from salesman;

select * from  salesman order BY SALESMAN_NAME,COMMISSION;

select * from  salesman order BY SALESMAN_NAME ACS, COMMISSION DSCE ;

select * from  salesman order BY SALESMAN_NAME ASC, COMMISSION DESC ;

select DISTINCT salesman where COMMISSION;

select DISTINCT from salesman where COMMISSION;

select DISTINCT  salesman from  COMMISSION;

 select DISTINCT  COMMISSION from salesman ;

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

select * from salesman;

select DISTINCT  SALESMAN_ID from salesman;

select * from salesman;

select DISTINCT  SALESMAN_ID from salesman;

select DISTINCT  SALESMAN_ID from orders;

select order_no,order_date date order By order ASC;

select order_no,order_date date order By  from order ASC;

select order_no,order_date  from orders order By order_date;

select DISTINCT  SALESMAN_ID from orders;

# Display the order number ordered by date in ascending order 


select order_no,order_date  from orders order By order_date;

# Display the order number ordered by purchase amount in descending order 


select order_no, purchase_amount from orders order by purchase_amount DESC;

# Display the full data of orders that have purchase amount less than 500. 


select * from orders where purchase_amount < 500;

# Display the full data of orders that have purchase amount between 1000 and 2000. 


select * from orders where purchase_amount between 1000 and 2000;

