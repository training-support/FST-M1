/*Activity4*/

ALTER TABLE salesman ADD grade int;
UPDATE salesman SET grade=100;
SELECT * FROM salesman;

/*Activity5*/
UPDATE salesman SET grade=200 WHERE salesman_city='Rome';
UPDATE salesman SET grade=300 WHERE salesman_name='Nail Knite';
UPDATE salesman SET salesman_name='Pierre' WHERE salesman_name='McLyon';
SELECT * FROM salesman;