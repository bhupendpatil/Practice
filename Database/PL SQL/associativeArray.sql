set serveroutput on;

declare
	type asso_array is table of number
    index by binary_integer;
  x asso_array;
begin
	x(1) := 10;
  x(2) := 2;
  x(3) := 4;
  x(4) := 5;
  
  for i in 1..4
  loop
    dbms_output.put_line('on index ' || i || ' = '||x(i));
  end loop;
end;
/