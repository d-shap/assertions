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
package ru.d_shap.assertions.asimp.primitive;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link DoubleAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class DoubleAssertionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public DoubleAssertionTest() {
        super();
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void actualValueValidatorTest() {
        initialize(Raw.doubleAssertion(), 10.0);

        try {
            initializeWithRawActual(Raw.doubleAssertion(), new Object());
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<java.lang.Double> but was:<java.lang.Object>");
        }
        try {
            initializeWithRawActual(Raw.doubleAssertion(), new Object(), "Message");
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<java.lang.Double> but was:<java.lang.Object>");
        }
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void isEqualToDefaultDeltaTest() {
        initialize(Raw.doubleAssertion(), 10.1).isEqualTo(10.1);
        initialize(Raw.doubleAssertion(), 10.01).isEqualTo(10.01);
        initialize(Raw.doubleAssertion(), 10.001).isEqualTo(10.001);
        initialize(Raw.doubleAssertion(), 10.0001).isEqualTo(10.0001);
        initialize(Raw.doubleAssertion(), 10.00001).isEqualTo(10.00001);
        initialize(Raw.doubleAssertion(), 10.000001).isEqualTo(10.000001);
        initialize(Raw.doubleAssertion(), 10.0000001).isEqualTo(10.0000001);
        initialize(Raw.doubleAssertion(), 10.00000001).isEqualTo(10.00000001);
        initialize(Raw.doubleAssertion(), 10.000000001).isEqualTo(10.000000001);
        initialize(Raw.doubleAssertion(), 10.0000000001).isEqualTo(10.0000000001);
        initialize(Raw.doubleAssertion(), 10.00000000001).isEqualTo(10.00000000001);
        initialize(Raw.doubleAssertion(), 10.000000000011).isEqualTo(10.000000000012);
        initialize(Raw.doubleAssertion(), 10.000000000001).isEqualTo(10.000000000002);
        initialize(Raw.doubleAssertion(), 10.0000000000001).isEqualTo(10.0000000000002);

        try {
            Raw.doubleAssertion().isEqualTo(1.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleAssertion(), null).isEqualTo(1.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), null, "Message").isEqualTo(1.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.00000000001).isEqualTo(10.00000000002);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<10.00000000002±9.999999960041972E-12> but was:<10.00000000001>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.00000000001, "Message").isEqualTo(10.00000000002);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<10.00000000002±9.999999960041972E-12> but was:<10.00000000001>");
        }
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void isEqualToSpecifiedDeltaTest() {
        initialize(Raw.doubleAssertion(), 10.0).isEqualTo(10.0, 0.01);
        initialize(Raw.doubleAssertion(), 10.0).isEqualTo(9.999, 0.01);
        initialize(Raw.doubleAssertion(), 10.0).isEqualTo(10.001, 0.01);
        initialize(Raw.doubleAssertion(), 0.0).isEqualTo(0.0, 0.01);
        initialize(Raw.doubleAssertion(), Double.MAX_VALUE).isEqualTo(Double.MAX_VALUE, 0.01);
        initialize(Raw.doubleAssertion(), -0.0).isEqualTo(+0.0, 0.0);
        initialize(Raw.doubleAssertion(), +0.0).isEqualTo(-0.0, 0.0);

        try {
            Raw.doubleAssertion().isEqualTo(1.0, 0.01);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleAssertion(), null).isEqualTo(1.0, 0.01);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), null, "Message").isEqualTo(1.0, 0.01);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0).isEqualTo(10.01, 0.001);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<10.01±0.001> but was:<10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0, "Message").isEqualTo(10.01, 0.001);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<10.01±0.001> but was:<10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0).isEqualTo(9.99, 0.001);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<9.99±0.001> but was:<10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0, "Message").isEqualTo(9.99, 0.001);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<9.99±0.001> but was:<10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0).isEqualTo(20.0, 0.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<20.0±0.0> but was:<10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0, "Message").isEqualTo(20.0, 0.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<20.0±0.0> but was:<10.0>");
        }
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void isNotEqualToDefaultDeltaTest() {
        initialize(Raw.doubleAssertion(), 10.1).isNotEqualTo(10.2);
        initialize(Raw.doubleAssertion(), 10.01).isNotEqualTo(10.02);
        initialize(Raw.doubleAssertion(), 10.001).isNotEqualTo(10.002);
        initialize(Raw.doubleAssertion(), 10.0001).isNotEqualTo(10.0002);
        initialize(Raw.doubleAssertion(), 10.00001).isNotEqualTo(10.00002);
        initialize(Raw.doubleAssertion(), 10.000001).isNotEqualTo(10.000002);
        initialize(Raw.doubleAssertion(), 10.0000001).isNotEqualTo(10.0000002);
        initialize(Raw.doubleAssertion(), 10.00000001).isNotEqualTo(10.00000002);
        initialize(Raw.doubleAssertion(), 10.000000001).isNotEqualTo(10.000000002);
        initialize(Raw.doubleAssertion(), 10.0000000001).isNotEqualTo(10.0000000002);
        initialize(Raw.doubleAssertion(), 10.00000000001).isNotEqualTo(10.00000000002);

        try {
            Raw.doubleAssertion().isNotEqualTo(1.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleAssertion(), null).isNotEqualTo(1.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), null, "Message").isNotEqualTo(1.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.000000000001).isNotEqualTo(10.000000000002);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<10.000000000001±9.999999960041972E-12>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.000000000001, "Message").isNotEqualTo(10.000000000002);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<10.000000000001±9.999999960041972E-12>");
        }
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void isNotEqualSpecifiedDeltaTest() {
        initialize(Raw.doubleAssertion(), 10.0).isNotEqualTo(10.01, 0.001);
        initialize(Raw.doubleAssertion(), 10.0).isNotEqualTo(9.99, 0.001);
        initialize(Raw.doubleAssertion(), 10.0).isNotEqualTo(20.0, 0.0);

        try {
            Raw.doubleAssertion().isNotEqualTo(1.0, 0.01);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleAssertion(), null).isNotEqualTo(1.0, 0.01);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), null, "Message").isNotEqualTo(1.0, 0.01);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0).isNotEqualTo(10.001, 0.01);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<10.0±0.01>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0, "Message").isNotEqualTo(10.001, 0.01);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<10.0±0.01>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0).isNotEqualTo(9.999, 0.01);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<10.0±0.01>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0, "Message").isNotEqualTo(9.999, 0.01);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<10.0±0.01>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0).isNotEqualTo(10.0, 0.01);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<10.0±0.01>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0, "Message").isNotEqualTo(10.0, 0.01);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<10.0±0.01>");
        }
        try {
            initialize(Raw.doubleAssertion(), +0.0).isNotEqualTo(-0.0, 0.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<0.0±0.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), +0.0, "Message").isNotEqualTo(-0.0, 0.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<0.0±0.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), -0.0).isNotEqualTo(+0.0, 0.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<-0.0±0.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), -0.0, "Message").isNotEqualTo(+0.0, 0.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<-0.0±0.0>");
        }
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void isGreaterThanTest() {
        initialize(Raw.doubleAssertion(), 10.0).isGreaterThan(9.0);
        initialize(Raw.doubleAssertion(), 10.0).isGreaterThan(8.0);
        initialize(Raw.doubleAssertion(), 10.0).isGreaterThan(-1.0);

        try {
            Raw.doubleAssertion().isGreaterThan(1.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleAssertion(), null).isGreaterThan(1.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), null, "Message").isGreaterThan(1.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0).isGreaterThan(10.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater than the expected.\n\tExpected:<10.0> but was:<10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0, "Message").isGreaterThan(10.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be greater than the expected.\n\tExpected:<10.0> but was:<10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0).isGreaterThan(11.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater than the expected.\n\tExpected:<11.0> but was:<10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0, "Message").isGreaterThan(11.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be greater than the expected.\n\tExpected:<11.0> but was:<10.0>");
        }
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void isGreaterThanOrEqualToTest() {
        initialize(Raw.doubleAssertion(), 10.0).isGreaterThanOrEqualTo(9.0);
        initialize(Raw.doubleAssertion(), 10.0).isGreaterThanOrEqualTo(10.0);
        initialize(Raw.doubleAssertion(), 10.0).isGreaterThanOrEqualTo(-1.0);

        try {
            Raw.doubleAssertion().isGreaterThanOrEqualTo(1.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleAssertion(), null).isGreaterThanOrEqualTo(1.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), null, "Message").isGreaterThanOrEqualTo(1.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0).isGreaterThanOrEqualTo(11.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater than or equal to the expected.\n\tExpected:<11.0> but was:<10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0, "Message").isGreaterThanOrEqualTo(11.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be greater than or equal to the expected.\n\tExpected:<11.0> but was:<10.0>");
        }
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void isLessThanTest() {
        initialize(Raw.doubleAssertion(), 10.0).isLessThan(11.0);
        initialize(Raw.doubleAssertion(), 10.0).isLessThan(12.0);
        initialize(Raw.doubleAssertion(), 10.0).isLessThan(100.0);

        try {
            Raw.doubleAssertion().isLessThan(1.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleAssertion(), null).isLessThan(1.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), null, "Message").isLessThan(1.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0).isLessThan(10.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than the expected.\n\tExpected:<10.0> but was:<10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0, "Message").isLessThan(10.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be less than the expected.\n\tExpected:<10.0> but was:<10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0).isLessThan(9.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than the expected.\n\tExpected:<9.0> but was:<10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0, "Message").isLessThan(9.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be less than the expected.\n\tExpected:<9.0> but was:<10.0>");
        }
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void isLessThanOrEqualToTest() {
        initialize(Raw.doubleAssertion(), 10.0).isLessThanOrEqualTo(11.0);
        initialize(Raw.doubleAssertion(), 10.0).isLessThanOrEqualTo(10.0);
        initialize(Raw.doubleAssertion(), 10.0).isLessThanOrEqualTo(100.0);

        try {
            Raw.doubleAssertion().isLessThanOrEqualTo(1.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleAssertion(), null).isLessThanOrEqualTo(1.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), null, "Message").isLessThanOrEqualTo(1.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0).isLessThanOrEqualTo(9.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than or equal to the expected.\n\tExpected:<9.0> but was:<10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0, "Message").isLessThanOrEqualTo(9.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be less than or equal to the expected.\n\tExpected:<9.0> but was:<10.0>");
        }
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void isInRangeTest() {
        initialize(Raw.doubleAssertion(), 5.0).isInRange(4.0, 6.0);
        initialize(Raw.doubleAssertion(), 5.0).isInRange(5.0, 6.0);
        initialize(Raw.doubleAssertion(), 5.0).isInRange(1.0, 10.0);

        try {
            Raw.doubleAssertion().isInRange(1.0, 1.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleAssertion(), null).isInRange(1.0, 1.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), null, "Message").isInRange(1.0, 1.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), 5.0).isInRange(1.0, 5.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be in the expected range.\n\tExpected:<1.0:5.0> but was:<5.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 5.0, "Message").isInRange(1.0, 5.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be in the expected range.\n\tExpected:<1.0:5.0> but was:<5.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 5.0).isInRange(6.0, 10.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be in the expected range.\n\tExpected:<6.0:10.0> but was:<5.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 5.0, "Message").isInRange(6.0, 10.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be in the expected range.\n\tExpected:<6.0:10.0> but was:<5.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 5.0).isInRange(8.0, 9.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be in the expected range.\n\tExpected:<8.0:9.0> but was:<5.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 5.0, "Message").isInRange(8.0, 9.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be in the expected range.\n\tExpected:<8.0:9.0> but was:<5.0>");
        }
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void isNotInRangeTest() {
        initialize(Raw.doubleAssertion(), 5.0).isNotInRange(1.0, 5.0);
        initialize(Raw.doubleAssertion(), 5.0).isNotInRange(6.0, 10.0);
        initialize(Raw.doubleAssertion(), 5.0).isNotInRange(8.0, 9.0);

        try {
            Raw.doubleAssertion().isNotInRange(1.0, 1.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleAssertion(), null).isNotInRange(1.0, 1.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), null, "Message").isNotInRange(1.0, 1.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), 5.0).isNotInRange(4.0, 6.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be in the expected range.\n\tExpected:<4.0:6.0> but was:<5.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 5.0, "Message").isNotInRange(4.0, 6.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be in the expected range.\n\tExpected:<4.0:6.0> but was:<5.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 5.0).isNotInRange(5.0, 6.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be in the expected range.\n\tExpected:<5.0:6.0> but was:<5.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 5.0, "Message").isNotInRange(5.0, 6.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be in the expected range.\n\tExpected:<5.0:6.0> but was:<5.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 5.0).isNotInRange(1.0, 10.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be in the expected range.\n\tExpected:<1.0:10.0> but was:<5.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 5.0, "Message").isNotInRange(1.0, 10.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be in the expected range.\n\tExpected:<1.0:10.0> but was:<5.0>");
        }
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void isZeroTest() {
        initialize(Raw.doubleAssertion(), 0.0).isZero();
        initialize(Raw.doubleAssertion(), +0.0).isZero();
        initialize(Raw.doubleAssertion(), -0.0).isZero();

        try {
            Raw.doubleAssertion().isZero();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleAssertion(), null).isZero();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), null, "Message").isZero();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0).isZero();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be zero.\n\tActual:<10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0, "Message").isZero();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be zero.\n\tActual:<10.0>");
        }
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void isNonZeroTest() {
        initialize(Raw.doubleAssertion(), 10.0).isNonZero();
        initialize(Raw.doubleAssertion(), -10.0).isNonZero();
        initialize(Raw.doubleAssertion(), Double.POSITIVE_INFINITY).isNonZero();
        initialize(Raw.doubleAssertion(), Double.NEGATIVE_INFINITY).isNonZero();
        initialize(Raw.doubleAssertion(), Double.NaN).isNonZero();

        try {
            Raw.doubleAssertion().isNonZero();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleAssertion(), null).isNonZero();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), null, "Message").isNonZero();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), 0.0).isNonZero();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be zero.");
        }
        try {
            initialize(Raw.doubleAssertion(), 0.0, "Message").isNonZero();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be zero.");
        }
        try {
            initialize(Raw.doubleAssertion(), +0.0).isNonZero();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be zero.");
        }
        try {
            initialize(Raw.doubleAssertion(), +0.0, "Message").isNonZero();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be zero.");
        }
        try {
            initialize(Raw.doubleAssertion(), -0.0).isNonZero();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be zero.");
        }
        try {
            initialize(Raw.doubleAssertion(), -0.0, "Message").isNonZero();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be zero.");
        }
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void isPositiveInfinityTest() {
        initialize(Raw.doubleAssertion(), Double.POSITIVE_INFINITY).isPositiveInfinity();
        double val = getZero();
        initialize(Raw.doubleAssertion(), 1.0 / val).isPositiveInfinity();

        try {
            Raw.doubleAssertion().isPositiveInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleAssertion(), null).isPositiveInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), null, "Message").isPositiveInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), 0.0).isPositiveInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be positive infinity.\n\tActual:<0.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 0.0, "Message").isPositiveInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be positive infinity.\n\tActual:<0.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0).isPositiveInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be positive infinity.\n\tActual:<10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0, "Message").isPositiveInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be positive infinity.\n\tActual:<10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), Double.NaN).isPositiveInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be positive infinity.\n\tActual:<NaN>");
        }
        try {
            initialize(Raw.doubleAssertion(), Double.NaN, "Message").isPositiveInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be positive infinity.\n\tActual:<NaN>");
        }
        try {
            initialize(Raw.doubleAssertion(), Double.NEGATIVE_INFINITY).isPositiveInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be positive infinity.\n\tActual:<-Infinity>");
        }
        try {
            initialize(Raw.doubleAssertion(), Double.NEGATIVE_INFINITY, "Message").isPositiveInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be positive infinity.\n\tActual:<-Infinity>");
        }
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void isNegativeInfinityTest() {
        initialize(Raw.doubleAssertion(), Double.NEGATIVE_INFINITY).isNegativeInfinity();
        double val = getZero();
        initialize(Raw.doubleAssertion(), -1.0 / val).isNegativeInfinity();

        try {
            Raw.doubleAssertion().isNegativeInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleAssertion(), null).isNegativeInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), null, "Message").isNegativeInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), 0.0).isNegativeInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be negative infinity.\n\tActual:<0.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 0.0, "Message").isNegativeInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be negative infinity.\n\tActual:<0.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), -10.0).isNegativeInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be negative infinity.\n\tActual:<-10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), -10.0, "Message").isNegativeInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be negative infinity.\n\tActual:<-10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), Double.NaN).isNegativeInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be negative infinity.\n\tActual:<NaN>");
        }
        try {
            initialize(Raw.doubleAssertion(), Double.NaN, "Message").isNegativeInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be negative infinity.\n\tActual:<NaN>");
        }
        try {
            initialize(Raw.doubleAssertion(), Double.POSITIVE_INFINITY).isNegativeInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be negative infinity.\n\tActual:<Infinity>");
        }
        try {
            initialize(Raw.doubleAssertion(), Double.POSITIVE_INFINITY, "Message").isNegativeInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be negative infinity.\n\tActual:<Infinity>");
        }
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void isInfinityTest() {
        initialize(Raw.doubleAssertion(), Double.POSITIVE_INFINITY).isInfinity();
        initialize(Raw.doubleAssertion(), Double.NEGATIVE_INFINITY).isInfinity();
        double val = getZero();
        initialize(Raw.doubleAssertion(), 1.0 / val).isInfinity();
        initialize(Raw.doubleAssertion(), -1.0 / val).isInfinity();

        try {
            Raw.doubleAssertion().isInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleAssertion(), null).isInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), null, "Message").isInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), 0.0).isInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be infinity.\n\tActual:<0.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 0.0, "Message").isInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be infinity.\n\tActual:<0.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0).isInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be infinity.\n\tActual:<10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0, "Message").isInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be infinity.\n\tActual:<10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), -10.0).isInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be infinity.\n\tActual:<-10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), -10.0, "Message").isInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be infinity.\n\tActual:<-10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), Double.NaN).isInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be infinity.\n\tActual:<NaN>");
        }
        try {
            initialize(Raw.doubleAssertion(), Double.NaN, "Message").isInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be infinity.\n\tActual:<NaN>");
        }
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void isNaNTest() {
        initialize(Raw.doubleAssertion(), Double.NaN).isNaN();
        initialize(Raw.doubleAssertion(), Math.sqrt(-2.0)).isNaN();
        initialize(Raw.doubleAssertion(), Double.POSITIVE_INFINITY / Double.NEGATIVE_INFINITY).isNaN();

        try {
            Raw.doubleAssertion().isNaN();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleAssertion(), null).isNaN();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), null, "Message").isNaN();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), 0.0).isNaN();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be NaN.\n\tActual:<0.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 0.0, "Message").isNaN();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be NaN.\n\tActual:<0.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0).isNaN();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be NaN.\n\tActual:<10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0, "Message").isNaN();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be NaN.\n\tActual:<10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), -10.0).isNaN();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be NaN.\n\tActual:<-10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), -10.0, "Message").isNaN();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be NaN.\n\tActual:<-10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), Double.POSITIVE_INFINITY).isNaN();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be NaN.\n\tActual:<Infinity>");
        }
        try {
            initialize(Raw.doubleAssertion(), Double.POSITIVE_INFINITY, "Message").isNaN();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be NaN.\n\tActual:<Infinity>");
        }
        try {
            initialize(Raw.doubleAssertion(), Double.NEGATIVE_INFINITY).isNaN();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be NaN.\n\tActual:<-Infinity>");
        }
        try {
            initialize(Raw.doubleAssertion(), Double.NEGATIVE_INFINITY, "Message").isNaN();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be NaN.\n\tActual:<-Infinity>");
        }
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void isNotNaNTest() {
        initialize(Raw.doubleAssertion(), 0.0).isNotNaN();
        initialize(Raw.doubleAssertion(), 10.0).isNotNaN();
        initialize(Raw.doubleAssertion(), -10.0).isNotNaN();
        initialize(Raw.doubleAssertion(), Double.POSITIVE_INFINITY).isNotNaN();
        initialize(Raw.doubleAssertion(), Double.NEGATIVE_INFINITY).isNotNaN();

        try {
            Raw.doubleAssertion().isNotNaN();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleAssertion(), null).isNotNaN();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), null, "Message").isNotNaN();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), Double.NaN).isNotNaN();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be NaN.");
        }
        try {
            initialize(Raw.doubleAssertion(), Double.NaN, "Message").isNotNaN();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be NaN.");
        }
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void isFiniteTest() {
        initialize(Raw.doubleAssertion(), 0.0).isFinite();
        initialize(Raw.doubleAssertion(), 10.0).isFinite();
        initialize(Raw.doubleAssertion(), -10.0).isFinite();

        try {
            Raw.doubleAssertion().isFinite();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleAssertion(), null).isFinite();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), null, "Message").isFinite();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), Double.NaN).isFinite();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be finite.\n\tActual:<NaN>");
        }
        try {
            initialize(Raw.doubleAssertion(), Double.NaN, "Message").isFinite();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be finite.\n\tActual:<NaN>");
        }
        try {
            initialize(Raw.doubleAssertion(), Double.POSITIVE_INFINITY).isFinite();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be finite.\n\tActual:<Infinity>");
        }
        try {
            initialize(Raw.doubleAssertion(), Double.POSITIVE_INFINITY, "Message").isFinite();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be finite.\n\tActual:<Infinity>");
        }
        try {
            initialize(Raw.doubleAssertion(), Double.NEGATIVE_INFINITY).isFinite();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be finite.\n\tActual:<-Infinity>");
        }
        try {
            initialize(Raw.doubleAssertion(), Double.NEGATIVE_INFINITY, "Message").isFinite();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be finite.\n\tActual:<-Infinity>");
        }
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void isNullTest() {
        initialize(Raw.doubleAssertion(), null).isNull();

        try {
            initialize(Raw.doubleAssertion(), 10.0).isNull();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null.\n\tActual:<10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0, "Message").isNull();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null.\n\tActual:<10.0>");
        }
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void isSameAsTest() {
        Double value = 10000.0;
        initialize(Raw.doubleAssertion(), value).isSameAs(value);

        try {
            initialize(Raw.doubleAssertion(), value).isSameAs(10000.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should point to the same object.\n\tExpected:<10000.0> but was:<10000.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), value, "Message").isSameAs(10000.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should point to the same object.\n\tExpected:<10000.0> but was:<10000.0>");
        }
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        Double value = 10000.0;
        initialize(Raw.doubleAssertion(), value).isNotSameAs(10000.0);

        try {
            initialize(Raw.doubleAssertion(), value).isNotSameAs(value);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should point to the different objects.\n\tActual:<10000.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should point to the different objects.\n\tActual:<10000.0>");
        }
    }

    private double getZero() {
        return 0.0;
    }

}
