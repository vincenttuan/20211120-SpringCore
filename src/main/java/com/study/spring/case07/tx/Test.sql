-- 交易 Transcation 所需要的資料表
-- 書籍資料
create table if not exists book(
	bid integer not null auto_increment,
	bname varchar(50) not null,
	price integer,
	ct timestamp default current_timestamp,
	primary key(bid)
);
-- 庫存資料
create table if not exists stock(
	sid integer not null auto_increment,
	bid integer not null, -- book's bid
	amount integer,
	primary key(sid),
	foreign key(bid) references book(bid) -- 外鍵關聯
);
-- 客戶雲端錢包資料
create table if not exists wallet(
	wid integer not null auto_increment,
	wname varchar(50), -- 名稱
	money integer default 0,
	primary key(wid)
);

