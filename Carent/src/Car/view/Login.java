package Car.view;
import Car.model.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import Car.model.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class Login  {

	public int getAcces() {
		return acces;
	}

	public void setAcces(int acces) {
		this.acces = acces;
	}


	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private boolean status=true;
	private int acces;
	
	  

	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Sqlite sqlite=new Sqlite();
		Connection conn=sqlite.connect();
		System.out.println(conn);
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String user= new String(textField.getText());
				String passText = new String(passwordField.getPassword());
				int acces =sqlite.userexists(conn, user, passText);  
				setAcces(acces);
				
				
				
				
				
			}
		});
		btnNewButton.setBounds(15, 199, 115, 29);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.setBounds(145, 199, 115, 29);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("user name");
		lblNewLabel.setBounds(15, 41, 115, 20);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(191, 38, 146, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(15, 77, 69, 20);
		frame.getContentPane().add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(191, 80, 146, 26);
		frame.getContentPane().add(passwordField);
		
		
		
		}
	public void control( boolean status) {
		frame.setVisible(status);
	}
	


	
}
