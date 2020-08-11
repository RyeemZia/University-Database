import java.io.Serializable;
import java.util.Scanner;
//interface
interface StudentInterface{
	void viewAll();
	void viewOpen();
	void register();
	void withdraw();
	void viewRegistered();
	
	}
//students 
public class Student extends User implements StudentInterface, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static Scanner input = new Scanner(System.in);
	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Student() {
		super();
	}
	public Student(String username, String password, String fname, String lname, String id) {
		super(username, password, fname, lname);
		this.id = id;
	}
//uses methods from  course registry
	@Override
	public void viewAll() {
		// TODO Auto-generated method stub
		CourseRegistry.crs.viewAll();
	}

	@Override
	public void viewOpen() {
		// TODO Auto-generated method stub
		CourseRegistry.crs.viewOpen();
	}

	@Override
	public void register() {
		// TODO Auto-generated method stub
		System.out.println("Enter course id:");
		String courseId = input.next();
		System.out.println("Enter course section:");
		int section = input.nextInt();
		
		CourseRegistry.crs.register(courseId,id, section);
	}

	@Override
	public void withdraw() {
		// TODO Auto-generated method stub
		System.out.println("Enter course name:");
		String courseName = input.next();
		CourseRegistry.crs.withdraw(courseName, id);
		
	}

	@Override
	public void viewRegistered() {
		// TODO Auto-generated method stub
		CourseRegistry.crs.viewStudentCourses(fname, lname);
		
	}

	
	

}
