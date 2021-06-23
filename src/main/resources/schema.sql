drop table if exists receipts;

create table receipts (
	receipt_id integer auto_increment primary key,
	data varchar(10000),
	total decimal,
	taxes decimal,
	date varchar(10),
	url varchar(1024)
);