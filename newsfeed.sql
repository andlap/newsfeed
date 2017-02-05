drop database if exists newsmanager;

create database newsmanager; 

use newsmanager;          

create table newsmanager (
	id	int(8) not null auto_increment, 
	title    varchar(255) not null, 
	category    varchar(255) not null,  
	text     varchar(255) not null, 
	createDate     timestamp not null,
	PRIMARY KEY (id)
);

insert into newsmanager(title,category,text) 
values 
('Title1','Category1','This news Title1 by Category1'),
('Title2','Category2','This news Title2 by Category2'),
('Title3','Category3','This news Title3 by Category3'),
('Title4','Category1','This news Title4 by Category1'),
('Title5','Category3','This news Title5 by Category3'),
('Title6','Category1','This news Title6 by Category1'),
('Title7','Category2','This news Title7 by Category2'),
('Title8','Category1','This news Title8 by Category1'),
('Title9','Category2','This news Title9 by Category2'),
('Title10','Category3','This news Title10 by Category3');


commit;