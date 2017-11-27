set serveroutput on;

declare
  i number;
begin
  for i in 1..10 loop
  	dbms_output.put_line(i);
    if i = 5 then
      exit;
    end if;
  end loop;
end;
/