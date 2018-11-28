import java.io.Serializable;
import java.util.ArrayList;

public class CourseList implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String[] list;
	int courseCount = 0;
	
	public CourseList()
	{
		this.list = new String[4];
	}
	
	public boolean search(String e)
	{
		for (int i=0; i<courseCount; i++)
		{
			if (list[i].equals(e))
				return true;
		} 
		return false;
	}
	
	public void add(String e)
	{
		if (courseCount < 4)
		{
			list[courseCount] = e;
			courseCount++;
		}
	}
	
	public void remove(String e)
	{
		if (courseCount > 0)
		{
			ArrayList<String> temp = new ArrayList<String>();
			for(int i=0; i<4; i++)
			{
				temp.add(list[i]);
			}
			temp.remove(e);
			
			for(int i=0; i<temp.size(); i++)
			{
				list[i] = temp.get(i);
			}
			courseCount--;
		}
	}
	
	public String[] getList()
	{
		return list;
	}
	
	public String get(int index)
	{
		return list[index];
	}
}
