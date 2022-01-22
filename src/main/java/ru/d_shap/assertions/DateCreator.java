package ru.d_shap.assertions;

import java.util.Calendar;
import java.util.TimeZone;

public final class DateCreator {

    public static final String TIMEZONE_UTC = "UTC";

    public static final String TIMEZONE_GMT = "GMT";

    private DateCreator() {
        super();
    }

    public static Calendar createCalendar(final int year, final int month, final int dayOfMonth, final int hourOfDay, final int minute, final int second) {
        return createCalendar(year, month, dayOfMonth, hourOfDay, minute, second, 0);
    }

    public static Calendar createCalendar(final int year, final int month, final int dayOfMonth, final int hourOfDay, final int minute, final int second, final int millisecond) {
        Calendar calendar = Calendar.getInstance();
        fillCalendarValues(calendar, year, month, dayOfMonth, hourOfDay, minute, second, millisecond);
        return calendar;
    }

    public static Calendar createCalendar(final int year, final int month, final int dayOfMonth, final int hourOfDay, final int minute, final int second, final String timeZoneId) {
        return createCalendar(year, month, dayOfMonth, hourOfDay, minute, second, 0, timeZoneId);
    }

    public static Calendar createCalendar(final int year, final int month, final int dayOfMonth, final int hourOfDay, final int minute, final int second, final int millisecond, final String timeZoneId) {
        Calendar calendar = Calendar.getInstance();
        TimeZone timeZone = TimeZone.getTimeZone(timeZoneId);
        calendar.setTimeZone(timeZone);
        fillCalendarValues(calendar, year, month, dayOfMonth, hourOfDay, minute, second, millisecond);
        return calendar;
    }

    public static Calendar createUtcCalendar(final int year, final int month, final int dayOfMonth, final int hourOfDay, final int minute, final int second) {
        return createUtcCalendar(year, month, dayOfMonth, hourOfDay, minute, second, 0);
    }

    public static Calendar createUtcCalendar(final int year, final int month, final int dayOfMonth, final int hourOfDay, final int minute, final int second, final int millisecond) {
        Calendar calendar = Calendar.getInstance();
        TimeZone timeZone = TimeZone.getTimeZone(TIMEZONE_UTC);
        calendar.setTimeZone(timeZone);
        fillCalendarValues(calendar, year, month, dayOfMonth, hourOfDay, minute, second, millisecond);
        return calendar;
    }

    private static void fillCalendarValues(final Calendar calendar, final int year, final int month, final int dayOfMonth, final int hourOfDay, final int minute, final int second, final int millisecond) {
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, second);
        calendar.set(Calendar.MILLISECOND, millisecond);
    }

}
