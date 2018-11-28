import java.io.Serializable;

public class Student extends User implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	CourseList courseList;
	CourseTime[] schedule; // not implemented
	Transcript transcript; // not implemented
	int courseCount = 0;
	
	public Student(String username, String password, String name, String email, String dob, String sex)
	{
		super(username, password, name, email, dob, sex, "Student");
		courseList = new CourseList();
		transcript = new Transcript(this.username);
		schedule = new CourseTime[4];
	}
	public CourseList getCourseList()
	{
		return courseList;
	}
	
	public CourseTime[] getSchedule()
	{
		return schedule;
	}
	
	public void enroll(String courseName)
	{
		courseList.add(courseName);
		courseCount++;
	}
	
	public void remove(String courseName)
	{
		courseList.remove(courseName);
		courseCount--;
	}
	
	public Transcript getTranscript()
	{
		return transcript;
	}
	
	public boolean checkAvailable(CourseTime c)
	{
		// didn't have time to implement checking for time confliction
		return false;
	}
	
	public int getCourseCount()
	{
		return courseCount;
	}
}
