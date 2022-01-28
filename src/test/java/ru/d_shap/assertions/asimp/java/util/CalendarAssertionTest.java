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
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toYear().isEqualTo(1324);
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toYear().isEqualTo(1324);

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
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toYear(Matchers.is(Matchers.equalTo(1324)));
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toYear(Matchers.is(Matchers.equalTo(1324)));

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
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).hasYear(1324);
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).hasYear(1324);

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
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toMonth().isEqualTo(Calendar.JULY);
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toMonth().isEqualTo(Calendar.DECEMBER);

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
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toMonth(Matchers.is(Matchers.equalTo(Calendar.JULY)));
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toMonth(Matchers.is(Matchers.equalTo(Calendar.DECEMBER)));

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
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).hasMonth(Calendar.JULY);
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).hasMonth(Calendar.DECEMBER);

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
        initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toWeekOfYear().isEqualTo(28);
        initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toWeekOfYear().isEqualTo(50);
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toWeekOfYear().isEqualTo(30);
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toWeekOfYear().isEqualTo(52);

        try {
            Raw.calendarAssertion().toWeekOfYear();
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toWeekOfYear();
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toWeekOfYear();
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toWeekOfYear()).isEqualTo(2020);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's week of year.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toWeekOfYear()).isEqualTo(2020);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's week of year.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toWeekOfYear().isEqualTo(30);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's week of year.\n\tActual and expected values should be the same.\n\tExpected:<30> but was:<28>");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toWeekOfYear().isEqualTo(30);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's week of year.\n\tActual and expected values should be the same.\n\tExpected:<30> but was:<28>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toWeekOfYearMatcherTest() {
        initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toWeekOfYear(Matchers.is(Matchers.equalTo(28)));
        initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toWeekOfYear(Matchers.is(Matchers.equalTo(50)));
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toWeekOfYear(Matchers.is(Matchers.equalTo(30)));
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toWeekOfYear(Matchers.is(Matchers.equalTo(52)));

        try {
            Raw.calendarAssertion().toWeekOfYear(Matchers.equalTo(0));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toWeekOfYear(Matchers.equalTo(0));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toWeekOfYear(Matchers.equalTo(0));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toWeekOfYear(null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toWeekOfYear(null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toWeekOfYear(null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toWeekOfYear(null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toWeekOfYear(Matchers.is(Matchers.equalTo(30)));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's week of year.\nExpected: is <30>\n     but: was <28>");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toWeekOfYear(Matchers.is(Matchers.equalTo(30)));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's week of year.\nExpected: is <30>\n     but: was <28>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasWeekOfYearTest() {
        initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).hasWeekOfYear(28);
        initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).hasWeekOfYear(50);
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).hasWeekOfYear(30);
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).hasWeekOfYear(52);

        try {
            Raw.calendarAssertion().hasWeekOfYear(0);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).hasWeekOfYear(0);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").hasWeekOfYear(0);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).hasWeekOfYear(30);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's week of year.\n\tActual and expected values should be the same.\n\tExpected:<30> but was:<28>");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").hasWeekOfYear(30);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's week of year.\n\tActual and expected values should be the same.\n\tExpected:<30> but was:<28>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toWeekOfMonthTest() {
        initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toWeekOfMonth().isEqualTo(2);
        initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toWeekOfMonth().isEqualTo(2);
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toWeekOfMonth().isEqualTo(4);
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toWeekOfMonth().isEqualTo(4);

        try {
            Raw.calendarAssertion().toWeekOfMonth();
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toWeekOfMonth();
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toWeekOfMonth();
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toWeekOfMonth()).isEqualTo(2020);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's week of month.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toWeekOfMonth()).isEqualTo(2020);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's week of month.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toWeekOfMonth().isEqualTo(1);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's week of month.\n\tActual and expected values should be the same.\n\tExpected:<1> but was:<2>");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toWeekOfMonth().isEqualTo(1);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's week of month.\n\tActual and expected values should be the same.\n\tExpected:<1> but was:<2>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toWeekOfMonthMatcherTest() {
        initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toWeekOfMonth(Matchers.is(Matchers.equalTo(2)));
        initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toWeekOfMonth(Matchers.is(Matchers.equalTo(2)));
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toWeekOfMonth(Matchers.is(Matchers.equalTo(4)));
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toWeekOfMonth(Matchers.is(Matchers.equalTo(4)));

        try {
            Raw.calendarAssertion().toWeekOfMonth(Matchers.equalTo(0));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toWeekOfMonth(Matchers.equalTo(0));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toWeekOfMonth(Matchers.equalTo(0));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toWeekOfMonth(null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toWeekOfMonth(null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toWeekOfMonth(null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toWeekOfMonth(null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toWeekOfMonth(Matchers.is(Matchers.equalTo(1)));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's week of month.\nExpected: is <1>\n     but: was <2>");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toWeekOfMonth(Matchers.is(Matchers.equalTo(1)));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's week of month.\nExpected: is <1>\n     but: was <2>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasWeekOfMonthTest() {
        initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).hasWeekOfMonth(2);
        initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).hasWeekOfMonth(2);
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).hasWeekOfMonth(4);
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).hasWeekOfMonth(4);

        try {
            Raw.calendarAssertion().hasWeekOfMonth(0);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).hasWeekOfMonth(0);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").hasWeekOfMonth(0);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).hasWeekOfMonth(1);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's week of month.\n\tActual and expected values should be the same.\n\tExpected:<1> but was:<2>");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").hasWeekOfMonth(1);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's week of month.\n\tActual and expected values should be the same.\n\tExpected:<1> but was:<2>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toDayOfYearTest() {
        initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toDayOfYear().isEqualTo(193);
        initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toDayOfYear().isEqualTo(346);
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toDayOfYear().isEqualTo(203);
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toDayOfYear().isEqualTo(356);

        try {
            Raw.calendarAssertion().toDayOfYear();
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toDayOfYear();
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toDayOfYear();
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toDayOfYear()).isEqualTo(193);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's day of year.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toDayOfYear()).isEqualTo(193);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's day of year.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toDayOfYear().isEqualTo(192);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's day of year.\n\tActual and expected values should be the same.\n\tExpected:<192> but was:<193>");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toDayOfYear().isEqualTo(192);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's day of year.\n\tActual and expected values should be the same.\n\tExpected:<192> but was:<193>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toDayOfYearMatcherTest() {
        initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toDayOfYear(Matchers.is(Matchers.equalTo(193)));
        initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toDayOfYear(Matchers.is(Matchers.equalTo(346)));
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toDayOfYear(Matchers.is(Matchers.equalTo(203)));
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toDayOfYear(Matchers.is(Matchers.equalTo(356)));

        try {
            Raw.calendarAssertion().toDayOfYear(Matchers.equalTo(0));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toDayOfYear(Matchers.equalTo(0));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toDayOfYear(Matchers.equalTo(0));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toDayOfYear(null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toDayOfYear(null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toDayOfYear(null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toDayOfYear(null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toDayOfYear(Matchers.is(Matchers.equalTo(192)));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's day of year.\nExpected: is <192>\n     but: was <193>");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toDayOfYear(Matchers.is(Matchers.equalTo(192)));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's day of year.\nExpected: is <192>\n     but: was <193>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasDayOfYearTest() {
        initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).hasDayOfYear(193);
        initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).hasDayOfYear(346);
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).hasDayOfYear(203);
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).hasDayOfYear(356);

        try {
            Raw.calendarAssertion().hasDayOfYear(0);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).hasDayOfYear(0);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").hasDayOfYear(0);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).hasDayOfYear(192);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's day of year.\n\tActual and expected values should be the same.\n\tExpected:<192> but was:<193>");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").hasDayOfYear(192);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's day of year.\n\tActual and expected values should be the same.\n\tExpected:<192> but was:<193>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toDayOfMonthTest() {
        initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toDayOfMonth().isEqualTo(11);
        initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toDayOfMonth().isEqualTo(11);
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toDayOfMonth().isEqualTo(21);
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toDayOfMonth().isEqualTo(21);

        try {
            Raw.calendarAssertion().toDayOfMonth();
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toDayOfMonth();
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toDayOfMonth();
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toDayOfMonth()).isEqualTo(193);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's day of month.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toDayOfMonth()).isEqualTo(193);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's day of month.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toDayOfMonth().isEqualTo(12);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's day of month.\n\tActual and expected values should be the same.\n\tExpected:<12> but was:<11>");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toDayOfMonth().isEqualTo(12);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's day of month.\n\tActual and expected values should be the same.\n\tExpected:<12> but was:<11>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toDayOfMonthMatcherTest() {
        initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toDayOfMonth(Matchers.is(Matchers.equalTo(11)));
        initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toDayOfMonth(Matchers.is(Matchers.equalTo(11)));
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toDayOfMonth(Matchers.is(Matchers.equalTo(21)));
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toDayOfMonth(Matchers.is(Matchers.equalTo(21)));

        try {
            Raw.calendarAssertion().toDayOfMonth(Matchers.equalTo(0));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toDayOfMonth(Matchers.equalTo(0));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toDayOfMonth(Matchers.equalTo(0));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toDayOfMonth(null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toDayOfMonth(null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toDayOfMonth(null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toDayOfMonth(null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toDayOfMonth(Matchers.is(Matchers.equalTo(12)));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's day of month.\nExpected: is <12>\n     but: was <11>");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toDayOfMonth(Matchers.is(Matchers.equalTo(12)));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's day of month.\nExpected: is <12>\n     but: was <11>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasDayOfMonthTest() {
        initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).hasDayOfMonth(11);
        initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).hasDayOfMonth(11);
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).hasDayOfMonth(21);
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).hasDayOfMonth(21);

        try {
            Raw.calendarAssertion().hasDayOfMonth(0);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).hasDayOfMonth(0);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").hasDayOfMonth(0);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).hasDayOfMonth(12);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's day of month.\n\tActual and expected values should be the same.\n\tExpected:<12> but was:<11>");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").hasDayOfMonth(12);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's day of month.\n\tActual and expected values should be the same.\n\tExpected:<12> but was:<11>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toDayOfWeekInMonthTest() {
        initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toDayOfWeekInMonth().isEqualTo(2);
        initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toDayOfWeekInMonth().isEqualTo(2);
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toDayOfWeekInMonth().isEqualTo(3);
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toDayOfWeekInMonth().isEqualTo(3);

        try {
            Raw.calendarAssertion().toDayOfWeekInMonth();
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toDayOfWeekInMonth();
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toDayOfWeekInMonth();
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toDayOfWeekInMonth()).isEqualTo(193);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's day of week in month.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toDayOfWeekInMonth()).isEqualTo(193);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's day of week in month.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toDayOfWeekInMonth().isEqualTo(3);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's day of week in month.\n\tActual and expected values should be the same.\n\tExpected:<3> but was:<2>");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toDayOfWeekInMonth().isEqualTo(3);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's day of week in month.\n\tActual and expected values should be the same.\n\tExpected:<3> but was:<2>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toDayOfWeekInMonthMatcherTest() {
        initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toDayOfWeekInMonth(Matchers.is(Matchers.equalTo(2)));
        initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toDayOfWeekInMonth(Matchers.is(Matchers.equalTo(2)));
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toDayOfWeekInMonth(Matchers.is(Matchers.equalTo(3)));
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toDayOfWeekInMonth(Matchers.is(Matchers.equalTo(3)));

        try {
            Raw.calendarAssertion().toDayOfWeekInMonth(Matchers.equalTo(0));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toDayOfWeekInMonth(Matchers.equalTo(0));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toDayOfWeekInMonth(Matchers.equalTo(0));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toDayOfWeekInMonth(null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toDayOfWeekInMonth(null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toDayOfWeekInMonth(null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toDayOfWeekInMonth(null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toDayOfWeekInMonth(Matchers.is(Matchers.equalTo(3)));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's day of week in month.\nExpected: is <3>\n     but: was <2>");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toDayOfWeekInMonth(Matchers.is(Matchers.equalTo(3)));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's day of week in month.\nExpected: is <3>\n     but: was <2>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasDayOfWeekInMonthTest() {
        initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).hasDayOfWeekInMonth(2);
        initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).hasDayOfWeekInMonth(2);
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).hasDayOfWeekInMonth(3);
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).hasDayOfWeekInMonth(3);

        try {
            Raw.calendarAssertion().hasDayOfWeekInMonth(0);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).hasDayOfWeekInMonth(0);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").hasDayOfWeekInMonth(0);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).hasDayOfWeekInMonth(3);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's day of week in month.\n\tActual and expected values should be the same.\n\tExpected:<3> but was:<2>");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").hasDayOfWeekInMonth(3);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's day of week in month.\n\tActual and expected values should be the same.\n\tExpected:<3> but was:<2>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toDayOfWeekTest() {
        initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toDayOfWeek().isEqualTo(Calendar.SATURDAY);
        initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toDayOfWeek().isEqualTo(Calendar.FRIDAY);
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toDayOfWeek().isEqualTo(Calendar.SATURDAY);
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toDayOfWeek().isEqualTo(Calendar.FRIDAY);

        try {
            Raw.calendarAssertion().toDayOfWeek();
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toDayOfWeek();
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toDayOfWeek();
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toDayOfWeek()).isEqualTo(193);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's day of week.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toDayOfWeek()).isEqualTo(193);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's day of week.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toDayOfWeek().isEqualTo(Calendar.FRIDAY);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's day of week.\n\tActual and expected values should be the same.\n\tExpected:<6> but was:<7>");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toDayOfWeek().isEqualTo(Calendar.FRIDAY);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's day of week.\n\tActual and expected values should be the same.\n\tExpected:<6> but was:<7>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toDayOfWeekMatcherTest() {
        initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toDayOfWeek(Matchers.is(Matchers.equalTo(Calendar.SATURDAY)));
        initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toDayOfWeek(Matchers.is(Matchers.equalTo(Calendar.FRIDAY)));
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toDayOfWeek(Matchers.is(Matchers.equalTo(Calendar.SATURDAY)));
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toDayOfWeek(Matchers.is(Matchers.equalTo(Calendar.FRIDAY)));

        try {
            Raw.calendarAssertion().toDayOfWeek(Matchers.equalTo(0));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toDayOfWeek(Matchers.equalTo(0));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toDayOfWeek(Matchers.equalTo(0));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toDayOfWeek(null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toDayOfWeek(null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toDayOfWeek(null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toDayOfWeek(null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toDayOfWeek(Matchers.is(Matchers.equalTo(Calendar.FRIDAY)));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's day of week.\nExpected: is <6>\n     but: was <7>");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toDayOfWeek(Matchers.is(Matchers.equalTo(Calendar.FRIDAY)));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's day of week.\nExpected: is <6>\n     but: was <7>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasDayOfWeekTest() {
        initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).hasDayOfWeek(Calendar.SATURDAY);
        initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).hasDayOfWeek(Calendar.FRIDAY);
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).hasDayOfWeek(Calendar.SATURDAY);
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).hasDayOfWeek(Calendar.FRIDAY);

        try {
            Raw.calendarAssertion().hasDayOfWeek(0);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).hasDayOfWeek(0);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").hasDayOfWeek(0);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).hasDayOfWeek(Calendar.FRIDAY);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's day of week.\n\tActual and expected values should be the same.\n\tExpected:<6> but was:<7>");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").hasDayOfWeek(Calendar.FRIDAY);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's day of week.\n\tActual and expected values should be the same.\n\tExpected:<6> but was:<7>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toAmPmTest() {
        initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toAmPm().isEqualTo(Calendar.PM);
        initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toAmPm().isEqualTo(Calendar.PM);
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toAmPm().isEqualTo(Calendar.AM);
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toAmPm().isEqualTo(Calendar.AM);

        try {
            Raw.calendarAssertion().toAmPm();
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toAmPm();
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toAmPm();
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toAmPm()).isEqualTo(193);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's AM/PM.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toAmPm()).isEqualTo(193);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's AM/PM.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toAmPm().isEqualTo(Calendar.AM);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's AM/PM.\n\tActual and expected values should be the same.\n\tExpected:<0> but was:<1>");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toAmPm().isEqualTo(Calendar.AM);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's AM/PM.\n\tActual and expected values should be the same.\n\tExpected:<0> but was:<1>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toAmPmMatcherTest() {
        initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toAmPm(Matchers.is(Matchers.equalTo(Calendar.PM)));
        initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toAmPm(Matchers.is(Matchers.equalTo(Calendar.PM)));
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toAmPm(Matchers.is(Matchers.equalTo(Calendar.AM)));
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toAmPm(Matchers.is(Matchers.equalTo(Calendar.AM)));

        try {
            Raw.calendarAssertion().toAmPm(Matchers.equalTo(0));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toAmPm(Matchers.equalTo(0));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toAmPm(Matchers.equalTo(0));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toAmPm(null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toAmPm(null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toAmPm(null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toAmPm(null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toAmPm(Matchers.is(Matchers.equalTo(Calendar.AM)));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's AM/PM.\nExpected: is <0>\n     but: was <1>");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toAmPm(Matchers.is(Matchers.equalTo(Calendar.AM)));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's AM/PM.\nExpected: is <0>\n     but: was <1>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void isAmTest() {
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).isAm();
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).isAm();

        try {
            Raw.calendarAssertion().isAm();
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).isAm();
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").isAm();
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).isAm();
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's AM/PM.\n\tActual and expected values should be the same.\n\tExpected:<0> but was:<1>");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").isAm();
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's AM/PM.\n\tActual and expected values should be the same.\n\tExpected:<0> but was:<1>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void isPmTest() {
        initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).isPm();
        initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).isPm();

        try {
            Raw.calendarAssertion().isPm();
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).isPm();
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").isPm();
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 3, 23, 47)).isPm();
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's AM/PM.\n\tActual and expected values should be the same.\n\tExpected:<1> but was:<0>");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 3, 23, 47), "Message").isPm();
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's AM/PM.\n\tActual and expected values should be the same.\n\tExpected:<1> but was:<0>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toHourOfDayTest() {
        initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toHourOfDay().isEqualTo(15);
        initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toHourOfDay().isEqualTo(15);
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toHourOfDay().isEqualTo(3);
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toHourOfDay().isEqualTo(3);

        try {
            Raw.calendarAssertion().toHourOfDay();
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toHourOfDay();
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toHourOfDay();
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toHourOfDay()).isEqualTo(193);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hour of day.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toHourOfDay()).isEqualTo(193);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hour of day.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toHourOfDay().isEqualTo(14);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<14> but was:<15>");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toHourOfDay().isEqualTo(14);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<14> but was:<15>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toHourOfDayMatcherTest() {
        initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toHourOfDay(Matchers.is(Matchers.equalTo(15)));
        initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toHourOfDay(Matchers.is(Matchers.equalTo(15)));
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toHourOfDay(Matchers.is(Matchers.equalTo(3)));
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toHourOfDay(Matchers.is(Matchers.equalTo(3)));

        try {
            Raw.calendarAssertion().toHourOfDay(Matchers.equalTo(0));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toHourOfDay(Matchers.equalTo(0));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toHourOfDay(Matchers.equalTo(0));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toHourOfDay(null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toHourOfDay(null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toHourOfDay(null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toHourOfDay(null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toHourOfDay(Matchers.is(Matchers.equalTo(14)));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hour of day.\nExpected: is <14>\n     but: was <15>");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toHourOfDay(Matchers.is(Matchers.equalTo(14)));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hour of day.\nExpected: is <14>\n     but: was <15>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasHourOfDayTest() {
        initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).hasHourOfDay(15);
        initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).hasHourOfDay(15);
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).hasHourOfDay(3);
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).hasHourOfDay(3);

        try {
            Raw.calendarAssertion().hasHourOfDay(0);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).hasHourOfDay(0);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").hasHourOfDay(0);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).hasHourOfDay(14);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<14> but was:<15>");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").hasHourOfDay(14);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<14> but was:<15>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toHourTest() {
        initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toHour().isEqualTo(3);
        initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toHour().isEqualTo(3);
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toHour().isEqualTo(3);
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toHour().isEqualTo(3);

        try {
            Raw.calendarAssertion().toHour();
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toHour();
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toHour();
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toHour()).isEqualTo(193);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hour.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toHour()).isEqualTo(193);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hour.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toHour().isEqualTo(2);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hour.\n\tActual and expected values should be the same.\n\tExpected:<2> but was:<3>");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toHour().isEqualTo(2);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hour.\n\tActual and expected values should be the same.\n\tExpected:<2> but was:<3>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toHourMatcherTest() {
        initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toHour(Matchers.is(Matchers.equalTo(3)));
        initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toHour(Matchers.is(Matchers.equalTo(3)));
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toHour(Matchers.is(Matchers.equalTo(3)));
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toHour(Matchers.is(Matchers.equalTo(3)));

        try {
            Raw.calendarAssertion().toHour(Matchers.equalTo(0));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toHour(Matchers.equalTo(0));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toHour(Matchers.equalTo(0));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toHour(null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toHour(null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toHour(null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toHour(null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toHour(Matchers.is(Matchers.equalTo(2)));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hour.\nExpected: is <2>\n     but: was <3>");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toHour(Matchers.is(Matchers.equalTo(2)));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hour.\nExpected: is <2>\n     but: was <3>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasHourTest() {
        initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).hasHour(3);
        initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).hasHour(3);
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).hasHour(3);
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).hasHour(3);

        try {
            Raw.calendarAssertion().hasHour(0);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).hasHour(0);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").hasHour(0);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).hasHour(2);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hour.\n\tActual and expected values should be the same.\n\tExpected:<2> but was:<3>");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").hasHour(2);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hour.\n\tActual and expected values should be the same.\n\tExpected:<2> but was:<3>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toMinuteTest() {
        initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toMinute().isEqualTo(23);
        initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toMinute().isEqualTo(23);
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toMinute().isEqualTo(22);
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toMinute().isEqualTo(22);

        try {
            Raw.calendarAssertion().toMinute();
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toMinute();
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toMinute();
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toMinute()).isEqualTo(193);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minute.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toMinute()).isEqualTo(193);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minute.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toMinute().isEqualTo(22);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<22> but was:<23>");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toMinute().isEqualTo(22);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<22> but was:<23>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toMinuteMatcherTest() {
        initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toMinute(Matchers.is(Matchers.equalTo(23)));
        initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toMinute(Matchers.is(Matchers.equalTo(23)));
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toMinute(Matchers.is(Matchers.equalTo(22)));
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toMinute(Matchers.is(Matchers.equalTo(22)));

        try {
            Raw.calendarAssertion().toMinute(Matchers.equalTo(0));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toMinute(Matchers.equalTo(0));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toMinute(Matchers.equalTo(0));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toMinute(null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toMinute(null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toMinute(null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toMinute(null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toMinute(Matchers.is(Matchers.equalTo(22)));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minute.\nExpected: is <22>\n     but: was <23>");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toMinute(Matchers.is(Matchers.equalTo(22)));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minute.\nExpected: is <22>\n     but: was <23>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasMinuteTest() {
        initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).hasMinute(23);
        initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).hasMinute(23);
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).hasMinute(22);
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).hasMinute(22);

        try {
            Raw.calendarAssertion().hasMinute(0);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).hasMinute(0);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").hasMinute(0);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).hasMinute(22);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<22> but was:<23>");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").hasMinute(22);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<22> but was:<23>");
        }
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
