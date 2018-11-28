import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import java.awt.TextArea;

public class GUIProfessor {

	private JFrame frmEservices;
	private JLabel lblCourseAns = new JLabel("");
	private JLabel label_7 = new JLabel("");
	private TextArea textArea = new TextArea();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIProfessor window = new GUIProfessor();
					window.frmEservices.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUIProfessor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
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
		
		JLabel lblUsersUsername = new JLabel("mleves10");
		lblUsersUsername.setBounds(196, 28, 226, 28);
		panel.add(lblUsersUsername);
		
		JLabel lblUsersEmail = new JLabel("mleves10@unb.ca");
		lblUsersEmail.setBounds(196, 67, 226, 28);
		panel.add(lblUsersEmail);
		
		JLabel lblUsersName = new JLabel("Mitchell Levesque");
		lblUsersName.setBounds(196, 106, 226, 28);
		panel.add(lblUsersName);
		
		JLabel lblUsersDOB = new JLabel("9/17/1999");
		lblUsersDOB.setBounds(196, 145, 226, 28);
		panel.add(lblUsersDOB);
		
		JLabel lblUsersSex = new JLabel("Male");
		lblUsersSex.setBounds(196, 184, 226, 28);
		panel.add(lblUsersSex);
		
		JLabel lblAddress = new JLabel("Address : ");
		lblAddress.setBounds(25, 223, 161, 28);
		panel.add(lblAddress);
		
		JLabel lblUsersAddress = new JLabel("59 Coral Road");
		lblUsersAddress.setBounds(196, 223, 226, 28);
		panel.add(lblUsersAddress);
		
		JLabel lblRole = new JLabel("Role : ");
		lblRole.setBounds(25, 301, 161, 28);
		panel.add(lblRole);
		
		JLabel lblUsersRole = new JLabel("Professor");
		lblUsersRole.setBounds(196, 301, 226, 28);
		panel.add(lblUsersRole);
		
		JButton btnChangeEmailAddress = new JButton("Update my email address...");
		btnChangeEmailAddress.setBounds(432, 70, 213, 23);
		panel.add(btnChangeEmailAddress);
		
		JButton btnChangeMyAddress = new JButton("Update my address...");
		btnChangeMyAddress.setBounds(432, 226, 213, 23);
		panel.add(btnChangeMyAddress);
		
		JLabel label = new JLabel("506 - 123 - 4567");
		label.setBounds(196, 262, 226, 28);
		panel.add(label);
		
		JLabel lblPhone = new JLabel("Phone : ");
		lblPhone.setBounds(25, 262, 161, 28);
		panel.add(lblPhone);
		
		JButton btnChangeMyPhone = new JButton("Update my phone number...");
		btnChangeMyPhone.setBounds(432, 265, 213, 23);
		panel.add(btnChangeMyPhone);
		
		JButton btnUpdateMyPassword = new JButton("Update my password...");
		btnUpdateMyPassword.setBounds(25, 380, 213, 23);
		panel.add(btnUpdateMyPassword);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Currently Teaching", null, panel_1, null);
		panel_1.setLayout(null);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String course = (String) comboBox.getSelectedItem();
				lblCourseAns.setText(course);
			}
		});
		comboBox.setBounds(190, 13, 126, 22);
		comboBox.addItem("CS 2043");
		comboBox.addItem("CS 2383");
		comboBox.addItem("CS 2263");
		comboBox.addItem("STAT 2793");
		comboBox.addItem("ECE 2214");
		comboBox.addItem("ECE 2215");
		panel_1.add(comboBox);
		
		JLabel lblSelectedCourse = new JLabel("You currently teach :");
		lblSelectedCourse.setBounds(10, 15, 170, 18);
		panel_1.add(lblSelectedCourse);
		
		JButton btnDropCurrentlySelected = new JButton("Drop currently selected course");
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
		
		JLabel lblSectionAns = new JLabel("SJ01B");
		lblSectionAns.setHorizontalAlignment(SwingConstants.LEFT);
		lblSectionAns.setBounds(135, 105, 215, 22);
		panel_1.add(lblSectionAns);
		
		JLabel lblScheduleAns = new JLabel("MWF 12:30pm - 1:20pm");
		lblScheduleAns.setHorizontalAlignment(SwingConstants.LEFT);
		lblScheduleAns.setBounds(135, 138, 215, 22);
		panel_1.add(lblScheduleAns);
		
		JLabel lblLocationAns = new JLabel("Oland Hall G31");
		lblLocationAns.setHorizontalAlignment(SwingConstants.LEFT);
		lblLocationAns.setBounds(135, 171, 140, 22);
		panel_1.add(lblLocationAns);
		
		JLabel lblProfessorAns = new JLabel("Prabhat Mahanti");
		lblProfessorAns.setHorizontalAlignment(SwingConstants.LEFT);
		lblProfessorAns.setBounds(135, 204, 140, 22);
		panel_1.add(lblProfessorAns);
		
		JLabel lblProfessorEmail = new JLabel("Professor email :");
		lblProfessorEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lblProfessorEmail.setBounds(10, 237, 140, 22);
		panel_1.add(lblProfessorEmail);
		
		JLabel lblPmahantiunbca = new JLabel("pmahanti@unb.ca");
		lblPmahantiunbca.setHorizontalAlignment(SwingConstants.LEFT);
		lblPmahantiunbca.setBounds(135, 237, 140, 22);
		panel_1.add(lblPmahantiunbca);
		
		JButton btnViewCourseList = new JButton("View course list");
		btnViewCourseList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String classlist = "Mitchell Levesque	-	mleves10\r\n" + 
						"Shae-Lynn Murray	-	smurray6\r\n" + 
						"Jonathan Landry	-	jlandr12\r\n" + 
						"Joshua Logan 		- 	jlogan4\r\n" + 
						"Ken Guay		-	kguay8\r\n";
				textArea.append(classlist);
			}
		});
		btnViewCourseList.setBounds(356, 59, 140, 23);
		panel_1.add(btnViewCourseList);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setBounds(331, 46, 1, 426);
		panel_1.add(separator_3);
		textArea.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textArea.setBounds(356, 100, 493, 362);
		panel_1.add(textArea);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		tabbedPane.addTab("Teach a Course", null, panel_3, null);
		
		JComboBox<String> comboBox_1 = new JComboBox<String>();
		comboBox_1.setBounds(190, 13, 126, 22);
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String course = (String) comboBox_1.getSelectedItem();
				label_7.setText(course);
			}
		});
		comboBox_1.setBounds(190, 13, 126, 22);
		comboBox_1.addItem("CS 2043");
		comboBox_1.addItem("CS 2383");
		comboBox_1.addItem("CS 2263");
		comboBox_1.addItem("STAT 2793");
		comboBox_1.addItem("ECE 2214");
		comboBox_1.addItem("ECE 2215");
		panel_3.add(comboBox_1);
		
		JLabel lblCurrentlyOfferedCourses = new JLabel("Currently offered courses :");
		lblCurrentlyOfferedCourses.setBounds(10, 15, 170, 18);
		panel_3.add(lblCurrentlyOfferedCourses);
		
		JButton btnEnrollInCurrently = new JButton("Teach currently selected course");
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
		label_7.setBounds(160, 72, 241, 22);
		panel_3.add(label_7);
		
		JLabel label_8 = new JLabel("SJ01B");
		label_8.setHorizontalAlignment(SwingConstants.LEFT);
		label_8.setBounds(160, 105, 241, 22);
		panel_3.add(label_8);
		
		JLabel label_9 = new JLabel("MWF 12:30pm - 1:20pm");
		label_9.setHorizontalAlignment(SwingConstants.LEFT);
		label_9.setBounds(160, 138, 241, 22);
		panel_3.add(label_9);
		
		JLabel label_10 = new JLabel("Oland Hall G31");
		label_10.setHorizontalAlignment(SwingConstants.LEFT);
		label_10.setBounds(160, 171, 140, 22);
		panel_3.add(label_10);
		
		JLabel lblUnknown = new JLabel("Unknown");
		lblUnknown.setHorizontalAlignment(SwingConstants.LEFT);
		lblUnknown.setBounds(160, 204, 140, 22);
		panel_3.add(lblUnknown);
		
		JLabel label_12 = new JLabel("Professor email :");
		label_12.setHorizontalAlignment(SwingConstants.LEFT);
		label_12.setBounds(10, 237, 140, 22);
		panel_3.add(label_12);
		
		JLabel lblUnknown_1 = new JLabel("Unknown");
		lblUnknown_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblUnknown_1.setBounds(160, 237, 140, 22);
		panel_3.add(lblUnknown_1);
		
		JLabel lblPrerequisiteCourses = new JLabel("Prerequisite courses :");
		lblPrerequisiteCourses.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrerequisiteCourses.setBounds(10, 270, 140, 22);
		panel_3.add(lblPrerequisiteCourses);
		
		JLabel lblCs = new JLabel("CS 1073, CS 1083");
		lblCs.setHorizontalAlignment(SwingConstants.LEFT);
		lblCs.setBounds(162, 270, 140, 22);
		panel_3.add(lblCs);
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmEservices.dispose();
			}
		});
		btnLogOut.setBounds(756, 522, 118, 23);
		frmEservices.getContentPane().add(btnLogOut);
		
		JLabel lblYouAreCurrently = new JLabel("You are currently logged in as Mitchell Levesque.");
		lblYouAreCurrently.setBounds(10, 522, 736, 23);
		frmEservices.getContentPane().add(lblYouAreCurrently);
		frmEservices.setTitle("eServices - mleves10");
		frmEservices.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		frmEservices.setBounds(100, 100, 900, 600);
		frmEservices.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
