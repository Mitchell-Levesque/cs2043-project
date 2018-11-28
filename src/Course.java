import java.io.Serializable;

public class Course implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int courseID;
	String courseName;
	Course[] preReq;
	
	public Course(int id, String name, Course[] preReq)
	{
		this.courseID = id;
		this.courseName = name;
		this.preReq = preReq;
	}
	
	public int getCourseID()
	{
		return courseID;
	}
	
	public String getCourseName()
	{
		return courseName;
	}
	
	public Course[] getPreReq()
	{
		return preReq;
	}
	
	public boolean checkIfElig(Course[] t)
	{
		return true;
		// didnt have time to implement :(
	}
}
