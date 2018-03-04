set serveroutput on;

declare
  lv_sql varchar2(500);
  ln_fname varchar2(50);
  ln_lname varchar2(50);
  ln_salary number(10,2);
  ln_department number;
begin
  lv_sql := 'SELECT first_name, last_name, salary, department_no FROM employee WHERE department_no=:department_no';
  EXECUTE IMMEDIATE lv_sql into ln_fname, ln_lname, ln_salary, ln_department using 24;
  dbms_output.put_line('Employee Name: '||ln_fname||' '||ln_lname);
  dbms_output.put_line('Employee Salary: '||ln_salary);
  dbms_output.put_line('Department number: '||ln_department);
end;
/