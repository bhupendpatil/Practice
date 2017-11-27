--Assume table emp with ename and sal
--ename sal
--A     1000
--B     2000
--C     3000
--B     4000
--A     2000

declare
	cursor c1 is 
		select * from emp for update of sal no wait;
begin
	for r in c1
	loop
		update emp set sal=1000 where current of c1;
	end loop;
end;
/