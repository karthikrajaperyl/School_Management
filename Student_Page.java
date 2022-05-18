
class Student_Page {
	private int id;
	private String name;
	private String password;
	private String department;
	private String email;
	private int[] marks;
	private int fees;
	private String grade;
	private String address;

	protected Student_Page setId(int id) {
		this.id = id;
		return this;
	}

	protected int getId() {
		return id;
	}

	protected Student_Page setName(String name) {
		this.name = name;
		return this;
	}

	protected String getName() {
		return name;
	}

	protected Student_Page setPassword(String password) {
		this.password = password;
		return this;
	}

	private String getPassword() {
		return password;
	}

	protected Student_Page setAddress(String city) {
		this.address = city;
		return this;
	}

	protected String getAddress() {
		return address;
	}

	protected Student_Page setMarks(int[] marks) {
		this.marks = marks;
		return this;
	}

	protected int[] getMark() {
		return marks;
	}

	protected Student_Page setGrade(String grade) {
		this.grade = grade;
		return this;
	}

	protected String getGrade() {
		return grade;
	}

	protected Student_Page setFees(int fees) {
		this.fees = fees;
		return this;
	}

	protected int getFees() {
		return fees;
	}

	protected Student_Page setEmail(String email) {
		this.email = email;
		return this;
	}

	protected String getEmail() {
		return email;
	}

	protected Student_Page setDepartment(String department) {
		this.department = department;
		return this;
	}

	protected String getDepartment() {
		return department;
	}

	protected boolean passwordMatch(String password) {
		boolean isTrue = false;
		if (password.equals(this.password))
			isTrue = true;
		return isTrue;
	}
}
