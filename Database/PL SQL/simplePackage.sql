-- Package

create or replace PACKAGE math is 
  x number := 10;
  y number := 20;
end math;
/ 

-- Program

set serveroutput on;
declare
  a number;
  b number;
begin
  a := math.x;
  b := math.y;
  dbms_output.put_line(a+b);
end;
/

-- drop

drop package math;