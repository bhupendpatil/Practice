-- Creating replica of Database

-- Global Schema Employee(Eno;Ename;Address;Email;Salary)
-- insert 10 records
-- Store the replication of emp in 2 different nodes
-- Fire the 4 Queries
-- 1. Find the salary of all employees.
-- 2. Find the email of all employees where salary=15000.
-- 3. Find the employee name and email where employee number is known.
-- 4. Find the employee name and address where employee number is known.

-- Global Schema Employee(Eno;Ename;Address;Email;Salary)
create table Employee(Eno numeric(6),Ename varchar2(10),Address varchar2(10),Email varchar2(20),Salary numeric(6));

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

--if there is no user make one
create user msc1 identified by msc1;
create user msc2 identified by msc2;
create user msc3 identified by msc3;
-- give them privileges
grant all privileges to msc1 identified by msc1;
grant all privileges to msc2 identified by msc2;
grant all privileges to msc3 identified by msc3;

-- Store the replication of emp in 2 different nodes

-- connect to msc1
connect msc1/msc1@xe;
-- EmppI
create database link linkdb1 connect to scott identified by tiger using 'xe';

create table EmppI as (select * from Employee@linkdb1);

-- connect to msc2
connect msc2/msc2@xe;

-- create a replica link
create database link linkdb3 connect to msc1 identified by msc1 using 'xe';

-- Fire the 4 Queries

-- 1. Find the salary of all employees.
select salary,ename from EmppI@linkdb3;

-- 2. Find the email of all employees where salary=15000.
select email from EmppI@linkdb3 where salary=15000;

-- 3. Find the employee name and email where employee number is known.
select ename,email from EmppI@linkdb3 where eno='&eno';

-- 4. Find the employee name and address where employee number is known.
select ename,address from EmppI@linkdb3 where eno='&eno';
