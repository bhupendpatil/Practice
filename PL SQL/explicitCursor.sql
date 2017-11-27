--Assume we have table named employee with id, first_name and last_name

set serveroutput on;

declare
  firstname employee.first_name%type;
  lastname employee.last_name%type;
  department employee.department_no%type;
  Cursor emp(firstname firstname%type) is 
    select first_name, last_name, department_no from employee where first_name=firstname;
begin
  open emp('ABC');
  fetch emp into firstname, lastname, department;
  dbms_output.put_line(' Name: '|| firstname || ' ' || lastname || ' , DepartmentNo. ' || department);
  close emp;
end;
/