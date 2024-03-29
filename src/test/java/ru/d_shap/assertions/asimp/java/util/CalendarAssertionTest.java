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

import org.hamcrest.Matchers;
import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.util.DataHelper;

/**
 * Tests for {@link CalendarAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class CalendarAssertionTest extends AssertionTest {

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
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<java.util.Calendar> but was:<java.lang.Object>");
        }
        try {
            initializeWithRawActual(Raw.calendarAssertion(), new Object(), "Message");
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<java.util.Calendar> but was:<java.lang.Object>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void isEqualToTest() {
        initialize(Raw.calendarAssertion(), null).isEqualTo(null);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC")).isEqualTo(DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC")).isEqualTo(DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).isEqualTo(DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).isEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane")).isEqualTo(DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane")).isEqualTo(DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).isEqualTo(DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).isEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin")).isEqualTo(DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin")).isEqualTo(DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin")).isEqualTo(DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotNull().isEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isInstanceOf(Calendar.class);

        try {
            Raw.calendarAssertion().isEqualTo(DataHelper.createCalendar(1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).isEqualTo(DataHelper.createCalendar(1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").isEqualTo(DataHelper.createCalendar(1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isEqualTo(null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null.\n\tActual:<2020-07-11T15:23:47.000+0000>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").isEqualTo(null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null.\n\tActual:<2020-07-11T15:23:47.000+0000>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isEqualTo(DataHelper.createCalendar(2019, Calendar.AUGUST, 12, 16, 22, 46, 555, "UTC"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<2019-08-12T16:22:46.555+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").isEqualTo(DataHelper.createCalendar(2019, Calendar.AUGUST, 12, 16, 22, 46, 555, "UTC"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<2019-08-12T16:22:46.555+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<2020-07-11T15:23:47.000+0200> but was:<2020-07-11T15:23:47.000+0000>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").isEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<2020-07-11T15:23:47.000+0200> but was:<2020-07-11T15:23:47.000+0000>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 17, 23, 47, "Europe/Berlin"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<2020-07-11T17:23:47.000+0200> but was:<2020-07-11T15:23:47.000+0000>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").isEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 17, 23, 47, "Europe/Berlin"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<2020-07-11T17:23:47.000+0200> but was:<2020-07-11T15:23:47.000+0000>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void isNotEqualToTest() {
        initialize(Raw.calendarAssertion(), null).isNotEqualTo(DataHelper.createCalendar(2019, Calendar.JULY, 11, 15, 23, 47, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotEqualTo(null);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotEqualTo(DataHelper.createCalendar(2019, Calendar.JULY, 11, 15, 23, 47, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotEqualTo(DataHelper.createCalendar(2020, Calendar.AUGUST, 11, 15, 23, 47, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 12, 15, 23, 47, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 16, 23, 47, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 22, 47, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 46, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 16, 23, 47, "Europe/Berlin"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 17, 23, 47, "Europe/Berlin"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).isNotEqualTo(DataHelper.createCalendar(1323, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).isNotEqualTo(DataHelper.createCalendar(1324, Calendar.NOVEMBER, 21, 3, 22, 46, 543, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).isNotEqualTo(DataHelper.createCalendar(1324, Calendar.DECEMBER, 20, 3, 22, 46, 543, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).isNotEqualTo(DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 4, 22, 46, 543, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).isNotEqualTo(DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 21, 46, 543, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).isNotEqualTo(DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 45, 543, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).isNotEqualTo(DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 555, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).isNotEqualTo(DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).isNotEqualTo(DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 4, 22, 46, 543, "Europe/Berlin"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).isNotEqualTo(DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 5, 22, 46, 543, "Europe/Berlin"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotNull().isNotEqualTo(DataHelper.createCalendar(2019, Calendar.JULY, 11, 15, 23, 47, "UTC")).isInstanceOf(Calendar.class);

        try {
            Raw.calendarAssertion().isNotEqualTo(DataHelper.createCalendar(1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).isNotEqualTo(null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").isNotEqualTo(null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isNotEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").isNotEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).isNotEqualTo(DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<1324-12-21T03:22:46.543+0700>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane"), "Message").isNotEqualTo(DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<1324-12-21T03:22:46.543+0700>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void isGreaterThanTest() {
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThan(DataHelper.createCalendar(2019, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThan(DataHelper.createCalendar(2020, Calendar.JUNE, 11, 15, 23, 47, 345, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThan(DataHelper.createCalendar(2020, Calendar.JULY, 10, 15, 23, 47, 345, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThan(DataHelper.createCalendar(2020, Calendar.JULY, 11, 14, 23, 47, 345, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThan(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 22, 47, 345, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThan(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 46, 345, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThan(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 344, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThan(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThan(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Asia/Vientiane"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin")).isGreaterThan(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Asia/Vientiane"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isNotNull().isGreaterThan(DataHelper.createCalendar(2019, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isInstanceOf(Calendar.class);

        try {
            Raw.calendarAssertion().isGreaterThan(DataHelper.createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).isGreaterThan(DataHelper.createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").isGreaterThan(DataHelper.createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).isGreaterThan(null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").isGreaterThan(null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThan(null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").isGreaterThan(null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThan(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater than the expected.\n\tExpected:<2020-07-11T15:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").isGreaterThan(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be greater than the expected.\n\tExpected:<2020-07-11T15:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThan(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 346, "UTC"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater than the expected.\n\tExpected:<2020-07-11T15:23:47.346+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").isGreaterThan(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 346, "UTC"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be greater than the expected.\n\tExpected:<2020-07-11T15:23:47.346+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin")).isGreaterThan(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater than the expected.\n\tExpected:<2020-07-11T15:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0200>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin"), "Message").isGreaterThan(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be greater than the expected.\n\tExpected:<2020-07-11T15:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0200>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin")).isGreaterThan(DataHelper.createCalendar(2020, Calendar.JULY, 11, 17, 23, 47, 345, "UTC"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater than the expected.\n\tExpected:<2020-07-11T17:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0200>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin"), "Message").isGreaterThan(DataHelper.createCalendar(2020, Calendar.JULY, 11, 17, 23, 47, 345, "UTC"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be greater than the expected.\n\tExpected:<2020-07-11T17:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0200>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void isGreaterThanOrEqualToTest() {
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThanOrEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThanOrEqualTo(DataHelper.createCalendar(2019, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThanOrEqualTo(DataHelper.createCalendar(2020, Calendar.JUNE, 11, 15, 23, 47, 345, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThanOrEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 10, 15, 23, 47, 345, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThanOrEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 14, 23, 47, 345, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThanOrEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 22, 47, 345, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThanOrEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 46, 345, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThanOrEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 344, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThanOrEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThanOrEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Asia/Vientiane"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin")).isGreaterThanOrEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Asia/Vientiane"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isNotNull().isGreaterThanOrEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isInstanceOf(Calendar.class);

        try {
            Raw.calendarAssertion().isGreaterThanOrEqualTo(DataHelper.createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).isGreaterThanOrEqualTo(DataHelper.createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").isGreaterThanOrEqualTo(DataHelper.createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).isGreaterThanOrEqualTo(null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").isGreaterThanOrEqualTo(null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThanOrEqualTo(null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").isGreaterThanOrEqualTo(null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThanOrEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 346, "UTC"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater than or equal to the expected.\n\tExpected:<2020-07-11T15:23:47.346+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").isGreaterThanOrEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 346, "UTC"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be greater than or equal to the expected.\n\tExpected:<2020-07-11T15:23:47.346+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin")).isGreaterThanOrEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater than or equal to the expected.\n\tExpected:<2020-07-11T15:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0200>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin"), "Message").isGreaterThanOrEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be greater than or equal to the expected.\n\tExpected:<2020-07-11T15:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0200>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin")).isGreaterThanOrEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 17, 23, 47, 345, "UTC"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater than or equal to the expected.\n\tExpected:<2020-07-11T17:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0200>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin"), "Message").isGreaterThanOrEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 17, 23, 47, 345, "UTC"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be greater than or equal to the expected.\n\tExpected:<2020-07-11T17:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0200>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void isLessThanTest() {
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThan(DataHelper.createCalendar(2021, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThan(DataHelper.createCalendar(2020, Calendar.AUGUST, 11, 15, 23, 47, 345, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThan(DataHelper.createCalendar(2020, Calendar.JULY, 12, 15, 23, 47, 345, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThan(DataHelper.createCalendar(2020, Calendar.JULY, 11, 16, 23, 47, 345, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThan(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 24, 47, 345, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThan(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 48, 345, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThan(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 346, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin")).isLessThan(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Asia/Vientiane")).isLessThan(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Asia/Vientiane")).isLessThan(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isNotNull().isLessThan(DataHelper.createCalendar(2021, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isInstanceOf(Calendar.class);

        try {
            Raw.calendarAssertion().isLessThan(DataHelper.createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).isLessThan(DataHelper.createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").isLessThan(DataHelper.createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).isLessThan(null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").isLessThan(null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThan(null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").isLessThan(null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThan(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than the expected.\n\tExpected:<2020-07-11T15:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").isLessThan(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be less than the expected.\n\tExpected:<2020-07-11T15:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThan(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 344, "UTC"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than the expected.\n\tExpected:<2020-07-11T15:23:47.344+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").isLessThan(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 344, "UTC"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be less than the expected.\n\tExpected:<2020-07-11T15:23:47.344+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThan(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than the expected.\n\tExpected:<2020-07-11T15:23:47.345+0200> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").isLessThan(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be less than the expected.\n\tExpected:<2020-07-11T15:23:47.345+0200> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThan(DataHelper.createCalendar(2020, Calendar.JULY, 11, 13, 23, 47, 345, "Europe/Berlin"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than the expected.\n\tExpected:<2020-07-11T13:23:47.345+0200> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").isLessThan(DataHelper.createCalendar(2020, Calendar.JULY, 11, 13, 23, 47, 345, "Europe/Berlin"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be less than the expected.\n\tExpected:<2020-07-11T13:23:47.345+0200> but was:<2020-07-11T15:23:47.345+0000>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void isLessThanOrEqualToTest() {
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThanOrEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThanOrEqualTo(DataHelper.createCalendar(2021, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThanOrEqualTo(DataHelper.createCalendar(2020, Calendar.AUGUST, 11, 15, 23, 47, 345, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThanOrEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 12, 15, 23, 47, 345, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThanOrEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 16, 23, 47, 345, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThanOrEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 24, 47, 345, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThanOrEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 48, 345, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThanOrEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 346, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin")).isLessThanOrEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Asia/Vientiane")).isLessThanOrEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Asia/Vientiane")).isLessThanOrEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isNotNull().isLessThanOrEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isInstanceOf(Calendar.class);

        try {
            Raw.calendarAssertion().isLessThanOrEqualTo(DataHelper.createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).isLessThanOrEqualTo(DataHelper.createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").isLessThanOrEqualTo(DataHelper.createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).isLessThanOrEqualTo(null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").isLessThanOrEqualTo(null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThanOrEqualTo(null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").isLessThanOrEqualTo(null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThanOrEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 344, "UTC"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than or equal to the expected.\n\tExpected:<2020-07-11T15:23:47.344+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").isLessThanOrEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 344, "UTC"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be less than or equal to the expected.\n\tExpected:<2020-07-11T15:23:47.344+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThanOrEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than or equal to the expected.\n\tExpected:<2020-07-11T15:23:47.345+0200> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").isLessThanOrEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be less than or equal to the expected.\n\tExpected:<2020-07-11T15:23:47.345+0200> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThanOrEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 13, 23, 47, 345, "Europe/Berlin"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than or equal to the expected.\n\tExpected:<2020-07-11T13:23:47.345+0200> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").isLessThanOrEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 13, 23, 47, 345, "Europe/Berlin"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be less than or equal to the expected.\n\tExpected:<2020-07-11T13:23:47.345+0200> but was:<2020-07-11T15:23:47.345+0000>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void isInRangeTest() {
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isInRange(DataHelper.createCalendar(2019, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), DataHelper.createCalendar(2021, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isInRange(DataHelper.createCalendar(2020, Calendar.JUNE, 11, 15, 23, 47, 345, "UTC"), DataHelper.createCalendar(2020, Calendar.AUGUST, 11, 15, 23, 47, 345, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isInRange(DataHelper.createCalendar(2020, Calendar.JULY, 10, 15, 23, 47, 345, "UTC"), DataHelper.createCalendar(2020, Calendar.JULY, 12, 15, 23, 47, 345, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isInRange(DataHelper.createCalendar(2020, Calendar.JULY, 11, 14, 23, 47, 345, "UTC"), DataHelper.createCalendar(2020, Calendar.JULY, 11, 16, 23, 47, 345, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isInRange(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 22, 47, 345, "UTC"), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 24, 47, 345, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isInRange(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 46, 345, "UTC"), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 48, 345, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isInRange(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 346, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isInRange(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 344, "UTC"), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 346, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin")).isInRange(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Asia/Vientiane"), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isNotNull().isInRange(DataHelper.createCalendar(2019, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), DataHelper.createCalendar(2021, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isInstanceOf(Calendar.class);

        try {
            Raw.calendarAssertion().isInRange(DataHelper.createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"), DataHelper.createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).isInRange(DataHelper.createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"), DataHelper.createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").isInRange(DataHelper.createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"), DataHelper.createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).isInRange(null, DataHelper.createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").isInRange(null, DataHelper.createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).isInRange(DataHelper.createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"), null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").isInRange(DataHelper.createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"), null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC")).isInRange(null, DataHelper.createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"), "Message").isInRange(null, DataHelper.createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC")).isInRange(null, null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"), "Message").isInRange(null, null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC")).isInRange(DataHelper.createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"), null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedTo.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"), "Message").isInRange(DataHelper.createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"), null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedTo.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isInRange(DataHelper.createCalendar(2019, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be in the expected range.\n\tExpected:<2019-07-11T15:23:47.345+0000:2020-07-11T15:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").isInRange(DataHelper.createCalendar(2019, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be in the expected range.\n\tExpected:<2019-07-11T15:23:47.345+0000:2020-07-11T15:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isInRange(DataHelper.createCalendar(2021, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), DataHelper.createCalendar(2022, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be in the expected range.\n\tExpected:<2021-07-11T15:23:47.345+0000:2022-07-11T15:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").isInRange(DataHelper.createCalendar(2021, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), DataHelper.createCalendar(2022, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be in the expected range.\n\tExpected:<2021-07-11T15:23:47.345+0000:2022-07-11T15:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isInRange(DataHelper.createCalendar(2018, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), DataHelper.createCalendar(2019, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be in the expected range.\n\tExpected:<2018-07-11T15:23:47.345+0000:2019-07-11T15:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").isInRange(DataHelper.createCalendar(2018, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), DataHelper.createCalendar(2019, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be in the expected range.\n\tExpected:<2018-07-11T15:23:47.345+0000:2019-07-11T15:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void isNotInRangeTest() {
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isNotInRange(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isNotInRange(DataHelper.createCalendar(2018, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), DataHelper.createCalendar(2019, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isNotInRange(DataHelper.createCalendar(2021, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), DataHelper.createCalendar(2022, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isNotInRange(DataHelper.createCalendar(2020, Calendar.MAY, 11, 15, 23, 47, 345, "UTC"), DataHelper.createCalendar(2020, Calendar.JUNE, 11, 15, 23, 47, 345, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isNotInRange(DataHelper.createCalendar(2020, Calendar.AUGUST, 11, 15, 23, 47, 345, "UTC"), DataHelper.createCalendar(2020, Calendar.SEPTEMBER, 11, 15, 23, 47, 345, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isNotInRange(DataHelper.createCalendar(2020, Calendar.JULY, 9, 15, 23, 47, 345, "UTC"), DataHelper.createCalendar(2020, Calendar.JULY, 10, 15, 23, 47, 345, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isNotInRange(DataHelper.createCalendar(2020, Calendar.JULY, 12, 15, 23, 47, 345, "UTC"), DataHelper.createCalendar(2020, Calendar.JULY, 13, 15, 23, 47, 345, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isNotInRange(DataHelper.createCalendar(2020, Calendar.JULY, 11, 13, 23, 47, 345, "UTC"), DataHelper.createCalendar(2020, Calendar.JULY, 11, 14, 23, 47, 345, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isNotInRange(DataHelper.createCalendar(2020, Calendar.JULY, 11, 16, 23, 47, 345, "UTC"), DataHelper.createCalendar(2020, Calendar.JULY, 11, 17, 23, 47, 345, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isNotInRange(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 21, 47, 345, "UTC"), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 22, 47, 345, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isNotInRange(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 24, 47, 345, "UTC"), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 25, 47, 345, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isNotInRange(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 45, 345, "UTC"), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 46, 345, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isNotInRange(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 48, 345, "UTC"), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 49, 345, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isNotInRange(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 343, "UTC"), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 344, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isNotInRange(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 346, "UTC"), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 347, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Asia/Vientiane")).isNotInRange(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin"), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isNotInRange(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Asia/Vientiane"), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isNotNull().isNotInRange(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isInstanceOf(Calendar.class);

        try {
            Raw.calendarAssertion().isNotInRange(DataHelper.createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"), DataHelper.createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).isNotInRange(DataHelper.createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"), DataHelper.createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").isNotInRange(DataHelper.createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"), DataHelper.createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).isNotInRange(null, DataHelper.createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").isNotInRange(null, DataHelper.createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).isNotInRange(DataHelper.createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"), null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").isNotInRange(DataHelper.createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"), null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC")).isNotInRange(null, DataHelper.createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"), "Message").isNotInRange(null, DataHelper.createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC")).isNotInRange(null, null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"), "Message").isNotInRange(null, null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC")).isNotInRange(DataHelper.createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"), null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedTo.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"), "Message").isNotInRange(DataHelper.createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"), null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedTo.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isNotInRange(DataHelper.createCalendar(2019, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), DataHelper.createCalendar(2021, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be in the expected range.\n\tExpected:<2019-07-11T15:23:47.345+0000:2021-07-11T15:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").isNotInRange(DataHelper.createCalendar(2019, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), DataHelper.createCalendar(2021, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be in the expected range.\n\tExpected:<2019-07-11T15:23:47.345+0000:2021-07-11T15:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isNotInRange(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), DataHelper.createCalendar(2021, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be in the expected range.\n\tExpected:<2020-07-11T15:23:47.345+0000:2021-07-11T15:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").isNotInRange(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), DataHelper.createCalendar(2021, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be in the expected range.\n\tExpected:<2020-07-11T15:23:47.345+0000:2021-07-11T15:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin")).isNotInRange(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Asia/Vientiane"), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be in the expected range.\n\tExpected:<2020-07-11T15:23:47.345+0700:2020-07-11T15:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0200>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin"), "Message").isNotInRange(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Asia/Vientiane"), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be in the expected range.\n\tExpected:<2020-07-11T15:23:47.345+0700:2020-07-11T15:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0200>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toYearTest() {
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toYear().isEqualTo(2020);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toYear().isEqualTo(2020);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toYear().isEqualTo(1324);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toYear().isEqualTo(1324);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).isNotNull().toYear().isEqualTo(2020);

        try {
            Raw.calendarAssertion().toYear();
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toYear();
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toYear();
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toYear()).isEqualTo(2020);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's year.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toYear()).isEqualTo(2020);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's year.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toYear().isEqualTo(2019);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's year.\n\tActual and expected values should be the same.\n\tExpected:<2019> but was:<2020>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toYear().isEqualTo(2019);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's year.\n\tActual and expected values should be the same.\n\tExpected:<2019> but was:<2020>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toYearMatcherTest() {
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toYear(Matchers.is(Matchers.equalTo(2020)));
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toYear(Matchers.is(Matchers.equalTo(2020)));
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toYear(Matchers.is(Matchers.equalTo(1324)));
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toYear(Matchers.is(Matchers.equalTo(1324)));
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).isNotNull().toYear(Matchers.is(Matchers.equalTo(2020))).isInstanceOf(Calendar.class);

        try {
            Raw.calendarAssertion().toYear(Matchers.equalTo(0));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toYear(Matchers.equalTo(0));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toYear(Matchers.equalTo(0));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toYear(null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toYear(null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toYear(null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toYear(null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toYear(Matchers.is(Matchers.equalTo(2019)));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's year.\nExpected: is <2019>\n     but: was <2020>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toYear(Matchers.is(Matchers.equalTo(2019)));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's year.\nExpected: is <2019>\n     but: was <2020>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasYearTest() {
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).hasYear(2020);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).hasYear(2020);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).hasYear(1324);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).hasYear(1324);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).isNotNull().hasYear(2020).isInstanceOf(Calendar.class);

        try {
            Raw.calendarAssertion().hasYear(0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).hasYear(0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").hasYear(0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).hasYear(2019);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's year.\n\tActual and expected values should be the same.\n\tExpected:<2019> but was:<2020>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").hasYear(2019);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's year.\n\tActual and expected values should be the same.\n\tExpected:<2019> but was:<2020>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toMonthTest() {
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toMonth().isEqualTo(Calendar.JULY);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toMonth().isEqualTo(Calendar.DECEMBER);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toMonth().isEqualTo(Calendar.JULY);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toMonth().isEqualTo(Calendar.DECEMBER);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).isNotNull().toMonth().isEqualTo(Calendar.JULY);

        try {
            Raw.calendarAssertion().toMonth();
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toMonth();
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toMonth();
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toMonth()).isEqualTo(Calendar.JULY);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's month.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toMonth()).isEqualTo(Calendar.JULY);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's month.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toMonth().isEqualTo(Calendar.DECEMBER);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's month.\n\tActual and expected values should be the same.\n\tExpected:<11> but was:<6>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toMonth().isEqualTo(Calendar.DECEMBER);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's month.\n\tActual and expected values should be the same.\n\tExpected:<11> but was:<6>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toMonthMatcherTest() {
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toMonth(Matchers.is(Matchers.equalTo(Calendar.JULY)));
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toMonth(Matchers.is(Matchers.equalTo(Calendar.DECEMBER)));
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toMonth(Matchers.is(Matchers.equalTo(Calendar.JULY)));
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toMonth(Matchers.is(Matchers.equalTo(Calendar.DECEMBER)));
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).isNotNull().toMonth(Matchers.is(Matchers.equalTo(Calendar.JULY))).isInstanceOf(Calendar.class);

        try {
            Raw.calendarAssertion().toMonth(Matchers.equalTo(0));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toMonth(Matchers.equalTo(0));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toMonth(Matchers.equalTo(0));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toMonth(null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toMonth(null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toMonth(null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toMonth(null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toMonth(Matchers.is(Matchers.equalTo(Calendar.DECEMBER)));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's month.\nExpected: is <11>\n     but: was <6>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toMonth(Matchers.is(Matchers.equalTo(Calendar.DECEMBER)));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's month.\nExpected: is <11>\n     but: was <6>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasMonthTest() {
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).hasMonth(Calendar.JULY);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).hasMonth(Calendar.DECEMBER);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).hasMonth(Calendar.JULY);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).hasMonth(Calendar.DECEMBER);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).isNotNull().hasMonth(Calendar.JULY).isInstanceOf(Calendar.class);

        try {
            Raw.calendarAssertion().hasMonth(0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).hasMonth(0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").hasMonth(0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).hasMonth(Calendar.DECEMBER);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's month.\n\tActual and expected values should be the same.\n\tExpected:<11> but was:<6>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").hasMonth(Calendar.DECEMBER);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's month.\n\tActual and expected values should be the same.\n\tExpected:<11> but was:<6>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toWeekOfYearTest() {
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toWeekOfYear().isEqualTo(28);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toWeekOfYear().isEqualTo(50);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toWeekOfYear().isEqualTo(30);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toWeekOfYear().isEqualTo(52);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).isNotNull().toWeekOfYear().isEqualTo(28);

        try {
            Raw.calendarAssertion().toWeekOfYear();
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toWeekOfYear();
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toWeekOfYear();
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toWeekOfYear()).isEqualTo(2020);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's week of year.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toWeekOfYear()).isEqualTo(2020);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's week of year.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toWeekOfYear().isEqualTo(30);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's week of year.\n\tActual and expected values should be the same.\n\tExpected:<30> but was:<28>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toWeekOfYear().isEqualTo(30);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's week of year.\n\tActual and expected values should be the same.\n\tExpected:<30> but was:<28>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toWeekOfYearMatcherTest() {
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toWeekOfYear(Matchers.is(Matchers.equalTo(28)));
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toWeekOfYear(Matchers.is(Matchers.equalTo(50)));
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toWeekOfYear(Matchers.is(Matchers.equalTo(30)));
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toWeekOfYear(Matchers.is(Matchers.equalTo(52)));
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).isNotNull().toWeekOfYear(Matchers.is(Matchers.equalTo(28))).isInstanceOf(Calendar.class);

        try {
            Raw.calendarAssertion().toWeekOfYear(Matchers.equalTo(0));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toWeekOfYear(Matchers.equalTo(0));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toWeekOfYear(Matchers.equalTo(0));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toWeekOfYear(null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toWeekOfYear(null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toWeekOfYear(null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toWeekOfYear(null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toWeekOfYear(Matchers.is(Matchers.equalTo(30)));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's week of year.\nExpected: is <30>\n     but: was <28>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toWeekOfYear(Matchers.is(Matchers.equalTo(30)));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's week of year.\nExpected: is <30>\n     but: was <28>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasWeekOfYearTest() {
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).hasWeekOfYear(28);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).hasWeekOfYear(50);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).hasWeekOfYear(30);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).hasWeekOfYear(52);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).isNotNull().hasWeekOfYear(28).isInstanceOf(Calendar.class);

        try {
            Raw.calendarAssertion().hasWeekOfYear(0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).hasWeekOfYear(0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").hasWeekOfYear(0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).hasWeekOfYear(30);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's week of year.\n\tActual and expected values should be the same.\n\tExpected:<30> but was:<28>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").hasWeekOfYear(30);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's week of year.\n\tActual and expected values should be the same.\n\tExpected:<30> but was:<28>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toWeekOfMonthTest() {
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toWeekOfMonth().isEqualTo(2);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toWeekOfMonth().isEqualTo(2);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toWeekOfMonth().isEqualTo(4);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toWeekOfMonth().isEqualTo(4);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).isNotNull().toWeekOfMonth().isEqualTo(2);

        try {
            Raw.calendarAssertion().toWeekOfMonth();
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toWeekOfMonth();
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toWeekOfMonth();
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toWeekOfMonth()).isEqualTo(2020);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's week of month.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toWeekOfMonth()).isEqualTo(2020);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's week of month.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toWeekOfMonth().isEqualTo(1);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's week of month.\n\tActual and expected values should be the same.\n\tExpected:<1> but was:<2>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toWeekOfMonth().isEqualTo(1);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's week of month.\n\tActual and expected values should be the same.\n\tExpected:<1> but was:<2>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toWeekOfMonthMatcherTest() {
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toWeekOfMonth(Matchers.is(Matchers.equalTo(2)));
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toWeekOfMonth(Matchers.is(Matchers.equalTo(2)));
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toWeekOfMonth(Matchers.is(Matchers.equalTo(4)));
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toWeekOfMonth(Matchers.is(Matchers.equalTo(4)));
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).isNotNull().toWeekOfMonth(Matchers.is(Matchers.equalTo(2))).isInstanceOf(Calendar.class);

        try {
            Raw.calendarAssertion().toWeekOfMonth(Matchers.equalTo(0));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toWeekOfMonth(Matchers.equalTo(0));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toWeekOfMonth(Matchers.equalTo(0));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toWeekOfMonth(null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toWeekOfMonth(null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toWeekOfMonth(null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toWeekOfMonth(null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toWeekOfMonth(Matchers.is(Matchers.equalTo(1)));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's week of month.\nExpected: is <1>\n     but: was <2>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toWeekOfMonth(Matchers.is(Matchers.equalTo(1)));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's week of month.\nExpected: is <1>\n     but: was <2>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasWeekOfMonthTest() {
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).hasWeekOfMonth(2);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).hasWeekOfMonth(2);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).hasWeekOfMonth(4);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).hasWeekOfMonth(4);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).isNotNull().hasWeekOfMonth(2).isInstanceOf(Calendar.class);

        try {
            Raw.calendarAssertion().hasWeekOfMonth(0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).hasWeekOfMonth(0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").hasWeekOfMonth(0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).hasWeekOfMonth(1);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's week of month.\n\tActual and expected values should be the same.\n\tExpected:<1> but was:<2>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").hasWeekOfMonth(1);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's week of month.\n\tActual and expected values should be the same.\n\tExpected:<1> but was:<2>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toDayOfYearTest() {
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toDayOfYear().isEqualTo(193);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toDayOfYear().isEqualTo(346);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toDayOfYear().isEqualTo(203);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toDayOfYear().isEqualTo(356);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).isNotNull().toDayOfYear().isEqualTo(193);

        try {
            Raw.calendarAssertion().toDayOfYear();
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toDayOfYear();
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toDayOfYear();
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toDayOfYear()).isEqualTo(193);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's day of year.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toDayOfYear()).isEqualTo(193);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's day of year.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toDayOfYear().isEqualTo(192);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's day of year.\n\tActual and expected values should be the same.\n\tExpected:<192> but was:<193>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toDayOfYear().isEqualTo(192);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's day of year.\n\tActual and expected values should be the same.\n\tExpected:<192> but was:<193>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toDayOfYearMatcherTest() {
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toDayOfYear(Matchers.is(Matchers.equalTo(193)));
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toDayOfYear(Matchers.is(Matchers.equalTo(346)));
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toDayOfYear(Matchers.is(Matchers.equalTo(203)));
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toDayOfYear(Matchers.is(Matchers.equalTo(356)));
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).isNotNull().toDayOfYear(Matchers.is(Matchers.equalTo(193))).isInstanceOf(Calendar.class);

        try {
            Raw.calendarAssertion().toDayOfYear(Matchers.equalTo(0));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toDayOfYear(Matchers.equalTo(0));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toDayOfYear(Matchers.equalTo(0));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toDayOfYear(null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toDayOfYear(null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toDayOfYear(null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toDayOfYear(null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toDayOfYear(Matchers.is(Matchers.equalTo(192)));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's day of year.\nExpected: is <192>\n     but: was <193>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toDayOfYear(Matchers.is(Matchers.equalTo(192)));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's day of year.\nExpected: is <192>\n     but: was <193>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasDayOfYearTest() {
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).hasDayOfYear(193);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).hasDayOfYear(346);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).hasDayOfYear(203);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).hasDayOfYear(356);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).isNotNull().hasDayOfYear(193).isInstanceOf(Calendar.class);

        try {
            Raw.calendarAssertion().hasDayOfYear(0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).hasDayOfYear(0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").hasDayOfYear(0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).hasDayOfYear(192);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's day of year.\n\tActual and expected values should be the same.\n\tExpected:<192> but was:<193>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").hasDayOfYear(192);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's day of year.\n\tActual and expected values should be the same.\n\tExpected:<192> but was:<193>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toDayOfMonthTest() {
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toDayOfMonth().isEqualTo(11);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toDayOfMonth().isEqualTo(11);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toDayOfMonth().isEqualTo(21);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toDayOfMonth().isEqualTo(21);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).isNotNull().toDayOfMonth().isEqualTo(11);

        try {
            Raw.calendarAssertion().toDayOfMonth();
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toDayOfMonth();
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toDayOfMonth();
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toDayOfMonth()).isEqualTo(193);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's day of month.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toDayOfMonth()).isEqualTo(193);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's day of month.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toDayOfMonth().isEqualTo(12);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's day of month.\n\tActual and expected values should be the same.\n\tExpected:<12> but was:<11>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toDayOfMonth().isEqualTo(12);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's day of month.\n\tActual and expected values should be the same.\n\tExpected:<12> but was:<11>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toDayOfMonthMatcherTest() {
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toDayOfMonth(Matchers.is(Matchers.equalTo(11)));
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toDayOfMonth(Matchers.is(Matchers.equalTo(11)));
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toDayOfMonth(Matchers.is(Matchers.equalTo(21)));
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toDayOfMonth(Matchers.is(Matchers.equalTo(21)));
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).isNotNull().toDayOfMonth(Matchers.is(Matchers.equalTo(11))).isInstanceOf(Calendar.class);

        try {
            Raw.calendarAssertion().toDayOfMonth(Matchers.equalTo(0));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toDayOfMonth(Matchers.equalTo(0));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toDayOfMonth(Matchers.equalTo(0));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toDayOfMonth(null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toDayOfMonth(null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toDayOfMonth(null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toDayOfMonth(null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toDayOfMonth(Matchers.is(Matchers.equalTo(12)));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's day of month.\nExpected: is <12>\n     but: was <11>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toDayOfMonth(Matchers.is(Matchers.equalTo(12)));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's day of month.\nExpected: is <12>\n     but: was <11>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasDayOfMonthTest() {
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).hasDayOfMonth(11);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).hasDayOfMonth(11);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).hasDayOfMonth(21);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).hasDayOfMonth(21);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).isNotNull().hasDayOfMonth(11).isInstanceOf(Calendar.class);

        try {
            Raw.calendarAssertion().hasDayOfMonth(0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).hasDayOfMonth(0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").hasDayOfMonth(0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).hasDayOfMonth(12);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's day of month.\n\tActual and expected values should be the same.\n\tExpected:<12> but was:<11>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").hasDayOfMonth(12);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's day of month.\n\tActual and expected values should be the same.\n\tExpected:<12> but was:<11>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toDayOfWeekInMonthTest() {
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toDayOfWeekInMonth().isEqualTo(2);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toDayOfWeekInMonth().isEqualTo(2);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toDayOfWeekInMonth().isEqualTo(3);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toDayOfWeekInMonth().isEqualTo(3);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).isNotNull().toDayOfWeekInMonth().isEqualTo(2);

        try {
            Raw.calendarAssertion().toDayOfWeekInMonth();
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toDayOfWeekInMonth();
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toDayOfWeekInMonth();
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toDayOfWeekInMonth()).isEqualTo(193);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's day of week in month.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toDayOfWeekInMonth()).isEqualTo(193);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's day of week in month.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toDayOfWeekInMonth().isEqualTo(3);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's day of week in month.\n\tActual and expected values should be the same.\n\tExpected:<3> but was:<2>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toDayOfWeekInMonth().isEqualTo(3);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's day of week in month.\n\tActual and expected values should be the same.\n\tExpected:<3> but was:<2>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toDayOfWeekInMonthMatcherTest() {
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toDayOfWeekInMonth(Matchers.is(Matchers.equalTo(2)));
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toDayOfWeekInMonth(Matchers.is(Matchers.equalTo(2)));
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toDayOfWeekInMonth(Matchers.is(Matchers.equalTo(3)));
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toDayOfWeekInMonth(Matchers.is(Matchers.equalTo(3)));
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).isNotNull().toDayOfWeekInMonth(Matchers.is(Matchers.equalTo(2))).isInstanceOf(Calendar.class);

        try {
            Raw.calendarAssertion().toDayOfWeekInMonth(Matchers.equalTo(0));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toDayOfWeekInMonth(Matchers.equalTo(0));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toDayOfWeekInMonth(Matchers.equalTo(0));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toDayOfWeekInMonth(null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toDayOfWeekInMonth(null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toDayOfWeekInMonth(null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toDayOfWeekInMonth(null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toDayOfWeekInMonth(Matchers.is(Matchers.equalTo(3)));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's day of week in month.\nExpected: is <3>\n     but: was <2>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toDayOfWeekInMonth(Matchers.is(Matchers.equalTo(3)));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's day of week in month.\nExpected: is <3>\n     but: was <2>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasDayOfWeekInMonthTest() {
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).hasDayOfWeekInMonth(2);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).hasDayOfWeekInMonth(2);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).hasDayOfWeekInMonth(3);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).hasDayOfWeekInMonth(3);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).isNotNull().hasDayOfWeekInMonth(2).isInstanceOf(Calendar.class);

        try {
            Raw.calendarAssertion().hasDayOfWeekInMonth(0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).hasDayOfWeekInMonth(0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").hasDayOfWeekInMonth(0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).hasDayOfWeekInMonth(3);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's day of week in month.\n\tActual and expected values should be the same.\n\tExpected:<3> but was:<2>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").hasDayOfWeekInMonth(3);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's day of week in month.\n\tActual and expected values should be the same.\n\tExpected:<3> but was:<2>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toDayOfWeekTest() {
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toDayOfWeek().isEqualTo(Calendar.SATURDAY);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toDayOfWeek().isEqualTo(Calendar.FRIDAY);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toDayOfWeek().isEqualTo(Calendar.SATURDAY);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toDayOfWeek().isEqualTo(Calendar.FRIDAY);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).isNotNull().toDayOfWeek().isEqualTo(Calendar.SATURDAY);

        try {
            Raw.calendarAssertion().toDayOfWeek();
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toDayOfWeek();
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toDayOfWeek();
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toDayOfWeek()).isEqualTo(193);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's day of week.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toDayOfWeek()).isEqualTo(193);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's day of week.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toDayOfWeek().isEqualTo(Calendar.FRIDAY);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's day of week.\n\tActual and expected values should be the same.\n\tExpected:<6> but was:<7>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toDayOfWeek().isEqualTo(Calendar.FRIDAY);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's day of week.\n\tActual and expected values should be the same.\n\tExpected:<6> but was:<7>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toDayOfWeekMatcherTest() {
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toDayOfWeek(Matchers.is(Matchers.equalTo(Calendar.SATURDAY)));
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toDayOfWeek(Matchers.is(Matchers.equalTo(Calendar.FRIDAY)));
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toDayOfWeek(Matchers.is(Matchers.equalTo(Calendar.SATURDAY)));
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toDayOfWeek(Matchers.is(Matchers.equalTo(Calendar.FRIDAY)));
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).isNotNull().toDayOfWeek(Matchers.is(Matchers.equalTo(Calendar.SATURDAY))).isInstanceOf(Calendar.class);

        try {
            Raw.calendarAssertion().toDayOfWeek(Matchers.equalTo(0));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toDayOfWeek(Matchers.equalTo(0));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toDayOfWeek(Matchers.equalTo(0));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toDayOfWeek(null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toDayOfWeek(null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toDayOfWeek(null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toDayOfWeek(null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toDayOfWeek(Matchers.is(Matchers.equalTo(Calendar.FRIDAY)));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's day of week.\nExpected: is <6>\n     but: was <7>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toDayOfWeek(Matchers.is(Matchers.equalTo(Calendar.FRIDAY)));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's day of week.\nExpected: is <6>\n     but: was <7>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasDayOfWeekTest() {
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).hasDayOfWeek(Calendar.SATURDAY);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).hasDayOfWeek(Calendar.FRIDAY);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).hasDayOfWeek(Calendar.SATURDAY);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).hasDayOfWeek(Calendar.FRIDAY);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).isNotNull().hasDayOfWeek(Calendar.SATURDAY).isInstanceOf(Calendar.class);

        try {
            Raw.calendarAssertion().hasDayOfWeek(0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).hasDayOfWeek(0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").hasDayOfWeek(0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).hasDayOfWeek(Calendar.FRIDAY);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's day of week.\n\tActual and expected values should be the same.\n\tExpected:<6> but was:<7>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").hasDayOfWeek(Calendar.FRIDAY);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's day of week.\n\tActual and expected values should be the same.\n\tExpected:<6> but was:<7>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toAmPmTest() {
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toAmPm().isEqualTo(Calendar.PM);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toAmPm().isEqualTo(Calendar.PM);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toAmPm().isEqualTo(Calendar.AM);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toAmPm().isEqualTo(Calendar.AM);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).isNotNull().toAmPm().isEqualTo(Calendar.PM);

        try {
            Raw.calendarAssertion().toAmPm();
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toAmPm();
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toAmPm();
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toAmPm()).isEqualTo(193);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's AM/PM.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toAmPm()).isEqualTo(193);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's AM/PM.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toAmPm().isEqualTo(Calendar.AM);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's AM/PM.\n\tActual and expected values should be the same.\n\tExpected:<0> but was:<1>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toAmPm().isEqualTo(Calendar.AM);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's AM/PM.\n\tActual and expected values should be the same.\n\tExpected:<0> but was:<1>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toAmPmMatcherTest() {
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toAmPm(Matchers.is(Matchers.equalTo(Calendar.PM)));
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toAmPm(Matchers.is(Matchers.equalTo(Calendar.PM)));
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toAmPm(Matchers.is(Matchers.equalTo(Calendar.AM)));
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toAmPm(Matchers.is(Matchers.equalTo(Calendar.AM)));
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).isNotNull().toAmPm(Matchers.is(Matchers.equalTo(Calendar.PM))).isInstanceOf(Calendar.class);

        try {
            Raw.calendarAssertion().toAmPm(Matchers.equalTo(0));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toAmPm(Matchers.equalTo(0));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toAmPm(Matchers.equalTo(0));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toAmPm(null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toAmPm(null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toAmPm(null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toAmPm(null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toAmPm(Matchers.is(Matchers.equalTo(Calendar.AM)));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's AM/PM.\nExpected: is <0>\n     but: was <1>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toAmPm(Matchers.is(Matchers.equalTo(Calendar.AM)));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's AM/PM.\nExpected: is <0>\n     but: was <1>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void isAmTest() {
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).isAm();
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).isAm();
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).isNotNull().isAm().isInstanceOf(Calendar.class);

        try {
            Raw.calendarAssertion().isAm();
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).isAm();
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").isAm();
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).isAm();
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's AM/PM.\n\tActual and expected values should be the same.\n\tExpected:<0> but was:<1>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").isAm();
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's AM/PM.\n\tActual and expected values should be the same.\n\tExpected:<0> but was:<1>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void isPmTest() {
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).isPm();
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).isPm();
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).isNotNull().isPm().isInstanceOf(Calendar.class);

        try {
            Raw.calendarAssertion().isPm();
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).isPm();
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").isPm();
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 3, 23, 47)).isPm();
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's AM/PM.\n\tActual and expected values should be the same.\n\tExpected:<1> but was:<0>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 3, 23, 47), "Message").isPm();
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's AM/PM.\n\tActual and expected values should be the same.\n\tExpected:<1> but was:<0>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toHourOfDayTest() {
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toHourOfDay().isEqualTo(15);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toHourOfDay().isEqualTo(15);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toHourOfDay().isEqualTo(3);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toHourOfDay().isEqualTo(3);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).isNotNull().toHourOfDay().isEqualTo(15);

        try {
            Raw.calendarAssertion().toHourOfDay();
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toHourOfDay();
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toHourOfDay();
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toHourOfDay()).isEqualTo(193);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hour of day.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toHourOfDay()).isEqualTo(193);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hour of day.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toHourOfDay().isEqualTo(14);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<14> but was:<15>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toHourOfDay().isEqualTo(14);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<14> but was:<15>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toHourOfDayMatcherTest() {
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toHourOfDay(Matchers.is(Matchers.equalTo(15)));
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toHourOfDay(Matchers.is(Matchers.equalTo(15)));
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toHourOfDay(Matchers.is(Matchers.equalTo(3)));
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toHourOfDay(Matchers.is(Matchers.equalTo(3)));
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).isNotNull().toHourOfDay(Matchers.is(Matchers.equalTo(15))).isInstanceOf(Calendar.class);

        try {
            Raw.calendarAssertion().toHourOfDay(Matchers.equalTo(0));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toHourOfDay(Matchers.equalTo(0));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toHourOfDay(Matchers.equalTo(0));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toHourOfDay(null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toHourOfDay(null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toHourOfDay(null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toHourOfDay(null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toHourOfDay(Matchers.is(Matchers.equalTo(14)));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hour of day.\nExpected: is <14>\n     but: was <15>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toHourOfDay(Matchers.is(Matchers.equalTo(14)));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hour of day.\nExpected: is <14>\n     but: was <15>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasHourOfDayTest() {
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).hasHourOfDay(15);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).hasHourOfDay(15);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).hasHourOfDay(3);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).hasHourOfDay(3);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).isNotNull().hasHourOfDay(15).isInstanceOf(Calendar.class);

        try {
            Raw.calendarAssertion().hasHourOfDay(0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).hasHourOfDay(0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").hasHourOfDay(0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).hasHourOfDay(14);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<14> but was:<15>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").hasHourOfDay(14);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<14> but was:<15>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toHourTest() {
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toHour().isEqualTo(3);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toHour().isEqualTo(3);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toHour().isEqualTo(3);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toHour().isEqualTo(3);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).isNotNull().toHour().isEqualTo(3);

        try {
            Raw.calendarAssertion().toHour();
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toHour();
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toHour();
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toHour()).isEqualTo(193);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hour.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toHour()).isEqualTo(193);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hour.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toHour().isEqualTo(2);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hour.\n\tActual and expected values should be the same.\n\tExpected:<2> but was:<3>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toHour().isEqualTo(2);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hour.\n\tActual and expected values should be the same.\n\tExpected:<2> but was:<3>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toHourMatcherTest() {
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toHour(Matchers.is(Matchers.equalTo(3)));
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toHour(Matchers.is(Matchers.equalTo(3)));
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toHour(Matchers.is(Matchers.equalTo(3)));
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toHour(Matchers.is(Matchers.equalTo(3)));
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).isNotNull().toHour(Matchers.is(Matchers.equalTo(3))).isInstanceOf(Calendar.class);

        try {
            Raw.calendarAssertion().toHour(Matchers.equalTo(0));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toHour(Matchers.equalTo(0));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toHour(Matchers.equalTo(0));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toHour(null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toHour(null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toHour(null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toHour(null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toHour(Matchers.is(Matchers.equalTo(2)));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hour.\nExpected: is <2>\n     but: was <3>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toHour(Matchers.is(Matchers.equalTo(2)));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hour.\nExpected: is <2>\n     but: was <3>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasHourTest() {
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).hasHour(3);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).hasHour(3);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).hasHour(3);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).hasHour(3);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).isNotNull().hasHour(3).isInstanceOf(Calendar.class);

        try {
            Raw.calendarAssertion().hasHour(0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).hasHour(0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").hasHour(0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).hasHour(2);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hour.\n\tActual and expected values should be the same.\n\tExpected:<2> but was:<3>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").hasHour(2);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hour.\n\tActual and expected values should be the same.\n\tExpected:<2> but was:<3>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toMinuteTest() {
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toMinute().isEqualTo(23);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toMinute().isEqualTo(23);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toMinute().isEqualTo(22);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toMinute().isEqualTo(22);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).isNotNull().toMinute().isEqualTo(23);

        try {
            Raw.calendarAssertion().toMinute();
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toMinute();
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toMinute();
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toMinute()).isEqualTo(193);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minute.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toMinute()).isEqualTo(193);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minute.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toMinute().isEqualTo(22);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<22> but was:<23>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toMinute().isEqualTo(22);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<22> but was:<23>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toMinuteMatcherTest() {
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toMinute(Matchers.is(Matchers.equalTo(23)));
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toMinute(Matchers.is(Matchers.equalTo(23)));
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toMinute(Matchers.is(Matchers.equalTo(22)));
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toMinute(Matchers.is(Matchers.equalTo(22)));
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).isNotNull().toMinute(Matchers.is(Matchers.equalTo(23))).isInstanceOf(Calendar.class);

        try {
            Raw.calendarAssertion().toMinute(Matchers.equalTo(0));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toMinute(Matchers.equalTo(0));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toMinute(Matchers.equalTo(0));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toMinute(null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toMinute(null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toMinute(null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toMinute(null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toMinute(Matchers.is(Matchers.equalTo(22)));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minute.\nExpected: is <22>\n     but: was <23>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toMinute(Matchers.is(Matchers.equalTo(22)));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minute.\nExpected: is <22>\n     but: was <23>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasMinuteTest() {
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).hasMinute(23);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).hasMinute(23);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).hasMinute(22);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).hasMinute(22);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).isNotNull().hasMinute(23).isInstanceOf(Calendar.class);

        try {
            Raw.calendarAssertion().hasMinute(0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).hasMinute(0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").hasMinute(0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).hasMinute(22);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<22> but was:<23>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").hasMinute(22);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<22> but was:<23>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toSecondTest() {
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toSecond().isEqualTo(47);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toSecond().isEqualTo(47);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toSecond().isEqualTo(46);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toSecond().isEqualTo(46);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).isNotNull().toSecond().isEqualTo(47);

        try {
            Raw.calendarAssertion().toSecond();
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toSecond();
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toSecond();
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toSecond()).isEqualTo(193);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's second.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toSecond()).isEqualTo(193);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's second.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toSecond().isEqualTo(46);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<46> but was:<47>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toSecond().isEqualTo(46);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<46> but was:<47>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toSecondMatcherTest() {
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toSecond(Matchers.is(Matchers.equalTo(47)));
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toSecond(Matchers.is(Matchers.equalTo(47)));
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toSecond(Matchers.is(Matchers.equalTo(46)));
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toSecond(Matchers.is(Matchers.equalTo(46)));
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).isNotNull().toSecond(Matchers.is(Matchers.equalTo(47))).isInstanceOf(Calendar.class);

        try {
            Raw.calendarAssertion().toSecond(Matchers.equalTo(0));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toSecond(Matchers.equalTo(0));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toSecond(Matchers.equalTo(0));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toSecond(null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toSecond(null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toSecond(null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toSecond(null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toSecond(Matchers.is(Matchers.equalTo(46)));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's second.\nExpected: is <46>\n     but: was <47>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toSecond(Matchers.is(Matchers.equalTo(46)));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's second.\nExpected: is <46>\n     but: was <47>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasSecondTest() {
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).hasSecond(47);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).hasSecond(47);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).hasSecond(46);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).hasSecond(46);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).isNotNull().hasSecond(47).isInstanceOf(Calendar.class);

        try {
            Raw.calendarAssertion().hasSecond(0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).hasSecond(0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").hasSecond(0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).hasSecond(46);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<46> but was:<47>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").hasSecond(46);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<46> but was:<47>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toMillisecondTest() {
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toMillisecond().isEqualTo(0);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toMillisecond().isEqualTo(0);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toMillisecond().isEqualTo(543);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toMillisecond().isEqualTo(543);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).isNotNull().toMillisecond().isEqualTo(0);

        try {
            Raw.calendarAssertion().toMillisecond();
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toMillisecond();
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toMillisecond();
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toMillisecond()).isEqualTo(193);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's millisecond.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toMillisecond()).isEqualTo(193);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's millisecond.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 543)).toMillisecond().isEqualTo(544);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's millisecond.\n\tActual and expected values should be the same.\n\tExpected:<544> but was:<543>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 543), "Message").toMillisecond().isEqualTo(544);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's millisecond.\n\tActual and expected values should be the same.\n\tExpected:<544> but was:<543>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toMillisecondMatcherTest() {
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toMillisecond(Matchers.is(Matchers.equalTo(0)));
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toMillisecond(Matchers.is(Matchers.equalTo(0)));
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toMillisecond(Matchers.is(Matchers.equalTo(543)));
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toMillisecond(Matchers.is(Matchers.equalTo(543)));
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).isNotNull().toMillisecond(Matchers.is(Matchers.equalTo(0))).isInstanceOf(Calendar.class);

        try {
            Raw.calendarAssertion().toMillisecond(Matchers.equalTo(0));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toMillisecond(Matchers.equalTo(0));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toMillisecond(Matchers.equalTo(0));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toMillisecond(null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toMillisecond(null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toMillisecond(null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toMillisecond(null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 543)).toMillisecond(Matchers.is(Matchers.equalTo(544)));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's millisecond.\nExpected: is <544>\n     but: was <543>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 543), "Message").toMillisecond(Matchers.is(Matchers.equalTo(544)));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's millisecond.\nExpected: is <544>\n     but: was <543>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasMillisecondTest() {
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).hasMillisecond(0);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).hasMillisecond(0);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).hasMillisecond(543);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).hasMillisecond(543);
        initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).isNotNull().hasMillisecond(0).isInstanceOf(Calendar.class);

        try {
            Raw.calendarAssertion().hasMillisecond(0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).hasMillisecond(0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").hasMillisecond(0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 543)).hasMillisecond(544);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's millisecond.\n\tActual and expected values should be the same.\n\tExpected:<544> but was:<543>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 543), "Message").hasMillisecond(544);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's millisecond.\n\tActual and expected values should be the same.\n\tExpected:<544> but was:<543>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toZoneOffsetTest() {
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).toZoneOffset().isEqualTo(0);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC")).toZoneOffset().isEqualTo(0);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC")).toZoneOffset().isEqualTo(0);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).toZoneOffset().isEqualTo(0);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).toZoneOffset().isEqualTo(7 * 60 * 60 * 1000);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane")).toZoneOffset().isEqualTo(7 * 60 * 60 * 1000);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane")).toZoneOffset().isEqualTo(7 * 60 * 60 * 1000);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).toZoneOffset().isEqualTo(7 * 60 * 60 * 1000);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).toZoneOffset().isEqualTo(60 * 60 * 1000);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin")).toZoneOffset().isEqualTo(60 * 60 * 1000);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin")).toZoneOffset().isEqualTo(60 * 60 * 1000);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin")).toZoneOffset().isEqualTo(60 * 60 * 1000);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotNull().toZoneOffset().isEqualTo(0);

        try {
            Raw.calendarAssertion().toZoneOffset();
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toZoneOffset();
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toZoneOffset();
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).toZoneOffset()).isEqualTo(100);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's zone offset.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").toZoneOffset()).isEqualTo(100);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's zone offset.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 543, "UTC")).toZoneOffset().isEqualTo(100);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's zone offset.\n\tActual and expected values should be the same.\n\tExpected:<100> but was:<0>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 543, "UTC"), "Message").toZoneOffset().isEqualTo(100);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's zone offset.\n\tActual and expected values should be the same.\n\tExpected:<100> but was:<0>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toZoneOffsetMatcherTest() {
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).toZoneOffset(Matchers.is(Matchers.equalTo(0)));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC")).toZoneOffset(Matchers.is(Matchers.equalTo(0)));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC")).toZoneOffset(Matchers.is(Matchers.equalTo(0)));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).toZoneOffset(Matchers.is(Matchers.equalTo(0)));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).toZoneOffset(Matchers.is(Matchers.equalTo(7 * 60 * 60 * 1000)));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane")).toZoneOffset(Matchers.is(Matchers.equalTo(7 * 60 * 60 * 1000)));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane")).toZoneOffset(Matchers.is(Matchers.equalTo(7 * 60 * 60 * 1000)));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).toZoneOffset(Matchers.is(Matchers.equalTo(7 * 60 * 60 * 1000)));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).toZoneOffset(Matchers.is(Matchers.equalTo(60 * 60 * 1000)));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin")).toZoneOffset(Matchers.is(Matchers.equalTo(60 * 60 * 1000)));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin")).toZoneOffset(Matchers.is(Matchers.equalTo(60 * 60 * 1000)));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin")).toZoneOffset(Matchers.is(Matchers.equalTo(60 * 60 * 1000)));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotNull().toZoneOffset(Matchers.is(Matchers.equalTo(0))).isInstanceOf(Calendar.class);

        try {
            Raw.calendarAssertion().toZoneOffset(Matchers.equalTo(0));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toZoneOffset(Matchers.equalTo(0));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toZoneOffset(Matchers.equalTo(0));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toZoneOffset(null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toZoneOffset(null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).toZoneOffset(null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").toZoneOffset(null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 543, "UTC")).toZoneOffset(Matchers.is(Matchers.equalTo(100)));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's zone offset.\nExpected: is <100>\n     but: was <0>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 543, "UTC"), "Message").toZoneOffset(Matchers.is(Matchers.equalTo(100)));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's zone offset.\nExpected: is <100>\n     but: was <0>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasZoneOffsetTest() {
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasZoneOffset(0);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC")).hasZoneOffset(0);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC")).hasZoneOffset(0);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).hasZoneOffset(0);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).hasZoneOffset(7 * 60 * 60 * 1000);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane")).hasZoneOffset(7 * 60 * 60 * 1000);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasZoneOffset(7 * 60 * 60 * 1000);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasZoneOffset(7 * 60 * 60 * 1000);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).hasZoneOffset(60 * 60 * 1000);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin")).hasZoneOffset(60 * 60 * 1000);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin")).hasZoneOffset(60 * 60 * 1000);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin")).hasZoneOffset(60 * 60 * 1000);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotNull().hasZoneOffset(0).isInstanceOf(Calendar.class);

        try {
            Raw.calendarAssertion().hasZoneOffset(0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).hasZoneOffset(0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").hasZoneOffset(0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 543, "UTC")).hasZoneOffset(100);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's zone offset.\n\tActual and expected values should be the same.\n\tExpected:<100> but was:<0>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 543, "UTC"), "Message").hasZoneOffset(100);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's zone offset.\n\tActual and expected values should be the same.\n\tExpected:<100> but was:<0>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toDstOffsetTest() {
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).toDstOffset().isEqualTo(0);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC")).toDstOffset().isEqualTo(0);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC")).toDstOffset().isEqualTo(0);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).toDstOffset().isEqualTo(0);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).toDstOffset().isEqualTo(0);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane")).toDstOffset().isEqualTo(0);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane")).toDstOffset().isEqualTo(0);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).toDstOffset().isEqualTo(0);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).toDstOffset().isEqualTo(60 * 60 * 1000);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin")).toDstOffset().isEqualTo(0);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin")).toDstOffset().isEqualTo(0);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin")).toDstOffset().isEqualTo(0);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotNull().toDstOffset().isEqualTo(0);

        try {
            Raw.calendarAssertion().toDstOffset();
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toDstOffset();
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toDstOffset();
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).toDstOffset()).isEqualTo(100);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's DST offset.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").toDstOffset()).isEqualTo(100);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's DST offset.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 543, "UTC")).toDstOffset().isEqualTo(100);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's DST offset.\n\tActual and expected values should be the same.\n\tExpected:<100> but was:<0>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 543, "UTC"), "Message").toDstOffset().isEqualTo(100);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's DST offset.\n\tActual and expected values should be the same.\n\tExpected:<100> but was:<0>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toDstOffsetMatcherTest() {
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).toDstOffset(Matchers.is(Matchers.equalTo(0)));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC")).toDstOffset(Matchers.is(Matchers.equalTo(0)));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC")).toDstOffset(Matchers.is(Matchers.equalTo(0)));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).toDstOffset(Matchers.is(Matchers.equalTo(0)));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).toDstOffset(Matchers.is(Matchers.equalTo(0)));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane")).toDstOffset(Matchers.is(Matchers.equalTo(0)));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane")).toDstOffset(Matchers.is(Matchers.equalTo(0)));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).toDstOffset(Matchers.is(Matchers.equalTo(0)));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).toDstOffset(Matchers.is(Matchers.equalTo(60 * 60 * 1000)));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin")).toDstOffset(Matchers.is(Matchers.equalTo(0)));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin")).toDstOffset(Matchers.is(Matchers.equalTo(0)));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin")).toDstOffset(Matchers.is(Matchers.equalTo(0)));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotNull().toDstOffset(Matchers.is(Matchers.equalTo(0))).isInstanceOf(Calendar.class);

        try {
            Raw.calendarAssertion().toDstOffset(Matchers.equalTo(0));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toDstOffset(Matchers.equalTo(0));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toDstOffset(Matchers.equalTo(0));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toDstOffset(null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toDstOffset(null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).toDstOffset(null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").toDstOffset(null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 543, "UTC")).toDstOffset(Matchers.is(Matchers.equalTo(100)));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's DST offset.\nExpected: is <100>\n     but: was <0>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 543, "UTC"), "Message").toDstOffset(Matchers.is(Matchers.equalTo(100)));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's DST offset.\nExpected: is <100>\n     but: was <0>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasDstOffsetTest() {
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasDstOffset(0);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC")).hasDstOffset(0);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC")).hasDstOffset(0);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).hasDstOffset(0);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).hasDstOffset(0);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane")).hasDstOffset(0);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasDstOffset(0);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasDstOffset(0);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).hasDstOffset(60 * 60 * 1000);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin")).hasDstOffset(0);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin")).hasDstOffset(0);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin")).hasDstOffset(0);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotNull().hasDstOffset(0).isInstanceOf(Calendar.class);

        try {
            Raw.calendarAssertion().hasDstOffset(0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).hasDstOffset(0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").hasDstOffset(0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 543, "UTC")).hasDstOffset(100);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's DST offset.\n\tActual and expected values should be the same.\n\tExpected:<100> but was:<0>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 543, "UTC"), "Message").hasDstOffset(100);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's DST offset.\n\tActual and expected values should be the same.\n\tExpected:<100> but was:<0>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toTimeZoneTest() {
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).toTimeZone().isEqualTo(TimeZone.getTimeZone("UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC")).toTimeZone().isEqualTo(TimeZone.getTimeZone("UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC")).toTimeZone().isEqualTo(TimeZone.getTimeZone("UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).toTimeZone().isEqualTo(TimeZone.getTimeZone("UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).toTimeZone().isEqualTo(TimeZone.getTimeZone("Asia/Vientiane"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane")).toTimeZone().isEqualTo(TimeZone.getTimeZone("Asia/Vientiane"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane")).toTimeZone().isEqualTo(TimeZone.getTimeZone("Asia/Vientiane"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).toTimeZone().isEqualTo(TimeZone.getTimeZone("Asia/Vientiane"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).toTimeZone().isEqualTo(TimeZone.getTimeZone("Europe/Berlin"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin")).toTimeZone().isEqualTo(TimeZone.getTimeZone("Europe/Berlin"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin")).toTimeZone().isEqualTo(TimeZone.getTimeZone("Europe/Berlin"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin")).toTimeZone().isEqualTo(TimeZone.getTimeZone("Europe/Berlin"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotNull().toTimeZone().isEqualTo(TimeZone.getTimeZone("UTC"));

        try {
            Raw.calendarAssertion().toTimeZone();
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toTimeZone();
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toTimeZone();
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).toTimeZone()).isEqualTo(TimeZone.getTimeZone("UTC"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's time zone.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").toTimeZone()).isEqualTo(TimeZone.getTimeZone("UTCn"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's time zone.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 543, "UTC")).toTimeZone().isEqualTo(TimeZone.getTimeZone("Europe/Berlin"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's time zone.\n\tActual and expected values should be the same.\n\tExpected:<Europe/Berlin> but was:<UTC>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 543, "UTC"), "Message").toTimeZone().isEqualTo(TimeZone.getTimeZone("Europe/Berlin"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's time zone.\n\tActual and expected values should be the same.\n\tExpected:<Europe/Berlin> but was:<UTC>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toTimeZoneMatcherTest() {
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).toTimeZone(Matchers.is(Matchers.equalTo(TimeZone.getTimeZone("UTC"))));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC")).toTimeZone(Matchers.is(Matchers.equalTo(TimeZone.getTimeZone("UTC"))));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC")).toTimeZone(Matchers.is(Matchers.equalTo(TimeZone.getTimeZone("UTC"))));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).toTimeZone(Matchers.is(Matchers.equalTo(TimeZone.getTimeZone("UTC"))));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).toTimeZone(Matchers.is(Matchers.equalTo(TimeZone.getTimeZone("Asia/Vientiane"))));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane")).toTimeZone(Matchers.is(Matchers.equalTo(TimeZone.getTimeZone("Asia/Vientiane"))));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane")).toTimeZone(Matchers.is(Matchers.equalTo(TimeZone.getTimeZone("Asia/Vientiane"))));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).toTimeZone(Matchers.is(Matchers.equalTo(TimeZone.getTimeZone("Asia/Vientiane"))));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).toTimeZone(Matchers.is(Matchers.equalTo(TimeZone.getTimeZone("Europe/Berlin"))));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin")).toTimeZone(Matchers.is(Matchers.equalTo(TimeZone.getTimeZone("Europe/Berlin"))));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin")).toTimeZone(Matchers.is(Matchers.equalTo(TimeZone.getTimeZone("Europe/Berlin"))));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin")).toTimeZone(Matchers.is(Matchers.equalTo(TimeZone.getTimeZone("Europe/Berlin"))));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotNull().toTimeZone(Matchers.is(Matchers.equalTo(TimeZone.getTimeZone("UTC")))).isInstanceOf(Calendar.class);

        try {
            Raw.calendarAssertion().toTimeZone(Matchers.equalTo(TimeZone.getTimeZone("UTC")));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toTimeZone(Matchers.equalTo(TimeZone.getTimeZone("UTC")));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toTimeZone(Matchers.equalTo(TimeZone.getTimeZone("UTC")));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toTimeZone(null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toTimeZone(null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).toTimeZone(null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").toTimeZone(null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 543, "UTC")).toTimeZone(Matchers.is(Matchers.equalTo(TimeZone.getTimeZone("Europe/Berlin"))));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Check actual value's time zone.\nExpected: is <.*>\n     but: was <.*>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 543, "UTC"), "Message").toTimeZone(Matchers.is(Matchers.equalTo(TimeZone.getTimeZone("Europe/Berlin"))));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Message.\n\tCheck actual value's time zone.\nExpected: is <.*>\n     but: was <.*>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasTimeZoneTest() {
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasTimeZone(TimeZone.getTimeZone("UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC")).hasTimeZone(TimeZone.getTimeZone("UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC")).hasTimeZone(TimeZone.getTimeZone("UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).hasTimeZone(TimeZone.getTimeZone("UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).hasTimeZone(TimeZone.getTimeZone("Asia/Vientiane"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane")).hasTimeZone(TimeZone.getTimeZone("Asia/Vientiane"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasTimeZone(TimeZone.getTimeZone("Asia/Vientiane"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasTimeZone(TimeZone.getTimeZone("Asia/Vientiane"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).hasTimeZone(TimeZone.getTimeZone("Europe/Berlin"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin")).hasTimeZone(TimeZone.getTimeZone("Europe/Berlin"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin")).hasTimeZone(TimeZone.getTimeZone("Europe/Berlin"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin")).hasTimeZone(TimeZone.getTimeZone("Europe/Berlin"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotNull().hasTimeZone(TimeZone.getTimeZone("UTC")).isInstanceOf(Calendar.class);

        try {
            Raw.calendarAssertion().hasTimeZone(TimeZone.getTimeZone("UTC"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).hasTimeZone(TimeZone.getTimeZone("UTC"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").hasTimeZone(TimeZone.getTimeZone("UTC"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 543, "UTC")).hasTimeZone(TimeZone.getTimeZone("Europe/Berlin"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's time zone.\n\tActual and expected values should be the same.\n\tExpected:<Europe/Berlin> but was:<UTC>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 543, "UTC"), "Message").hasTimeZone(TimeZone.getTimeZone("Europe/Berlin"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's time zone.\n\tActual and expected values should be the same.\n\tExpected:<Europe/Berlin> but was:<UTC>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasTimeZoneIdTest() {
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasTimeZoneId("UTC");
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC")).hasTimeZoneId("UTC");
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC")).hasTimeZoneId("UTC");
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).hasTimeZoneId("UTC");
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).hasTimeZoneId("Asia/Vientiane");
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane")).hasTimeZoneId("Asia/Vientiane");
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasTimeZoneId("Asia/Vientiane");
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasTimeZoneId("Asia/Vientiane");
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).hasTimeZoneId("Europe/Berlin");
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin")).hasTimeZoneId("Europe/Berlin");
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin")).hasTimeZoneId("Europe/Berlin");
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin")).hasTimeZoneId("Europe/Berlin");
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotNull().hasTimeZoneId("UTC").isInstanceOf(Calendar.class);

        try {
            Raw.calendarAssertion().hasTimeZoneId("UTC");
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).hasTimeZoneId("UTC");
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").hasTimeZoneId("UTC");
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 543, "UTC")).hasTimeZoneId("Europe/Berlin");
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's time zone.\n\tCheck actual value's ID.\n\tActual and expected values should be the same.\n\tExpected:<Europe/Berlin> but was:<UTC>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 543, "UTC"), "Message").hasTimeZoneId("Europe/Berlin");
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's time zone.\n\tCheck actual value's ID.\n\tActual and expected values should be the same.\n\tExpected:<Europe/Berlin> but was:<UTC>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasDateTest() {
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasDate(2020, Calendar.JULY, 11);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC")).hasDate(2020, Calendar.DECEMBER, 11);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC")).hasDate(1324, Calendar.JULY, 21);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).hasDate(1324, Calendar.DECEMBER, 21);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).hasDate(2020, Calendar.JULY, 11);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane")).hasDate(2020, Calendar.DECEMBER, 11);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasDate(1324, Calendar.JULY, 21);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasDate(1324, Calendar.DECEMBER, 21);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).hasDate(2020, Calendar.JULY, 11);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin")).hasDate(2020, Calendar.DECEMBER, 11);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin")).hasDate(1324, Calendar.JULY, 21);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin")).hasDate(1324, Calendar.DECEMBER, 21);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotNull().hasDate(2020, Calendar.JULY, 11).isInstanceOf(Calendar.class);

        try {
            Raw.calendarAssertion().hasDate(1, 1, 1);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).hasDate(1, 1, 1);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").hasDate(1, 1, 1);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasDate(2019, Calendar.JULY, 11);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's year.\n\tActual and expected values should be the same.\n\tExpected:<2019> but was:<2020>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasDate(2019, Calendar.JULY, 11);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's year.\n\tActual and expected values should be the same.\n\tExpected:<2019> but was:<2020>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasDate(2020, Calendar.AUGUST, 11);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's month.\n\tActual and expected values should be the same.\n\tExpected:<7> but was:<6>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasDate(2020, Calendar.AUGUST, 11);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's month.\n\tActual and expected values should be the same.\n\tExpected:<7> but was:<6>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasDate(2020, Calendar.JULY, 12);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's day of month.\n\tActual and expected values should be the same.\n\tExpected:<12> but was:<11>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasDate(2020, Calendar.JULY, 12);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's day of month.\n\tActual and expected values should be the same.\n\tExpected:<12> but was:<11>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasTimeZoneDateTimeZoneIdTest() {
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasTimeZoneDate(2020, Calendar.JULY, 11, "UTC");
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC")).hasTimeZoneDate(2020, Calendar.DECEMBER, 11, "UTC");
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC")).hasTimeZoneDate(1324, Calendar.JULY, 21, "UTC");
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).hasTimeZoneDate(1324, Calendar.DECEMBER, 21, "UTC");
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).hasTimeZoneDate(2020, Calendar.JULY, 11, "Asia/Vientiane");
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane")).hasTimeZoneDate(2020, Calendar.DECEMBER, 11, "Asia/Vientiane");
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasTimeZoneDate(1324, Calendar.JULY, 21, "Asia/Vientiane");
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasTimeZoneDate(1324, Calendar.DECEMBER, 21, "Asia/Vientiane");
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).hasTimeZoneDate(2020, Calendar.JULY, 11, "Europe/Berlin");
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin")).hasTimeZoneDate(2020, Calendar.DECEMBER, 11, "Europe/Berlin");
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin")).hasTimeZoneDate(1324, Calendar.JULY, 21, "Europe/Berlin");
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin")).hasTimeZoneDate(1324, Calendar.DECEMBER, 21, "Europe/Berlin");
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotNull().hasTimeZoneDate(2020, Calendar.JULY, 11, "UTC").isInstanceOf(Calendar.class);

        try {
            Raw.calendarAssertion().hasTimeZoneDate(1, 1, 1, "UTC");
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).hasTimeZoneDate(1, 1, 1, "UTC");
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").hasTimeZoneDate(1, 1, 1, "UTC");
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasTimeZoneDate(2019, Calendar.JULY, 11, "UTC");
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's year.\n\tActual and expected values should be the same.\n\tExpected:<2019> but was:<2020>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasTimeZoneDate(2019, Calendar.JULY, 11, "UTC");
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's year.\n\tActual and expected values should be the same.\n\tExpected:<2019> but was:<2020>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasTimeZoneDate(2020, Calendar.AUGUST, 11, "UTC");
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's month.\n\tActual and expected values should be the same.\n\tExpected:<7> but was:<6>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasTimeZoneDate(2020, Calendar.AUGUST, 11, "UTC");
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's month.\n\tActual and expected values should be the same.\n\tExpected:<7> but was:<6>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasTimeZoneDate(2020, Calendar.JULY, 12, "UTC");
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's day of month.\n\tActual and expected values should be the same.\n\tExpected:<12> but was:<11>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasTimeZoneDate(2020, Calendar.JULY, 12, "UTC");
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's day of month.\n\tActual and expected values should be the same.\n\tExpected:<12> but was:<11>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasTimeZoneDate(2020, Calendar.JULY, 11, "Europe/Berlin");
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's time zone.\n\tCheck actual value's ID.\n\tActual and expected values should be the same.\n\tExpected:<Europe/Berlin> but was:<UTC>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasTimeZoneDate(2020, Calendar.JULY, 11, "Europe/Berlin");
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's time zone.\n\tCheck actual value's ID.\n\tActual and expected values should be the same.\n\tExpected:<Europe/Berlin> but was:<UTC>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasTimeZoneDateZoneOffsetTest() {
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasTimeZoneDate(2020, Calendar.JULY, 11, 0);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC")).hasTimeZoneDate(2020, Calendar.DECEMBER, 11, 0);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC")).hasTimeZoneDate(1324, Calendar.JULY, 21, 0);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).hasTimeZoneDate(1324, Calendar.DECEMBER, 21, 0);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).hasTimeZoneDate(2020, Calendar.JULY, 11, 7 * 60 * 60 * 1000);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane")).hasTimeZoneDate(2020, Calendar.DECEMBER, 11, 7 * 60 * 60 * 1000);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasTimeZoneDate(1324, Calendar.JULY, 21, 7 * 60 * 60 * 1000);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasTimeZoneDate(1324, Calendar.DECEMBER, 21, 7 * 60 * 60 * 1000);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).hasTimeZoneDate(2020, Calendar.JULY, 11, 60 * 60 * 1000);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin")).hasTimeZoneDate(2020, Calendar.DECEMBER, 11, 60 * 60 * 1000);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin")).hasTimeZoneDate(1324, Calendar.JULY, 21, 60 * 60 * 1000);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin")).hasTimeZoneDate(1324, Calendar.DECEMBER, 21, 60 * 60 * 1000);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotNull().hasTimeZoneDate(2020, Calendar.JULY, 11, 0).isInstanceOf(Calendar.class);

        try {
            Raw.calendarAssertion().hasTimeZoneDate(1, 1, 1, 0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).hasTimeZoneDate(1, 1, 1, 0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").hasTimeZoneDate(1, 1, 1, 0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasTimeZoneDate(2019, Calendar.JULY, 11, 0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's year.\n\tActual and expected values should be the same.\n\tExpected:<2019> but was:<2020>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasTimeZoneDate(2019, Calendar.JULY, 11, 0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's year.\n\tActual and expected values should be the same.\n\tExpected:<2019> but was:<2020>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasTimeZoneDate(2020, Calendar.AUGUST, 11, 0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's month.\n\tActual and expected values should be the same.\n\tExpected:<7> but was:<6>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasTimeZoneDate(2020, Calendar.AUGUST, 11, 0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's month.\n\tActual and expected values should be the same.\n\tExpected:<7> but was:<6>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasTimeZoneDate(2020, Calendar.JULY, 12, 0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's day of month.\n\tActual and expected values should be the same.\n\tExpected:<12> but was:<11>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasTimeZoneDate(2020, Calendar.JULY, 12, 0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's day of month.\n\tActual and expected values should be the same.\n\tExpected:<12> but was:<11>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasTimeZoneDate(2020, Calendar.JULY, 11, 60 * 60 * 1000);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's zone offset.\n\tActual and expected values should be the same.\n\tExpected:<3600000> but was:<0>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasTimeZoneDate(2020, Calendar.JULY, 11, 60 * 60 * 1000);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's zone offset.\n\tActual and expected values should be the same.\n\tExpected:<3600000> but was:<0>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasUtcDateTest() {
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasUtcDate(2020, Calendar.JULY, 11);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC")).hasUtcDate(2020, Calendar.DECEMBER, 11);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC")).hasUtcDate(1324, Calendar.JULY, 21);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).hasUtcDate(1324, Calendar.DECEMBER, 21);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).hasUtcDate(2020, Calendar.JULY, 11);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane")).hasUtcDate(2020, Calendar.DECEMBER, 11);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasUtcDate(1324, Calendar.JULY, 20);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasUtcDate(1324, Calendar.DECEMBER, 20);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).hasUtcDate(2020, Calendar.JULY, 11);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin")).hasUtcDate(2020, Calendar.DECEMBER, 11);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin")).hasUtcDate(1324, Calendar.JULY, 21);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin")).hasUtcDate(1324, Calendar.DECEMBER, 21);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotNull().hasUtcDate(2020, Calendar.JULY, 11).isInstanceOf(Calendar.class);

        try {
            Raw.calendarAssertion().hasUtcDate(1, 1, 1);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).hasUtcDate(1, 1, 1);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").hasUtcDate(1, 1, 1);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).hasUtcDate(2019, Calendar.JULY, 11);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's date in time zone: UTC.\n\tCheck actual value's year.\n\tActual and expected values should be the same.\n\tExpected:<2019> but was:<2020>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin"), "Message").hasUtcDate(2019, Calendar.JULY, 11);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's date in time zone: UTC.\n\tCheck actual value's year.\n\tActual and expected values should be the same.\n\tExpected:<2019> but was:<2020>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).hasUtcDate(2020, Calendar.AUGUST, 11);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's date in time zone: UTC.\n\tCheck actual value's month.\n\tActual and expected values should be the same.\n\tExpected:<7> but was:<6>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin"), "Message").hasUtcDate(2020, Calendar.AUGUST, 11);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's date in time zone: UTC.\n\tCheck actual value's month.\n\tActual and expected values should be the same.\n\tExpected:<7> but was:<6>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).hasUtcDate(2020, Calendar.JULY, 12);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's date in time zone: UTC.\n\tCheck actual value's day of month.\n\tActual and expected values should be the same.\n\tExpected:<12> but was:<11>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin"), "Message").hasUtcDate(2020, Calendar.JULY, 12);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's date in time zone: UTC.\n\tCheck actual value's day of month.\n\tActual and expected values should be the same.\n\tExpected:<12> but was:<11>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasTimeTest() {
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasTime(15, 23, 47);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC")).hasTime(15, 23, 47);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC")).hasTime(3, 22, 46);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).hasTime(3, 22, 46);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).hasTime(15, 23, 47);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane")).hasTime(15, 23, 47);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasTime(3, 22, 46);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasTime(3, 22, 46);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).hasTime(15, 23, 47);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin")).hasTime(15, 23, 47);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin")).hasTime(3, 22, 46);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin")).hasTime(3, 22, 46);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotNull().hasTime(15, 23, 47).isInstanceOf(Calendar.class);

        try {
            Raw.calendarAssertion().hasTime(1, 1, 1);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).hasTime(1, 1, 1);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").hasTime(1, 1, 1);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasTime(16, 23, 47);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<16> but was:<15>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasTime(16, 23, 47);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<16> but was:<15>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasTime(15, 22, 47);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<22> but was:<23>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasTime(15, 22, 47);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<22> but was:<23>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasTime(15, 23, 45);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<45> but was:<47>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasTime(15, 23, 45);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<45> but was:<47>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasTimeMillisecondTest() {
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasTime(15, 23, 47, 0);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC")).hasTime(15, 23, 47, 0);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC")).hasTime(3, 22, 46, 543);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).hasTime(3, 22, 46, 543);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).hasTime(15, 23, 47, 0);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane")).hasTime(15, 23, 47, 0);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasTime(3, 22, 46, 543);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasTime(3, 22, 46, 543);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).hasTime(15, 23, 47, 0);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin")).hasTime(15, 23, 47, 0);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin")).hasTime(3, 22, 46, 543);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin")).hasTime(3, 22, 46, 543);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotNull().hasTime(15, 23, 47, 0).isInstanceOf(Calendar.class);

        try {
            Raw.calendarAssertion().hasTime(1, 1, 1, 1);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).hasTime(1, 1, 1, 1);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").hasTime(1, 1, 1, 1);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasTime(16, 23, 47, 345);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<16> but was:<15>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasTime(16, 23, 47, 345);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<16> but was:<15>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasTime(15, 22, 47, 345);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<22> but was:<23>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasTime(15, 22, 47, 345);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<22> but was:<23>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasTime(15, 23, 45, 345);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<45> but was:<47>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasTime(15, 23, 45, 345);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<45> but was:<47>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasTime(15, 23, 47, 555);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's millisecond.\n\tActual and expected values should be the same.\n\tExpected:<555> but was:<345>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasTime(15, 23, 47, 555);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's millisecond.\n\tActual and expected values should be the same.\n\tExpected:<555> but was:<345>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasTimeZoneTimeTimeZoneIdTest() {
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasTimeZoneTime(15, 23, 47, "UTC");
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC")).hasTimeZoneTime(15, 23, 47, "UTC");
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC")).hasTimeZoneTime(3, 22, 46, "UTC");
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).hasTimeZoneTime(3, 22, 46, "UTC");
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).hasTimeZoneTime(15, 23, 47, "Asia/Vientiane");
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane")).hasTimeZoneTime(15, 23, 47, "Asia/Vientiane");
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasTimeZoneTime(3, 22, 46, "Asia/Vientiane");
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasTimeZoneTime(3, 22, 46, "Asia/Vientiane");
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).hasTimeZoneTime(15, 23, 47, "Europe/Berlin");
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin")).hasTimeZoneTime(15, 23, 47, "Europe/Berlin");
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin")).hasTimeZoneTime(3, 22, 46, "Europe/Berlin");
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin")).hasTimeZoneTime(3, 22, 46, "Europe/Berlin");
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotNull().hasTimeZoneTime(15, 23, 47, "UTC").isInstanceOf(Calendar.class);

        try {
            Raw.calendarAssertion().hasTimeZoneTime(1, 1, 1, "UTC");
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).hasTimeZoneTime(1, 1, 1, "UTC");
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").hasTimeZoneTime(1, 1, 1, "UTC");
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasTimeZoneTime(16, 23, 47, "UTC");
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<16> but was:<15>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasTimeZoneTime(16, 23, 47, "UTC");
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<16> but was:<15>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasTimeZoneTime(15, 22, 47, "UTC");
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<22> but was:<23>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasTimeZoneTime(15, 22, 47, "UTC");
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<22> but was:<23>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasTimeZoneTime(15, 23, 45, "UTC");
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<45> but was:<47>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasTimeZoneTime(15, 23, 45, "UTC");
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<45> but was:<47>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasTimeZoneTime(15, 23, 47, "Europe/Berlin");
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's time zone.\n\tCheck actual value's ID.\n\tActual and expected values should be the same.\n\tExpected:<Europe/Berlin> but was:<UTC>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasTimeZoneTime(15, 23, 47, "Europe/Berlin");
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's time zone.\n\tCheck actual value's ID.\n\tActual and expected values should be the same.\n\tExpected:<Europe/Berlin> but was:<UTC>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasTimeZoneTimeZoneOffsetTest() {
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasTimeZoneTime(15, 23, 47, 0);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC")).hasTimeZoneTime(15, 23, 47, 0);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC")).hasTimeZoneTime(3, 22, 46, 0);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).hasTimeZoneTime(3, 22, 46, 0);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).hasTimeZoneTime(15, 23, 47, 7 * 60 * 60 * 1000);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane")).hasTimeZoneTime(15, 23, 47, 7 * 60 * 60 * 1000);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasTimeZoneTime(3, 22, 46, 7 * 60 * 60 * 1000);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasTimeZoneTime(3, 22, 46, 7 * 60 * 60 * 1000);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).hasTimeZoneTime(15, 23, 47, 60 * 60 * 1000);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin")).hasTimeZoneTime(15, 23, 47, 60 * 60 * 1000);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin")).hasTimeZoneTime(3, 22, 46, 60 * 60 * 1000);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin")).hasTimeZoneTime(3, 22, 46, 60 * 60 * 1000);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotNull().hasTimeZoneTime(15, 23, 47, 0).isInstanceOf(Calendar.class);

        try {
            Raw.calendarAssertion().hasTimeZoneTime(1, 1, 1, 0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).hasTimeZoneTime(1, 1, 1, 0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").hasTimeZoneTime(1, 1, 1, 0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasTimeZoneTime(16, 23, 47, 0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<16> but was:<15>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasTimeZoneTime(16, 23, 47, 0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<16> but was:<15>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasTimeZoneTime(15, 22, 47, 0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<22> but was:<23>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasTimeZoneTime(15, 22, 47, 0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<22> but was:<23>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasTimeZoneTime(15, 23, 45, 0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<45> but was:<47>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasTimeZoneTime(15, 23, 45, 0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<45> but was:<47>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasTimeZoneTime(15, 23, 47, 60 * 60 * 1000);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's zone offset.\n\tActual and expected values should be the same.\n\tExpected:<3600000> but was:<0>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasTimeZoneTime(15, 23, 47, 60 * 60 * 1000);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's zone offset.\n\tActual and expected values should be the same.\n\tExpected:<3600000> but was:<0>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasTimeZoneTimeMillisecondTimeZoneIdTest() {
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasTimeZoneTime(15, 23, 47, 0, "UTC");
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC")).hasTimeZoneTime(15, 23, 47, 0, "UTC");
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC")).hasTimeZoneTime(3, 22, 46, 543, "UTC");
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).hasTimeZoneTime(3, 22, 46, 543, "UTC");
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).hasTimeZoneTime(15, 23, 47, 0, "Asia/Vientiane");
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane")).hasTimeZoneTime(15, 23, 47, 0, "Asia/Vientiane");
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasTimeZoneTime(3, 22, 46, 543, "Asia/Vientiane");
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasTimeZoneTime(3, 22, 46, 543, "Asia/Vientiane");
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).hasTimeZoneTime(15, 23, 47, 0, "Europe/Berlin");
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin")).hasTimeZoneTime(15, 23, 47, 0, "Europe/Berlin");
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin")).hasTimeZoneTime(3, 22, 46, 543, "Europe/Berlin");
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin")).hasTimeZoneTime(3, 22, 46, 543, "Europe/Berlin");
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotNull().hasTimeZoneTime(15, 23, 47, 0, "UTC").isInstanceOf(Calendar.class);

        try {
            Raw.calendarAssertion().hasTimeZoneTime(1, 1, 1, 1, "UTC");
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).hasTimeZoneTime(1, 1, 1, 1, "UTC");
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").hasTimeZoneTime(1, 1, 1, 1, "UTC");
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasTimeZoneTime(16, 23, 47, 345, "UTC");
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<16> but was:<15>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasTimeZoneTime(16, 23, 47, 345, "UTC");
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<16> but was:<15>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasTimeZoneTime(15, 22, 47, 345, "UTC");
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<22> but was:<23>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasTimeZoneTime(15, 22, 47, 345, "UTC");
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<22> but was:<23>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasTimeZoneTime(15, 23, 45, 345, "UTC");
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<45> but was:<47>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasTimeZoneTime(15, 23, 45, 345, "UTC");
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<45> but was:<47>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasTimeZoneTime(15, 23, 47, 555, "UTC");
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's millisecond.\n\tActual and expected values should be the same.\n\tExpected:<555> but was:<345>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasTimeZoneTime(15, 23, 47, 555, "UTC");
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's millisecond.\n\tActual and expected values should be the same.\n\tExpected:<555> but was:<345>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasTimeZoneTime(15, 23, 47, 345, "Europe/Berlin");
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's time zone.\n\tCheck actual value's ID.\n\tActual and expected values should be the same.\n\tExpected:<Europe/Berlin> but was:<UTC>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasTimeZoneTime(15, 23, 47, 345, "Europe/Berlin");
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's time zone.\n\tCheck actual value's ID.\n\tActual and expected values should be the same.\n\tExpected:<Europe/Berlin> but was:<UTC>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasTimeZoneTimeMillisecondZoneOffsetTest() {
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasTimeZoneTime(15, 23, 47, 0, 0);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC")).hasTimeZoneTime(15, 23, 47, 0, 0);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC")).hasTimeZoneTime(3, 22, 46, 543, 0);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).hasTimeZoneTime(3, 22, 46, 543, 0);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).hasTimeZoneTime(15, 23, 47, 0, 7 * 60 * 60 * 1000);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane")).hasTimeZoneTime(15, 23, 47, 0, 7 * 60 * 60 * 1000);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasTimeZoneTime(3, 22, 46, 543, 7 * 60 * 60 * 1000);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasTimeZoneTime(3, 22, 46, 543, 7 * 60 * 60 * 1000);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).hasTimeZoneTime(15, 23, 47, 0, 60 * 60 * 1000);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin")).hasTimeZoneTime(15, 23, 47, 0, 60 * 60 * 1000);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin")).hasTimeZoneTime(3, 22, 46, 543, 60 * 60 * 1000);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin")).hasTimeZoneTime(3, 22, 46, 543, 60 * 60 * 1000);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotNull().hasTimeZoneTime(15, 23, 47, 0, 0).isInstanceOf(Calendar.class);

        try {
            Raw.calendarAssertion().hasTimeZoneTime(1, 1, 1, 1, 0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).hasTimeZoneTime(1, 1, 1, 1, 0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").hasTimeZoneTime(1, 1, 1, 1, 0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasTimeZoneTime(16, 23, 47, 345, 0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<16> but was:<15>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasTimeZoneTime(16, 23, 47, 345, 0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<16> but was:<15>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasTimeZoneTime(15, 22, 47, 345, 0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<22> but was:<23>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasTimeZoneTime(15, 22, 47, 345, 0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<22> but was:<23>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasTimeZoneTime(15, 23, 45, 345, 0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<45> but was:<47>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasTimeZoneTime(15, 23, 45, 345, 0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<45> but was:<47>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasTimeZoneTime(15, 23, 47, 555, 0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's millisecond.\n\tActual and expected values should be the same.\n\tExpected:<555> but was:<345>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasTimeZoneTime(15, 23, 47, 555, 0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's millisecond.\n\tActual and expected values should be the same.\n\tExpected:<555> but was:<345>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasTimeZoneTime(15, 23, 47, 345, 60 * 60 * 1000);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's zone offset.\n\tActual and expected values should be the same.\n\tExpected:<3600000> but was:<0>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasTimeZoneTime(15, 23, 47, 345, 60 * 60 * 1000);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's zone offset.\n\tActual and expected values should be the same.\n\tExpected:<3600000> but was:<0>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasUtcTimeTest() {
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasUtcTime(15, 23, 47);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC")).hasUtcTime(15, 23, 47);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC")).hasUtcTime(3, 22, 46);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).hasUtcTime(3, 22, 46);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).hasUtcTime(8, 23, 47);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane")).hasUtcTime(8, 23, 47);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasUtcTime(20, 22, 46);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasUtcTime(20, 22, 46);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).hasUtcTime(13, 23, 47);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin")).hasUtcTime(14, 23, 47);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin")).hasUtcTime(2, 22, 46);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin")).hasUtcTime(2, 22, 46);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotNull().hasUtcTime(15, 23, 47).isInstanceOf(Calendar.class);

        try {
            Raw.calendarAssertion().hasUtcTime(1, 1, 1);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).hasUtcTime(1, 1, 1);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").hasUtcTime(1, 1, 1);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).hasUtcTime(11, 23, 47);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's date in time zone: UTC.\n\tCheck actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<11> but was:<13>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin"), "Message").hasUtcTime(11, 23, 47);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's date in time zone: UTC.\n\tCheck actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<11> but was:<13>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).hasUtcTime(13, 22, 47);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's date in time zone: UTC.\n\tCheck actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<22> but was:<23>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin"), "Message").hasUtcTime(13, 22, 47);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's date in time zone: UTC.\n\tCheck actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<22> but was:<23>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).hasUtcTime(13, 23, 45);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's date in time zone: UTC.\n\tCheck actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<45> but was:<47>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin"), "Message").hasUtcTime(13, 23, 45);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's date in time zone: UTC.\n\tCheck actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<45> but was:<47>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasUtcTimeMillisecondTest() {
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasUtcTime(15, 23, 47, 0);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC")).hasUtcTime(15, 23, 47, 0);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC")).hasUtcTime(3, 22, 46, 543);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).hasUtcTime(3, 22, 46, 543);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).hasUtcTime(8, 23, 47, 0);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane")).hasUtcTime(8, 23, 47, 0);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasUtcTime(20, 22, 46, 543);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasUtcTime(20, 22, 46, 543);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).hasUtcTime(13, 23, 47, 0);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin")).hasUtcTime(14, 23, 47, 0);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin")).hasUtcTime(2, 22, 46, 543);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin")).hasUtcTime(2, 22, 46, 543);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotNull().hasUtcTime(15, 23, 47, 0).isInstanceOf(Calendar.class);

        try {
            Raw.calendarAssertion().hasUtcTime(1, 1, 1, 1);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).hasUtcTime(1, 1, 1, 1);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").hasUtcTime(1, 1, 1, 1);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin")).hasUtcTime(11, 23, 47, 345);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's date in time zone: UTC.\n\tCheck actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<11> but was:<13>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin"), "Message").hasUtcTime(11, 23, 47, 345);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's date in time zone: UTC.\n\tCheck actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<11> but was:<13>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin")).hasUtcTime(13, 22, 47, 345);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's date in time zone: UTC.\n\tCheck actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<22> but was:<23>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin"), "Message").hasUtcTime(13, 22, 47, 345);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's date in time zone: UTC.\n\tCheck actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<22> but was:<23>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin")).hasUtcTime(13, 23, 45, 345);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's date in time zone: UTC.\n\tCheck actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<45> but was:<47>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin"), "Message").hasUtcTime(13, 23, 45, 345);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's date in time zone: UTC.\n\tCheck actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<45> but was:<47>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin")).hasUtcTime(13, 23, 47, 555);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's date in time zone: UTC.\n\tCheck actual value's millisecond.\n\tActual and expected values should be the same.\n\tExpected:<555> but was:<345>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin"), "Message").hasUtcTime(13, 23, 47, 555);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's date in time zone: UTC.\n\tCheck actual value's millisecond.\n\tActual and expected values should be the same.\n\tExpected:<555> but was:<345>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasDateAndTimeTest() {
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC")).hasDateAndTime(2020, Calendar.DECEMBER, 11, 15, 23, 47);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC")).hasDateAndTime(1324, Calendar.JULY, 21, 3, 22, 46);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).hasDateAndTime(1324, Calendar.DECEMBER, 21, 3, 22, 46);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).hasDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane")).hasDateAndTime(2020, Calendar.DECEMBER, 11, 15, 23, 47);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasDateAndTime(1324, Calendar.JULY, 21, 3, 22, 46);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasDateAndTime(1324, Calendar.DECEMBER, 21, 3, 22, 46);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).hasDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin")).hasDateAndTime(2020, Calendar.DECEMBER, 11, 15, 23, 47);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin")).hasDateAndTime(1324, Calendar.JULY, 21, 3, 22, 46);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin")).hasDateAndTime(1324, Calendar.DECEMBER, 21, 3, 22, 46);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotNull().hasDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47).isInstanceOf(Calendar.class);

        try {
            Raw.calendarAssertion().hasDateAndTime(1, 1, 1, 1, 1, 1);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).hasDateAndTime(1, 1, 1, 1, 1, 1);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").hasDateAndTime(1, 1, 1, 1, 1, 1);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasDateAndTime(2019, Calendar.JULY, 11, 15, 23, 47);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's year.\n\tActual and expected values should be the same.\n\tExpected:<2019> but was:<2020>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasDateAndTime(2019, Calendar.JULY, 11, 15, 23, 47);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's year.\n\tActual and expected values should be the same.\n\tExpected:<2019> but was:<2020>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasDateAndTime(2020, Calendar.AUGUST, 11, 15, 23, 47);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's month.\n\tActual and expected values should be the same.\n\tExpected:<7> but was:<6>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasDateAndTime(2020, Calendar.AUGUST, 11, 15, 23, 47);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's month.\n\tActual and expected values should be the same.\n\tExpected:<7> but was:<6>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasDateAndTime(2020, Calendar.JULY, 12, 15, 23, 47);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's day of month.\n\tActual and expected values should be the same.\n\tExpected:<12> but was:<11>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasDateAndTime(2020, Calendar.JULY, 12, 15, 23, 47);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's day of month.\n\tActual and expected values should be the same.\n\tExpected:<12> but was:<11>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasDateAndTime(2020, Calendar.JULY, 11, 16, 23, 47);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<16> but was:<15>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasDateAndTime(2020, Calendar.JULY, 11, 16, 23, 47);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<16> but was:<15>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasDateAndTime(2020, Calendar.JULY, 11, 15, 24, 47);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<24> but was:<23>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasDateAndTime(2020, Calendar.JULY, 11, 15, 24, 47);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<24> but was:<23>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasDateAndTime(2020, Calendar.JULY, 11, 15, 23, 48);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<48> but was:<47>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasDateAndTime(2020, Calendar.JULY, 11, 15, 23, 48);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<48> but was:<47>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasDateAndTimeMillisecondTest() {
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, 0);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC")).hasDateAndTime(2020, Calendar.DECEMBER, 11, 15, 23, 47, 0);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC")).hasDateAndTime(1324, Calendar.JULY, 21, 3, 22, 46, 543);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).hasDateAndTime(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).hasDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, 0);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane")).hasDateAndTime(2020, Calendar.DECEMBER, 11, 15, 23, 47, 0);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasDateAndTime(1324, Calendar.JULY, 21, 3, 22, 46, 543);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasDateAndTime(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).hasDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, 0);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin")).hasDateAndTime(2020, Calendar.DECEMBER, 11, 15, 23, 47, 0);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin")).hasDateAndTime(1324, Calendar.JULY, 21, 3, 22, 46, 543);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin")).hasDateAndTime(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotNull().hasDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, 0).isInstanceOf(Calendar.class);

        try {
            Raw.calendarAssertion().hasDateAndTime(1, 1, 1, 1, 1, 1, 1);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).hasDateAndTime(1, 1, 1, 1, 1, 1, 1);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").hasDateAndTime(1, 1, 1, 1, 1, 1, 1);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasDateAndTime(2019, Calendar.JULY, 11, 15, 23, 47, 345);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's year.\n\tActual and expected values should be the same.\n\tExpected:<2019> but was:<2020>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasDateAndTime(2019, Calendar.JULY, 11, 15, 23, 47, 345);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's year.\n\tActual and expected values should be the same.\n\tExpected:<2019> but was:<2020>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasDateAndTime(2020, Calendar.AUGUST, 11, 15, 23, 47, 345);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's month.\n\tActual and expected values should be the same.\n\tExpected:<7> but was:<6>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasDateAndTime(2020, Calendar.AUGUST, 11, 15, 23, 47, 345);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's month.\n\tActual and expected values should be the same.\n\tExpected:<7> but was:<6>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasDateAndTime(2020, Calendar.JULY, 12, 15, 23, 47, 345);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's day of month.\n\tActual and expected values should be the same.\n\tExpected:<12> but was:<11>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasDateAndTime(2020, Calendar.JULY, 12, 15, 23, 47, 345);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's day of month.\n\tActual and expected values should be the same.\n\tExpected:<12> but was:<11>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasDateAndTime(2020, Calendar.JULY, 11, 16, 23, 47, 345);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<16> but was:<15>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasDateAndTime(2020, Calendar.JULY, 11, 16, 23, 47, 345);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<16> but was:<15>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasDateAndTime(2020, Calendar.JULY, 11, 15, 24, 47, 345);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<24> but was:<23>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasDateAndTime(2020, Calendar.JULY, 11, 15, 24, 47, 345);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<24> but was:<23>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasDateAndTime(2020, Calendar.JULY, 11, 15, 23, 48, 345);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<48> but was:<47>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasDateAndTime(2020, Calendar.JULY, 11, 15, 23, 48, 345);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<48> but was:<47>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, 555);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's millisecond.\n\tActual and expected values should be the same.\n\tExpected:<555> but was:<345>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, 555);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's millisecond.\n\tActual and expected values should be the same.\n\tExpected:<555> but was:<345>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasTimeZoneDateAndTimeTimeZoneIdTest() {
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasTimeZoneDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, "UTC");
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC")).hasTimeZoneDateAndTime(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC");
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC")).hasTimeZoneDateAndTime(1324, Calendar.JULY, 21, 3, 22, 46, "UTC");
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).hasTimeZoneDateAndTime(1324, Calendar.DECEMBER, 21, 3, 22, 46, "UTC");
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).hasTimeZoneDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane");
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane")).hasTimeZoneDateAndTime(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane");
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasTimeZoneDateAndTime(1324, Calendar.JULY, 21, 3, 22, 46, "Asia/Vientiane");
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasTimeZoneDateAndTime(1324, Calendar.DECEMBER, 21, 3, 22, 46, "Asia/Vientiane");
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).hasTimeZoneDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin");
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin")).hasTimeZoneDateAndTime(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin");
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin")).hasTimeZoneDateAndTime(1324, Calendar.JULY, 21, 3, 22, 46, "Europe/Berlin");
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin")).hasTimeZoneDateAndTime(1324, Calendar.DECEMBER, 21, 3, 22, 46, "Europe/Berlin");
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotNull().hasTimeZoneDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, "UTC").isInstanceOf(Calendar.class);

        try {
            Raw.calendarAssertion().hasTimeZoneDateAndTime(1, 1, 1, 1, 1, 1, "UTC");
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).hasTimeZoneDateAndTime(1, 1, 1, 1, 1, 1, "UTC");
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").hasTimeZoneDateAndTime(1, 1, 1, 1, 1, 1, "UTC");
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasTimeZoneDateAndTime(2019, Calendar.JULY, 11, 15, 23, 47, "UTC");
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's year.\n\tActual and expected values should be the same.\n\tExpected:<2019> but was:<2020>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasTimeZoneDateAndTime(2019, Calendar.JULY, 11, 15, 23, 47, "UTC");
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's year.\n\tActual and expected values should be the same.\n\tExpected:<2019> but was:<2020>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasTimeZoneDateAndTime(2020, Calendar.AUGUST, 11, 15, 23, 47, "UTC");
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's month.\n\tActual and expected values should be the same.\n\tExpected:<7> but was:<6>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasTimeZoneDateAndTime(2020, Calendar.AUGUST, 11, 15, 23, 47, "UTC");
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's month.\n\tActual and expected values should be the same.\n\tExpected:<7> but was:<6>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasTimeZoneDateAndTime(2020, Calendar.JULY, 12, 15, 23, 47, "UTC");
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's day of month.\n\tActual and expected values should be the same.\n\tExpected:<12> but was:<11>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasTimeZoneDateAndTime(2020, Calendar.JULY, 12, 15, 23, 47, "UTC");
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's day of month.\n\tActual and expected values should be the same.\n\tExpected:<12> but was:<11>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasTimeZoneDateAndTime(2020, Calendar.JULY, 11, 16, 23, 47, "UTC");
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<16> but was:<15>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasTimeZoneDateAndTime(2020, Calendar.JULY, 11, 16, 23, 47, "UTC");
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<16> but was:<15>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasTimeZoneDateAndTime(2020, Calendar.JULY, 11, 15, 24, 47, "UTC");
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<24> but was:<23>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasTimeZoneDateAndTime(2020, Calendar.JULY, 11, 15, 24, 47, "UTC");
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<24> but was:<23>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasTimeZoneDateAndTime(2020, Calendar.JULY, 11, 15, 23, 48, "UTC");
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<48> but was:<47>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasTimeZoneDateAndTime(2020, Calendar.JULY, 11, 15, 23, 48, "UTC");
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<48> but was:<47>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasTimeZoneDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin");
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's time zone.\n\tCheck actual value's ID.\n\tActual and expected values should be the same.\n\tExpected:<Europe/Berlin> but was:<UTC>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasTimeZoneDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin");
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's time zone.\n\tCheck actual value's ID.\n\tActual and expected values should be the same.\n\tExpected:<Europe/Berlin> but was:<UTC>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasTimeZoneDateAndTimeZoneOffsetTest() {
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasTimeZoneDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, 0);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC")).hasTimeZoneDateAndTime(2020, Calendar.DECEMBER, 11, 15, 23, 47, 0);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC")).hasTimeZoneDateAndTime(1324, Calendar.JULY, 21, 3, 22, 46, 0);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).hasTimeZoneDateAndTime(1324, Calendar.DECEMBER, 21, 3, 22, 46, 0);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).hasTimeZoneDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, 7 * 60 * 60 * 1000);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane")).hasTimeZoneDateAndTime(2020, Calendar.DECEMBER, 11, 15, 23, 47, 7 * 60 * 60 * 1000);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasTimeZoneDateAndTime(1324, Calendar.JULY, 21, 3, 22, 46, 7 * 60 * 60 * 1000);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasTimeZoneDateAndTime(1324, Calendar.DECEMBER, 21, 3, 22, 46, 7 * 60 * 60 * 1000);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).hasTimeZoneDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, 60 * 60 * 1000);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin")).hasTimeZoneDateAndTime(2020, Calendar.DECEMBER, 11, 15, 23, 47, 60 * 60 * 1000);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin")).hasTimeZoneDateAndTime(1324, Calendar.JULY, 21, 3, 22, 46, 60 * 60 * 1000);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin")).hasTimeZoneDateAndTime(1324, Calendar.DECEMBER, 21, 3, 22, 46, 60 * 60 * 1000);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotNull().hasTimeZoneDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, 0).isInstanceOf(Calendar.class);

        try {
            Raw.calendarAssertion().hasTimeZoneDateAndTime(1, 1, 1, 1, 1, 1, 0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).hasTimeZoneDateAndTime(1, 1, 1, 1, 1, 1, 0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").hasTimeZoneDateAndTime(1, 1, 1, 1, 1, 1, 0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasTimeZoneDateAndTime(2019, Calendar.JULY, 11, 15, 23, 47, 0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's year.\n\tActual and expected values should be the same.\n\tExpected:<2019> but was:<2020>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasTimeZoneDateAndTime(2019, Calendar.JULY, 11, 15, 23, 47, 0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's year.\n\tActual and expected values should be the same.\n\tExpected:<2019> but was:<2020>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasTimeZoneDateAndTime(2020, Calendar.AUGUST, 11, 15, 23, 47, 0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's month.\n\tActual and expected values should be the same.\n\tExpected:<7> but was:<6>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasTimeZoneDateAndTime(2020, Calendar.AUGUST, 11, 15, 23, 47, 0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's month.\n\tActual and expected values should be the same.\n\tExpected:<7> but was:<6>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasTimeZoneDateAndTime(2020, Calendar.JULY, 12, 15, 23, 47, 0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's day of month.\n\tActual and expected values should be the same.\n\tExpected:<12> but was:<11>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasTimeZoneDateAndTime(2020, Calendar.JULY, 12, 15, 23, 47, 0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's day of month.\n\tActual and expected values should be the same.\n\tExpected:<12> but was:<11>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasTimeZoneDateAndTime(2020, Calendar.JULY, 11, 16, 23, 47, 0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<16> but was:<15>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasTimeZoneDateAndTime(2020, Calendar.JULY, 11, 16, 23, 47, 0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<16> but was:<15>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasTimeZoneDateAndTime(2020, Calendar.JULY, 11, 15, 24, 47, 0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<24> but was:<23>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasTimeZoneDateAndTime(2020, Calendar.JULY, 11, 15, 24, 47, 0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<24> but was:<23>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasTimeZoneDateAndTime(2020, Calendar.JULY, 11, 15, 23, 48, 0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<48> but was:<47>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasTimeZoneDateAndTime(2020, Calendar.JULY, 11, 15, 23, 48, 0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<48> but was:<47>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasTimeZoneDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, 60 * 60 * 1000);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's zone offset.\n\tActual and expected values should be the same.\n\tExpected:<3600000> but was:<0>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasTimeZoneDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, 60 * 60 * 1000);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's zone offset.\n\tActual and expected values should be the same.\n\tExpected:<3600000> but was:<0>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasTimeZoneDateAndTimeMillisecondTimeZoneIdTest() {
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasTimeZoneDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, 0, "UTC");
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC")).hasTimeZoneDateAndTime(2020, Calendar.DECEMBER, 11, 15, 23, 47, 0, "UTC");
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC")).hasTimeZoneDateAndTime(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC");
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).hasTimeZoneDateAndTime(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC");
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).hasTimeZoneDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, 0, "Asia/Vientiane");
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane")).hasTimeZoneDateAndTime(2020, Calendar.DECEMBER, 11, 15, 23, 47, 0, "Asia/Vientiane");
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasTimeZoneDateAndTime(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane");
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasTimeZoneDateAndTime(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane");
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).hasTimeZoneDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, 0, "Europe/Berlin");
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin")).hasTimeZoneDateAndTime(2020, Calendar.DECEMBER, 11, 15, 23, 47, 0, "Europe/Berlin");
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin")).hasTimeZoneDateAndTime(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin");
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin")).hasTimeZoneDateAndTime(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin");
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotNull().hasTimeZoneDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, 0, "UTC").isInstanceOf(Calendar.class);

        try {
            Raw.calendarAssertion().hasTimeZoneDateAndTime(1, 1, 1, 1, 1, 1, 1, "UTC");
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).hasTimeZoneDateAndTime(1, 1, 1, 1, 1, 1, 1, "UTC");
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").hasTimeZoneDateAndTime(1, 1, 1, 1, 1, 1, 1, "UTC");
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasTimeZoneDateAndTime(2019, Calendar.JULY, 11, 15, 23, 47, 345, "UTC");
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's year.\n\tActual and expected values should be the same.\n\tExpected:<2019> but was:<2020>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasTimeZoneDateAndTime(2019, Calendar.JULY, 11, 15, 23, 47, 345, "UTC");
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's year.\n\tActual and expected values should be the same.\n\tExpected:<2019> but was:<2020>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasTimeZoneDateAndTime(2020, Calendar.AUGUST, 11, 15, 23, 47, 345, "UTC");
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's month.\n\tActual and expected values should be the same.\n\tExpected:<7> but was:<6>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasTimeZoneDateAndTime(2020, Calendar.AUGUST, 11, 15, 23, 47, 345, "UTC");
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's month.\n\tActual and expected values should be the same.\n\tExpected:<7> but was:<6>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasTimeZoneDateAndTime(2020, Calendar.JULY, 12, 15, 23, 47, 345, "UTC");
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's day of month.\n\tActual and expected values should be the same.\n\tExpected:<12> but was:<11>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasTimeZoneDateAndTime(2020, Calendar.JULY, 12, 15, 23, 47, 345, "UTC");
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's day of month.\n\tActual and expected values should be the same.\n\tExpected:<12> but was:<11>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasTimeZoneDateAndTime(2020, Calendar.JULY, 11, 16, 23, 47, 345, "UTC");
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<16> but was:<15>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasTimeZoneDateAndTime(2020, Calendar.JULY, 11, 16, 23, 47, 345, "UTC");
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<16> but was:<15>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasTimeZoneDateAndTime(2020, Calendar.JULY, 11, 15, 24, 47, 345, "UTC");
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<24> but was:<23>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasTimeZoneDateAndTime(2020, Calendar.JULY, 11, 15, 24, 47, 345, "UTC");
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<24> but was:<23>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasTimeZoneDateAndTime(2020, Calendar.JULY, 11, 15, 23, 48, 345, "UTC");
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<48> but was:<47>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasTimeZoneDateAndTime(2020, Calendar.JULY, 11, 15, 23, 48, 345, "UTC");
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<48> but was:<47>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasTimeZoneDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, 555, "UTC");
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's millisecond.\n\tActual and expected values should be the same.\n\tExpected:<555> but was:<345>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasTimeZoneDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, 555, "UTC");
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's millisecond.\n\tActual and expected values should be the same.\n\tExpected:<555> but was:<345>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasTimeZoneDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin");
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's time zone.\n\tCheck actual value's ID.\n\tActual and expected values should be the same.\n\tExpected:<Europe/Berlin> but was:<UTC>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasTimeZoneDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin");
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's time zone.\n\tCheck actual value's ID.\n\tActual and expected values should be the same.\n\tExpected:<Europe/Berlin> but was:<UTC>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasTimeZoneDateAndTimeMillisecondZoneOffsetTest() {
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasTimeZoneDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, 0, 0);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC")).hasTimeZoneDateAndTime(2020, Calendar.DECEMBER, 11, 15, 23, 47, 0, 0);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC")).hasTimeZoneDateAndTime(1324, Calendar.JULY, 21, 3, 22, 46, 543, 0);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).hasTimeZoneDateAndTime(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, 0);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).hasTimeZoneDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, 0, 7 * 60 * 60 * 1000);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane")).hasTimeZoneDateAndTime(2020, Calendar.DECEMBER, 11, 15, 23, 47, 0, 7 * 60 * 60 * 1000);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasTimeZoneDateAndTime(1324, Calendar.JULY, 21, 3, 22, 46, 543, 7 * 60 * 60 * 1000);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasTimeZoneDateAndTime(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, 7 * 60 * 60 * 1000);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).hasTimeZoneDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, 0, 60 * 60 * 1000);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin")).hasTimeZoneDateAndTime(2020, Calendar.DECEMBER, 11, 15, 23, 47, 0, 60 * 60 * 1000);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin")).hasTimeZoneDateAndTime(1324, Calendar.JULY, 21, 3, 22, 46, 543, 60 * 60 * 1000);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin")).hasTimeZoneDateAndTime(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, 60 * 60 * 1000);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotNull().hasTimeZoneDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, 0, 0).isInstanceOf(Calendar.class);

        try {
            Raw.calendarAssertion().hasTimeZoneDateAndTime(1, 1, 1, 1, 1, 1, 1, 0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).hasTimeZoneDateAndTime(1, 1, 1, 1, 1, 1, 1, 0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").hasTimeZoneDateAndTime(1, 1, 1, 1, 1, 1, 1, 0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasTimeZoneDateAndTime(2019, Calendar.JULY, 11, 15, 23, 47, 345, 0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's year.\n\tActual and expected values should be the same.\n\tExpected:<2019> but was:<2020>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasTimeZoneDateAndTime(2019, Calendar.JULY, 11, 15, 23, 47, 345, 0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's year.\n\tActual and expected values should be the same.\n\tExpected:<2019> but was:<2020>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasTimeZoneDateAndTime(2020, Calendar.AUGUST, 11, 15, 23, 47, 345, 0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's month.\n\tActual and expected values should be the same.\n\tExpected:<7> but was:<6>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasTimeZoneDateAndTime(2020, Calendar.AUGUST, 11, 15, 23, 47, 345, 0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's month.\n\tActual and expected values should be the same.\n\tExpected:<7> but was:<6>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasTimeZoneDateAndTime(2020, Calendar.JULY, 12, 15, 23, 47, 345, 0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's day of month.\n\tActual and expected values should be the same.\n\tExpected:<12> but was:<11>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasTimeZoneDateAndTime(2020, Calendar.JULY, 12, 15, 23, 47, 345, 0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's day of month.\n\tActual and expected values should be the same.\n\tExpected:<12> but was:<11>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasTimeZoneDateAndTime(2020, Calendar.JULY, 11, 16, 23, 47, 345, 0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<16> but was:<15>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasTimeZoneDateAndTime(2020, Calendar.JULY, 11, 16, 23, 47, 345, 0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<16> but was:<15>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasTimeZoneDateAndTime(2020, Calendar.JULY, 11, 15, 24, 47, 345, 0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<24> but was:<23>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasTimeZoneDateAndTime(2020, Calendar.JULY, 11, 15, 24, 47, 345, 0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<24> but was:<23>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasTimeZoneDateAndTime(2020, Calendar.JULY, 11, 15, 23, 48, 345, 0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<48> but was:<47>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasTimeZoneDateAndTime(2020, Calendar.JULY, 11, 15, 23, 48, 345, 0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<48> but was:<47>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasTimeZoneDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, 555, 0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's millisecond.\n\tActual and expected values should be the same.\n\tExpected:<555> but was:<345>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasTimeZoneDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, 555, 0);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's millisecond.\n\tActual and expected values should be the same.\n\tExpected:<555> but was:<345>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasTimeZoneDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, 345, 60 * 60 * 1000);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's zone offset.\n\tActual and expected values should be the same.\n\tExpected:<3600000> but was:<0>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasTimeZoneDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, 345, 60 * 60 * 1000);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's zone offset.\n\tActual and expected values should be the same.\n\tExpected:<3600000> but was:<0>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasUtcDateAndTimeTest() {
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasUtcDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC")).hasUtcDateAndTime(2020, Calendar.DECEMBER, 11, 15, 23, 47);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC")).hasUtcDateAndTime(1324, Calendar.JULY, 21, 3, 22, 46);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).hasUtcDateAndTime(1324, Calendar.DECEMBER, 21, 3, 22, 46);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).hasUtcDateAndTime(2020, Calendar.JULY, 11, 8, 23, 47);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane")).hasUtcDateAndTime(2020, Calendar.DECEMBER, 11, 8, 23, 47);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasUtcDateAndTime(1324, Calendar.JULY, 20, 20, 22, 46);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasUtcDateAndTime(1324, Calendar.DECEMBER, 20, 20, 22, 46);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).hasUtcDateAndTime(2020, Calendar.JULY, 11, 13, 23, 47);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin")).hasUtcDateAndTime(2020, Calendar.DECEMBER, 11, 14, 23, 47);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin")).hasUtcDateAndTime(1324, Calendar.JULY, 21, 2, 22, 46);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin")).hasUtcDateAndTime(1324, Calendar.DECEMBER, 21, 2, 22, 46);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotNull().hasUtcDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47).isInstanceOf(Calendar.class);

        try {
            Raw.calendarAssertion().hasUtcDateAndTime(1, 1, 1, 1, 1, 1);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).hasUtcDateAndTime(1, 1, 1, 1, 1, 1);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").hasUtcDateAndTime(1, 1, 1, 1, 1, 1);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasUtcDateAndTime(2019, Calendar.JULY, 11, 15, 23, 47);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's date in time zone: UTC.\n\tCheck actual value's year.\n\tActual and expected values should be the same.\n\tExpected:<2019> but was:<2020>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasUtcDateAndTime(2019, Calendar.JULY, 11, 15, 23, 47);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's date in time zone: UTC.\n\tCheck actual value's year.\n\tActual and expected values should be the same.\n\tExpected:<2019> but was:<2020>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasUtcDateAndTime(2020, Calendar.AUGUST, 11, 15, 23, 47);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's date in time zone: UTC.\n\tCheck actual value's month.\n\tActual and expected values should be the same.\n\tExpected:<7> but was:<6>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasUtcDateAndTime(2020, Calendar.AUGUST, 11, 15, 23, 47);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's date in time zone: UTC.\n\tCheck actual value's month.\n\tActual and expected values should be the same.\n\tExpected:<7> but was:<6>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasUtcDateAndTime(2020, Calendar.JULY, 12, 15, 23, 47);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's date in time zone: UTC.\n\tCheck actual value's day of month.\n\tActual and expected values should be the same.\n\tExpected:<12> but was:<11>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasUtcDateAndTime(2020, Calendar.JULY, 12, 15, 23, 47);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's date in time zone: UTC.\n\tCheck actual value's day of month.\n\tActual and expected values should be the same.\n\tExpected:<12> but was:<11>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasUtcDateAndTime(2020, Calendar.JULY, 11, 16, 23, 47);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's date in time zone: UTC.\n\tCheck actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<16> but was:<15>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasUtcDateAndTime(2020, Calendar.JULY, 11, 16, 23, 47);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's date in time zone: UTC.\n\tCheck actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<16> but was:<15>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasUtcDateAndTime(2020, Calendar.JULY, 11, 15, 24, 47);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's date in time zone: UTC.\n\tCheck actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<24> but was:<23>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasUtcDateAndTime(2020, Calendar.JULY, 11, 15, 24, 47);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's date in time zone: UTC.\n\tCheck actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<24> but was:<23>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasUtcDateAndTime(2020, Calendar.JULY, 11, 15, 23, 48);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's date in time zone: UTC.\n\tCheck actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<48> but was:<47>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasUtcDateAndTime(2020, Calendar.JULY, 11, 15, 23, 48);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's date in time zone: UTC.\n\tCheck actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<48> but was:<47>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasUtcDateAndTimeMillisecondTest() {
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasUtcDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, 0);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC")).hasUtcDateAndTime(2020, Calendar.DECEMBER, 11, 15, 23, 47, 0);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC")).hasUtcDateAndTime(1324, Calendar.JULY, 21, 3, 22, 46, 543);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).hasUtcDateAndTime(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).hasUtcDateAndTime(2020, Calendar.JULY, 11, 8, 23, 47, 0);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane")).hasUtcDateAndTime(2020, Calendar.DECEMBER, 11, 8, 23, 47, 0);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasUtcDateAndTime(1324, Calendar.JULY, 20, 20, 22, 46, 543);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasUtcDateAndTime(1324, Calendar.DECEMBER, 20, 20, 22, 46, 543);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).hasUtcDateAndTime(2020, Calendar.JULY, 11, 13, 23, 47, 0);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin")).hasUtcDateAndTime(2020, Calendar.DECEMBER, 11, 14, 23, 47, 0);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin")).hasUtcDateAndTime(1324, Calendar.JULY, 21, 2, 22, 46, 543);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin")).hasUtcDateAndTime(1324, Calendar.DECEMBER, 21, 2, 22, 46, 543);
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotNull().hasUtcDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, 0).isInstanceOf(Calendar.class);

        try {
            Raw.calendarAssertion().hasUtcDateAndTime(1, 1, 1, 1, 1, 1, 1);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).hasUtcDateAndTime(1, 1, 1, 1, 1, 1, 1);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").hasUtcDateAndTime(1, 1, 1, 1, 1, 1, 1);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasUtcDateAndTime(2019, Calendar.JULY, 11, 15, 23, 47, 345);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's date in time zone: UTC.\n\tCheck actual value's year.\n\tActual and expected values should be the same.\n\tExpected:<2019> but was:<2020>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasUtcDateAndTime(2019, Calendar.JULY, 11, 15, 23, 47, 345);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's date in time zone: UTC.\n\tCheck actual value's year.\n\tActual and expected values should be the same.\n\tExpected:<2019> but was:<2020>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasUtcDateAndTime(2020, Calendar.AUGUST, 11, 15, 23, 47, 345);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's date in time zone: UTC.\n\tCheck actual value's month.\n\tActual and expected values should be the same.\n\tExpected:<7> but was:<6>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasUtcDateAndTime(2020, Calendar.AUGUST, 11, 15, 23, 47, 345);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's date in time zone: UTC.\n\tCheck actual value's month.\n\tActual and expected values should be the same.\n\tExpected:<7> but was:<6>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasUtcDateAndTime(2020, Calendar.JULY, 12, 15, 23, 47, 345);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's date in time zone: UTC.\n\tCheck actual value's day of month.\n\tActual and expected values should be the same.\n\tExpected:<12> but was:<11>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasUtcDateAndTime(2020, Calendar.JULY, 12, 15, 23, 47, 345);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's date in time zone: UTC.\n\tCheck actual value's day of month.\n\tActual and expected values should be the same.\n\tExpected:<12> but was:<11>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasUtcDateAndTime(2020, Calendar.JULY, 11, 16, 23, 47, 345);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's date in time zone: UTC.\n\tCheck actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<16> but was:<15>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasUtcDateAndTime(2020, Calendar.JULY, 11, 16, 23, 47, 345);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's date in time zone: UTC.\n\tCheck actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<16> but was:<15>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasUtcDateAndTime(2020, Calendar.JULY, 11, 15, 24, 47, 345);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's date in time zone: UTC.\n\tCheck actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<24> but was:<23>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasUtcDateAndTime(2020, Calendar.JULY, 11, 15, 24, 47, 345);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's date in time zone: UTC.\n\tCheck actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<24> but was:<23>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasUtcDateAndTime(2020, Calendar.JULY, 11, 15, 23, 48, 345);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's date in time zone: UTC.\n\tCheck actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<48> but was:<47>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasUtcDateAndTime(2020, Calendar.JULY, 11, 15, 23, 48, 345);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's date in time zone: UTC.\n\tCheck actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<48> but was:<47>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasUtcDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, 555);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's date in time zone: UTC.\n\tCheck actual value's millisecond.\n\tActual and expected values should be the same.\n\tExpected:<555> but was:<345>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasUtcDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, 555);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's date in time zone: UTC.\n\tCheck actual value's millisecond.\n\tActual and expected values should be the same.\n\tExpected:<555> but was:<345>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toTimeZoneCalendarTest() {
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).toTimeZoneCalendar(TimeZone.getTimeZone("UTC")).isEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC")).toTimeZoneCalendar(TimeZone.getTimeZone("UTC")).isEqualTo(DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC")).toTimeZoneCalendar(TimeZone.getTimeZone("UTC")).isEqualTo(DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).toTimeZoneCalendar(TimeZone.getTimeZone("UTC")).isEqualTo(DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).toTimeZoneCalendar(TimeZone.getTimeZone("Asia/Vientiane")).isEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 22, 23, 47, "Asia/Vientiane"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC")).toTimeZoneCalendar(TimeZone.getTimeZone("Asia/Vientiane")).isEqualTo(DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 22, 23, 47, "Asia/Vientiane"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC")).toTimeZoneCalendar(TimeZone.getTimeZone("Asia/Vientiane")).isEqualTo(DataHelper.createCalendar(1324, Calendar.JULY, 21, 10, 22, 46, 543, "Asia/Vientiane"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).toTimeZoneCalendar(TimeZone.getTimeZone("Asia/Vientiane")).isEqualTo(DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 10, 22, 46, 543, "Asia/Vientiane"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).toTimeZoneCalendar(TimeZone.getTimeZone("Europe/Berlin")).isEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 17, 23, 47, "Europe/Berlin"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC")).toTimeZoneCalendar(TimeZone.getTimeZone("Europe/Berlin")).isEqualTo(DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 16, 23, 47, "Europe/Berlin"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC")).toTimeZoneCalendar(TimeZone.getTimeZone("Europe/Berlin")).isEqualTo(DataHelper.createCalendar(1324, Calendar.JULY, 21, 4, 22, 46, 543, "Europe/Berlin"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).toTimeZoneCalendar(TimeZone.getTimeZone("Europe/Berlin")).isEqualTo(DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 4, 22, 46, 543, "Europe/Berlin"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).toTimeZoneCalendar(TimeZone.getTimeZone("UTC")).isEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 8, 23, 47, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane")).toTimeZoneCalendar(TimeZone.getTimeZone("UTC")).isEqualTo(DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 8, 23, 47, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane")).toTimeZoneCalendar(TimeZone.getTimeZone("UTC")).isEqualTo(DataHelper.createCalendar(1324, Calendar.JULY, 20, 20, 22, 46, 543, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).toTimeZoneCalendar(TimeZone.getTimeZone("UTC")).isEqualTo(DataHelper.createCalendar(1324, Calendar.DECEMBER, 20, 20, 22, 46, 543, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).toTimeZoneCalendar(TimeZone.getTimeZone("Asia/Vientiane")).isEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane")).toTimeZoneCalendar(TimeZone.getTimeZone("Asia/Vientiane")).isEqualTo(DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane")).toTimeZoneCalendar(TimeZone.getTimeZone("Asia/Vientiane")).isEqualTo(DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).toTimeZoneCalendar(TimeZone.getTimeZone("Asia/Vientiane")).isEqualTo(DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).toTimeZoneCalendar(TimeZone.getTimeZone("Europe/Berlin")).isEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 10, 23, 47, "Europe/Berlin"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane")).toTimeZoneCalendar(TimeZone.getTimeZone("Europe/Berlin")).isEqualTo(DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 9, 23, 47, "Europe/Berlin"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane")).toTimeZoneCalendar(TimeZone.getTimeZone("Europe/Berlin")).isEqualTo(DataHelper.createCalendar(1324, Calendar.JULY, 20, 21, 22, 46, 543, "Europe/Berlin"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).toTimeZoneCalendar(TimeZone.getTimeZone("Europe/Berlin")).isEqualTo(DataHelper.createCalendar(1324, Calendar.DECEMBER, 20, 21, 22, 46, 543, "Europe/Berlin"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).toTimeZoneCalendar(TimeZone.getTimeZone("UTC")).isEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 13, 23, 47, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin")).toTimeZoneCalendar(TimeZone.getTimeZone("UTC")).isEqualTo(DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 14, 23, 47, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin")).toTimeZoneCalendar(TimeZone.getTimeZone("UTC")).isEqualTo(DataHelper.createCalendar(1324, Calendar.JULY, 21, 2, 22, 46, 543, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin")).toTimeZoneCalendar(TimeZone.getTimeZone("UTC")).isEqualTo(DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 2, 22, 46, 543, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).toTimeZoneCalendar(TimeZone.getTimeZone("Asia/Vientiane")).isEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 20, 23, 47, "Asia/Vientiane"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin")).toTimeZoneCalendar(TimeZone.getTimeZone("Asia/Vientiane")).isEqualTo(DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 21, 23, 47, "Asia/Vientiane"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin")).toTimeZoneCalendar(TimeZone.getTimeZone("Asia/Vientiane")).isEqualTo(DataHelper.createCalendar(1324, Calendar.JULY, 21, 9, 22, 46, 543, "Asia/Vientiane"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin")).toTimeZoneCalendar(TimeZone.getTimeZone("Asia/Vientiane")).isEqualTo(DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 9, 22, 46, 543, "Asia/Vientiane"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).toTimeZoneCalendar(TimeZone.getTimeZone("Europe/Berlin")).isEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin")).toTimeZoneCalendar(TimeZone.getTimeZone("Europe/Berlin")).isEqualTo(DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin")).toTimeZoneCalendar(TimeZone.getTimeZone("Europe/Berlin")).isEqualTo(DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin")).toTimeZoneCalendar(TimeZone.getTimeZone("Europe/Berlin")).isEqualTo(DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotNull().toTimeZoneCalendar(TimeZone.getTimeZone("UTC")).isEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"));

        try {
            Raw.calendarAssertion().toTimeZoneCalendar(TimeZone.getTimeZone("UTC"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toTimeZoneCalendar(TimeZone.getTimeZone("UTC"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toTimeZoneCalendar(TimeZone.getTimeZone("UTC"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toTimeZoneCalendar((TimeZone) null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toTimeZoneCalendar((TimeZone) null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).toTimeZoneCalendar((TimeZone) null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: timeZone.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").toTimeZoneCalendar((TimeZone) null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: timeZone.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).toTimeZoneCalendar(TimeZone.getTimeZone("Europe/Berlin")).isEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 10, 10, 23, 47, "Europe/Berlin"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's date in time zone: Europe/Berlin.\n\tActual and expected values should be the same.\n\tExpected:<2020-07-10T10:23:47.000+0200> but was:<2020-07-11T10:23:47.000+0200>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane"), "Message").toTimeZoneCalendar(TimeZone.getTimeZone("Europe/Berlin")).isEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 10, 10, 23, 47, "Europe/Berlin"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's date in time zone: Europe/Berlin.\n\tActual and expected values should be the same.\n\tExpected:<2020-07-10T10:23:47.000+0200> but was:<2020-07-11T10:23:47.000+0200>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toTimeZoneIdCalendarTest() {
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).toTimeZoneCalendar("UTC").isEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC")).toTimeZoneCalendar("UTC").isEqualTo(DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC")).toTimeZoneCalendar("UTC").isEqualTo(DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).toTimeZoneCalendar("UTC").isEqualTo(DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).toTimeZoneCalendar("Asia/Vientiane").isEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 22, 23, 47, "Asia/Vientiane"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC")).toTimeZoneCalendar("Asia/Vientiane").isEqualTo(DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 22, 23, 47, "Asia/Vientiane"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC")).toTimeZoneCalendar("Asia/Vientiane").isEqualTo(DataHelper.createCalendar(1324, Calendar.JULY, 21, 10, 22, 46, 543, "Asia/Vientiane"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).toTimeZoneCalendar("Asia/Vientiane").isEqualTo(DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 10, 22, 46, 543, "Asia/Vientiane"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).toTimeZoneCalendar("Europe/Berlin").isEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 17, 23, 47, "Europe/Berlin"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC")).toTimeZoneCalendar("Europe/Berlin").isEqualTo(DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 16, 23, 47, "Europe/Berlin"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC")).toTimeZoneCalendar("Europe/Berlin").isEqualTo(DataHelper.createCalendar(1324, Calendar.JULY, 21, 4, 22, 46, 543, "Europe/Berlin"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).toTimeZoneCalendar("Europe/Berlin").isEqualTo(DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 4, 22, 46, 543, "Europe/Berlin"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).toTimeZoneCalendar("UTC").isEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 8, 23, 47, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane")).toTimeZoneCalendar("UTC").isEqualTo(DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 8, 23, 47, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane")).toTimeZoneCalendar("UTC").isEqualTo(DataHelper.createCalendar(1324, Calendar.JULY, 20, 20, 22, 46, 543, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).toTimeZoneCalendar("UTC").isEqualTo(DataHelper.createCalendar(1324, Calendar.DECEMBER, 20, 20, 22, 46, 543, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).toTimeZoneCalendar("Asia/Vientiane").isEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane")).toTimeZoneCalendar("Asia/Vientiane").isEqualTo(DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane")).toTimeZoneCalendar("Asia/Vientiane").isEqualTo(DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).toTimeZoneCalendar("Asia/Vientiane").isEqualTo(DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).toTimeZoneCalendar("Europe/Berlin").isEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 10, 23, 47, "Europe/Berlin"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane")).toTimeZoneCalendar("Europe/Berlin").isEqualTo(DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 9, 23, 47, "Europe/Berlin"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane")).toTimeZoneCalendar("Europe/Berlin").isEqualTo(DataHelper.createCalendar(1324, Calendar.JULY, 20, 21, 22, 46, 543, "Europe/Berlin"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).toTimeZoneCalendar("Europe/Berlin").isEqualTo(DataHelper.createCalendar(1324, Calendar.DECEMBER, 20, 21, 22, 46, 543, "Europe/Berlin"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).toTimeZoneCalendar("UTC").isEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 13, 23, 47, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin")).toTimeZoneCalendar("UTC").isEqualTo(DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 14, 23, 47, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin")).toTimeZoneCalendar("UTC").isEqualTo(DataHelper.createCalendar(1324, Calendar.JULY, 21, 2, 22, 46, 543, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin")).toTimeZoneCalendar("UTC").isEqualTo(DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 2, 22, 46, 543, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).toTimeZoneCalendar("Asia/Vientiane").isEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 20, 23, 47, "Asia/Vientiane"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin")).toTimeZoneCalendar("Asia/Vientiane").isEqualTo(DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 21, 23, 47, "Asia/Vientiane"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin")).toTimeZoneCalendar("Asia/Vientiane").isEqualTo(DataHelper.createCalendar(1324, Calendar.JULY, 21, 9, 22, 46, 543, "Asia/Vientiane"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin")).toTimeZoneCalendar("Asia/Vientiane").isEqualTo(DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 9, 22, 46, 543, "Asia/Vientiane"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).toTimeZoneCalendar("Europe/Berlin").isEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin")).toTimeZoneCalendar("Europe/Berlin").isEqualTo(DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin")).toTimeZoneCalendar("Europe/Berlin").isEqualTo(DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin")).toTimeZoneCalendar("Europe/Berlin").isEqualTo(DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotNull().toTimeZoneCalendar("UTC").isEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"));

        try {
            Raw.calendarAssertion().toTimeZoneCalendar("UTC");
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toTimeZoneCalendar("UTC");
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toTimeZoneCalendar("UTC");
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toTimeZoneCalendar((String) null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toTimeZoneCalendar((String) null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).toTimeZoneCalendar((String) null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: timeZoneId.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").toTimeZoneCalendar((String) null);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: timeZoneId.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).toTimeZoneCalendar("Europe/Berlin").isEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 10, 10, 23, 47, "Europe/Berlin"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's date in time zone: Europe/Berlin.\n\tActual and expected values should be the same.\n\tExpected:<2020-07-10T10:23:47.000+0200> but was:<2020-07-11T10:23:47.000+0200>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane"), "Message").toTimeZoneCalendar("Europe/Berlin").isEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 10, 10, 23, 47, "Europe/Berlin"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's date in time zone: Europe/Berlin.\n\tActual and expected values should be the same.\n\tExpected:<2020-07-10T10:23:47.000+0200> but was:<2020-07-11T10:23:47.000+0200>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toUtcTimeZoneCalendarTest() {
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).toUtcTimeZoneCalendar().isEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC")).toUtcTimeZoneCalendar().isEqualTo(DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC")).toUtcTimeZoneCalendar().isEqualTo(DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).toUtcTimeZoneCalendar().isEqualTo(DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).toUtcTimeZoneCalendar().isEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 8, 23, 47, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane")).toUtcTimeZoneCalendar().isEqualTo(DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 8, 23, 47, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane")).toUtcTimeZoneCalendar().isEqualTo(DataHelper.createCalendar(1324, Calendar.JULY, 20, 20, 22, 46, 543, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).toUtcTimeZoneCalendar().isEqualTo(DataHelper.createCalendar(1324, Calendar.DECEMBER, 20, 20, 22, 46, 543, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).toUtcTimeZoneCalendar().isEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 13, 23, 47, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin")).toUtcTimeZoneCalendar().isEqualTo(DataHelper.createCalendar(2020, Calendar.DECEMBER, 11, 14, 23, 47, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin")).toUtcTimeZoneCalendar().isEqualTo(DataHelper.createCalendar(1324, Calendar.JULY, 21, 2, 22, 46, 543, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin")).toUtcTimeZoneCalendar().isEqualTo(DataHelper.createCalendar(1324, Calendar.DECEMBER, 21, 2, 22, 46, 543, "UTC"));
        initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotNull().toUtcTimeZoneCalendar().isEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"));

        try {
            Raw.calendarAssertion().toUtcTimeZoneCalendar();
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toUtcTimeZoneCalendar();
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toUtcTimeZoneCalendar();
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).toUtcTimeZoneCalendar().isEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 10, 8, 23, 47, "UTC"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's date in time zone: UTC.\n\tActual and expected values should be the same.\n\tExpected:<2020-07-10T08:23:47.000+0000> but was:<2020-07-11T08:23:47.000+0000>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane"), "Message").toUtcTimeZoneCalendar().isEqualTo(DataHelper.createCalendar(2020, Calendar.JULY, 10, 8, 23, 47, "UTC"));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's date in time zone: UTC.\n\tActual and expected values should be the same.\n\tExpected:<2020-07-10T08:23:47.000+0000> but was:<2020-07-11T08:23:47.000+0000>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void changeTimeZoneTest() {
        TimeZone timeZone = TimeZone.getDefault();

        try {
            TimeZone.setDefault(TimeZone.getTimeZone("Asia/Vientiane"));

            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).hasDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47);
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).hasUtcDateAndTime(2020, Calendar.JULY, 11, 8, 23, 47);
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).hasTimeZoneId("Asia/Vientiane");
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).hasZoneOffset(7 * 60 * 60 * 1000);
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).hasDstOffset(0);

            TimeZone.setDefault(TimeZone.getTimeZone("Europe/Berlin"));

            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).hasDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47);
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).hasUtcDateAndTime(2020, Calendar.JULY, 11, 13, 23, 47);
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).hasTimeZoneId("Europe/Berlin");
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).hasZoneOffset(60 * 60 * 1000);
            initialize(Raw.calendarAssertion(), DataHelper.createCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).hasDstOffset(60 * 60 * 1000);
        } finally {
            TimeZone.setDefault(timeZone);
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void isNullTest() {
        initialize(Raw.calendarAssertion(), null).isNull();

        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).isNull();
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null.\n\tActual:<2020-07-11T15:23:47.000+0000>");
        }
        try {
            initialize(Raw.calendarAssertion(), DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").isNull();
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null.\n\tActual:<2020-07-11T15:23:47.000+0000>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void isSameAsTest() {
        Calendar value = DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47);
        initialize(Raw.calendarAssertion(), value).isSameAs(value);

        try {
            initialize(Raw.calendarAssertion(), value).isSameAs(DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should point to the same object.\n\tExpected:<2020-07-11T15:23:47.000+0000> but was:<2020-07-11T15:23:47.000+0000>");
        }
        try {
            initialize(Raw.calendarAssertion(), value, "Message").isSameAs(DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47));
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should point to the same object.\n\tExpected:<2020-07-11T15:23:47.000+0000> but was:<2020-07-11T15:23:47.000+0000>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        Calendar value = DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47);
        initialize(Raw.calendarAssertion(), value).isNotSameAs(DataHelper.createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47));

        try {
            initialize(Raw.calendarAssertion(), value).isNotSameAs(value);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should point to the different objects.\n\tActual:<2020-07-11T15:23:47.000+0000>");
        }
        try {
            initialize(Raw.calendarAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail(CalendarAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should point to the different objects.\n\tActual:<2020-07-11T15:23:47.000+0000>");
        }
    }

}
