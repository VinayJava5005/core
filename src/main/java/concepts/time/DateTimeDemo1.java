package concepts.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;

public class DateTimeDemo1 {

	public static void main(String[] args) {

		System.out.println("Current Date time : " + LocalDateTime.now());
		System.out.println("Specific Date time : "
				+ LocalDateTime.of(LocalDate.now(), LocalTime.now()));
		System.out.println("Specific Time zone : "
				+ LocalDateTime.now(ZoneId.of("America/Chicago")));
	}

}
