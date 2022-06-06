select sum(purchase_amount) as "Total Amount" from orders;

select AVG(purchase_amount) as "Average Amount" from orders;

select MAX(purchase_amount) as "Maximum Purchase Amount" from orders;

select MIN(purchase_amount) as "Mininum Purchase Amount" from orders;

select count(distinct Salesman_id) as "Total salesman" from orders;