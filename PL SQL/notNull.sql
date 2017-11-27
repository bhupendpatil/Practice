set serveroutput on;

declare
  x number := 1 ;
  y number;
begin
  if x is not null
    then dbms_output.put_line('x is not null');
  else
    dbms_output.put_line('y is not null');
  end if;
end;
/