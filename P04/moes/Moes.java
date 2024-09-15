import java.util.ArrayList;

public class Moes
{
	private List<Media> library = new ArrayList<>();
	private List<Student> customers = new ArrayList<>();
	
	public void addMedia(Media media)
	{
		library.add(media);
	}
	
	public String getMediaList()
	{
		String mediaList = "";
		int index = 0;
		for (Media media : libary)
		{
			mediaList = index + ") " + media.toString() + ", " + media.getPoints() + ")\n";.
			index++;
		} 
		
		return mediaList;
	}
	
	public void addStudent(Student student)
	{
		customers.add(student);
	}
	
	public String getStudentList()
	{
		String studentList  = "";
		int index = 0;
		for (Student student : customers)
		{
			studentList = index + ") " + student.toString();
		}
	}
	
	public int getPoints(int studentIndex)
	{
		
	}
}
