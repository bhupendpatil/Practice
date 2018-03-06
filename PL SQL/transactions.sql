--Study of transactions and locks

--Commit
--COMMIT

create table employee(id int, first_name varchar2(10), last_name varchar2(10), salary decimal(10,2), department_no int);

insert into employee values(1, 'ABC', 'CBA', 232.1, 50);
insert into employee values(2, 'DEF', 'FED', 2323.12, 60);
insert into employee values(3, 'GHI', 'IHG', 23132.1, 70);
insert into employee values(4, 'JKL', 'LKJ', 2326.1, 80);
insert into employee values(5, 'NOP', 'PON', 5232.1, 90);
insert into employee values(6, 'QRS', 'SRQ', 23223.2, 23);
insert into employee values(7, 'TUV', 'VUT', 23121.1, 24);
insert into employee values(8, 'WXY', 'YXW', 50282.2, 45);

commit;

--Savepoint
--SAVEPOINT < savepoint_name >;

savepoint inserted8;

insert into employee values(9, 'ZAB', 'BAZ', 7698.2, 21);
insert into employee values(10, 'CDE', 'EDC', 502888.2, 60);
insert into employee values(11, 'FGH', 'HGF', 54350.2, 15);
insert into employee values(12, 'IJK', 'KJI', 76879.2, 60);

savepoint inserted12;

update employee set salary = salary+10 where department_no = 60;

savepoint updatedSalary60;

--Rollback
--ROLLBACK [TO SAVEPOINT < savepoint_name>]
--If no savepoints then use only ROLLBACK;

rollback to savepoint inserted12;

rollback to savepoint updatedSalary60;
  
--Lock
--LOCK TABLE [TABLE NAME] IN [LOCK MODE] [WAIT | NOWAIT]