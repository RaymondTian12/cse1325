public class Student
{
	private String name;
	private int id;
	private String email;
	private Account account;
	
	public Student(String name, int id, String email)
	{
		if (!email.endsWith("@uta.edu") && !email.endsWith("@mavs.uta.edu"))
		{
			throw new IllegalArgumentException("Non-UTA email addres: " + email);
		}
		
		this.name = name;
		this.id = id;
		this.email = email;
		this.account = account;
	}
	
	public String requestMedia(Media media)
	{
		return account.play(media);
	}
}
