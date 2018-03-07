--Create index

-- Assume Table employee
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

--CREATE [UNIQUE] INDEX index_name
--  ON table_name (column1, column2, ... column_n)
--  [ COMPUTE STATISTICS ];
create index namee
  on employee (FIRST_NAME, Last_name);
  
--Maintain Index
  --Rename
  --ALTER INDEX index_name
  --  RENAME TO new_index_name;
  alter index namee
    rename to flname;
  
  --Collect Statistics
  --ALTER INDEX index_name
  --REBUILD COMPUTE STATISTICS;
  alter index flname
  rebuild compute statistics; --this sometimes never work
  
--Delete Index
--DROP INDEX index_name;
drop index flname;
