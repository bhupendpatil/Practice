set serveroutput on;

declare
  x number;
  y x%type;
begin
  x := 1;
  y := 2;
  dbms_output.put_line(x+y);
end;
/