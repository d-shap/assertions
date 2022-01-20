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

import org.hamcrest.Matcher;

import ru.d_shap.assertions.Messages;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.asimp.ReferenceAssertion;
import ru.d_shap.assertions.asimp.primitive.IntAssertion;

/**
 * Assertions for the calendar.
 *
 * @author Dmitry Shapovalov
 */
public class CalendarAssertion extends ReferenceAssertion<Calendar> {

    /**
     * Create new object.
     */
    public CalendarAssertion() {
        super();
    }

    @Override
    protected final Class<Calendar> getActualValueClass() {
        return Calendar.class;
    }

    /**
     * Check if the actual value is equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isEqualTo(final Calendar expected) {
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
    public final void isNotEqualTo(final Calendar expected) {
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
    public final void isGreaterThan(final Calendar expected) {
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
    public final void isGreaterThanOrEqualTo(final Calendar expected) {
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
    public final void isLessThan(final Calendar expected) {
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
    public final void isLessThanOrEqualTo(final Calendar expected) {
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
    public final void isInRange(final Calendar expectedFrom, final Calendar expectedTo) {
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
    public final void isNotInRange(final Calendar expectedFrom, final Calendar expectedTo) {
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
        checkActualIsNotNull();
        return initializeAssertion(Raw.intAssertion(), getActual().get(Calendar.YEAR), Messages.Check.YEAR);
    }

    /**
     * Make assertion about the actual value's year.
     *
     * @param matcher the hamcrest matcher.
     */
    public final void toYear(final Matcher<Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().get(Calendar.YEAR), matcher, Messages.Check.YEAR);
    }

    /**
     * Check if the actual value's year is equal to the expected year.
     *
     * @param expected the expected value.
     */
    public final void hasYear(final int expected) {
        toYear().isEqualTo(expected);
    }

    /**
     * Make assertion about the actual value's month.
     *
     * @return the assertion.
     */
    public final IntAssertion toMonth() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.intAssertion(), getActual().get(Calendar.MONTH), Messages.Check.MONTH);
    }

    /**
     * Make assertion about the actual value's month.
     *
     * @param matcher the hamcrest matcher.
     */
    public final void toMonth(final Matcher<Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().get(Calendar.MONTH), matcher, Messages.Check.MONTH);
    }

    /**
     * Check if the actual value's month is equal to the expected month.
     *
     * @param expected the expected value.
     */
    public final void hasMonth(final int expected) {
        toMonth().isEqualTo(expected);
    }

    /**
     * Make assertion about the actual value's week of year.
     *
     * @return the assertion.
     */
    public final IntAssertion toWeekOfYear() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.intAssertion(), getActual().get(Calendar.WEEK_OF_YEAR), Messages.Check.WEEK_OF_YEAR);
    }

    /**
     * Make assertion about the actual value's week of year.
     *
     * @param matcher the hamcrest matcher.
     */
    public final void toWeekOfYear(final Matcher<Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().get(Calendar.WEEK_OF_YEAR), matcher, Messages.Check.WEEK_OF_YEAR);
    }

    /**
     * Check if the actual value's week of year is equal to the expected week of year.
     *
     * @param expected the expected value.
     */
    public final void hasWeekOfYear(final int expected) {
        toWeekOfYear().isEqualTo(expected);
    }

    /**
     * Make assertion about the actual value's week of month.
     *
     * @return the assertion.
     */
    public final IntAssertion toWeekOfMonth() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.intAssertion(), getActual().get(Calendar.WEEK_OF_MONTH), Messages.Check.WEEK_OF_MONTH);
    }

    /**
     * Make assertion about the actual value's week of month.
     *
     * @param matcher the hamcrest matcher.
     */
    public final void toWeekOfMonth(final Matcher<Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().get(Calendar.WEEK_OF_MONTH), matcher, Messages.Check.WEEK_OF_MONTH);
    }

    /**
     * Check if the actual value's week of month is equal to the expected week of month.
     *
     * @param expected the expected value.
     */
    public final void hasWeekOfMonth(final int expected) {
        toWeekOfMonth().isEqualTo(expected);
    }

    /**
     * Make assertion about the actual value's day of year.
     *
     * @return the assertion.
     */
    public final IntAssertion toDayOfYear() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.intAssertion(), getActual().get(Calendar.DAY_OF_YEAR), Messages.Check.DAY_OF_YEAR);
    }

    /**
     * Make assertion about the actual value's day of year.
     *
     * @param matcher the hamcrest matcher.
     */
    public final void toDayOfYear(final Matcher<Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().get(Calendar.DAY_OF_YEAR), matcher, Messages.Check.DAY_OF_YEAR);
    }

    /**
     * Check if the actual value's day day of year is equal to the expected day of year.
     *
     * @param expected the expected value.
     */
    public final void hasDayOfYear(final int expected) {
        toDayOfYear().isEqualTo(expected);
    }

    /**
     * Make assertion about the actual value's day of month.
     *
     * @return the assertion.
     */
    public final IntAssertion toDayOfMonth() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.intAssertion(), getActual().get(Calendar.DAY_OF_MONTH), Messages.Check.DAY_OF_MONTH);
    }

    /**
     * Make assertion about the actual value's day of month.
     *
     * @param matcher the hamcrest matcher.
     */
    public final void toDayOfMonth(final Matcher<Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().get(Calendar.DAY_OF_MONTH), matcher, Messages.Check.DAY_OF_MONTH);
    }

    /**
     * Check if the actual value's day of month is equal to the expected day of month.
     *
     * @param expected the expected value.
     */
    public final void hasDayOfMonth(final int expected) {
        toDayOfMonth().isEqualTo(expected);
    }

    /**
     * Make assertion about the actual value's day of week in month.
     *
     * @return the assertion.
     */
    public final IntAssertion toDayOfWeekInMonth() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.intAssertion(), getActual().get(Calendar.DAY_OF_WEEK_IN_MONTH), Messages.Check.DAY_OF_WEEK_IN_MONTH);
    }

    /**
     * Make assertion about the actual value's day of week in month.
     *
     * @param matcher the hamcrest matcher.
     */
    public final void toDayOfWeekInMonth(final Matcher<Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().get(Calendar.DAY_OF_WEEK_IN_MONTH), matcher, Messages.Check.DAY_OF_WEEK_IN_MONTH);
    }

    /**
     * Check if the actual value's day of week in month is equal to the expected day of week in month.
     *
     * @param expected the expected value.
     */
    public final void hasDayOfWeekInMonth(final int expected) {
        toDayOfWeekInMonth().isEqualTo(expected);
    }

    /**
     * Make assertion about the actual value's day of week.
     *
     * @return the assertion.
     */
    public final IntAssertion toDayOfWeek() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.intAssertion(), getActual().get(Calendar.DAY_OF_WEEK), Messages.Check.DAY_OF_WEEK);
    }

    /**
     * Make assertion about the actual value's day of week.
     *
     * @param matcher the hamcrest matcher.
     */
    public final void toDayOfWeek(final Matcher<Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().get(Calendar.DAY_OF_WEEK), matcher, Messages.Check.DAY_OF_WEEK);
    }

    /**
     * Check if the actual value's day of week is equal to the expected day of week.
     *
     * @param expected the expected value.
     */
    public final void hasDayOfWeek(final int expected) {
        toDayOfWeek().isEqualTo(expected);
    }

    /**
     * Make assertion about the actual value's AM/PM.
     *
     * @return the assertion.
     */
    public final IntAssertion toAmPm() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.intAssertion(), getActual().get(Calendar.AM_PM), Messages.Check.AM_PM);
    }

    /**
     * Make assertion about the actual value's AM/PM.
     *
     * @param matcher the hamcrest matcher.
     */
    public final void toAmPm(final Matcher<Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().get(Calendar.AM_PM), matcher, Messages.Check.AM_PM);
    }

    /**
     * Check if the actual value's AM/PM is equal to AM.
     */
    public final void isAm() {
        toAmPm().isEqualTo(Calendar.AM);
    }

    /**
     * Check if the actual value's AM/PM is equal to PM.
     */
    public final void isPm() {
        toAmPm().isEqualTo(Calendar.PM);
    }

    /**
     * Make assertion about the actual value's hour of day.
     *
     * @return the assertion.
     */
    public final IntAssertion toHourOfDay() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.intAssertion(), getActual().get(Calendar.HOUR_OF_DAY), Messages.Check.HOUR_OF_DAY);
    }

    /**
     * Make assertion about the actual value's hour of day.
     *
     * @param matcher the hamcrest matcher.
     */
    public final void toHourOfDay(final Matcher<Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().get(Calendar.HOUR_OF_DAY), matcher, Messages.Check.HOUR_OF_DAY);
    }

    /**
     * Check if the actual value's hour of day is equal to the expected hour of day.
     *
     * @param expected the expected value.
     */
    public final void hasHourOfDay(final int expected) {
        toHourOfDay().isEqualTo(expected);
    }

    /**
     * Make assertion about the actual value's hour.
     *
     * @return the assertion.
     */
    public final IntAssertion toHour() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.intAssertion(), getActual().get(Calendar.HOUR), Messages.Check.HOUR);
    }

    /**
     * Make assertion about the actual value's hour.
     *
     * @param matcher the hamcrest matcher.
     */
    public final void toHour(final Matcher<Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().get(Calendar.HOUR), matcher, Messages.Check.HOUR);
    }

    /**
     * Check if the actual value's hour is equal to the expected hour.
     *
     * @param expected the expected value.
     */
    public final void hasHour(final int expected) {
        toHour().isEqualTo(expected);
    }

    /**
     * Make assertion about the actual value's minute.
     *
     * @return the assertion.
     */
    public final IntAssertion toMinute() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.intAssertion(), getActual().get(Calendar.MINUTE), Messages.Check.MINUTE);
    }

    /**
     * Make assertion about the actual value's minute.
     *
     * @param matcher the hamcrest matcher.
     */
    public final void toMinute(final Matcher<Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().get(Calendar.MINUTE), matcher, Messages.Check.MINUTE);
    }

    /**
     * Check if the actual value's minute is equal to the expected minute.
     *
     * @param expected the expected value.
     */
    public final void hasMinute(final int expected) {
        toMinute().isEqualTo(expected);
    }

    /**
     * Make assertion about the actual value's second.
     *
     * @return the assertion.
     */
    public final IntAssertion toSecond() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.intAssertion(), getActual().get(Calendar.SECOND), Messages.Check.SECOND);
    }

    /**
     * Make assertion about the actual value's second.
     *
     * @param matcher the hamcrest matcher.
     */
    public final void toSecond(final Matcher<Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().get(Calendar.SECOND), matcher, Messages.Check.SECOND);
    }

    /**
     * Check if the actual value's second is equal to the expected second.
     *
     * @param expected the expected value.
     */
    public final void hasSecond(final int expected) {
        toSecond().isEqualTo(expected);
    }

    /**
     * Make assertion about the actual value's millisecond.
     *
     * @return the assertion.
     */
    public final IntAssertion toMillisecond() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.intAssertion(), getActual().get(Calendar.MILLISECOND), Messages.Check.MILLISECOND);
    }

    /**
     * Make assertion about the actual value's millisecond.
     *
     * @param matcher the hamcrest matcher.
     */
    public final void toMillisecond(final Matcher<Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().get(Calendar.MILLISECOND), matcher, Messages.Check.MILLISECOND);
    }

    /**
     * Check if the actual value's millisecond is equal to the expected millisecond.
     *
     * @param expected the expected value.
     */
    public final void hasMillisecond(final int expected) {
        toMillisecond().isEqualTo(expected);
    }

}
