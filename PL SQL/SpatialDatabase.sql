-- Implementing and retrieving records from spatial database.

-- Create the spatial database table that stores the number, name,
-- location which consists of 4 different areas
-- a) Find the topological intersection of 2 geometries.
-- b) Find whether 2 geometric figures are equivalent to each other.
-- c) Find the areas of all different location.
-- d) Find area of only one location.
-- e) Find the distance between two geometries.

-- Create Table
Create table cola_mrp (mkt_id number primary key, name varchar(20), shape MDSYS.SDO_Geometry);

-- Inserting values into table
insert into cola_mrp values
		(1,'cola_a',MDSYS.SDO_GEOMETRY(
		2003,NULL,NULL,
		MDSYS.SDO_ELEM_INFO_ARRAY
		(1,1003,3),
		MDSYS.SDO_ORDINATE_ARRAY
		(1,1,5,7)));

insert into cola_mrp values
		(2,'cola_b',MDSYS.SDO_GEOMETRY(
		2003,NULL,NULL,
		MDSYS.SDO_ELEM_INFO_ARRAY
		(1,1003,1),
		MDSYS.SDO_ORDINATE_ARRAY
		(5,1,8,1,8,6,5,7,5,1)));

insert into cola_mrp values
		(3,'cola_c',MDSYS.SDO_GEOMETRY(
		2003,NULL,NULL,
		MDSYS.SDO_ELEM_INFO_ARRAY
		(1,1003,1),
		MDSYS.SDO_ORDINATE_ARRAY
		(3,3,6,3,6,5,4,5,3,3)));

insert into cola_mrp values
		(4,'cola_d',MDSYS.SDO_GEOMETRY(
		2003,NULL,NULL,
		MDSYS.SDO_ELEM_INFO_ARRAY
		(1,1003,4),
		MDSYS.SDO_ORDINATE_ARRAY
		(7,9,10,9,8,11)));

insert into user_SDO_GEOM_METADATA values
		('cola_mrp','shape',
		MDSYS.SDO_DIM_ARRAY(
		MDSYS.SDO_DIM_ELEMENT('X',0,20,0.005),
		MDSYS.SDO_DIM_ELEMENT('Y',0,20,0.005)),
		NULL);

create index cola_spatial_idx
		on cola_mrp(shape)
			Indextype Is mdsys.spatial_index;

-- Queries

-- a) Find the topological intersection of 2 geometries.
select SDO_GEOM.SDO_INTERSECTION(c_a.shape,c_c.shape,0.005)
from cola_mrp c_a,cola_mrp c_c
where c_a.name='cola_a' AND c_c.name='cola_c';

-- b) Find whether 2 geometric figures are equivalent to each other.
SELECT SDO_GEOM.RELATE(c_c.shape,'EQUAL',c_a.shape,0.005)
FROM cola_mrp c_c,cola_mrp c_a
WHERE c_c.name='cola_c' AND c_a.name='cola_a';

-- c) Find the areas of all different location.
SELECT name,SDO_GEOM.SDO_AREA(shape,0.005) from cola_mrp;

-- d) Find area of only one location.
SELECT c.name,SDO_GEOM.SDO_AREA(c.shape,0.005) FROM cola_mrp c
WHERE c.name='cola_a';

-- e) Find the distance between two geometries.
SELECT SDO_GEOM.SDO_DISTANCE(c_b.shape,c_d.shape,0.005)
FROM cola_mrp c_b,cola_mrp c_d
WHERE c_b.name='cola_b'AND c_d.name='cola_d';