import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.junit.jupiter.api.Test;

class LogPassTest {
	public static Connection conn;
	public static Statement statmt;
	public static ResultSet resSet;
	public static Scanner sc = new Scanner(System.in);
	public static HashMap <String, String> usersList = new HashMap<>();
	public static Set <String> setUsers = new HashSet<>();
	public static String userLogin;
	
	/*
	 * @Test public void zeroDenominatorShouldThrowException() { ArithmeticException
	 * thrown = Assertions.assertThrows(ArithmeticException.class, new Executable()
	 * {
	 * 
	 * @Override public void execute() throws Throwable { MyMath.divide(1, 0); } },
	 * "Can't divide by zero"); }
	 * 
	 * @Test public void zeroDenominatorShouldThrowException1() {
	 * ArithmeticException thrown =
	 * Assertions.assertThrows(ArithmeticException.class, () -> { MyMath.divide(1,
	 * 0);}, "Can't divide by zero"); }
	 * 
	 * @BeforeAll public static void createNewVector() { v1 = new Vector2D(); }
	 * 
	 * @Test public void newVectorShouldHaveZeroLength() {
	 * Assertions.assertEquals(0, v1.length(), EPS); }
	 * 
	 * @Test public void newVectorShouldHaveZeroX() { Assertions.assertEquals(0,
	 * v1.getX(), EPS); }
	 * 
	 * @Test public void newVectorShouldHaveZeroY() { Assertions.assertEquals(0,
	 * v1.getY(), EPS);
	 * 
	 * }
	 * 
	 * @Test
	 * 
	 * @Timeout(value = 1, unit = TimeUnit.SECONDS) public void
	 * getConnectionShouldReturnFasterThanOneSecond() {
	 * NetworkUtils.getConnection(); return; }
	 */

}
