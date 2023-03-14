//用户余额表
create table user_balance(
id    bigint unsigned auto_increment not null,
user_uuid  varchar(20), //user_uuid
balance  decimal(15,2), //余额
create_time timestamp,
create_user varchar(20),
update_time timestamp,
update_user varchar(20),
primary key(id)
)ENGINE = InnoDB;


//用户余额变动明细表
create table user_balance_detail(
id  bigint unsigned auto_increment not null,
user_uuid   varchar(20), //user_uuid
incoming    decimal(15,2),//收入
outgoing    decimal(15,2),//支出
user_balance decimal(15,2),//余额 
create_time  timestamp, //时间
change_type  varchar(2), //变动原因
detail    JSON,  //余额变动明细
primary key(id)
)ENGINE = InnoDB;


//商品库存表
create table goods(
id  bigint unsigned auto_increment not null,
uuid   varchar(20), //uuid
goods_name  varchar(50), //商品名称
price  decimal(15,2), //商品价格
inventory  int, //库存
primary key(id)
)ENGINE = InnoDB;

