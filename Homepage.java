import java.util.*;
import java.io.*;
import java.util.regex.*;

public class Homepage implements Login {

	static BufferedReader readerobj = new BufferedReader(new InputStreamReader(System.in));

	private int[] enterMark() throws IOException {
		int[] mark = new int[5];
		System.out.println("Enter the mark");
		for (int i = 0; i < 5; i++)
			mark[i] = Integer.parseInt(readerobj.readLine());
		return mark;
	}

	private String getandCheckPassword() throws IOException {
		System.out.println(
				"Enter The password For your Account.Password should contains Uppercase Lowercase Alphanumberic");
		String password = readerobj.readLine();
		Pattern pattern = Pattern.compile("^(?=.*[0-9])\"\n" + "        + \"(?=.*[a-z])(?=.*[A-Z])\"\n"
				+ "        + \"(?=.*[@#$%^&+=])\"\n" + "        + \"(?=\\\\S+$).{8,20}$");
		Matcher match = pattern.matcher(password);
		boolean istrue = true;
		while (istrue) {
			if (!(match.matches()) && (password.length() <= 8)) {
				System.out.println(
						"Password should contains upppercase,lowercase,Alphanumberic,length should greater than 8");
				istrue = true;
				password = readerobj.readLine();
			} else {
				System.out.println("Reenter the password");
				String reenterpass = readerobj.readLine();
				if (reenterpass.equals(password)) {
					// AccountCreationObj.setpassword(password);
					System.out.println("Password Created");
					istrue = false;
				} else {
					System.out.println("Password Mismatch");
					istrue = true;
				}
			}
		}
		return password;
	}

	private String getandCheckEmail() throws IOException, Exception {
		String email = readerobj.readLine();
		Pattern pattern = Pattern.compile("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$");
		Matcher matcher = pattern.matcher(email);
		if (!matcher.find())
			throw new Exception();
		return email;
	}

	@Override
	public boolean NewAccount_Creation() throws IOException {
		try {
			Random random = new Random();
			System.out.println("\n1.Admin Creation\n2.Student_Login\n3.Teacher_Login");
			int choice = Integer.parseInt(readerobj.readLine());
			int id = random.nextInt(50);
			BgDatabase.listid.add(id);
			System.out.println("Enter your Name");
			String name = readerobj.readLine();
			BgDatabase.idwithName.put(id, name);
			// System.out.println("Enter your Password");
			String password = getandCheckPassword();
			System.out.println("Enter your Department");
			String department = readerobj.readLine();
			System.out.println("Enter the valid Email");
			String email = getandCheckEmail();
			System.out.println("Enter Your City");
			String address = readerobj.readLine();
			switch (choice) {
			case 1:
				Admin_Page adminObj = new Admin_Page(id, name, password, address);
				BgDatabase.adminstorage.put(id, adminObj);
				break;
			case 2:
				Student_Page studObj = new Student_Page();
				studObj.setId(id).setName(name).setPassword(password).setDepartment(department).setEmail(email)
						.setAddress(address);
				BgDatabase.studentstorage.put(id, studObj);
				break;
			case 3:
				Teacher_Details teacherobj = new Teacher_Details(id, name, password, department, address);
				BgDatabase.teacherstorage.put(id, teacherobj);
				break;
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void Login() throws IOException {
		try {
			Thread.sleep(1000);
			System.out.println("Enter your ID");
			int id = Integer.parseInt(readerobj.readLine());
			System.out.println("Enter your Password");
			String password = readerobj.readLine();
			System.out.println("1.Admin_Login\n2.Student_Login\n3.Teacher Login");

			int choice = Integer.parseInt(readerobj.readLine());
			switch (choice) {
			case 1:
				adminLogin(id, password);
				break;
			case 2:
				studentLogin(id, password);
				break;
			case 3:
				TeacherLogin(id, password);
				break;
			}
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void updateStudentDetails() throws IOException {
		int[] marks;
		int fees;
		String grade;
		Student_Page tempobj1;
		System.out.println("Enter the Student Id");
		int studentid = Integer.parseInt(readerobj.readLine());
		tempobj1 = BgDatabase.studentstorage.get(studentid);
		if (tempobj1 != null) {
			System.out.println("1.Enter Student Marks\n2.Enter the Fees\n3.Enter the Grade\n4.All the above\n5.Exit");
			int choice = Integer.parseInt(readerobj.readLine());
			switch (choice) {
			case 1:
				marks = enterMark();
				tempobj1.setMarks(marks);
				break;
			case 2:
				System.out.println("Enter the fees for student");
				fees = Integer.parseInt(readerobj.readLine());
				tempobj1.setFees(fees);
				break;
			case 3:
				System.out.println("Enter the Grade");
				grade = readerobj.readLine();
				tempobj1.setGrade(grade);
				break;
			case 4:
				// System.out.print("Enter the Students Marks");
				marks = enterMark();
				System.out.println("Enter the fees for studt");
				fees = Integer.parseInt(readerobj.readLine());
				System.out.println("Enter the Grade");
				grade = readerobj.readLine();
				tempobj1.setMarks(marks).setGrade(grade).setFees(fees);
				break;
			}
		} else
			System.out.println("Given Student IT doesn't Exist");
	}

	public void updateTeacherDetails() throws IOException {
		int salary;
		String position;
		Teacher_Details tempobj1;
		System.out.println("Enter the Teacher Id");
		int teacherid = Integer.parseInt(readerobj.readLine());
		tempobj1 = BgDatabase.teacherstorage.get(teacherid);
		System.out.println("1.Enter Teacher salary\n2.Enter the Postition\n3.All the above\n");
		int choice = Integer.parseInt(readerobj.readLine());

		switch (choice) {
		case 1:
			System.out.println("Enter the salary");
			salary = Integer.parseInt(readerobj.readLine());
			tempobj1.setSalary(salary);
			break;
		case 2:
			System.out.println("Enter the postition");
			position = readerobj.readLine();
			tempobj1.setPosition(position);
			break;
		case 3:
			System.out.print("Enter the Salary");
			salary = Integer.parseInt(readerobj.readLine());
			System.out.println("Enter the Position");
			position = readerobj.readLine();
			tempobj1.setSalary(salary).setPosition(position);
			break;
		case 4:
			System.out.println("Not a valid choice");
		}
	}

	public void adminLogin(int id, String password) throws IOException {

		if (BgDatabase.listid.contains(id) && BgDatabase.adminstorage.get(id).passwordMatch(password)) {
			System.out.println("1.Update Student Details\n2.Update Teacher Details");
			int choice = Integer.parseInt(readerobj.readLine());
			switch (choice) {
			case 1:
				updateStudentDetails();
				break;
			case 2:
				updateTeacherDetails();
				break;
			}
		} else {
			System.out.println("Given Id Doesn't Exist");
		}
	}

	public void studentLogin(int id, String password) {
		if (BgDatabase.listid.contains(id) && BgDatabase.studentstorage.get(id).passwordMatch(password)) {
			Student_Page tempobj = BgDatabase.studentstorage.get(id);
			System.out.println("\nId-" + tempobj.getId() + "\nName-" + tempobj.getName() + "\nAddress-"
					+ tempobj.getAddress() + "\nGrade-" + tempobj.getGrade() + "\nfees-" + tempobj.getFees());
		} else {
			System.out.println("Given Id does not exist");
		}
	}

	public void TeacherLogin(int id, String password) {
		if (BgDatabase.listid.contains(id) && BgDatabase.teacherstorage.get(id).passwordMatch(password)) {
			Teacher_Details tempobj = BgDatabase.teacherstorage.get(id);
			System.out.println("\nId-" + tempobj.getId() + "\nName-" + tempobj.getName() + "\nAddress-"
					+ tempobj.getSalary() + "\nGrade-" + tempobj.getPosition());
		} else {
			System.out.println("Given Id does not exist");
		}
	}

	public static void main(String[] args) throws IOException {
		boolean continuation = true;
		while (continuation) {
			Homepage obj1 = new Homepage();
			System.out.println("1.Create an Account\n2.Login\n3.Show Id\n4.Exist");
			int choice = Integer.parseInt(readerobj.readLine());
			switch (choice) {
			case 1:
				if (obj1.NewAccount_Creation())
					System.out.println("Account Created Successfully");
				else
					System.out.println("Account was not created");
				break;
			case 2:
				obj1.Login();
				break;
			case 3:
				for (Map.Entry<Integer, String> mapiter : BgDatabase.idwithName.entrySet()) {
					System.out.println("Id-" + mapiter.getKey() + "\nName-" + mapiter.getValue());
				}
				break;
			case 4:
				continuation = false;
				System.out.println("Program Termination");
				break;
			}
		}
	}
}
