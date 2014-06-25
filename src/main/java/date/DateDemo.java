package main.java.date;

import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * Created with IntelliJ IDEA.
 * User: foxc
 * Date: 20/06/14
 * Time: 4:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class DateDemo {

  private static PrintWriter pw = new PrintWriter(System.out, true);

  public static void main(String[] args){
    LocalDate today = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
    pw.println("Today is " + formatter.format(today));

    LocalDate tomorrow = today.plusDays(1);
    pw.println("Tomorrow is " + formatter.format(tomorrow));
    LocalDate yesterday = today.minusDays(1);
    pw.println("Yesterday is " + formatter.format(yesterday));

    LocalDateTime thisMoment = LocalDateTime.now();
    DateTimeFormatter momentFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
    pw.println("Right now is " + momentFormatter.format(thisMoment));

    LocalDate independenceDay = LocalDate.of(1776, Month.JULY, 4);
    pw.println("Independence Day was on " + independenceDay.format(formatter));
    Period since = Period.between(independenceDay, today);

    LocalDate tomorrowInAugust = tomorrow.withMonth(8);
    pw.println("Tomorrow in August is " + formatter.format(tomorrowInAugust));

    LocalTime partyTime = LocalTime.of(18, 30);
    DateTimeFormatter timeFormatter = DateTimeFormatter.ISO_TIME;
    pw.println("Be there by " + timeFormatter.format(partyTime) + "!");

    LocalTime deadline = LocalTime.now().minusHours(1);
    DateTimeFormatter timeFormatter2 = DateTimeFormatter.ofPattern("HH:mm");
    pw.println("The deadline was at " + timeFormatter2.format(deadline));

    Month monthAWeekFromNow = Month.from(LocalDate.now().plusWeeks(1));
    DateTimeFormatter monthFormatter = DateTimeFormatter.ofPattern("MMMM");
    pw.println("Month a week from now is " + monthFormatter.format(monthAWeekFromNow));

    int thisSecond = LocalTime.now().getSecond();
    int thisMilli = LocalTime.now().getNano() / 1000000;
    pw.println("The second hand was on " + thisSecond);
    pw.println("The millisecond hand was on " + thisMilli);

    LocalDate xmasParty = LocalDate.of(2014, Month.DECEMBER, 12);
    boolean is2WeeksBeforeXmas = xmasParty.isBefore(xmasParty.withDayOfMonth(25).minusWeeks(2));
    pw.println("The party is" + (is2WeeksBeforeXmas ? " " : " not ") + "two weeks before Xmas");

    LocalDateTime tomorrowAfterMidnight = LocalDate.now().plusDays(1).atStartOfDay().plusSeconds(10);
    pw.println(momentFormatter.format(tomorrowAfterMidnight));

    DateTimeFormatter parser = DateTimeFormatter.ofPattern("HH:mm");
    String input = "17:30";
    LocalTime dinnerTime = parser.parse(input, LocalTime::from);
    pw.println("Dinner time at " + timeFormatter.format(dinnerTime));



  }
}
