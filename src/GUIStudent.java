import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JSeparator;

public class GUIStudent 
{

	private JFrame frmEservices;
	private JLabel lblCourseAns = new JLabel("");
	private JLabel label_7 = new JLabel("");
	Statement s = null;
	ResultSet rs = null;
	private JLabel lblUsersAddress;
	private JLabel lblUsersEmail;
	private JLabel lblSectionAns1 = new JLabel("SJ01A");
	private JLabel lblScheduleAns1 = new JLabel("MWF 12:30pm - 1:20pm");
	private JLabel lblLocationAns1 = new JLabel("Oland Hall G31");
	private JLabel lblProfessorAns1 = new JLabel("Prabhat Mahanti");
	private JLabel lblPmahantiunbca1 = new JLabel("pmahanti@unb.ca");
	private JLabel lblScheduleAns = new JLabel("");
	private JLabel lblSectionAns = new JLabel("");
	private JLabel lblLocationAns = new JLabel("");
	private JLabel lblProfessorAns = new JLabel("");
	private JLabel lblPmahantiunbca = new JLabel("");

	public static void main(Connection c, String user, String pass, Student student) 
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIStudent window = new GUIStudent(c, user, pass, student);
					window.frmEservices.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	public GUIStudent(Connection c, String user, String pass, Student student) 
	{
		initialize(c, user, pass, student);
	}

	private void initialize(Connection c, String user, String pass, Student student) 
	{
		String query = "select * from `User` where User.UserName = '" + user + "' and User.Password = '" + pass+"'";
		frmEservices = new JFrame();
		frmEservices.setBackground(SystemColor.menu);
		frmEservices.getContentPane().setBackground(SystemColor.menu);
		frmEservices.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 864, 500);
		frmEservices.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Profile", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username : ");
		lblUsername.setBounds(25, 28, 161, 28);
		panel.add(lblUsername);
		
		JLabel lblEmail = new JLabel("Email : ");
		lblEmail.setBounds(25, 67, 161, 28);
		panel.add(lblEmail);
		
		JLabel lblName = new JLabel("Name : ");
		lblName.setBounds(25, 106, 161, 28);
		panel.add(lblName);
		
		JLabel lblDOB = new JLabel("Date of Birth (mm/dd/yy) : ");
		lblDOB.setBounds(25, 145, 161, 28);
		panel.add(lblDOB);
		
		JLabel lblSex = new JLabel("Sex : ");
		lblSex.setBounds(25, 184, 161, 28);
		panel.add(lblSex);
		
		try
		{
			s = c.createStatement();
			rs = s.executeQuery(query);
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		JLabel lblUsersUsername = null;
		try
		{
			rs.next();
			lblUsersUsername = new JLabel(rs.getString("UserName"));
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		lblUsersUsername.setBounds(196, 28, 226, 28);
		panel.add(lblUsersUsername);
		
		try
		{
			lblUsersEmail = new JLabel(rs.getString("Email"));
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		lblUsersEmail.setBounds(196, 67, 226, 28);
		panel.add(lblUsersEmail);
		
		JLabel lblUsersName = null;
		try
		{
			lblUsersName = new JLabel(rs.getString("Name"));
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		lblUsersName.setBounds(196, 106, 226, 28);
		panel.add(lblUsersName);
		
		JLabel lblUsersDOB = null;
		try
		{
			lblUsersDOB = new JLabel(rs.getString("Dob"));
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		lblUsersDOB.setBounds(196, 145, 226, 28);
		panel.add(lblUsersDOB);
		
		JLabel lblUsersSex = null;
		try
		{
			lblUsersSex = new JLabel(rs.getString("Sex"));
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		lblUsersSex.setBounds(196, 184, 226, 28);
		panel.add(lblUsersSex);
		
		JLabel lblAddress = new JLabel("Address : ");
		lblAddress.setBounds(25, 223, 161, 28);
		panel.add(lblAddress);
		
		try
		{
			lblUsersAddress = new JLabel(rs.getString("Address"));
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		lblUsersAddress.setBounds(196, 223, 226, 28);
		panel.add(lblUsersAddress);
		
		JLabel lblRole = new JLabel("Role : ");
		lblRole.setBounds(25, 262, 161, 28);
		panel.add(lblRole);
		
		JLabel lblUsersRole = null;
		try
		{
			lblUsersRole = new JLabel(rs.getString("Role"));
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		lblUsersRole.setBounds(196, 262, 226, 28);
		panel.add(lblUsersRole);
		
		JButton btnChangeEmailAddress = new JButton("Update my email address...");
		btnChangeEmailAddress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String newEmail = JOptionPane.showInputDialog("Enter your new email address:");
				String q = "Update `User` Set User.Email = '" + newEmail + "' where User.UserName = '" + user + "'";
				try
				{
					if(newEmail == null || !newEmail.contains("@"))
					{
						JOptionPane.showMessageDialog(null, "Please enter a valid email address.", "Update Failed.", JOptionPane.ERROR_MESSAGE);
					}
					else 
					{
						s.executeUpdate(q);
						JOptionPane.showMessageDialog(null, "Update Successful.", "Update Successful.", JOptionPane.INFORMATION_MESSAGE);
						lblUsersEmail.setText(newEmail);
					}


				} catch (SQLException e)
				{
					JOptionPane.showMessageDialog(null, "Update canceled.", "Update canceled.", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnChangeEmailAddress.setBounds(432, 70, 213, 23);
		panel.add(btnChangeEmailAddress);
		
		JButton btnChangeMyAddress = new JButton("Update my address...");
		btnChangeMyAddress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String newAddress = JOptionPane.showInputDialog("Enter your new address:");
				String q = "Update `User` Set User.Address = '" + newAddress + "' where User.UserName = '" + user + "'";
				try
				{
					if (newAddress == null || newAddress.length()<3)
					{
						JOptionPane.showMessageDialog(null, "Update Canceled.", "Update Canceled.", JOptionPane.INFORMATION_MESSAGE);
					}
					else
					{
						s.executeUpdate(q);
						JOptionPane.showMessageDialog(null, "Update Successful.", "Update Successful.", JOptionPane.INFORMATION_MESSAGE);
						lblUsersAddress.setText(newAddress);
					}
				} catch (SQLException e)
				{
					JOptionPane.showMessageDialog(null, "Update canceled.", "Update canceled.", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnChangeMyAddress.setBounds(432, 226, 213, 23);
		panel.add(btnChangeMyAddress);
		
		JButton btnUpdateMyPassword = new JButton("Update my password...");
		btnUpdateMyPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				String newPass = JOptionPane.showInputDialog("Enter your new password:");
				String q = "Update `User` Set User.Password = '" + newPass + "' where User.UserName = '" + user + "'";
				try
				{
					if (newPass == null)
					{
						JOptionPane.showMessageDialog(null, "Please enter a valid password (length > 4).", "Update Failed.", JOptionPane.ERROR_MESSAGE);
						return;
					}
					if (newPass.length()>4)
					{
						s.executeUpdate(q);
						JOptionPane.showMessageDialog(null, "Update Successful.", "Update Successful.", JOptionPane.INFORMATION_MESSAGE);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Please enter a valid password (length > 4).", "Update Failed.", JOptionPane.ERROR_MESSAGE);
					}
				} catch (SQLException e)
				{
					JOptionPane.showMessageDialog(null, "Update canceled.", "Update canceled.", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnUpdateMyPassword.setBounds(25, 361, 213, 23);
		panel.add(btnUpdateMyPassword);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Currently Enrolled Courses", null, panel_1, null);
		panel_1.setLayout(null);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) 
			{
				String course = (String) comboBox.getSelectedItem();
				lblCourseAns.setText(course);
				
				String schedule = null;
				String location = null;
				String prof = null;
				String profEmail = null;
				String sec = null;
				try
				{
					String q8 = "Select * from `Course` where Course.CourseName = '" + (String)comboBox.getSelectedItem()+"'";
					Statement s8 = c.createStatement();
					ResultSet rs8 = s8.executeQuery(q8);
					if(rs8.next())
					{
						int courseID = rs8.getInt("CourseID");
						
						String q9 = "Select * from `Section` where Section.SectionID = " + courseID;
						Statement s9 = c.createStatement();
						ResultSet rs9 = s9.executeQuery(q9);
						rs9.next();
						schedule = rs9.getString("Schedule");
						sec = rs9.getString("SectionName");
						sec = sec.split(" ")[1];
						location = rs9.getString("Location");
						prof = rs9.getString("Professor");
						
						String q10 = "select * from `User` where User.Name = '" + prof + "'";
						Statement s10 = c.createStatement();
						ResultSet rs10 = s10.executeQuery(q10);
						if(rs10.next())
							profEmail = rs10.getString("Email");
						else
							profEmail = "unknown";
						
					}
				} catch (SQLException e1)
				{
					e1.printStackTrace();
				}
				lblScheduleAns.setText(schedule);
				lblSectionAns.setText(sec);
				lblLocationAns.setText(location);
				lblProfessorAns.setText(prof);
				lblPmahantiunbca.setText(profEmail);
			}
		});
		comboBox.setBounds(190, 13, 126, 22);
		
		int count = student.getCourseCount();
		for (int i=0; i<count; i++)
		{
			String item = student.getCourseList().get(i);
			comboBox.addItem(item);
		}
		panel_1.add(comboBox);
		
		JLabel lblSelectedCourse = new JLabel("Your current courses :");
		lblSelectedCourse.setBounds(10, 15, 170, 18);
		panel_1.add(lblSelectedCourse);
		
		JButton btnDropCurrentlySelected = new JButton("Drop currently selected course");
		btnDropCurrentlySelected.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				if (comboBox.getSelectedItem() == null)
				{
					JOptionPane.showMessageDialog(null, "You are not enrolled in any courses.", "D canceled", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				String course = (String) comboBox.getSelectedItem();
				int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to drop " + course  + "?");
				if (option == 0)
				{
					comboBox.removeItem(course);
					student.remove(course);
					JOptionPane.showMessageDialog(null, "You have successfully dropped " + course, "Course drop successful", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnDropCurrentlySelected.setBounds(617, 13, 232, 23);
		panel_1.add(btnDropCurrentlySelected);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 46, 869, 15);
		panel_1.add(separator);
		
		JLabel lblCourse = new JLabel("Course :");
		lblCourse.setHorizontalAlignment(SwingConstants.LEFT);
		lblCourse.setBounds(10, 72, 140, 22);
		panel_1.add(lblCourse);
		
		JLabel lblSection = new JLabel("Section : ");
		lblSection.setHorizontalAlignment(SwingConstants.LEFT);
		lblSection.setBounds(10, 105, 140, 22);
		panel_1.add(lblSection);
		
		JLabel lblSchedule = new JLabel("Schedule :");
		lblSchedule.setHorizontalAlignment(SwingConstants.LEFT);
		lblSchedule.setBounds(10, 138, 140, 22);
		panel_1.add(lblSchedule);
		
		JLabel lblLocation = new JLabel("Location : ");
		lblLocation.setHorizontalAlignment(SwingConstants.LEFT);
		lblLocation.setBounds(10, 171, 140, 22);
		panel_1.add(lblLocation);
		
		JLabel lblProfessor = new JLabel("Professor :");
		lblProfessor.setHorizontalAlignment(SwingConstants.LEFT);
		lblProfessor.setBounds(10, 204, 140, 22);
		panel_1.add(lblProfessor);
		
		lblCourseAns.setHorizontalAlignment(SwingConstants.LEFT);
		lblCourseAns.setBounds(135, 72, 241, 22);
		panel_1.add(lblCourseAns);
		
		lblSectionAns.setHorizontalAlignment(SwingConstants.LEFT);
		lblSectionAns.setBounds(135, 105, 241, 22);
		panel_1.add(lblSectionAns);
		
		lblScheduleAns.setHorizontalAlignment(SwingConstants.LEFT);
		lblScheduleAns.setBounds(135, 138, 241, 22);
		panel_1.add(lblScheduleAns);
		
		lblLocationAns.setHorizontalAlignment(SwingConstants.LEFT);
		lblLocationAns.setBounds(135, 171, 241, 22);
		panel_1.add(lblLocationAns);
		
		lblProfessorAns.setHorizontalAlignment(SwingConstants.LEFT);
		lblProfessorAns.setBounds(135, 204, 241, 22);
		panel_1.add(lblProfessorAns);
		
		JLabel lblProfessorEmail = new JLabel("Professor email :");
		lblProfessorEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lblProfessorEmail.setBounds(10, 237, 140, 22);
		panel_1.add(lblProfessorEmail);
		
		lblPmahantiunbca.setHorizontalAlignment(SwingConstants.LEFT);
		lblPmahantiunbca.setBounds(135, 237, 140, 22);
		panel_1.add(lblPmahantiunbca);
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		tabbedPane.addTab("Enroll in Course", null, panel_3, null);
		
		
		
		JComboBox<String> comboBox1 = new JComboBox<String>();
		comboBox1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String course = (String) comboBox1.getSelectedItem();
				label_7.setText(course);
				try
				{
					String q8 = "Select * from `Course` where Course.CourseName = '" + (String)comboBox1.getSelectedItem()+"'";
					Statement s8 = c.createStatement();
					ResultSet rs8 = s8.executeQuery(q8);
					int courseID;
					if(rs8.next())
						courseID = rs8.getInt("CourseID");
					else
					{
						JOptionPane.showMessageDialog(null, "Update canceled.", "Update canceled.", JOptionPane.INFORMATION_MESSAGE);
						return;
					}
					
					String q9 = "Select * from `Section` where Section.SectionID = " + courseID;
					Statement s9 = c.createStatement();
					ResultSet rs9 = s9.executeQuery(q9);
					rs9.next();
					String section = rs9.getString("SectionName");
					section = section.split(" ")[1];
					if (lblSectionAns1 != null)
						lblSectionAns1.setText(section);
					
					String q10 = "Select * from `Section` where Section.SectionID = " + courseID;
					Statement s10 = c.createStatement();
					ResultSet rs10 = s10.executeQuery(q10);
					rs10.next();
					String schedule = rs10.getString("Schedule");
					lblScheduleAns1.setText(schedule);
					
					lblLocationAns1.setText(rs10.getString("Location"));
					String prof = rs10.getString("Professor");
					lblProfessorAns1.setText(prof);
					
					String q11 = "select * from `User` where User.Name = '" + prof + "'";
					Statement s11 = c.createStatement();
					ResultSet rs11 = s11.executeQuery(q11);
					String email;
					if(rs11.next())
						email = rs11.getString("Email");
					else
						email = "unknown";
					lblPmahantiunbca1.setText(email);
				} catch (SQLException e1)
				{
					JOptionPane.showMessageDialog(null, "An unexpected error has occured.", "Error.", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		try
		{
			Statement s2 = c.createStatement();
			Statement s3 = c.createStatement();
			ResultSet rs2 = s2.executeQuery("select * from Section");
			ResultSet rs3;
			while (rs2.next())
			{
				rs3 = s3.executeQuery("select Course.CourseName from Course where Course.CourseID = " + rs2.getInt("CourseID"));
				rs3.next();
				comboBox1.addItem(rs3.getString("CourseName"));
			}
		} catch (SQLException e1)
		{
			e1.printStackTrace();
		}
		comboBox1.setBounds(190, 13, 126, 22);
		panel_3.add(comboBox1);
		
		JLabel lblCurrentlyOfferedCourses = new JLabel("Currently offered courses :");
		lblCurrentlyOfferedCourses.setBounds(10, 15, 170, 18);
		panel_3.add(lblCurrentlyOfferedCourses);
		
		JButton btnEnrollInCurrently = new JButton("Enroll in currently selected course");
		btnEnrollInCurrently.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				if (student.getCourseCount() == 4)
				{
					JOptionPane.showMessageDialog(null, "You may not enroll in more courses.", "Enroll canceled", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				String course = (String) comboBox1.getSelectedItem();
				if (!student.getCourseList().search(course))
				{
					int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to enroll in " + course  + "?");
					if (option == 0)
					{
						comboBox.addItem(course);
						student.enroll(course);
						JOptionPane.showMessageDialog(null, "You are now enrolled in " + course, "Enroll successful", JOptionPane.INFORMATION_MESSAGE);
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "You are already enrolled in  " + course, "Enroll canceled", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnEnrollInCurrently.setBounds(617, 13, 232, 23);
		panel_3.add(btnEnrollInCurrently);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 46, 869, 15);
		panel_3.add(separator_1);
		
		JLabel label_2 = new JLabel("Course :");
		label_2.setHorizontalAlignment(SwingConstants.LEFT);
		label_2.setBounds(10, 72, 140, 22);
		panel_3.add(label_2);
		
		JLabel label_3 = new JLabel("Section : ");
		label_3.setHorizontalAlignment(SwingConstants.LEFT);
		label_3.setBounds(10, 105, 140, 22);
		panel_3.add(label_3);
		
		JLabel label_4 = new JLabel("Schedule :");
		label_4.setHorizontalAlignment(SwingConstants.LEFT);
		label_4.setBounds(10, 138, 140, 22);
		panel_3.add(label_4);
		
		JLabel label_5 = new JLabel("Location : ");
		label_5.setHorizontalAlignment(SwingConstants.LEFT);
		label_5.setBounds(10, 171, 140, 22);
		panel_3.add(label_5);
		
		JLabel label_6 = new JLabel("Professor :");
		label_6.setHorizontalAlignment(SwingConstants.LEFT);
		label_6.setBounds(10, 204, 140, 22);
		panel_3.add(label_6);
		
		label_7.setHorizontalAlignment(SwingConstants.LEFT);
		label_7.setBounds(135, 72, 241, 22);
		panel_3.add(label_7);
		
		String section = null;
		try
		{
			String q8 = "Select * from `Course` where Course.CourseName = '" + (String)comboBox1.getSelectedItem()+"'";
			Statement s8 = c.createStatement();
			ResultSet rs8 = s8.executeQuery(q8);
			int courseID;
			if(rs8.next())
				courseID = rs8.getInt("CourseID");
			else
			{
				JOptionPane.showMessageDialog(null, "Update canceled.", "Update canceled.", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			
			
			String q9 = "Select * from `Section` where Section.SectionID = " + courseID;
			Statement s9 = c.createStatement();
			ResultSet rs9 = s9.executeQuery(q9);
			rs9.next();
			section = rs9.getString("SectionName");
			section = section.split(" ")[1];
		} catch (SQLException e1)
		{
			e1.printStackTrace();
		}
		
		lblSectionAns1.setHorizontalAlignment(SwingConstants.LEFT);
		lblSectionAns1.setBounds(135, 105, 241, 22);
		panel_3.add(lblSectionAns1);
		
		lblScheduleAns1.setHorizontalAlignment(SwingConstants.LEFT);
		lblScheduleAns1.setBounds(135, 138, 241, 22);
		panel_3.add(lblScheduleAns1);
		
		lblLocationAns1.setHorizontalAlignment(SwingConstants.LEFT);
		lblLocationAns1.setBounds(135, 171, 140, 22);
		panel_3.add(lblLocationAns1);
		
		lblProfessorAns1.setHorizontalAlignment(SwingConstants.LEFT);
		lblProfessorAns1.setBounds(135, 204, 140, 22);
		panel_3.add(lblProfessorAns1);
		
		JLabel lblProfessorEmail1 = new JLabel("Professor email :");
		lblProfessorEmail1.setHorizontalAlignment(SwingConstants.LEFT);
		lblProfessorEmail1.setBounds(10, 237, 140, 22);
		panel_3.add(lblProfessorEmail1);
		
		lblPmahantiunbca1.setHorizontalAlignment(SwingConstants.LEFT);
		lblPmahantiunbca1.setBounds(135, 237, 140, 22);
		panel_3.add(lblPmahantiunbca1);
		
		
		

		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				byte[] byteArrayObject = null;
				try {
		            ByteArrayOutputStream bos = new ByteArrayOutputStream();
		            ObjectOutputStream oos = new ObjectOutputStream(bos);
		            oos.writeObject(student);
		            
		            oos.close();
		            bos.close();
		            byteArrayObject = bos.toByteArray();
		            
		            String update = "update `Student` set Student.StuData =  ? where Student.StudentID = ?";
		            PreparedStatement ps = c.prepareStatement(update);
		            ps.setBytes(1, byteArrayObject);
		            ps.setString(2, user);
		            ps.executeUpdate();
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
				System.exit(0);
			}
		});
		btnLogOut.setBounds(756, 522, 118, 23);
		frmEservices.getContentPane().add(btnLogOut);
		
		JLabel lblYouAreCurrently = null;
		try
		{
			lblYouAreCurrently = new JLabel("You are currently logged in as " + rs.getString("Name"));
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		lblYouAreCurrently.setBounds(10, 522, 736, 23);
		frmEservices.getContentPane().add(lblYouAreCurrently);
		frmEservices.setTitle("eServices - mleves10");
		frmEservices.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		frmEservices.setBounds(100, 100, 900, 600);
		frmEservices.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
