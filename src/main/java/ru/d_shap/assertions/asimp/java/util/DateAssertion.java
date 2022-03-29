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
package ru.d_shap.assertions.asimp.java.util;

import java.util.Calendar;
import java.util.Date;

import org.hamcrest.Matcher;

import ru.d_shap.assertions.Messages;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.asimp.ReferenceAssertion;
import ru.d_shap.assertions.asimp.primitive.IntAssertion;

/**
 * Assertions for the date.
 *
 * @author Dmitry Shapovalov
 */
public class DateAssertion extends ReferenceAssertion<Date> {

    /**
     * Create new object.
     */
    public DateAssertion() {
        super();
    }

    @Override
    protected final Class<Date> getActualValueClass() {
        return Date.class;
    }

    /**
     * Check if the actual value is equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isEqualTo(final Date expected) {
        if (expected == null) {
            isNull();
        } else {
            checkActualIsNotNull();
            if (!getActual().equals(expected)) {
                throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_SAME).addActual().addExpected(expected).build();
            }
        }
    }

    /**
     * Check if the actual value is NOT equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isNotEqualTo(final Date expected) {
        if (expected == null) {
            isNotNull();
        } else {
            if (getActual() != null && getActual().equals(expected)) {
                throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_DIFFERENT).addActual().build();
            }
        }
    }

    /**
     * Check if the actual value is greater than the expected value.
     *
     * @param expected the expected value.
     */
    public final void isGreaterThan(final Date expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        if (getActual().compareTo(expected) <= 0) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_GREATER).addActual().addExpected(expected).build();
        }
    }

    /**
     * Check if the actual value is greater than or equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isGreaterThanOrEqualTo(final Date expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        if (getActual().compareTo(expected) < 0) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_GREATER_OR_EQUAL).addActual().addExpected(expected).build();
        }
    }

    /**
     * Check if the actual value is less than the expected value.
     *
     * @param expected the expected value.
     */
    public final void isLessThan(final Date expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        if (getActual().compareTo(expected) >= 0) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_LESS).addActual().addExpected(expected).build();
        }
    }

    /**
     * Check if the actual value is less than or equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isLessThanOrEqualTo(final Date expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        if (getActual().compareTo(expected) > 0) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_LESS_OR_EQUAL).addActual().addExpected(expected).build();
        }
    }

    /**
     * Check if the actual value is in the expected range.
     *
     * @param expectedFrom the expected lower (inclusive) bound of the range.
     * @param expectedTo   the expected upper (exclusive) bound of the range.
     */
    public final void isInRange(final Date expectedFrom, final Date expectedTo) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expectedFrom, "expectedFrom");
        checkArgumentIsNotNull(expectedTo, "expectedTo");
        if (getActual().compareTo(expectedFrom) < 0 || getActual().compareTo(expectedTo) >= 0) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_IN_RANGE).addActual().addExpected(expectedFrom, expectedTo).build();
        }
    }

    /**
     * Check if the actual value is NOT in the expected range.
     *
     * @param expectedFrom the expected lower (inclusive) bound of the range.
     * @param expectedTo   the expected upper (exclusive) bound of the range.
     */
    public final void isNotInRange(final Date expectedFrom, final Date expectedTo) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expectedFrom, "expectedFrom");
        checkArgumentIsNotNull(expectedTo, "expectedTo");
        if (getActual().compareTo(expectedFrom) >= 0 && getActual().compareTo(expectedTo) < 0) {
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
    public final void toYear(final Matcher<? super Integer> matcher) {
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
    public final void toMonth(final Matcher<? super Integer> matcher) {
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
    public final void toWeekOfYear(final Matcher<? super Integer> matcher) {
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
    public final void toWeekOfMonth(final Matcher<? super Integer> matcher) {
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
    public final void toDayOfYear(final Matcher<? super Integer> matcher) {
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
    public final void toDayOfMonth(final Matcher<? super Integer> matcher) {
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
    public final void toDayOfWeekInMonth(final Matcher<? super Integer> matcher) {
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
    public final void toDayOfWeek(final Matcher<? super Integer> matcher) {
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
    public final void toAmPm(final Matcher<? super Integer> matcher) {
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
    public final void toHourOfDay(final Matcher<? super Integer> matcher) {
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
    public final void toHour(final Matcher<? super Integer> matcher) {
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
    public final void toMinute(final Matcher<? super Integer> matcher) {
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
    public final void toSecond(final Matcher<? super Integer> matcher) {
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
    public final void toMillisecond(final Matcher<? super Integer> matcher) {
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
        createCalendarAssertion().hasTime(hourOfDay, minute, second, millisecond);
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

    private CalendarAssertion createCalendarAssertion() {
        checkActualIsNotNull();
        Calendar calendar = convertValue(getActual(), null, Calendar.class);
        return initializeAssertion(Raw.calendarAssertion(), calendar);
    }

}
