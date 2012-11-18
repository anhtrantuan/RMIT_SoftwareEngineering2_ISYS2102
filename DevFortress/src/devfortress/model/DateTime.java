/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.model;

/**
 *
 * @author Sherlock
 */
public class DateTime {

    private int weekOfMonth;
    private int monthOfYear;
    private int year;
    private String[] month = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

    public DateTime() {
        weekOfMonth = 1;
        monthOfYear = 1;
        year = 1;
    }

    public DateTime(int weekOfMonth, int monthOfYear, int year) {
        this.weekOfMonth = weekOfMonth;
        this.monthOfYear = monthOfYear;
        this.year = year;
    }

    public int getMonthOfYear() {
        return monthOfYear;
    }

    public void setMonthOfYear(int monthOfYear) {
        this.monthOfYear = monthOfYear;
    }

    public int getWeekOfMonth() {
        return weekOfMonth;
    }

    public void setWeekOfMonth(int weekOfMonth) {
        this.weekOfMonth = weekOfMonth;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonths() {
        return monthOfYear + year * 12;
    }

    public void nextWeek() {
        if (weekOfMonth == 4) {
            weekOfMonth = 1;
            nextMonth();
        } else {
            weekOfMonth++;
        }
    }

    public void nextMonth() {
        if (monthOfYear == 12) {
            monthOfYear = 1;
            year++;
        } else {
            monthOfYear++;
        }
    }

    public void nextTurn() {
        if (year == 0 || monthOfYear > 1) {
            monthOfYear--;
        } else {
            monthOfYear = 12;
            year--;
        }
    }

    @Override
    public String toString() {
        return "Week (" + weekOfMonth + " of 4) " + month[monthOfYear - 1];
    }
}
