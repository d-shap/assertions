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

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link CalendarAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public class CalendarAssertionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public CalendarAssertionTest() {
        super();
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void actualValueValidatorTest() {
        initialize(Raw.calendarAssertion(), Calendar.getInstance());

        try {
            initializeWithRawActual(Raw.calendarAssertion(), new Object());
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<java.util.Calendar> but was:<java.lang.Object>");
        }
        try {
            initializeWithRawActual(Raw.calendarAssertion(), new Object(), "Message");
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<java.util.Calendar> but was:<java.lang.Object>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void isEqualToTest() {
        // TODO
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void isNotEqualToTest() {
        // TODO
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void isGreaterThanTest() {
        // TODO
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void isGreaterThanOrEqualToTest() {
        // TODO
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void isLessThanTest() {
        // TODO
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void isLessThanOrEqualToTest() {
        // TODO
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void isInRangeTest() {
        // TODO
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void isNotInRangeTest() {
        // TODO
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toYearTest() {
        // TODO
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toYearMatcherTest() {
        // TODO
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasYearTest() {
        // TODO
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toMonthTest() {
        // TODO
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toMonthMatcherTest() {
        // TODO
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasMonthTest() {
        // TODO
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toWeekOfYearTest() {
        // TODO
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toWeekOfYearMatcherTest() {
        // TODO
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasWeekOfYearTest() {
        // TODO
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toWeekOfMonthTest() {
        // TODO
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toWeekOfMonthMatcherTest() {
        // TODO
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasWeekOfMonthTest() {
        // TODO
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toDayOfYearTest() {
        // TODO
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toDayOfYearMatcherTest() {
        // TODO
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasDayOfYearTest() {
        // TODO
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toDayOfMonthTest() {
        // TODO
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toDayOfMonthMatcherTest() {
        // TODO
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasDayOfMonthTest() {
        // TODO
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toDayOfWeekInMonthTest() {
        // TODO
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toDayOfWeekInMonthMatcherTest() {
        // TODO
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasDayOfWeekInMonthTest() {
        // TODO
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toDayOfWeekTest() {
        // TODO
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toDayOfWeekMatcherTest() {
        // TODO
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasDayOfWeekTest() {
        // TODO
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toAmPmTest() {
        // TODO
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toAmPmMatcherTest() {
        // TODO
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void isAmTest() {
        // TODO
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void isPmTest() {
        // TODO
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toHourOfDayTest() {
        // TODO
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toHourOfDayMatcherTest() {
        // TODO
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasHourOfDayTest() {
        // TODO
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toHourTest() {
        // TODO
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toHourMatcherTest() {
        // TODO
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasHourTest() {
        // TODO
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toMinuteTest() {
        // TODO
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toMinuteMatcherTest() {
        // TODO
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasMinuteTest() {
        // TODO
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toSecondTest() {
        // TODO
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toSecondMatcherTest() {
        // TODO
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasSecondTest() {
        // TODO
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toMillisecondTest() {
        // TODO
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toMillisecondMatcherTest() {
        // TODO
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasMillisecondTest() {
        // TODO
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toZoneOffsetTest() {
        // TODO
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toZoneOffsetMatcherTest() {
        // TODO
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasZoneOffsetTest() {
        // TODO
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toDstOffsetTest() {
        // TODO
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toDstOffsetMatcherTest() {
        // TODO
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasDstOffsetTest() {
        // TODO
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toTimeZoneTest() {
        // TODO
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toTimeZoneMatcherTest() {
        // TODO
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasTimeZoneTest() {
        // TODO
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasTimeZoneIdTest() {
        // TODO
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasDateTest() {
        // TODO
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasDateTimeZoneIdTest() {
        // TODO
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasUtcDateTest() {
        // TODO
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasTimeTest() {
        // TODO
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasTimeTimeZoneIdTest() {
        // TODO
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasTimeMillisecondTest() {
        // TODO
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasTimeMillisecondTimeZoneIdTest() {
        // TODO
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasUtcTimeTest() {
        // TODO
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasUtcTimeMillisecondTest() {
        // TODO
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasDateAndTimeTest() {
        // TODO
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasDateAndTimeTimeZoneIdTest() {
        // TODO
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasDateAndTimeMillisecondTest() {
        // TODO
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasDateAndTimeMillisecondTimeZoneIdTest() {
        // TODO
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasUtcDateAndTimeTest() {
        // TODO
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasUtcDateAndTimeMillisecondTest() {
        // TODO
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toTimeZoneCalendarTest() {
        // TODO
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toTimeZoneIdCalendarTest() {
        // TODO
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toUtcTimeZoneCalendarTest() {
        // TODO
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void isNullTest() {
        // TODO
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void isSameAsTest() {
        // TODO
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        // TODO
    }

}
