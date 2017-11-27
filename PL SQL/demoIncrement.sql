set serveroutput on;

begin
  update employee set DEPARTMENT_NO = DEPARTMENT_NO + 10;
end;