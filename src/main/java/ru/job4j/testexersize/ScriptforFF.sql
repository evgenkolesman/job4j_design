select c.name, acc_number, sum(amount) from customer c join Account on c.id = customer_id, 
a join fin_transaction f on a.id = Account_id where avv_number like '45204%'