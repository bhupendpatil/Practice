set serveroutput on;

declare
  aIsSmall exception;
  aIsBig exception;
  a number := 1;
  b number := 2;
begin
  begin
    if a < b then
      raise aIsSmall;
    else
      raise aIsBig;
    end if;
  exception
    when aIsBig then
      dbms_output.put_line('a is big');
  end;
exception
  when aIsSmall then
    dbms_output.put_line('a is small');
end;
/
    