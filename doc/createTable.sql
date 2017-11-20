/*** create table tb_w4ymusicItem **/
create table if not exists tb_w4ymusicItem(
	id varchar(32) primary key,
	name varchar(100) not null unique,
	link varchar(100) not null unique,
	singer varchar(50),
	album varchar(100),
	cover varchar(100),
	lyric varchar(2000),
	total_comment int(10)
);