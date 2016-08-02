package programs;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * Created by pradeep on 5/7/16.
 */
public class ZoneConverstion {

    public static void main(String[] args) {
        long miliSeconds = 1467717000000l;
        System.out.println(Instant.ofEpochMilli(miliSeconds).atOffset(ZoneOffset.UTC)
                .toLocalDateTime());

        System.out.println(LocalDateTime.now(ZoneOffset.UTC).withHour(0).withMinute(0).withSecond(0).withNano(0));
        System.out.println(LocalDateTime.now(ZoneOffset.UTC).withHour(23).withMinute(59).withSecond(59).withNano(0));
    }
}
