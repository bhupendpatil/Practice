--Assume we have table named employee with id, first_name and last_name

set serveroutput on;

declare
  firstname employee.first_name%type;
  lastname employee.last_name%type;
  department employee.department_no%type;
  Cursor emp(firstname varchar2) is 
    select * from employee where first_name=firstname;
begin
  open emp();
  loop
    fetch emp into firstname, lastname, department;
      exit when emp%notfound;
      dbms_output.put_line(' Name: '|| firstname || ' ' || lastname || ' , DepartmentNo. ' || department);
  end loop;
  close emp;
end;
/