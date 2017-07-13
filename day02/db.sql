/*
	如果存在一个数据库叫test2就把它删除掉
	DROP DATABASE IF EXISTS test2;		

	如果不存在一个数据叫test2就创建一个叫做是test2的数据，并把数据库使用字符编码设置为UTF8
	CREATE DATABASE IF NOT EXISTS test2 CHARSET UTF8;
 */
# DROP DATABASE IF EXISTS test2;
# CREATE DATABASE IF NOT EXISTS test2 CHARSET UTF8;

# 选择使用数据库
# USE test;

# 创建表
/*
		INT							整数
		PRIMARY KEY			主键，唯一的，会对查找做优化
		AUTO_INCREMENT	数字会自动做增长，不需要手动设置
		VARCHAR					表示是字符串，可以保存文字，(32)这个字符只能保存32个文字
		NOT NULL				表示这个字段必须要赋值
		UNIQUE					表示这个内容不能重复
 */
CREATE TABLE IF NOT EXISTS t_user(
id INT PRIMARY KEY AUTO_INCREMENT,
username VARCHAR(32) NOT NULL UNIQUE,
password VARCHAR(32) NOT NULL
) ENGINE=INNODB;#默认使用MYSAM，InnoDB支持事务，MYISAM不支持效率会更高

/*
添加数据
INSERT INTO t_user(字段1, 字段2,....字段n) VALUES(值1, 值2,...值n);
*/
INSERT INTO t_user(username, password) VALUES('admin', '1234');






