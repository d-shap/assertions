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
import java.util.TimeZone;

import org.hamcrest.Matcher;

import ru.d_shap.assertions.Messages;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.asimp.ReferenceAssertion;
import ru.d_shap.assertions.asimp.primitive.IntAssertion;
import ru.d_shap.assertions.util.DataHelper;

/**
 * Assertions for the calendar.
 *
 * @author Dmitry Shapovalov
 */
public final class CalendarAssertion extends ReferenceAssertion<CalendarAssertion, Calendar> {

    /**
     * Create new object.
     */
    public CalendarAssertion() {
        super();
    }

    @Override
    protected Class<Calendar> getActualValueClass() {
        return Calendar.class;
    }

    /**
     * Check if the actual value is equal to the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public CalendarAssertion isEqualTo(final Calendar expected) {
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
    public CalendarAssertion isNotEqualTo(final Calendar expected) {
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
    public CalendarAssertion isGreaterThan(final Calendar expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        if (getActual().compareTo(expected) <= 0) {
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
    public CalendarAssertion isGreaterThanOrEqualTo(final Calendar expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        if (getActual().compareTo(expected) < 0) {
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
    public CalendarAssertion isLessThan(final Calendar expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        if (getActual().compareTo(expected) >= 0) {
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
    public CalendarAssertion isLessThanOrEqualTo(final Calendar expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        if (getActual().compareTo(expected) > 0) {
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
    public CalendarAssertion isInRange(final Calendar expectedFrom, final Calendar expectedTo) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expectedFrom, "expectedFrom");
        checkArgumentIsNotNull(expectedTo, "expectedTo");
        if (getActual().compareTo(expectedFrom) < 0 || getActual().compareTo(expectedTo) >= 0) {
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
    public CalendarAssertion isNotInRange(final Calendar expectedFrom, final Calendar expectedTo) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expectedFrom, "expectedFrom");
        checkArgumentIsNotNull(expectedTo, "expectedTo");
        if (getActual().compareTo(expectedFrom) >= 0 && getActual().compareTo(expectedTo) < 0) {
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
        checkActualIsNotNull();
        return initializeAssertion(Raw.intAssertion(), getActual().get(Calendar.YEAR), Messages.Check.YEAR);
    }

    /**
     * Make assertion about the actual value's year.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public CalendarAssertion toYear(final Matcher<? super Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().get(Calendar.YEAR), matcher, Messages.Check.YEAR);
        return this;
    }

    /**
     * Check if the actual value's year is equal to the expected year.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public CalendarAssertion hasYear(final int expected) {
        toYear().isEqualTo(expected);
        return this;
    }

    /**
     * Make assertion about the actual value's month.
     *
     * @return the assertion.
     */
    public IntAssertion toMonth() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.intAssertion(), getActual().get(Calendar.MONTH), Messages.Check.MONTH);
    }

    /**
     * Make assertion about the actual value's month.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public CalendarAssertion toMonth(final Matcher<? super Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().get(Calendar.MONTH), matcher, Messages.Check.MONTH);
        return this;
    }

    /**
     * Check if the actual value's month is equal to the expected month.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public CalendarAssertion hasMonth(final int expected) {
        toMonth().isEqualTo(expected);
        return this;
    }

    /**
     * Make assertion about the actual value's week of year.
     *
     * @return the assertion.
     */
    public IntAssertion toWeekOfYear() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.intAssertion(), getActual().get(Calendar.WEEK_OF_YEAR), Messages.Check.WEEK_OF_YEAR);
    }

    /**
     * Make assertion about the actual value's week of year.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public CalendarAssertion toWeekOfYear(final Matcher<? super Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().get(Calendar.WEEK_OF_YEAR), matcher, Messages.Check.WEEK_OF_YEAR);
        return this;
    }

    /**
     * Check if the actual value's week of year is equal to the expected week of year.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public CalendarAssertion hasWeekOfYear(final int expected) {
        toWeekOfYear().isEqualTo(expected);
        return this;
    }

    /**
     * Make assertion about the actual value's week of month.
     *
     * @return the assertion.
     */
    public IntAssertion toWeekOfMonth() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.intAssertion(), getActual().get(Calendar.WEEK_OF_MONTH), Messages.Check.WEEK_OF_MONTH);
    }

    /**
     * Make assertion about the actual value's week of month.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public CalendarAssertion toWeekOfMonth(final Matcher<? super Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().get(Calendar.WEEK_OF_MONTH), matcher, Messages.Check.WEEK_OF_MONTH);
        return this;
    }

    /**
     * Check if the actual value's week of month is equal to the expected week of month.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public CalendarAssertion hasWeekOfMonth(final int expected) {
        toWeekOfMonth().isEqualTo(expected);
        return this;
    }

    /**
     * Make assertion about the actual value's day of year.
     *
     * @return the assertion.
     */
    public IntAssertion toDayOfYear() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.intAssertion(), getActual().get(Calendar.DAY_OF_YEAR), Messages.Check.DAY_OF_YEAR);
    }

    /**
     * Make assertion about the actual value's day of year.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public CalendarAssertion toDayOfYear(final Matcher<? super Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().get(Calendar.DAY_OF_YEAR), matcher, Messages.Check.DAY_OF_YEAR);
        return this;
    }

    /**
     * Check if the actual value's day day of year is equal to the expected day of year.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public CalendarAssertion hasDayOfYear(final int expected) {
        toDayOfYear().isEqualTo(expected);
        return this;
    }

    /**
     * Make assertion about the actual value's day of month.
     *
     * @return the assertion.
     */
    public IntAssertion toDayOfMonth() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.intAssertion(), getActual().get(Calendar.DAY_OF_MONTH), Messages.Check.DAY_OF_MONTH);
    }

    /**
     * Make assertion about the actual value's day of month.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public CalendarAssertion toDayOfMonth(final Matcher<? super Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().get(Calendar.DAY_OF_MONTH), matcher, Messages.Check.DAY_OF_MONTH);
        return this;
    }

    /**
     * Check if the actual value's day of month is equal to the expected day of month.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public CalendarAssertion hasDayOfMonth(final int expected) {
        toDayOfMonth().isEqualTo(expected);
        return this;
    }

    /**
     * Make assertion about the actual value's day of week in month.
     *
     * @return the assertion.
     */
    public IntAssertion toDayOfWeekInMonth() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.intAssertion(), getActual().get(Calendar.DAY_OF_WEEK_IN_MONTH), Messages.Check.DAY_OF_WEEK_IN_MONTH);
    }

    /**
     * Make assertion about the actual value's day of week in month.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public CalendarAssertion toDayOfWeekInMonth(final Matcher<? super Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().get(Calendar.DAY_OF_WEEK_IN_MONTH), matcher, Messages.Check.DAY_OF_WEEK_IN_MONTH);
        return this;
    }

    /**
     * Check if the actual value's day of week in month is equal to the expected day of week in month.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public CalendarAssertion hasDayOfWeekInMonth(final int expected) {
        toDayOfWeekInMonth().isEqualTo(expected);
        return this;
    }

    /**
     * Make assertion about the actual value's day of week.
     *
     * @return the assertion.
     */
    public IntAssertion toDayOfWeek() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.intAssertion(), getActual().get(Calendar.DAY_OF_WEEK), Messages.Check.DAY_OF_WEEK);
    }

    /**
     * Make assertion about the actual value's day of week.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public CalendarAssertion toDayOfWeek(final Matcher<? super Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().get(Calendar.DAY_OF_WEEK), matcher, Messages.Check.DAY_OF_WEEK);
        return this;
    }

    /**
     * Check if the actual value's day of week is equal to the expected day of week.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public CalendarAssertion hasDayOfWeek(final int expected) {
        toDayOfWeek().isEqualTo(expected);
        return this;
    }

    /**
     * Make assertion about the actual value's AM/PM.
     *
     * @return the assertion.
     */
    public IntAssertion toAmPm() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.intAssertion(), getActual().get(Calendar.AM_PM), Messages.Check.AM_PM);
    }

    /**
     * Make assertion about the actual value's AM/PM.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public CalendarAssertion toAmPm(final Matcher<? super Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().get(Calendar.AM_PM), matcher, Messages.Check.AM_PM);
        return this;
    }

    /**
     * Check if the actual value's AM/PM is equal to AM.
     *
     * @return current object for the chain call.
     */
    public CalendarAssertion isAm() {
        toAmPm().isEqualTo(Calendar.AM);
        return this;
    }

    /**
     * Check if the actual value's AM/PM is equal to PM.
     *
     * @return current object for the chain call.
     */
    public CalendarAssertion isPm() {
        toAmPm().isEqualTo(Calendar.PM);
        return this;
    }

    /**
     * Make assertion about the actual value's hour of day.
     *
     * @return the assertion.
     */
    public IntAssertion toHourOfDay() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.intAssertion(), getActual().get(Calendar.HOUR_OF_DAY), Messages.Check.HOUR_OF_DAY);
    }

    /**
     * Make assertion about the actual value's hour of day.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public CalendarAssertion toHourOfDay(final Matcher<? super Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().get(Calendar.HOUR_OF_DAY), matcher, Messages.Check.HOUR_OF_DAY);
        return this;
    }

    /**
     * Check if the actual value's hour of day is equal to the expected hour of day.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public CalendarAssertion hasHourOfDay(final int expected) {
        toHourOfDay().isEqualTo(expected);
        return this;
    }

    /**
     * Make assertion about the actual value's hour.
     *
     * @return the assertion.
     */
    public IntAssertion toHour() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.intAssertion(), getActual().get(Calendar.HOUR), Messages.Check.HOUR);
    }

    /**
     * Make assertion about the actual value's hour.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public CalendarAssertion toHour(final Matcher<? super Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().get(Calendar.HOUR), matcher, Messages.Check.HOUR);
        return this;
    }

    /**
     * Check if the actual value's hour is equal to the expected hour.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public CalendarAssertion hasHour(final int expected) {
        toHour().isEqualTo(expected);
        return this;
    }

    /**
     * Make assertion about the actual value's minute.
     *
     * @return the assertion.
     */
    public IntAssertion toMinute() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.intAssertion(), getActual().get(Calendar.MINUTE), Messages.Check.MINUTE);
    }

    /**
     * Make assertion about the actual value's minute.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public CalendarAssertion toMinute(final Matcher<? super Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().get(Calendar.MINUTE), matcher, Messages.Check.MINUTE);
        return this;
    }

    /**
     * Check if the actual value's minute is equal to the expected minute.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public CalendarAssertion hasMinute(final int expected) {
        toMinute().isEqualTo(expected);
        return this;
    }

    /**
     * Make assertion about the actual value's second.
     *
     * @return the assertion.
     */
    public IntAssertion toSecond() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.intAssertion(), getActual().get(Calendar.SECOND), Messages.Check.SECOND);
    }

    /**
     * Make assertion about the actual value's second.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public CalendarAssertion toSecond(final Matcher<? super Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().get(Calendar.SECOND), matcher, Messages.Check.SECOND);
        return this;
    }

    /**
     * Check if the actual value's second is equal to the expected second.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public CalendarAssertion hasSecond(final int expected) {
        toSecond().isEqualTo(expected);
        return this;
    }

    /**
     * Make assertion about the actual value's millisecond.
     *
     * @return the assertion.
     */
    public IntAssertion toMillisecond() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.intAssertion(), getActual().get(Calendar.MILLISECOND), Messages.Check.MILLISECOND);
    }

    /**
     * Make assertion about the actual value's millisecond.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public CalendarAssertion toMillisecond(final Matcher<? super Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().get(Calendar.MILLISECOND), matcher, Messages.Check.MILLISECOND);
        return this;
    }

    /**
     * Check if the actual value's millisecond is equal to the expected millisecond.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public CalendarAssertion hasMillisecond(final int expected) {
        toMillisecond().isEqualTo(expected);
        return this;
    }

    /**
     * Make assertion about the actual value's zone offset.
     *
     * @return the assertion.
     */
    public IntAssertion toZoneOffset() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.intAssertion(), getActual().get(Calendar.ZONE_OFFSET), Messages.Check.ZONE_OFFSET);
    }

    /**
     * Make assertion about the actual value's zone offset.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public CalendarAssertion toZoneOffset(final Matcher<? super Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().get(Calendar.ZONE_OFFSET), matcher, Messages.Check.ZONE_OFFSET);
        return this;
    }

    /**
     * Check if the actual value's zone offset is equal to the expected zone offset.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public CalendarAssertion hasZoneOffset(final int expected) {
        toZoneOffset().isEqualTo(expected);
        return this;
    }

    /**
     * Make assertion about the actual value's DST offset.
     *
     * @return the assertion.
     */
    public IntAssertion toDstOffset() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.intAssertion(), getActual().get(Calendar.DST_OFFSET), Messages.Check.DST_OFFSET);
    }

    /**
     * Make assertion about the actual value's DST offset.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public CalendarAssertion toDstOffset(final Matcher<? super Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().get(Calendar.DST_OFFSET), matcher, Messages.Check.DST_OFFSET);
        return this;
    }

    /**
     * Check if the actual value's DST offset is equal to the expected DST offset.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public CalendarAssertion hasDstOffset(final int expected) {
        toDstOffset().isEqualTo(expected);
        return this;
    }

    /**
     * Make assertion about the actual value's time zone.
     *
     * @return the assertion.
     */
    public TimeZoneAssertion toTimeZone() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.timeZoneAssertion(), getActual().getTimeZone(), Messages.Check.TIME_ZONE);
    }

    /**
     * Make assertion about the actual value's time zone.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public CalendarAssertion toTimeZone(final Matcher<? super TimeZone> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().getTimeZone(), matcher, Messages.Check.TIME_ZONE);
        return this;
    }

    /**
     * Check if the actual value's time zone is equal to the expected time zone.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public CalendarAssertion hasTimeZone(final TimeZone expected) {
        toTimeZone().isEqualTo(expected);
        return this;
    }

    /**
     * Check if the actual value's time zone ID is equal to the expected time zone ID.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public CalendarAssertion hasTimeZoneId(final String expected) {
        toTimeZone().hasId(expected);
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
    public CalendarAssertion hasDate(final int year, final int month, final int dayOfMonth) {
        hasYear(year);
        hasMonth(month);
        hasDayOfMonth(dayOfMonth);
        return this;
    }

    /**
     * Check if the actual value's date and time zone properties are equal to the expected date and time zone properties.
     *
     * @param year       the expected year.
     * @param month      the expected month.
     * @param dayOfMonth the expected day of month.
     * @param timeZoneId the expected time zone ID.
     *
     * @return current object for the chain call.
     */
    public CalendarAssertion hasTimeZoneDate(final int year, final int month, final int dayOfMonth, final String timeZoneId) {
        hasYear(year);
        hasMonth(month);
        hasDayOfMonth(dayOfMonth);
        hasTimeZoneId(timeZoneId);
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
    public CalendarAssertion hasTimeZoneDate(final int year, final int month, final int dayOfMonth, final int zoneOffset) {
        hasYear(year);
        hasMonth(month);
        hasDayOfMonth(dayOfMonth);
        hasZoneOffset(zoneOffset);
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
    public CalendarAssertion hasUtcDate(final int year, final int month, final int dayOfMonth) {
        toUtcTimeZoneCalendar().hasDate(year, month, dayOfMonth);
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
    public CalendarAssertion hasTime(final int hourOfDay, final int minute, final int second) {
        hasHourOfDay(hourOfDay);
        hasMinute(minute);
        hasSecond(second);
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
    public CalendarAssertion hasTime(final int hourOfDay, final int minute, final int second, final int millisecond) {
        hasHourOfDay(hourOfDay);
        hasMinute(minute);
        hasSecond(second);
        hasMillisecond(millisecond);
        return this;
    }

    /**
     * Check if the actual value's time and time zone properties are equal to the expected time and time zone properties.
     *
     * @param hourOfDay  the expected hour of day.
     * @param minute     the expected minute.
     * @param second     the expected second.
     * @param timeZoneId the expected time zone ID.
     *
     * @return current object for the chain call.
     */
    public CalendarAssertion hasTimeZoneTime(final int hourOfDay, final int minute, final int second, final String timeZoneId) {
        hasHourOfDay(hourOfDay);
        hasMinute(minute);
        hasSecond(second);
        hasTimeZoneId(timeZoneId);
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
    public CalendarAssertion hasTimeZoneTime(final int hourOfDay, final int minute, final int second, final int zoneOffset) {
        hasHourOfDay(hourOfDay);
        hasMinute(minute);
        hasSecond(second);
        hasZoneOffset(zoneOffset);
        return this;
    }

    /**
     * Check if the actual value's time and time zone properties are equal to the expected time and time zone properties.
     *
     * @param hourOfDay   the expected hour of day.
     * @param minute      the expected minute.
     * @param second      the expected second.
     * @param millisecond the expected millisecond.
     * @param timeZoneId  the expected time zone ID.
     *
     * @return current object for the chain call.
     */
    public CalendarAssertion hasTimeZoneTime(final int hourOfDay, final int minute, final int second, final int millisecond, final String timeZoneId) {
        hasHourOfDay(hourOfDay);
        hasMinute(minute);
        hasSecond(second);
        hasMillisecond(millisecond);
        hasTimeZoneId(timeZoneId);
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
    public CalendarAssertion hasTimeZoneTime(final int hourOfDay, final int minute, final int second, final int millisecond, final int zoneOffset) {
        hasHourOfDay(hourOfDay);
        hasMinute(minute);
        hasSecond(second);
        hasMillisecond(millisecond);
        hasZoneOffset(zoneOffset);
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
    public CalendarAssertion hasUtcTime(final int hourOfDay, final int minute, final int second) {
        toUtcTimeZoneCalendar().hasTime(hourOfDay, minute, second);
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
    public CalendarAssertion hasUtcTime(final int hourOfDay, final int minute, final int second, final int millisecond) {
        toUtcTimeZoneCalendar().hasTime(hourOfDay, minute, second, millisecond);
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
    public CalendarAssertion hasDateAndTime(final int year, final int month, final int dayOfMonth, final int hourOfDay, final int minute, final int second) {
        hasYear(year);
        hasMonth(month);
        hasDayOfMonth(dayOfMonth);
        hasHourOfDay(hourOfDay);
        hasMinute(minute);
        hasSecond(second);
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
    public CalendarAssertion hasDateAndTime(final int year, final int month, final int dayOfMonth, final int hourOfDay, final int minute, final int second, final int millisecond) {
        hasYear(year);
        hasMonth(month);
        hasDayOfMonth(dayOfMonth);
        hasHourOfDay(hourOfDay);
        hasMinute(minute);
        hasSecond(second);
        hasMillisecond(millisecond);
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
     * @param timeZoneId the expected time zone ID.
     *
     * @return current object for the chain call.
     */
    public CalendarAssertion hasTimeZoneDateAndTime(final int year, final int month, final int dayOfMonth, final int hourOfDay, final int minute, final int second, final String timeZoneId) {
        hasYear(year);
        hasMonth(month);
        hasDayOfMonth(dayOfMonth);
        hasHourOfDay(hourOfDay);
        hasMinute(minute);
        hasSecond(second);
        hasTimeZoneId(timeZoneId);
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
    public CalendarAssertion hasTimeZoneDateAndTime(final int year, final int month, final int dayOfMonth, final int hourOfDay, final int minute, final int second, final int zoneOffset) {
        hasYear(year);
        hasMonth(month);
        hasDayOfMonth(dayOfMonth);
        hasHourOfDay(hourOfDay);
        hasMinute(minute);
        hasSecond(second);
        hasZoneOffset(zoneOffset);
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
     * @param timeZoneId  the expected time zone ID.
     *
     * @return current object for the chain call.
     */
    public CalendarAssertion hasTimeZoneDateAndTime(final int year, final int month, final int dayOfMonth, final int hourOfDay, final int minute, final int second, final int millisecond, final String timeZoneId) {
        hasYear(year);
        hasMonth(month);
        hasDayOfMonth(dayOfMonth);
        hasHourOfDay(hourOfDay);
        hasMinute(minute);
        hasSecond(second);
        hasMillisecond(millisecond);
        hasTimeZoneId(timeZoneId);
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
    public CalendarAssertion hasTimeZoneDateAndTime(final int year, final int month, final int dayOfMonth, final int hourOfDay, final int minute, final int second, final int millisecond, final int zoneOffset) {
        hasYear(year);
        hasMonth(month);
        hasDayOfMonth(dayOfMonth);
        hasHourOfDay(hourOfDay);
        hasMinute(minute);
        hasSecond(second);
        hasMillisecond(millisecond);
        hasZoneOffset(zoneOffset);
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
    public CalendarAssertion hasUtcDateAndTime(final int year, final int month, final int dayOfMonth, final int hourOfDay, final int minute, final int second) {
        toUtcTimeZoneCalendar().hasDateAndTime(year, month, dayOfMonth, hourOfDay, minute, second);
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
    public CalendarAssertion hasUtcDateAndTime(final int year, final int month, final int dayOfMonth, final int hourOfDay, final int minute, final int second, final int millisecond) {
        toUtcTimeZoneCalendar().hasDateAndTime(year, month, dayOfMonth, hourOfDay, minute, second, millisecond);
        return this;
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
        Calendar calendar = getActual();
        Calendar newCalendar = Calendar.getInstance();
        newCalendar.setTimeZone(timeZone);
        newCalendar.setTime(calendar.getTime());
        return initializeAssertion(Raw.calendarAssertion(), newCalendar, Messages.Check.TIME_ZONE_DATE, timeZone);
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
