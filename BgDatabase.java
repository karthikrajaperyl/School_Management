import java.util.*;

public class BgDatabase {
	protected static Map<Integer, Admin_Page> adminstorage = new HashMap<>();
	protected static Map<Integer, Student_Page> studentstorage = new HashMap<>();
	protected static Set<Integer> listid = new HashSet<>();
	protected static Map<Integer, String> idwithName = new HashMap<>();
	protected static Map<Integer, Teacher_Details> teacherstorage = new HashMap<>();
}
