create table suppliers(id int, first_name varchar2(10), last_name varchar2(10), salary decimal(10,2), department_no int);

insert into suppliers values(1, 'ABC', 'CBA', 232.1, 50);
insert into suppliers values(2, 'DEF', 'FED', 2323.12, 60);
insert into suppliers values(3, 'GHI', 'IHG', 23132.1, 70);
insert into suppliers values(4, 'JKL', 'LKJ', 2326.1, 80);
insert into suppliers values(5, 'NOP', 'PON', 5232.1, 90);


set serveroutput on;

declare
  a binary_integer := 5;
begin
  while a <= 50
  loop
    insert into suppliers (id) values (a);
    a := a + 1;
  end loop;
end;
/
