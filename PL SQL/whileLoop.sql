set serveroutput on;

declare
  i number := 0;
  a number := 10;
begin
  while i <= a loop
    dbms_output.put_line(i);
    i := i + 1;
  end loop;
end;
/