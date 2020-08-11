import java.io.IOException;
import java.io.Serializable;
import java.util.Collections;
//admin implements user
//interface for methods
interface Admininterface{
	void add();
	void delete();
	void edit();
	void display();
	void register();
	void view();
	void viewFull();
	void writeFull() throws IOException;
	void viewSpecific();
	void viewStudentCourses();
	void sortNumberRegistered();
}
public class Admin extends User implements Admininterface, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5L;

	Admin(){
		super();
	}
	Admin(String username, String password, String fname, String lname){
		super(username, password, fname, lname);
		
	}

	@Override
	public void add() {
		// TODO Auto-generated method stub
		CourseRegistry.crs.addCourse();
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		CourseRegistry.crs.deleteCourse();
	}

	@Override
	public void edit() {
		// TODO Auto-generated method stub
		CourseRegistry.crs.editCourse();
		
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		CourseRegistry.crs.display();
		
	}

	@Override
	public void register() {
		// TODO Auto-generated method stub
		CourseRegistry.crs.register();
		
	}

	@Override
	public void view() {
		// TODO Auto-generated method stub
		CourseRegistry.crs.viewAll();
		
	}

	@Override
	public void viewFull() {
		// TODO Auto-generated method stub
		CourseRegistry.crs.viewAllFull();
		
	}

	@Override
	public void writeFull() throws IOException {
		// TODO Auto-generated method stub
		CourseRegistry.crs.write();
		
	}

	@Override
	public void viewSpecific() {
		// TODO Auto-generated method stub
		CourseRegistry.crs.viewCertainCourseStudents();
		
	}

	@Override
	public void viewStudentCourses() {
		// TODO Auto-generated method stub
		CourseRegistry.crs.viewStudentCourses();
		
	}

	@Override
	public void sortNumberRegistered() {
		// TODO Auto-generated method stub
		Collections.sort(CourseRegistry.crs.cArray);
	}
	
	

}
