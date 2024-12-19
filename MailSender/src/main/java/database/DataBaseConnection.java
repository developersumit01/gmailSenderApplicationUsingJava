package database;

import java.sql.Connection;
import java.sql.DriverManager;

public final class DataBaseConnection {
	private DataBaseConnection() {
		
	}
	static Connection connection;
	public static Connection getConnection(){
		if(connection==null) {
		try {
			Class.forName(LoginInfo.DBDriver);
			connection=DriverManager.getConnection(LoginInfo.DBUrl,LoginInfo.DBUser,LoginInfo.DBPassword);
//			System.out.println(c);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		}else {
			return connection;
		}
		return connection;
	}
}
