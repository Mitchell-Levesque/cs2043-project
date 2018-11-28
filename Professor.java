import java.io.Serializable;

public class Professor extends User implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	CourseList courseList;
	String department;
	
	public Professor(int id, String username, String password, String name, String email, String dob, String sex, String department)
	{
		super(username, password, name, email, dob, sex, "Professor");
		this.courseList = new CourseList();
		this.department = department;
	}
	
	public void teach(Section e)
	{
		// didn't have time to implement
	}
	
	public String getDepartment()
	{
		return department;
	}
	
	public CourseList getCourseList()
	{
		return courseList;
	}
}
