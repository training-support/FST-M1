REM   Script: Activity2
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

