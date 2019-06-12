set serveroutput on;

declare
  x char := '1';
  y number := 2;
  a number;
  b number;
begin
  a := to_number(x);
  b := y;
  dbms_output.put_line(a+b);
end;
/