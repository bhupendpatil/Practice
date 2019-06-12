-- XML Database

-- Creating Table
-- Inserting Values into "predetor"
-- Queries
-- 	1) Retrieve the name of employee from predator table.
-- 	2) Retrieve the acc_no of employee from predator table.
-- 	3) Retrieve the names, acc_no, email of employee from predator table.
-- Updating XML type
-- Deleting XML type


-- Creating Table
Create table predetor(dept_id NUMBER(3),employee_spec XMLTYPE);

-- Inserting Values into "predator"
INSERT INTO predetor VALUES 
    (100, XMLType(
        '<employees>
            <emp id="1">
            	<name>Sachin Yelmar</name>
            	<email>sachinyelmar@rediffmail.com</email>
            	<acc_no>111</acc_no>
            	<dateOfJoining>1994-11-16</dateOfJoining>
            </emp>
		</employees>'));

INSERT INTO predetor VALUES 
	(200, XMLType(
    	'<employees>
        	<emp id="2">
            	<name>Aditya Nakhare</name>
            	<email>aditya1811@yahoo.com</email>
            	<acc_no>222</acc_no>
        		<dateOfJoining>1992-12-24</dateOfJoining>
    		</emp>
    	</employees>'));

INSERT INTO predetor VALUES 
	(300, XMLType(
		'<employees>
        	<emp id="3">
            	<name>Dhiraj Dhabi</name>
            	<email>dhiraj@yahoo.co.in</email>
            	<acc_no>333</acc_no>
            	<dateOfJoining>1993-08-19</dateOfJoining>
        	</emp>
    	</employees>'));

-- Queries
-- 	1) Retrieve the name of employee from predator table.
SELECT w.employee_spec.extract('/employees/emp/name/text()').getStringVal()"name" FROM predetor w;

-- 	2) Retrieve the acc_no of employee from predator table.
SELECT w.employee_spec.extract('/employees/emp/acc_no/text()').getStringVal() "acc_no" FROM predetor w;

-- 	3) Retrieve the names, acc_no, email of employee from predator table.
SELECT w.employee_spec.extract('/employees/emp/name/text()').getStringVal() "name",
       w.employee_spec.extract('/employees/emp/acc_no/text()').getStringVal()  "acc_no",
       w.employee_spec.extract('/employees/emp/email/text()').getStringVal() "email"
	FROM predetor w;


-- Updating XML type
UPDATE predetor w 
	set employee_spec = XMLType
    	('<employees>
        	<emp id="5">
                <name>korth</name>
        	</emp>
    	</employees>')
	WHERE w.employee_spec.extract('//acc_no/text()').getStringVal() = '222';

-- 	checking
SELECT w.employee_spec.extract('/employees/emp/name/text()').getStringVal() "name"         
	FROM predetor w;


-- Deleting XML type
DELETE from predetor w 
	WHERE w.employee_spec.extract('/employees/emp/acc_no/text()').getStringVal() = '111';

-- 	checking
SELECT w.employee_spec.extract('/employee/emp/acc_no/text()').getStringVal() "acc_no"
   FROM predetor w;