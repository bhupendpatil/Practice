--Assume that you have table employee with column id and name

set serveroutput on;

declare
  a number;
begin
  select id into a from employee where id=1 or id = 3;
exception
  when too_many_rows then
    dbms_output.put_line('too many rows found nigga');
end;
/