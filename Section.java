import java.io.Serializable;

public class Section implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	CourseTime time;
	String sectionName;
	int sectionID;
	String professor;
	Course course;
	String fullCourseName;
	Student[] studentList;
	
	public Section(CourseTime time, String name, int id, String prof, Course crs)
	{
		this.time = time;
		this.sectionName = name;
		this.sectionID = id;
		this.professor = prof;
		this.course = crs;
		this.fullCourseName = course.getCourseName() + " " + sectionName;
		this.studentList = new Student[10];
	}
	
	public String getProfessor()
	{
		return professor;
	}
	
	public CourseTime getTime()
	{
		return time;
	}
	
	public String getSectionName()
	{
		return sectionName;
	}
	
	public int getSectionID()
	{
		return sectionID;
	}
	
	public Course getCourse()
	{
		return course;
	}
	
	public String getFullCourseName()
	{
		return fullCourseName;
	}
	
	public Student[] getStudentList()
	{
		return studentList;
	}
	
}
