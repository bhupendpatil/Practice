-- Object Oriented Database Management Application(OODBMS)

-- Create different types and tables
-- Insertion of values in the tables
-- Author
-- Publisher
-- Book
-- Queries
-- a)List all the authors that have the same pin code as their publisher.
-- b)List all books that have 2 or more authors.
-- c)List the name of the publisher that has the most branches.
-- d)Name of authors who have not published more than a book.
-- e)List all the authors who have published more than one book.
-- f)List all books (title) where the same author appears more than once on the list of authors (assuming that an integrity constraint requiring that the name of an author is unique in a list of authors has not been specified).


-- Create different types and tables

Create or replace type AddrType1 as object( 
	Pincode number(5),										        
	Street char(20),											        
	City varchar2(50),										         
	state varchar2(40), 										       
  	no number(4)
);
/

Create or replace type BranchType as object(
	address AddrType1,											
	phone1 integer,
	phone2 integer
);
/

Create or replace type BranchTableType as table of BranchType;
/

Create or replace type AuthorType as object(
	name varchar2(50),
    addr AddrType1
);
/

Create table author of AuthorType;

Create or replace type AuthorListType as array(10) of ref AuthorType;
/

Create or replace type PublisherType as object(
	name varchar2(50),
	addr AddrType1, 
	branches BranchTableType
);
/

Create table Publisher of PublisherType NESTED TABLE branches STORE as branchstable;

Create table book(
	title varchar2(50),
	year date,
	published_by ref PublisherType,
	authors AuthorListType
);

-- Insertion of values in the tables

-- Author
insert into Author values('Rabiner',AddrType1(7007,'sstreet','mumbai','mha',1007));
insert into Author values('Seema',AddrType1(5002,'sstreet','pune','mha',04));
insert into Author values('Jerry',AddrType1(7003,'dstreet','mumbai','mha',1003));
insert into Author values('Schiller',AddrType1(7008,'nstreet','nasik','mha',08));
insert into Author values('Paulraj',AddrType1(7008,'sstreet','mumbai','mha',1007));
insert into Author values('Elmasri',AddrType1(7006,'nstreet','mumbai','mha',1006));
insert into Author values('Ramakrishnan',AddrType1(8002,'dstreet','pune','mha',1003));
insert into Author values('Jerry',AddrType1(8003,'dstreet','pune','mha',1010));

-- Publisher 
insert into Publisher values('Pearson',AddrType1(4002,'rstreet','mumbai','mha',03),
    BranchTableType(BranchType(AddrType1(5002,'fstreet','mumbai','mha',03),23406,69896)));
insert into Publisher values('ekta', AddrType1(7007,'sstreet','mumbai','mha',1007),
    BranchTableType(BranchType(AddrType1(7007,'sstreet','mumbai','mha',1007),4543545,8676775)));
insert into Publisher values('joshi',AddrType1(7008,'sstreet','mumbai','mha',1007),
    BranchTableType(BranchType(AddrType1(1002,'sstreet','nasik','mha',1007),456767,7675757)));
insert into Publisher values('ekta', AddrType1(7002,'sstreet','pune','mha',1007),
    BranchTableType(BranchType(AddrType1(1002,'sstreet','pune','mha',1007),4543545,8676775)));
insert into Publisher values('wiley',AddrType1(6002,'sstreet','nasik','mha',1007),
    BranchTableType(BranchType( AddrType1(6002,'sstreet','nasik','mha',1007),4543545,8676775)));
insert into Publisher values('arihant',AddrType1(6002,'sstreet','nasik','mha',1007),
    BranchTableType(BranchType( AddrType1(6002,'sstreet','nasik','mha',1007),4543545,8676775)));

-- Book
insert into book
	SELECT 'DSP','28-may-1983',ref(pub),AuthorListType(ref(aut)) 
		FROM Publisher pub,Author aut
 		WHERE pub.name='joshi' and aut.name='Schiller';
insert into book
	SELECT 'compiler','09-jan-1890',ref(pub),AuthorListType(ref(aut)) 
		FROM Publisher pub,Author aut 
		WHERE pub.name='wiley' and aut.name='Paulraj';
insert into book
	SELECT 'c','25-may-1983',ref(pub),AuthorListType(ref(aut))
        FROM Publisher pub,Author aut 
        WHERE pub.name='Pearson' and aut.name='Rabiner';
insert into book
    SELECT 'DSP','28-may-1983',ref(pub),AuthorListType(ref(aut))
     	FROM Publisher pub,Author aut 
		WHERE pub.name='joshi' and aut.name='Elmasri';
insert into book
	SELECT 'DSP','28-may-1983',ref(pub),AuthorListType(ref(aut))
    	FROM Publisher pub,Author aut 
		WHERE pub.name='arihant' and aut.name='Elmasri';

-- Queries

-- a)List all the authors that have the same pin code as their publisher.
SELECT a.name
	FROM author a, publisher p
	WHERE a.addr.pincode = p.addr.pincode;

-- b)List all books that have 2 or more authors.
SELECT *
	FROM book b 
	WHERE 1 < (SELECT count(*) FROM table(b.authors));

-- c)List the name of the publisher that has the most branches.
SELECT p.name
	FROM publisher p, table(p.branches)
	GROUP BY p.name having count(*)> = all (SELECT count(*)
    			                             	FROM publisher p, table(p.branches)
   			                                	GROUP BY name);

-- d)Name of authors who have not published more than a book.
SELECT a.name
	FROM author a
	WHERE not exists (SELECT b.title
    						FROM book b, table (b.authors)
                            WHERE a.name = name);

-- e)List all the authors who have published more than one book.
SELECT a.name
	FROM author a, book b, table(b.authors) v
	WHERE v.column_value = ref(a)
	GROUP BY a.name having count(*) > 1;	

-- f)List all books (title) where the same author appears more than once on the list of authors (assuming that an integrity constraint requiring that the name of an author is unique in a list of authors has not been specified).
SELECT title
	FROM author a, book b, table(b.authors) v
	WHERE v.column_value = ref(a)
	GROUP BY title having count(*) > 1;