import java.io.Serializable;

public class Admin extends User implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Admin(int id, String username, String password, String name, String email, String dob, String sex)
	{
		super(username, password, name, email, dob, sex, "Admin");
	}
	
	public void addStudent(Student s)
	{
		// do whatever
	}
	
	public void addProfessor(Professor p)
	{
		// do whatever
	}
	
	public void addAdmin(Admin a)
	{
		// do whatever
	}
	
	public void addCourse(Course c)
	{
		// do whatever
	}
	
	public void clearCourses()
	{
		// do whatever
	}
}
