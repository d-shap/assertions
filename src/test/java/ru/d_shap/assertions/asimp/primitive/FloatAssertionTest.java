///////////////////////////////////////////////////////////////////////////////////////////////////
// Assertions framework provides facilities for the unit testing.
// Copyright (C) 2017 Dmitry Shapovalov.
//
// This file is part of assertions framework.
//
// Assertions framework is free software: you can redistribute it and/or modify
// it under the terms of the GNU Lesser General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// Assertions framework is distributed in the hope that it will be useful,
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
 * Tests for {@link FloatAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class FloatAssertionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public FloatAssertionTest() {
        super();
    }

    /**
     * {@link FloatAssertion} class test.
     */
    @Test
    public void actualValueValidatorTest() {
        initialize(Raw.floatAssertion(), 10.0f);

        try {
            initializeWithRawActual(Raw.floatAssertion(), new Object());
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<java.lang.Float> but was:<java.lang.Object>");
        }
        try {
            initializeWithRawActual(Raw.floatAssertion(), new Object(), "Message");
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<java.lang.Float> but was:<java.lang.Object>");
        }
    }

    /**
     * {@link FloatAssertion} class test.
     */
    @Test
    public void isEqualToDefaultDeltaTest() {
        initialize(Raw.floatAssertion(), 10.1f).isEqualTo(10.1f);
        initialize(Raw.floatAssertion(), 10.01f).isEqualTo(10.01f);
        initialize(Raw.floatAssertion(), 10.001f).isEqualTo(10.001f);
        initialize(Raw.floatAssertion(), 10.0001f).isEqualTo(10.0001f);
        initialize(Raw.floatAssertion(), 10.00001f).isEqualTo(10.00001f);
        initialize(Raw.floatAssertion(), 10.000011f).isEqualTo(10.000012f);
        initialize(Raw.floatAssertion(), 10.000001f).isEqualTo(10.000002f);
        initialize(Raw.floatAssertion(), 10.0000001f).isEqualTo(10.0000002f);

        try {
            Raw.floatAssertion().isEqualTo(1.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatAssertion(), null).isEqualTo(1.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), null, "Message").isEqualTo(1.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), 10.00001f).isEqualTo(10.00002f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<10.00002f±1.0E-5f> but was:<10.00001f>");
        }
        try {
            initialize(Raw.floatAssertion(), 10.00001f, "Message").isEqualTo(10.00002f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<10.00002f±1.0E-5f> but was:<10.00001f>");
        }
    }

    /**
     * {@link FloatAssertion} class test.
     */
    @Test
    public void isEqualToSpecifiedDeltaTest() {
        initialize(Raw.floatAssertion(), 10.0f).isEqualTo(10.0f, 0.01f);
        initialize(Raw.floatAssertion(), 10.0f).isEqualTo(9.999f, 0.01f);
        initialize(Raw.floatAssertion(), 10.0f).isEqualTo(10.001f, 0.01f);
        initialize(Raw.floatAssertion(), 0.0f).isEqualTo(0.0f, 0.01f);
        initialize(Raw.floatAssertion(), Float.MAX_VALUE).isEqualTo(Float.MAX_VALUE, 0.01f);
        initialize(Raw.floatAssertion(), -0.0f).isEqualTo(+0.0f, 0.0f);
        initialize(Raw.floatAssertion(), +0.0f).isEqualTo(-0.0f, 0.0f);

        try {
            Raw.floatAssertion().isEqualTo(1.0f, 0.01f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatAssertion(), null).isEqualTo(1.0f, 0.01f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), null, "Message").isEqualTo(1.0f, 0.01f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f).isEqualTo(10.01f, 0.001f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<10.01f±0.001f> but was:<10.0f>");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f, "Message").isEqualTo(10.01f, 0.001f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<10.01f±0.001f> but was:<10.0f>");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f).isEqualTo(9.99f, 0.001f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<9.99f±0.001f> but was:<10.0f>");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f, "Message").isEqualTo(9.99f, 0.001f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<9.99f±0.001f> but was:<10.0f>");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f).isEqualTo(20.0f, 0.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<20.0f±0.0f> but was:<10.0f>");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f, "Message").isEqualTo(20.0f, 0.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<20.0f±0.0f> but was:<10.0f>");
        }
    }

    /**
     * {@link FloatAssertion} class test.
     */
    @Test
    public void isNotEqualToDefaultDeltaTest() {
        initialize(Raw.floatAssertion(), 10.1f).isNotEqualTo(10.2f);
        initialize(Raw.floatAssertion(), 10.01f).isNotEqualTo(10.02f);
        initialize(Raw.floatAssertion(), 10.001f).isNotEqualTo(10.002f);
        initialize(Raw.floatAssertion(), 10.0001f).isNotEqualTo(10.0002f);
        initialize(Raw.floatAssertion(), 10.00001f).isNotEqualTo(10.00002f);

        try {
            Raw.floatAssertion().isNotEqualTo(1.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatAssertion(), null).isNotEqualTo(1.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), null, "Message").isNotEqualTo(1.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), 10.000001f).isNotEqualTo(10.000002f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<10.000001f±1.0E-5f>");
        }
        try {
            initialize(Raw.floatAssertion(), 10.000001f, "Message").isNotEqualTo(10.000002f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<10.000001f±1.0E-5f>");
        }
    }

    /**
     * {@link FloatAssertion} class test.
     */
    @Test
    public void isNotEqualToSpecifiedDeltaTest() {
        initialize(Raw.floatAssertion(), 10.0f).isNotEqualTo(10.01f, 0.001f);
        initialize(Raw.floatAssertion(), 10.0f).isNotEqualTo(9.99f, 0.001f);
        initialize(Raw.floatAssertion(), 10.0f).isNotEqualTo(20.0f, 0.0f);

        try {
            Raw.floatAssertion().isNotEqualTo(1.0f, 0.001f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatAssertion(), null).isNotEqualTo(1.0f, 0.001f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), null, "Message").isNotEqualTo(1.0f, 0.001f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f).isNotEqualTo(10.001f, 0.01f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<10.0f±0.01f>");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f, "Message").isNotEqualTo(10.001f, 0.01f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<10.0f±0.01f>");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f).isNotEqualTo(9.999f, 0.01f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<10.0f±0.01f>");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f, "Message").isNotEqualTo(9.999f, 0.01f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<10.0f±0.01f>");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f).isNotEqualTo(10.0f, 0.01f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<10.0f±0.01f>");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f, "Message").isNotEqualTo(10.0f, 0.01f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<10.0f±0.01f>");
        }
        try {
            initialize(Raw.floatAssertion(), +0.0f).isNotEqualTo(-0.0f, 0.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<0.0f±0.0f>");
        }
        try {
            initialize(Raw.floatAssertion(), +0.0f, "Message").isNotEqualTo(-0.0f, 0.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<0.0f±0.0f>");
        }
        try {
            initialize(Raw.floatAssertion(), -0.0f).isNotEqualTo(+0.0f, 0.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<-0.0f±0.0f>");
        }
        try {
            initialize(Raw.floatAssertion(), -0.0f, "Message").isNotEqualTo(+0.0f, 0.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<-0.0f±0.0f>");
        }
    }

    /**
     * {@link FloatAssertion} class test.
     */
    @Test
    public void isGreaterThanTest() {
        initialize(Raw.floatAssertion(), 10.0f).isGreaterThan(9.0f);
        initialize(Raw.floatAssertion(), 10.0f).isGreaterThan(8.0f);
        initialize(Raw.floatAssertion(), 10.0f).isGreaterThan(-1.0f);

        try {
            Raw.floatAssertion().isGreaterThan(1.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatAssertion(), null).isGreaterThan(1.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), null, "Message").isGreaterThan(1.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f).isGreaterThan(10.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater than the expected.\n\tExpected:<10.0f> but was:<10.0f>");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f, "Message").isGreaterThan(10.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be greater than the expected.\n\tExpected:<10.0f> but was:<10.0f>");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f).isGreaterThan(11.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater than the expected.\n\tExpected:<11.0f> but was:<10.0f>");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f, "Message").isGreaterThan(11.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be greater than the expected.\n\tExpected:<11.0f> but was:<10.0f>");
        }
    }

    /**
     * {@link FloatAssertion} class test.
     */
    @Test
    public void isGreaterThanOrEqualToTest() {
        initialize(Raw.floatAssertion(), 10.0f).isGreaterThanOrEqualTo(9.0f);
        initialize(Raw.floatAssertion(), 10.0f).isGreaterThanOrEqualTo(10.0f);
        initialize(Raw.floatAssertion(), 10.0f).isGreaterThanOrEqualTo(-1.0f);

        try {
            Raw.floatAssertion().isGreaterThanOrEqualTo(1.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatAssertion(), null).isGreaterThanOrEqualTo(1.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), null, "Message").isGreaterThanOrEqualTo(1.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f).isGreaterThanOrEqualTo(11.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater than or equal to the expected.\n\tExpected:<11.0f> but was:<10.0f>");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f, "Message").isGreaterThanOrEqualTo(11.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be greater than or equal to the expected.\n\tExpected:<11.0f> but was:<10.0f>");
        }
    }

    /**
     * {@link FloatAssertion} class test.
     */
    @Test
    public void isLessThanTest() {
        initialize(Raw.floatAssertion(), 10.0f).isLessThan(11.0f);
        initialize(Raw.floatAssertion(), 10.0f).isLessThan(12.0f);
        initialize(Raw.floatAssertion(), 10.0f).isLessThan(100.0f);

        try {
            Raw.floatAssertion().isLessThan(1.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatAssertion(), null).isLessThan(1.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), null, "Message").isLessThan(1.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f).isLessThan(10.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than the expected.\n\tExpected:<10.0f> but was:<10.0f>");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f, "Message").isLessThan(10.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be less than the expected.\n\tExpected:<10.0f> but was:<10.0f>");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f).isLessThan(9.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than the expected.\n\tExpected:<9.0f> but was:<10.0f>");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f, "Message").isLessThan(9.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be less than the expected.\n\tExpected:<9.0f> but was:<10.0f>");
        }
    }

    /**
     * {@link FloatAssertion} class test.
     */
    @Test
    public void isLessThanOrEqualToTest() {
        initialize(Raw.floatAssertion(), 10.0f).isLessThanOrEqualTo(11.0f);
        initialize(Raw.floatAssertion(), 10.0f).isLessThanOrEqualTo(10.0f);
        initialize(Raw.floatAssertion(), 10.0f).isLessThanOrEqualTo(100.0f);

        try {
            Raw.floatAssertion().isLessThanOrEqualTo(1.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatAssertion(), null).isLessThanOrEqualTo(1.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), null, "Message").isLessThanOrEqualTo(1.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f).isLessThanOrEqualTo(9.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than or equal to the expected.\n\tExpected:<9.0f> but was:<10.0f>");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f, "Message").isLessThanOrEqualTo(9.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be less than or equal to the expected.\n\tExpected:<9.0f> but was:<10.0f>");
        }
    }

    /**
     * {@link FloatAssertion} class test.
     */
    @Test
    public void isInRangeTest() {
        initialize(Raw.floatAssertion(), 5.0f).isInRange(4.0f, 6.0f);
        initialize(Raw.floatAssertion(), 5.0f).isInRange(5.0f, 6.0f);
        initialize(Raw.floatAssertion(), 5.0f).isInRange(1.0f, 10.0f);

        try {
            Raw.floatAssertion().isInRange(1.0f, 1.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatAssertion(), null).isInRange(1.0f, 1.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), null, "Message").isInRange(1.0f, 1.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), 5.0f).isInRange(1.0f, 5.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be in the expected range.\n\tExpected:<1.0f:5.0f> but was:<5.0f>");
        }
        try {
            initialize(Raw.floatAssertion(), 5.0f, "Message").isInRange(1.0f, 5.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be in the expected range.\n\tExpected:<1.0f:5.0f> but was:<5.0f>");
        }
        try {
            initialize(Raw.floatAssertion(), 5.0f).isInRange(6.0f, 10.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be in the expected range.\n\tExpected:<6.0f:10.0f> but was:<5.0f>");
        }
        try {
            initialize(Raw.floatAssertion(), 5.0f, "Message").isInRange(6.0f, 10.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be in the expected range.\n\tExpected:<6.0f:10.0f> but was:<5.0f>");
        }
        try {
            initialize(Raw.floatAssertion(), 5.0f).isInRange(8.0f, 9.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be in the expected range.\n\tExpected:<8.0f:9.0f> but was:<5.0f>");
        }
        try {
            initialize(Raw.floatAssertion(), 5.0f, "Message").isInRange(8.0f, 9.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be in the expected range.\n\tExpected:<8.0f:9.0f> but was:<5.0f>");
        }
    }

    /**
     * {@link FloatAssertion} class test.
     */
    @Test
    public void isNotInRangeTest() {
        initialize(Raw.floatAssertion(), 5.0f).isNotInRange(1.0f, 5.0f);
        initialize(Raw.floatAssertion(), 5.0f).isNotInRange(6.0f, 10.0f);
        initialize(Raw.floatAssertion(), 5.0f).isNotInRange(8.0f, 9.0f);

        try {
            Raw.floatAssertion().isNotInRange(1.0f, 1.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatAssertion(), null).isNotInRange(1.0f, 1.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), null, "Message").isNotInRange(1.0f, 1.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), 5.0f).isNotInRange(4.0f, 6.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be in the expected range.\n\tExpected:<4.0f:6.0f> but was:<5.0f>");
        }
        try {
            initialize(Raw.floatAssertion(), 5.0f, "Message").isNotInRange(4.0f, 6.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be in the expected range.\n\tExpected:<4.0f:6.0f> but was:<5.0f>");
        }
        try {
            initialize(Raw.floatAssertion(), 5.0f).isNotInRange(5.0f, 6.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be in the expected range.\n\tExpected:<5.0f:6.0f> but was:<5.0f>");
        }
        try {
            initialize(Raw.floatAssertion(), 5.0f, "Message").isNotInRange(5.0f, 6.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be in the expected range.\n\tExpected:<5.0f:6.0f> but was:<5.0f>");
        }
        try {
            initialize(Raw.floatAssertion(), 5.0f).isNotInRange(1.0f, 10.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be in the expected range.\n\tExpected:<1.0f:10.0f> but was:<5.0f>");
        }
        try {
            initialize(Raw.floatAssertion(), 5.0f, "Message").isNotInRange(1.0f, 10.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be in the expected range.\n\tExpected:<1.0f:10.0f> but was:<5.0f>");
        }
    }

    /**
     * {@link FloatAssertion} class test.
     */
    @Test
    public void isZeroTest() {
        initialize(Raw.floatAssertion(), 0.0f).isZero();
        initialize(Raw.floatAssertion(), +0.0f).isZero();
        initialize(Raw.floatAssertion(), -0.0f).isZero();

        try {
            Raw.floatAssertion().isZero();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatAssertion(), null).isZero();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), null, "Message").isZero();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f).isZero();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be zero.\n\tActual:<10.0f>");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f, "Message").isZero();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be zero.\n\tActual:<10.0f>");
        }
    }

    /**
     * {@link FloatAssertion} class test.
     */
    @Test
    public void isNonZeroTest() {
        initialize(Raw.floatAssertion(), 10.0f).isNonZero();
        initialize(Raw.floatAssertion(), -10.0f).isNonZero();
        initialize(Raw.floatAssertion(), Float.POSITIVE_INFINITY).isNonZero();
        initialize(Raw.floatAssertion(), Float.NEGATIVE_INFINITY).isNonZero();
        initialize(Raw.floatAssertion(), Float.NaN).isNonZero();

        try {
            Raw.floatAssertion().isNonZero();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatAssertion(), null).isNonZero();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), null, "Message").isNonZero();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), 0.0f).isNonZero();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be zero.");
        }
        try {
            initialize(Raw.floatAssertion(), 0.0f, "Message").isNonZero();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be zero.");
        }
        try {
            initialize(Raw.floatAssertion(), +0.0f).isNonZero();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be zero.");
        }
        try {
            initialize(Raw.floatAssertion(), +0.0f, "Message").isNonZero();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be zero.");
        }
        try {
            initialize(Raw.floatAssertion(), -0.0f).isNonZero();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be zero.");
        }
        try {
            initialize(Raw.floatAssertion(), -0.0f, "Message").isNonZero();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be zero.");
        }
    }

    /**
     * {@link FloatAssertion} class test.
     */
    @Test
    public void isPositiveInfinityTest() {
        initialize(Raw.floatAssertion(), Float.POSITIVE_INFINITY).isPositiveInfinity();
        float val = 0.0f;
        initialize(Raw.floatAssertion(), 1.0f / val).isPositiveInfinity();

        try {
            Raw.floatAssertion().isPositiveInfinity();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatAssertion(), null).isPositiveInfinity();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), null, "Message").isPositiveInfinity();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), 0.0f).isPositiveInfinity();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be positive infinity.\n\tActual:<0.0f>");
        }
        try {
            initialize(Raw.floatAssertion(), 0.0f, "Message").isPositiveInfinity();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be positive infinity.\n\tActual:<0.0f>");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f).isPositiveInfinity();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be positive infinity.\n\tActual:<10.0f>");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f, "Message").isPositiveInfinity();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be positive infinity.\n\tActual:<10.0f>");
        }
        try {
            initialize(Raw.floatAssertion(), Float.NaN).isPositiveInfinity();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be positive infinity.\n\tActual:<NaN>");
        }
        try {
            initialize(Raw.floatAssertion(), Float.NaN, "Message").isPositiveInfinity();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be positive infinity.\n\tActual:<NaN>");
        }
        try {
            initialize(Raw.floatAssertion(), Float.NEGATIVE_INFINITY).isPositiveInfinity();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be positive infinity.\n\tActual:<-Infinity>");
        }
        try {
            initialize(Raw.floatAssertion(), Float.NEGATIVE_INFINITY, "Message").isPositiveInfinity();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be positive infinity.\n\tActual:<-Infinity>");
        }
    }

    /**
     * {@link FloatAssertion} class test.
     */
    @Test
    public void isNegativeInfinityTest() {
        initialize(Raw.floatAssertion(), Float.NEGATIVE_INFINITY).isNegativeInfinity();
        float val = 0.0f;
        initialize(Raw.floatAssertion(), -1.0f / val).isNegativeInfinity();

        try {
            Raw.floatAssertion().isNegativeInfinity();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatAssertion(), null).isNegativeInfinity();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), null, "Message").isNegativeInfinity();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), 0.0f).isNegativeInfinity();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be negative infinity.\n\tActual:<0.0f>");
        }
        try {
            initialize(Raw.floatAssertion(), 0.0f, "Message").isNegativeInfinity();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be negative infinity.\n\tActual:<0.0f>");
        }
        try {
            initialize(Raw.floatAssertion(), -10.0f).isNegativeInfinity();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be negative infinity.\n\tActual:<-10.0f>");
        }
        try {
            initialize(Raw.floatAssertion(), -10.0f, "Message").isNegativeInfinity();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be negative infinity.\n\tActual:<-10.0f>");
        }
        try {
            initialize(Raw.floatAssertion(), Float.NaN).isNegativeInfinity();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be negative infinity.\n\tActual:<NaN>");
        }
        try {
            initialize(Raw.floatAssertion(), Float.NaN, "Message").isNegativeInfinity();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be negative infinity.\n\tActual:<NaN>");
        }
        try {
            initialize(Raw.floatAssertion(), Float.POSITIVE_INFINITY).isNegativeInfinity();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be negative infinity.\n\tActual:<Infinity>");
        }
        try {
            initialize(Raw.floatAssertion(), Float.POSITIVE_INFINITY, "Message").isNegativeInfinity();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be negative infinity.\n\tActual:<Infinity>");
        }
    }

    /**
     * {@link FloatAssertion} class test.
     */
    @Test
    public void isInfinityTest() {
        initialize(Raw.floatAssertion(), Float.POSITIVE_INFINITY).isInfinity();
        initialize(Raw.floatAssertion(), Float.NEGATIVE_INFINITY).isInfinity();
        float val = 0.0f;
        initialize(Raw.floatAssertion(), 1.0f / val).isInfinity();
        initialize(Raw.floatAssertion(), -1.0f / val).isInfinity();

        try {
            Raw.floatAssertion().isInfinity();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatAssertion(), null).isInfinity();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), null, "Message").isInfinity();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), 0.0f).isInfinity();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be infinity.\n\tActual:<0.0f>");
        }
        try {
            initialize(Raw.floatAssertion(), 0.0f, "Message").isInfinity();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be infinity.\n\tActual:<0.0f>");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f).isInfinity();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be infinity.\n\tActual:<10.0f>");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f, "Message").isInfinity();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be infinity.\n\tActual:<10.0f>");
        }
        try {
            initialize(Raw.floatAssertion(), -10.0f).isInfinity();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be infinity.\n\tActual:<-10.0f>");
        }
        try {
            initialize(Raw.floatAssertion(), -10.0f, "Message").isInfinity();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be infinity.\n\tActual:<-10.0f>");
        }
        try {
            initialize(Raw.floatAssertion(), Float.NaN).isInfinity();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be infinity.\n\tActual:<NaN>");
        }
        try {
            initialize(Raw.floatAssertion(), Float.NaN, "Message").isInfinity();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be infinity.\n\tActual:<NaN>");
        }
    }

    /**
     * {@link FloatAssertion} class test.
     */
    @Test
    public void isNaNTest() {
        initialize(Raw.floatAssertion(), Float.NaN).isNaN();
        initialize(Raw.floatAssertion(), 0.0f / 0.0f).isNaN();
        initialize(Raw.floatAssertion(), Float.POSITIVE_INFINITY / Float.NEGATIVE_INFINITY).isNaN();

        try {
            Raw.floatAssertion().isNaN();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatAssertion(), null).isNaN();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), null, "Message").isNaN();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), 0.0f).isNaN();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be NaN.\n\tActual:<0.0f>");
        }
        try {
            initialize(Raw.floatAssertion(), 0.0f, "Message").isNaN();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be NaN.\n\tActual:<0.0f>");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f).isNaN();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be NaN.\n\tActual:<10.0f>");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f, "Message").isNaN();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be NaN.\n\tActual:<10.0f>");
        }
        try {
            initialize(Raw.floatAssertion(), -10.0f).isNaN();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be NaN.\n\tActual:<-10.0f>");
        }
        try {
            initialize(Raw.floatAssertion(), -10.0f, "Message").isNaN();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be NaN.\n\tActual:<-10.0f>");
        }
        try {
            initialize(Raw.floatAssertion(), Float.POSITIVE_INFINITY).isNaN();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be NaN.\n\tActual:<Infinity>");
        }
        try {
            initialize(Raw.floatAssertion(), Float.POSITIVE_INFINITY, "Message").isNaN();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be NaN.\n\tActual:<Infinity>");
        }
        try {
            initialize(Raw.floatAssertion(), Float.NEGATIVE_INFINITY).isNaN();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be NaN.\n\tActual:<-Infinity>");
        }
        try {
            initialize(Raw.floatAssertion(), Float.NEGATIVE_INFINITY, "Message").isNaN();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be NaN.\n\tActual:<-Infinity>");
        }
    }

    /**
     * {@link FloatAssertion} class test.
     */
    @Test
    public void isNotNaNTest() {
        initialize(Raw.floatAssertion(), 0.0f).isNotNaN();
        initialize(Raw.floatAssertion(), 10.0f).isNotNaN();
        initialize(Raw.floatAssertion(), -10.0f).isNotNaN();
        initialize(Raw.floatAssertion(), Float.POSITIVE_INFINITY).isNotNaN();
        initialize(Raw.floatAssertion(), Float.NEGATIVE_INFINITY).isNotNaN();

        try {
            Raw.floatAssertion().isNotNaN();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatAssertion(), null).isNotNaN();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), null, "Message").isNotNaN();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), Float.NaN).isNotNaN();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be NaN.");
        }
        try {
            initialize(Raw.floatAssertion(), Float.NaN, "Message").isNotNaN();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be NaN.");
        }
    }

    /**
     * {@link FloatAssertion} class test.
     */
    @Test
    public void isFiniteTest() {
        initialize(Raw.floatAssertion(), 0.0f).isFinite();
        initialize(Raw.floatAssertion(), 10.0f).isFinite();
        initialize(Raw.floatAssertion(), -10.0f).isFinite();

        try {
            Raw.floatAssertion().isFinite();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatAssertion(), null).isFinite();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), null, "Message").isFinite();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), Float.NaN).isFinite();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be finite.\n\tActual:<NaN>");
        }
        try {
            initialize(Raw.floatAssertion(), Float.NaN, "Message").isFinite();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be finite.\n\tActual:<NaN>");
        }
        try {
            initialize(Raw.floatAssertion(), Float.POSITIVE_INFINITY).isFinite();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be finite.\n\tActual:<Infinity>");
        }
        try {
            initialize(Raw.floatAssertion(), Float.POSITIVE_INFINITY, "Message").isFinite();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be finite.\n\tActual:<Infinity>");
        }
        try {
            initialize(Raw.floatAssertion(), Float.NEGATIVE_INFINITY).isFinite();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be finite.\n\tActual:<-Infinity>");
        }
        try {
            initialize(Raw.floatAssertion(), Float.NEGATIVE_INFINITY, "Message").isFinite();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be finite.\n\tActual:<-Infinity>");
        }
    }

    /**
     * {@link FloatAssertion} class test.
     */
    @Test
    public void isNullTest() {
        initialize(Raw.floatAssertion(), null).isNull();

        try {
            initialize(Raw.floatAssertion(), 10.0f).isNull();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null.\n\tActual:<10.0f>");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f, "Message").isNull();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null.\n\tActual:<10.0f>");
        }
    }

    /**
     * {@link FloatAssertion} class test.
     */
    @Test
    public void isSameAsTest() {
        Float value = 10000.0f;
        initialize(Raw.floatAssertion(), value).isSameAs(value);

        try {
            initialize(Raw.floatAssertion(), value).isSameAs(10000.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<10000.0f> but was:<10000.0f>");
        }
        try {
            initialize(Raw.floatAssertion(), value, "Message").isSameAs(10000.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<10000.0f> but was:<10000.0f>");
        }
    }

    /**
     * {@link FloatAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        Float value = 10000.0f;
        initialize(Raw.floatAssertion(), value).isNotSameAs(10000.0f);

        try {
            initialize(Raw.floatAssertion(), value).isNotSameAs(value);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<10000.0f>");
        }
        try {
            initialize(Raw.floatAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<10000.0f>");
        }
    }

}
