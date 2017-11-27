set serveroutput on;

create or replace function functionThree 
	return number
is
  a number:=1;
  b number:=2;
  c number;
begin
  c:= a+b;
  return c;
end;
/