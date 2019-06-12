set serveroutput on;

declare
  i number;
  x number;
  a number;
  
begin
  x:=&x;
  a:=1;
  for i in 1..x loop
    a:= a*i;
  end loop;
  dbms_output.put_line(a);
end;
/