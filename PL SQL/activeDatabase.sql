-- Active Database

-- Create table bunty(eno;ename;hrs;pno;super_no) 
-- Create table kantekar(pname;pno;thrs;head_no)

-- Insert 5 tuples and write triggers to do the following:
-- a)Creating a trigger to insert new employee tuple and display the new total hours from project table.
-- b)Creating a trigger to change the hrs of existing employee and display the new total hours from project table.
-- c)Creating a trigger to change the project of an employee and display the new total hours from project table.
-- d)Creating a trigger to delete the project of an employee.


-- Create table bunty(eno;ename;hrs;pno;super_no) 
create table bunty(
	eno number(8) primary key,
	ename varchar(20),
	hrs number(8),
	pno number(8),
	super_no  number(8)CONSTRAINT sup0225 UNIQUE
);

-- Insert Values
insert into bunty values(1,'Pooja',7,10,1001);
insert into bunty values(2,'Priya',5,20,1002);
insert into bunty values(3,'Radha',3,10,1003);
insert into bunty values(4,'Nilam',1,20,1004);
insert into bunty values(5,'Supriya',5,30,1005);


-- Create table kantekar(pname;pno;thrs;head_no)
create table katekar(	
	pno number(8) primary key,
	pname varchar(20),
	thrs number(8),
	super_no number(8) CONSTRAINT supfk0225 references bunty(super_no)
);

-- Insert Values
insert into katekar values(10,'VB',10,1001);
insert into katekar values(20,'JAVA',6,1002);
insert into katekar values(30,'sORACLE',5,1005);

-- Insert 5 tuples and write triggers to do the following:

-- a)Creating a trigger to insert new employee tuple and display the new total hours from project table.
create or replace Trigger QBT
 	after insert on bunty for each row
	when(New.pno IS NOT NULL)
begin
	update katekar
	set thrs=thrs+:New.hrs 
	where pno=:New.pno;	
end;
/

insert into bunty values(6,'Suhas',4,30,1006);

-- b)Creating a trigger to change the hrs of existing employee and display the new total hours from project table.
create or replace Trigger QBV
 	after update of hrs on bunty 
	for each row
	when(New.pno IS NOT NULL)
begin
update katekar
set thrs=thrs+:New.hrs-:old.hrs 
where pno=:New.pno;	
end;
/

update bunty set hrs = 10 where eno = 1;

-- c)Creating a trigger to change the project of an employee and display the new total hours from project table.
create or replace Trigger QB3
 	after update of pno on bunty 
	for each row
	when(New.pno IS NOT NULL)
begin
	update katekar
	set thrs=thrs+:New.hrs-:old.hrs 
	where pno=:New.pno;	
end;
/

update bunty set pno=10 where eno=2;

-- d)Creating a trigger to delete the project of an employee.
create Trigger QB4u
	after delete on bunty
	for each row
	when(OLD.pno IS NOT NULL)
begin
	update katekar
	set thrs=thrs-:Old.hrs
	where pno=:Old.pno;
end;
/

delete from bunty where pno=20;