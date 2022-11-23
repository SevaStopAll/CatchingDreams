interface Executable {
	void execute();
}

class Runner {
	public void run(Executable e) {
		
	}
}

class ExecutableImplementation implements Executable {
	@Override
	public void execute() {
		System.out.println("Hello!");
	}
}

public class TestLambda {
	public static void main(String [] args) {
		Runner runner = new Runner();
		ExecutableImplementation e = new ExecutableImplementation();
		runner.run(e);
		
		runner.run(new Executable() {
			@Override
			public void execute() {
				System.out.println("Hello");
			}
			
		});
		
		runner.run(() -> System.out.println("Hello"));
	}
	
	
}
