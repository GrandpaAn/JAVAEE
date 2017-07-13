<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*"%>
<%
	// 实现数据库的连接及操作
	
	/*
		预备工作
		1. 打开WebContent->WEB-INF目录
		2. 把mysql-connector-java-5.1.42.jar复制到lib目录下
		3. 在page添加上import="java.sql.*"，引入java.sql下的所有文件到当前的文件中
	*/
	
	// 1. 加载驱动
	Class.forName("com.mysql.jdbc.Driver");	// 加载MySQL的驱动
	// 2. 获取连接
	// DriverManager.getConnection(连接的地址, 用户名, 密码);
	/*
		localhost				连接数据库的地址
		3306					数据库服务器的端口
		test					需要连接的数据库名称
		?useUnicode=true&characterEncoding=UTF8			这是参数
			useUnicode			表示当前连设置是否使用unicode编码，true使用，false不使用
			characterEncoding	使用什么字符集
		补充：如果连接地址是localhost:3306可以省略为 jdbc:mysql:///test
	 */
	String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF8";
	String username = "root";
	String password = "123123";
	Connection con = DriverManager.getConnection(url, username, password);
	// 3. 创建Statement
	Statement stmt = con.createStatement();
	// 4. 执行SQL语句（查询）
	String sql = "SELECT * FROM t_user";
	ResultSet rs = stmt.executeQuery(sql);	// 查找到的所有内容都会保存在ResultSet里
	// 5. 对查询返回的结果进行处理
	// 通过调用next()方法获取一行数据，调用后会返回布尔值，如果有记录返回true没有返回false
	/*
		while(布尔表达式){ // 只要布尔表达式为true就会一直执行大括号里的代码，直到结果为false时才不执行
			// TODO
		}
	 */
	 // 如果只查询一条数据，把while改为if
	while(rs.next()){
		int id = rs.getInt(1);// 获取第1列数据，这个数据会自动转换为int类型
		// id = rs.getInt("id");// 明确说明需要获取id这一列数据
		String name = rs.getString(2);
		String pass = rs.getString(3);
		out.println(id+","+name+","+pass+"<br/>");
	}
	
	// 6. 关闭数据库连接(不能忘)
	con.close();

	// 对应查找到数据或没有数据的情况怎样处理
%>










