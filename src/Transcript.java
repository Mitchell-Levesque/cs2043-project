import java.io.Serializable;

public class Transcript implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Course[] transcript;
	String studentUser;
	int countCompleted;
	
	public Transcript(String username)
	{
		this.studentUser = username;
		this.transcript = new Course[10];
		this.countCompleted = 0;
	}
	
	public boolean search(Course c)
	{
		return true;
	}
	
	public void add(Course c)
	{
		// add course
	}
	
	public void remove(Course c)
	{
		// add code
	}
	
	public Course[] getTranscript()
	{
		return transcript;
	}
}
