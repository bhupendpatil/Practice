--Assume that you have table employee with column id and name and id 10 has no value

set serveroutput on;

declare
  a number;
begin
  select id into a from employee where id=10;
exception
  when no_data_found then
    dbms_output.put_line('no value found nigga');
end;
/