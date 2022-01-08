create table emp(
	eid int not null auto_increment, -- 主鍵
	ename varchar(50), -- 員工名稱
	age int , -- 員工年齡
	createtime timestamp NULL DEFAULT CURRENT_TIMESTAMP,
	primary key (eid)
);

create table job(
	jid int not null auto_increment, -- 主鍵
	jname varchar(50), -- 工作名稱
	eid int not null, -- 員工 id
	primary key (jid),
	foreign key(eid) references emp(eid) -- 外鍵關聯
);