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
package ru.d_shap.assertions.asimp.javax.xml.datatype;

import java.util.Calendar;
import java.util.TimeZone;

import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.XMLGregorianCalendar;

import org.hamcrest.Matcher;

import ru.d_shap.assertions.DataCreator;
import ru.d_shap.assertions.Messages;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.asimp.ReferenceAssertion;
import ru.d_shap.assertions.asimp.java.util.CalendarAssertion;
import ru.d_shap.assertions.asimp.primitive.IntAssertion;

/**
 * Assertions for the XML gregorian calendar.
 *
 * @author Dmitry Shapovalov
 */
public class XMLGregorianCalendarAssertion extends ReferenceAssertion<XMLGregorianCalendar> {

    /**
     * Create new object.
     */
    public XMLGregorianCalendarAssertion() {
        super();
    }

    @Override
    protected final Class<XMLGregorianCalendar> getActualValueClass() {
        return XMLGregorianCalendar.class;
    }

    /**
     * Check if the actual value is equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isEqualTo(final XMLGregorianCalendar expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        if (!getActual().equals(expected)) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_SAME).addActual().addExpected(expected).build();
        }
    }

    /**
     * Check if the actual value is NOT equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isNotEqualTo(final XMLGregorianCalendar expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        if (getActual().equals(expected)) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_DIFFERENT).addActual().build();
        }
    }

    /**
     * Check if the actual value is greater than the expected value.
     *
     * @param expected the expected value.
     */
    public final void isGreaterThan(final XMLGregorianCalendar expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        int compare = getActual().compare(expected);
        if (compare == DatatypeConstants.LESSER || compare == DatatypeConstants.EQUAL) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_GREATER).addActual().addExpected(expected).build();
        }
    }

    /**
     * Check if the actual value is greater than or equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isGreaterThanOrEqualTo(final XMLGregorianCalendar expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        int compare = getActual().compare(expected);
        if (compare == DatatypeConstants.LESSER) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_GREATER_OR_EQUAL).addActual().addExpected(expected).build();
        }
    }

    /**
     * Check if the actual value is less than the expected value.
     *
     * @param expected the expected value.
     */
    public final void isLessThan(final XMLGregorianCalendar expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        int compare = getActual().compare(expected);
        if (compare == DatatypeConstants.GREATER || compare == DatatypeConstants.EQUAL) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_LESS).addActual().addExpected(expected).build();
        }
    }

    /**
     * Check if the actual value is less than or equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isLessThanOrEqualTo(final XMLGregorianCalendar expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        int compare = getActual().compare(expected);
        if (compare == DatatypeConstants.GREATER) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_LESS_OR_EQUAL).addActual().addExpected(expected).build();
        }
    }

    /**
     * Check if the actual value is in the expected range.
     *
     * @param expectedFrom the expected lower (inclusive) bound of the range.
     * @param expectedTo   the expected upper (exclusive) bound of the range.
     */
    public final void isInRange(final XMLGregorianCalendar expectedFrom, final XMLGregorianCalendar expectedTo) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expectedFrom, "expectedFrom");
        checkArgumentIsNotNull(expectedTo, "expectedTo");
        int compare1 = getActual().compare(expectedFrom);
        int compare2 = getActual().compare(expectedTo);
        if (compare1 == DatatypeConstants.LESSER || compare2 == DatatypeConstants.GREATER || compare2 == DatatypeConstants.EQUAL) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_IN_RANGE).addActual().addExpected(expectedFrom, expectedTo).build();
        }
    }

    /**
     * Check if the actual value is NOT in the expected range.
     *
     * @param expectedFrom the expected lower (inclusive) bound of the range.
     * @param expectedTo   the expected upper (exclusive) bound of the range.
     */
    public final void isNotInRange(final XMLGregorianCalendar expectedFrom, final XMLGregorianCalendar expectedTo) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expectedFrom, "expectedFrom");
        checkArgumentIsNotNull(expectedTo, "expectedTo");
        int compare1 = getActual().compare(expectedFrom);
        int compare2 = getActual().compare(expectedTo);
        if ((compare1 == DatatypeConstants.GREATER || compare1 == DatatypeConstants.EQUAL) && compare2 == DatatypeConstants.LESSER) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_NOT_IN_RANGE).addActual().addExpected(expectedFrom, expectedTo).build();
        }
    }

    /**
     * Make assertion about the actual value's year.
     *
     * @return the assertion.
     */
    public final IntAssertion toYear() {
        return createCalendarAssertion().toYear();
    }

    /**
     * Make assertion about the actual value's year.
     *
     * @param matcher the hamcrest matcher.
     */
    public final void toYear(final Matcher<Integer> matcher) {
        createCalendarAssertion().toYear(matcher);
    }

    /**
     * Check if the actual value's year is equal to the expected year.
     *
     * @param expected the expected value.
     */
    public final void hasYear(final int expected) {
        createCalendarAssertion().hasYear(expected);
    }

    /**
     * Make assertion about the actual value's month.
     *
     * @return the assertion.
     */
    public final IntAssertion toMonth() {
        return createCalendarAssertion().toMonth();
    }

    /**
     * Make assertion about the actual value's month.
     *
     * @param matcher the hamcrest matcher.
     */
    public final void toMonth(final Matcher<Integer> matcher) {
        createCalendarAssertion().toMonth(matcher);
    }

    /**
     * Check if the actual value's month is equal to the expected month.
     *
     * @param expected the expected value.
     */
    public final void hasMonth(final int expected) {
        createCalendarAssertion().hasMonth(expected);
    }

    /**
     * Make assertion about the actual value's week of year.
     *
     * @return the assertion.
     */
    public final IntAssertion toWeekOfYear() {
        return createCalendarAssertion().toWeekOfYear();
    }

    /**
     * Make assertion about the actual value's week of year.
     *
     * @param matcher the hamcrest matcher.
     */
    public final void toWeekOfYear(final Matcher<Integer> matcher) {
        createCalendarAssertion().toWeekOfYear(matcher);
    }

    /**
     * Check if the actual value's week of year is equal to the expected week of year.
     *
     * @param expected the expected value.
     */
    public final void hasWeekOfYear(final int expected) {
        createCalendarAssertion().hasWeekOfYear(expected);
    }

    /**
     * Make assertion about the actual value's week of month.
     *
     * @return the assertion.
     */
    public final IntAssertion toWeekOfMonth() {
        return createCalendarAssertion().toWeekOfMonth();
    }

    /**
     * Make assertion about the actual value's week of month.
     *
     * @param matcher the hamcrest matcher.
     */
    public final void toWeekOfMonth(final Matcher<Integer> matcher) {
        createCalendarAssertion().toWeekOfMonth(matcher);
    }

    /**
     * Check if the actual value's week of month is equal to the expected week of month.
     *
     * @param expected the expected value.
     */
    public final void hasWeekOfMonth(final int expected) {
        createCalendarAssertion().hasWeekOfMonth(expected);
    }

    /**
     * Make assertion about the actual value's day of year.
     *
     * @return the assertion.
     */
    public final IntAssertion toDayOfYear() {
        return createCalendarAssertion().toDayOfYear();
    }

    /**
     * Make assertion about the actual value's day of year.
     *
     * @param matcher the hamcrest matcher.
     */
    public final void toDayOfYear(final Matcher<Integer> matcher) {
        createCalendarAssertion().toDayOfYear(matcher);
    }

    /**
     * Check if the actual value's day day of year is equal to the expected day of year.
     *
     * @param expected the expected value.
     */
    public final void hasDayOfYear(final int expected) {
        createCalendarAssertion().hasDayOfYear(expected);
    }

    /**
     * Make assertion about the actual value's day of month.
     *
     * @return the assertion.
     */
    public final IntAssertion toDayOfMonth() {
        return createCalendarAssertion().toDayOfMonth();
    }

    /**
     * Make assertion about the actual value's day of month.
     *
     * @param matcher the hamcrest matcher.
     */
    public final void toDayOfMonth(final Matcher<Integer> matcher) {
        createCalendarAssertion().toDayOfMonth(matcher);
    }

    /**
     * Check if the actual value's day of month is equal to the expected day of month.
     *
     * @param expected the expected value.
     */
    public final void hasDayOfMonth(final int expected) {
        createCalendarAssertion().hasDayOfMonth(expected);
    }

    /**
     * Make assertion about the actual value's day of week in month.
     *
     * @return the assertion.
     */
    public final IntAssertion toDayOfWeekInMonth() {
        return createCalendarAssertion().toDayOfWeekInMonth();
    }

    /**
     * Make assertion about the actual value's day of week in month.
     *
     * @param matcher the hamcrest matcher.
     */
    public final void toDayOfWeekInMonth(final Matcher<Integer> matcher) {
        createCalendarAssertion().toDayOfWeekInMonth(matcher);
    }

    /**
     * Check if the actual value's day of week in month is equal to the expected day of week in month.
     *
     * @param expected the expected value.
     */
    public final void hasDayOfWeekInMonth(final int expected) {
        createCalendarAssertion().hasDayOfWeekInMonth(expected);
    }

    /**
     * Make assertion about the actual value's day of week.
     *
     * @return the assertion.
     */
    public final IntAssertion toDayOfWeek() {
        return createCalendarAssertion().toDayOfWeek();
    }

    /**
     * Make assertion about the actual value's day of week.
     *
     * @param matcher the hamcrest matcher.
     */
    public final void toDayOfWeek(final Matcher<Integer> matcher) {
        createCalendarAssertion().toDayOfWeek(matcher);
    }

    /**
     * Check if the actual value's day of week is equal to the expected day of week.
     *
     * @param expected the expected value.
     */
    public final void hasDayOfWeek(final int expected) {
        createCalendarAssertion().hasDayOfWeek(expected);
    }

    /**
     * Make assertion about the actual value's AM/PM.
     *
     * @return the assertion.
     */
    public final IntAssertion toAmPm() {
        return createCalendarAssertion().toAmPm();
    }

    /**
     * Make assertion about the actual value's AM/PM.
     *
     * @param matcher the hamcrest matcher.
     */
    public final void toAmPm(final Matcher<Integer> matcher) {
        createCalendarAssertion().toAmPm(matcher);
    }

    /**
     * Check if the actual value's AM/PM is equal to AM.
     */
    public final void isAm() {
        createCalendarAssertion().isAm();
    }

    /**
     * Check if the actual value's AM/PM is equal to PM.
     */
    public final void isPm() {
        createCalendarAssertion().isPm();
    }

    /**
     * Make assertion about the actual value's hour of day.
     *
     * @return the assertion.
     */
    public final IntAssertion toHourOfDay() {
        return createCalendarAssertion().toHourOfDay();
    }

    /**
     * Make assertion about the actual value's hour of day.
     *
     * @param matcher the hamcrest matcher.
     */
    public final void toHourOfDay(final Matcher<Integer> matcher) {
        createCalendarAssertion().toHourOfDay(matcher);
    }

    /**
     * Check if the actual value's hour of day is equal to the expected hour of day.
     *
     * @param expected the expected value.
     */
    public final void hasHourOfDay(final int expected) {
        createCalendarAssertion().hasHourOfDay(expected);
    }

    /**
     * Make assertion about the actual value's hour.
     *
     * @return the assertion.
     */
    public final IntAssertion toHour() {
        return createCalendarAssertion().toHour();
    }

    /**
     * Make assertion about the actual value's hour.
     *
     * @param matcher the hamcrest matcher.
     */
    public final void toHour(final Matcher<Integer> matcher) {
        createCalendarAssertion().toHour(matcher);
    }

    /**
     * Check if the actual value's hour is equal to the expected hour.
     *
     * @param expected the expected value.
     */
    public final void hasHour(final int expected) {
        createCalendarAssertion().hasHour(expected);
    }

    /**
     * Make assertion about the actual value's minute.
     *
     * @return the assertion.
     */
    public final IntAssertion toMinute() {
        return createCalendarAssertion().toMinute();
    }

    /**
     * Make assertion about the actual value's minute.
     *
     * @param matcher the hamcrest matcher.
     */
    public final void toMinute(final Matcher<Integer> matcher) {
        createCalendarAssertion().toMinute(matcher);
    }

    /**
     * Check if the actual value's minute is equal to the expected minute.
     *
     * @param expected the expected value.
     */
    public final void hasMinute(final int expected) {
        createCalendarAssertion().hasMinute(expected);
    }

    /**
     * Make assertion about the actual value's second.
     *
     * @return the assertion.
     */
    public final IntAssertion toSecond() {
        return createCalendarAssertion().toSecond();
    }

    /**
     * Make assertion about the actual value's second.
     *
     * @param matcher the hamcrest matcher.
     */
    public final void toSecond(final Matcher<Integer> matcher) {
        createCalendarAssertion().toSecond(matcher);
    }

    /**
     * Check if the actual value's second is equal to the expected second.
     *
     * @param expected the expected value.
     */
    public final void hasSecond(final int expected) {
        createCalendarAssertion().hasSecond(expected);
    }

    /**
     * Make assertion about the actual value's millisecond.
     *
     * @return the assertion.
     */
    public final IntAssertion toMillisecond() {
        return createCalendarAssertion().toMillisecond();
    }

    /**
     * Make assertion about the actual value's millisecond.
     *
     * @param matcher the hamcrest matcher.
     */
    public final void toMillisecond(final Matcher<Integer> matcher) {
        createCalendarAssertion().toMillisecond(matcher);
    }

    /**
     * Check if the actual value's millisecond is equal to the expected millisecond.
     *
     * @param expected the expected value.
     */
    public final void hasMillisecond(final int expected) {
        createCalendarAssertion().hasMillisecond(expected);
    }

    /**
     * Make assertion about the actual value's zone offset.
     *
     * @return the assertion.
     */
    public final IntAssertion toZoneOffset() {
        return createCalendarAssertion().toZoneOffset();
    }

    /**
     * Make assertion about the actual value's zone offset.
     *
     * @param matcher the hamcrest matcher.
     */
    public final void toZoneOffset(final Matcher<Integer> matcher) {
        createCalendarAssertion().toZoneOffset(matcher);
    }

    /**
     * Check if the actual value's zone offset is equal to the expected zone offset.
     *
     * @param expected the expected value.
     */
    public final void hasZoneOffset(final int expected) {
        createCalendarAssertion().hasZoneOffset(expected);
    }

    /**
     * Check if the actual value's date properties are equal to the expected date properties.
     *
     * @param year       the expected year.
     * @param month      the expected month.
     * @param dayOfMonth the expected day of month.
     */
    public final void hasDate(final int year, final int month, final int dayOfMonth) {
        createCalendarAssertion().hasDate(year, month, dayOfMonth);
    }

    /**
     * Check if the actual value's date properties are equal to the expected date properties in the UTC time zone.
     *
     * @param year       the expected year.
     * @param month      the expected month.
     * @param dayOfMonth the expected day of month.
     */
    public final void hasUtcDate(final int year, final int month, final int dayOfMonth) {
        createCalendarAssertion().hasUtcDate(year, month, dayOfMonth);
    }

    /**
     * Check if the actual value's time properties are equal to the expected time properties.
     *
     * @param hourOfDay the expected hour of day.
     * @param minute    the expected minute.
     * @param second    the expected second.
     */
    public final void hasTime(final int hourOfDay, final int minute, final int second) {
        createCalendarAssertion().hasTime(hourOfDay, minute, second);
    }

    /**
     * Check if the actual value's time properties are equal to the expected time properties.
     *
     * @param hourOfDay   the expected hour of day.
     * @param minute      the expected minute.
     * @param second      the expected second.
     * @param millisecond the expected millisecond.
     */
    public final void hasTime(final int hourOfDay, final int minute, final int second, final int millisecond) {
        createCalendarAssertion().hasTime(hourOfDay, minute, millisecond);
    }

    /**
     * Check if the actual value's time properties are equal to the expected time properties in the UTC time zone.
     *
     * @param hourOfDay the expected hour of day.
     * @param minute    the expected minute.
     * @param second    the expected second.
     */
    public final void hasUtcTime(final int hourOfDay, final int minute, final int second) {
        createCalendarAssertion().hasUtcTime(hourOfDay, minute, second);
    }

    /**
     * Check if the actual value's time properties are equal to the expected time properties in the UTC time zone.
     *
     * @param hourOfDay   the expected hour of day.
     * @param minute      the expected minute.
     * @param second      the expected second.
     * @param millisecond the expected millisecond.
     */
    public final void hasUtcTime(final int hourOfDay, final int minute, final int second, final int millisecond) {
        createCalendarAssertion().hasUtcTime(hourOfDay, minute, millisecond);
    }

    /**
     * Check if the actual value's date and time properties are equal to the expected date and time properties.
     *
     * @param year       the expected year.
     * @param month      the expected month.
     * @param dayOfMonth the expected day of month.
     * @param hourOfDay  the expected hour of day.
     * @param minute     the expected minute.
     * @param second     the expected second.
     */
    public final void hasDateAndTime(final int year, final int month, final int dayOfMonth, final int hourOfDay, final int minute, final int second) {
        createCalendarAssertion().hasDateAndTime(year, month, dayOfMonth, hourOfDay, minute, second);
    }

    /**
     * Check if the actual value's date and time properties are equal to the expected date and time properties.
     *
     * @param year        the expected year.
     * @param month       the expected month.
     * @param dayOfMonth  the expected day of month.
     * @param hourOfDay   the expected hour of day.
     * @param minute      the expected minute.
     * @param second      the expected second.
     * @param millisecond the expected millisecond.
     */
    public final void hasDateAndTime(final int year, final int month, final int dayOfMonth, final int hourOfDay, final int minute, final int second, final int millisecond) {
        createCalendarAssertion().hasDateAndTime(year, month, dayOfMonth, hourOfDay, minute, second, millisecond);
    }

    /**
     * Check if the actual value's date and time properties are equal to the expected date and time properties in the UTC time zone.
     *
     * @param year       the expected year.
     * @param month      the expected month.
     * @param dayOfMonth the expected day of month.
     * @param hourOfDay  the expected hour of day.
     * @param minute     the expected minute.
     * @param second     the expected second.
     */
    public final void hasUtcDateAndTime(final int year, final int month, final int dayOfMonth, final int hourOfDay, final int minute, final int second) {
        createCalendarAssertion().hasUtcDateAndTime(year, month, dayOfMonth, hourOfDay, minute, second);
    }

    /**
     * Check if the actual value's date and time properties are equal to the expected date and time properties in the UTC time zone.
     *
     * @param year        the expected year.
     * @param month       the expected month.
     * @param dayOfMonth  the expected day of month.
     * @param hourOfDay   the expected hour of day.
     * @param minute      the expected minute.
     * @param second      the expected second.
     * @param millisecond the expected millisecond.
     */
    public final void hasUtcDateAndTime(final int year, final int month, final int dayOfMonth, final int hourOfDay, final int minute, final int second, final int millisecond) {
        createCalendarAssertion().hasUtcDateAndTime(year, month, dayOfMonth, hourOfDay, minute, second, millisecond);
    }

    private CalendarAssertion createCalendarAssertion() {
        checkActualIsNotNull();
        Calendar calendar = convertValue(getActual(), null, Calendar.class, (TimeZone) null);
        return initializeAssertion(Raw.calendarAssertion(), calendar);
    }

    /**
     * Make assertion about the actual value's date in the specified time zone.
     *
     * @param timeZone the specified time zone.
     *
     * @return the assertion.
     */
    public final CalendarAssertion toTimeZoneCalendar(final TimeZone timeZone) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(timeZone, "timeZone");
        Calendar calendar = convertValue(getActual(), null, Calendar.class, timeZone);
        return initializeAssertion(Raw.calendarAssertion(), calendar, Messages.Check.TIME_ZONE_DATE, timeZone);
    }

    /**
     * Make assertion about the actual value's date in the specified time zone.
     *
     * @param timeZoneId the specified time zone ID.
     *
     * @return the assertion.
     */
    public final CalendarAssertion toTimeZoneCalendar(final String timeZoneId) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(timeZoneId, "timeZoneId");
        TimeZone timeZone = TimeZone.getTimeZone(timeZoneId);
        return toTimeZoneCalendar(timeZone);
    }

    /**
     * Make assertion about the actual value's date in the UTC time zone.
     *
     * @return the assertion.
     */
    public final CalendarAssertion toUtcTimeZoneCalendar() {
        return toTimeZoneCalendar(DataCreator.TIMEZONE_UTC);
    }

}
