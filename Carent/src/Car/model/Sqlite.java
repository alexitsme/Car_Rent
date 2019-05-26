package Car.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

import javax.swing.*;

public class Sqlite {

	
	public static Connection connect() {
		Connection conn=null;
		try {
			Class.forName("org.sqlite.JDBC");
			String url="jdbc:sqlite:C:\\Users\\Alex\\git\\Car_Rent\\Carent\\src\\DB\\username.db";
			conn=DriverManager.getConnection(url,"","");
			Statement stmt=conn.createStatement();
			
			
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
	
	public int userexists(Connection conn,String username,String Pass) {
		boolean connections= false;
		try {
			Statement stmt=conn.createStatement();
			ResultSet rs;
			System.out.println(conn);
			System.out.println("here");
			String query="select * from users ";
			PreparedStatement pst=conn.prepareStatement(query);
			//ResultSet rs=pst.executeQuery();
			int acces=0;
			rs=stmt.executeQuery(query);
			System.out.println(rs);
			while(rs.next()) {
				String login=rs.getString("username");
				System.out.println(login);
				String pas=rs.getString("password");
				System.out.println(pas);
			
				if((Objects.equals(login, username))&&(Objects.equals(pas, Pass)))
					connections=true;
				String permisions=rs.getString("admin");		
						if(Objects.equals(permisions, "yes"))
							acces=1;
					
						
						
						if(connections&& acces==1) {
							JOptionPane.showMessageDialog(null, "Wellcome Admin user:" +username);
							return 2;
						}
						else if(connections&& acces==0) {
							JOptionPane.showMessageDialog(null, "Wellcome" +username);
							return 1;
						}
						
							
			}
			JOptionPane.showConfirmDialog(null, "wrong user name or password");			
			rs.close();
			pst.close();
			
		}
		catch(Exception e){
			JOptionPane.showConfirmDialog(null, e);
		}
		return 0;

		
	
		
	}

}