-- 创建用户表
drop table if exists `t_user`;
create table `t_user`(
	id int(11) not null auto_increment,
	username varchar(255) not null,
	password varchar(255) not null,
	primary key(id)
)ENGINE=InnoDB default charset=utf8;
insert into `t_user` values(1,'tangxing','tangxing');
-- 创建学生表
drop table if exists `t_student`;
create table `t_student`(
	id int(11) not null auto_increment,
	name varchar(255) not null,
	age int(3) default null,
	primary key(id)
)ENGINE=InnoDB default charset=utf8;
insert into `t_student` values(1,'zhangsan',25);