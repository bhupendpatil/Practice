-- Assume Table
--    ID FIRST_NAME LAST_NAME      SALARY         DEPARTMENT_NO
-------- ---------- ---------- ---------- ---------------------
--     1 ABC        CBA             232.1                    50
--     2 DEF        FED           2323.12                    60
--     3 GHI        IHG           23132.1                    70
--     4 JKL        LKJ            2326.1                    80
--     5 NOP        PON            5232.1                    90
--     6 QRS        SRQ           23223.2                    23
--     7 TUV        VUT           23121.1                    24
--     8 WXY        YXW           50282.2                     4

--Dynamic SQL: Use of DBMS_SQL package to write Dynamic SQL
--Using the EXECUTE IMMEDIATE Statement

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

--OUTPUT
--PL/SQL procedure successfully completed.

--Employee Name: TUV VUT
--Employee Salary: 23121.1
--Department number: 24