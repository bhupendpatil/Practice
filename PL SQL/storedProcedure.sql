set serveroutput on;

create or replace procedure additionOfTwoAndOne
is
 a number:= 1;
 b number:= 2;
begin
  dbms_output.put_line(a+b);
end;
/