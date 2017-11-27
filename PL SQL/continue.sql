set serveroutput on;

declare
  i number;
begin
  for i in 1..10 loop
    if i = 5 or i = 7 then
      dbms_output.put_line(i);
      continue;
    end if;
  end loop;
end;
/