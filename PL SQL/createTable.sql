create table employee(id int, first_name varchar2(10), last_name varchar2(10), salary decimal(10,2), department_no int);

insert into employee values(1, 'ABC', 'CBA', 232.1, 50);
insert into employee values(2, 'DEF', 'FED', 2323.12, 60);
insert into employee values(3, 'GHI', 'IHG', 23132.1, 70);
insert into employee values(4, 'JKL', 'LKJ', 2326.1, 80);
insert into employee values(5, 'NOP', 'PON', 5232.1, 90);
insert into employee values(6, 'QRS', 'SRQ', 23223.2, 23);
insert into employee values(7, 'TUV', 'VUT', 23121.1, 24);
insert into employee values(8, 'WXY', 'YXW', 50282.2, 45);

Select * from employee;