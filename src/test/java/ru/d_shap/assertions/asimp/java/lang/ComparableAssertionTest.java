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
package ru.d_shap.assertions.asimp.java.lang;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link ComparableAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class ComparableAssertionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public ComparableAssertionTest() {
        super();
    }

    /**
     * {@link ComparableAssertion} class test.
     */
    @Test
    public void actualValueValidatorTest() {
        initialize(Raw.<Integer>comparableAssertion(), 10);

        try {
            initializeWithRawActual(Raw.<Integer>comparableAssertion(), new Object());
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<java.lang.Comparable> but was:<java.lang.Object>");
        }
        try {
            initializeWithRawActual(Raw.<Integer>comparableAssertion(), new Object(), "Message");
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<java.lang.Comparable> but was:<java.lang.Object>");
        }
    }

    /**
     * {@link ComparableAssertion} class test.
     */
    @Test
    public void isEqualToTest() {
        initialize(Raw.<Integer>comparableAssertion(), null).isEqualTo(null);
        initialize(Raw.<Integer>comparableAssertion(), 10).isEqualTo(10);
        initialize(Raw.<Integer>comparableAssertion(), 75).isEqualTo(75);
        initialize(Raw.<Integer>comparableAssertion(), 236).isEqualTo(236);
        initialize(Raw.<Integer>comparableAssertion(), 257).isEqualTo(257);

        try {
            Raw.<Integer>comparableAssertion().isEqualTo(1);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<Integer>comparableAssertion(), null).isEqualTo(1);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<Integer>comparableAssertion(), null, "Message").isEqualTo(1);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<Integer>comparableAssertion(), 1).isEqualTo(null);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null.\n\tActual:<1>");
        }
        try {
            initialize(Raw.<Integer>comparableAssertion(), 1, "Message").isEqualTo(null);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null.\n\tActual:<1>");
        }
        try {
            initialize(Raw.<Integer>comparableAssertion(), 10).isEqualTo(20);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<20> but was:<10>");
        }
        try {
            initialize(Raw.<Integer>comparableAssertion(), 10, "Message").isEqualTo(20);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<20> but was:<10>");
        }
    }

    /**
     * {@link ComparableAssertion} class test.
     */
    @Test
    public void isNotEqualToTest() {
        initialize(Raw.<Integer>comparableAssertion(), null).isNotEqualTo(1);
        initialize(Raw.<Integer>comparableAssertion(), 1).isNotEqualTo(null);
        initialize(Raw.<Integer>comparableAssertion(), 10).isNotEqualTo(15);
        initialize(Raw.<Integer>comparableAssertion(), 75).isNotEqualTo(76);
        initialize(Raw.<Integer>comparableAssertion(), 236).isNotEqualTo(143);
        initialize(Raw.<Integer>comparableAssertion(), 257).isNotEqualTo(2);

        try {
            Raw.<Integer>comparableAssertion().isNotEqualTo(1);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<Integer>comparableAssertion(), null).isNotEqualTo(null);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<Integer>comparableAssertion(), null, "Message").isNotEqualTo(null);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<Integer>comparableAssertion(), 10).isNotEqualTo(10);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<10>");
        }
        try {
            initialize(Raw.<Integer>comparableAssertion(), 10, "Message").isNotEqualTo(10);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<10>");
        }
    }

    /**
     * {@link ComparableAssertion} class test.
     */
    @Test
    public void isGreaterThanTest() {
        initialize(Raw.<Integer>comparableAssertion(), 10).isGreaterThan(5);
        initialize(Raw.<Integer>comparableAssertion(), 60).isGreaterThan(30);
        initialize(Raw.<Integer>comparableAssertion(), 245).isGreaterThan(244);

        try {
            Raw.<Integer>comparableAssertion().isGreaterThan(1);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<Integer>comparableAssertion(), null).isGreaterThan(1);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<Integer>comparableAssertion(), null, "Message").isGreaterThan(1);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<Integer>comparableAssertion(), null).isGreaterThan(null);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<Integer>comparableAssertion(), null, "Message").isGreaterThan(null);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<Integer>comparableAssertion(), 0).isGreaterThan(null);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<Integer>comparableAssertion(), 0, "Message").isGreaterThan(null);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<Integer>comparableAssertion(), 10).isGreaterThan(10);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater than the expected.\n\tExpected:<10> but was:<10>");
        }
        try {
            initialize(Raw.<Integer>comparableAssertion(), 10).isGreaterThan(11);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater than the expected.\n\tExpected:<11> but was:<10>");
        }
        try {
            initialize(Raw.<Integer>comparableAssertion(), 10, "Message").isGreaterThan(11);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be greater than the expected.\n\tExpected:<11> but was:<10>");
        }
    }

    /**
     * {@link ComparableAssertion} class test.
     */
    @Test
    public void isGreaterThanOrEqualToTest() {
        initialize(Raw.<Integer>comparableAssertion(), 10).isGreaterThanOrEqualTo(5);
        initialize(Raw.<Integer>comparableAssertion(), 60).isGreaterThanOrEqualTo(60);
        initialize(Raw.<Integer>comparableAssertion(), 245).isGreaterThanOrEqualTo(244);

        try {
            Raw.<Integer>comparableAssertion().isGreaterThanOrEqualTo(1);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<Integer>comparableAssertion(), null).isGreaterThanOrEqualTo(1);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<Integer>comparableAssertion(), null, "Message").isGreaterThanOrEqualTo(1);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<Integer>comparableAssertion(), null).isGreaterThanOrEqualTo(null);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<Integer>comparableAssertion(), null, "Message").isGreaterThanOrEqualTo(null);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<Integer>comparableAssertion(), 0).isGreaterThanOrEqualTo(null);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<Integer>comparableAssertion(), 0, "Message").isGreaterThanOrEqualTo(null);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<Integer>comparableAssertion(), 10).isGreaterThanOrEqualTo(11);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater than or equal to the expected.\n\tExpected:<11> but was:<10>");
        }
        try {
            initialize(Raw.<Integer>comparableAssertion(), 10, "Message").isGreaterThanOrEqualTo(11);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be greater than or equal to the expected.\n\tExpected:<11> but was:<10>");
        }
    }

    /**
     * {@link ComparableAssertion} class test.
     */
    @Test
    public void isLessThanTest() {
        initialize(Raw.<Integer>comparableAssertion(), 5).isLessThan(10);
        initialize(Raw.<Integer>comparableAssertion(), 30).isLessThan(60);
        initialize(Raw.<Integer>comparableAssertion(), 244).isLessThan(245);

        try {
            Raw.<Integer>comparableAssertion().isLessThan(1);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<Integer>comparableAssertion(), null).isLessThan(1);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<Integer>comparableAssertion(), null, "Message").isLessThan(1);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<Integer>comparableAssertion(), null).isLessThan(null);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<Integer>comparableAssertion(), null, "Message").isLessThan(null);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<Integer>comparableAssertion(), 0).isLessThan(null);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<Integer>comparableAssertion(), 0, "Message").isLessThan(null);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<Integer>comparableAssertion(), 10).isLessThan(10);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than the expected.\n\tExpected:<10> but was:<10>");
        }
        try {
            initialize(Raw.<Integer>comparableAssertion(), 11).isLessThan(10);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than the expected.\n\tExpected:<10> but was:<11>");
        }
        try {
            initialize(Raw.<Integer>comparableAssertion(), 11, "Message").isLessThan(10);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be less than the expected.\n\tExpected:<10> but was:<11>");
        }
    }

    /**
     * {@link ComparableAssertion} class test.
     */
    @Test
    public void isLessThanOrEqualToTest() {
        initialize(Raw.<Integer>comparableAssertion(), 5).isLessThanOrEqualTo(10);
        initialize(Raw.<Integer>comparableAssertion(), 60).isLessThanOrEqualTo(60);
        initialize(Raw.<Integer>comparableAssertion(), 244).isLessThanOrEqualTo(245);

        try {
            Raw.<Integer>comparableAssertion().isLessThanOrEqualTo(1);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<Integer>comparableAssertion(), null).isLessThanOrEqualTo(1);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<Integer>comparableAssertion(), null, "Message").isLessThanOrEqualTo(1);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<Integer>comparableAssertion(), null).isLessThanOrEqualTo(null);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<Integer>comparableAssertion(), null, "Message").isLessThanOrEqualTo(null);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<Integer>comparableAssertion(), 0).isLessThanOrEqualTo(null);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<Integer>comparableAssertion(), 0, "Message").isLessThanOrEqualTo(null);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<Integer>comparableAssertion(), 11).isLessThanOrEqualTo(10);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than or equal to the expected.\n\tExpected:<10> but was:<11>");
        }
        try {
            initialize(Raw.<Integer>comparableAssertion(), 11, "Message").isLessThanOrEqualTo(10);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be less than or equal to the expected.\n\tExpected:<10> but was:<11>");
        }
    }

    /**
     * {@link ComparableAssertion} class test.
     */
    @Test
    public void isInRangeTest() {
        initialize(Raw.<Integer>comparableAssertion(), 5).isInRange(4, 6);
        initialize(Raw.<Integer>comparableAssertion(), 5).isInRange(5, 6);
        initialize(Raw.<Integer>comparableAssertion(), 5).isInRange(1, 10);

        try {
            Raw.<Integer>comparableAssertion().isInRange(1, 1);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<Integer>comparableAssertion(), null).isInRange(1, 1);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<Integer>comparableAssertion(), null, "Message").isInRange(1, 1);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<Integer>comparableAssertion(), null).isInRange(null, 1);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<Integer>comparableAssertion(), null, "Message").isInRange(null, 1);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<Integer>comparableAssertion(), null).isInRange(1, null);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<Integer>comparableAssertion(), null, "Message").isInRange(1, null);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<Integer>comparableAssertion(), 0).isInRange(null, 10);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.<Integer>comparableAssertion(), 0, "Message").isInRange(null, 10);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.<Integer>comparableAssertion(), 0).isInRange(null, null);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.<Integer>comparableAssertion(), 0, "Message").isInRange(null, null);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.<Integer>comparableAssertion(), 0).isInRange(10, null);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedTo.");
        }
        try {
            initialize(Raw.<Integer>comparableAssertion(), 0, "Message").isInRange(10, null);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedTo.");
        }
        try {
            initialize(Raw.<Integer>comparableAssertion(), 5).isInRange(1, 5);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be in the expected range.\n\tExpected:<1:5> but was:<5>");
        }
        try {
            initialize(Raw.<Integer>comparableAssertion(), 5).isInRange(6, 10);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be in the expected range.\n\tExpected:<6:10> but was:<5>");
        }
        try {
            initialize(Raw.<Integer>comparableAssertion(), 5).isInRange(8, 9);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be in the expected range.\n\tExpected:<8:9> but was:<5>");
        }
        try {
            initialize(Raw.<Integer>comparableAssertion(), 5, "Message").isInRange(8, 9);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be in the expected range.\n\tExpected:<8:9> but was:<5>");
        }
    }

    /**
     * {@link ComparableAssertion} class test.
     */
    @Test
    public void isNotInRangeTest() {
        initialize(Raw.<Integer>comparableAssertion(), 5).isNotInRange(1, 5);
        initialize(Raw.<Integer>comparableAssertion(), 5).isNotInRange(6, 10);
        initialize(Raw.<Integer>comparableAssertion(), 5).isNotInRange(8, 9);

        try {
            Raw.<Integer>comparableAssertion().isNotInRange(1, 1);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<Integer>comparableAssertion(), null).isNotInRange(1, 1);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<Integer>comparableAssertion(), null, "Message").isNotInRange(1, 1);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<Integer>comparableAssertion(), null).isNotInRange(null, 1);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<Integer>comparableAssertion(), null, "Message").isNotInRange(null, 1);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<Integer>comparableAssertion(), null).isNotInRange(1, null);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<Integer>comparableAssertion(), null, "Message").isNotInRange(1, null);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<Integer>comparableAssertion(), 0).isNotInRange(null, 10);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.<Integer>comparableAssertion(), 0, "Message").isNotInRange(null, 10);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.<Integer>comparableAssertion(), 0).isNotInRange(null, null);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.<Integer>comparableAssertion(), 0, "Message").isNotInRange(null, null);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.<Integer>comparableAssertion(), 0).isNotInRange(10, null);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedTo.");
        }
        try {
            initialize(Raw.<Integer>comparableAssertion(), 0, "Message").isNotInRange(10, null);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedTo.");
        }
        try {
            initialize(Raw.<Integer>comparableAssertion(), 5).isNotInRange(4, 6);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be in the expected range.\n\tExpected:<4:6> but was:<5>");
        }
        try {
            initialize(Raw.<Integer>comparableAssertion(), 5).isNotInRange(5, 6);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be in the expected range.\n\tExpected:<5:6> but was:<5>");
        }
        try {
            initialize(Raw.<Integer>comparableAssertion(), 5).isNotInRange(1, 10);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be in the expected range.\n\tExpected:<1:10> but was:<5>");
        }
        try {
            initialize(Raw.<Integer>comparableAssertion(), 5, "Message").isNotInRange(1, 10);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be in the expected range.\n\tExpected:<1:10> but was:<5>");
        }
    }

    /**
     * {@link ComparableAssertion} class test.
     */
    @Test
    public void isNullTest() {
        initialize(Raw.<Integer>comparableAssertion(), null).isNull();

        try {
            initialize(Raw.<Integer>comparableAssertion(), 5).isNull();
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null.\n\tActual:<5>");
        }
        try {
            initialize(Raw.<Integer>comparableAssertion(), 5, "Message").isNull();
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null.\n\tActual:<5>");
        }
    }

    /**
     * {@link ComparableAssertion} class test.
     */
    @Test
    public void isSameAsTest() {
        Comparable<Integer> value = 1000;
        initialize(Raw.<Integer>comparableAssertion(), value).isSameAs(value);

        try {
            initialize(Raw.<Integer>comparableAssertion(), value).isSameAs(1000);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should point to the same object.\n\tExpected:<1000> but was:<1000>");
        }
        try {
            initialize(Raw.<Integer>comparableAssertion(), value, "Message").isSameAs(1000);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should point to the same object.\n\tExpected:<1000> but was:<1000>");
        }
    }

    /**
     * {@link ComparableAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        Comparable<Integer> value = 1000;
        initialize(Raw.<Integer>comparableAssertion(), value).isNotSameAs(1000);

        try {
            initialize(Raw.<Integer>comparableAssertion(), value).isNotSameAs(value);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should point to the different objects.\n\tActual:<1000>");
        }
        try {
            initialize(Raw.<Integer>comparableAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should point to the different objects.\n\tActual:<1000>");
        }
    }

}
