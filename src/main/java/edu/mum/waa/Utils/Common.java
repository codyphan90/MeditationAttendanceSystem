package edu.mum.waa.Utils;

import java.time.DayOfWeek;
import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class Common {
    public static Integer  calcWeekDays(final LocalDate start, final LocalDate end) {
        final DayOfWeek startW = start.getDayOfWeek();
        final DayOfWeek endW = end.getDayOfWeek();
        final long days = DAYS.between(start, end) + 1;
        final long daysWithoutSunday = days - ((days + startW.getValue())/7);

        //adjust for starting and ending on a Sunday:
        return (int) daysWithoutSunday + (startW == DayOfWeek.SUNDAY ? 1 : 0) + (endW == DayOfWeek.SUNDAY ? 1 : 0);
    }
}
