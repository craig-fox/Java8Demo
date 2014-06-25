package main.java.date;

import java.io.PrintWriter;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAdjusters;

import main.java.helpers.DaylightSavingQuery;

/**
 * Created with IntelliJ IDEA.
 * User: foxc
 * Date: 23/06/14
 * Time: 4:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class DatesTemporal {
  private static PrintWriter pw = new PrintWriter(System.out, true);

  public DatesTemporal(){
    LocalDate today = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
    LocalDate secondFriJuly = today.plusMonths(1).with(TemporalAdjusters.dayOfWeekInMonth(2,
            DayOfWeek.FRIDAY));
    LocalDate lastTuesday = today.with(TemporalAdjusters.previous(DayOfWeek.TUESDAY));
    pw.println("Second Friday of July: " + formatter.format(secondFriJuly));
    pw.println("Last Tuesday: " + formatter.format(lastTuesday));

    LocalDate validDate = LocalDate.of(2014, Month.OCTOBER, 02);
    LocalDate invalidDate = LocalDate.of(2015, Month.APRIL, 15);
    boolean isDaylightSavings = validDate.query(new DaylightSavingQuery());
    pw.println(formatter.format(validDate) + " is " + (isDaylightSavings?"":"not ") + "Daylight Savings");
    isDaylightSavings =  invalidDate.query(new DaylightSavingQuery());
    pw.println(formatter.format(invalidDate) + " is " + (isDaylightSavings?"":"not ") + "Daylight Savings");
  }

  public static void main(String[] args){
    new DatesTemporal();
  }
}
