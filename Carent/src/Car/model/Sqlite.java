package Car.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.*;

public class Sqlite {
	
	public static Connection connect() {
		Connection conn=null;
		try {
			Class.forName("org.sqlite.JDBC");
			String url="jdbc:sqlite:C:\\Users\\Alex\\Desktop\\username.db";
			conn=DriverManager.getConnection(url);
			JOptionPane.showConfirmDialog(null, "DB connected");
			return conn;
		}
		catch (Exception e) {
			JOptionPane.showConfirmDialog(null, e);
			return null;
		}
	}
	//check if user on DB, the function can return 3 options: 
	//0 user doesnt exists
	//1 worker
	//2 administrator user
	public int userexists(String username,String Pass) {
		
		return 0;
		
	}

}