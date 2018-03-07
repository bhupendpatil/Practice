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
--function and procedure of package (OPEN_CURSOR, PARSE, BIND_VARIABLE,
--EXECUTE, FETCH_ROWS, CLOSE_CURSOR)



set serveroutput on;

declare
  lv_sql varchar2(500);
  ln_fname varchar2(50);
  ln_lname varchar2(50);
  ln_salary number(10,2);
  ln_department number;
  ln_cursor_id number;
  ln_rows_processed number;
begin
  lv_sql := 'SELECT first_name, last_name, salary, department_no FROM employee WHERE department_no=:department_no';
  ln_cursor_id := dbms_sql.open_cursor;
  dbms_sql.parse(ln_cursor_id,lv_sql,dbms_sql.native);
  dbms_sql.bind_variable(ln_cursor_id,':department_no',24);
  
  dbms_sql.define_column(ln_cursor_id,1,ln_fname,50);
  dbms_sql.define_column(ln_cursor_id,2,ln_lname,50);
  dbms_sql.define_column(ln_cursor_id,3,ln_salary);
  dbms_sql.define_column(ln_cursor_id,4,ln_department);
  
  ln_rows_processed:=dbms_sql.execute(ln_cursor_id);
  
  loop
    if dbms_sql.fetch_rows(ln_cursor_id)=0 then
      exit;
    else
      dbms_sql.column_value(ln_cursor_id,1,ln_fname);
      dbms_sql.column_value(ln_cursor_id,2,ln_lname);
      dbms_sql.column_value(ln_cursor_id,3,ln_salary);
      dbms_sql.column_value(ln_cursor_id,4,ln_department);
    
      dbms_output.put_line('Employee Name: '||ln_fname|| ' ' ||ln_lname);
      dbms_output.put_line('Employee Salary: '||ln_salary);
      dbms_output.put_line('Department number: '||ln_department);
    end if;
    end loop;
    
    dbms_sql.close_cursor(ln_cursor_id);
end;
/

--OUTPUT
--PL/SQL procedure successfully completed.

--Employee Name: TUV VUT
--Employee Salary: 23121.1
--Department number: 24
