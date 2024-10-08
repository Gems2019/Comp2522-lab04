package ca.bcit.comp2522.lab4;

/**
 * This class models date formats.
 * Firstly, checks the validation of year, month, day if they are correct in the range, including checks leap year.
 * Secondly, finds a day of week with calculation using year,month,day ( Calculation formula is explained in the method
 * getDayOfTheWeek() between the every step)
 * Lastly, printing the date in two different formats ("YYYY-MM-DD" and "Month(in String) DD, YYYY").
 *
 * @author Yuho Lim
 * @author Daniil Yarygin
 * @author Kyle Lau
 * @author Gem Baojimin Sha
 * @version 1.0
 */

public class Date implements Comparable<Date>
{

    // Creating static variables to set a range of year.
    private static final int STARTING_YEAR = 1;
    private static final int CURRENT_YEAR = 2024;

    // Creating static variables to calculate leap year
    private static final int NO_REMAINDER = 0;
    private static final int LEAP_YEAR_DIVISIBLE_BY_FOURHUNDRED = 400;
    private static final int LEAP_YEAR_DIVISIBLE_BY_FOUR = 4;
    private static final int LEAP_YEAR_DIVISIBLE_BY_HUNDRED = 100;

    // Creating static variables to set a range days of month.
    private static final int FIRST_MONTH = 1;
    private static final int SHORT_FEB_MONTH = 28;
    private static final int LONG_FEB_MONTH = 29;
    private static final int SHORT_MONTH = 30;
    private static final int LONG_MONTH = 31;

    // Creating static variables to set months.
    private static final int JAN = 1;
    private static final int FEB = 2;
    private static final int MAR = 3;
    private static final int APR = 4;
    private static final int MAY = 5;
    private static final int JUN = 6;
    private static final int JULY = 7;
    private static final int AUG = 8;
    private static final int SEP = 9;
    private static final int OCT = 10;
    private static final int NOV = 11;
    private static final int DEC = 12;

    // Creating variables to get day, month, and year.
    private final int day;
    private final int month;
    private final int year;

    /**
     * Creating a constructor.
     *
     * @param year  will be assigned to the instance data: year
     * @param month will be assigned to the instance data: month
     * @param day   will be assigned to the instance data: day
     */
    public Date(final int year, final int month, final int day)
    {
        validateYear(year);
        validateMonth(month);
        validateDate(year, month, day);

        this.year = year;
        this.month = month;
        this.day = day;
    }

    /**
     * Creating getter to get year.
     *
     * @return year
     */
    public int getYear()
    {
        return year;
    }

    /**
     * Creating getter to get month.
     *
     * @return month
     */
    public int getMonth()
    {
        return month;

    }

    /**
     * Creating getter to get day.
     *
     * @return day
     */
    public int getDay()
    {
        return day;

    }

    /*
     * Creating a method if the year is valid.
     * @param year check if the year is valid
     * @throws IllegalArgumentException if the month is out of range and empty
     */
    private static void validateYear(final int year) throws IllegalArgumentException
    {
        if(STARTING_YEAR > year || CURRENT_YEAR < year)
        {
            throw new IllegalArgumentException("You must enter the correct year");
        }
    }

    /*
     * Creating a method if the year is leap year.
     * @param year check if the year is leap year
     * @return false if the year is not leap year
     */
    private static boolean isLeapYear(final int year)
    {

        return (year % LEAP_YEAR_DIVISIBLE_BY_FOURHUNDRED == NO_REMAINDER ||
                (year % LEAP_YEAR_DIVISIBLE_BY_FOUR == NO_REMAINDER && year % LEAP_YEAR_DIVISIBLE_BY_HUNDRED != NO_REMAINDER));
    }

    /*
     * Creating a method if the month is valid.
     * @param month check if the month is valid
     * @throws IllegalArgumentException if the month is null or blank
     */
    private static void validateMonth(final int month) throws IllegalArgumentException
    {

        if(JAN > month || DEC < month)
        {
            throw new IllegalArgumentException("You must enter the month between " + JAN + "  to 12");
        }
    }

    /*
     * Creating a method if the day is valid.
     * @param day check if the day is valid
     * @throws IllegalArgumentException if the day is out of range
     */
    private static void validateDate(final int year,
                                     final int month,
                                     final int day)
            throws IllegalArgumentException
    {

        final int maxDaysOfMonth;

        maxDaysOfMonth = numbOfDaysInMonth(month, year);

        if(FIRST_MONTH > day || maxDaysOfMonth < day)
        {
            throw new IllegalArgumentException("You must enter the correct day");
        }
    }

    /*
     * Creating method to classify the number of days in a given month of a given year.
     * @param month take month and classify the number of days in a given month
     * @param year take different number of days in February and check if it's leap year
     * @return the number of days
     */
    private static int numbOfDaysInMonth(final int month,
                                         final int year)
            throws IllegalArgumentException
    {

        switch(month)
        {
            case JAN:
            case MAR:
            case MAY:
            case JULY:
            case AUG:
            case OCT:
            case DEC:
                return LONG_MONTH;
            case APR:
            case JUN:
            case SEP:
            case NOV:
                return SHORT_MONTH;
            case FEB:
                return isLeapYear(year) ? LONG_FEB_MONTH : SHORT_FEB_MONTH;
            default:
                throw new IllegalArgumentException(String.format("Invalid days of %d", month));
        }
    }

    /**
     * Returns a string representation of the date in the format "YYYY-MM-DD".
     * <p>
     * The year, month, and day are formatted to always display four digits for the year,
     * and two digits for both the month and day.
     *
     * @return a string in the format "YYYY-MM-DD", representing the date.
     */
    @Override
    public String toString()
    {
        return String.format("%04d-%02d-%02d", year, month, day);
    }

    /**
     * Compares this Date object with the specified Date object for order.
     * Returns a negative integer, zero, or a positive integer as this Date
     * is less than, equal to, or greater than the specified Date.
     *
     * @param other the Date object to be compared
     * @return a negative integer if this Date is earlier than the specified Date,
     * zero if both dates are the same, or a positive integer if this Date
     * is later than the specified Date
     */
    @Override
    public int compareTo(final Date other)
    {

        if(this.year != other.year)
        {

            return Integer.compare(this.year, other.year);

        }

        if(this.month != other.month)
        {

            return Integer.compare(this.month, other.month);

        }

        return Integer.compare(this.day, other.day);
    }
}