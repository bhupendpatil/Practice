--assume that you have a table employee with columns name, salary, id 

set serveroutput on;

declare
  a number;
begin
  update employee
  set salary = salary + 150;
  if sql%notfound then
    dbms_output.put_line('none selected');
  elsif sql%found then
    a := sql%rowcount;
    dbms_output.put_line(a||' rows selected');
  end if;
end;
/