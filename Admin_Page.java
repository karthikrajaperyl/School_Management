
public class Admin_Page extends Student_Page {
	protected int id;
	protected String name;
	private String password;
	protected String department;
	protected int[] marks;
	protected String grade;
	private int fees;

	Admin_Page(int id, String name, String password, String address) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
	}

	protected int getId() {
		return id;
	}

	protected String getName() {
		return name;
	}

	private String getPassword() {
		return password;
	}

	protected Admin_Page setDepartment(String department) {
		this.department = department;
		return this;
	}

	protected String getDepartment() {
		return department;
	}

	protected boolean passwordMatch(String password) {
		boolean isMatch = false;
		if (password.equals(this.password))
			isMatch = true;
		return isMatch;
	}
}
