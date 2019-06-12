--Package 2

--Assume table customer
--+----+----------+-----+-----------+----------+ 
--| ID | NAME     | AGE | ADDRESS   | SALARY   | 
--+----+----------+-----+-----------+----------+ 
--|  1 | Ramesh   |  32 | Ahmedabad |  3000.00 | 
--|  2 | Khilan   |  25 | Delhi     |  3000.00 | 
--|  3 | kaushik  |  23 | Kota      |  3000.00 | 
--|  4 | Chaitali |  25 | Mumbai    |  7500.00 | 
--|  5 | Hardik   |  27 | Bhopal    |  9500.00 | 
--|  6 | Komal    |  22 | MP        |  5500.00 | 
--+----+----------+-----+-----------+----------+ 

--Package Specification
CREATE OR REPLACE PACKAGE c_package AS 
   -- Adds a customer 
   PROCEDURE addCustomer(c_id   customers.id%type, 
   c_name  customerS.No.ame%type, 
   c_age  customers.age%type, 
   c_addr customers.address%type,  
   c_sal  customers.salary%type); 
   
   -- Removes a customer 
   PROCEDURE delCustomer(c_id  customers.id%TYPE); 
   
   --Lists all customers 
   PROCEDURE listCustomer; 
  
END c_package; 
/

--Creating Package Body
CREATE OR REPLACE PACKAGE BODY c_package AS 
   PROCEDURE addCustomer(c_id  customers.id%type, 
      c_name customerS.No.ame%type, 
      c_age  customers.age%type, 
      c_addr  customers.address%type,  
      c_sal   customers.salary%type) 
   IS 
   BEGIN 
      INSERT INTO customers (id,name,age,address,salary) 
         VALUES(c_id, c_name, c_age, c_addr, c_sal); 
   END addCustomer; 
   
   PROCEDURE delCustomer(c_id   customers.id%type) IS 
   BEGIN 
      DELETE FROM customers 
      WHERE id = c_id; 
   END delCustomer;  
   
   PROCEDURE listCustomer IS 
   CURSOR c_customers is 
      SELECT  name FROM customers; 
   TYPE c_list is TABLE OF customerS.Name%type; 
   name_list c_list := c_list(); 
   counter integer :=0; 
   BEGIN 
      FOR n IN c_customers LOOP 
      counter := counter +1; 
      name_list.extend; 
      name_list(counter) := n.name; 
      dbms_output.put_line('Customer(' ||counter|| ')'||name_list(counter)); 
      END LOOP; 
   END listCustomer;
   
END c_package; 
/

--Using the package
DECLARE 
   code customers.id%type:= 8; 
BEGIN 
   c_package.addcustomer(7, 'Rajnish', 25, 'Chennai', 3500); 
   c_package.addcustomer(8, 'Subham', 32, 'Delhi', 7500); 
   c_package.listcustomer; 
   c_package.delcustomer(code); 
   c_package.listcustomer; 
END; 
/  

--OUTPUT
--Customer(1): Ramesh  
--Customer(2): Khilan  
--Customer(3): kaushik     
--Customer(4): Chaitali  
--Customer(5): Hardik  
--Customer(6): Komal 
--Customer(7): Rajnish 
--Customer(8): Subham 
--Customer(1): Ramesh  
--Customer(2): Khilan  
--Customer(3): kaushik     
--Customer(4): Chaitali  
--Customer(5): Hardik  
--Customer(6): Komal
--Customer(7): Rajnish 

--PL/SQL procedure successfully completed 
