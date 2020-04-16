/////////////////////////////////////////// FILE  HEADER /////////////////////////////////////////////
//
// Title: Calendar Printer
// Files: CalendarPrinter.java, CalendarTester.java
// This File: CalendarPrinter.java
// 
// Name: Benjamin Tarmann
// Email: btarmann@wisc.edu
//
///////////////////////////////////////// 100 COLUMNS WIDE /////////////////////////////////////////

import java.util.Scanner;

/**
 * Generates a calendar for a month based on the month and year input by the user
 * 
 * @author Benjamin Tarmann
 */
public class CalendarPrinter {

  private final static String[] DAYS_OF_WEEK = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
  private final static String[] MONTHS_OF_YEAR =
      {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};

  /**
   * Calculates the number of centuries (rounded down) that is represented by the specified year
   * (ie. the integer part of year/100).
   * 
   * @param year to compute the century of (based on the Gregorian Calendar AD) String must contain
   *             the digits of a single non-negative int for year.
   * @return number of centuries in the specified year
   */
  public static int getCentury(String year) {
    int numYear = Integer.parseInt(year);
    int century = numYear / 100;
    return century;
  }

  /**
   * Calculates the number of years between the specified year, and the first year in the specified
   * year's century. This number is always between 0 - 99.
   * 
   * @param year to compute the year within century of (Gregorian Calendar AD) String must contain
   *             the digits of a single non-negative int for year.
   * @return number of years since first year in the current century
   */
  public static int getYearWithinCentury(String year) {
    int numYear = Integer.parseInt(year);
    int yearWithinCentury = numYear % 100;
    return yearWithinCentury;
  }

  /**
   * This method computes whether the specified year is a leap year or not.
   * 
   * @param yearString is the year that is being checked for leap-year-ness String must contain the
   *                   digits of a single non-negative int for year.
   * @return true when the specified year is a leap year, and false otherwise
   */
  public static boolean getIsLeapYear(String yearString) {
    int numYears = Integer.parseInt(yearString);
    if ((numYears % 4) != 0) {
      return false;
    } else if ((numYears % 100) != 0) {
      return true;
    } else if ((numYears % 400) != 0) {
      return false;
    } else {
      return true;
    }
  }

  /**
   * Converts the name or abbreviation for any month into the index of that month's abbreviation
   * within MONTHS_OF_YEAR. Matches the specified month based only on the first three characters,
   * and is case in-sensitive.
   * 
   * @param month which may or may not be abbreviated to 3 or more characters
   * @return the index within MONTHS_OF_YEAR that a match is found at and returns -1, when no match
   *         is found
   */
  public static int getMonthIndex(String month) {
    month = month.trim();
    month = month.substring(0, 3);
    month = month.toUpperCase();
    for (int i = 0; i < MONTHS_OF_YEAR.length; i++) {
      if (month.equals(MONTHS_OF_YEAR[i])) {
        return i;
      }
    }
    return -1;
  }

  /**
   * Calculates the number of days in the specified month, while taking into consideration whether
   * or not the specified year is a leap year.
   * 
   * @param month which may or may not be abbreviated to 3 or more characters
   * @param year of month that days are being counted for (Gregorian Calendar AD) String must contain
   *             the digits of a single non-negative int for year.
   * @return the number of days in the specified month (between 28-31)
   */
  public static int getNumberOfDaysInMonth(String month, String year) {
    int numMonth = getMonthIndex(month);

    if (getIsLeapYear(year) == true && numMonth == 1) {
      return 29;
    } else {
      switch (numMonth) {
        case 0:
          return 31;
        case 1:
          return 28;
        case 2:
          return 31;
        case 3:
          return 30;
        case 4:
          return 31;
        case 5:
          return 30;
        case 6:
          return 31;
        case 7:
          return 31;
        case 8:
          return 30;
        case 9:
          return 31;
        case 10:
          return 30;
        case 11:
          return 31;
        default:
          return -1;
      }
    }
  }

  /**
   * Calculates the index of the first day of the week in a specified month. The index returned
   * corresponds to position of this first day of the week within the DAYS_OF_WEEK class field.
   * 
   * @param month which may or may not be abbreviated to 3 or more characters
   * @param year of month to determine the first day from (Gregorian Calendar AD) String must contain
   *             the digits of a single non-negative int for year.
   * @return index within DAYS_OF_WEEK of specified month's first day
   */
  public static int getFirstDayOfWeekInMonth(String month, String year) {
    int h;
    int numMonth = getMonthIndex(month) + 1;
    int centuryYear = getYearWithinCentury(year);
    int zeroBasedCentury = getCentury(year);

    // changes months january and february to months 13 and 14 respectively for the purpose of the formula
    if (numMonth < 3) {
      numMonth = numMonth + 12;
      if (centuryYear == 0) {
        centuryYear = 99;
        zeroBasedCentury--;
      } else {
        centuryYear--;
      }
    }

    h = (1 + ((13 * (numMonth + 1)) / (5)) + centuryYear + (centuryYear / 4)
        + (zeroBasedCentury / 4) + (5 * zeroBasedCentury)) % 7;

    switch (h) {
      case 0:
        return 5;
      case 1:
        return 6;
      case 2:
        return 0;
      case 3:
        return 1;
      case 4:
        return 2;
      case 5:
        return 3;
      case 6:
        return 4;
      default:
        return -1;
    }
  }

  /**
   * Creates and initializes a 2D String array to reflect the specified month. The first row of this
   * array [0] should contain labels representing the days of the week, starting with Monday, as
   * abbreviated in DAYS_OF_WEEK. Every later row should contain dates under the corresponding days
   * of week. Entries with no corresponding date in the current month should be filled with a single
   * period. There should not be any extra rows that are either blank, unused, or completely filled
   * with periods.
   * 
   * @param month which may or may not be abbreviated to 3 or more characters
   * @param year of month generate calendar for (Gregorian Calendar AD) String must contain the
   *             digits of a single non-negative int for year.
   * @return2d array of strings depicting the contents of a calendar
   */
  public static String[][] generateCalendar(String month, String year) {
    String[][] calendar = new String[6][7];
    int firstDayOfWeekInMonth = getFirstDayOfWeekInMonth(month, year);
    int numDaysInMonth = getNumberOfDaysInMonth(month, year);
    int date = 1;

    for (int i = 0; i < calendar[0].length; i++) {
      calendar[0][i] = DAYS_OF_WEEK[i];
    }

    for (int i = 1; i < calendar.length; i++) {
      // if filling the first week of the month
      if (i == 1) {
        for (int k = 0; k < calendar[i].length; k++) {
          if (k < firstDayOfWeekInMonth) {
            calendar[i][k] = ".";
          } else {
            calendar[i][k] = Integer.toString(date);
            date++;
          }
        }
        // if not filling the first week of the month
      } else {
        for (int k = 0; k < calendar[i].length; k++) {
          if (date > numDaysInMonth) {
            calendar[i][k] = ".";
          } else {
            calendar[i][k] = Integer.toString(date);
            date++;
          }
        }
      }
      // exits the loop if the date exceeds the number of days in the month
      if (date > (numDaysInMonth))
        break;
    }
    return calendar;
  }

  /**
   * Main method of the CalendarPrinter class. Generates the calendar array by calling the
   * generateCalendar method and then displays the calendar with proper formatting and spacing
   * 
   * @param args
   */
  public static void main(String[] args) {
    // welcome message
    System.out.println("Welcome to the Calendar Printer.");
    System.out.println("================================");

    Scanner scnr = new Scanner(System.in);
    String month;
    String year;
    String[][] calendar;

    // month input prompt
    System.out.println("Enter the month to print: ");
    month = scnr.nextLine();

    // year input prompt
    System.out.println("Enter the year to print: ");
    year = scnr.nextLine();

    calendar = generateCalendar(month, year);

    // prints the contents of the calendar array in a calendar format with appropriate spacing
    for (int i = 0; i < calendar.length; i++) {
      // Prints out the days of the week
      if (i == 0) {
        for (int k = 0; k < calendar[i].length; k++) {
          System.out.print(calendar[i][k] + " ");
        }
        System.out.println("");
      }
      // prints the rest of the calendar
      else {
        for (int k = 0; k < calendar[i].length; k++) {
          if (calendar[i][k] != null && !calendar[i][k].equals(".")) {
            // different spacing depending on whether the date is single digits or double
            if (Integer.parseInt(calendar[i][k]) >= 10) {
              System.out.print(calendar[i][k] + "  ");
            } else {
              System.out.print(calendar[i][k] + "   ");
            }
            // prints the portions of the calendar where no date exists
          } else if (calendar[i][k] != null && calendar[i][k].equals(".")) {
            System.out.print(calendar[i][k] + "   ");
          }
        }
        System.out.println("");
      }
    }

    // closing message
    System.out.println("================================");
    System.out.println("Thanks, and have a nice day.");
  }
}
