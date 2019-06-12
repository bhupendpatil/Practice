set serveroutput on;

declare
  i number := 0;
  a number := 10;
begin
  loop
    dbms_output.put_line(i);
    i :=  i + 1;
    exit when i > a;
  end loop;
end;
/