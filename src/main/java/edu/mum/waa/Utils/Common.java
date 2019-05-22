package edu.mum.waa.Utils;

import edu.mum.waa.entity.BlockEntity;
import edu.mum.waa.response.StudentReport;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    public static void exportCSV(HttpServletResponse response, List<StudentReport> studentReports, String csvFileName)  throws IOException {
        response.setContentType("text/csv");
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"", csvFileName);
        response.setHeader(headerKey, headerValue);

        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
        String[] header = { "StudentId", "AttendedCount", "TotalSession", "Percentage", "BonusPoint" };
        csvWriter.writeHeader(header);

        for (StudentReport studentReport : studentReports) {
            csvWriter.write(studentReport, header);
        }

        csvWriter.close();
    }

    public static List<LocalDate> getAllDateOfBlock(BlockEntity blockEntity) {
        LocalDate start =blockEntity.getStartDate();
        LocalDate end = blockEntity.getEndDate();
        List<LocalDate> totalDates = new ArrayList<>();
        while (!start.isAfter(end)) {
            if (start.getDayOfWeek() != DayOfWeek.SUNDAY) {
                totalDates.add(start);
            }
                start = start.plusDays(1);
        }
        return totalDates;
    }
}
