set serveroutput on;

declare
  x number;
  y number;
begin
  x := '3'; --varchar2  datatype
  y := 3;
  dbms_output.put_line(x+y);
end;
/