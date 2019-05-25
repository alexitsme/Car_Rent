package Car.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;

public class Sqlite {
	
	public static Connection connect() {
		Connection conn=null;
		try {
			Class.forName("org.sqlite.JDBC");
			String url="jdbc:sqlite:C:\\Users\\Alex\\git\\Car_Rent\\Carent\\src\\DB\\username.db";
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
	public void userexists(Connection conn,String username,String Pass) {
		try {
			System.out.println("here");
			String query="select * from users where username=? and password=?";
			PreparedStatement pst=conn.prepareStatement(query);
			pst.setString(0, username);
			pst.setString(1, Pass);
			ResultSet rs=pst.executeQuery();
			int count=0;
			while(rs.next()) {
				count++;
			}
			if(count==1) {
				JOptionPane.showMessageDialog(null, "Wellcome"+username);
			}
			else {
				JOptionPane.showConfirmDialog(null, "wrong user name or password");
			}
			rs.close();
			pst.close();
		}
		catch(Exception e){
			JOptionPane.showConfirmDialog(null, e);
		}

		
	
		
	}

}