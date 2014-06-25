package main.java.date;

import java.io.PrintWriter;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.FormatStyle;
import java.time.format.SignStyle;
import java.time.temporal.ChronoField;

/**
 * Created with IntelliJ IDEA.
 * User: foxc
 * Date: 23/06/14
 * Time: 3:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class LengthsOfTime {
  private static PrintWriter pw = new PrintWriter(System.out, true);

  private static void demoDateEnums(){
    DayOfWeek day = LocalDate.now().getDayOfWeek();
    pw.println("Day of the week is " + day.name());
    Month firstQuarterMonth = LocalDate.now().getMonth().firstMonthOfQuarter();
    pw.println("First month of this quarter is " + firstQuarterMonth.name());
    DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
    System.out.println("Short style of today is " + formatter.format(LocalDateTime.now()));
    DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder();
    builder.appendValue(ChronoField.HOUR_OF_DAY,2,4, SignStyle.ALWAYS);
    builder.appendLiteral(':');
    builder.appendValue(ChronoField.MINUTE_OF_HOUR, 2, 4, SignStyle.NEVER);
    DateTimeFormatter timeFormatter = builder.toFormatter();
    System.out.println("Time with signed hour " + timeFormatter.format(LocalTime.now()));

  }

  public static void main(String[] args){
    Instant instant = Instant.now();
    pw.println("Timestamp for now is " + instant.toString());

    pw.println("How long between now and the start of next hour?");
    LocalTime now = LocalTime.now();
    LocalTime topOfHour = now.plusHours(1).withMinute(0);
    Duration toTopOfHour = Duration.between(now, topOfHour);
    pw.println(toTopOfHour.toMinutes() + " minutes from now till the top of the hour!");

    pw.println("How long between now and the next Rugby World Cup?");
    LocalDate today = LocalDate.now();
    LocalDate rwcStart = LocalDate.of(2015, Month.SEPTEMBER, 18);

    Period stretch = Period.between(today, rwcStart);
    pw.println("There's " + stretch.getYears() + " years, " + stretch.getMonths()
            + " months, and " + stretch.getDays() + " days to go!");
    demoDateEnums();
  }
}
