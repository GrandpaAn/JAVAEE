/*
	�������һ�����ݿ��test2�Ͱ���ɾ����
	DROP DATABASE IF EXISTS test2;		

	���������һ�����ݽ�test2�ʹ���һ��������test2�����ݣ��������ݿ�ʹ���ַ���������ΪUTF8
	CREATE DATABASE IF NOT EXISTS test2 CHARSET UTF8;
 */
# DROP DATABASE IF EXISTS test2;
# CREATE DATABASE IF NOT EXISTS test2 CHARSET UTF8;

# ѡ��ʹ�����ݿ�
# USE test;

# ������
/*
		INT							����
		PRIMARY KEY			������Ψһ�ģ���Բ������Ż�
		AUTO_INCREMENT	���ֻ��Զ�������������Ҫ�ֶ�����
		VARCHAR					��ʾ���ַ��������Ա������֣�(32)����ַ�ֻ�ܱ���32������
		NOT NULL				��ʾ����ֶα���Ҫ��ֵ
		UNIQUE					��ʾ������ݲ����ظ�
 */
CREATE TABLE IF NOT EXISTS t_user(
id INT PRIMARY KEY AUTO_INCREMENT,
username VARCHAR(32) NOT NULL UNIQUE,
password VARCHAR(32) NOT NULL
) ENGINE=INNODB;#Ĭ��ʹ��MYSAM��InnoDB֧������MYISAM��֧��Ч�ʻ����

/*
�������
INSERT INTO t_user(�ֶ�1, �ֶ�2,....�ֶ�n) VALUES(ֵ1, ֵ2,...ֵn);
*/
INSERT INTO t_user(username, password) VALUES('admin', '1234');






