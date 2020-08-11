import java.io.Serializable;
import java.util.ArrayList;

public class Course implements Comparable<Course>, Serializable{
	private static final long serialVersionUID = 40L;
	private String name;
	private String id;
	private int max;
	private int current;
	private String instructor;
	private int section;
	private String location;
	ArrayList<Student> sArray;
	public Course() {
		this.name = "";
		this.id = "";
		this.max = 0;
		this.current = 0;
		this.instructor = "";
		this.section = 0;
		this.location = "";
		
		
	}
	
	public Course(String name, String id, int max, int current, ArrayList <Student> A, String instructor, int section, String location) {
		this.name = name;
		this.id = id;
		this.max = max;
		this.current = current;
		this.instructor = instructor;
		this.section = section;
		this.location = location;
		sArray = A;
	}

	public ArrayList<Student> getsArray() {
		return sArray;
	}

	public void setsArray(ArrayList<Student> sArray) {
		this.sArray = sArray;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public int getCurrent() {
		return current;
	}

	public void setCurrent(int current) {
		this.current = current;
	}

	public String getNames() {
		return name;
	}

	public void setNames(String names) {
		this.name = names;
	}

	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	public int getSection() {
		return section;
	}

	public void setSection(int section) {
		this.section = section;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public int compareTo(Course o) {
		// TODO Auto-generated method stub
		//compare to compares courses based on current size
		if (this.current < o.current)
			return -1;
		else if (this.current == o.current)
			return 0;
		else
			return 1;
	}
	
	
	
	
	

}
