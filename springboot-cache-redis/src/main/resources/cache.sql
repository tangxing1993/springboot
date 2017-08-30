drop table if exists `t_user`;
create table `t_user`(
	id int(11) not null auto_increment,
	name varchar(255) not null,
	age int(3) default null,
	primary key(id)
)ENGINE=InnoDB default charset=utf8;