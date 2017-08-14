-- jdbc模块的数据库mysql脚本
drop table if exists `t_user`;
create table `t_user`(
  id int(11) not null auto_increment comment  '用户id',
  name varchar(255) not null comment '用户名',
  age int(3) comment '年龄',
  primary key (id)
)ENGINE=InnoDB default charset=utf8;