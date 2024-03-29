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

import ru.d_shap.assertions.Messages;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.asimp.ReferenceAssertion;
import ru.d_shap.assertions.asimp.java.util.CalendarAssertion;
import ru.d_shap.assertions.asimp.primitive.IntAssertion;
import ru.d_shap.assertions.util.DataHelper;

/**
 * Assertions for the XML gregorian calendar.
 *
 * @author Dmitry Shapovalov
 */
public final class XMLGregorianCalendarAssertion extends ReferenceAssertion<XMLGregorianCalendarAssertion, XMLGregorianCalendar> {

    /**
     * Create new object.
     */
    public XMLGregorianCalendarAssertion() {
        super();
    }

    @Override
    protected Class<XMLGregorianCalendar> getActualValueClass() {
        return XMLGregorianCalendar.class;
    }

    /**
     * Check if the actual value is equal to the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public XMLGregorianCalendarAssertion isEqualTo(final XMLGregorianCalendar expected) {
        if (expected == null) {
            isNull();
        } else {
            checkActualIsNotNull();
            if (!getActual().equals(expected)) {
                throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_SAME).addActual().addExpected(expected).build();
            }
        }
        return this;
    }

    /**
     * Check if the actual value is NOT equal to the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public XMLGregorianCalendarAssertion isNotEqualTo(final XMLGregorianCalendar expected) {
        if (expected == null) {
            isNotNull();
        } else {
            if (getActual() != null && getActual().equals(expected)) {
                throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_DIFFERENT).addActual().build();
            }
        }
        return this;
    }

    /**
     * Check if the actual value is greater than the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public XMLGregorianCalendarAssertion isGreaterThan(final XMLGregorianCalendar expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        int compare = getActual().compare(expected);
        if (compare == DatatypeConstants.LESSER || compare == DatatypeConstants.EQUAL) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_GREATER).addActual().addExpected(expected).build();
        }
        return this;
    }

    /**
     * Check if the actual value is greater than or equal to the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public XMLGregorianCalendarAssertion isGreaterThanOrEqualTo(final XMLGregorianCalendar expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        int compare = getActual().compare(expected);
        if (compare == DatatypeConstants.LESSER) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_GREATER_OR_EQUAL).addActual().addExpected(expected).build();
        }
        return this;
    }

    /**
     * Check if the actual value is less than the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public XMLGregorianCalendarAssertion isLessThan(final XMLGregorianCalendar expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        int compare = getActual().compare(expected);
        if (compare == DatatypeConstants.GREATER || compare == DatatypeConstants.EQUAL) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_LESS).addActual().addExpected(expected).build();
        }
        return this;
    }

    /**
     * Check if the actual value is less than or equal to the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public XMLGregorianCalendarAssertion isLessThanOrEqualTo(final XMLGregorianCalendar expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        int compare = getActual().compare(expected);
        if (compare == DatatypeConstants.GREATER) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_LESS_OR_EQUAL).addActual().addExpected(expected).build();
        }
        return this;
    }

    /**
     * Check if the actual value is in the expected range.
     *
     * @param expectedFrom the expected lower (inclusive) bound of the range.
     * @param expectedTo   the expected upper (exclusive) bound of the range.
     *
     * @return current object for the chain call.
     */
    public XMLGregorianCalendarAssertion isInRange(final XMLGregorianCalendar expectedFrom, final XMLGregorianCalendar expectedTo) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expectedFrom, "expectedFrom");
        checkArgumentIsNotNull(expectedTo, "expectedTo");
        int compare1 = getActual().compare(expectedFrom);
        int compare2 = getActual().compare(expectedTo);
        if (compare1 == DatatypeConstants.LESSER || compare2 == DatatypeConstants.GREATER || compare2 == DatatypeConstants.EQUAL) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_IN_RANGE).addActual().addExpected(expectedFrom, expectedTo).build();
        }
        return this;
    }

    /**
     * Check if the actual value is NOT in the expected range.
     *
     * @param expectedFrom the expected lower (inclusive) bound of the range.
     * @param expectedTo   the expected upper (exclusive) bound of the range.
     *
     * @return current object for the chain call.
     */
    public XMLGregorianCalendarAssertion isNotInRange(final XMLGregorianCalendar expectedFrom, final XMLGregorianCalendar expectedTo) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expectedFrom, "expectedFrom");
        checkArgumentIsNotNull(expectedTo, "expectedTo");
        int compare1 = getActual().compare(expectedFrom);
        int compare2 = getActual().compare(expectedTo);
        if ((compare1 == DatatypeConstants.GREATER || compare1 == DatatypeConstants.EQUAL) && compare2 == DatatypeConstants.LESSER) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_NOT_IN_RANGE).addActual().addExpected(expectedFrom, expectedTo).build();
        }
        return this;
    }

    /**
     * Make assertion about the actual value's year.
     *
     * @return the assertion.
     */
    public IntAssertion toYear() {
        return createCalendarAssertion().toYear();
    }

    /**
     * Make assertion about the actual value's year.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public XMLGregorianCalendarAssertion toYear(final Matcher<? super Integer> matcher) {
        createCalendarAssertion().toYear(matcher);
        return this;
    }

    /**
     * Check if the actual value's year is equal to the expected year.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public XMLGregorianCalendarAssertion hasYear(final int expected) {
        createCalendarAssertion().hasYear(expected);
        return this;
    }

    /**
     * Make assertion about the actual value's month.
     *
     * @return the assertion.
     */
    public IntAssertion toMonth() {
        return createCalendarAssertion().toMonth();
    }

    /**
     * Make assertion about the actual value's month.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public XMLGregorianCalendarAssertion toMonth(final Matcher<? super Integer> matcher) {
        createCalendarAssertion().toMonth(matcher);
        return this;
    }

    /**
     * Check if the actual value's month is equal to the expected month.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public XMLGregorianCalendarAssertion hasMonth(final int expected) {
        createCalendarAssertion().hasMonth(expected);
        return this;
    }

    /**
     * Make assertion about the actual value's day of month.
     *
     * @return the assertion.
     */
    public IntAssertion toDayOfMonth() {
        return createCalendarAssertion().toDayOfMonth();
    }

    /**
     * Make assertion about the actual value's day of month.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public XMLGregorianCalendarAssertion toDayOfMonth(final Matcher<? super Integer> matcher) {
        createCalendarAssertion().toDayOfMonth(matcher);
        return this;
    }

    /**
     * Check if the actual value's day of month is equal to the expected day of month.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public XMLGregorianCalendarAssertion hasDayOfMonth(final int expected) {
        createCalendarAssertion().hasDayOfMonth(expected);
        return this;
    }

    /**
     * Make assertion about the actual value's hour of day.
     *
     * @return the assertion.
     */
    public IntAssertion toHourOfDay() {
        return createCalendarAssertion().toHourOfDay();
    }

    /**
     * Make assertion about the actual value's hour of day.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public XMLGregorianCalendarAssertion toHourOfDay(final Matcher<? super Integer> matcher) {
        createCalendarAssertion().toHourOfDay(matcher);
        return this;
    }

    /**
     * Check if the actual value's hour of day is equal to the expected hour of day.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public XMLGregorianCalendarAssertion hasHourOfDay(final int expected) {
        createCalendarAssertion().hasHourOfDay(expected);
        return this;
    }

    /**
     * Make assertion about the actual value's minute.
     *
     * @return the assertion.
     */
    public IntAssertion toMinute() {
        return createCalendarAssertion().toMinute();
    }

    /**
     * Make assertion about the actual value's minute.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public XMLGregorianCalendarAssertion toMinute(final Matcher<? super Integer> matcher) {
        createCalendarAssertion().toMinute(matcher);
        return this;
    }

    /**
     * Check if the actual value's minute is equal to the expected minute.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public XMLGregorianCalendarAssertion hasMinute(final int expected) {
        createCalendarAssertion().hasMinute(expected);
        return this;
    }

    /**
     * Make assertion about the actual value's second.
     *
     * @return the assertion.
     */
    public IntAssertion toSecond() {
        return createCalendarAssertion().toSecond();
    }

    /**
     * Make assertion about the actual value's second.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public XMLGregorianCalendarAssertion toSecond(final Matcher<? super Integer> matcher) {
        createCalendarAssertion().toSecond(matcher);
        return this;
    }

    /**
     * Check if the actual value's second is equal to the expected second.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public XMLGregorianCalendarAssertion hasSecond(final int expected) {
        createCalendarAssertion().hasSecond(expected);
        return this;
    }

    /**
     * Make assertion about the actual value's millisecond.
     *
     * @return the assertion.
     */
    public IntAssertion toMillisecond() {
        return createCalendarAssertion().toMillisecond();
    }

    /**
     * Make assertion about the actual value's millisecond.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public XMLGregorianCalendarAssertion toMillisecond(final Matcher<? super Integer> matcher) {
        createCalendarAssertion().toMillisecond(matcher);
        return this;
    }

    /**
     * Check if the actual value's millisecond is equal to the expected millisecond.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public XMLGregorianCalendarAssertion hasMillisecond(final int expected) {
        createCalendarAssertion().hasMillisecond(expected);
        return this;
    }

    /**
     * Make assertion about the actual value's zone offset.
     *
     * @return the assertion.
     */
    public IntAssertion toZoneOffset() {
        return createCalendarAssertion().toZoneOffset();
    }

    /**
     * Make assertion about the actual value's zone offset.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public XMLGregorianCalendarAssertion toZoneOffset(final Matcher<? super Integer> matcher) {
        createCalendarAssertion().toZoneOffset(matcher);
        return this;
    }

    /**
     * Check if the actual value's zone offset is equal to the expected zone offset.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public XMLGregorianCalendarAssertion hasZoneOffset(final int expected) {
        createCalendarAssertion().hasZoneOffset(expected);
        return this;
    }

    /**
     * Check if the actual value's date properties are equal to the expected date properties.
     *
     * @param year       the expected year.
     * @param month      the expected month.
     * @param dayOfMonth the expected day of month.
     *
     * @return current object for the chain call.
     */
    public XMLGregorianCalendarAssertion hasDate(final int year, final int month, final int dayOfMonth) {
        createCalendarAssertion().hasDate(year, month, dayOfMonth);
        return this;
    }

    /**
     * Check if the actual value's date and time zone properties are equal to the expected date and time zone properties.
     *
     * @param year       the expected year.
     * @param month      the expected month.
     * @param dayOfMonth the expected day of month.
     * @param zoneOffset the expected zone offset.
     *
     * @return current object for the chain call.
     */
    public XMLGregorianCalendarAssertion hasTimeZoneDate(final int year, final int month, final int dayOfMonth, final int zoneOffset) {
        createCalendarAssertion().hasTimeZoneDate(year, month, dayOfMonth, zoneOffset);
        return this;
    }

    /**
     * Check if the actual value's date properties are equal to the expected date properties in the UTC time zone.
     *
     * @param year       the expected year.
     * @param month      the expected month.
     * @param dayOfMonth the expected day of month.
     *
     * @return current object for the chain call.
     */
    public XMLGregorianCalendarAssertion hasUtcDate(final int year, final int month, final int dayOfMonth) {
        createCalendarAssertion().hasUtcDate(year, month, dayOfMonth);
        return this;
    }

    /**
     * Check if the actual value's time properties are equal to the expected time properties.
     *
     * @param hourOfDay the expected hour of day.
     * @param minute    the expected minute.
     * @param second    the expected second.
     *
     * @return current object for the chain call.
     */
    public XMLGregorianCalendarAssertion hasTime(final int hourOfDay, final int minute, final int second) {
        createCalendarAssertion().hasTime(hourOfDay, minute, second);
        return this;
    }

    /**
     * Check if the actual value's time properties are equal to the expected time properties.
     *
     * @param hourOfDay   the expected hour of day.
     * @param minute      the expected minute.
     * @param second      the expected second.
     * @param millisecond the expected millisecond.
     *
     * @return current object for the chain call.
     */
    public XMLGregorianCalendarAssertion hasTime(final int hourOfDay, final int minute, final int second, final int millisecond) {
        createCalendarAssertion().hasTime(hourOfDay, minute, second, millisecond);
        return this;
    }

    /**
     * Check if the actual value's time and time zone properties are equal to the expected time and time zone properties.
     *
     * @param hourOfDay  the expected hour of day.
     * @param minute     the expected minute.
     * @param second     the expected second.
     * @param zoneOffset the expected zone offset.
     *
     * @return current object for the chain call.
     */
    public XMLGregorianCalendarAssertion hasTimeZoneTime(final int hourOfDay, final int minute, final int second, final int zoneOffset) {
        createCalendarAssertion().hasTimeZoneTime(hourOfDay, minute, second, zoneOffset);
        return this;
    }

    /**
     * Check if the actual value's time and time zone properties are equal to the expected time and time zone properties.
     *
     * @param hourOfDay   the expected hour of day.
     * @param minute      the expected minute.
     * @param second      the expected second.
     * @param millisecond the expected millisecond.
     * @param zoneOffset  the expected zone offset.
     *
     * @return current object for the chain call.
     */
    public XMLGregorianCalendarAssertion hasTimeZoneTime(final int hourOfDay, final int minute, final int second, final int millisecond, final int zoneOffset) {
        createCalendarAssertion().hasTimeZoneTime(hourOfDay, minute, second, millisecond, zoneOffset);
        return this;
    }

    /**
     * Check if the actual value's time properties are equal to the expected time properties in the UTC time zone.
     *
     * @param hourOfDay the expected hour of day.
     * @param minute    the expected minute.
     * @param second    the expected second.
     *
     * @return current object for the chain call.
     */
    public XMLGregorianCalendarAssertion hasUtcTime(final int hourOfDay, final int minute, final int second) {
        createCalendarAssertion().hasUtcTime(hourOfDay, minute, second);
        return this;
    }

    /**
     * Check if the actual value's time properties are equal to the expected time properties in the UTC time zone.
     *
     * @param hourOfDay   the expected hour of day.
     * @param minute      the expected minute.
     * @param second      the expected second.
     * @param millisecond the expected millisecond.
     *
     * @return current object for the chain call.
     */
    public XMLGregorianCalendarAssertion hasUtcTime(final int hourOfDay, final int minute, final int second, final int millisecond) {
        createCalendarAssertion().hasUtcTime(hourOfDay, minute, second, millisecond);
        return this;
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
     *
     * @return current object for the chain call.
     */
    public XMLGregorianCalendarAssertion hasDateAndTime(final int year, final int month, final int dayOfMonth, final int hourOfDay, final int minute, final int second) {
        createCalendarAssertion().hasDateAndTime(year, month, dayOfMonth, hourOfDay, minute, second);
        return this;
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
     *
     * @return current object for the chain call.
     */
    public XMLGregorianCalendarAssertion hasDateAndTime(final int year, final int month, final int dayOfMonth, final int hourOfDay, final int minute, final int second, final int millisecond) {
        createCalendarAssertion().hasDateAndTime(year, month, dayOfMonth, hourOfDay, minute, second, millisecond);
        return this;
    }

    /**
     * Check if the actual value's date, time and time zone properties are equal to the expected date, time and time zone properties.
     *
     * @param year       the expected year.
     * @param month      the expected month.
     * @param dayOfMonth the expected day of month.
     * @param hourOfDay  the expected hour of day.
     * @param minute     the expected minute.
     * @param second     the expected second.
     * @param zoneOffset the expected zone offset.
     *
     * @return current object for the chain call.
     */
    public XMLGregorianCalendarAssertion hasTimeZoneDateAndTime(final int year, final int month, final int dayOfMonth, final int hourOfDay, final int minute, final int second, final int zoneOffset) {
        createCalendarAssertion().hasTimeZoneDateAndTime(year, month, dayOfMonth, hourOfDay, minute, second, zoneOffset);
        return this;
    }

    /**
     * Check if the actual value's date, time and time zone properties are equal to the expected date, time and time zone properties.
     *
     * @param year        the expected year.
     * @param month       the expected month.
     * @param dayOfMonth  the expected day of month.
     * @param hourOfDay   the expected hour of day.
     * @param minute      the expected minute.
     * @param second      the expected second.
     * @param millisecond the expected millisecond.
     * @param zoneOffset  the expected zone offset.
     *
     * @return current object for the chain call.
     */
    public XMLGregorianCalendarAssertion hasTimeZoneDateAndTime(final int year, final int month, final int dayOfMonth, final int hourOfDay, final int minute, final int second, final int millisecond, final int zoneOffset) {
        createCalendarAssertion().hasTimeZoneDateAndTime(year, month, dayOfMonth, hourOfDay, minute, second, millisecond, zoneOffset);
        return this;
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
     *
     * @return current object for the chain call.
     */
    public XMLGregorianCalendarAssertion hasUtcDateAndTime(final int year, final int month, final int dayOfMonth, final int hourOfDay, final int minute, final int second) {
        createCalendarAssertion().hasUtcDateAndTime(year, month, dayOfMonth, hourOfDay, minute, second);
        return this;
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
     *
     * @return current object for the chain call.
     */
    public XMLGregorianCalendarAssertion hasUtcDateAndTime(final int year, final int month, final int dayOfMonth, final int hourOfDay, final int minute, final int second, final int millisecond) {
        createCalendarAssertion().hasUtcDateAndTime(year, month, dayOfMonth, hourOfDay, minute, second, millisecond);
        return this;
    }

    private CalendarAssertion createCalendarAssertion() {
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
    public CalendarAssertion toTimeZoneCalendar(final TimeZone timeZone) {
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
    public CalendarAssertion toTimeZoneCalendar(final String timeZoneId) {
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
    public CalendarAssertion toUtcTimeZoneCalendar() {
        return toTimeZoneCalendar(DataHelper.TIMEZONE_UTC);
    }

}
