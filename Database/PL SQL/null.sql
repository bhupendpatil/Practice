set serveroutput on;

declare
  x number := 1 ;
  y number;
begin
  if x is null
    then dbms_output.put_line('x is null');
  else
    dbms_output.put_line('y is null');
  end if;
end;
/