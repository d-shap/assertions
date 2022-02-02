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

import org.hamcrest.Matchers;
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
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345)).isGreaterThan(createDate(2019, Calendar.JULY, 11, 15, 23, 47, 345));
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345)).isGreaterThan(createDate(2020, Calendar.JUNE, 11, 15, 23, 47, 345));
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345)).isGreaterThan(createDate(2020, Calendar.JULY, 10, 15, 23, 47, 345));
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345)).isGreaterThan(createDate(2020, Calendar.JULY, 11, 14, 23, 47, 345));
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345)).isGreaterThan(createDate(2020, Calendar.JULY, 11, 15, 22, 47, 345));
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345)).isGreaterThan(createDate(2020, Calendar.JULY, 11, 15, 23, 46, 345));
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345)).isGreaterThan(createDate(2020, Calendar.JULY, 11, 15, 23, 47, 344));

        try {
            Raw.dateAssertion().isGreaterThan(createDate(1, 1, 1, 1, 1, 1, 1));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.dateAssertion(), null).isGreaterThan(createDate(1, 1, 1, 1, 1, 1, 1));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null, "Message").isGreaterThan(createDate(1, 1, 1, 1, 1, 1, 1));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null).isGreaterThan(null);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null, "Message").isGreaterThan(null);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345)).isGreaterThan(null);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345), "Message").isGreaterThan(null);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345)).isGreaterThan(createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater than the expected.\n\tExpected:<2020-07-11T15:23:47.345> but was:<2020-07-11T15:23:47.345>");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345), "Message").isGreaterThan(createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be greater than the expected.\n\tExpected:<2020-07-11T15:23:47.345> but was:<2020-07-11T15:23:47.345>");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345)).isGreaterThan(createDate(2020, Calendar.JULY, 11, 15, 23, 47, 346));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater than the expected.\n\tExpected:<2020-07-11T15:23:47.346> but was:<2020-07-11T15:23:47.345>");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345), "Message").isGreaterThan(createDate(2020, Calendar.JULY, 11, 15, 23, 47, 346));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be greater than the expected.\n\tExpected:<2020-07-11T15:23:47.346> but was:<2020-07-11T15:23:47.345>");
        }
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void isGreaterThanOrEqualToTest() {
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345)).isGreaterThanOrEqualTo(createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345));
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345)).isGreaterThanOrEqualTo(createDate(2019, Calendar.JULY, 11, 15, 23, 47, 345));
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345)).isGreaterThanOrEqualTo(createDate(2020, Calendar.JUNE, 11, 15, 23, 47, 345));
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345)).isGreaterThanOrEqualTo(createDate(2020, Calendar.JULY, 10, 15, 23, 47, 345));
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345)).isGreaterThanOrEqualTo(createDate(2020, Calendar.JULY, 11, 14, 23, 47, 345));
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345)).isGreaterThanOrEqualTo(createDate(2020, Calendar.JULY, 11, 15, 22, 47, 345));
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345)).isGreaterThanOrEqualTo(createDate(2020, Calendar.JULY, 11, 15, 23, 46, 345));
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345)).isGreaterThanOrEqualTo(createDate(2020, Calendar.JULY, 11, 15, 23, 47, 344));

        try {
            Raw.dateAssertion().isGreaterThanOrEqualTo(createDate(1, 1, 1, 1, 1, 1, 1));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.dateAssertion(), null).isGreaterThanOrEqualTo(createDate(1, 1, 1, 1, 1, 1, 1));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null, "Message").isGreaterThanOrEqualTo(createDate(1, 1, 1, 1, 1, 1, 1));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null).isGreaterThanOrEqualTo(null);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null, "Message").isGreaterThanOrEqualTo(null);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345)).isGreaterThanOrEqualTo(null);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345), "Message").isGreaterThanOrEqualTo(null);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345)).isGreaterThanOrEqualTo(createDate(2020, Calendar.JULY, 11, 15, 23, 47, 346));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater than or equal to the expected.\n\tExpected:<2020-07-11T15:23:47.346> but was:<2020-07-11T15:23:47.345>");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345), "Message").isGreaterThanOrEqualTo(createDate(2020, Calendar.JULY, 11, 15, 23, 47, 346));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be greater than or equal to the expected.\n\tExpected:<2020-07-11T15:23:47.346> but was:<2020-07-11T15:23:47.345>");
        }
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void isLessThanTest() {
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345)).isLessThan(createDate(2021, Calendar.JULY, 11, 15, 23, 47, 345));
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345)).isLessThan(createDate(2020, Calendar.AUGUST, 11, 15, 23, 47, 345));
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345)).isLessThan(createDate(2020, Calendar.JULY, 12, 15, 23, 47, 345));
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345)).isLessThan(createDate(2020, Calendar.JULY, 11, 16, 23, 47, 345));
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345)).isLessThan(createDate(2020, Calendar.JULY, 11, 15, 24, 47, 345));
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345)).isLessThan(createDate(2020, Calendar.JULY, 11, 15, 23, 48, 345));
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345)).isLessThan(createDate(2020, Calendar.JULY, 11, 15, 23, 47, 346));

        try {
            Raw.dateAssertion().isLessThan(createDate(1, 1, 1, 1, 1, 1, 1));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.dateAssertion(), null).isLessThan(createDate(1, 1, 1, 1, 1, 1, 1));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null, "Message").isLessThan(createDate(1, 1, 1, 1, 1, 1, 1));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null).isLessThan(null);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null, "Message").isLessThan(null);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345)).isLessThan(null);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345), "Message").isLessThan(null);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345)).isLessThan(createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than the expected.\n\tExpected:<2020-07-11T15:23:47.345> but was:<2020-07-11T15:23:47.345>");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345), "Message").isLessThan(createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be less than the expected.\n\tExpected:<2020-07-11T15:23:47.345> but was:<2020-07-11T15:23:47.345>");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345)).isLessThan(createDate(2020, Calendar.JULY, 11, 15, 23, 47, 344));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than the expected.\n\tExpected:<2020-07-11T15:23:47.344> but was:<2020-07-11T15:23:47.345>");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345), "Message").isLessThan(createDate(2020, Calendar.JULY, 11, 15, 23, 47, 344));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be less than the expected.\n\tExpected:<2020-07-11T15:23:47.344> but was:<2020-07-11T15:23:47.345>");
        }
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void isLessThanOrEqualToTest() {
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345)).isLessThanOrEqualTo(createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345));
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345)).isLessThanOrEqualTo(createDate(2021, Calendar.JULY, 11, 15, 23, 47, 345));
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345)).isLessThanOrEqualTo(createDate(2020, Calendar.AUGUST, 11, 15, 23, 47, 345));
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345)).isLessThanOrEqualTo(createDate(2020, Calendar.JULY, 12, 15, 23, 47, 345));
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345)).isLessThanOrEqualTo(createDate(2020, Calendar.JULY, 11, 16, 23, 47, 345));
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345)).isLessThanOrEqualTo(createDate(2020, Calendar.JULY, 11, 15, 24, 47, 345));
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345)).isLessThanOrEqualTo(createDate(2020, Calendar.JULY, 11, 15, 23, 48, 345));
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345)).isLessThanOrEqualTo(createDate(2020, Calendar.JULY, 11, 15, 23, 47, 346));

        try {
            Raw.dateAssertion().isLessThanOrEqualTo(createDate(1, 1, 1, 1, 1, 1, 1));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.dateAssertion(), null).isLessThanOrEqualTo(createDate(1, 1, 1, 1, 1, 1, 1));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null, "Message").isLessThanOrEqualTo(createDate(1, 1, 1, 1, 1, 1, 1));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null).isLessThanOrEqualTo(null);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null, "Message").isLessThanOrEqualTo(null);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345)).isLessThanOrEqualTo(null);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345), "Message").isLessThanOrEqualTo(null);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345)).isLessThanOrEqualTo(createDate(2020, Calendar.JULY, 11, 15, 23, 47, 344));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than or equal to the expected.\n\tExpected:<2020-07-11T15:23:47.344> but was:<2020-07-11T15:23:47.345>");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345), "Message").isLessThanOrEqualTo(createDate(2020, Calendar.JULY, 11, 15, 23, 47, 344));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be less than or equal to the expected.\n\tExpected:<2020-07-11T15:23:47.344> but was:<2020-07-11T15:23:47.345>");
        }
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void isInRangeTest() {
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345)).isInRange(createDate(2019, Calendar.JULY, 11, 15, 23, 47, 345), createDate(2021, Calendar.JULY, 11, 15, 23, 47, 345));
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345)).isInRange(createDate(2020, Calendar.JUNE, 11, 15, 23, 47, 345), createDate(2020, Calendar.AUGUST, 11, 15, 23, 47, 345));
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345)).isInRange(createDate(2020, Calendar.JULY, 10, 15, 23, 47, 345), createDate(2020, Calendar.JULY, 12, 15, 23, 47, 345));
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345)).isInRange(createDate(2020, Calendar.JULY, 11, 14, 23, 47, 345), createDate(2020, Calendar.JULY, 11, 16, 23, 47, 345));
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345)).isInRange(createDate(2020, Calendar.JULY, 11, 15, 22, 47, 345), createDate(2020, Calendar.JULY, 11, 15, 24, 47, 345));
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345)).isInRange(createDate(2020, Calendar.JULY, 11, 15, 23, 46, 345), createDate(2020, Calendar.JULY, 11, 15, 23, 48, 345));
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345)).isInRange(createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 346));
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345)).isInRange(createDate(2020, Calendar.JULY, 11, 15, 23, 47, 344), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 346));

        try {
            Raw.dateAssertion().isInRange(createDate(1, 1, 1, 1, 1, 1, 1), createDate(1, 1, 1, 1, 1, 1, 1));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.dateAssertion(), null).isInRange(createDate(1, 1, 1, 1, 1, 1, 1), createDate(1, 1, 1, 1, 1, 1, 1));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null, "Message").isInRange(createDate(1, 1, 1, 1, 1, 1, 1), createDate(1, 1, 1, 1, 1, 1, 1));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null).isInRange(null, createDate(1, 1, 1, 1, 1, 1, 1));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null, "Message").isInRange(null, createDate(1, 1, 1, 1, 1, 1, 1));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null).isInRange(createDate(1, 1, 1, 1, 1, 1, 1), null);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null, "Message").isInRange(createDate(1, 1, 1, 1, 1, 1, 1), null);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(1, 1, 1, 1, 1, 1, 1)).isInRange(null, createDate(1, 1, 1, 1, 1, 1, 1));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(1, 1, 1, 1, 1, 1, 1), "Message").isInRange(null, createDate(1, 1, 1, 1, 1, 1, 1));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(1, 1, 1, 1, 1, 1, 1)).isInRange(null, null);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(1, 1, 1, 1, 1, 1, 1), "Message").isInRange(null, null);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(1, 1, 1, 1, 1, 1, 1)).isInRange(createDate(1, 1, 1, 1, 1, 1, 1), null);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedTo.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(1, 1, 1, 1, 1, 1, 1), "Message").isInRange(createDate(1, 1, 1, 1, 1, 1, 1), null);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedTo.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345)).isInRange(createDate(2019, Calendar.JULY, 11, 15, 23, 47, 345), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be in the expected range.\n\tExpected:<2019-07-11T15:23:47.345:2020-07-11T15:23:47.345> but was:<2020-07-11T15:23:47.345>");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345), "Message").isInRange(createDate(2019, Calendar.JULY, 11, 15, 23, 47, 345), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be in the expected range.\n\tExpected:<2019-07-11T15:23:47.345:2020-07-11T15:23:47.345> but was:<2020-07-11T15:23:47.345>");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345)).isInRange(createDate(2021, Calendar.JULY, 11, 15, 23, 47, 345), createDate(2022, Calendar.JULY, 11, 15, 23, 47, 345));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be in the expected range.\n\tExpected:<2021-07-11T15:23:47.345:2022-07-11T15:23:47.345> but was:<2020-07-11T15:23:47.345>");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345), "Message").isInRange(createDate(2021, Calendar.JULY, 11, 15, 23, 47, 345), createDate(2022, Calendar.JULY, 11, 15, 23, 47, 345));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be in the expected range.\n\tExpected:<2021-07-11T15:23:47.345:2022-07-11T15:23:47.345> but was:<2020-07-11T15:23:47.345>");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345)).isInRange(createDate(2018, Calendar.JULY, 11, 15, 23, 47, 345), createDate(2019, Calendar.JULY, 11, 15, 23, 47, 345));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be in the expected range.\n\tExpected:<2018-07-11T15:23:47.345:2019-07-11T15:23:47.345> but was:<2020-07-11T15:23:47.345>");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345), "Message").isInRange(createDate(2018, Calendar.JULY, 11, 15, 23, 47, 345), createDate(2019, Calendar.JULY, 11, 15, 23, 47, 345));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be in the expected range.\n\tExpected:<2018-07-11T15:23:47.345:2019-07-11T15:23:47.345> but was:<2020-07-11T15:23:47.345>");
        }
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void isNotInRangeTest() {
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345)).isNotInRange(createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345));
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345)).isNotInRange(createDate(2018, Calendar.JULY, 11, 15, 23, 47, 345), createDate(2019, Calendar.JULY, 11, 15, 23, 47, 345));
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345)).isNotInRange(createDate(2021, Calendar.JULY, 11, 15, 23, 47, 345), createDate(2022, Calendar.JULY, 11, 15, 23, 47, 345));
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345)).isNotInRange(createDate(2020, Calendar.MAY, 11, 15, 23, 47, 345), createDate(2020, Calendar.JUNE, 11, 15, 23, 47, 345));
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345)).isNotInRange(createDate(2020, Calendar.AUGUST, 11, 15, 23, 47, 345), createDate(2020, Calendar.SEPTEMBER, 11, 15, 23, 47, 345));
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345)).isNotInRange(createDate(2020, Calendar.JULY, 9, 15, 23, 47, 345), createDate(2020, Calendar.JULY, 10, 15, 23, 47, 345));
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345)).isNotInRange(createDate(2020, Calendar.JULY, 12, 15, 23, 47, 345), createDate(2020, Calendar.JULY, 13, 15, 23, 47, 345));
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345)).isNotInRange(createDate(2020, Calendar.JULY, 11, 13, 23, 47, 345), createDate(2020, Calendar.JULY, 11, 14, 23, 47, 345));
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345)).isNotInRange(createDate(2020, Calendar.JULY, 11, 16, 23, 47, 345), createDate(2020, Calendar.JULY, 11, 17, 23, 47, 345));
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345)).isNotInRange(createDate(2020, Calendar.JULY, 11, 15, 21, 47, 345), createDate(2020, Calendar.JULY, 11, 15, 22, 47, 345));
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345)).isNotInRange(createDate(2020, Calendar.JULY, 11, 15, 24, 47, 345), createDate(2020, Calendar.JULY, 11, 15, 25, 47, 345));
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345)).isNotInRange(createDate(2020, Calendar.JULY, 11, 15, 23, 45, 345), createDate(2020, Calendar.JULY, 11, 15, 23, 46, 345));
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345)).isNotInRange(createDate(2020, Calendar.JULY, 11, 15, 23, 48, 345), createDate(2020, Calendar.JULY, 11, 15, 23, 49, 345));
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345)).isNotInRange(createDate(2020, Calendar.JULY, 11, 15, 23, 47, 343), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 344));
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345)).isNotInRange(createDate(2020, Calendar.JULY, 11, 15, 23, 47, 346), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 347));

        try {
            Raw.dateAssertion().isNotInRange(createDate(1, 1, 1, 1, 1, 1, 1), createDate(1, 1, 1, 1, 1, 1, 1));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.dateAssertion(), null).isNotInRange(createDate(1, 1, 1, 1, 1, 1, 1), createDate(1, 1, 1, 1, 1, 1, 1));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null, "Message").isNotInRange(createDate(1, 1, 1, 1, 1, 1, 1), createDate(1, 1, 1, 1, 1, 1, 1));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null).isNotInRange(null, createDate(1, 1, 1, 1, 1, 1, 1));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null, "Message").isNotInRange(null, createDate(1, 1, 1, 1, 1, 1, 1));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null).isNotInRange(createDate(1, 1, 1, 1, 1, 1, 1), null);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null, "Message").isNotInRange(createDate(1, 1, 1, 1, 1, 1, 1), null);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(1, 1, 1, 1, 1, 1, 1)).isNotInRange(null, createDate(1, 1, 1, 1, 1, 1, 1));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(1, 1, 1, 1, 1, 1, 1), "Message").isNotInRange(null, createDate(1, 1, 1, 1, 1, 1, 1));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(1, 1, 1, 1, 1, 1, 1)).isNotInRange(null, null);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(1, 1, 1, 1, 1, 1, 1), "Message").isNotInRange(null, null);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(1, 1, 1, 1, 1, 1, 1)).isNotInRange(createDate(1, 1, 1, 1, 1, 1, 1), null);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedTo.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(1, 1, 1, 1, 1, 1, 1), "Message").isNotInRange(createDate(1, 1, 1, 1, 1, 1, 1), null);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedTo.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345)).isNotInRange(createDate(2019, Calendar.JULY, 11, 15, 23, 47, 345), createDate(2021, Calendar.JULY, 11, 15, 23, 47, 345));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be in the expected range.\n\tExpected:<2019-07-11T15:23:47.345:2021-07-11T15:23:47.345> but was:<2020-07-11T15:23:47.345>");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345), "Message").isNotInRange(createDate(2019, Calendar.JULY, 11, 15, 23, 47, 345), createDate(2021, Calendar.JULY, 11, 15, 23, 47, 345));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be in the expected range.\n\tExpected:<2019-07-11T15:23:47.345:2021-07-11T15:23:47.345> but was:<2020-07-11T15:23:47.345>");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345)).isNotInRange(createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345), createDate(2021, Calendar.JULY, 11, 15, 23, 47, 345));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be in the expected range.\n\tExpected:<2020-07-11T15:23:47.345:2021-07-11T15:23:47.345> but was:<2020-07-11T15:23:47.345>");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345), "Message").isNotInRange(createDate(2020, Calendar.JULY, 11, 15, 23, 47, 345), createDate(2021, Calendar.JULY, 11, 15, 23, 47, 345));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be in the expected range.\n\tExpected:<2020-07-11T15:23:47.345:2021-07-11T15:23:47.345> but was:<2020-07-11T15:23:47.345>");
        }
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void toYearTest() {
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).toYear().isEqualTo(2020);
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toYear().isEqualTo(2020);
        initialize(Raw.dateAssertion(), createDate(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toYear().isEqualTo(1324);
        initialize(Raw.dateAssertion(), createDate(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toYear().isEqualTo(1324);

        try {
            Raw.dateAssertion().toYear();
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.dateAssertion(), null).toYear();
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null, "Message").toYear();
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).toYear()).isEqualTo(2020);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's year.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toYear()).isEqualTo(2020);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's year.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).toYear().isEqualTo(2019);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's year.\n\tActual and expected values should be the same.\n\tExpected:<2019> but was:<2020>");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toYear().isEqualTo(2019);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's year.\n\tActual and expected values should be the same.\n\tExpected:<2019> but was:<2020>");
        }
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void toYearMatcherTest() {
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).toYear(Matchers.is(Matchers.equalTo(2020)));
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toYear(Matchers.is(Matchers.equalTo(2020)));
        initialize(Raw.dateAssertion(), createDate(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toYear(Matchers.is(Matchers.equalTo(1324)));
        initialize(Raw.dateAssertion(), createDate(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toYear(Matchers.is(Matchers.equalTo(1324)));

        try {
            Raw.dateAssertion().toYear(Matchers.equalTo(0));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.dateAssertion(), null).toYear(Matchers.equalTo(0));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null, "Message").toYear(Matchers.equalTo(0));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null).toYear(null);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null, "Message").toYear(null);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).toYear(null);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toYear(null);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).toYear(Matchers.is(Matchers.equalTo(2019)));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's year.\nExpected: is <2019>\n     but: was <2020>");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toYear(Matchers.is(Matchers.equalTo(2019)));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's year.\nExpected: is <2019>\n     but: was <2020>");
        }
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void hasYearTest() {
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).hasYear(2020);
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.DECEMBER, 11, 15, 23, 47)).hasYear(2020);
        initialize(Raw.dateAssertion(), createDate(1324, Calendar.JULY, 21, 3, 22, 46, 543)).hasYear(1324);
        initialize(Raw.dateAssertion(), createDate(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).hasYear(1324);

        try {
            Raw.dateAssertion().hasYear(0);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.dateAssertion(), null).hasYear(0);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null, "Message").hasYear(0);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).hasYear(2019);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's year.\n\tActual and expected values should be the same.\n\tExpected:<2019> but was:<2020>");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47), "Message").hasYear(2019);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's year.\n\tActual and expected values should be the same.\n\tExpected:<2019> but was:<2020>");
        }
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void toMonthTest() {
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).toMonth().isEqualTo(Calendar.JULY);
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toMonth().isEqualTo(Calendar.DECEMBER);
        initialize(Raw.dateAssertion(), createDate(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toMonth().isEqualTo(Calendar.JULY);
        initialize(Raw.dateAssertion(), createDate(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toMonth().isEqualTo(Calendar.DECEMBER);

        try {
            Raw.dateAssertion().toMonth();
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.dateAssertion(), null).toMonth();
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null, "Message").toMonth();
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).toMonth()).isEqualTo(Calendar.JULY);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's month.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toMonth()).isEqualTo(Calendar.JULY);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's month.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).toMonth().isEqualTo(Calendar.DECEMBER);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's month.\n\tActual and expected values should be the same.\n\tExpected:<11> but was:<6>");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toMonth().isEqualTo(Calendar.DECEMBER);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's month.\n\tActual and expected values should be the same.\n\tExpected:<11> but was:<6>");
        }
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void toMonthMatcherTest() {
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).toMonth(Matchers.is(Matchers.equalTo(Calendar.JULY)));
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toMonth(Matchers.is(Matchers.equalTo(Calendar.DECEMBER)));
        initialize(Raw.dateAssertion(), createDate(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toMonth(Matchers.is(Matchers.equalTo(Calendar.JULY)));
        initialize(Raw.dateAssertion(), createDate(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toMonth(Matchers.is(Matchers.equalTo(Calendar.DECEMBER)));

        try {
            Raw.dateAssertion().toMonth(Matchers.equalTo(0));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.dateAssertion(), null).toMonth(Matchers.equalTo(0));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null, "Message").toMonth(Matchers.equalTo(0));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null).toMonth(null);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null, "Message").toMonth(null);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).toMonth(null);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toMonth(null);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).toMonth(Matchers.is(Matchers.equalTo(Calendar.DECEMBER)));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's month.\nExpected: is <11>\n     but: was <6>");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toMonth(Matchers.is(Matchers.equalTo(Calendar.DECEMBER)));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's month.\nExpected: is <11>\n     but: was <6>");
        }
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void hasMonthTest() {
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).hasMonth(Calendar.JULY);
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.DECEMBER, 11, 15, 23, 47)).hasMonth(Calendar.DECEMBER);
        initialize(Raw.dateAssertion(), createDate(1324, Calendar.JULY, 21, 3, 22, 46, 543)).hasMonth(Calendar.JULY);
        initialize(Raw.dateAssertion(), createDate(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).hasMonth(Calendar.DECEMBER);

        try {
            Raw.dateAssertion().hasMonth(0);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.dateAssertion(), null).hasMonth(0);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null, "Message").hasMonth(0);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).hasMonth(Calendar.DECEMBER);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's month.\n\tActual and expected values should be the same.\n\tExpected:<11> but was:<6>");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47), "Message").hasMonth(Calendar.DECEMBER);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's month.\n\tActual and expected values should be the same.\n\tExpected:<11> but was:<6>");
        }
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void toWeekOfYearTest() {
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).toWeekOfYear().isEqualTo(28);
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toWeekOfYear().isEqualTo(50);
        initialize(Raw.dateAssertion(), createDate(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toWeekOfYear().isEqualTo(30);
        initialize(Raw.dateAssertion(), createDate(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toWeekOfYear().isEqualTo(52);

        try {
            Raw.dateAssertion().toWeekOfYear();
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.dateAssertion(), null).toWeekOfYear();
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null, "Message").toWeekOfYear();
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).toWeekOfYear()).isEqualTo(2020);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's week of year.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toWeekOfYear()).isEqualTo(2020);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's week of year.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).toWeekOfYear().isEqualTo(30);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's week of year.\n\tActual and expected values should be the same.\n\tExpected:<30> but was:<28>");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toWeekOfYear().isEqualTo(30);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's week of year.\n\tActual and expected values should be the same.\n\tExpected:<30> but was:<28>");
        }
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void toWeekOfYearMatcherTest() {
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).toWeekOfYear(Matchers.is(Matchers.equalTo(28)));
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toWeekOfYear(Matchers.is(Matchers.equalTo(50)));
        initialize(Raw.dateAssertion(), createDate(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toWeekOfYear(Matchers.is(Matchers.equalTo(30)));
        initialize(Raw.dateAssertion(), createDate(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toWeekOfYear(Matchers.is(Matchers.equalTo(52)));

        try {
            Raw.dateAssertion().toWeekOfYear(Matchers.equalTo(0));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.dateAssertion(), null).toWeekOfYear(Matchers.equalTo(0));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null, "Message").toWeekOfYear(Matchers.equalTo(0));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null).toWeekOfYear(null);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null, "Message").toWeekOfYear(null);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).toWeekOfYear(null);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toWeekOfYear(null);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).toWeekOfYear(Matchers.is(Matchers.equalTo(30)));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's week of year.\nExpected: is <30>\n     but: was <28>");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toWeekOfYear(Matchers.is(Matchers.equalTo(30)));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's week of year.\nExpected: is <30>\n     but: was <28>");
        }
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void hasWeekOfYearTest() {
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).hasWeekOfYear(28);
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.DECEMBER, 11, 15, 23, 47)).hasWeekOfYear(50);
        initialize(Raw.dateAssertion(), createDate(1324, Calendar.JULY, 21, 3, 22, 46, 543)).hasWeekOfYear(30);
        initialize(Raw.dateAssertion(), createDate(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).hasWeekOfYear(52);

        try {
            Raw.dateAssertion().hasWeekOfYear(0);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.dateAssertion(), null).hasWeekOfYear(0);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null, "Message").hasWeekOfYear(0);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).hasWeekOfYear(30);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's week of year.\n\tActual and expected values should be the same.\n\tExpected:<30> but was:<28>");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47), "Message").hasWeekOfYear(30);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's week of year.\n\tActual and expected values should be the same.\n\tExpected:<30> but was:<28>");
        }
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void toWeekOfMonthTest() {
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).toWeekOfMonth().isEqualTo(2);
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toWeekOfMonth().isEqualTo(2);
        initialize(Raw.dateAssertion(), createDate(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toWeekOfMonth().isEqualTo(4);
        initialize(Raw.dateAssertion(), createDate(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toWeekOfMonth().isEqualTo(4);

        try {
            Raw.dateAssertion().toWeekOfMonth();
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.dateAssertion(), null).toWeekOfMonth();
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null, "Message").toWeekOfMonth();
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).toWeekOfMonth()).isEqualTo(2020);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's week of month.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toWeekOfMonth()).isEqualTo(2020);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's week of month.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).toWeekOfMonth().isEqualTo(1);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's week of month.\n\tActual and expected values should be the same.\n\tExpected:<1> but was:<2>");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toWeekOfMonth().isEqualTo(1);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's week of month.\n\tActual and expected values should be the same.\n\tExpected:<1> but was:<2>");
        }
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void toWeekOfMonthMatcherTest() {
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).toWeekOfMonth(Matchers.is(Matchers.equalTo(2)));
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toWeekOfMonth(Matchers.is(Matchers.equalTo(2)));
        initialize(Raw.dateAssertion(), createDate(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toWeekOfMonth(Matchers.is(Matchers.equalTo(4)));
        initialize(Raw.dateAssertion(), createDate(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toWeekOfMonth(Matchers.is(Matchers.equalTo(4)));

        try {
            Raw.dateAssertion().toWeekOfMonth(Matchers.equalTo(0));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.dateAssertion(), null).toWeekOfMonth(Matchers.equalTo(0));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null, "Message").toWeekOfMonth(Matchers.equalTo(0));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null).toWeekOfMonth(null);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null, "Message").toWeekOfMonth(null);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).toWeekOfMonth(null);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toWeekOfMonth(null);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).toWeekOfMonth(Matchers.is(Matchers.equalTo(1)));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's week of month.\nExpected: is <1>\n     but: was <2>");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toWeekOfMonth(Matchers.is(Matchers.equalTo(1)));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's week of month.\nExpected: is <1>\n     but: was <2>");
        }
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void hasWeekOfMonthTest() {
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).hasWeekOfMonth(2);
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.DECEMBER, 11, 15, 23, 47)).hasWeekOfMonth(2);
        initialize(Raw.dateAssertion(), createDate(1324, Calendar.JULY, 21, 3, 22, 46, 543)).hasWeekOfMonth(4);
        initialize(Raw.dateAssertion(), createDate(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).hasWeekOfMonth(4);

        try {
            Raw.dateAssertion().hasWeekOfMonth(0);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.dateAssertion(), null).hasWeekOfMonth(0);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null, "Message").hasWeekOfMonth(0);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).hasWeekOfMonth(1);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's week of month.\n\tActual and expected values should be the same.\n\tExpected:<1> but was:<2>");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47), "Message").hasWeekOfMonth(1);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's week of month.\n\tActual and expected values should be the same.\n\tExpected:<1> but was:<2>");
        }
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void toDayOfYearTest() {
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).toDayOfYear().isEqualTo(193);
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toDayOfYear().isEqualTo(346);
        initialize(Raw.dateAssertion(), createDate(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toDayOfYear().isEqualTo(203);
        initialize(Raw.dateAssertion(), createDate(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toDayOfYear().isEqualTo(356);

        try {
            Raw.dateAssertion().toDayOfYear();
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.dateAssertion(), null).toDayOfYear();
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null, "Message").toDayOfYear();
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).toDayOfYear()).isEqualTo(193);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's day of year.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toDayOfYear()).isEqualTo(193);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's day of year.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).toDayOfYear().isEqualTo(192);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's day of year.\n\tActual and expected values should be the same.\n\tExpected:<192> but was:<193>");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toDayOfYear().isEqualTo(192);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's day of year.\n\tActual and expected values should be the same.\n\tExpected:<192> but was:<193>");
        }
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void toDayOfYearMatcherTest() {
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).toDayOfYear(Matchers.is(Matchers.equalTo(193)));
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toDayOfYear(Matchers.is(Matchers.equalTo(346)));
        initialize(Raw.dateAssertion(), createDate(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toDayOfYear(Matchers.is(Matchers.equalTo(203)));
        initialize(Raw.dateAssertion(), createDate(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toDayOfYear(Matchers.is(Matchers.equalTo(356)));

        try {
            Raw.dateAssertion().toDayOfYear(Matchers.equalTo(0));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.dateAssertion(), null).toDayOfYear(Matchers.equalTo(0));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null, "Message").toDayOfYear(Matchers.equalTo(0));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null).toDayOfYear(null);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null, "Message").toDayOfYear(null);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).toDayOfYear(null);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toDayOfYear(null);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).toDayOfYear(Matchers.is(Matchers.equalTo(192)));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's day of year.\nExpected: is <192>\n     but: was <193>");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toDayOfYear(Matchers.is(Matchers.equalTo(192)));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's day of year.\nExpected: is <192>\n     but: was <193>");
        }
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void hasDayOfYearTest() {
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).hasDayOfYear(193);
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.DECEMBER, 11, 15, 23, 47)).hasDayOfYear(346);
        initialize(Raw.dateAssertion(), createDate(1324, Calendar.JULY, 21, 3, 22, 46, 543)).hasDayOfYear(203);
        initialize(Raw.dateAssertion(), createDate(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).hasDayOfYear(356);

        try {
            Raw.dateAssertion().hasDayOfYear(0);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.dateAssertion(), null).hasDayOfYear(0);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null, "Message").hasDayOfYear(0);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).hasDayOfYear(192);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's day of year.\n\tActual and expected values should be the same.\n\tExpected:<192> but was:<193>");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47), "Message").hasDayOfYear(192);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's day of year.\n\tActual and expected values should be the same.\n\tExpected:<192> but was:<193>");
        }
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void toDayOfMonthTest() {
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).toDayOfMonth().isEqualTo(11);
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toDayOfMonth().isEqualTo(11);
        initialize(Raw.dateAssertion(), createDate(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toDayOfMonth().isEqualTo(21);
        initialize(Raw.dateAssertion(), createDate(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toDayOfMonth().isEqualTo(21);

        try {
            Raw.dateAssertion().toDayOfMonth();
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.dateAssertion(), null).toDayOfMonth();
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null, "Message").toDayOfMonth();
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).toDayOfMonth()).isEqualTo(193);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's day of month.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toDayOfMonth()).isEqualTo(193);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's day of month.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).toDayOfMonth().isEqualTo(12);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's day of month.\n\tActual and expected values should be the same.\n\tExpected:<12> but was:<11>");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toDayOfMonth().isEqualTo(12);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's day of month.\n\tActual and expected values should be the same.\n\tExpected:<12> but was:<11>");
        }
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void toDayOfMonthMatcherTest() {
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).toDayOfMonth(Matchers.is(Matchers.equalTo(11)));
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toDayOfMonth(Matchers.is(Matchers.equalTo(11)));
        initialize(Raw.dateAssertion(), createDate(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toDayOfMonth(Matchers.is(Matchers.equalTo(21)));
        initialize(Raw.dateAssertion(), createDate(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toDayOfMonth(Matchers.is(Matchers.equalTo(21)));

        try {
            Raw.dateAssertion().toDayOfMonth(Matchers.equalTo(0));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.dateAssertion(), null).toDayOfMonth(Matchers.equalTo(0));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null, "Message").toDayOfMonth(Matchers.equalTo(0));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null).toDayOfMonth(null);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null, "Message").toDayOfMonth(null);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).toDayOfMonth(null);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toDayOfMonth(null);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).toDayOfMonth(Matchers.is(Matchers.equalTo(12)));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's day of month.\nExpected: is <12>\n     but: was <11>");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toDayOfMonth(Matchers.is(Matchers.equalTo(12)));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's day of month.\nExpected: is <12>\n     but: was <11>");
        }
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void hasDayOfMonthTest() {
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).hasDayOfMonth(11);
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.DECEMBER, 11, 15, 23, 47)).hasDayOfMonth(11);
        initialize(Raw.dateAssertion(), createDate(1324, Calendar.JULY, 21, 3, 22, 46, 543)).hasDayOfMonth(21);
        initialize(Raw.dateAssertion(), createDate(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).hasDayOfMonth(21);

        try {
            Raw.dateAssertion().hasDayOfMonth(0);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.dateAssertion(), null).hasDayOfMonth(0);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null, "Message").hasDayOfMonth(0);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).hasDayOfMonth(12);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's day of month.\n\tActual and expected values should be the same.\n\tExpected:<12> but was:<11>");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47), "Message").hasDayOfMonth(12);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's day of month.\n\tActual and expected values should be the same.\n\tExpected:<12> but was:<11>");
        }
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void toDayOfWeekInMonthTest() {
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).toDayOfWeekInMonth().isEqualTo(2);
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toDayOfWeekInMonth().isEqualTo(2);
        initialize(Raw.dateAssertion(), createDate(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toDayOfWeekInMonth().isEqualTo(3);
        initialize(Raw.dateAssertion(), createDate(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toDayOfWeekInMonth().isEqualTo(3);

        try {
            Raw.dateAssertion().toDayOfWeekInMonth();
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.dateAssertion(), null).toDayOfWeekInMonth();
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null, "Message").toDayOfWeekInMonth();
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).toDayOfWeekInMonth()).isEqualTo(193);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's day of week in month.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toDayOfWeekInMonth()).isEqualTo(193);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's day of week in month.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).toDayOfWeekInMonth().isEqualTo(3);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's day of week in month.\n\tActual and expected values should be the same.\n\tExpected:<3> but was:<2>");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toDayOfWeekInMonth().isEqualTo(3);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's day of week in month.\n\tActual and expected values should be the same.\n\tExpected:<3> but was:<2>");
        }
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void toDayOfWeekInMonthMatcherTest() {
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).toDayOfWeekInMonth(Matchers.is(Matchers.equalTo(2)));
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toDayOfWeekInMonth(Matchers.is(Matchers.equalTo(2)));
        initialize(Raw.dateAssertion(), createDate(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toDayOfWeekInMonth(Matchers.is(Matchers.equalTo(3)));
        initialize(Raw.dateAssertion(), createDate(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toDayOfWeekInMonth(Matchers.is(Matchers.equalTo(3)));

        try {
            Raw.dateAssertion().toDayOfWeekInMonth(Matchers.equalTo(0));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.dateAssertion(), null).toDayOfWeekInMonth(Matchers.equalTo(0));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null, "Message").toDayOfWeekInMonth(Matchers.equalTo(0));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null).toDayOfWeekInMonth(null);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null, "Message").toDayOfWeekInMonth(null);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).toDayOfWeekInMonth(null);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toDayOfWeekInMonth(null);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).toDayOfWeekInMonth(Matchers.is(Matchers.equalTo(3)));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's day of week in month.\nExpected: is <3>\n     but: was <2>");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toDayOfWeekInMonth(Matchers.is(Matchers.equalTo(3)));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's day of week in month.\nExpected: is <3>\n     but: was <2>");
        }
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void hasDayOfWeekInMonthTest() {
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).hasDayOfWeekInMonth(2);
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.DECEMBER, 11, 15, 23, 47)).hasDayOfWeekInMonth(2);
        initialize(Raw.dateAssertion(), createDate(1324, Calendar.JULY, 21, 3, 22, 46, 543)).hasDayOfWeekInMonth(3);
        initialize(Raw.dateAssertion(), createDate(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).hasDayOfWeekInMonth(3);

        try {
            Raw.dateAssertion().hasDayOfWeekInMonth(0);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.dateAssertion(), null).hasDayOfWeekInMonth(0);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null, "Message").hasDayOfWeekInMonth(0);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).hasDayOfWeekInMonth(3);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's day of week in month.\n\tActual and expected values should be the same.\n\tExpected:<3> but was:<2>");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47), "Message").hasDayOfWeekInMonth(3);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's day of week in month.\n\tActual and expected values should be the same.\n\tExpected:<3> but was:<2>");
        }
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void toDayOfWeekTest() {
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).toDayOfWeek().isEqualTo(Calendar.SATURDAY);
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toDayOfWeek().isEqualTo(Calendar.FRIDAY);
        initialize(Raw.dateAssertion(), createDate(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toDayOfWeek().isEqualTo(Calendar.SATURDAY);
        initialize(Raw.dateAssertion(), createDate(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toDayOfWeek().isEqualTo(Calendar.FRIDAY);

        try {
            Raw.dateAssertion().toDayOfWeek();
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.dateAssertion(), null).toDayOfWeek();
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null, "Message").toDayOfWeek();
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).toDayOfWeek()).isEqualTo(193);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's day of week.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toDayOfWeek()).isEqualTo(193);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's day of week.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).toDayOfWeek().isEqualTo(Calendar.FRIDAY);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's day of week.\n\tActual and expected values should be the same.\n\tExpected:<6> but was:<7>");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toDayOfWeek().isEqualTo(Calendar.FRIDAY);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's day of week.\n\tActual and expected values should be the same.\n\tExpected:<6> but was:<7>");
        }
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void toDayOfWeekMatcherTest() {
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).toDayOfWeek(Matchers.is(Matchers.equalTo(Calendar.SATURDAY)));
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toDayOfWeek(Matchers.is(Matchers.equalTo(Calendar.FRIDAY)));
        initialize(Raw.dateAssertion(), createDate(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toDayOfWeek(Matchers.is(Matchers.equalTo(Calendar.SATURDAY)));
        initialize(Raw.dateAssertion(), createDate(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toDayOfWeek(Matchers.is(Matchers.equalTo(Calendar.FRIDAY)));

        try {
            Raw.dateAssertion().toDayOfWeek(Matchers.equalTo(0));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.dateAssertion(), null).toDayOfWeek(Matchers.equalTo(0));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null, "Message").toDayOfWeek(Matchers.equalTo(0));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null).toDayOfWeek(null);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null, "Message").toDayOfWeek(null);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).toDayOfWeek(null);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toDayOfWeek(null);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).toDayOfWeek(Matchers.is(Matchers.equalTo(Calendar.FRIDAY)));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's day of week.\nExpected: is <6>\n     but: was <7>");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toDayOfWeek(Matchers.is(Matchers.equalTo(Calendar.FRIDAY)));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's day of week.\nExpected: is <6>\n     but: was <7>");
        }
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void hasDayOfWeekTest() {
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).hasDayOfWeek(Calendar.SATURDAY);
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.DECEMBER, 11, 15, 23, 47)).hasDayOfWeek(Calendar.FRIDAY);
        initialize(Raw.dateAssertion(), createDate(1324, Calendar.JULY, 21, 3, 22, 46, 543)).hasDayOfWeek(Calendar.SATURDAY);
        initialize(Raw.dateAssertion(), createDate(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).hasDayOfWeek(Calendar.FRIDAY);

        try {
            Raw.dateAssertion().hasDayOfWeek(0);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.dateAssertion(), null).hasDayOfWeek(0);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null, "Message").hasDayOfWeek(0);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).hasDayOfWeek(Calendar.FRIDAY);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's day of week.\n\tActual and expected values should be the same.\n\tExpected:<6> but was:<7>");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47), "Message").hasDayOfWeek(Calendar.FRIDAY);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's day of week.\n\tActual and expected values should be the same.\n\tExpected:<6> but was:<7>");
        }
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void toAmPmTest() {
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).toAmPm().isEqualTo(Calendar.PM);
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toAmPm().isEqualTo(Calendar.PM);
        initialize(Raw.dateAssertion(), createDate(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toAmPm().isEqualTo(Calendar.AM);
        initialize(Raw.dateAssertion(), createDate(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toAmPm().isEqualTo(Calendar.AM);

        try {
            Raw.dateAssertion().toAmPm();
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.dateAssertion(), null).toAmPm();
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null, "Message").toAmPm();
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).toAmPm()).isEqualTo(193);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's AM/PM.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toAmPm()).isEqualTo(193);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's AM/PM.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).toAmPm().isEqualTo(Calendar.AM);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's AM/PM.\n\tActual and expected values should be the same.\n\tExpected:<0> but was:<1>");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toAmPm().isEqualTo(Calendar.AM);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's AM/PM.\n\tActual and expected values should be the same.\n\tExpected:<0> but was:<1>");
        }
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void toAmPmMatcherTest() {
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).toAmPm(Matchers.is(Matchers.equalTo(Calendar.PM)));
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toAmPm(Matchers.is(Matchers.equalTo(Calendar.PM)));
        initialize(Raw.dateAssertion(), createDate(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toAmPm(Matchers.is(Matchers.equalTo(Calendar.AM)));
        initialize(Raw.dateAssertion(), createDate(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toAmPm(Matchers.is(Matchers.equalTo(Calendar.AM)));

        try {
            Raw.dateAssertion().toAmPm(Matchers.equalTo(0));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.dateAssertion(), null).toAmPm(Matchers.equalTo(0));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null, "Message").toAmPm(Matchers.equalTo(0));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null).toAmPm(null);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null, "Message").toAmPm(null);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).toAmPm(null);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toAmPm(null);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).toAmPm(Matchers.is(Matchers.equalTo(Calendar.AM)));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's AM/PM.\nExpected: is <0>\n     but: was <1>");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toAmPm(Matchers.is(Matchers.equalTo(Calendar.AM)));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's AM/PM.\nExpected: is <0>\n     but: was <1>");
        }
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void isAmTest() {
        initialize(Raw.dateAssertion(), createDate(1324, Calendar.JULY, 21, 3, 22, 46, 543)).isAm();
        initialize(Raw.dateAssertion(), createDate(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).isAm();

        try {
            Raw.dateAssertion().isAm();
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.dateAssertion(), null).isAm();
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null, "Message").isAm();
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).isAm();
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's AM/PM.\n\tActual and expected values should be the same.\n\tExpected:<0> but was:<1>");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47), "Message").isAm();
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's AM/PM.\n\tActual and expected values should be the same.\n\tExpected:<0> but was:<1>");
        }
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void isPmTest() {
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).isPm();
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.DECEMBER, 11, 15, 23, 47)).isPm();

        try {
            Raw.dateAssertion().isPm();
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.dateAssertion(), null).isPm();
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null, "Message").isPm();
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 3, 23, 47)).isPm();
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's AM/PM.\n\tActual and expected values should be the same.\n\tExpected:<1> but was:<0>");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 3, 23, 47), "Message").isPm();
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's AM/PM.\n\tActual and expected values should be the same.\n\tExpected:<1> but was:<0>");
        }
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void toHourOfDayTest() {
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).toHourOfDay().isEqualTo(15);
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toHourOfDay().isEqualTo(15);
        initialize(Raw.dateAssertion(), createDate(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toHourOfDay().isEqualTo(3);
        initialize(Raw.dateAssertion(), createDate(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toHourOfDay().isEqualTo(3);

        try {
            Raw.dateAssertion().toHourOfDay();
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.dateAssertion(), null).toHourOfDay();
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null, "Message").toHourOfDay();
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).toHourOfDay()).isEqualTo(193);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hour of day.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toHourOfDay()).isEqualTo(193);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hour of day.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).toHourOfDay().isEqualTo(14);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<14> but was:<15>");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toHourOfDay().isEqualTo(14);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<14> but was:<15>");
        }
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void toHourOfDayMatcherTest() {
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).toHourOfDay(Matchers.is(Matchers.equalTo(15)));
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toHourOfDay(Matchers.is(Matchers.equalTo(15)));
        initialize(Raw.dateAssertion(), createDate(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toHourOfDay(Matchers.is(Matchers.equalTo(3)));
        initialize(Raw.dateAssertion(), createDate(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toHourOfDay(Matchers.is(Matchers.equalTo(3)));

        try {
            Raw.dateAssertion().toHourOfDay(Matchers.equalTo(0));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.dateAssertion(), null).toHourOfDay(Matchers.equalTo(0));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null, "Message").toHourOfDay(Matchers.equalTo(0));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null).toHourOfDay(null);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null, "Message").toHourOfDay(null);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).toHourOfDay(null);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toHourOfDay(null);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).toHourOfDay(Matchers.is(Matchers.equalTo(14)));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hour of day.\nExpected: is <14>\n     but: was <15>");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toHourOfDay(Matchers.is(Matchers.equalTo(14)));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hour of day.\nExpected: is <14>\n     but: was <15>");
        }
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void hasHourOfDayTest() {
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).hasHourOfDay(15);
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.DECEMBER, 11, 15, 23, 47)).hasHourOfDay(15);
        initialize(Raw.dateAssertion(), createDate(1324, Calendar.JULY, 21, 3, 22, 46, 543)).hasHourOfDay(3);
        initialize(Raw.dateAssertion(), createDate(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).hasHourOfDay(3);

        try {
            Raw.dateAssertion().hasHourOfDay(0);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.dateAssertion(), null).hasHourOfDay(0);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null, "Message").hasHourOfDay(0);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).hasHourOfDay(14);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<14> but was:<15>");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47), "Message").hasHourOfDay(14);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hour of day.\n\tActual and expected values should be the same.\n\tExpected:<14> but was:<15>");
        }
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void toHourTest() {
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).toHour().isEqualTo(3);
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toHour().isEqualTo(3);
        initialize(Raw.dateAssertion(), createDate(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toHour().isEqualTo(3);
        initialize(Raw.dateAssertion(), createDate(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toHour().isEqualTo(3);

        try {
            Raw.dateAssertion().toHour();
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.dateAssertion(), null).toHour();
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null, "Message").toHour();
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).toHour()).isEqualTo(193);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hour.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toHour()).isEqualTo(193);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hour.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).toHour().isEqualTo(2);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hour.\n\tActual and expected values should be the same.\n\tExpected:<2> but was:<3>");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toHour().isEqualTo(2);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hour.\n\tActual and expected values should be the same.\n\tExpected:<2> but was:<3>");
        }
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void toHourMatcherTest() {
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).toHour(Matchers.is(Matchers.equalTo(3)));
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toHour(Matchers.is(Matchers.equalTo(3)));
        initialize(Raw.dateAssertion(), createDate(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toHour(Matchers.is(Matchers.equalTo(3)));
        initialize(Raw.dateAssertion(), createDate(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toHour(Matchers.is(Matchers.equalTo(3)));

        try {
            Raw.dateAssertion().toHour(Matchers.equalTo(0));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.dateAssertion(), null).toHour(Matchers.equalTo(0));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null, "Message").toHour(Matchers.equalTo(0));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null).toHour(null);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null, "Message").toHour(null);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).toHour(null);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toHour(null);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).toHour(Matchers.is(Matchers.equalTo(2)));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hour.\nExpected: is <2>\n     but: was <3>");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toHour(Matchers.is(Matchers.equalTo(2)));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hour.\nExpected: is <2>\n     but: was <3>");
        }
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void hasHourTest() {
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).hasHour(3);
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.DECEMBER, 11, 15, 23, 47)).hasHour(3);
        initialize(Raw.dateAssertion(), createDate(1324, Calendar.JULY, 21, 3, 22, 46, 543)).hasHour(3);
        initialize(Raw.dateAssertion(), createDate(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).hasHour(3);

        try {
            Raw.dateAssertion().hasHour(0);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.dateAssertion(), null).hasHour(0);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null, "Message").hasHour(0);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).hasHour(2);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hour.\n\tActual and expected values should be the same.\n\tExpected:<2> but was:<3>");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47), "Message").hasHour(2);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hour.\n\tActual and expected values should be the same.\n\tExpected:<2> but was:<3>");
        }
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void toMinuteTest() {
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).toMinute().isEqualTo(23);
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toMinute().isEqualTo(23);
        initialize(Raw.dateAssertion(), createDate(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toMinute().isEqualTo(22);
        initialize(Raw.dateAssertion(), createDate(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toMinute().isEqualTo(22);

        try {
            Raw.dateAssertion().toMinute();
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.dateAssertion(), null).toMinute();
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null, "Message").toMinute();
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).toMinute()).isEqualTo(193);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minute.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toMinute()).isEqualTo(193);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minute.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).toMinute().isEqualTo(22);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<22> but was:<23>");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toMinute().isEqualTo(22);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<22> but was:<23>");
        }
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void toMinuteMatcherTest() {
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).toMinute(Matchers.is(Matchers.equalTo(23)));
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toMinute(Matchers.is(Matchers.equalTo(23)));
        initialize(Raw.dateAssertion(), createDate(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toMinute(Matchers.is(Matchers.equalTo(22)));
        initialize(Raw.dateAssertion(), createDate(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toMinute(Matchers.is(Matchers.equalTo(22)));

        try {
            Raw.dateAssertion().toMinute(Matchers.equalTo(0));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.dateAssertion(), null).toMinute(Matchers.equalTo(0));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null, "Message").toMinute(Matchers.equalTo(0));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null).toMinute(null);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null, "Message").toMinute(null);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).toMinute(null);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toMinute(null);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).toMinute(Matchers.is(Matchers.equalTo(22)));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minute.\nExpected: is <22>\n     but: was <23>");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toMinute(Matchers.is(Matchers.equalTo(22)));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minute.\nExpected: is <22>\n     but: was <23>");
        }
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void hasMinuteTest() {
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).hasMinute(23);
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.DECEMBER, 11, 15, 23, 47)).hasMinute(23);
        initialize(Raw.dateAssertion(), createDate(1324, Calendar.JULY, 21, 3, 22, 46, 543)).hasMinute(22);
        initialize(Raw.dateAssertion(), createDate(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).hasMinute(22);

        try {
            Raw.dateAssertion().hasMinute(0);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.dateAssertion(), null).hasMinute(0);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null, "Message").hasMinute(0);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).hasMinute(22);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<22> but was:<23>");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47), "Message").hasMinute(22);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minute.\n\tActual and expected values should be the same.\n\tExpected:<22> but was:<23>");
        }
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void toSecondTest() {
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).toSecond().isEqualTo(47);
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toSecond().isEqualTo(47);
        initialize(Raw.dateAssertion(), createDate(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toSecond().isEqualTo(46);
        initialize(Raw.dateAssertion(), createDate(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toSecond().isEqualTo(46);

        try {
            Raw.dateAssertion().toSecond();
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.dateAssertion(), null).toSecond();
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null, "Message").toSecond();
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).toSecond()).isEqualTo(193);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's second.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toSecond()).isEqualTo(193);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's second.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).toSecond().isEqualTo(46);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<46> but was:<47>");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toSecond().isEqualTo(46);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<46> but was:<47>");
        }
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void toSecondMatcherTest() {
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).toSecond(Matchers.is(Matchers.equalTo(47)));
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toSecond(Matchers.is(Matchers.equalTo(47)));
        initialize(Raw.dateAssertion(), createDate(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toSecond(Matchers.is(Matchers.equalTo(46)));
        initialize(Raw.dateAssertion(), createDate(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toSecond(Matchers.is(Matchers.equalTo(46)));

        try {
            Raw.dateAssertion().toSecond(Matchers.equalTo(0));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.dateAssertion(), null).toSecond(Matchers.equalTo(0));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null, "Message").toSecond(Matchers.equalTo(0));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null).toSecond(null);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null, "Message").toSecond(null);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).toSecond(null);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toSecond(null);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).toSecond(Matchers.is(Matchers.equalTo(46)));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's second.\nExpected: is <46>\n     but: was <47>");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toSecond(Matchers.is(Matchers.equalTo(46)));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's second.\nExpected: is <46>\n     but: was <47>");
        }
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void hasSecondTest() {
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).hasSecond(47);
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.DECEMBER, 11, 15, 23, 47)).hasSecond(47);
        initialize(Raw.dateAssertion(), createDate(1324, Calendar.JULY, 21, 3, 22, 46, 543)).hasSecond(46);
        initialize(Raw.dateAssertion(), createDate(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).hasSecond(46);

        try {
            Raw.dateAssertion().hasSecond(0);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.dateAssertion(), null).hasSecond(0);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null, "Message").hasSecond(0);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).hasSecond(46);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<46> but was:<47>");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47), "Message").hasSecond(46);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's second.\n\tActual and expected values should be the same.\n\tExpected:<46> but was:<47>");
        }
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void toMillisecondTest() {
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).toMillisecond().isEqualTo(0);
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toMillisecond().isEqualTo(0);
        initialize(Raw.dateAssertion(), createDate(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toMillisecond().isEqualTo(543);
        initialize(Raw.dateAssertion(), createDate(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toMillisecond().isEqualTo(543);

        try {
            Raw.dateAssertion().toMillisecond();
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.dateAssertion(), null).toMillisecond();
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null, "Message").toMillisecond();
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).toMillisecond()).isEqualTo(193);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's millisecond.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toMillisecond()).isEqualTo(193);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's millisecond.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 543)).toMillisecond().isEqualTo(544);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's millisecond.\n\tActual and expected values should be the same.\n\tExpected:<544> but was:<543>");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 543), "Message").toMillisecond().isEqualTo(544);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's millisecond.\n\tActual and expected values should be the same.\n\tExpected:<544> but was:<543>");
        }
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void toMillisecondMatcherTest() {
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).toMillisecond(Matchers.is(Matchers.equalTo(0)));
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.DECEMBER, 11, 15, 23, 47)).toMillisecond(Matchers.is(Matchers.equalTo(0)));
        initialize(Raw.dateAssertion(), createDate(1324, Calendar.JULY, 21, 3, 22, 46, 543)).toMillisecond(Matchers.is(Matchers.equalTo(543)));
        initialize(Raw.dateAssertion(), createDate(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).toMillisecond(Matchers.is(Matchers.equalTo(543)));

        try {
            Raw.dateAssertion().toMillisecond(Matchers.equalTo(0));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.dateAssertion(), null).toMillisecond(Matchers.equalTo(0));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null, "Message").toMillisecond(Matchers.equalTo(0));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null).toMillisecond(null);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null, "Message").toMillisecond(null);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).toMillisecond(null);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47), "Message").toMillisecond(null);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 543)).toMillisecond(Matchers.is(Matchers.equalTo(544)));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's millisecond.\nExpected: is <544>\n     but: was <543>");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 543), "Message").toMillisecond(Matchers.is(Matchers.equalTo(544)));
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's millisecond.\nExpected: is <544>\n     but: was <543>");
        }
    }

    /**
     * {@link DateAssertion} class test.
     */
    @Test
    public void hasMillisecondTest() {
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47)).hasMillisecond(0);
        initialize(Raw.dateAssertion(), createDate(2020, Calendar.DECEMBER, 11, 15, 23, 47)).hasMillisecond(0);
        initialize(Raw.dateAssertion(), createDate(1324, Calendar.JULY, 21, 3, 22, 46, 543)).hasMillisecond(543);
        initialize(Raw.dateAssertion(), createDate(1324, Calendar.DECEMBER, 21, 3, 22, 46, 543)).hasMillisecond(543);

        try {
            Raw.dateAssertion().hasMillisecond(0);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.dateAssertion(), null).hasMillisecond(0);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), null, "Message").hasMillisecond(0);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 543)).hasMillisecond(544);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's millisecond.\n\tActual and expected values should be the same.\n\tExpected:<544> but was:<543>");
        }
        try {
            initialize(Raw.dateAssertion(), createDate(2020, Calendar.JULY, 11, 15, 23, 47, 543), "Message").hasMillisecond(544);
            Assertions.fail("DateAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's millisecond.\n\tActual and expected values should be the same.\n\tExpected:<544> but was:<543>");
        }
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
