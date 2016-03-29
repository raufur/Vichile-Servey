package com.epsilon.coders.vichile_servey.services;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Thisaru Guruge
 * 06 / 03 / 2016
 * TimeManager to get time instances
 */
public class TimeManager {

    private int year, month, date, hour, minute, second;

    public TimeManager () {
        Calendar calendar = Calendar.getInstance();

        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH) + 1; // January = 0th month
        date = calendar.get(Calendar.DAY_OF_MONTH);
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        minute = calendar.get(Calendar.MINUTE);
        second = calendar.get(Calendar.SECOND);
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public String getDateString() {
        String dateSeparator = "-";

        StringBuilder sb = new StringBuilder();
        sb.append(date).append(dateSeparator);
        sb.append(month).append(dateSeparator);
        sb.append(year);

        return sb.toString();
    }

    public String getTimeString() {
        String timeSeparator = ":";

        StringBuilder sb = new StringBuilder();

        sb.append(hour).append(timeSeparator);
        sb.append(minute).append(timeSeparator);
        sb.append(second);

        return sb.toString();
    }

    @Override
    public String toString() {
        String dateSeparator = "-";
        String timeSeparator = ":";

        StringBuilder sb = new StringBuilder();
        sb.append(date).append(dateSeparator);
        sb.append(month).append(dateSeparator);
        sb.append(year).append(" ");
        sb.append(hour).append(timeSeparator);
        sb.append(minute).append(timeSeparator);
        sb.append(second);

        return sb.toString();
    }
}
