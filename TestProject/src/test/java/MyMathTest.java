import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class MyMathTest {

	@Test
	public void zeroDenominatorShouldThrowException() {
		ArithmeticException thrown = Assertions.assertThrows(ArithmeticException.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				MyMath.divide(1, 0);
			}
		}, "Can't divide by zero");
	}
	
	@Test
	public void zeroDenominatorShouldThrowException1() {
		ArithmeticException thrown = Assertions.assertThrows(ArithmeticException.class, () -> { MyMath.divide(1, 0);}, "Can't divide by zero");
	}
	
	// Change to newType Lambda 
	@Test
	public void zeroDenominatorShouldThrowException11() {
		ArithmeticException thrown = Assertions.assertThrows(ArithmeticException.class, () -> { MyMath.divide(1, 0);}, "Can't divide by zero");
	}
}
