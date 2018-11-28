import java.io.Serializable;

public class User implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String username;
	String password;
	String name;
	String address;
	String email;
	String dob;
	String sex;
	String role;
	
	public User(String username, String password, String name, String email, String dob, String sex, String role)
	{
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
		this.dob = dob;
		this.sex = sex;
		this.role = role;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getRole()
	{
		return role;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public String getAddress()
	{
		return address;
	}
	
	public String getDob()
	{
		return dob;
	}
	
	public String getSex()
	{
		return sex;
	}
}
