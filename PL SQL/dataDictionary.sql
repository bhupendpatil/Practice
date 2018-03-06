--Data Dictionary

--User Tables
--View a list of all the tables owned by the current Oracle user.
--This can be accomplished with a simple SELECT query on the USER_TABLES data dictionary
SELECT
  table_name, owner
FROM
  user_tables
ORDER BY
  owner, table_name;

--All Tables
--Tables the current Oracle user has access to, regardless of ownership, 
--you’ll use the ALL_TABLES data dictionary instead
SELECT
  table_name, owner
FROM
  all_tables
ORDER BY
  owner, table_name;

--DBA Tables
--View every table in the system, the great and powerful DBA_TABLES 
--data dictionary.
SELECT
  table_name, owner
FROM
  dba_tables
WHERE
  owner='schema_name'
ORDER BY
  owner, table_name;
