set serveroutput on;

declare
  x number := 1;
  y number := 2;
begin
  dbms_output.put_line('value of outer x is '||x);
  dbms_output.put_line('value of outer y is '||y);
  begin
    y := 4;
    dbms_output.put_line('value of inner x is '||x);
    dbms_output.put_line('value of inner y is '||y);
  end;
end;
/