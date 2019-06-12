set serveroutput on;

declare
  x number(10);
  y number(10);
  div number(10,2);
begin
  x:=&number1;
  y:=&number2;
  div:=x/y;
  dbms_output.put_line('The outer quotient is '||div);
exception
  when zero_divide then
    dbms_output.put_line('Divide by zero not allowed');
end;
/