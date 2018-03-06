--Package 1

--Assume table customer
--+----+----------+-----+-----------+----------+ 
--| ID | NAME     | AGE | ADDRESS   | SALARY   | 
--+----+----------+-----+-----------+----------+ 
--|  1 | Ramesh   |  32 | Ahmedabad |  2000.00 | 
--|  2 | Khilan   |  25 | Delhi     |  1500.00 | 
--|  3 | kaushik  |  23 | Kota      |  2000.00 | 
--|  4 | Chaitali |  25 | Mumbai    |  6500.00 | 
--|  5 | Hardik   |  27 | Bhopal    |  8500.00 | 
--|  6 | Komal    |  22 | MP        |  4500.00 | 
--+----+----------+-----+-----------+----------+ 

--Creating Package
CREATE PACKAGE cust_sal AS 
   PROCEDURE find_sal(c_id customers.id%type); 
END cust_sal; 
/

--Package body
CREATE OR REPLACE PACKAGE BODY cust_sal AS  
  PROCEDURE find_sal(c_id customers.id%TYPE) IS 
  c_sal customers.salary%TYPE; 
  BEGIN 
    SELECT salary INTO c_sal 
    FROM customers 
    WHERE id = c_id; 
    dbms_output.put_line('Salary: '|| c_sal); 
  END find_sal; 
END cust_sal; 
/

--Using package element
DECLARE 
   code customers.id%type := &cc_id; 
BEGIN 
   cust_sal.find_sal(code); 
END; 
/

--OUTPUT
--Enter value for cc_id: 1 
--Salary: 3000 

--PL/SQL procedure successfully completed. 
