
public class OverridingDemo {
	protected void Action(String name) {
		System.out.println(name + "Can walk");
	}

	void displayNumber(int a) throws Exception {

	}

	public static void main(String[] args) {
		OverridingDemo obj1 = new OverridingDemo();
		obj1.Action("Animal");
		OverridingDemo1 obj2 = new OverridingDemo1();
		obj2.method2();
	}
}

class OverridingDemo1 extends OverridingDemo {
	// Access Modifiers Don't be More restrictive
	@Override
	public void Action(String name) {
		System.out.println(name + "Can Fly");
	}

	// Exception should be in Hierarchical Order
	@Override
	void displayNumber(int a) throws NumberFormatException {

	}

	public void method2() {
		OverridingDemo1 obj2 = new OverridingDemo1();
		obj2.Action("Birds");
	}
}
