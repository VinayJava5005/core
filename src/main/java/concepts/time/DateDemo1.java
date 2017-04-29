package concepts.time;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;

public class DateDemo1 {

	public static void main(String[] args) {

		System.out.println("Current System Date (Default(yyyy-mm-dd)): "
				+ LocalDate.now());

		System.out.println("Specific Date : "
				+ LocalDate.of(1990, Month.OCTOBER, 19));

		System.out.println("Specific Time Zone Date : "
				+ LocalDate.now(ZoneId.of("America/Chicago")));

		System.out.println("Is Leap year : " + LocalDate.now().isLeapYear());
		System.out.println("Add one day : " + LocalDate.now().plusDays(1));

	}
}
