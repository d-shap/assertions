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
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isEqualTo(createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC")).isEqualTo(createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC"));
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC")).isEqualTo(createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC"));
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).isEqualTo(createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC"));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).isEqualTo(createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane"));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane")).isEqualTo(createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane"));
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane")).isEqualTo(createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane"));
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).isEqualTo(createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane"));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).isEqualTo(createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin"));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin")).isEqualTo(createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin"));
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin")).isEqualTo(createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin"));
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin")).isEqualTo(createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin"));

        try {
            Raw.calendarAssertion().isEqualTo(createCalendar(1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).isEqualTo(createCalendar(1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").isEqualTo(createCalendar(1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).isEqualTo(null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").isEqualTo(null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isEqualTo(null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").isEqualTo(null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isEqualTo(createCalendar(2019, Calendar.AUGUST, 12, 16, 22, 46, 555, "UTC"));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<2019-08-12T16:22:46.555+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").isEqualTo(createCalendar(2019, Calendar.AUGUST, 12, 16, 22, 46, 555, "UTC"));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<2019-08-12T16:22:46.555+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isEqualTo(createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin"));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<2020-07-11T15:23:47.000+0200> but was:<2020-07-11T15:23:47.000+0000>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").isEqualTo(createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin"));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<2020-07-11T15:23:47.000+0200> but was:<2020-07-11T15:23:47.000+0000>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isEqualTo(createCalendar(2020, Calendar.JULY, 11, 17, 23, 47, "Europe/Berlin"));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<2020-07-11T17:23:47.000+0200> but was:<2020-07-11T15:23:47.000+0000>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").isEqualTo(createCalendar(2020, Calendar.JULY, 11, 17, 23, 47, "Europe/Berlin"));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<2020-07-11T17:23:47.000+0200> but was:<2020-07-11T15:23:47.000+0000>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void isNotEqualToTest() {
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotEqualTo(createCalendar(2019, Calendar.JULY, 11, 15, 23, 47, "UTC"));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotEqualTo(createCalendar(2020, Calendar.AUGUST, 11, 15, 23, 47, "UTC"));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotEqualTo(createCalendar(2020, Calendar.JULY, 12, 15, 23, 47, "UTC"));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotEqualTo(createCalendar(2020, Calendar.JULY, 11, 16, 23, 47, "UTC"));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotEqualTo(createCalendar(2020, Calendar.JULY, 11, 15, 22, 47, "UTC"));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotEqualTo(createCalendar(2020, Calendar.JULY, 11, 15, 23, 46, "UTC"));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotEqualTo(createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin"));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotEqualTo(createCalendar(2020, Calendar.JULY, 11, 16, 23, 47, "Europe/Berlin"));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotEqualTo(createCalendar(2020, Calendar.JULY, 11, 17, 23, 47, "Europe/Berlin"));
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).isNotEqualTo(createCalendar(1323, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC"));
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).isNotEqualTo(createCalendar(1324, Calendar.NOVEMBER, 21, 3, 22, 46, 543, "UTC"));
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).isNotEqualTo(createCalendar(1324, Calendar.DECEMBER, 20, 3, 22, 46, 543, "UTC"));
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).isNotEqualTo(createCalendar(1324, Calendar.DECEMBER, 21, 4, 22, 46, 543, "UTC"));
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).isNotEqualTo(createCalendar(1324, Calendar.DECEMBER, 21, 3, 21, 46, 543, "UTC"));
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).isNotEqualTo(createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 45, 543, "UTC"));
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).isNotEqualTo(createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 555, "UTC"));
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).isNotEqualTo(createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin"));
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).isNotEqualTo(createCalendar(1324, Calendar.DECEMBER, 21, 4, 22, 46, 543, "Europe/Berlin"));
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).isNotEqualTo(createCalendar(1324, Calendar.DECEMBER, 21, 5, 22, 46, 543, "Europe/Berlin"));

        try {
            Raw.calendarAssertion().isNotEqualTo(createCalendar(1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).isNotEqualTo(createCalendar(1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").isNotEqualTo(createCalendar(1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).isNotEqualTo(null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").isNotEqualTo(null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).isNotEqualTo(null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").isNotEqualTo(null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isNotEqualTo(createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").isNotEqualTo(createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).isNotEqualTo(createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane"));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<1324-12-21T03:22:46.543+0700>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane"), "Message").isNotEqualTo(createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane"));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<1324-12-21T03:22:46.543+0700>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void isGreaterThanTest() {
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThan(createCalendar(2019, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThan(createCalendar(2020, Calendar.JUNE, 11, 15, 23, 47, 345, "UTC"));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThan(createCalendar(2020, Calendar.JULY, 10, 15, 23, 47, 345, "UTC"));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThan(createCalendar(2020, Calendar.JULY, 11, 14, 23, 47, 345, "UTC"));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThan(createCalendar(2020, Calendar.JULY, 11, 15, 22, 47, 345, "UTC"));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThan(createCalendar(2020, Calendar.JULY, 11, 15, 23, 46, 345, "UTC"));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThan(createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 344, "UTC"));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThan(createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin"));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThan(createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Asia/Vientiane"));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin")).isGreaterThan(createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Asia/Vientiane"));

        try {
            Raw.calendarAssertion().isGreaterThan(createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).isGreaterThan(createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").isGreaterThan(createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).isGreaterThan(null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").isGreaterThan(null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThan(null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").isGreaterThan(null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThan(createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater than the expected.\n\tExpected:<2020-07-11T15:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").isGreaterThan(createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be greater than the expected.\n\tExpected:<2020-07-11T15:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThan(createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 346, "UTC"));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater than the expected.\n\tExpected:<2020-07-11T15:23:47.346+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").isGreaterThan(createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 346, "UTC"));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be greater than the expected.\n\tExpected:<2020-07-11T15:23:47.346+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin")).isGreaterThan(createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater than the expected.\n\tExpected:<2020-07-11T15:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0200>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin"), "Message").isGreaterThan(createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be greater than the expected.\n\tExpected:<2020-07-11T15:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0200>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin")).isGreaterThan(createCalendar(2020, Calendar.JULY, 11, 17, 23, 47, 345, "UTC"));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater than the expected.\n\tExpected:<2020-07-11T17:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0200>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin"), "Message").isGreaterThan(createCalendar(2020, Calendar.JULY, 11, 17, 23, 47, 345, "UTC"));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be greater than the expected.\n\tExpected:<2020-07-11T17:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0200>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void isGreaterThanOrEqualToTest() {
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThanOrEqualTo(createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThanOrEqualTo(createCalendar(2019, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThanOrEqualTo(createCalendar(2020, Calendar.JUNE, 11, 15, 23, 47, 345, "UTC"));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThanOrEqualTo(createCalendar(2020, Calendar.JULY, 10, 15, 23, 47, 345, "UTC"));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThanOrEqualTo(createCalendar(2020, Calendar.JULY, 11, 14, 23, 47, 345, "UTC"));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThanOrEqualTo(createCalendar(2020, Calendar.JULY, 11, 15, 22, 47, 345, "UTC"));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThanOrEqualTo(createCalendar(2020, Calendar.JULY, 11, 15, 23, 46, 345, "UTC"));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThanOrEqualTo(createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 344, "UTC"));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThanOrEqualTo(createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin"));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThanOrEqualTo(createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Asia/Vientiane"));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin")).isGreaterThanOrEqualTo(createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Asia/Vientiane"));

        try {
            Raw.calendarAssertion().isGreaterThanOrEqualTo(createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).isGreaterThanOrEqualTo(createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").isGreaterThanOrEqualTo(createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).isGreaterThanOrEqualTo(null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").isGreaterThanOrEqualTo(null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThanOrEqualTo(null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").isGreaterThanOrEqualTo(null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isGreaterThanOrEqualTo(createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 346, "UTC"));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater than or equal to the expected.\n\tExpected:<2020-07-11T15:23:47.346+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").isGreaterThanOrEqualTo(createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 346, "UTC"));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be greater than or equal to the expected.\n\tExpected:<2020-07-11T15:23:47.346+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin")).isGreaterThanOrEqualTo(createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater than or equal to the expected.\n\tExpected:<2020-07-11T15:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0200>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin"), "Message").isGreaterThanOrEqualTo(createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be greater than or equal to the expected.\n\tExpected:<2020-07-11T15:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0200>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin")).isGreaterThanOrEqualTo(createCalendar(2020, Calendar.JULY, 11, 17, 23, 47, 345, "UTC"));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater than or equal to the expected.\n\tExpected:<2020-07-11T17:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0200>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin"), "Message").isGreaterThanOrEqualTo(createCalendar(2020, Calendar.JULY, 11, 17, 23, 47, 345, "UTC"));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be greater than or equal to the expected.\n\tExpected:<2020-07-11T17:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0200>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void isLessThanTest() {
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThan(createCalendar(2021, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThan(createCalendar(2020, Calendar.AUGUST, 11, 15, 23, 47, 345, "UTC"));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThan(createCalendar(2020, Calendar.JULY, 12, 15, 23, 47, 345, "UTC"));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThan(createCalendar(2020, Calendar.JULY, 11, 16, 23, 47, 345, "UTC"));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThan(createCalendar(2020, Calendar.JULY, 11, 15, 24, 47, 345, "UTC"));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThan(createCalendar(2020, Calendar.JULY, 11, 15, 23, 48, 345, "UTC"));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThan(createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 346, "UTC"));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin")).isLessThan(createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Asia/Vientiane")).isLessThan(createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Asia/Vientiane")).isLessThan(createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin"));

        try {
            Raw.calendarAssertion().isLessThan(createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).isLessThan(createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").isLessThan(createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).isLessThan(null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").isLessThan(null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThan(null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").isLessThan(null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThan(createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than the expected.\n\tExpected:<2020-07-11T15:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").isLessThan(createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be less than the expected.\n\tExpected:<2020-07-11T15:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThan(createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 344, "UTC"));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than the expected.\n\tExpected:<2020-07-11T15:23:47.344+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").isLessThan(createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 344, "UTC"));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be less than the expected.\n\tExpected:<2020-07-11T15:23:47.344+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThan(createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin"));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than the expected.\n\tExpected:<2020-07-11T15:23:47.345+0200> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").isLessThan(createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin"));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be less than the expected.\n\tExpected:<2020-07-11T15:23:47.345+0200> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThan(createCalendar(2020, Calendar.JULY, 11, 13, 23, 47, 345, "Europe/Berlin"));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than the expected.\n\tExpected:<2020-07-11T13:23:47.345+0200> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").isLessThan(createCalendar(2020, Calendar.JULY, 11, 13, 23, 47, 345, "Europe/Berlin"));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be less than the expected.\n\tExpected:<2020-07-11T13:23:47.345+0200> but was:<2020-07-11T15:23:47.345+0000>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void isLessThanOrEqualToTest() {
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThanOrEqualTo(createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThanOrEqualTo(createCalendar(2021, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThanOrEqualTo(createCalendar(2020, Calendar.AUGUST, 11, 15, 23, 47, 345, "UTC"));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThanOrEqualTo(createCalendar(2020, Calendar.JULY, 12, 15, 23, 47, 345, "UTC"));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThanOrEqualTo(createCalendar(2020, Calendar.JULY, 11, 16, 23, 47, 345, "UTC"));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThanOrEqualTo(createCalendar(2020, Calendar.JULY, 11, 15, 24, 47, 345, "UTC"));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThanOrEqualTo(createCalendar(2020, Calendar.JULY, 11, 15, 23, 48, 345, "UTC"));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThanOrEqualTo(createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 346, "UTC"));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin")).isLessThanOrEqualTo(createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Asia/Vientiane")).isLessThanOrEqualTo(createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Asia/Vientiane")).isLessThanOrEqualTo(createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin"));

        try {
            Raw.calendarAssertion().isLessThanOrEqualTo(createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).isLessThanOrEqualTo(createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").isLessThanOrEqualTo(createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).isLessThanOrEqualTo(null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").isLessThanOrEqualTo(null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThanOrEqualTo(null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").isLessThanOrEqualTo(null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThanOrEqualTo(createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 344, "UTC"));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than or equal to the expected.\n\tExpected:<2020-07-11T15:23:47.344+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").isLessThanOrEqualTo(createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 344, "UTC"));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be less than or equal to the expected.\n\tExpected:<2020-07-11T15:23:47.344+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThanOrEqualTo(createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin"));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than or equal to the expected.\n\tExpected:<2020-07-11T15:23:47.345+0200> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").isLessThanOrEqualTo(createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin"));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be less than or equal to the expected.\n\tExpected:<2020-07-11T15:23:47.345+0200> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isLessThanOrEqualTo(createCalendar(2020, Calendar.JULY, 11, 13, 23, 47, 345, "Europe/Berlin"));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than or equal to the expected.\n\tExpected:<2020-07-11T13:23:47.345+0200> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").isLessThanOrEqualTo(createCalendar(2020, Calendar.JULY, 11, 13, 23, 47, 345, "Europe/Berlin"));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be less than or equal to the expected.\n\tExpected:<2020-07-11T13:23:47.345+0200> but was:<2020-07-11T15:23:47.345+0000>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void isInRangeTest() {
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isInRange(createCalendar(2019, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), createCalendar(2021, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isInRange(createCalendar(2020, Calendar.JUNE, 11, 15, 23, 47, 345, "UTC"), createCalendar(2020, Calendar.AUGUST, 11, 15, 23, 47, 345, "UTC"));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isInRange(createCalendar(2020, Calendar.JULY, 10, 15, 23, 47, 345, "UTC"), createCalendar(2020, Calendar.JULY, 12, 15, 23, 47, 345, "UTC"));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isInRange(createCalendar(2020, Calendar.JULY, 11, 14, 23, 47, 345, "UTC"), createCalendar(2020, Calendar.JULY, 11, 16, 23, 47, 345, "UTC"));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isInRange(createCalendar(2020, Calendar.JULY, 11, 15, 22, 47, 345, "UTC"), createCalendar(2020, Calendar.JULY, 11, 15, 24, 47, 345, "UTC"));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isInRange(createCalendar(2020, Calendar.JULY, 11, 15, 23, 46, 345, "UTC"), createCalendar(2020, Calendar.JULY, 11, 15, 23, 48, 345, "UTC"));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isInRange(createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 346, "UTC"));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isInRange(createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 344, "UTC"), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 346, "UTC"));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin")).isInRange(createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Asia/Vientiane"), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));

        try {
            Raw.calendarAssertion().isInRange(createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"), createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).isInRange(createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"), createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").isInRange(createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"), createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).isInRange(null, createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").isInRange(null, createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).isInRange(createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"), null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").isInRange(createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"), null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC")).isInRange(null, createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"), "Message").isInRange(null, createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC")).isInRange(null, null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"), "Message").isInRange(null, null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC")).isInRange(createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"), null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedTo.");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"), "Message").isInRange(createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"), null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedTo.");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isInRange(createCalendar(2019, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be in the expected range.\n\tExpected:<2019-07-11T15:23:47.345+0000:2020-07-11T15:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").isInRange(createCalendar(2019, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be in the expected range.\n\tExpected:<2019-07-11T15:23:47.345+0000:2020-07-11T15:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isInRange(createCalendar(2021, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), createCalendar(2022, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be in the expected range.\n\tExpected:<2021-07-11T15:23:47.345+0000:2022-07-11T15:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").isInRange(createCalendar(2021, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), createCalendar(2022, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be in the expected range.\n\tExpected:<2021-07-11T15:23:47.345+0000:2022-07-11T15:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isInRange(createCalendar(2018, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), createCalendar(2019, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be in the expected range.\n\tExpected:<2018-07-11T15:23:47.345+0000:2019-07-11T15:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").isInRange(createCalendar(2018, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), createCalendar(2019, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be in the expected range.\n\tExpected:<2018-07-11T15:23:47.345+0000:2019-07-11T15:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void isNotInRangeTest() {
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isNotInRange(createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isNotInRange(createCalendar(2018, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), createCalendar(2019, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isNotInRange(createCalendar(2021, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), createCalendar(2022, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isNotInRange(createCalendar(2020, Calendar.MAY, 11, 15, 23, 47, 345, "UTC"), createCalendar(2020, Calendar.JUNE, 11, 15, 23, 47, 345, "UTC"));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isNotInRange(createCalendar(2020, Calendar.AUGUST, 11, 15, 23, 47, 345, "UTC"), createCalendar(2020, Calendar.SEPTEMBER, 11, 15, 23, 47, 345, "UTC"));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isNotInRange(createCalendar(2020, Calendar.JULY, 9, 15, 23, 47, 345, "UTC"), createCalendar(2020, Calendar.JULY, 10, 15, 23, 47, 345, "UTC"));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isNotInRange(createCalendar(2020, Calendar.JULY, 12, 15, 23, 47, 345, "UTC"), createCalendar(2020, Calendar.JULY, 13, 15, 23, 47, 345, "UTC"));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isNotInRange(createCalendar(2020, Calendar.JULY, 11, 13, 23, 47, 345, "UTC"), createCalendar(2020, Calendar.JULY, 11, 14, 23, 47, 345, "UTC"));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isNotInRange(createCalendar(2020, Calendar.JULY, 11, 16, 23, 47, 345, "UTC"), createCalendar(2020, Calendar.JULY, 11, 17, 23, 47, 345, "UTC"));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isNotInRange(createCalendar(2020, Calendar.JULY, 11, 15, 21, 47, 345, "UTC"), createCalendar(2020, Calendar.JULY, 11, 15, 22, 47, 345, "UTC"));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isNotInRange(createCalendar(2020, Calendar.JULY, 11, 15, 24, 47, 345, "UTC"), createCalendar(2020, Calendar.JULY, 11, 15, 25, 47, 345, "UTC"));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isNotInRange(createCalendar(2020, Calendar.JULY, 11, 15, 23, 45, 345, "UTC"), createCalendar(2020, Calendar.JULY, 11, 15, 23, 46, 345, "UTC"));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isNotInRange(createCalendar(2020, Calendar.JULY, 11, 15, 23, 48, 345, "UTC"), createCalendar(2020, Calendar.JULY, 11, 15, 23, 49, 345, "UTC"));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isNotInRange(createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 343, "UTC"), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 344, "UTC"));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isNotInRange(createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 346, "UTC"), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 347, "UTC"));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Asia/Vientiane")).isNotInRange(createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin"), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isNotInRange(createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Asia/Vientiane"), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin"));

        try {
            Raw.calendarAssertion().isNotInRange(createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"), createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).isNotInRange(createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"), createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").isNotInRange(createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"), createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).isNotInRange(null, createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").isNotInRange(null, createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).isNotInRange(createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"), null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").isNotInRange(createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"), null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC")).isNotInRange(null, createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"), "Message").isNotInRange(null, createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC")).isNotInRange(null, null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"), "Message").isNotInRange(null, null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC")).isNotInRange(createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"), null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedTo.");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"), "Message").isNotInRange(createCalendar(1, 1, 1, 1, 1, 1, 1, "UTC"), null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedTo.");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isNotInRange(createCalendar(2019, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), createCalendar(2021, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be in the expected range.\n\tExpected:<2019-07-11T15:23:47.345+0000:2021-07-11T15:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").isNotInRange(createCalendar(2019, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), createCalendar(2021, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be in the expected range.\n\tExpected:<2019-07-11T15:23:47.345+0000:2021-07-11T15:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).isNotInRange(createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), createCalendar(2021, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be in the expected range.\n\tExpected:<2020-07-11T15:23:47.345+0000:2021-07-11T15:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").isNotInRange(createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), createCalendar(2021, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be in the expected range.\n\tExpected:<2020-07-11T15:23:47.345+0000:2021-07-11T15:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0000>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin")).isNotInRange(createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Asia/Vientiane"), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be in the expected range.\n\tExpected:<2020-07-11T15:23:47.345+0700:2020-07-11T15:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0200>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin"), "Message").isNotInRange(createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Asia/Vientiane"), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be in the expected range.\n\tExpected:<2020-07-11T15:23:47.345+0700:2020-07-11T15:23:47.345+0000> but was:<2020-07-11T15:23:47.345+0200>");
        }
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
        initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toSecond().isEqualTo(47);
        initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toSecond().isEqualTo(47);
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toSecond().isEqualTo(46);
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toSecond().isEqualTo(46);

        try {
            Raw.calendarAssertion().toSecond();
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toSecond();
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toSecond();
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toSecond()).isEqualTo(193);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's second.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toSecond()).isEqualTo(193);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's second.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toSecond().isEqualTo(46);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<46> but was:<47>");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toSecond().isEqualTo(46);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<46> but was:<47>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toSecondMatcherTest() {
        initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toSecond(Matchers.is(Matchers.equalTo(47)));
        initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toSecond(Matchers.is(Matchers.equalTo(47)));
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toSecond(Matchers.is(Matchers.equalTo(46)));
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toSecond(Matchers.is(Matchers.equalTo(46)));

        try {
            Raw.calendarAssertion().toSecond(Matchers.equalTo(0));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toSecond(Matchers.equalTo(0));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toSecond(Matchers.equalTo(0));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toSecond(null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toSecond(null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toSecond(null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toSecond(null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toSecond(Matchers.is(Matchers.equalTo(46)));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's second.\nExpected: is <46>\n     but: was <47>");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toSecond(Matchers.is(Matchers.equalTo(46)));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's second.\nExpected: is <46>\n     but: was <47>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasSecondTest() {
        initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).hasSecond(47);
        initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).hasSecond(47);
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).hasSecond(46);
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).hasSecond(46);

        try {
            Raw.calendarAssertion().hasSecond(0);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).hasSecond(0);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").hasSecond(0);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).hasSecond(46);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<46> but was:<47>");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").hasSecond(46);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<46> but was:<47>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toMillisecondTest() {
        initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toMillisecond().isEqualTo(0);
        initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toMillisecond().isEqualTo(0);
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toMillisecond().isEqualTo(543);
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toMillisecond().isEqualTo(543);

        try {
            Raw.calendarAssertion().toMillisecond();
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toMillisecond();
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toMillisecond();
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toMillisecond()).isEqualTo(193);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's millisecond.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toMillisecond()).isEqualTo(193);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's millisecond.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 543)).toMillisecond().isEqualTo(544);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's millisecond.\n\tActual and expected values should be the same.\n\tExpected:<544> but was:<543>");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 543), "Message").toMillisecond().isEqualTo(544);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's millisecond.\n\tActual and expected values should be the same.\n\tExpected:<544> but was:<543>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toMillisecondMatcherTest() {
        initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toMillisecond(Matchers.is(Matchers.equalTo(0)));
        initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toMillisecond(Matchers.is(Matchers.equalTo(0)));
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toMillisecond(Matchers.is(Matchers.equalTo(543)));
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toMillisecond(Matchers.is(Matchers.equalTo(543)));

        try {
            Raw.calendarAssertion().toMillisecond(Matchers.equalTo(0));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toMillisecond(Matchers.equalTo(0));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toMillisecond(Matchers.equalTo(0));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toMillisecond(null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toMillisecond(null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).toMillisecond(null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toMillisecond(null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 543)).toMillisecond(Matchers.is(Matchers.equalTo(544)));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's millisecond.\nExpected: is <544>\n     but: was <543>");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 543), "Message").toMillisecond(Matchers.is(Matchers.equalTo(544)));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's millisecond.\nExpected: is <544>\n     but: was <543>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasMillisecondTest() {
        initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47)).hasMillisecond(0);
        initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47)).hasMillisecond(0);
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543)).hasMillisecond(543);
        initialize(Raw.calendarAssertion(), createUtcCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).hasMillisecond(543);

        try {
            Raw.calendarAssertion().hasMillisecond(0);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).hasMillisecond(0);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").hasMillisecond(0);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 543)).hasMillisecond(544);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's millisecond.\n\tActual and expected values should be the same.\n\tExpected:<544> but was:<543>");
        }
        try {
            initialize(Raw.calendarAssertion(), createUtcCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 543), "Message").hasMillisecond(544);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's millisecond.\n\tActual and expected values should be the same.\n\tExpected:<544> but was:<543>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toZoneOffsetTest() {
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).toZoneOffset().isEqualTo(0);
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC")).toZoneOffset().isEqualTo(0);
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC")).toZoneOffset().isEqualTo(0);
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).toZoneOffset().isEqualTo(0);
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).toZoneOffset().isEqualTo(7 * 60 * 60 * 1000);
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane")).toZoneOffset().isEqualTo(7 * 60 * 60 * 1000);
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane")).toZoneOffset().isEqualTo(7 * 60 * 60 * 1000);
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).toZoneOffset().isEqualTo(7 * 60 * 60 * 1000);
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).toZoneOffset().isEqualTo(60 * 60 * 1000);
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin")).toZoneOffset().isEqualTo(60 * 60 * 1000);
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin")).toZoneOffset().isEqualTo(60 * 60 * 1000);
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin")).toZoneOffset().isEqualTo(60 * 60 * 1000);

        try {
            Raw.calendarAssertion().toZoneOffset();
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toZoneOffset();
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toZoneOffset();
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).toZoneOffset()).isEqualTo(100);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's zone offset.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").toZoneOffset()).isEqualTo(100);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's zone offset.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 543, "UTC")).toZoneOffset().isEqualTo(100);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's zone offset.\n\tActual and expected values should be the same.\n\tExpected:<100> but was:<0>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 543, "UTC"), "Message").toZoneOffset().isEqualTo(100);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's zone offset.\n\tActual and expected values should be the same.\n\tExpected:<100> but was:<0>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toZoneOffsetMatcherTest() {
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).toZoneOffset(Matchers.is(Matchers.equalTo(0)));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC")).toZoneOffset(Matchers.is(Matchers.equalTo(0)));
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC")).toZoneOffset(Matchers.is(Matchers.equalTo(0)));
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).toZoneOffset(Matchers.is(Matchers.equalTo(0)));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).toZoneOffset(Matchers.is(Matchers.equalTo(7 * 60 * 60 * 1000)));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane")).toZoneOffset(Matchers.is(Matchers.equalTo(7 * 60 * 60 * 1000)));
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane")).toZoneOffset(Matchers.is(Matchers.equalTo(7 * 60 * 60 * 1000)));
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).toZoneOffset(Matchers.is(Matchers.equalTo(7 * 60 * 60 * 1000)));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).toZoneOffset(Matchers.is(Matchers.equalTo(60 * 60 * 1000)));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin")).toZoneOffset(Matchers.is(Matchers.equalTo(60 * 60 * 1000)));
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin")).toZoneOffset(Matchers.is(Matchers.equalTo(60 * 60 * 1000)));
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin")).toZoneOffset(Matchers.is(Matchers.equalTo(60 * 60 * 1000)));

        try {
            Raw.calendarAssertion().toZoneOffset(Matchers.equalTo(0));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toZoneOffset(Matchers.equalTo(0));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toZoneOffset(Matchers.equalTo(0));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toZoneOffset(null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toZoneOffset(null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).toZoneOffset(null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").toZoneOffset(null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 543, "UTC")).toZoneOffset(Matchers.is(Matchers.equalTo(100)));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's zone offset.\nExpected: is <100>\n     but: was <0>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 543, "UTC"), "Message").toZoneOffset(Matchers.is(Matchers.equalTo(100)));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's zone offset.\nExpected: is <100>\n     but: was <0>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasZoneOffsetTest() {
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasZoneOffset(0);
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC")).hasZoneOffset(0);
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC")).hasZoneOffset(0);
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).hasZoneOffset(0);
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).hasZoneOffset(7 * 60 * 60 * 1000);
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane")).hasZoneOffset(7 * 60 * 60 * 1000);
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasZoneOffset(7 * 60 * 60 * 1000);
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasZoneOffset(7 * 60 * 60 * 1000);
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).hasZoneOffset(60 * 60 * 1000);
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin")).hasZoneOffset(60 * 60 * 1000);
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin")).hasZoneOffset(60 * 60 * 1000);
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin")).hasZoneOffset(60 * 60 * 1000);

        try {
            Raw.calendarAssertion().hasZoneOffset(0);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).hasZoneOffset(0);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").hasZoneOffset(0);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 543, "UTC")).hasZoneOffset(100);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's zone offset.\n\tActual and expected values should be the same.\n\tExpected:<100> but was:<0>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 543, "UTC"), "Message").hasZoneOffset(100);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's zone offset.\n\tActual and expected values should be the same.\n\tExpected:<100> but was:<0>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toDstOffsetTest() {
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).toDstOffset().isEqualTo(0);
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC")).toDstOffset().isEqualTo(0);
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC")).toDstOffset().isEqualTo(0);
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).toDstOffset().isEqualTo(0);
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).toDstOffset().isEqualTo(0);
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane")).toDstOffset().isEqualTo(0);
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane")).toDstOffset().isEqualTo(0);
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).toDstOffset().isEqualTo(0);
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).toDstOffset().isEqualTo(60 * 60 * 1000);
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin")).toDstOffset().isEqualTo(0);
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin")).toDstOffset().isEqualTo(0);
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin")).toDstOffset().isEqualTo(0);

        try {
            Raw.calendarAssertion().toDstOffset();
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toDstOffset();
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toDstOffset();
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).toDstOffset()).isEqualTo(100);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's DST offset.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").toDstOffset()).isEqualTo(100);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's DST offset.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 543, "UTC")).toDstOffset().isEqualTo(100);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's DST offset.\n\tActual and expected values should be the same.\n\tExpected:<100> but was:<0>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 543, "UTC"), "Message").toDstOffset().isEqualTo(100);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's DST offset.\n\tActual and expected values should be the same.\n\tExpected:<100> but was:<0>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toDstOffsetMatcherTest() {
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).toDstOffset(Matchers.is(Matchers.equalTo(0)));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC")).toDstOffset(Matchers.is(Matchers.equalTo(0)));
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC")).toDstOffset(Matchers.is(Matchers.equalTo(0)));
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).toDstOffset(Matchers.is(Matchers.equalTo(0)));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).toDstOffset(Matchers.is(Matchers.equalTo(0)));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane")).toDstOffset(Matchers.is(Matchers.equalTo(0)));
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane")).toDstOffset(Matchers.is(Matchers.equalTo(0)));
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).toDstOffset(Matchers.is(Matchers.equalTo(0)));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).toDstOffset(Matchers.is(Matchers.equalTo(60 * 60 * 1000)));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin")).toDstOffset(Matchers.is(Matchers.equalTo(0)));
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin")).toDstOffset(Matchers.is(Matchers.equalTo(0)));
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin")).toDstOffset(Matchers.is(Matchers.equalTo(0)));

        try {
            Raw.calendarAssertion().toDstOffset(Matchers.equalTo(0));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toDstOffset(Matchers.equalTo(0));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toDstOffset(Matchers.equalTo(0));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toDstOffset(null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toDstOffset(null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).toDstOffset(null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").toDstOffset(null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 543, "UTC")).toDstOffset(Matchers.is(Matchers.equalTo(100)));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's DST offset.\nExpected: is <100>\n     but: was <0>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 543, "UTC"), "Message").toDstOffset(Matchers.is(Matchers.equalTo(100)));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's DST offset.\nExpected: is <100>\n     but: was <0>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasDstOffsetTest() {
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasDstOffset(0);
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC")).hasDstOffset(0);
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC")).hasDstOffset(0);
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).hasDstOffset(0);
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).hasDstOffset(0);
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane")).hasDstOffset(0);
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasDstOffset(0);
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasDstOffset(0);
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).hasDstOffset(60 * 60 * 1000);
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin")).hasDstOffset(0);
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin")).hasDstOffset(0);
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin")).hasDstOffset(0);

        try {
            Raw.calendarAssertion().hasDstOffset(0);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).hasDstOffset(0);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").hasDstOffset(0);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 543, "UTC")).hasDstOffset(100);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's DST offset.\n\tActual and expected values should be the same.\n\tExpected:<100> but was:<0>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 543, "UTC"), "Message").hasDstOffset(100);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's DST offset.\n\tActual and expected values should be the same.\n\tExpected:<100> but was:<0>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toTimeZoneTest() {
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).toTimeZone().isEqualTo(TimeZone.getTimeZone("UTC"));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC")).toTimeZone().isEqualTo(TimeZone.getTimeZone("UTC"));
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC")).toTimeZone().isEqualTo(TimeZone.getTimeZone("UTC"));
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).toTimeZone().isEqualTo(TimeZone.getTimeZone("UTC"));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).toTimeZone().isEqualTo(TimeZone.getTimeZone("Asia/Vientiane"));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane")).toTimeZone().isEqualTo(TimeZone.getTimeZone("Asia/Vientiane"));
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane")).toTimeZone().isEqualTo(TimeZone.getTimeZone("Asia/Vientiane"));
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).toTimeZone().isEqualTo(TimeZone.getTimeZone("Asia/Vientiane"));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).toTimeZone().isEqualTo(TimeZone.getTimeZone("Europe/Berlin"));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin")).toTimeZone().isEqualTo(TimeZone.getTimeZone("Europe/Berlin"));
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin")).toTimeZone().isEqualTo(TimeZone.getTimeZone("Europe/Berlin"));
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin")).toTimeZone().isEqualTo(TimeZone.getTimeZone("Europe/Berlin"));

        try {
            Raw.calendarAssertion().toTimeZone();
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toTimeZone();
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toTimeZone();
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).toTimeZone()).isEqualTo(TimeZone.getTimeZone("UTC"));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's time zone.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").toTimeZone()).isEqualTo(TimeZone.getTimeZone("UTCn"));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's time zone.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 543, "UTC")).toTimeZone().isEqualTo(TimeZone.getTimeZone("Europe/Berlin"));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's time zone.\n\tActual and expected values should be the same.\n\tExpected:<Europe/Berlin> but was:<UTC>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 543, "UTC"), "Message").toTimeZone().isEqualTo(TimeZone.getTimeZone("Europe/Berlin"));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's time zone.\n\tActual and expected values should be the same.\n\tExpected:<Europe/Berlin> but was:<UTC>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void toTimeZoneMatcherTest() {
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).toTimeZone(Matchers.is(Matchers.equalTo(TimeZone.getTimeZone("UTC"))));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC")).toTimeZone(Matchers.is(Matchers.equalTo(TimeZone.getTimeZone("UTC"))));
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC")).toTimeZone(Matchers.is(Matchers.equalTo(TimeZone.getTimeZone("UTC"))));
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).toTimeZone(Matchers.is(Matchers.equalTo(TimeZone.getTimeZone("UTC"))));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).toTimeZone(Matchers.is(Matchers.equalTo(TimeZone.getTimeZone("Asia/Vientiane"))));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane")).toTimeZone(Matchers.is(Matchers.equalTo(TimeZone.getTimeZone("Asia/Vientiane"))));
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane")).toTimeZone(Matchers.is(Matchers.equalTo(TimeZone.getTimeZone("Asia/Vientiane"))));
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).toTimeZone(Matchers.is(Matchers.equalTo(TimeZone.getTimeZone("Asia/Vientiane"))));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).toTimeZone(Matchers.is(Matchers.equalTo(TimeZone.getTimeZone("Europe/Berlin"))));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin")).toTimeZone(Matchers.is(Matchers.equalTo(TimeZone.getTimeZone("Europe/Berlin"))));
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin")).toTimeZone(Matchers.is(Matchers.equalTo(TimeZone.getTimeZone("Europe/Berlin"))));
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin")).toTimeZone(Matchers.is(Matchers.equalTo(TimeZone.getTimeZone("Europe/Berlin"))));

        try {
            Raw.calendarAssertion().toTimeZone(Matchers.equalTo(TimeZone.getTimeZone("UTC")));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toTimeZone(Matchers.equalTo(TimeZone.getTimeZone("UTC")));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toTimeZone(Matchers.equalTo(TimeZone.getTimeZone("UTC")));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).toTimeZone(null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").toTimeZone(null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).toTimeZone(null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").toTimeZone(null);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 543, "UTC")).toTimeZone(Matchers.is(Matchers.equalTo(TimeZone.getTimeZone("Europe/Berlin"))));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().matches("Check actual value's time zone.\nExpected: is <.*>\n     but: was <.*>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 543, "UTC"), "Message").toTimeZone(Matchers.is(Matchers.equalTo(TimeZone.getTimeZone("Europe/Berlin"))));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().matches("Message.\n\tCheck actual value's time zone.\nExpected: is <.*>\n     but: was <.*>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasTimeZoneTest() {
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasTimeZone(TimeZone.getTimeZone("UTC"));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC")).hasTimeZone(TimeZone.getTimeZone("UTC"));
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC")).hasTimeZone(TimeZone.getTimeZone("UTC"));
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).hasTimeZone(TimeZone.getTimeZone("UTC"));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).hasTimeZone(TimeZone.getTimeZone("Asia/Vientiane"));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane")).hasTimeZone(TimeZone.getTimeZone("Asia/Vientiane"));
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasTimeZone(TimeZone.getTimeZone("Asia/Vientiane"));
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasTimeZone(TimeZone.getTimeZone("Asia/Vientiane"));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).hasTimeZone(TimeZone.getTimeZone("Europe/Berlin"));
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin")).hasTimeZone(TimeZone.getTimeZone("Europe/Berlin"));
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin")).hasTimeZone(TimeZone.getTimeZone("Europe/Berlin"));
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin")).hasTimeZone(TimeZone.getTimeZone("Europe/Berlin"));

        try {
            Raw.calendarAssertion().hasTimeZone(TimeZone.getTimeZone("UTC"));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).hasTimeZone(TimeZone.getTimeZone("UTC"));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").hasTimeZone(TimeZone.getTimeZone("UTC"));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 543, "UTC")).hasTimeZone(TimeZone.getTimeZone("Europe/Berlin"));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's time zone.\n\tActual and expected values should be the same.\n\tExpected:<Europe/Berlin> but was:<UTC>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 543, "UTC"), "Message").hasTimeZone(TimeZone.getTimeZone("Europe/Berlin"));
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's time zone.\n\tActual and expected values should be the same.\n\tExpected:<Europe/Berlin> but was:<UTC>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasTimeZoneIdTest() {
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasTimeZoneId("UTC");
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC")).hasTimeZoneId("UTC");
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC")).hasTimeZoneId("UTC");
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).hasTimeZoneId("UTC");
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).hasTimeZoneId("Asia/Vientiane");
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane")).hasTimeZoneId("Asia/Vientiane");
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasTimeZoneId("Asia/Vientiane");
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasTimeZoneId("Asia/Vientiane");
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).hasTimeZoneId("Europe/Berlin");
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin")).hasTimeZoneId("Europe/Berlin");
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin")).hasTimeZoneId("Europe/Berlin");
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin")).hasTimeZoneId("Europe/Berlin");

        try {
            Raw.calendarAssertion().hasTimeZoneId("UTC");
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).hasTimeZoneId("UTC");
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").hasTimeZoneId("UTC");
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 543, "UTC")).hasTimeZoneId("Europe/Berlin");
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's time zone.\n\tCheck actual value's ID.\n\tActual and expected values should be the same.\n\tExpected:<Europe/Berlin> but was:<UTC>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 543, "UTC"), "Message").hasTimeZoneId("Europe/Berlin");
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's time zone.\n\tCheck actual value's ID.\n\tActual and expected values should be the same.\n\tExpected:<Europe/Berlin> but was:<UTC>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasDateTest() {
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasDate(2020, Calendar.JULY, 11);
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC")).hasDate(2020, Calendar.DECEMBER, 11);
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC")).hasDate(1324, Calendar.JULY, 21);
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).hasDate(1324, Calendar.DECEMBER, 21);
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).hasDate(2020, Calendar.JULY, 11);
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane")).hasDate(2020, Calendar.DECEMBER, 11);
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasDate(1324, Calendar.JULY, 21);
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasDate(1324, Calendar.DECEMBER, 21);
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).hasDate(2020, Calendar.JULY, 11);
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin")).hasDate(2020, Calendar.DECEMBER, 11);
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin")).hasDate(1324, Calendar.JULY, 21);
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin")).hasDate(1324, Calendar.DECEMBER, 21);

        try {
            Raw.calendarAssertion().hasDate(1, 1, 1);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).hasDate(1, 1, 1);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").hasDate(1, 1, 1);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasDate(2019, Calendar.JULY, 11);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's year.\n\tActual and expected values should be the same.\n\tExpected:<2019> but was:<2020>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasDate(2019, Calendar.JULY, 11);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's year.\n\tActual and expected values should be the same.\n\tExpected:<2019> but was:<2020>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasDate(2020, Calendar.AUGUST, 11);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's month.\n\tActual and expected values should be the same.\n\tExpected:<7> but was:<6>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasDate(2020, Calendar.AUGUST, 11);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's month.\n\tActual and expected values should be the same.\n\tExpected:<7> but was:<6>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasDate(2020, Calendar.JULY, 12);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's day of month.\n\tActual and expected values should be the same.\n\tExpected:<12> but was:<11>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasDate(2020, Calendar.JULY, 12);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's day of month.\n\tActual and expected values should be the same.\n\tExpected:<12> but was:<11>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasDateTimeZoneIdTest() {
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasDate(2020, Calendar.JULY, 11, "UTC");
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC")).hasDate(2020, Calendar.DECEMBER, 11, "UTC");
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC")).hasDate(1324, Calendar.JULY, 21, "UTC");
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).hasDate(1324, Calendar.DECEMBER, 21, "UTC");
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).hasDate(2020, Calendar.JULY, 11, "Asia/Vientiane");
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane")).hasDate(2020, Calendar.DECEMBER, 11, "Asia/Vientiane");
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasDate(1324, Calendar.JULY, 21, "Asia/Vientiane");
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasDate(1324, Calendar.DECEMBER, 21, "Asia/Vientiane");
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).hasDate(2020, Calendar.JULY, 11, "Europe/Berlin");
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin")).hasDate(2020, Calendar.DECEMBER, 11, "Europe/Berlin");
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin")).hasDate(1324, Calendar.JULY, 21, "Europe/Berlin");
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin")).hasDate(1324, Calendar.DECEMBER, 21, "Europe/Berlin");

        try {
            Raw.calendarAssertion().hasDate(1, 1, 1, "UTC");
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).hasDate(1, 1, 1, "UTC");
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").hasDate(1, 1, 1, "UTC");
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasDate(2019, Calendar.JULY, 11, "UTC");
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's year.\n\tActual and expected values should be the same.\n\tExpected:<2019> but was:<2020>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasDate(2019, Calendar.JULY, 11, "UTC");
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's year.\n\tActual and expected values should be the same.\n\tExpected:<2019> but was:<2020>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasDate(2020, Calendar.AUGUST, 11, "UTC");
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's month.\n\tActual and expected values should be the same.\n\tExpected:<7> but was:<6>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasDate(2020, Calendar.AUGUST, 11, "UTC");
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's month.\n\tActual and expected values should be the same.\n\tExpected:<7> but was:<6>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasDate(2020, Calendar.JULY, 12, "UTC");
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's day of month.\n\tActual and expected values should be the same.\n\tExpected:<12> but was:<11>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasDate(2020, Calendar.JULY, 12, "UTC");
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's day of month.\n\tActual and expected values should be the same.\n\tExpected:<12> but was:<11>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasDate(2020, Calendar.JULY, 11, "Europe/Berlin");
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's time zone.\n\tCheck actual value's ID.\n\tActual and expected values should be the same.\n\tExpected:<Europe/Berlin> but was:<UTC>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasDate(2020, Calendar.JULY, 11, "Europe/Berlin");
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's time zone.\n\tCheck actual value's ID.\n\tActual and expected values should be the same.\n\tExpected:<Europe/Berlin> but was:<UTC>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasUtcDateTest() {
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasUtcDate(2020, Calendar.JULY, 11);
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC")).hasUtcDate(2020, Calendar.DECEMBER, 11);
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC")).hasUtcDate(1324, Calendar.JULY, 21);
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).hasUtcDate(1324, Calendar.DECEMBER, 21);
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).hasUtcDate(2020, Calendar.JULY, 11);
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane")).hasUtcDate(2020, Calendar.DECEMBER, 11);
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasUtcDate(1324, Calendar.JULY, 20);
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasUtcDate(1324, Calendar.DECEMBER, 20);
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).hasUtcDate(2020, Calendar.JULY, 11);
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin")).hasUtcDate(2020, Calendar.DECEMBER, 11);
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin")).hasUtcDate(1324, Calendar.JULY, 21);
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin")).hasUtcDate(1324, Calendar.DECEMBER, 21);

        try {
            Raw.calendarAssertion().hasUtcDate(1, 1, 1);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).hasUtcDate(1, 1, 1);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").hasUtcDate(1, 1, 1);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).hasUtcDate(2019, Calendar.JULY, 11);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's date in time zone: UTC.\n\tCheck actual value's year.\n\tActual and expected values should be the same.\n\tExpected:<2019> but was:<2020>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin"), "Message").hasUtcDate(2019, Calendar.JULY, 11);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's date in time zone: UTC.\n\tCheck actual value's year.\n\tActual and expected values should be the same.\n\tExpected:<2019> but was:<2020>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).hasUtcDate(2020, Calendar.AUGUST, 11);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's date in time zone: UTC.\n\tCheck actual value's month.\n\tActual and expected values should be the same.\n\tExpected:<7> but was:<6>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin"), "Message").hasUtcDate(2020, Calendar.AUGUST, 11);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's date in time zone: UTC.\n\tCheck actual value's month.\n\tActual and expected values should be the same.\n\tExpected:<7> but was:<6>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).hasUtcDate(2020, Calendar.JULY, 12);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's date in time zone: UTC.\n\tCheck actual value's day of month.\n\tActual and expected values should be the same.\n\tExpected:<12> but was:<11>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin"), "Message").hasUtcDate(2020, Calendar.JULY, 12);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's date in time zone: UTC.\n\tCheck actual value's day of month.\n\tActual and expected values should be the same.\n\tExpected:<12> but was:<11>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasTimeTest() {
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasTime(15, 23, 47);
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC")).hasTime(15, 23, 47);
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC")).hasTime(3, 22, 46);
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).hasTime(3, 22, 46);
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).hasTime(15, 23, 47);
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane")).hasTime(15, 23, 47);
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasTime(3, 22, 46);
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasTime(3, 22, 46);
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).hasTime(15, 23, 47);
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin")).hasTime(15, 23, 47);
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin")).hasTime(3, 22, 46);
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin")).hasTime(3, 22, 46);

        try {
            Raw.calendarAssertion().hasTime(1, 1, 1);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).hasTime(1, 1, 1);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").hasTime(1, 1, 1);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasTime(16, 23, 47);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<16> but was:<15>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasTime(16, 23, 47);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<16> but was:<15>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasTime(15, 22, 47);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<22> but was:<23>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasTime(15, 22, 47);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<22> but was:<23>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasTime(15, 23, 45);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<45> but was:<47>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasTime(15, 23, 45);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<45> but was:<47>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasTimeTimeZoneIdTest() {
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasTime(15, 23, 47, "UTC");
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC")).hasTime(15, 23, 47, "UTC");
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC")).hasTime(3, 22, 46, "UTC");
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).hasTime(3, 22, 46, "UTC");
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).hasTime(15, 23, 47, "Asia/Vientiane");
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane")).hasTime(15, 23, 47, "Asia/Vientiane");
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasTime(3, 22, 46, "Asia/Vientiane");
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasTime(3, 22, 46, "Asia/Vientiane");
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).hasTime(15, 23, 47, "Europe/Berlin");
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin")).hasTime(15, 23, 47, "Europe/Berlin");
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin")).hasTime(3, 22, 46, "Europe/Berlin");
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin")).hasTime(3, 22, 46, "Europe/Berlin");

        try {
            Raw.calendarAssertion().hasTime(1, 1, 1, "UTC");
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).hasTime(1, 1, 1, "UTC");
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").hasTime(1, 1, 1, "UTC");
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasTime(16, 23, 47, "UTC");
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<16> but was:<15>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasTime(16, 23, 47, "UTC");
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<16> but was:<15>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasTime(15, 22, 47, "UTC");
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<22> but was:<23>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasTime(15, 22, 47, "UTC");
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<22> but was:<23>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasTime(15, 23, 45, "UTC");
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<45> but was:<47>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasTime(15, 23, 45, "UTC");
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<45> but was:<47>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasTime(15, 23, 47, "Europe/Berlin");
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's time zone.\n\tCheck actual value's ID.\n\tActual and expected values should be the same.\n\tExpected:<Europe/Berlin> but was:<UTC>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasTime(15, 23, 47, "Europe/Berlin");
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's time zone.\n\tCheck actual value's ID.\n\tActual and expected values should be the same.\n\tExpected:<Europe/Berlin> but was:<UTC>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasTimeMillisecondTest() {
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasTime(15, 23, 47, 0);
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC")).hasTime(15, 23, 47, 0);
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC")).hasTime(3, 22, 46, 543);
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).hasTime(3, 22, 46, 543);
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).hasTime(15, 23, 47, 0);
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane")).hasTime(15, 23, 47, 0);
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasTime(3, 22, 46, 543);
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasTime(3, 22, 46, 543);
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).hasTime(15, 23, 47, 0);
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin")).hasTime(15, 23, 47, 0);
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin")).hasTime(3, 22, 46, 543);
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin")).hasTime(3, 22, 46, 543);

        try {
            Raw.calendarAssertion().hasTime(1, 1, 1, 1);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).hasTime(1, 1, 1, 1);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").hasTime(1, 1, 1, 1);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasTime(16, 23, 47, 345);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<16> but was:<15>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasTime(16, 23, 47, 345);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<16> but was:<15>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasTime(15, 22, 47, 345);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<22> but was:<23>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasTime(15, 22, 47, 345);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<22> but was:<23>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasTime(15, 23, 45, 345);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<45> but was:<47>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasTime(15, 23, 45, 345);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<45> but was:<47>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasTime(15, 23, 47, 555);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's millisecond.\n\tActual and expected values should be the same.\n\tExpected:<555> but was:<345>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasTime(15, 23, 47, 555);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's millisecond.\n\tActual and expected values should be the same.\n\tExpected:<555> but was:<345>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasTimeMillisecondTimeZoneIdTest() {
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasTime(15, 23, 47, 0, "UTC");
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC")).hasTime(15, 23, 47, 0, "UTC");
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC")).hasTime(3, 22, 46, 543, "UTC");
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).hasTime(3, 22, 46, 543, "UTC");
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).hasTime(15, 23, 47, 0, "Asia/Vientiane");
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane")).hasTime(15, 23, 47, 0, "Asia/Vientiane");
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasTime(3, 22, 46, 543, "Asia/Vientiane");
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasTime(3, 22, 46, 543, "Asia/Vientiane");
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).hasTime(15, 23, 47, 0, "Europe/Berlin");
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin")).hasTime(15, 23, 47, 0, "Europe/Berlin");
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin")).hasTime(3, 22, 46, 543, "Europe/Berlin");
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin")).hasTime(3, 22, 46, 543, "Europe/Berlin");

        try {
            Raw.calendarAssertion().hasTime(1, 1, 1, 1, "UTC");
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).hasTime(1, 1, 1, 1, "UTC");
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").hasTime(1, 1, 1, 1, "UTC");
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasTime(16, 23, 47, 345, "UTC");
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<16> but was:<15>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasTime(16, 23, 47, 345, "UTC");
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<16> but was:<15>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasTime(15, 22, 47, 345, "UTC");
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<22> but was:<23>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasTime(15, 22, 47, 345, "UTC");
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<22> but was:<23>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasTime(15, 23, 45, 345, "UTC");
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<45> but was:<47>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasTime(15, 23, 45, 345, "UTC");
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<45> but was:<47>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasTime(15, 23, 47, 555, "UTC");
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's millisecond.\n\tActual and expected values should be the same.\n\tExpected:<555> but was:<345>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasTime(15, 23, 47, 555, "UTC");
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's millisecond.\n\tActual and expected values should be the same.\n\tExpected:<555> but was:<345>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasTime(15, 23, 47, 345, "Europe/Berlin");
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's time zone.\n\tCheck actual value's ID.\n\tActual and expected values should be the same.\n\tExpected:<Europe/Berlin> but was:<UTC>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasTime(15, 23, 47, 345, "Europe/Berlin");
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's time zone.\n\tCheck actual value's ID.\n\tActual and expected values should be the same.\n\tExpected:<Europe/Berlin> but was:<UTC>");
        }

    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasUtcTimeTest() {
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasUtcTime(15, 23, 47);
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC")).hasUtcTime(15, 23, 47);
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC")).hasUtcTime(3, 22, 46);
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).hasUtcTime(3, 22, 46);
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).hasUtcTime(8, 23, 47);
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane")).hasUtcTime(8, 23, 47);
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasUtcTime(20, 22, 46);
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasUtcTime(20, 22, 46);
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).hasUtcTime(13, 23, 47);
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin")).hasUtcTime(14, 23, 47);
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin")).hasUtcTime(2, 22, 46);
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin")).hasUtcTime(2, 22, 46);

        try {
            Raw.calendarAssertion().hasUtcTime(1, 1, 1);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).hasUtcTime(1, 1, 1);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").hasUtcTime(1, 1, 1);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).hasUtcTime(11, 23, 47);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's date in time zone: UTC.\n\tCheck actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<11> but was:<13>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin"), "Message").hasUtcTime(11, 23, 47);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's date in time zone: UTC.\n\tCheck actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<11> but was:<13>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).hasUtcTime(13, 22, 47);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's date in time zone: UTC.\n\tCheck actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<22> but was:<23>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin"), "Message").hasUtcTime(13, 22, 47);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's date in time zone: UTC.\n\tCheck actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<22> but was:<23>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).hasUtcTime(13, 23, 45);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's date in time zone: UTC.\n\tCheck actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<45> but was:<47>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin"), "Message").hasUtcTime(13, 23, 45);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's date in time zone: UTC.\n\tCheck actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<45> but was:<47>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasUtcTimeMillisecondTest() {
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasUtcTime(15, 23, 47, 0);
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC")).hasUtcTime(15, 23, 47, 0);
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC")).hasUtcTime(3, 22, 46, 543);
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).hasUtcTime(3, 22, 46, 543);
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).hasUtcTime(8, 23, 47, 0);
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane")).hasUtcTime(8, 23, 47, 0);
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasUtcTime(20, 22, 46, 543);
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasUtcTime(20, 22, 46, 543);
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).hasUtcTime(13, 23, 47, 0);
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin")).hasUtcTime(14, 23, 47, 0);
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin")).hasUtcTime(2, 22, 46, 543);
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin")).hasUtcTime(2, 22, 46, 543);

        try {
            Raw.calendarAssertion().hasUtcTime(1, 1, 1, 1);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).hasUtcTime(1, 1, 1, 1);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").hasUtcTime(1, 1, 1, 1);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin")).hasUtcTime(11, 23, 47, 345);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's date in time zone: UTC.\n\tCheck actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<11> but was:<13>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin"), "Message").hasUtcTime(11, 23, 47, 345);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's date in time zone: UTC.\n\tCheck actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<11> but was:<13>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin")).hasUtcTime(13, 22, 47, 345);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's date in time zone: UTC.\n\tCheck actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<22> but was:<23>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin"), "Message").hasUtcTime(13, 22, 47, 345);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's date in time zone: UTC.\n\tCheck actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<22> but was:<23>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin")).hasUtcTime(13, 23, 45, 345);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's date in time zone: UTC.\n\tCheck actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<45> but was:<47>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin"), "Message").hasUtcTime(13, 23, 45, 345);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's date in time zone: UTC.\n\tCheck actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<45> but was:<47>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin")).hasUtcTime(13, 23, 47, 555);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's date in time zone: UTC.\n\tCheck actual value's millisecond.\n\tActual and expected values should be the same.\n\tExpected:<555> but was:<345>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin"), "Message").hasUtcTime(13, 23, 47, 555);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's date in time zone: UTC.\n\tCheck actual value's millisecond.\n\tActual and expected values should be the same.\n\tExpected:<555> but was:<345>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasDateAndTimeTest() {
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47);
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC")).hasDateAndTime(2020, Calendar.DECEMBER, 11, 15, 23, 47);
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC")).hasDateAndTime(1324, Calendar.JULY, 21, 3, 22, 46);
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).hasDateAndTime(1324, Calendar.DECEMBER, 21, 3, 22, 46);
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).hasDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47);
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane")).hasDateAndTime(2020, Calendar.DECEMBER, 11, 15, 23, 47);
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasDateAndTime(1324, Calendar.JULY, 21, 3, 22, 46);
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasDateAndTime(1324, Calendar.DECEMBER, 21, 3, 22, 46);
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).hasDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47);
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin")).hasDateAndTime(2020, Calendar.DECEMBER, 11, 15, 23, 47);
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin")).hasDateAndTime(1324, Calendar.JULY, 21, 3, 22, 46);
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin")).hasDateAndTime(1324, Calendar.DECEMBER, 21, 3, 22, 46);

        try {
            Raw.calendarAssertion().hasDateAndTime(1, 1, 1, 1, 1, 1);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).hasDateAndTime(1, 1, 1, 1, 1, 1);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").hasDateAndTime(1, 1, 1, 1, 1, 1);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasDateAndTime(2019, Calendar.JULY, 11, 15, 23, 47);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's year.\n\tActual and expected values should be the same.\n\tExpected:<2019> but was:<2020>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasDateAndTime(2019, Calendar.JULY, 11, 15, 23, 47);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's year.\n\tActual and expected values should be the same.\n\tExpected:<2019> but was:<2020>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasDateAndTime(2020, Calendar.AUGUST, 11, 15, 23, 47);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's month.\n\tActual and expected values should be the same.\n\tExpected:<7> but was:<6>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasDateAndTime(2020, Calendar.AUGUST, 11, 15, 23, 47);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's month.\n\tActual and expected values should be the same.\n\tExpected:<7> but was:<6>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasDateAndTime(2020, Calendar.JULY, 12, 15, 23, 47);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's day of month.\n\tActual and expected values should be the same.\n\tExpected:<12> but was:<11>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasDateAndTime(2020, Calendar.JULY, 12, 15, 23, 47);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's day of month.\n\tActual and expected values should be the same.\n\tExpected:<12> but was:<11>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasDateAndTime(2020, Calendar.JULY, 11, 16, 23, 47);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<16> but was:<15>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasDateAndTime(2020, Calendar.JULY, 11, 16, 23, 47);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<16> but was:<15>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasDateAndTime(2020, Calendar.JULY, 11, 15, 24, 47);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<24> but was:<23>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasDateAndTime(2020, Calendar.JULY, 11, 15, 24, 47);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<24> but was:<23>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasDateAndTime(2020, Calendar.JULY, 11, 15, 23, 48);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<48> but was:<47>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasDateAndTime(2020, Calendar.JULY, 11, 15, 23, 48);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<48> but was:<47>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasDateAndTimeTimeZoneIdTest() {
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, "UTC");
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC")).hasDateAndTime(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC");
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC")).hasDateAndTime(1324, Calendar.JULY, 21, 3, 22, 46, "UTC");
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).hasDateAndTime(1324, Calendar.DECEMBER, 21, 3, 22, 46, "UTC");
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).hasDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane");
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane")).hasDateAndTime(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane");
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasDateAndTime(1324, Calendar.JULY, 21, 3, 22, 46, "Asia/Vientiane");
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasDateAndTime(1324, Calendar.DECEMBER, 21, 3, 22, 46, "Asia/Vientiane");
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).hasDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin");
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin")).hasDateAndTime(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin");
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin")).hasDateAndTime(1324, Calendar.JULY, 21, 3, 22, 46, "Europe/Berlin");
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin")).hasDateAndTime(1324, Calendar.DECEMBER, 21, 3, 22, 46, "Europe/Berlin");

        try {
            Raw.calendarAssertion().hasDateAndTime(1, 1, 1, 1, 1, 1, "UTC");
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).hasDateAndTime(1, 1, 1, 1, 1, 1, "UTC");
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").hasDateAndTime(1, 1, 1, 1, 1, 1, "UTC");
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasDateAndTime(2019, Calendar.JULY, 11, 15, 23, 47, "UTC");
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's year.\n\tActual and expected values should be the same.\n\tExpected:<2019> but was:<2020>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasDateAndTime(2019, Calendar.JULY, 11, 15, 23, 47, "UTC");
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's year.\n\tActual and expected values should be the same.\n\tExpected:<2019> but was:<2020>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasDateAndTime(2020, Calendar.AUGUST, 11, 15, 23, 47, "UTC");
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's month.\n\tActual and expected values should be the same.\n\tExpected:<7> but was:<6>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasDateAndTime(2020, Calendar.AUGUST, 11, 15, 23, 47, "UTC");
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's month.\n\tActual and expected values should be the same.\n\tExpected:<7> but was:<6>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasDateAndTime(2020, Calendar.JULY, 12, 15, 23, 47, "UTC");
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's day of month.\n\tActual and expected values should be the same.\n\tExpected:<12> but was:<11>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasDateAndTime(2020, Calendar.JULY, 12, 15, 23, 47, "UTC");
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's day of month.\n\tActual and expected values should be the same.\n\tExpected:<12> but was:<11>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasDateAndTime(2020, Calendar.JULY, 11, 16, 23, 47, "UTC");
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<16> but was:<15>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasDateAndTime(2020, Calendar.JULY, 11, 16, 23, 47, "UTC");
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<16> but was:<15>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasDateAndTime(2020, Calendar.JULY, 11, 15, 24, 47, "UTC");
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<24> but was:<23>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasDateAndTime(2020, Calendar.JULY, 11, 15, 24, 47, "UTC");
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<24> but was:<23>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasDateAndTime(2020, Calendar.JULY, 11, 15, 23, 48, "UTC");
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<48> but was:<47>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasDateAndTime(2020, Calendar.JULY, 11, 15, 23, 48, "UTC");
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<48> but was:<47>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin");
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's time zone.\n\tCheck actual value's ID.\n\tActual and expected values should be the same.\n\tExpected:<Europe/Berlin> but was:<UTC>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin");
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's time zone.\n\tCheck actual value's ID.\n\tActual and expected values should be the same.\n\tExpected:<Europe/Berlin> but was:<UTC>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasDateAndTimeMillisecondTest() {
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, 0);
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC")).hasDateAndTime(2020, Calendar.DECEMBER, 11, 15, 23, 47, 0);
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC")).hasDateAndTime(1324, Calendar.JULY, 21, 3, 22, 46, 543);
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).hasDateAndTime(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543);
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).hasDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, 0);
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane")).hasDateAndTime(2020, Calendar.DECEMBER, 11, 15, 23, 47, 0);
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasDateAndTime(1324, Calendar.JULY, 21, 3, 22, 46, 543);
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasDateAndTime(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543);
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).hasDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, 0);
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin")).hasDateAndTime(2020, Calendar.DECEMBER, 11, 15, 23, 47, 0);
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin")).hasDateAndTime(1324, Calendar.JULY, 21, 3, 22, 46, 543);
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin")).hasDateAndTime(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543);

        try {
            Raw.calendarAssertion().hasDateAndTime(1, 1, 1, 1, 1, 1, 1);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).hasDateAndTime(1, 1, 1, 1, 1, 1, 1);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").hasDateAndTime(1, 1, 1, 1, 1, 1, 1);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasDateAndTime(2019, Calendar.JULY, 11, 15, 23, 47, 345);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's year.\n\tActual and expected values should be the same.\n\tExpected:<2019> but was:<2020>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasDateAndTime(2019, Calendar.JULY, 11, 15, 23, 47, 345);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's year.\n\tActual and expected values should be the same.\n\tExpected:<2019> but was:<2020>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasDateAndTime(2020, Calendar.AUGUST, 11, 15, 23, 47, 345);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's month.\n\tActual and expected values should be the same.\n\tExpected:<7> but was:<6>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasDateAndTime(2020, Calendar.AUGUST, 11, 15, 23, 47, 345);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's month.\n\tActual and expected values should be the same.\n\tExpected:<7> but was:<6>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasDateAndTime(2020, Calendar.JULY, 12, 15, 23, 47, 345);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's day of month.\n\tActual and expected values should be the same.\n\tExpected:<12> but was:<11>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasDateAndTime(2020, Calendar.JULY, 12, 15, 23, 47, 345);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's day of month.\n\tActual and expected values should be the same.\n\tExpected:<12> but was:<11>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasDateAndTime(2020, Calendar.JULY, 11, 16, 23, 47, 345);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<16> but was:<15>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasDateAndTime(2020, Calendar.JULY, 11, 16, 23, 47, 345);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<16> but was:<15>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasDateAndTime(2020, Calendar.JULY, 11, 15, 24, 47, 345);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<24> but was:<23>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasDateAndTime(2020, Calendar.JULY, 11, 15, 24, 47, 345);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<24> but was:<23>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasDateAndTime(2020, Calendar.JULY, 11, 15, 23, 48, 345);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<48> but was:<47>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasDateAndTime(2020, Calendar.JULY, 11, 15, 23, 48, 345);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<48> but was:<47>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, 555);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's millisecond.\n\tActual and expected values should be the same.\n\tExpected:<555> but was:<345>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, 555);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's millisecond.\n\tActual and expected values should be the same.\n\tExpected:<555> but was:<345>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasDateAndTimeMillisecondTimeZoneIdTest() {
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, 0, "UTC");
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC")).hasDateAndTime(2020, Calendar.DECEMBER, 11, 15, 23, 47, 0, "UTC");
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC")).hasDateAndTime(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC");
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).hasDateAndTime(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC");
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).hasDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, 0, "Asia/Vientiane");
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane")).hasDateAndTime(2020, Calendar.DECEMBER, 11, 15, 23, 47, 0, "Asia/Vientiane");
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasDateAndTime(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane");
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasDateAndTime(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane");
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).hasDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, 0, "Europe/Berlin");
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin")).hasDateAndTime(2020, Calendar.DECEMBER, 11, 15, 23, 47, 0, "Europe/Berlin");
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin")).hasDateAndTime(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin");
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin")).hasDateAndTime(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin");

        try {
            Raw.calendarAssertion().hasDateAndTime(1, 1, 1, 1, 1, 1, 1, "UTC");
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).hasDateAndTime(1, 1, 1, 1, 1, 1, 1, "UTC");
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").hasDateAndTime(1, 1, 1, 1, 1, 1, 1, "UTC");
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasDateAndTime(2019, Calendar.JULY, 11, 15, 23, 47, 345, "UTC");
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's year.\n\tActual and expected values should be the same.\n\tExpected:<2019> but was:<2020>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasDateAndTime(2019, Calendar.JULY, 11, 15, 23, 47, 345, "UTC");
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's year.\n\tActual and expected values should be the same.\n\tExpected:<2019> but was:<2020>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasDateAndTime(2020, Calendar.AUGUST, 11, 15, 23, 47, 345, "UTC");
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's month.\n\tActual and expected values should be the same.\n\tExpected:<7> but was:<6>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasDateAndTime(2020, Calendar.AUGUST, 11, 15, 23, 47, 345, "UTC");
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's month.\n\tActual and expected values should be the same.\n\tExpected:<7> but was:<6>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasDateAndTime(2020, Calendar.JULY, 12, 15, 23, 47, 345, "UTC");
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's day of month.\n\tActual and expected values should be the same.\n\tExpected:<12> but was:<11>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasDateAndTime(2020, Calendar.JULY, 12, 15, 23, 47, 345, "UTC");
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's day of month.\n\tActual and expected values should be the same.\n\tExpected:<12> but was:<11>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasDateAndTime(2020, Calendar.JULY, 11, 16, 23, 47, 345, "UTC");
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<16> but was:<15>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasDateAndTime(2020, Calendar.JULY, 11, 16, 23, 47, 345, "UTC");
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<16> but was:<15>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasDateAndTime(2020, Calendar.JULY, 11, 15, 24, 47, 345, "UTC");
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<24> but was:<23>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasDateAndTime(2020, Calendar.JULY, 11, 15, 24, 47, 345, "UTC");
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<24> but was:<23>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasDateAndTime(2020, Calendar.JULY, 11, 15, 23, 48, 345, "UTC");
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<48> but was:<47>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasDateAndTime(2020, Calendar.JULY, 11, 15, 23, 48, 345, "UTC");
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<48> but was:<47>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, 555, "UTC");
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's millisecond.\n\tActual and expected values should be the same.\n\tExpected:<555> but was:<345>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, 555, "UTC");
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's millisecond.\n\tActual and expected values should be the same.\n\tExpected:<555> but was:<345>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin");
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's time zone.\n\tCheck actual value's ID.\n\tActual and expected values should be the same.\n\tExpected:<Europe/Berlin> but was:<UTC>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, 345, "Europe/Berlin");
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's time zone.\n\tCheck actual value's ID.\n\tActual and expected values should be the same.\n\tExpected:<Europe/Berlin> but was:<UTC>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasUtcDateAndTimeTest() {
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasUtcDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47);
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC")).hasUtcDateAndTime(2020, Calendar.DECEMBER, 11, 15, 23, 47);
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC")).hasUtcDateAndTime(1324, Calendar.JULY, 21, 3, 22, 46);
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).hasUtcDateAndTime(1324, Calendar.DECEMBER, 21, 3, 22, 46);
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).hasUtcDateAndTime(2020, Calendar.JULY, 11, 8, 23, 47);
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane")).hasUtcDateAndTime(2020, Calendar.DECEMBER, 11, 8, 23, 47);
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasUtcDateAndTime(1324, Calendar.JULY, 20, 20, 22, 46);
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasUtcDateAndTime(1324, Calendar.DECEMBER, 20, 20, 22, 46);
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).hasUtcDateAndTime(2020, Calendar.JULY, 11, 13, 23, 47);
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin")).hasUtcDateAndTime(2020, Calendar.DECEMBER, 11, 14, 23, 47);
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin")).hasUtcDateAndTime(1324, Calendar.JULY, 21, 2, 22, 46);
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin")).hasUtcDateAndTime(1324, Calendar.DECEMBER, 21, 2, 22, 46);

        try {
            Raw.calendarAssertion().hasUtcDateAndTime(1, 1, 1, 1, 1, 1);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).hasUtcDateAndTime(1, 1, 1, 1, 1, 1);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").hasUtcDateAndTime(1, 1, 1, 1, 1, 1);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasUtcDateAndTime(2019, Calendar.JULY, 11, 15, 23, 47);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's date in time zone: UTC.\n\tCheck actual value's year.\n\tActual and expected values should be the same.\n\tExpected:<2019> but was:<2020>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasUtcDateAndTime(2019, Calendar.JULY, 11, 15, 23, 47);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's date in time zone: UTC.\n\tCheck actual value's year.\n\tActual and expected values should be the same.\n\tExpected:<2019> but was:<2020>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasUtcDateAndTime(2020, Calendar.AUGUST, 11, 15, 23, 47);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's date in time zone: UTC.\n\tCheck actual value's month.\n\tActual and expected values should be the same.\n\tExpected:<7> but was:<6>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasUtcDateAndTime(2020, Calendar.AUGUST, 11, 15, 23, 47);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's date in time zone: UTC.\n\tCheck actual value's month.\n\tActual and expected values should be the same.\n\tExpected:<7> but was:<6>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasUtcDateAndTime(2020, Calendar.JULY, 12, 15, 23, 47);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's date in time zone: UTC.\n\tCheck actual value's day of month.\n\tActual and expected values should be the same.\n\tExpected:<12> but was:<11>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasUtcDateAndTime(2020, Calendar.JULY, 12, 15, 23, 47);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's date in time zone: UTC.\n\tCheck actual value's day of month.\n\tActual and expected values should be the same.\n\tExpected:<12> but was:<11>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasUtcDateAndTime(2020, Calendar.JULY, 11, 16, 23, 47);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's date in time zone: UTC.\n\tCheck actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<16> but was:<15>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasUtcDateAndTime(2020, Calendar.JULY, 11, 16, 23, 47);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's date in time zone: UTC.\n\tCheck actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<16> but was:<15>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasUtcDateAndTime(2020, Calendar.JULY, 11, 15, 24, 47);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's date in time zone: UTC.\n\tCheck actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<24> but was:<23>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasUtcDateAndTime(2020, Calendar.JULY, 11, 15, 24, 47);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's date in time zone: UTC.\n\tCheck actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<24> but was:<23>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasUtcDateAndTime(2020, Calendar.JULY, 11, 15, 23, 48);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's date in time zone: UTC.\n\tCheck actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<48> but was:<47>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC"), "Message").hasUtcDateAndTime(2020, Calendar.JULY, 11, 15, 23, 48);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's date in time zone: UTC.\n\tCheck actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<48> but was:<47>");
        }
    }

    /**
     * {@link CalendarAssertion} class test.
     */
    @Test
    public void hasUtcDateAndTimeMillisecondTest() {
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "UTC")).hasUtcDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, 0);
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "UTC")).hasUtcDateAndTime(2020, Calendar.DECEMBER, 11, 15, 23, 47, 0);
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "UTC")).hasUtcDateAndTime(1324, Calendar.JULY, 21, 3, 22, 46, 543);
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "UTC")).hasUtcDateAndTime(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543);
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Asia/Vientiane")).hasUtcDateAndTime(2020, Calendar.JULY, 11, 8, 23, 47, 0);
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Asia/Vientiane")).hasUtcDateAndTime(2020, Calendar.DECEMBER, 11, 8, 23, 47, 0);
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasUtcDateAndTime(1324, Calendar.JULY, 20, 20, 22, 46, 543);
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Asia/Vientiane")).hasUtcDateAndTime(1324, Calendar.DECEMBER, 20, 20, 22, 46, 543);
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, "Europe/Berlin")).hasUtcDateAndTime(2020, Calendar.JULY, 11, 13, 23, 47, 0);
        initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.DECEMBER, 11, 15, 23, 47, "Europe/Berlin")).hasUtcDateAndTime(2020, Calendar.DECEMBER, 11, 14, 23, 47, 0);
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.JULY, 21, 3, 22, 46, 543, "Europe/Berlin")).hasUtcDateAndTime(1324, Calendar.JULY, 21, 2, 22, 46, 543);
        initialize(Raw.calendarAssertion(), createCalendar(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543, "Europe/Berlin")).hasUtcDateAndTime(1324, Calendar.DECEMBER, 21, 2, 22, 46, 543);

        try {
            Raw.calendarAssertion().hasUtcDateAndTime(1, 1, 1, 1, 1, 1, 1);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.calendarAssertion(), null).hasUtcDateAndTime(1, 1, 1, 1, 1, 1, 1);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), null, "Message").hasUtcDateAndTime(1, 1, 1, 1, 1, 1, 1);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasUtcDateAndTime(2019, Calendar.JULY, 11, 15, 23, 47, 345);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's date in time zone: UTC.\n\tCheck actual value's year.\n\tActual and expected values should be the same.\n\tExpected:<2019> but was:<2020>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasUtcDateAndTime(2019, Calendar.JULY, 11, 15, 23, 47, 345);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's date in time zone: UTC.\n\tCheck actual value's year.\n\tActual and expected values should be the same.\n\tExpected:<2019> but was:<2020>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasUtcDateAndTime(2020, Calendar.AUGUST, 11, 15, 23, 47, 345);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's date in time zone: UTC.\n\tCheck actual value's month.\n\tActual and expected values should be the same.\n\tExpected:<7> but was:<6>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasUtcDateAndTime(2020, Calendar.AUGUST, 11, 15, 23, 47, 345);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's date in time zone: UTC.\n\tCheck actual value's month.\n\tActual and expected values should be the same.\n\tExpected:<7> but was:<6>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasUtcDateAndTime(2020, Calendar.JULY, 12, 15, 23, 47, 345);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's date in time zone: UTC.\n\tCheck actual value's day of month.\n\tActual and expected values should be the same.\n\tExpected:<12> but was:<11>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasUtcDateAndTime(2020, Calendar.JULY, 12, 15, 23, 47, 345);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's date in time zone: UTC.\n\tCheck actual value's day of month.\n\tActual and expected values should be the same.\n\tExpected:<12> but was:<11>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasUtcDateAndTime(2020, Calendar.JULY, 11, 16, 23, 47, 345);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's date in time zone: UTC.\n\tCheck actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<16> but was:<15>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasUtcDateAndTime(2020, Calendar.JULY, 11, 16, 23, 47, 345);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's date in time zone: UTC.\n\tCheck actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<16> but was:<15>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasUtcDateAndTime(2020, Calendar.JULY, 11, 15, 24, 47, 345);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's date in time zone: UTC.\n\tCheck actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<24> but was:<23>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasUtcDateAndTime(2020, Calendar.JULY, 11, 15, 24, 47, 345);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's date in time zone: UTC.\n\tCheck actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<24> but was:<23>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasUtcDateAndTime(2020, Calendar.JULY, 11, 15, 23, 48, 345);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's date in time zone: UTC.\n\tCheck actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<48> but was:<47>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasUtcDateAndTime(2020, Calendar.JULY, 11, 15, 23, 48, 345);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's date in time zone: UTC.\n\tCheck actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<48> but was:<47>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC")).hasUtcDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, 555);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's date in time zone: UTC.\n\tCheck actual value's millisecond.\n\tActual and expected values should be the same.\n\tExpected:<555> but was:<345>");
        }
        try {
            initialize(Raw.calendarAssertion(), createCalendar(2020, Calendar.JULY, 11, 15, 23, 47, 345, "UTC"), "Message").hasUtcDateAndTime(2020, Calendar.JULY, 11, 15, 23, 47, 555);
            Assertions.fail("CalendarAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's date in time zone: UTC.\n\tCheck actual value's millisecond.\n\tActual and expected values should be the same.\n\tExpected:<555> but was:<345>");
        }
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
