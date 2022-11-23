
public class TestLambda {
	public static void main(String [] args) {
		Thread thread = new Thread(() -> System.out.println("Hello"));
	}
}
