--Trigger

--Assume table
--Select * from customers;  

--+----+----------+-----+-----------+----------+ 
--| ID | NAME     | AGE | ADDRESS   | SALARY   | 
--+----+----------+-----+-----------+----------+ 
--|  1 | Ramesh   |  32 | Ahmedabad |  2000.00 | 
--|  2 | Khilan   |  25 | Delhi     |  1500.00 | 
--|  3 | kaushik  |  23 | Kota      |  2000.00 | 
--|  4 | Chaitali |  25 | Mumbai    |  6500.00 | 
--|  5 | Hardik   |  27 | Bhopal    |  8500.00 | 
--|  6 | Komal    |  22 | MP        |  4500.00 | 
--+----+----------+-----+-----------+----------+ 

--Insert/Update/Delete Trigger
--Before Trigger

create or replace trigger displayChange before
delete or insert or update on customers
for each row
declare
  differ number;
begin
  differ := new.salary - old.salary;
  dbms_output.put_line('old salary '||old.salary);
  dbms_output.put_line('new salary '||new.salary);
  dbms_output.put_line('salary difference '||differ);
end;
/
--OUTPUT
--Trigger created

--Triggering a trigger
insert into customer (id,name,age,address,salary) 
values (7, 'Noone', 22, 'MH', 2333.00 );
--OUTPUT
--Old salary: 
--New salary: 2333.00 
--Salary difference:

--After Trigger
create or replace trigger displayInsertChange after
insert on customers
for each row
begin
  dbms_output.put_line('Inserted new values in table :)');
end;
/
--Triggering a trigger
insert into customer (id,name,age,address,salary) 
values (8, 'Noone', 22, 'MH', 2333.00 );
--OUTPUT
--Inserted new values in table :)

--Remove Trigger
Drop trigger displayChange;
Drop trigger displayInsertChange;