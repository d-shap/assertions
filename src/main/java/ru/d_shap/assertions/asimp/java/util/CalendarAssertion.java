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
public final class CalendarAssertion extends ReferenceAssertion<Calendar> {

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
     */
    public void isEqualTo(final Calendar expected) {
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
    public void isNotEqualTo(final Calendar expected) {
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
    public void isGreaterThan(final Calendar expected) {
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
    public void isGreaterThanOrEqualTo(final Calendar expected) {
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
    public void isLessThan(final Calendar expected) {
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
    public void isLessThanOrEqualTo(final Calendar expected) {
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
    public void isInRange(final Calendar expectedFrom, final Calendar expectedTo) {
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
    public void isNotInRange(final Calendar expectedFrom, final Calendar expectedTo) {
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
    public IntAssertion toYear() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.intAssertion(), getActual().get(Calendar.YEAR), Messages.Check.YEAR);
    }

    /**
     * Make assertion about the actual value's year.
     *
     * @param matcher the hamcrest matcher.
     */
    public void toYear(final Matcher<? super Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().get(Calendar.YEAR), matcher, Messages.Check.YEAR);
    }

    /**
     * Check if the actual value's year is equal to the expected year.
     *
     * @param expected the expected value.
     */
    public void hasYear(final int expected) {
        toYear().isEqualTo(expected);
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
     */
    public void toMonth(final Matcher<? super Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().get(Calendar.MONTH), matcher, Messages.Check.MONTH);
    }

    /**
     * Check if the actual value's month is equal to the expected month.
     *
     * @param expected the expected value.
     */
    public void hasMonth(final int expected) {
        toMonth().isEqualTo(expected);
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
     */
    public void toWeekOfYear(final Matcher<? super Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().get(Calendar.WEEK_OF_YEAR), matcher, Messages.Check.WEEK_OF_YEAR);
    }

    /**
     * Check if the actual value's week of year is equal to the expected week of year.
     *
     * @param expected the expected value.
     */
    public void hasWeekOfYear(final int expected) {
        toWeekOfYear().isEqualTo(expected);
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
     */
    public void toWeekOfMonth(final Matcher<? super Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().get(Calendar.WEEK_OF_MONTH), matcher, Messages.Check.WEEK_OF_MONTH);
    }

    /**
     * Check if the actual value's week of month is equal to the expected week of month.
     *
     * @param expected the expected value.
     */
    public void hasWeekOfMonth(final int expected) {
        toWeekOfMonth().isEqualTo(expected);
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
     */
    public void toDayOfYear(final Matcher<? super Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().get(Calendar.DAY_OF_YEAR), matcher, Messages.Check.DAY_OF_YEAR);
    }

    /**
     * Check if the actual value's day day of year is equal to the expected day of year.
     *
     * @param expected the expected value.
     */
    public void hasDayOfYear(final int expected) {
        toDayOfYear().isEqualTo(expected);
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
     */
    public void toDayOfMonth(final Matcher<? super Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().get(Calendar.DAY_OF_MONTH), matcher, Messages.Check.DAY_OF_MONTH);
    }

    /**
     * Check if the actual value's day of month is equal to the expected day of month.
     *
     * @param expected the expected value.
     */
    public void hasDayOfMonth(final int expected) {
        toDayOfMonth().isEqualTo(expected);
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
     */
    public void toDayOfWeekInMonth(final Matcher<? super Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().get(Calendar.DAY_OF_WEEK_IN_MONTH), matcher, Messages.Check.DAY_OF_WEEK_IN_MONTH);
    }

    /**
     * Check if the actual value's day of week in month is equal to the expected day of week in month.
     *
     * @param expected the expected value.
     */
    public void hasDayOfWeekInMonth(final int expected) {
        toDayOfWeekInMonth().isEqualTo(expected);
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
     */
    public void toDayOfWeek(final Matcher<? super Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().get(Calendar.DAY_OF_WEEK), matcher, Messages.Check.DAY_OF_WEEK);
    }

    /**
     * Check if the actual value's day of week is equal to the expected day of week.
     *
     * @param expected the expected value.
     */
    public void hasDayOfWeek(final int expected) {
        toDayOfWeek().isEqualTo(expected);
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
     */
    public void toAmPm(final Matcher<? super Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().get(Calendar.AM_PM), matcher, Messages.Check.AM_PM);
    }

    /**
     * Check if the actual value's AM/PM is equal to AM.
     */
    public void isAm() {
        toAmPm().isEqualTo(Calendar.AM);
    }

    /**
     * Check if the actual value's AM/PM is equal to PM.
     */
    public void isPm() {
        toAmPm().isEqualTo(Calendar.PM);
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
     */
    public void toHourOfDay(final Matcher<? super Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().get(Calendar.HOUR_OF_DAY), matcher, Messages.Check.HOUR_OF_DAY);
    }

    /**
     * Check if the actual value's hour of day is equal to the expected hour of day.
     *
     * @param expected the expected value.
     */
    public void hasHourOfDay(final int expected) {
        toHourOfDay().isEqualTo(expected);
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
     */
    public void toHour(final Matcher<? super Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().get(Calendar.HOUR), matcher, Messages.Check.HOUR);
    }

    /**
     * Check if the actual value's hour is equal to the expected hour.
     *
     * @param expected the expected value.
     */
    public void hasHour(final int expected) {
        toHour().isEqualTo(expected);
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
     */
    public void toMinute(final Matcher<? super Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().get(Calendar.MINUTE), matcher, Messages.Check.MINUTE);
    }

    /**
     * Check if the actual value's minute is equal to the expected minute.
     *
     * @param expected the expected value.
     */
    public void hasMinute(final int expected) {
        toMinute().isEqualTo(expected);
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
     */
    public void toSecond(final Matcher<? super Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().get(Calendar.SECOND), matcher, Messages.Check.SECOND);
    }

    /**
     * Check if the actual value's second is equal to the expected second.
     *
     * @param expected the expected value.
     */
    public void hasSecond(final int expected) {
        toSecond().isEqualTo(expected);
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
     */
    public void toMillisecond(final Matcher<? super Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().get(Calendar.MILLISECOND), matcher, Messages.Check.MILLISECOND);
    }

    /**
     * Check if the actual value's millisecond is equal to the expected millisecond.
     *
     * @param expected the expected value.
     */
    public void hasMillisecond(final int expected) {
        toMillisecond().isEqualTo(expected);
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
     */
    public void toZoneOffset(final Matcher<? super Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().get(Calendar.ZONE_OFFSET), matcher, Messages.Check.ZONE_OFFSET);
    }

    /**
     * Check if the actual value's zone offset is equal to the expected zone offset.
     *
     * @param expected the expected value.
     */
    public void hasZoneOffset(final int expected) {
        toZoneOffset().isEqualTo(expected);
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
     */
    public void toDstOffset(final Matcher<? super Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().get(Calendar.DST_OFFSET), matcher, Messages.Check.DST_OFFSET);
    }

    /**
     * Check if the actual value's DST offset is equal to the expected DST offset.
     *
     * @param expected the expected value.
     */
    public void hasDstOffset(final int expected) {
        toDstOffset().isEqualTo(expected);
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
     */
    public void toTimeZone(final Matcher<? super TimeZone> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().getTimeZone(), matcher, Messages.Check.TIME_ZONE);
    }

    /**
     * Check if the actual value's time zone is equal to the expected time zone.
     *
     * @param expected the expected value.
     */
    public void hasTimeZone(final TimeZone expected) {
        toTimeZone().isEqualTo(expected);
    }

    /**
     * Check if the actual value's time zone ID is equal to the expected time zone ID.
     *
     * @param expected the expected value.
     */
    public void hasTimeZoneId(final String expected) {
        toTimeZone().hasId(expected);
    }

    /**
     * Check if the actual value's date properties are equal to the expected date properties.
     *
     * @param year       the expected year.
     * @param month      the expected month.
     * @param dayOfMonth the expected day of month.
     */
    public void hasDate(final int year, final int month, final int dayOfMonth) {
        hasYear(year);
        hasMonth(month);
        hasDayOfMonth(dayOfMonth);
    }

    /**
     * Check if the actual value's date and time zone properties are equal to the expected date and time zone properties.
     *
     * @param year       the expected year.
     * @param month      the expected month.
     * @param dayOfMonth the expected day of month.
     * @param timeZoneId the expected time zone ID.
     */
    public void hasTimeZoneDate(final int year, final int month, final int dayOfMonth, final String timeZoneId) {
        hasYear(year);
        hasMonth(month);
        hasDayOfMonth(dayOfMonth);
        hasTimeZoneId(timeZoneId);
    }

    /**
     * Check if the actual value's date and time zone properties are equal to the expected date and time zone properties.
     *
     * @param year       the expected year.
     * @param month      the expected month.
     * @param dayOfMonth the expected day of month.
     * @param zoneOffset the expected zone offset.
     */
    public void hasTimeZoneDate(final int year, final int month, final int dayOfMonth, final int zoneOffset) {
        hasYear(year);
        hasMonth(month);
        hasDayOfMonth(dayOfMonth);
        hasZoneOffset(zoneOffset);
    }

    /**
     * Check if the actual value's date properties are equal to the expected date properties in the UTC time zone.
     *
     * @param year       the expected year.
     * @param month      the expected month.
     * @param dayOfMonth the expected day of month.
     */
    public void hasUtcDate(final int year, final int month, final int dayOfMonth) {
        toUtcTimeZoneCalendar().hasDate(year, month, dayOfMonth);
    }

    /**
     * Check if the actual value's time properties are equal to the expected time properties.
     *
     * @param hourOfDay the expected hour of day.
     * @param minute    the expected minute.
     * @param second    the expected second.
     */
    public void hasTime(final int hourOfDay, final int minute, final int second) {
        hasHourOfDay(hourOfDay);
        hasMinute(minute);
        hasSecond(second);
    }

    /**
     * Check if the actual value's time properties are equal to the expected time properties.
     *
     * @param hourOfDay   the expected hour of day.
     * @param minute      the expected minute.
     * @param second      the expected second.
     * @param millisecond the expected millisecond.
     */
    public void hasTime(final int hourOfDay, final int minute, final int second, final int millisecond) {
        hasHourOfDay(hourOfDay);
        hasMinute(minute);
        hasSecond(second);
        hasMillisecond(millisecond);
    }

    /**
     * Check if the actual value's time and time zone properties are equal to the expected time and time zone properties.
     *
     * @param hourOfDay  the expected hour of day.
     * @param minute     the expected minute.
     * @param second     the expected second.
     * @param timeZoneId the expected time zone ID.
     */
    public void hasTimeZoneTime(final int hourOfDay, final int minute, final int second, final String timeZoneId) {
        hasHourOfDay(hourOfDay);
        hasMinute(minute);
        hasSecond(second);
        hasTimeZoneId(timeZoneId);
    }

    /**
     * Check if the actual value's time and time zone properties are equal to the expected time and time zone properties.
     *
     * @param hourOfDay  the expected hour of day.
     * @param minute     the expected minute.
     * @param second     the expected second.
     * @param zoneOffset the expected zone offset.
     */
    public void hasTimeZoneTime(final int hourOfDay, final int minute, final int second, final int zoneOffset) {
        hasHourOfDay(hourOfDay);
        hasMinute(minute);
        hasSecond(second);
        hasZoneOffset(zoneOffset);
    }

    /**
     * Check if the actual value's time and time zone properties are equal to the expected time and time zone properties.
     *
     * @param hourOfDay   the expected hour of day.
     * @param minute      the expected minute.
     * @param second      the expected second.
     * @param millisecond the expected millisecond.
     * @param timeZoneId  the expected time zone ID.
     */
    public void hasTimeZoneTime(final int hourOfDay, final int minute, final int second, final int millisecond, final String timeZoneId) {
        hasHourOfDay(hourOfDay);
        hasMinute(minute);
        hasSecond(second);
        hasMillisecond(millisecond);
        hasTimeZoneId(timeZoneId);
    }

    /**
     * Check if the actual value's time and time zone properties are equal to the expected time and time zone properties.
     *
     * @param hourOfDay   the expected hour of day.
     * @param minute      the expected minute.
     * @param second      the expected second.
     * @param millisecond the expected millisecond.
     * @param zoneOffset  the expected zone offset.
     */
    public void hasTimeZoneTime(final int hourOfDay, final int minute, final int second, final int millisecond, final int zoneOffset) {
        hasHourOfDay(hourOfDay);
        hasMinute(minute);
        hasSecond(second);
        hasMillisecond(millisecond);
        hasZoneOffset(zoneOffset);
    }

    /**
     * Check if the actual value's time properties are equal to the expected time properties in the UTC time zone.
     *
     * @param hourOfDay the expected hour of day.
     * @param minute    the expected minute.
     * @param second    the expected second.
     */
    public void hasUtcTime(final int hourOfDay, final int minute, final int second) {
        toUtcTimeZoneCalendar().hasTime(hourOfDay, minute, second);
    }

    /**
     * Check if the actual value's time properties are equal to the expected time properties in the UTC time zone.
     *
     * @param hourOfDay   the expected hour of day.
     * @param minute      the expected minute.
     * @param second      the expected second.
     * @param millisecond the expected millisecond.
     */
    public void hasUtcTime(final int hourOfDay, final int minute, final int second, final int millisecond) {
        toUtcTimeZoneCalendar().hasTime(hourOfDay, minute, second, millisecond);
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
    public void hasDateAndTime(final int year, final int month, final int dayOfMonth, final int hourOfDay, final int minute, final int second) {
        hasYear(year);
        hasMonth(month);
        hasDayOfMonth(dayOfMonth);
        hasHourOfDay(hourOfDay);
        hasMinute(minute);
        hasSecond(second);
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
    public void hasDateAndTime(final int year, final int month, final int dayOfMonth, final int hourOfDay, final int minute, final int second, final int millisecond) {
        hasYear(year);
        hasMonth(month);
        hasDayOfMonth(dayOfMonth);
        hasHourOfDay(hourOfDay);
        hasMinute(minute);
        hasSecond(second);
        hasMillisecond(millisecond);
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
     */
    public void hasTimeZoneDateAndTime(final int year, final int month, final int dayOfMonth, final int hourOfDay, final int minute, final int second, final String timeZoneId) {
        hasYear(year);
        hasMonth(month);
        hasDayOfMonth(dayOfMonth);
        hasHourOfDay(hourOfDay);
        hasMinute(minute);
        hasSecond(second);
        hasTimeZoneId(timeZoneId);
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
     */
    public void hasTimeZoneDateAndTime(final int year, final int month, final int dayOfMonth, final int hourOfDay, final int minute, final int second, final int zoneOffset) {
        hasYear(year);
        hasMonth(month);
        hasDayOfMonth(dayOfMonth);
        hasHourOfDay(hourOfDay);
        hasMinute(minute);
        hasSecond(second);
        hasZoneOffset(zoneOffset);
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
     */
    public void hasTimeZoneDateAndTime(final int year, final int month, final int dayOfMonth, final int hourOfDay, final int minute, final int second, final int millisecond, final String timeZoneId) {
        hasYear(year);
        hasMonth(month);
        hasDayOfMonth(dayOfMonth);
        hasHourOfDay(hourOfDay);
        hasMinute(minute);
        hasSecond(second);
        hasMillisecond(millisecond);
        hasTimeZoneId(timeZoneId);
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
     */
    public void hasTimeZoneDateAndTime(final int year, final int month, final int dayOfMonth, final int hourOfDay, final int minute, final int second, final int millisecond, final int zoneOffset) {
        hasYear(year);
        hasMonth(month);
        hasDayOfMonth(dayOfMonth);
        hasHourOfDay(hourOfDay);
        hasMinute(minute);
        hasSecond(second);
        hasMillisecond(millisecond);
        hasZoneOffset(zoneOffset);
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
    public void hasUtcDateAndTime(final int year, final int month, final int dayOfMonth, final int hourOfDay, final int minute, final int second) {
        toUtcTimeZoneCalendar().hasDateAndTime(year, month, dayOfMonth, hourOfDay, minute, second);
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
    public void hasUtcDateAndTime(final int year, final int month, final int dayOfMonth, final int hourOfDay, final int minute, final int second, final int millisecond) {
        toUtcTimeZoneCalendar().hasDateAndTime(year, month, dayOfMonth, hourOfDay, minute, second, millisecond);
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
