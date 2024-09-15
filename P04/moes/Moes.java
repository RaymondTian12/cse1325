import java.util.ArrayList;
import product.Media;
import customer.Student;
import customer.Account;
import customer.Alacarte;
import customer.Unlimited;

public class Moes
{
	private ArrayList<Media> library = new ArrayList<>();
	private ArrayList<Student> customers = new ArrayList<>();
	
	public void addMedia(Media media)
	{
		library.add(media);
	}
	
	public String getMediaList()
	{
		String mediaList = "";
		int index = 0;
		for (Media media : library)
		{
			mediaList = index + ") " + media.toString() + ", " + media.getPoints() + ")\n";
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
		
		return studentList;
	}
	
	public int getPoints(int studentIndex)
	{
		Student student = customers.get(studentIndex); // ArrayList: get used to return element
		Account account = student.getAccount();
		
		if (account instanceof Alacarte)
		{
			return ((Alacarte) account).getPointsRemaining(); 
		}
		else if (account instanceof Unlimited)
		{
			return Integer.MAX_VALUE;
		}
		else
		{
			throw new UnsupportedOperationException("Unknown subclass of Account");
		}
	}
	
	public String buyPoints(int studentIndex, int points)
	{
		Student student = customers.get(studentIndex); 
		Account account = student.getAccount();
		
		if (account instanceof Alacarte)
		{
			((Alacarte) account).buyPoints(points);
			return "Student now has " + ((Alacarte) account).getPointsRemaining() + " points";
		}
		else if (account instanceof Unlimited)
		{
			return "Student has an unlimited account and needs now additional points";
		}
		else
		{
			throw new UnsupportedOperationException("Unknown subclass of Account");
		}
	}
	
	public String playMedia(int studentIndex, int mediaIndex)
	{
		Student student = customers.get(studentIndex);
		Media media = library.get(mediaIndex);
		
		return student.requestMedia(media);
	}
	
}
