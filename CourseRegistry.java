import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;
public class CourseRegistry extends ArrayList<Course>  implements Serializable{
	private static final long serialVersionUID = 43L;
	//implements serialializable
	//set a static course array that can be changed throughout the program
	public static CourseRegistry crs = new CourseRegistry();
	ArrayList <Course> cArray;
	ArrayList<Student> allstudentArray;
	//constructor
	CourseRegistry(){
		cArray = new ArrayList<Course>();
		allstudentArray = new ArrayList<Student>();
	}
	
	
	static Scanner input = new Scanner(System.in);
	
	public void addCourse() {
		//adds course, asks for info then creates a course to add
		String name;
		String id;
		int max;
		int current;
		String instructor;
		int section;
		String location;
		
		System.out.println("Enter info for course in this order with a comma in between each piece: name,id,max,currentnumber,instructor,section,location");
		String Info = "";
		Info  = input.nextLine();
		String [] info = Info.split(",");
		name = info[0];
		id = info[1];
		max= Integer.parseInt(info[2]);
		current= Integer.parseInt(info[3]);
		instructor= info[4];
		section= Integer.parseInt(info[5]);
		location = info[6];
		Course course= new Course();
		course.setsArray(new ArrayList<Student>());
		course.setName(name);
		course.setId(id);
		course.setMax(max);
		course.setCurrent(current);
		course.setInstructor(instructor);
		course.setSection(section);
		course.setLocation(location);
		cArray.add(course);
		System.out.println("Course added");
	}
	public void deleteCourse() 
	{
		//deletes course based on the name of the course
		String id;
		int section;
		System.out.println("Enter the id:");
		id = input.next();
		System.out.println("Enter the section:");
		section = input.nextInt();
		
		
		input.nextLine();
		for(Course course: cArray) {
			if(course.getSection()== section&& course.getId().equals(id)){
				cArray.remove(course);
				System.out.println("Course id: " + id +  " Removed.");
				return;
			}
		}
		System.out.println("Course does not exist.");
		return;
	}
	public void editCourse() {
		//edits course with new course info except name and id
	
		String name;
		int max;
		int current;
		String instructor;
		int section;
		String location;
		String Info = "";
		System.out.println("Enter info for course in this order with a comma in between each piece: name,id,max,currentnumber,instructor,section,location");
		Info  = input.nextLine();
		String [] info = Info.split(",");
		name = info[0];
		max= Integer.parseInt(info[1]);
		current= Integer.parseInt(info[2]);
		instructor= info[3];
		section= Integer.parseInt(info[4]);
		location = info[5];
		for(Course course: cArray) {
			if(course.getName().equals(name)){
		course.setMax(max);
		course.setCurrent(current);
		course.setInstructor(instructor);
		course.setSection(section);
		course.setLocation(location);
		System.out.println("Course edited.");
		
		return;
	}}
		System.out.println("The course does not exist.");
		}
	public void display() {
		//displays the course info based on its id
		System.out.println("Enter course id:");
		String id = input.next();
		System.out.println("Enter course section:");
		int section = input.nextInt();
		input.nextLine();
		for(Course course: cArray) {
			if(course.getSection()== section&& course.getId().equals(id)){
				System.out.println(course.getName());
				System.out.println(course.getId());
				System.out.println (course.getMax());
				System.out.println (course.getCurrent());
				System.out.println (course.getInstructor());
				System.out.println (course.getSection());
				System.out.println (course.getLocation());
				return;
			}
	}System.out.println("Course does not exist.");
	return;
		
	}
	public void register() {
		//registers a student to the system but not a course
		String fname;
		String lname;
		String username;
		String password;
		String id;
		Student student = new Student();
		System.out.println("Enter info for student in this order with a comma in between each piece: username,password,firstname,lastname,id");
		String Info = "";
		Info  = input.nextLine();
		String [] info = Info.split(",");
		username = info[0];
		password = info[1];
		fname = info[2];
		lname = info[3];
		id = info[4];
		student.setUsername(username);
		student.setPassword(password);
		student.setFname(fname);
		student.setLname(lname);
		student.setId(id);
		allstudentArray.add(student);
		}
	public void viewAll() {
		//views all courses
		for(Course course: cArray) {
			System.out.println(course.getName());
			for(Student student: course.sArray) {
				System.out.println("Name:"+ student.getFname() + " "+ student.getLname() + " id: " + student.getId());
				System.out.println("current number: " + course.getCurrent());
				System.out.println("max number: " + course.getMax());
			}
		}
	}
	public void viewAllFull() {
		//views all courses that are full
		for(Course course: cArray) {
			if(course.getCurrent()== course.getMax()) {
			System.out.println(course.getName());
			for(Student student: course.sArray) {
				System.out.println("Name:"+ student.getFname() + " "+ student.getLname() + " id: " + student.getId());
				System.out.println("current number: " + course.getCurrent());
				System.out.println("max number: " + course.getMax());
			}
		}
		}
	}
	public void writeFile() {
		
	}
	public void viewCertainCourseStudents() {
		//views students in a given course
		int section;
		String id;
		System.out.println("section: ");
		section = input.nextInt();
		System.out.println("id: ");
		id = input.next();
		input.nextLine();
		
		
		
		for(Course course: cArray) {
			if(course.getSection()== section&& course.getId().equals(id)) {
				for(Student student : course.sArray ) {
				System.out.println(student.getFname() + " " + student.getLname());
				
			}
		}}
	}
	public void viewStudentCourses() {
		//views courses that a entered student is in 
		String fname;
		String lname;
		System.out.println("Enter first name: ");
		fname = input.next();
		System.out.println("Enter last name: ");
		lname = input.next();
		ArrayList <String> enrolledcourses = new ArrayList<String>();
		for(Course course: cArray) {
			for(Student student: course.sArray) {
				if(student.getFname().equals(fname) && student.getLname().equals(lname)) {
					enrolledcourses.add(course.getName());
					
				}
			}
		}
		System.out.println(fname + " "+ lname + " is enrolled in: ");
		for(String enrolled: enrolledcourses) {
			System.out.println(enrolled);
		}
		
		input.nextLine();
	}
	public void viewStudentCourses(String fname, String lname) {
		//overloading previous method for when a student calls this
		ArrayList <String> enrolledcourses = new ArrayList<String>();
		for(Course course: cArray) {
			for(Student student: course.sArray) {
				if(student.getFname().equals(fname) && student.getLname().equals(lname)) {
					enrolledcourses.add(course.getName());
				}
			}
		}
		System.out.println(fname + " "+ lname + " is enrolled in: ");
		for(String enrolled: enrolledcourses) {
			System.out.println(enrolled);
		}
		if(enrolledcourses.isEmpty()) {
			System.out.println("Student is not enrolled in any courses.");
			
		}
		
	}
	
	public void viewOpen() {
		//views all courses that are not full
		for(Course course: cArray) {
			if(course.getCurrent() < course.getMax()) {
			System.out.println(course.getName());
		}
		}
	}
	public void register(String courseId, String id,int section) {
		//registers a student to a course based on their id
		for(Course course: cArray) {
			if(course.getId().equals(courseId)&& course.getSection() == section&& course.getCurrent() < course.getMax()) {
				for(Student student: allstudentArray) {
					if(student.getId().equals(id)){
						course.sArray.add(student);
						System.out.println("Registered.");
						return;
					}
				}
			}
		}
		System.out.println("The course is full or does not exist.");
		return;
	}
	
	public void withdraw(String courseName, String id) {
		//withdraws a student
		for(Course course: cArray) {
				for(Student student: course.sArray) {
					if(student.getId().equals(id)){
				course.sArray.remove(student);
				System.out.println("Withdrawn.");
				return;}
				
		}
		
	}System.out.println("Not enrolled in: " + courseName );
		
	}
	public void write() throws IOException {
		//writes to a file if it is full
		for(Course course: cArray) {
			if(course.getCurrent()== course.getMax()) {
				FileWriter myWriter = new FileWriter("full.txt");
			      myWriter.write(course.getName());
			      myWriter.close();
		}
		}
	}
	

	}
