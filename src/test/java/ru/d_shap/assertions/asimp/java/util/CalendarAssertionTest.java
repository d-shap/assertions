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

import org.hamcrest.Matchers;
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
        initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toYear().isEqualTo(2020);
        initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toYear().isEqualTo(2020);
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.JULY, 11, 15, 23, 47)).toYear().isEqualTo(1324);
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.DECEMBER, 11, 15, 23, 47)).toYear().isEqualTo(1324);

        try {
            Raw.calendarAssertion().toYear();
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toYear();
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toYear();
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toYear()).isEqualTo(2020);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's year.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toYear()).isEqualTo(2020);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's year.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toYear().isEqualTo(2019);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's year.\n\tActual and expected values should be the same.\n\tExpected:<2019> but was:<2020>");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toYear().isEqualTo(2019);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's year.\n\tActual and expected values should be the same.\n\tExpected:<2019> but was:<2020>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toYearMatcherTest() {
        initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toYear(Matchers.is(Matchers.equalTo(2020)));
        initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toYear(Matchers.is(Matchers.equalTo(2020)));
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.JULY, 11, 15, 23, 47)).toYear(Matchers.is(Matchers.equalTo(1324)));
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.DECEMBER, 11, 15, 23, 47)).toYear(Matchers.is(Matchers.equalTo(1324)));

        try {
            Raw.calendarAssertion().toYear(Matchers.equalTo(0));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toYear(Matchers.equalTo(0));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toYear(Matchers.equalTo(0));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toYear(null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toYear(null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toYear(null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toYear(null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toYear(Matchers.is(Matchers.equalTo(2019)));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's year.\nExpected: is <2019>\n     but: was <2020>");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toYear(Matchers.is(Matchers.equalTo(2019)));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's year.\nExpected: is <2019>\n     but: was <2020>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasYearTest() {
        initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).hasYear(2020);
        initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).hasYear(2020);
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.JULY, 11, 15, 23, 47)).hasYear(1324);
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.DECEMBER, 11, 15, 23, 47)).hasYear(1324);

        try {
            Raw.calendarAssertion().hasYear(0);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).hasYear(0);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").hasYear(0);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).hasYear(2019);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's year.\n\tActual and expected values should be the same.\n\tExpected:<2019> but was:<2020>");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").hasYear(2019);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's year.\n\tActual and expected values should be the same.\n\tExpected:<2019> but was:<2020>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toMonthTest() {
        initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toMonth().isEqualTo(Calendar.JULY);
        initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toMonth().isEqualTo(Calendar.DECEMBER);
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.JULY, 11, 15, 23, 47)).toMonth().isEqualTo(Calendar.JULY);
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.DECEMBER, 11, 15, 23, 47)).toMonth().isEqualTo(Calendar.DECEMBER);

        try {
            Raw.calendarAssertion().toMonth();
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toMonth();
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toMonth();
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toMonth()).isEqualTo(Calendar.JULY);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's month.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toMonth()).isEqualTo(Calendar.JULY);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's month.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toMonth().isEqualTo(Calendar.DECEMBER);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's month.\n\tActual and expected values should be the same.\n\tExpected:<11> but was:<6>");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toMonth().isEqualTo(Calendar.DECEMBER);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's month.\n\tActual and expected values should be the same.\n\tExpected:<11> but was:<6>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toMonthMatcherTest() {
        initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toMonth(Matchers.is(Matchers.equalTo(Calendar.JULY)));
        initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toMonth(Matchers.is(Matchers.equalTo(Calendar.DECEMBER)));
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.JULY, 11, 15, 23, 47)).toMonth(Matchers.is(Matchers.equalTo(Calendar.JULY)));
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.DECEMBER, 11, 15, 23, 47)).toMonth(Matchers.is(Matchers.equalTo(Calendar.DECEMBER)));

        try {
            Raw.calendarAssertion().toMonth(Matchers.equalTo(0));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toMonth(Matchers.equalTo(0));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toMonth(Matchers.equalTo(0));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toMonth(null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toMonth(null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toMonth(null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toMonth(null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toMonth(Matchers.is(Matchers.equalTo(Calendar.DECEMBER)));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's month.\nExpected: is <11>\n     but: was <6>");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toMonth(Matchers.is(Matchers.equalTo(Calendar.DECEMBER)));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's month.\nExpected: is <11>\n     but: was <6>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasMonthTest() {
        initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).hasMonth(Calendar.JULY);
        initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).hasMonth(Calendar.DECEMBER);
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.JULY, 11, 15, 23, 47)).hasMonth(Calendar.JULY);
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.DECEMBER, 11, 15, 23, 47)).hasMonth(Calendar.DECEMBER);

        try {
            Raw.calendarAssertion().hasMonth(0);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).hasMonth(0);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").hasMonth(0);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).hasMonth(Calendar.DECEMBER);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's month.\n\tActual and expected values should be the same.\n\tExpected:<11> but was:<6>");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").hasMonth(Calendar.DECEMBER);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's month.\n\tActual and expected values should be the same.\n\tExpected:<11> but was:<6>");
        }
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
