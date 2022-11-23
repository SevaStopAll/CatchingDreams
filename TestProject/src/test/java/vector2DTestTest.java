
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class vector2DTestTest {
	private final double EPS = 1e-9;
	
	@Test
	public void newVectorShouldHaveZeroLength() {
		Vector2D v1 = new Vector2D();
		Assertions.assertEquals(0, v1.length(), EPS);
	}
	
	@Test 
	public void newVectorShouldHaveZeroX() {
		Vector2D v1 = new Vector2D();
		Assertions.assertEquals(0, v1.getX(), EPS);
	}
	@Test 
	public void newVectorShouldHaveZeroY() {
		Vector2D v1 = new Vector2D();
		Assertions.assertEquals(0, v1.getY(), EPS);
		
	}

}
