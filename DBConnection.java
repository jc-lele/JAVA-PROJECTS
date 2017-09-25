package vcampus.database.database;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	static Connection con = null;
	private static String dpath=new File("").getAbsolutePath().replace('\\', '/') + "/VirtualCampus.accdb";
	private static String url = "jdbc:Access:///"+dpath;
	public Connection conn = null;
	
	static {
		
		//驱动
		try {
			Class.forName("com.hxtt.sql.access.AccessDriver");
		}
		catch(ClassNotFoundException e) {
			System.out.println("驱动加载失败");
			e.printStackTrace();
		}
		System.out.println("驱动加载成功");
		
		//连接
		try {
			con = DriverManager.getConnection(url);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("数据库连接成功");

		//获取执行sql语句的Statement,然后执行sql语句
		
		try {
			Statement statement = con.createStatement();
		} catch (SQLException e) {
			System.out.println("执行sql语句出错");
			e.printStackTrace();
		}
	}
	public static Connection getCon() {
		return con;
	}

}
