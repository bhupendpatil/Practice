
-- Global Schema Employee(Eno;Ename;Address;Email;Salary)
-- insert 10 records
-- divide Emp into vertical fragments 
-- Emp1(Eno;Ename;Address)
-- and 
-- Emp2(Eno;Email;Salary)
-- on two different nodes.
-- Fire the 4 Queries
-- 1. Find the salary of an employee where employee number is unknown
-- 2. Find the Email where the employee name is unknown
-- 3. Find the employee name and Email where employee number is unknown
-- 4. Find the employee name whose salary is > 2000


-- Global Schema Employee(Eno;Ename;Address;Email;Salary)
create table Employee(Eno numeric(6),Ename varchar2(50),Address varchar2(50),Email varchar2(20),Salary numeric(6));

-- insert 10 records
insert into Employee values(101,'Steve','Nerul','steve@gmail.com',20000);
insert into Employee values(102,'Matt','Vashi','matt@gmail.com',10000);
insert into Employee values(103,'Bob','Vashi','bob@gmail.com',15000);
insert into Employee values(104,'Alice','Bandra','alice@gmail.com',19000);
insert into Employee values(105,'Smith','Colaba','smith@gmail.com',25000);
insert into Employee values(106,'Jones','Colaba','jones@gmail.com',29000);
insert into Employee values(107,'George','Panvel','george@gmail.com',11000);
insert into Employee values(108,'Nina','Thane','nina@gmail.com',16000);
insert into Employee values(109,'John','Thane','john@gmail.com',22000);
insert into Employee values(110,'Paul','Airoli','paul@gmail.com',30000);

--if there is no user make make one
create user msc1 identified by msc1;
create user msc2 identified by msc2;
create user msc3 identified by msc3;
-- give them privileges
grant all privileges to msc1 identified by msc1;
grant all privileges to msc2 identified by msc2;
grant all privileges to msc3 identified by msc3;

-- divide Emp into vertical fragments

-- connect to msc1
connect msc1/msc1@orcl;
-- Emp1(Eno;Ename;Address)
-- create a 1st link
create database link Linkm1 connect to scott identified by tiger using 'orcl';

create table Employee1 as select Eno,Ename,Address from Employee@Linkm1;

-- connect to msc2
connect msc2/msc2@orcl;
-- Emp2(Eno;Email;Salary)
-- create a 2nd link
create database link Linkm2 connect to scott identified by tiger using 'orcl';

create table Employee2 as select Eno,Email,Salary from Employee@Linkm2;


-- on two different nodes

-- connect to msc3
connect msc3/msc3@orcl;
--creating 2 different links
create database link linkmsc1 connect to msc1 identified by msc1 using 'orcl';

create database link linkmsc2 connect to msc2 identified by msc2 using 'orcl';



-- Fire the 4 Queries

-- 1. Find the salary of an employee where employee number is unknown
select salary from Employee2@linkmsc2 where Eno='&Eno';

-- 2. Find the Email where the employee name is unknown
select email from Employee2@linkmsc2 where Eno = (select Eno from Employee1@linkmsc1 where Ename='&Ename');

-- 3. Find the employee name and Email where employee number is unknown
select a.Ename,b.Email from Employee1@linkmsc1 a, Employee2@linkmsc2 b where a.Eno=b.Eno and b.Eno='&Eno';

-- 4. Find the employee name whose salary is > 2000
select a.Ename from Employee1@linkmsc1 a, Employee2@linkmsc2 b where a.Eno=b.Eno and b.Salary>2000;