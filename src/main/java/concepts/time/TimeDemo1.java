package concepts.time;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.ChronoField;

public class TimeDemo1 {

	public static void main(String[] args) {

		System.out.println("Current time : " + LocalTime.now());
		System.out.println("Specified time : " + LocalTime.of(23, 4));
		System.out.println("Specified Time Zone : "
				+ LocalTime.now(ZoneId.of("America/Chicago")));
		System.out.println(LocalDateTime.now().get(ChronoField.NANO_OF_SECOND));
	}
}
