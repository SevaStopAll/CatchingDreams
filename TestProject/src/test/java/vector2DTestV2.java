import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class vector2DTestV2 {
	private final double EPS = 1e-9;
	private static Vector2D v1;
	
	@BeforeAll 
	public static void createNewVector() {
		v1 = new Vector2D();
	}
	
	@Test
	public void newVectorShouldHaveZeroLength() {
		Assertions.assertEquals(0, v1.length(), EPS);
	}
	
	@Test 
	public void newVectorShouldHaveZeroX() {
		Assertions.assertEquals(0, v1.getX(), EPS);
	}
	
	@Test 
	public void newVectorShouldHaveZeroY() {
		Assertions.assertEquals(0, v1.getY(), EPS);
		
	}

}
