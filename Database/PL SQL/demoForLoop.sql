set serveroutput on;

declare
  x number;
begin
  for x in 1..10
  loop
    dbms_output.put_line(x);
  end loop;
end;
/