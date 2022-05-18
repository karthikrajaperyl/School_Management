
public class OverLoadingDemo {

	int a, b, c;

	OverLoadingDemo() {

	}

	OverLoadingDemo(int a, int b) {
		this.a = a;
		this.b = b;
	}

	OverLoadingDemo(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	static int sum(int a, int b) {
		return a + b;
	}

	static int sum(int a, int b, int c) {
		return a + b + c;
	}

	public static void main(String[] args) {
		System.out.println(sum(1, 2));
		System.out.println(sum(1, 2, 3));
	}
}
