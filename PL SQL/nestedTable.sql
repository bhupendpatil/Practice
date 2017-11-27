set serveroutput on;

declare
	type nested_table is table of number;
  	x nested_table;
begin
	x := nested_table(23,23,42,23,5,5,353,5,2,34);
  	for i in 1..x.count
  	loop
    	dbms_output.put_line(x(i));
  	end loop;
end;
/