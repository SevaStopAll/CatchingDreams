package Game;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

public class ReflectionTest {
	public static void main(String [] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
	Scanner sc = new Scanner(System.in);
	// Название_класса_1 Название_класса_2 Название_метода
	Class classObject1 = Class.forName(sc.next());
	Class classObject2 = Class.forName(sc.next());
	String methodName = sc.next();
	
	
	Method m = classObject1.getMethod(methodName, classObject2);
	
	Object o1 = classObject1.getConstructor().newInstance();
	Object o2 = classObject2.getConstructor(String.class).newInstance("String value");
	
	m.invoke(o1, o2);
	
	System.out.println(o1); 
	
	
	/*Get all class methods with its returnType and Parameters
	 * Method[] methods = human.getMethods();
		for (Method method : methods) {
			System.out.println(method.getName()) + " " + method.getReturnType() + " " + System.out.println(Arrays.toString(method.getParameterTypes()));
		}*/
	
	/* Get all Class public fields (not private, not protected)
	 * Field [] fields = human.getFields(); for (Field field : fields) {
	 * System.out.println(field.getName()); System.out.println(field.getType()); }
	 */
	
	/*
	 * Get all Class fields (public, private, protected) Field [] fields =
	 * human.getDeclaredFields(); for (Field field : fields) {
	 * System.out.println(field.getName()); System.out.println(field.getType()); }
	 */
	}
}
	

