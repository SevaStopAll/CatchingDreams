package TestPackage;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TestDate {

	public static void main(String[] args) {
		System.out.println(java.time.LocalDateTime.now());
		System.out.println(java.time.ZonedDateTime.now());
		String time = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(Calendar.getInstance().getTime());
		System.out.println(time);

	}

}
