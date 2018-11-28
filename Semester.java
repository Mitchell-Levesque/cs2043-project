import java.io.Serializable;
import java.util.Date;

public class Semester implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String name;
	Date finalEnrollmentDate;
	CourseList offeredCourses;
	
	public Semester(String name, Date finalDate)
	{
		this.name = name;
		this.finalEnrollmentDate = finalDate;
		this.offeredCourses = new CourseList();
	}
	
	public String getName()
	{
		return name;
	}
	
	public Date getFinalEnrollmentDate()
	{
		return finalEnrollmentDate;
	}
}
