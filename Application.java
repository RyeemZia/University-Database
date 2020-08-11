import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Application {
	public static void main(String args[]) throws IOException {
		File f = new File("data.ser");
		if(f.exists()) {
			deserialize();
		}
		else {
		String fileName = "MyUniversityCourses.csv";
		//References one line at a time
		String line = null;
		try{
			//FileReader reads text files as characters as opposed to bytes (like FileInputStream)
			
			
			FileReader fileReader = new FileReader(fileName);
			
			//The BufferedReader class can wrap around Readers, like FileReader, to buffer the input and improve efficiency.
			
			
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			//readLine() reads a line of text.
			
			bufferedReader.readLine();
			while((line = bufferedReader.readLine()) != null) {
				String [] array = line.split(",");
				String courseName = array[0];
				String id = array[1];
				int max = Integer.parseInt(array[2]);
				int current = Integer.parseInt(array[3]);
				String instructor = array[5];
				int section = Integer.parseInt(array[6]);
				String location = array[7];
				ArrayList <Student> A = new ArrayList<Student>();
				Course course = new Course(courseName, id, max, current, A, instructor,  section, location);
				CourseRegistry.crs.cArray.add(course);
			}

			//Always close files
			bufferedReader.close();
		}
		//The catch block performs a specific action depending on the exception
		catch(FileNotFoundException ex){
			System.out.println( "Unable to open file '" + fileName + "'");
			//the printStackTrace method will print out an error output stream ("What went wrong?" report);
			
			ex.printStackTrace();
		}

		catch (IOException ex) {
			System.out.println( "Error reading file '" + fileName + "'");
			ex.printStackTrace();
		}}
		int pass =0;
		
		Scanner input = new Scanner(System.in);
		String username = "Admin";
		String password = "Admin001";
		do {
		System.out.println("Are you an admin or student ? Enter a or s");
		String choice = input.next();
		if(choice.equals("a")) {
			String inputUsername;
			String inputPassword;
			System.out.println("Enter your username");
			inputUsername = input.next();
			System.out.println("Enter your password");
			inputPassword = input.next();
			if(inputUsername.equals(username) && inputPassword.equals(password)) {
				adminMenu();
				pass =1;
			}
			else {
				System.out.println("Wrong username or password");
				
			}
			
		}
		if(choice.equals("s")) {
			String inputUsername;
			String inputPassword;
			System.out.println("Enter your username");
			inputUsername = input.next();
			System.out.println("Enter your password");
			inputPassword = input.next();
			studentMenu(inputUsername, inputPassword);
			pass =1;
			
		}
	}while(pass!=1);
		
	}

	private static void studentMenu(String inputUsername, String inputPassword) {
		// TODO Auto-generated method stub
		//student menu uses do while loop and calls methods from student
		for (Student student: CourseRegistry.crs.allstudentArray) {
			if(student.getUsername().equals(inputUsername)) {
				if(student.getPassword().equals(inputPassword)) {
				int key;
				Scanner input = new Scanner(System.in);
				do {
					System.out.println("1. View all courses"
							+ "\n2. View all courses that are not full"
							+ "\n3. Register for a course"
							+ "\n4. Withdraw from a course "
							+ "\n5. View all courses you are registered in"
							+ "\n6. Exit");
							
					key = input.nextInt();
					switch(key){
					case 1:
						student.viewAll();
						break;
					case 2:
						student.viewOpen();
						break;
					case 3:
						student.register();
						serialization ();
						break;
					case 4:
						student.withdraw();
						serialization ();
						break;
					case 5:
						student.viewRegistered();
						break;
					}
					
				}while(key!=6);
				serialization ();
				
			
				}
			}
		}
		
		
	}

	private static void adminMenu() throws IOException {
		//menu for admin, do while, calls methods from admin
		// TODO Auto-generated method stub
		Admin one = new Admin("Admin","Admin001", "Bob", "Jones");
		int key;
		Scanner input = new Scanner(System.in);
		do {
			System.out.println("1. Add a course"
					+ "\n2. Delete a course"
					+ "\n3. Edit a course"
					+ "\n4. Display info of a course "
					+ "\n5. Register a student"
					+ "\n6. View all courses"
					+ "\n7. View all course that are full"
					+ "\n8. Write to a file of the courses that are full"
					+ "\n9. View names of students in a certain course"
					+ "\n10. View the list of courses that a student is registered in"
					+ "\n11. Sort the courses based on current number of students"
					+"\n12. Exit");
					
					
			key = input.nextInt();
			switch(key){
			case 1:
			one.add();
			serialization();
			break;
			case 2:
			one.delete();
			serialization();
			break;
			case 3:
			one.edit();
			serialization();
			break;
			case 4:
			one.display();
			break;
			case 5:
			one.register();
			serialization();
			break;
			case 6:
			one.view();	
			break;
			case 7:
			one.viewFull();	
			break;
			case 8:
			one.writeFull();
			break;
			case 9:
			one.viewSpecific();	
			break;
			case 10:
			one.viewStudentCourses();
			break;
			case 11:
			one.sortNumberRegistered();	
			serialization();
			break;
			}
			
		}while(key!=12);
		serialization ();
	
}
	public static void serialization () {

		
	//instantiate an Employee object
			//CourseRegistry serializedCourse = new Course(name, id,  max,current, A,instructor, section, location);
			//Course de = null;
			try {
				//FileOutput Stream writes data to a file
				FileOutputStream fos = new FileOutputStream("data.ser");
				
				//ObjectOutputStream writes objects to a stream (A sequence of data)
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				
				//Writes the specific object to the OOS
				oos.writeObject(CourseRegistry.crs);
				
				//Close both streams
				oos.close();
				fos.close();
			} 
			catch (IOException ioe) {
				ioe.printStackTrace();
			}
	}
	
	public static void deserialize() {
		try{
			  //FileInputSystem receives bytes from a file
		      FileInputStream fis = new FileInputStream("data.ser");
		      
		      //ObjectInputStream does the deserialization-- it reconstructs the data into an object
		      ObjectInputStream ois = new ObjectInputStream(fis);
		      
		      // readObject will take the object from ObjectInputStream
		      CourseRegistry.crs = (CourseRegistry)ois.readObject();
		      ois.close();
		      fis.close();
		    }
		    catch(IOException ioe) {
		       ioe.printStackTrace();
		       return;
		    }
		 catch(ClassNotFoundException cnfe) {
		       cnfe.printStackTrace();
		       return;
		     }

		 }
}


