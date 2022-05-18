
public class Teacher_Details {

	private int id;
	private String name;
	private String password;
	private int salary;
	private int salaryEarned;
	private String department;
	private String position;
	private String address;

	public Teacher_Details(int id, String name, String password, String department, String address) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.salaryEarned = 0;
		this.department = department;
		this.address = address;
	}

	protected int getId() {
		return id;
	}

	protected String getName() {
		return name;
	}

	protected Teacher_Details setSalary(int salary) {
		this.salary = salary;
		return this;
	}

	protected int getSalary() {
		return salary;
	}

	protected String getDepartment() {
		return department;
	}

	protected Teacher_Details setPosition(String position) {
		this.position = position;
		return this;
	}

	protected String getPosition() {
		return position;
	}

	protected String getAddress() {
		return address;
	}

	protected boolean passwordMatch(String password) {
		boolean isMatch = false;
		if (password.equals(this.password))
			isMatch = true;
		return isMatch;
	}

}
