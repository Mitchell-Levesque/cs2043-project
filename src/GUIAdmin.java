import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class GUIAdmin {

	private JFrame frmEservices;
	private JLabel lblCourseAns = new JLabel("");
	private JTextField txtSearchAUsername;
	Statement s = null;
	ResultSet rs = null;
	private JLabel lblUsersEmail = null;
	private JLabel lblUsersAddress = null;
	private int count = 1;
	private JLabel lblSectionAns;
	private JLabel lblScheduleAns = new JLabel("MWF 12:30pm - 1:20pm");
	private JLabel lblLocationAns = new JLabel("Oland Hall G31");
	private JLabel lblProfessorAns = new JLabel("Prabhat Mahanti");
	private JLabel lblPmahantiunbca = new JLabel("pmahanti@unb.ca");
	private JLabel label_4 = new JLabel("");
	private JLabel label_6 = new JLabel("");
	private JLabel label_17 = new JLabel("");
	private JLabel label_13 = new JLabel("");
	private JLabel label_11 = new JLabel("");
	private JLabel label_9 = new JLabel("");
	private JLabel label_2 = new JLabel("");
	
	public static void main(Connection c, String user, String pass) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIAdmin window = new GUIAdmin(c, user, pass);
					window.frmEservices.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GUIAdmin(Connection c, String user, String pass) {
		initialize(c, user, pass);
	}

	private void initialize(Connection c, String user, String pass) 
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
			JOptionPane.showMessageDialog(null, "An unexpected error has occured.", "Error.", JOptionPane.ERROR_MESSAGE);
		}
		
		JLabel lblUsersUsername = null;
		try
		{
			rs.next();
			lblUsersUsername = new JLabel(rs.getString("UserName"));
		} catch (SQLException e)
		{
			JOptionPane.showMessageDialog(null, "An unexpected error has occured.", "Error.", JOptionPane.ERROR_MESSAGE);
		}
		lblUsersUsername.setBounds(196, 28, 226, 28);
		panel.add(lblUsersUsername);
		
		try
		{
			lblUsersEmail = new JLabel(rs.getString("Email"));
		} catch (SQLException e)
		{
			JOptionPane.showMessageDialog(null, "An unexpected error has occured.", "Error.", JOptionPane.ERROR_MESSAGE);
		}
		lblUsersEmail.setBounds(196, 67, 226, 28);
		panel.add(lblUsersEmail);
		
		JLabel lblUsersName = null;
		try
		{
			lblUsersName = new JLabel(rs.getString("Name"));
		} catch (SQLException e)
		{
			JOptionPane.showMessageDialog(null, "An unexpected error has occured.", "Error.", JOptionPane.ERROR_MESSAGE);
		}
		lblUsersName.setBounds(196, 106, 226, 28);
		panel.add(lblUsersName);
		
		JLabel lblUsersDOB = null;
		try
		{
			lblUsersDOB = new JLabel(rs.getString("Dob"));
		} catch (SQLException e)
		{
			JOptionPane.showMessageDialog(null, "An unexpected error has occured.", "Error.", JOptionPane.ERROR_MESSAGE);
		}
		lblUsersDOB.setBounds(196, 145, 226, 28);
		panel.add(lblUsersDOB);
		
		JLabel lblUsersSex = null;
		try
		{
			lblUsersSex = new JLabel(rs.getString("Sex"));
		} catch (SQLException e)
		{
			JOptionPane.showMessageDialog(null, "An unexpected error has occured.", "Error.", JOptionPane.ERROR_MESSAGE);
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
			JOptionPane.showMessageDialog(null, "An unexpected error has occured.", "Error.", JOptionPane.ERROR_MESSAGE);
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
			JOptionPane.showMessageDialog(null, "An unexpected error has occured.", "Error.", JOptionPane.ERROR_MESSAGE);
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
		tabbedPane.addTab("Currently Offered Courses", null, panel_1, null);
		panel_1.setLayout(null);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String course = (String) comboBox.getSelectedItem();
				lblCourseAns.setText(course);
				try
				{
					String q8 = "Select * from `Course` where Course.CourseName = '" + (String)comboBox.getSelectedItem()+"'";
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
					if (lblSectionAns != null)
						lblSectionAns.setText(section);
					
					String q10 = "Select * from `Section` where Section.SectionID = " + courseID;
					Statement s10 = c.createStatement();
					ResultSet rs10 = s10.executeQuery(q10);
					rs10.next();
					String schedule = rs10.getString("Schedule");
					lblScheduleAns.setText(schedule);
					
					lblLocationAns.setText(rs10.getString("Location"));
					String prof = rs10.getString("Professor");
					lblProfessorAns.setText(prof);
					
					String q11 = "select * from `User` where User.Name = '" + prof + "'";
					Statement s11 = c.createStatement();
					ResultSet rs11 = s11.executeQuery(q11);
					String email;
					if(rs11.next())
						email = rs11.getString("Email");
					else
						email = "unknown";
					lblPmahantiunbca.setText(email);
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
				comboBox.addItem(rs3.getString("CourseName"));
				count++;
			}
		} catch (SQLException e1)
		{
			JOptionPane.showMessageDialog(null, "An unexpected error has occured.", "Error.", JOptionPane.ERROR_MESSAGE);
		}
		comboBox.setBounds(190, 13, 126, 22);
		panel_1.add(comboBox);
		
		JLabel lblSelectedCourse = new JLabel("Currently offered courses :");
		lblSelectedCourse.setBounds(10, 15, 170, 18);
		panel_1.add(lblSelectedCourse);
		
		JButton btnDropCurrentlySelected = new JButton("Offer a new course");
		btnDropCurrentlySelected.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String name = JOptionPane.showInputDialog("Enter the section full name:");
				if (name == null || name.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Update Canceled.", "Update Canceled.", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				String prof = JOptionPane.showInputDialog("Enter the professor:");
				if (prof == null || prof.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Update Canceled.", "Update Canceled.", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				String schedule = JOptionPane.showInputDialog("Enter the schedule:");
				if (schedule == null || schedule.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Update Canceled.", "Update Canceled.", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				String semester = JOptionPane.showInputDialog("Enter the current semester:");
				if (semester == null || semester.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Update Canceled.", "Update Canceled.", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				String location = JOptionPane.showInputDialog("Enter the location (room):");
				if (location == null || location.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Update Canceled.", "Update Canceled.", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				String[] strs = name.split(" ");
				String courseName = name;
				if(strs[0] != null)
					courseName = name.split(" ")[0];
				
				String insert = "insert into `Section` values ("+count+",'"+name+"','"+prof+"','"+schedule+"','"+semester+"',"+count+",'"+location+"')";
				Statement s4 = null;
				try
				{
					s.executeUpdate(insert);
					s4 = c.createStatement();
					s4.executeUpdate("insert into `Course` values ("+count+", '"+ courseName + "')");
					JOptionPane.showMessageDialog(null, "Update Successful.", "Update Successful.", JOptionPane.INFORMATION_MESSAGE);
					comboBox.addItem(courseName);
				} catch (SQLException e)
				{
					JOptionPane.showMessageDialog(null, "Update canceled.", "Update canceled.", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnDropCurrentlySelected.setBounds(547, 13, 302, 23);
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
		
		String section = null;
		try
		{
			String q8 = "Select * from `Course` where Course.CourseName = '" + (String)comboBox.getSelectedItem()+"'";
			Statement s8 = c.createStatement();
			ResultSet rs8 = s8.executeQuery(q8);
			rs8.next();
			int courseID = rs8.getInt("CourseID");
			
			String q9 = "Select * from `Section` where Section.SectionID = " + courseID;
			Statement s9 = c.createStatement();
			ResultSet rs9 = s9.executeQuery(q9);
			rs9.next();
			section = rs9.getString("SectionName");
			section = section.split(" ")[1];
		} catch (SQLException e1)
		{
			JOptionPane.showMessageDialog(null, "An unexpected error has occured.", "Error.", JOptionPane.ERROR_MESSAGE);
		}
		
		lblSectionAns = new JLabel(section);
		lblSectionAns.setHorizontalAlignment(SwingConstants.LEFT);
		lblSectionAns.setBounds(135, 105, 241, 22);
		panel_1.add(lblSectionAns);
		
		lblScheduleAns.setHorizontalAlignment(SwingConstants.LEFT);
		lblScheduleAns.setBounds(135, 138, 241, 22);
		panel_1.add(lblScheduleAns);
		
		lblLocationAns.setHorizontalAlignment(SwingConstants.LEFT);
		lblLocationAns.setBounds(135, 171, 140, 22);
		panel_1.add(lblLocationAns);
		
		lblProfessorAns.setHorizontalAlignment(SwingConstants.LEFT);
		lblProfessorAns.setBounds(135, 204, 140, 22);
		panel_1.add(lblProfessorAns);
		
		JLabel lblProfessorEmail = new JLabel("Professor email :");
		lblProfessorEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lblProfessorEmail.setBounds(10, 237, 140, 22);
		panel_1.add(lblProfessorEmail);
		
		lblPmahantiunbca.setHorizontalAlignment(SwingConstants.LEFT);
		lblPmahantiunbca.setBounds(135, 237, 140, 22);
		panel_1.add(lblPmahantiunbca);
		
		JButton btnRemoveCurrentlySelected = new JButton("Remove currently selected course");
		btnRemoveCurrentlySelected.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this course from the offered courses?");
				if (option == 0)
				{
					String course = (String) comboBox.getSelectedItem();
					Statement s6, s5;
					ResultSet rs6;
					try
					{
						s6 = c.createStatement();
						rs6 = s6.executeQuery("select * from `Course` where Course.CourseName = '" + course + "'");
						rs6.next();
						int courseID = rs6.getInt("CourseID");
						s5 = c.createStatement();
						String delete = "delete from `Section` where Section.SectionID = " + courseID;
						s5.executeUpdate(delete);
						delete = "delete from `Course` where Course.CourseID = " + courseID;
						Statement s7 = c.createStatement();
						s7.executeUpdate(delete);
						count--;
						JOptionPane.showMessageDialog(null, "Deletion Successful.", "Deletion Successful.", JOptionPane.INFORMATION_MESSAGE);
						comboBox.removeItem(course);
						
					} catch (SQLException e)
					{
						JOptionPane.showMessageDialog(null, "An unexpected error has occured.", "Error.", JOptionPane.ERROR_MESSAGE);
					}
					
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Deletion canceled.", "Deletion canceled.", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnRemoveCurrentlySelected.setBounds(10, 307, 232, 23);
		panel_1.add(btnRemoveCurrentlySelected);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try
				{
					String prev = (String)comboBox.getSelectedItem();
					String newCourse = JOptionPane.showInputDialog("Enter the new course name:");
					if(newCourse == null || newCourse.equals(""))
					{
						JOptionPane.showMessageDialog(null, "Update failed.", "Update failed.", JOptionPane.INFORMATION_MESSAGE);
						return;
					}
					else
					{
						String q = "Update `Course` set Course.CourseName = '" + newCourse + "' where Course.CourseName = '" + prev + "'";
						Statement s = c.createStatement();
						if (newCourse != null && !newCourse.equals(""))
							s.executeUpdate(q);
						else
						{
							JOptionPane.showMessageDialog(null, "Update canceled.", "Update canceled.", JOptionPane.INFORMATION_MESSAGE);
							return;
						}
						
						String q1 = "Select * from `Course` where Course.CourseName = '" + newCourse + "'";
						Statement s1 = c.createStatement();
						ResultSet rs = s1.executeQuery(q1);
						int id;
						if(rs.next())
							id = rs.getInt("CourseID");
						else
						{
							JOptionPane.showMessageDialog(null, "Update canceled.", "Update canceled.", JOptionPane.INFORMATION_MESSAGE);
							return;
						}
						
						String q2 = "Select * from `Section` where Section.SectionID = " + id;
						Statement s2 = c.createStatement();
						ResultSet rs1 = s2.executeQuery(q2);
						String section;
						if (rs1.next())
							section = rs1.getString("SectionName");
						else
						{
							JOptionPane.showMessageDialog(null, "Update canceled.", "Update canceled.", JOptionPane.INFORMATION_MESSAGE);
							return;
						}
						String[] arr = section.split(" ");
						String newSection = newCourse + " " + arr[1];
						String prevSec = prev + " " + arr[1];
						
						String q3 = "Update `Section` set Section.SectionName = '" + newSection + "' where Section.SectionName = '" + prevSec + "'";
						Statement s3 = c.createStatement();
						s3.executeUpdate(q3);
						JOptionPane.showMessageDialog(null, "Update Successful.", "Update Successful.", JOptionPane.INFORMATION_MESSAGE);
						
						comboBox.removeItem(prev);
						comboBox.addItem(newCourse);
						comboBox.setSelectedItem(newCourse);
					}
				} catch (Exception e)
				{
					JOptionPane.showMessageDialog(null, "An unexpected error has occured.", "Error.", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnEdit.setBounds(425, 72, 89, 23);
		panel_1.add(btnEdit);
		
		JButton button = new JButton("Edit");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try
				{
					String prev = (String)comboBox.getSelectedItem();
					String newSec = JOptionPane.showInputDialog("Enter the new section:");
					if(newSec == null || newSec.equals(""))
					{
						JOptionPane.showMessageDialog(null, "Update failed.", "Update failed.", JOptionPane.INFORMATION_MESSAGE);
						return;
					}
					else
					{
						String q = "select * from `Course` where Course.CourseName = '" + prev + "'";
						Statement s = c.createStatement();
						ResultSet rs = s.executeQuery(q);
						int id;
						if (rs.next())
							id = rs.getInt("CourseID");
						else
						{
							JOptionPane.showMessageDialog(null, "Update canceled.", "Update canceled.", JOptionPane.INFORMATION_MESSAGE);
							return;
						}	
						String update = prev + " " + newSec;
						Statement s1 = c.createStatement();
						s1.executeUpdate("update `Section` set Section.SectionName = '" + update + "' where Section.SectionID = " + id);
						JOptionPane.showMessageDialog(null, "Update Successful.", "Update Successful.", JOptionPane.INFORMATION_MESSAGE);
						comboBox.setSelectedItem(prev);
					}

				} catch (Exception e)
				{
					JOptionPane.showMessageDialog(null, "An unexpected error has occured.", "Error.", JOptionPane.ERROR_MESSAGE);
				}
				
				
			}
		});
		button.setBounds(425, 105, 89, 23);
		panel_1.add(button);
		
		JButton button_1 = new JButton("Edit");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try
				{
					String prev = (String)comboBox.getSelectedItem();
					String newSchedule = JOptionPane.showInputDialog("Enter the new schedule:");
					if(newSchedule == null || newSchedule.equals(""))
					{
						JOptionPane.showMessageDialog(null, "Update failed.", "Update failed.", JOptionPane.INFORMATION_MESSAGE);
						return;
					}
					else
					{
						String q = "select * from `Course` where Course.CourseName = '" + prev + "'";
						Statement s = c.createStatement();
						ResultSet rs = s.executeQuery(q);
						int id;
						if (rs.next())
							id = rs.getInt("CourseID");
						else
						{
							JOptionPane.showMessageDialog(null, "Update canceled.", "Update canceled.", JOptionPane.INFORMATION_MESSAGE);
							return;
						}
						
						Statement s1 = c.createStatement();
						s1.executeUpdate("update `Section` set Section.Schedule = '" + newSchedule + "' where Section.SectionID = " + id);
						JOptionPane.showMessageDialog(null, "Update Successful.", "Update Successful.", JOptionPane.INFORMATION_MESSAGE);
						comboBox.setSelectedItem(prev);
					}

				} catch (Exception e)
				{
					JOptionPane.showMessageDialog(null, "An unexpected error has occured.", "Error.", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		button_1.setBounds(425, 138, 89, 23);
		panel_1.add(button_1);
		
		JButton button_2 = new JButton("Edit");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try
				{
					String prev = (String)comboBox.getSelectedItem();
					String newLocation = JOptionPane.showInputDialog("Enter the new location:");
					if(newLocation == null || newLocation.equals(""))
					{
						JOptionPane.showMessageDialog(null, "Update failed.", "Update failed.", JOptionPane.INFORMATION_MESSAGE);
						return;
					}
					else
					{
						String q = "select * from `Course` where Course.CourseName = '" + prev + "'";
						Statement s = c.createStatement();
						ResultSet rs = s.executeQuery(q);
						int id;
						if (rs.next())
							id = rs.getInt("CourseID");
						else
						{
							JOptionPane.showMessageDialog(null, "Update canceled.", "Update canceled.", JOptionPane.INFORMATION_MESSAGE);
							return;
						}
						
						Statement s1 = c.createStatement();
						s1.executeUpdate("update `Section` set Section.Location = '" + newLocation + "' where Section.SectionID = " + id);
						JOptionPane.showMessageDialog(null, "Update Successful.", "Update Successful.", JOptionPane.INFORMATION_MESSAGE);
						comboBox.setSelectedItem(prev);
					}

				} catch (Exception e)
				{
					JOptionPane.showMessageDialog(null, "An unexpected error has occured.", "Error.", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		button_2.setBounds(425, 171, 89, 23);
		panel_1.add(button_2);
		
		JButton button_3 = new JButton("Edit");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try
				{
					String prev = (String)comboBox.getSelectedItem();
					String newProf = JOptionPane.showInputDialog("Enter the new professor:");
					if(newProf == null || newProf.equals(""))
					{
						JOptionPane.showMessageDialog(null, "Update failed.", "Update failed.", JOptionPane.INFORMATION_MESSAGE);
						return;
					}
					else
					{
						String q = "select * from `Course` where Course.CourseName = '" + prev + "'";
						Statement s = c.createStatement();
						ResultSet rs = s.executeQuery(q);
						int id;
						if (rs.next())
							id = rs.getInt("CourseID");
						else
						{
							JOptionPane.showMessageDialog(null, "Update canceled.", "Update canceled.", JOptionPane.INFORMATION_MESSAGE);
							return;
						}
						
						Statement s1 = c.createStatement();
						s1.executeUpdate("update `Section` set Section.Professor = '" + newProf + "' where Section.SectionID = " + id);
						JOptionPane.showMessageDialog(null, "Update Successful.", "Update Successful.", JOptionPane.INFORMATION_MESSAGE);
						comboBox.setSelectedItem(prev);
					}

				} catch (Exception e)
				{
					JOptionPane.showMessageDialog(null, "An unexpected error has occured.", "Error.", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		button_3.setBounds(425, 204, 89, 23);
		panel_1.add(button_3);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		tabbedPane.addTab("User Management", null, panel_3, null);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 46, 869, 15);
		panel_3.add(separator_1);
		
		JButton btnSearchAUsername = new JButton("Search this user");
		btnSearchAUsername.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try
				{
					String user = txtSearchAUsername.getText();
					String q12 = "select * from `User` where User.Username = '" + user + "'";
					Statement s12 = c.createStatement();
					ResultSet rs12 = s12.executeQuery(q12);
					
					String username, email, name, dob, sex, address, role;
					if(rs12.next())
					{
						username = user;
						email = rs12.getString("Email");
						name = rs12.getString("Name");
						dob = rs12.getString("DOB");
						sex = rs12.getString("Sex");
						address = rs12.getString("Address");
						role = rs12.getString("Role");
						
						label_2.setText(username);
						label_4.setText(email);
						label_6.setText(name);
						label_9.setText(dob);
						label_11.setText(sex);
						label_13.setText(address);
						label_17.setText(role);
					}
					else
						JOptionPane.showMessageDialog(null, "User not found.", "Invadil user.", JOptionPane.INFORMATION_MESSAGE);
				} catch (SQLException e)
				{
					JOptionPane.showMessageDialog(null, "An unexpected error has occured.", "Error.", JOptionPane.ERROR_MESSAGE);
				}
				
				
				
			}
		});
		btnSearchAUsername.setBounds(191, 11, 140, 23);
		panel_3.add(btnSearchAUsername);
		
		JButton btnDeleteThisUser = new JButton("Delete this user from database");
		btnDeleteThisUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String user = txtSearchAUsername.getText();
				String q = "delete from `User` where User.UserName = '" + user + "'";
				int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this user from the database?");
				try
				{
					if (option == 0)
					{
						Statement s = c.createStatement();
						s.executeUpdate(q);
						JOptionPane.showMessageDialog(null, "Deletion successful.", "Deletion successful.", JOptionPane.INFORMATION_MESSAGE);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Deletion canceled.", "Deletion canceled.", JOptionPane.INFORMATION_MESSAGE);
					}
				} catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		});
		btnDeleteThisUser.setBounds(20, 382, 241, 23);
		panel_3.add(btnDeleteThisUser);
		
		JLabel label_1 = new JLabel("Username : ");
		label_1.setBounds(20, 72, 161, 28);
		panel_3.add(label_1);
		
		label_2.setBounds(191, 72, 226, 28);
		panel_3.add(label_2);
		
		JLabel label_3 = new JLabel("Email : ");
		label_3.setBounds(20, 111, 161, 28);
		panel_3.add(label_3);
		
		label_4.setBounds(191, 111, 226, 28);
		panel_3.add(label_4);
		
		JLabel label_5 = new JLabel("Name : ");
		label_5.setBounds(20, 150, 161, 28);
		panel_3.add(label_5);
		
		label_6.setBounds(191, 150, 226, 28);
		panel_3.add(label_6);
		
		JLabel label_8 = new JLabel("Date of Birth (mm/dd/yy) : ");
		label_8.setBounds(20, 189, 161, 28);
		panel_3.add(label_8);
		
		label_9.setBounds(191, 189, 226, 28);
		panel_3.add(label_9);
		
		JLabel label_10 = new JLabel("Sex : ");
		label_10.setBounds(20, 228, 161, 28);
		panel_3.add(label_10);
		
		label_11.setBounds(191, 228, 226, 28);
		panel_3.add(label_11);
		
		JLabel label_12 = new JLabel("Address : ");
		label_12.setBounds(20, 267, 161, 28);
		panel_3.add(label_12);
		
		label_13.setBounds(191, 267, 226, 28);
		panel_3.add(label_13);
		
		JLabel label_16 = new JLabel("Role : ");
		label_16.setBounds(20, 306, 161, 28);
		panel_3.add(label_16);
		
		label_17.setBounds(191, 306, 226, 28);
		panel_3.add(label_17);
		
		txtSearchAUsername = new JTextField();
		txtSearchAUsername.setText("Search a username");
		txtSearchAUsername.setBounds(10, 12, 171, 20);
		panel_3.add(txtSearchAUsername);
		txtSearchAUsername.setColumns(10);
		
		JButton btnAddANew = new JButton("Add a new user to the database");
		btnAddANew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String username = JOptionPane.showInputDialog("Enter user's username:");
				if (username == null || username.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Update Canceled.", "Update Canceled.", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				String password = JOptionPane.showInputDialog("Enter user's password:");
				if (password == null || password.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Update Canceled.", "Update Canceled.", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				String email = JOptionPane.showInputDialog("Enter user's email:");
				if (email == null || email.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Update Canceled.", "Update Canceled.", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				String name = JOptionPane.showInputDialog("Enter user's name:");
				if (name == null || name.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Update Canceled.", "Update Canceled.", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				String dob = JOptionPane.showInputDialog("Enter user's date of birth (mm/dd/yy):");
				if (dob == null || dob.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Update Canceled.", "Update Canceled.", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				String sex = JOptionPane.showInputDialog("Enter the user's sex:");
				if (sex == null || sex.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Update Canceled.", "Update Canceled.", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				String address = JOptionPane.showInputDialog("Enter the user's address:");
				if (address == null || address.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Update Canceled.", "Update Canceled.", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				String role = JOptionPane.showInputDialog("Enter the user's role:");
				if (role == null || role.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Update Canceled.", "Update Canceled.", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				
				String insert = "insert into `User` values ('"+username+"','"+password+"','"+name+"','"+address+"','"+email+"','"+dob+"','"+sex+"','"+role+"')";
				try
				{
					Statement s = c.createStatement();
					s.executeUpdate(insert);
					JOptionPane.showMessageDialog(null, "Update Successful.", "Update Succussful.", JOptionPane.INFORMATION_MESSAGE);
				} catch (HeadlessException e)
				{
					e.printStackTrace();
				} catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		});
		btnAddANew.setBounds(608, 12, 241, 23);
		panel_3.add(btnAddANew);
		
		JButton btnNewButton = new JButton("Edit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try
				{
					String searchedUser = txtSearchAUsername.getText();
					String newStr = JOptionPane.showInputDialog("Enter the new username:");
					if(newStr == null || newStr.equals(""))
					{
						JOptionPane.showMessageDialog(null, "Update failed.", "Update failed.", JOptionPane.INFORMATION_MESSAGE);
						return;
					}
					else
					{
						String q = "update `User` set User.UserName = '" + newStr + "' where User.UserName = '" + searchedUser +"'";
						Statement s = c.createStatement();
						s.executeUpdate(q);
						JOptionPane.showMessageDialog(null, "Update Successful.", "Update Successful.", JOptionPane.INFORMATION_MESSAGE);
						txtSearchAUsername.setText(newStr);
						label_2.setText(newStr);
					}

				} catch (Exception e)
				{
					JOptionPane.showMessageDialog(null, "An unexpected error has occured.", "Error.", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(386, 71, 89, 23);
		panel_3.add(btnNewButton);
		
		JButton button_5 = new JButton("Edit");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try
				{
					String searchedUser = txtSearchAUsername.getText();
					String newStr = JOptionPane.showInputDialog("Enter the new email:");
					if(newStr == null || newStr.equals(""))
					{
						JOptionPane.showMessageDialog(null, "Update failed.", "Update failed.", JOptionPane.INFORMATION_MESSAGE);
						return;
					}
					else
					{
						String q = "update `User` set User.Email = '" + newStr + "' where User.UserName = '" + searchedUser +"'";
						Statement s = c.createStatement();
						s.executeUpdate(q);
						JOptionPane.showMessageDialog(null, "Update Successful.", "Update Successful.", JOptionPane.INFORMATION_MESSAGE);
						label_4.setText(newStr);
					}

				} catch (Exception e)
				{
					JOptionPane.showMessageDialog(null, "An unexpected error has occured.", "Error.", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		button_5.setBounds(386, 114, 89, 23);
		panel_3.add(button_5);
		
		JButton button_6 = new JButton("Edit");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try
				{
					String searchedUser = txtSearchAUsername.getText();
					String newStr = JOptionPane.showInputDialog("Enter the new name:");
					if(newStr == null || newStr.equals(""))
					{
						JOptionPane.showMessageDialog(null, "Update failed.", "Update failed.", JOptionPane.INFORMATION_MESSAGE);
						return;
					}
					else
					{
						String q = "update `User` set User.Name = '" + newStr + "' where User.UserName = '" + searchedUser +"'";
						Statement s = c.createStatement();
						s.executeUpdate(q);
						JOptionPane.showMessageDialog(null, "Update Successful.", "Update Successful.", JOptionPane.INFORMATION_MESSAGE);
						label_6.setText(newStr);
					}

				} catch (Exception e)
				{
					JOptionPane.showMessageDialog(null, "An unexpected error has occured.", "Error.", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		button_6.setBounds(386, 153, 89, 23);
		panel_3.add(button_6);
		
		JButton button_7 = new JButton("Edit");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try
				{
					String searchedUser = txtSearchAUsername.getText();
					String newStr = JOptionPane.showInputDialog("Enter the new date of birth (mm/dd/yy):");
					if(newStr == null || newStr.equals(""))
					{
						JOptionPane.showMessageDialog(null, "Update failed.", "Update failed.", JOptionPane.INFORMATION_MESSAGE);
						return;
					}
					else
					{
						String q = "update `User` set User.DOB = '" + newStr + "' where User.UserName = '" + searchedUser +"'";
						Statement s = c.createStatement();
						s.executeUpdate(q);
						JOptionPane.showMessageDialog(null, "Update Successful.", "Update Successful.", JOptionPane.INFORMATION_MESSAGE);
						label_9.setText(newStr);
					}

				} catch (Exception e)
				{
					JOptionPane.showMessageDialog(null, "An unexpected error has occured.", "Error.", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		button_7.setBounds(386, 192, 89, 23);
		panel_3.add(button_7);
		
		JButton button_8 = new JButton("Edit");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try
				{
					String searchedUser = txtSearchAUsername.getText();
					String newStr = JOptionPane.showInputDialog("Enter the new sex:");
					if(newStr == null || newStr.equals(""))
					{
						JOptionPane.showMessageDialog(null, "Update failed.", "Update failed.", JOptionPane.INFORMATION_MESSAGE);
						return;
					}
					else
					{
						String q = "update `User` set User.Sex = '" + newStr + "' where User.UserName = '" + searchedUser +"'";
						Statement s = c.createStatement();
						s.executeUpdate(q);
						JOptionPane.showMessageDialog(null, "Update Successful.", "Update Successful.", JOptionPane.INFORMATION_MESSAGE);
						label_11.setText(newStr);
					}

				} catch (Exception e)
				{
					JOptionPane.showMessageDialog(null, "An unexpected error has occured.", "Error.", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		button_8.setBounds(386, 231, 89, 23);
		panel_3.add(button_8);
		
		JButton button_9 = new JButton("Edit");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try
				{
					String searchedUser = txtSearchAUsername.getText();
					String newStr = JOptionPane.showInputDialog("Enter the new address:");
					if(newStr == null || newStr.equals(""))
					{
						JOptionPane.showMessageDialog(null, "Update failed.", "Update failed.", JOptionPane.INFORMATION_MESSAGE);
						return;
					}
					else
					{
						String q = "update `User` set User.Address = '" + newStr + "' where User.UserName = '" + searchedUser +"'";
						Statement s = c.createStatement();
						s.executeUpdate(q);
						JOptionPane.showMessageDialog(null, "Update Successful.", "Update Successful.", JOptionPane.INFORMATION_MESSAGE);
						label_11.setText(newStr);
					}

				} catch (Exception e)
				{
					JOptionPane.showMessageDialog(null, "An unexpected error has occured.", "Error.", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		button_9.setBounds(386, 270, 89, 23);
		panel_3.add(button_9);
		
		JButton button_11 = new JButton("Edit");
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try
				{
					String searchedUser = txtSearchAUsername.getText();
					String newStr = JOptionPane.showInputDialog("Enter the new role:");
					if (!newStr.equals("Professor") && !newStr.equals("Admin") && !newStr.equals("Student"))
					{
						JOptionPane.showMessageDialog(null, "Update failed.", "Update failed.", JOptionPane.ERROR_MESSAGE);
						return;
					}
					else if(newStr == null || newStr.equals(""))
					{
						JOptionPane.showMessageDialog(null, "Update failed.", "Update failed.", JOptionPane.INFORMATION_MESSAGE);
						return;
					}
					else
					{
						String q = "update `User` set User.Role = '" + newStr + "' where User.UserName = '" + searchedUser +"'";
						Statement s = c.createStatement();
						s.executeUpdate(q);
						JOptionPane.showMessageDialog(null, "Update Successful.", "Update Successful.", JOptionPane.INFORMATION_MESSAGE);
						label_17.setText(newStr);
					}

				} catch (Exception e)
				{
					JOptionPane.showMessageDialog(null, "An unexpected error has occured.", "Error.", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		button_11.setBounds(386, 309, 89, 23);
		panel_3.add(button_11);
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
			JOptionPane.showMessageDialog(null, "An unexpected error has occured.", "Error.", JOptionPane.ERROR_MESSAGE);
		}
		lblYouAreCurrently.setBounds(10, 522, 736, 23);
		frmEservices.getContentPane().add(lblYouAreCurrently);
		frmEservices.setTitle("eServices");
		frmEservices.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		frmEservices.setBounds(100, 100, 900, 600);
		frmEservices.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
