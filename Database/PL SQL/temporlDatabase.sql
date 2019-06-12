-- Temporal Database

-- A. Create table temporal1(ename;recdate;dob;retiredate;accno)
--    insert 5 records
--    a. Find all the employees who join the company on 02-03-1990
--    b. Find all the employees who retire on 02-03-1930

-- B. Create table tbl_shares(company_name;no_shares;price;transaction_time)
--    insert 5 records
--    a. Find all the names of a company whose share price is more than Rs. 100 at 11:45AM
--    b. Find the name of company which has highest share price at 5:00 PM

-- A. Create table temporal1(accno;ename;recdate;dob;retiredate)
create table temporal1(accno number,
	ename varchar2(10),
	recdate date,
	dob date,
	retiredate date);

--    insert 5 records
insert into temporal1 values(1,'ABC','2-Mar-1990','11-April-1975','');
insert into temporal1 values(2,'PQR','8-Jun-1992','2-Mar-1972','');
insert into temporal1 values(3,'LMN','5-Apr-2000','31-Jul-1980','');
insert into temporal1 values(4,'XYZ','23-Jul-1996','15-Aug-1976','');
insert into temporal1 values(5,'TUV','13-Mar-2008','23-Sep-1996','');

--    create procedure
create or replace procedure Caldate is
	cursor c1 is select * from temporal1;
	r c1%rowtype;
begin
	for r in c1 loop
		update temporal1 set retiredate=add_months(r.dob,696)
		where accno=r.accno;
	end loop;
end;
/

--    execute cursor
execute Caldate;

select * from temporal1;
--    Queries
--    a. Find all the employees who join the company on 02-03-1990
select * from temporal1 where recdate = '02-Mar-90';
--    b. Find all the employees who retire on 02-03-1930
select * from temporal1 where retiredate = '02-Mar-30';


-- B. Create table tbl_shares(company_name;no_shares;price;transaction_time)
create table tb_shares(company_name varchar2(10),
	no_shares number(5),
	price number(5),
	transaction_time date);

--    insert 5 records
insert into tb_shares values('Infosys',300,10,to_date('09:45','hh24:mi'));
insert into tb_shares values('Patni',500,10,to_date('11:45','hh24:mi'));
insert into tb_shares values('Wipro',200,20,to_date('06:45','hh24:mi'));
insert into tb_shares values('Himalaya',100,15,to_date('17:45','hh24:mi'));
insert into tb_shares values('MBT',100,20,to_date('18:45','hh24:mi'));

--    a. Find all the names of a company whose share price is more than Rs. 100 at 11:45AM
SELECT company_name, no_shares* price
    FROM tb_shares
    WHERE no_shares* price > 100 and transaction_time= to_date('11:45', 'hh24:mi');

--    b. Find the name of company which has highest share price at 5:00 PM
SELECT company_name, max(No_Shares* price)
    FROM tb_shares
    WHERE transaction_time<  to_date('17:00', 'hh24:mi')
   	GROUP BY company_name;