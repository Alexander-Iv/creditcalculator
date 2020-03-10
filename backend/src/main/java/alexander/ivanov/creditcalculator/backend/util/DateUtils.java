package alexander.ivanov.creditcalculator.backend.util;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateUtils {
    private static final DateTimeFormatter PERIOD_FORMATTER = DateTimeFormatter.ofPattern("MM/yyyy");

    public static LocalDateTime toLocalDateTime(Date date) {
        Instant startDateInstant = date.toInstant();
        LocalDateTime localStartDate = LocalDateTime.ofInstant(startDateInstant, ZoneId.systemDefault());
        return localStartDate;
    }

    public static String toPeriod(LocalDateTime localDateTime, long months) {
        return localDateTime.plusMonths(months).format(PERIOD_FORMATTER);
    }
}
