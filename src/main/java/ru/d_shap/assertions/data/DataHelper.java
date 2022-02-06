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
package ru.d_shap.assertions.data;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * Helper class to create objects of various types.
 *
 * @author Dmitry Shapovalov
 */
public final class DataHelper {

    public static final String TIMEZONE_UTC = "UTC";

    public static final String TIMEZONE_GMT = "GMT";

    private DataHelper() {
        super();
    }

    /**
     * Create date object.
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
    public static Date createDate(final int year, final int month, final int dayOfMonth, final int hourOfDay, final int minute, final int second) {
        return createDate(year, month, dayOfMonth, hourOfDay, minute, second, 0);
    }

    /**
     * Create date object.
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
    public static Date createDate(final int year, final int month, final int dayOfMonth, final int hourOfDay, final int minute, final int second, final int millisecond) {
        Calendar calendar = createCalendar(year, month, dayOfMonth, hourOfDay, minute, second, millisecond);
        return calendar.getTime();
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
        Calendar calendar = new GregorianCalendar();
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
        Calendar calendar = new GregorianCalendar();
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
        TimeZone timeZone = TimeZone.getTimeZone(TIMEZONE_UTC);
        Calendar calendar = new GregorianCalendar(timeZone);
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

    /**
     * Create XML calendar object in the default time zone.
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
    public static XMLGregorianCalendar createXmlCalendar(final int year, final int month, final int dayOfMonth, final int hourOfDay, final int minute, final int second) {
        return createXmlCalendar(year, month, dayOfMonth, hourOfDay, minute, second, 0);
    }

    /**
     * Create XML calendar object in the default time zone.
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
    public static XMLGregorianCalendar createXmlCalendar(final int year, final int month, final int dayOfMonth, final int hourOfDay, final int minute, final int second, final int millisecond) {
        GregorianCalendar calendar = (GregorianCalendar) createCalendar(year, month, dayOfMonth, hourOfDay, minute, second, millisecond);
        return convertToXmlCalendar(calendar);
    }

    /**
     * Create XML calendar object in the specified time zone.
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
    public static XMLGregorianCalendar createXmlCalendar(final int year, final int month, final int dayOfMonth, final int hourOfDay, final int minute, final int second, final String timeZoneId) {
        return createXmlCalendar(year, month, dayOfMonth, hourOfDay, minute, second, 0, timeZoneId);
    }

    /**
     * Create XML calendar object in the specified time zone.
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
    public static XMLGregorianCalendar createXmlCalendar(final int year, final int month, final int dayOfMonth, final int hourOfDay, final int minute, final int second, final int millisecond, final String timeZoneId) {
        GregorianCalendar calendar = (GregorianCalendar) createCalendar(year, month, dayOfMonth, hourOfDay, minute, second, millisecond, timeZoneId);
        return convertToXmlCalendar(calendar);
    }

    /**
     * Create XML calendar object in the UTC time zone.
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
    public static XMLGregorianCalendar createUtcXmlCalendar(final int year, final int month, final int dayOfMonth, final int hourOfDay, final int minute, final int second) {
        return createUtcXmlCalendar(year, month, dayOfMonth, hourOfDay, minute, second, 0);
    }

    /**
     * Create XML calendar object in the UTC time zone.
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
    public static XMLGregorianCalendar createUtcXmlCalendar(final int year, final int month, final int dayOfMonth, final int hourOfDay, final int minute, final int second, final int millisecond) {
        GregorianCalendar calendar = (GregorianCalendar) createUtcCalendar(year, month, dayOfMonth, hourOfDay, minute, second, millisecond);
        return convertToXmlCalendar(calendar);
    }

    private static XMLGregorianCalendar convertToXmlCalendar(final GregorianCalendar calendar) {
        try {
            DatatypeFactory datatypeFactory = DatatypeFactory.newInstance();
            return datatypeFactory.newXMLGregorianCalendar(calendar);
        } catch (DatatypeConfigurationException ex) {
            throw new DataException(ex);
        }
    }

}
