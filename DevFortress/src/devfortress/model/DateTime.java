/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.model;

/**
 *
 * @author Sherlock
 */
class DateTime {
    private int weekOfMonth;
    private int monthOfYear;
    private int year;
    private String[] month ={"January","February","March","April","May","June","July","August","September","October","November","December"};

    public DateTime() {
        weekOfMonth = 1;
        monthOfYear = 1;
        year = 1;
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
    
    public String toString(){
        return "Week ("+weekOfMonth+" of 4) "+ month[monthOfYear-1];
    }
}
