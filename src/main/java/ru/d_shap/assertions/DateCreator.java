///////////////////////////////////////////////////////////////////////////////////////////////////
// Assertions library provides facilities for the unit testing.
// Copyright (C) 2017 Dmitry Shapovalov.
//
// This file is part of assertions library.
//
// Assertions library is free software: you can redistribute it and/or modify
// it under the terms of the GNU Lesser General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// Assertions library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public License
// along with this program. If not, see <http://www.gnu.org/licenses/>.
///////////////////////////////////////////////////////////////////////////////////////////////////
package ru.d_shap.assertions;

import java.util.Calendar;
import java.util.TimeZone;

/**
 * Helper class to create date objects.
 *
 * @author Dmitry Shapovalov
 */
public final class DateCreator {

    public static final String TIMEZONE_UTC = "UTC";

    public static final String TIMEZONE_GMT = "GMT";

    private DateCreator() {
        super();
    }

    /**
     * Create calendar object in the default time zone.
     *
     * @param year       the year.
     * @param month      the month.
     * @param dayOfMonth the day of month.
     * @param hourOfDay  the hour of day.
     * @param minute     the minute.
     * @param second     the second.
     *
     * @return the created object.
     */
    public static Calendar createCalendar(final int year, final int month, final int dayOfMonth, final int hourOfDay, final int minute, final int second) {
        return createCalendar(year, month, dayOfMonth, hourOfDay, minute, second, 0);
    }

    /**
     * Create calendar object in the default time zone.
     *
     * @param year        the year.
     * @param month       the month.
     * @param dayOfMonth  the day of month.
     * @param hourOfDay   the hour of day.
     * @param minute      the minute.
     * @param second      the second.
     * @param millisecond the millisecond.
     *
     * @return the created object.
     */
    public static Calendar createCalendar(final int year, final int month, final int dayOfMonth, final int hourOfDay, final int minute, final int second, final int millisecond) {
        Calendar calendar = Calendar.getInstance();
        fillCalendarValues(calendar, year, month, dayOfMonth, hourOfDay, minute, second, millisecond);
        return calendar;
    }

    /**
     * Create calendar object in the specified time zone.
     *
     * @param year       the year.
     * @param month      the month.
     * @param dayOfMonth the day of month.
     * @param hourOfDay  the hour of day.
     * @param minute     the minute.
     * @param second     the second.
     * @param timeZoneId the time zone ID.
     *
     * @return the created object.
     */
    public static Calendar createCalendar(final int year, final int month, final int dayOfMonth, final int hourOfDay, final int minute, final int second, final String timeZoneId) {
        return createCalendar(year, month, dayOfMonth, hourOfDay, minute, second, 0, timeZoneId);
    }

    /**
     * Create calendar object in the specified time zone.
     *
     * @param year        the year.
     * @param month       the month.
     * @param dayOfMonth  the day of month.
     * @param hourOfDay   the hour of day.
     * @param minute      the minute.
     * @param second      the second.
     * @param millisecond the millisecond.
     * @param timeZoneId  the time zone ID.
     *
     * @return the created object.
     */
    public static Calendar createCalendar(final int year, final int month, final int dayOfMonth, final int hourOfDay, final int minute, final int second, final int millisecond, final String timeZoneId) {
        Calendar calendar = Calendar.getInstance();
        TimeZone timeZone = TimeZone.getTimeZone(timeZoneId);
        calendar.setTimeZone(timeZone);
        fillCalendarValues(calendar, year, month, dayOfMonth, hourOfDay, minute, second, millisecond);
        return calendar;
    }

    /**
     * Create calendar object in the UTC time zone.
     *
     * @param year       the year.
     * @param month      the month.
     * @param dayOfMonth the day of month.
     * @param hourOfDay  the hour of day.
     * @param minute     the minute.
     * @param second     the second.
     *
     * @return the created object.
     */
    public static Calendar createUtcCalendar(final int year, final int month, final int dayOfMonth, final int hourOfDay, final int minute, final int second) {
        return createUtcCalendar(year, month, dayOfMonth, hourOfDay, minute, second, 0);
    }

    /**
     * Create calendar object in the UTC time zone.
     *
     * @param year        the year.
     * @param month       the month.
     * @param dayOfMonth  the day of month.
     * @param hourOfDay   the hour of day.
     * @param minute      the minute.
     * @param second      the second.
     * @param millisecond the millisecond.
     *
     * @return the created object.
     */
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
