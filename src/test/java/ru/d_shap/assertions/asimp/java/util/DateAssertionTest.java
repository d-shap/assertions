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

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link DateAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public class DateAssertionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public DateAssertionTest() {
        super();
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void actualValueValidatorTest() {
        initialize(Raw.dateAssertion(), new Date());

        try {
            initializeWithRawActual(Raw.dateAssertion(), new Object());
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<java.util.Date> but was:<java.lang.Object>");
        }
        try {
            initializeWithRawActual(Raw.dateAssertion(), new Object(), "Message");
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<java.util.Date> but was:<java.lang.Object>");
        }
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void isEqualToTest() {
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).isEqualTo(createDate(2020, Calendar.JULY, 11, 15, 23, 47));
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.DECEMBER, 11, 15, 23, 47)).isEqualTo(createDate(2020, Calendar.DECEMBER, 11, 15, 23, 47));
        initialize(Raw.dateAssertion(), createDate(1324, Calendar.JULY, 21, 3, 22, 46, 543)).isEqualTo(createDate(1324, Calendar.JULY, 21, 3, 22, 46, 543));
        initialize(Raw.dateAssertion(), createDate(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).isEqualTo(createDate(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543));

        try {
            Raw.dateAssertion().isEqualTo(createDate(1, 1, 1, 1, 1, 1));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.dateAssertion(), null).isEqualTo(createDate(1, 1, 1, 1, 1, 1));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null, "Message").isEqualTo(createDate(1, 1, 1, 1, 1, 1));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null).isEqualTo(null);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null, "Message").isEqualTo(null);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).isEqualTo(null);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47), "Message").isEqualTo(null);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345)).isEqualTo(createDate(2019, Calendar.AUGUST, 12, 16, 22, 46, 555));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<2019-08-12T16:22:46.555> but was:<2020-07-11T15:23:47.345>");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345), "Message").isEqualTo(createDate(2019, Calendar.AUGUST, 12, 16, 22, 46, 555));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<2019-08-12T16:22:46.555> but was:<2020-07-11T15:23:47.345>");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).isEqualTo(createDate(2020, Calendar.JULY, 11, 17, 23, 47));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<2020-07-11T17:23:47.000> but was:<2020-07-11T15:23:47.000>");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47), "Message").isEqualTo(createDate(2020, Calendar.JULY, 11, 17, 23, 47));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<2020-07-11T17:23:47.000> but was:<2020-07-11T15:23:47.000>");
        }
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void isNotEqualToTest() {
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).isNotEqualTo(createDate(2019, Calendar.JULY, 11, 15, 23, 47));
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).isNotEqualTo(createDate(2020, Calendar.AUGUST, 11, 15, 23, 47));
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).isNotEqualTo(createDate(2020, Calendar.JULY, 12, 15, 23, 47));
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).isNotEqualTo(createDate(2020, Calendar.JULY, 11, 16, 23, 47));
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).isNotEqualTo(createDate(2020, Calendar.JULY, 11, 15, 22, 47));
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).isNotEqualTo(createDate(2020, Calendar.JULY, 11, 15, 23, 46));

        try {
            Raw.dateAssertion().isNotEqualTo(createDate(1, 1, 1, 1, 1, 1));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.dateAssertion(), null).isNotEqualTo(createDate(1, 1, 1, 1, 1, 1));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null, "Message").isNotEqualTo(createDate(1, 1, 1, 1, 1, 1));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null).isNotEqualTo(null);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null, "Message").isNotEqualTo(null);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).isNotEqualTo(null);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47), "Message").isNotEqualTo(null);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345)).isNotEqualTo(createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<2020-07-11T15:23:47.345>");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345), "Message").isNotEqualTo(createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<2020-07-11T15:23:47.345>");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).isNotEqualTo(createDate(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<1324-12-21T03:22:46.543>");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543), "Message").isNotEqualTo(createDate(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<1324-12-21T03:22:46.543>");
        }
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void isGreaterThanTest() {
        // TODO
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void isGreaterThanOrEqualToTest() {
        // TODO
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void isLessThanTest() {
        // TODO
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void isLessThanOrEqualToTest() {
        // TODO
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void isInRangeTest() {
        // TODO
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void isNotInRangeTest() {
        // TODO
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void toYearTest() {
        // TODO
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void toYearMatcherTest() {
        // TODO
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void hasYearTest() {
        // TODO
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void toMonthTest() {
        // TODO
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void toMonthMatcherTest() {
        // TODO
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void hasMonthTest() {
        // TODO
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void toWeekOfYearTest() {
        // TODO
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void toWeekOfYearMatcherTest() {
        // TODO
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void hasWeekOfYearTest() {
        // TODO
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void toWeekOfMonthTest() {
        // TODO
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void toWeekOfMonthMatcherTest() {
        // TODO
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void hasWeekOfMonthTest() {
        // TODO
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void toDayOfYearTest() {
        // TODO
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void toDayOfYearMatcherTest() {
        // TODO
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void hasDayOfYearTest() {
        // TODO
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void toDayOfMonthTest() {
        // TODO
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void toDayOfMonthMatcherTest() {
        // TODO
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void hasDayOfMonthTest() {
        // TODO
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void toDayOfWeekInMonthTest() {
        // TODO
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void toDayOfWeekInMonthMatcherTest() {
        // TODO
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void hasDayOfWeekInMonthTest() {
        // TODO
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void toDayOfWeekTest() {
        // TODO
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void toDayOfWeekMatcherTest() {
        // TODO
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void hasDayOfWeekTest() {
        // TODO
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void toAmPmTest() {
        // TODO
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void toAmPmMatcherTest() {
        // TODO
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void isAmTest() {
        // TODO
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void isPmTest() {
        // TODO
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void toHourOfDayTest() {
        // TODO
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void toHourOfDayMatcherTest() {
        // TODO
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void hasHourOfDayTest() {
        // TODO
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void toHourTest() {
        // TODO
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void toHourMatcherTest() {
        // TODO
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void hasHourTest() {
        // TODO
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void toMinuteTest() {
        // TODO
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void toMinuteMatcherTest() {
        // TODO
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void hasMinuteTest() {
        // TODO
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void toSecondTest() {
        // TODO
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void toSecondMatcherTest() {
        // TODO
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void hasSecondTest() {
        // TODO
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void toMillisecondTest() {
        // TODO
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void toMillisecondMatcherTest() {
        // TODO
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void hasMillisecondTest() {
        // TODO
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void hasDateTest() {
        // TODO
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void hasTimeTest() {
        // TODO
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void hasTimeMillisecondTest() {
        // TODO
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void hasDateAndTimeTest() {
        // TODO
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void hasDateAndTimeMillisecondTest() {
        // TODO
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void isNullTest() {
        // TODO
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void isSameAsTest() {
        // TODO
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        // TODO
    }

}
