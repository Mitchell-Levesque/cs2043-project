import java.io.Serializable;


public class CourseTime implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int id;
	String days;
	String time;
	Semester semester;
	
	public CourseTime(int id, String days, String time, Semester semester)
	{
		this.id = id;
		this.days = days;
		this.time = time;
		this.semester = semester;
	}
	
	public int getID()
	{
		return id;
	}
	
	public String getDays()
	{
		return days;
	}
	
	public String getTime()
	{
		return time;
	}
	
	public Semester getSemester()
	{
		return semester;
	}
	
	public String getFullTime()
	{
		return days + " " + time;
	}
}
