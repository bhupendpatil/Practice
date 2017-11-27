--Create a sequence first
--create sequence seq start with 1 increment by 1;



set serveroutput on;

declare
  x number;
begin
  x:=seq.nextval;
  dbms_output.put_line('sequence value = '||x);
end;
/

--drop a sequence
--drop sequence seq;