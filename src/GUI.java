import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

@SuppressWarnings("serial")
public class GUI extends JFrame {

	public static class Run implements Runnable
	{
		public void run() {
			try {
				GUI frame = new GUI();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private static Connection c;

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://sql9.freesqldatabase.com:3306/sql9267322", "sql9267322", "r3wkhE6UAS");
		} catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Run());
	}

	/**
	 * Create the frame.
	 */
	public GUI() 
	{
		setTitle("Log In");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 336);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Log In");
		lblNewLabel.setBounds(0, 0, 434, 70);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textField.setBounds(173, 81, 175, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Username:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(74, 81, 89, 23);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblPassword.setBounds(74, 134, 89, 23);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();

		passwordField.setBounds(173, 135, 175, 23);
		contentPane.add(passwordField);
		
		JButton btnLogIn = new JButton("Log In");
		btnLogIn.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) 
			{
				String username = textField.getText();
				String password = passwordField.getText();
				Statement s;
				ResultSet rs= null;
				try
				{
					s = c.createStatement();
					rs = s.executeQuery("select User.Role from `User` where User.UserName = '" + username + "' and User.Password = '" + password+"'");
				} catch (SQLException e)
				{
					e.printStackTrace();
				}
				try
				{
					if (rs.next() != false)
					{
						String role = rs.getString("Role");
						if (role.equalsIgnoreCase("Student"))
						{
							String q = "select * from `Student` where Student.StudentID = '" + username + "'";
							Statement s1 = c.createStatement();
							ResultSet rs1 = s1.executeQuery(q);
							Student student = null;
							if (rs1.next())
							{
								byte[] bytes = rs1.getBytes("StuData");
					            try
								{
									ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
									ObjectInputStream input = new ObjectInputStream(bais);
									student = (Student) input.readObject();
									
									input.close();
									
								} catch (ClassNotFoundException e)
								{
									e.printStackTrace();
								} catch (IOException e)
								{
									e.printStackTrace();
								}
							}
							else
							{
								Statement myState = c.createStatement();
								String myQ = "select * from `User` where User.Username = '" + username + "'";
								ResultSet myRs = myState.executeQuery(myQ);
								if (myRs.next())
								{
									String name = myRs.getString("Name");
									String email = myRs.getString("Email");
									String dob = myRs.getString("DOB");
									String sex = myRs.getString("Sex");
									student = new Student(username, password, name, email, dob, sex);
									System.out.print("Course 0 : " + student.getCourseList().get(0));
								}
								String q1 = "insert into `Student` values ('" + username + "', 'init entry')";
								Statement s2 = c.createStatement();
								s2.executeUpdate(q1);
							}
							GUIStudent.main(c, username, password, student);
						}
							
						if (role.equalsIgnoreCase("Professor"))
							GUIProfessor.main(null);
						if (role.equalsIgnoreCase("Admin"))
							GUIAdmin.main(c, username, password);
						GUI.this.setVisible(false);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Username or password was incorrect.", "Incorrect log in.", JOptionPane.ERROR_MESSAGE);
					}
				} catch (HeadlessException | SQLException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnLogIn.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnLogIn.setBounds(146, 206, 145, 44);
		contentPane.add(btnLogIn);
		
	}
}
