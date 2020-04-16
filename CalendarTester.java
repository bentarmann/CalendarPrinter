/////////////////////////////////////////// FILE  HEADER /////////////////////////////////////////////
//
// Title: Calendar Printer
// Files: CalendarPrinter.java, CalendarTester.java
// This File: CalendarTester.java
// 
// Name: Benjamin Tarmann
// Email: btarmann@wisc.edu
//
///////////////////////////////////////// 100 COLUMNS WIDE /////////////////////////////////////////

/**
 * This class contains methods to test the methods in the CalendarPrinter class
 * 
 * @author Benjamin Tarmann
 */
public class CalendarTester {
  /**
   * Tests whether the getCentury method in CalendarPrinter.java is operating properly
   * 
   * @return True if the method is operating properly, false if the method is not
   */
  public static boolean testGetCentury() {
    if (CalendarPrinter.getCentury("2") != 0)
      return false;
    if (CalendarPrinter.getCentury("2019") != 20)
      return false;
    if (CalendarPrinter.getCentury("44444") != 444)
      return false;
    return true;
  }

  /**
   * Tests whether the getYearWithinCentury method in CalendarPrinter.java is operating properly
   * 
   * @return True if the method is operating properly, false if the method is not
   */
  public static boolean testGetYearWithinCentury() {
    if (CalendarPrinter.getYearWithinCentury("2") != 2)
      return false;
    if (CalendarPrinter.getYearWithinCentury("2019") != 19)
      return false;
    if (CalendarPrinter.getYearWithinCentury("44444") != 44)
      return false;
    return true;
  }

  /**
   * Tests whether the getIsLeapYear method in CalendarPrinter.java is operating properly
   * 
   * @return True if the method is operating properly, false if the method is not
   */
  public static boolean testGetIsLeapYear() {
    if (CalendarPrinter.getIsLeapYear("2013") != false)
      return false;
    if (CalendarPrinter.getIsLeapYear("2016") != true)
      return false;
    if (CalendarPrinter.getIsLeapYear("1900") != false)
      return false;
    if (CalendarPrinter.getIsLeapYear("2000") != true)
      return false;
    return true;
  }

  /**
   * Tests whether the getMonthIndex method in CalendarPrinter.java is operating properly
   * 
   * @return True if the method is operating properly, false if the method is not
   */
  public static boolean testGetMonthIndex() {
    if (CalendarPrinter.getMonthIndex("january") != 0)
      return false;
    if (CalendarPrinter.getMonthIndex(" DeCeMbEr") != 11)
      return false;
    if (CalendarPrinter.getMonthIndex("juneeeeeee") != 5)
      return false;
    if (CalendarPrinter.getMonthIndex("carrot") != -1)
      return false;
    return true;
  }

  /**
   * Tests whether the getNumberOfDaysInMonth method in CalendarPrinter.java is operating properly
   * 
   * @return True if the method is operating properly, false if the method is not
   */
  public static boolean testGetNumberOfDaysInMonth() {
    if (CalendarPrinter.getNumberOfDaysInMonth("february", "2016") != 29)
      return false;
    if (CalendarPrinter.getNumberOfDaysInMonth("february", "2015") != 28)
      return false;
    if (CalendarPrinter.getNumberOfDaysInMonth("january", "2020") != 31)
      return false;
    if (CalendarPrinter.getNumberOfDaysInMonth("december", "2016") != 31)
      return false;
    if (CalendarPrinter.getNumberOfDaysInMonth("april", "2016") != 30)
      return false;
    return true;
  }

  /**
   * Tests whether the getFirstDayOfWeekInMonth method in CalendarPrinter.java is operating properly
   * 
   * @return True if the method is operating properly, false if the method is not
   */
  public static boolean testGetFirstDayOfWeekInMonth() {
    if (CalendarPrinter.getFirstDayOfWeekInMonth("march", "2019") != 4)
      return false;
    if (CalendarPrinter.getFirstDayOfWeekInMonth("january", "2019") != 1)
      return false;
    if (CalendarPrinter.getFirstDayOfWeekInMonth("january", "2000") != 5)
      return false;
    return true;
  }

  /**
   * Tests whether the getIsLeapYear method in CalendarPrinter.java is operating properly
   * 
   * @return True if the method is operating properly, false if the method is not
   */
  public static boolean testGenerateCalendar() {
    if (!(CalendarPrinter.generateCalendar("sept", "2019")[2][0]).equals("2"))
      return false;
    if (!(CalendarPrinter.generateCalendar("jan", "1999")[4][1]).equals("19"))
      return false;
    if (!(CalendarPrinter.generateCalendar("jan", "2020")[1][0]).equals("."))
      return false;
    return true;
  }

  /**
   * The main method. Calls all of the test methods and prints the return value of each to indicate
   * which methods are operating properly and which ones are not
   * 
   * @param args
   */
  public static void main(String[] args) {
    System.out.println("testGetCentury returns " + testGetCentury());
    System.out.println("testGetYearWithinCentury returns " + testGetYearWithinCentury());
    System.out.println("testGetIsLeapYear returns " + testGetIsLeapYear());
    System.out.println("testGetMonthIndex returns " + testGetMonthIndex());
    System.out.println("testGetNumberOfDaysInMonth returns " + testGetNumberOfDaysInMonth());
    System.out.println("testGetFirstDayOfWeekInMonth returns " + testGetFirstDayOfWeekInMonth());
    System.out.println("testGenerateCalendar returns " + testGenerateCalendar());
  }
}
