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
package ru.d_shap.assertions.primitive;

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
            Assertions.assertThat(ex).hasMessage("Value should match the assertion.");
        }
        try {
            initializeWithRawActual(Raw.floatAssertion(), new Object(), "Message");
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should match the assertion.");
        }
    }

    /**
     * {@link FloatAssertion} class test.
     */
    @Test
    public void isEqualToTest() {
        initialize(Raw.floatAssertion(), 10.0f).isEqualTo(10.0f, 0.01f);
        initialize(Raw.floatAssertion(), 10.0f).isEqualTo(9.999f, 0.01f);
        initialize(Raw.floatAssertion(), 10.0f).isEqualTo(10.001f, 0.01f);
        initialize(Raw.floatAssertion(), 0.0f).isEqualTo(0.0f, 0.01f);
        initialize(Raw.floatAssertion(), Float.MAX_VALUE).isEqualTo(Float.MAX_VALUE, 0.01f);
        initialize(Raw.floatAssertion(), -0.0f).isEqualTo(+0.0f, 0.0f);
        initialize(Raw.floatAssertion(), +0.0f).isEqualTo(-0.0f, 0.0f);

        try {
            Raw.floatAssertion().isEqualTo(10.0f, 0.01f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatAssertion(), null).isEqualTo(10.0f, 0.01f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), null, "Message").isEqualTo(10.0f, 0.01f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f).isEqualTo(10.01f, 0.001f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<10.01> but was:<10.0>");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f, "Message").isEqualTo(10.01f, 0.001f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<10.01> but was:<10.0>");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f).isEqualTo(9.99f, 0.001f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<9.99> but was:<10.0>");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f, "Message").isEqualTo(9.99f, 0.001f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<9.99> but was:<10.0>");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f).isEqualTo(20.0f, 0.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<20.0> but was:<10.0>");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f, "Message").isEqualTo(20.0f, 0.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<20.0> but was:<10.0>");
        }
    }

    /**
     * {@link FloatAssertion} class test.
     */
    @Test
    public void isNotEqualToTest() {
        initialize(Raw.floatAssertion(), 10.0f).isNotEqualTo(10.01f, 0.001f);
        initialize(Raw.floatAssertion(), 10.0f).isNotEqualTo(9.99f, 0.001f);
        initialize(Raw.floatAssertion(), 10.0f).isNotEqualTo(20.0f, 0.0f);

        try {
            Raw.floatAssertion().isNotEqualTo(10.01f, 0.001f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatAssertion(), null).isNotEqualTo(10.01f, 0.001f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), null, "Message").isNotEqualTo(10.01f, 0.001f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f).isNotEqualTo(10.001f, 0.01f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<10.0>");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f, "Message").isNotEqualTo(10.001f, 0.01f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be different. Actual:<10.0>");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f).isNotEqualTo(9.999f, 0.01f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<10.0>");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f, "Message").isNotEqualTo(9.999f, 0.01f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be different. Actual:<10.0>");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f).isNotEqualTo(10.0f, 0.01f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<10.0>");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f, "Message").isNotEqualTo(10.0f, 0.01f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be different. Actual:<10.0>");
        }
        try {
            initialize(Raw.floatAssertion(), +0.0f).isNotEqualTo(-0.0f, 0.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<0.0>");
        }
        try {
            initialize(Raw.floatAssertion(), +0.0f, "Message").isNotEqualTo(-0.0f, 0.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be different. Actual:<0.0>");
        }
        try {
            initialize(Raw.floatAssertion(), -0.0f).isNotEqualTo(+0.0f, 0.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<-0.0>");
        }
        try {
            initialize(Raw.floatAssertion(), -0.0f, "Message").isNotEqualTo(+0.0f, 0.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be different. Actual:<-0.0>");
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
            Raw.floatAssertion().isGreaterThan(9.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatAssertion(), null).isGreaterThan(9.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), null, "Message").isGreaterThan(9.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f).isGreaterThan(10.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then the expected. Expected:<10.0> but was:<10.0>");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f, "Message").isGreaterThan(10.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be greater then the expected. Expected:<10.0> but was:<10.0>");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f).isGreaterThan(11.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then the expected. Expected:<11.0> but was:<10.0>");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f, "Message").isGreaterThan(11.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be greater then the expected. Expected:<11.0> but was:<10.0>");
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
            Raw.floatAssertion().isGreaterThanOrEqualTo(9.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatAssertion(), null).isGreaterThanOrEqualTo(9.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), null, "Message").isGreaterThanOrEqualTo(9.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f).isGreaterThanOrEqualTo(11.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then or equal to the expected. Expected:<11.0> but was:<10.0>");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f, "Message").isGreaterThanOrEqualTo(11.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be greater then or equal to the expected. Expected:<11.0> but was:<10.0>");
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
            Raw.floatAssertion().isLessThan(11.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatAssertion(), null).isLessThan(11.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), null, "Message").isLessThan(11.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f).isLessThan(10.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then the expected. Expected:<10.0> but was:<10.0>");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f, "Message").isLessThan(10.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be less then the expected. Expected:<10.0> but was:<10.0>");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f).isLessThan(9.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then the expected. Expected:<9.0> but was:<10.0>");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f, "Message").isLessThan(9.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be less then the expected. Expected:<9.0> but was:<10.0>");
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
            Raw.floatAssertion().isLessThanOrEqualTo(11.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatAssertion(), null).isLessThanOrEqualTo(11.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), null, "Message").isLessThanOrEqualTo(11.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f).isLessThanOrEqualTo(9.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then or equal to the expected. Expected:<9.0> but was:<10.0>");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f, "Message").isLessThanOrEqualTo(9.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be less then or equal to the expected. Expected:<9.0> but was:<10.0>");
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
            Raw.floatAssertion().isInRange(4.0f, 6.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatAssertion(), null).isInRange(4.0f, 6.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), null, "Message").isInRange(4.0f, 6.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), 5.0f).isInRange(1.0f, 5.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<1.0:5.0> but was:<5.0>");
        }
        try {
            initialize(Raw.floatAssertion(), 5.0f, "Message").isInRange(1.0f, 5.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be in the expected range. Expected:<1.0:5.0> but was:<5.0>");
        }
        try {
            initialize(Raw.floatAssertion(), 5.0f).isInRange(6.0f, 10.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<6.0:10.0> but was:<5.0>");
        }
        try {
            initialize(Raw.floatAssertion(), 5.0f, "Message").isInRange(6.0f, 10.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be in the expected range. Expected:<6.0:10.0> but was:<5.0>");
        }
        try {
            initialize(Raw.floatAssertion(), 5.0f).isInRange(8.0f, 9.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<8.0:9.0> but was:<5.0>");
        }
        try {
            initialize(Raw.floatAssertion(), 5.0f, "Message").isInRange(8.0f, 9.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be in the expected range. Expected:<8.0:9.0> but was:<5.0>");
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
            Raw.floatAssertion().isNotInRange(1.0f, 5.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatAssertion(), null).isNotInRange(1.0f, 5.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), null, "Message").isNotInRange(1.0f, 5.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), 5.0f).isNotInRange(4.0f, 6.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<4.0:6.0> but was:<5.0>");
        }
        try {
            initialize(Raw.floatAssertion(), 5.0f, "Message").isNotInRange(4.0f, 6.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be in the expected range. Expected:<4.0:6.0> but was:<5.0>");
        }
        try {
            initialize(Raw.floatAssertion(), 5.0f).isNotInRange(5.0f, 6.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<5.0:6.0> but was:<5.0>");
        }
        try {
            initialize(Raw.floatAssertion(), 5.0f, "Message").isNotInRange(5.0f, 6.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be in the expected range. Expected:<5.0:6.0> but was:<5.0>");
        }
        try {
            initialize(Raw.floatAssertion(), 5.0f).isNotInRange(1.0f, 10.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<1.0:10.0> but was:<5.0>");
        }
        try {
            initialize(Raw.floatAssertion(), 5.0f, "Message").isNotInRange(1.0f, 10.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be in the expected range. Expected:<1.0:10.0> but was:<5.0>");
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
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), null, "Message").isZero();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f).isZero();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be zero. Actual:<10.0>");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f, "Message").isZero();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be zero. Actual:<10.0>");
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
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), null, "Message").isNonZero();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), 0.0f).isNonZero();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be zero.");
        }
        try {
            initialize(Raw.floatAssertion(), 0.0f, "Message").isNonZero();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be zero.");
        }
        try {
            initialize(Raw.floatAssertion(), +0.0f).isNonZero();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be zero.");
        }
        try {
            initialize(Raw.floatAssertion(), +0.0f, "Message").isNonZero();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be zero.");
        }
        try {
            initialize(Raw.floatAssertion(), -0.0f).isNonZero();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be zero.");
        }
        try {
            initialize(Raw.floatAssertion(), -0.0f, "Message").isNonZero();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be zero.");
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
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), null, "Message").isPositiveInfinity();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), 0.0f).isPositiveInfinity();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be positive infinity. Actual:<0.0>");
        }
        try {
            initialize(Raw.floatAssertion(), 0.0f, "Message").isPositiveInfinity();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be positive infinity. Actual:<0.0>");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f).isPositiveInfinity();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be positive infinity. Actual:<10.0>");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f, "Message").isPositiveInfinity();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be positive infinity. Actual:<10.0>");
        }
        try {
            initialize(Raw.floatAssertion(), Float.NaN).isPositiveInfinity();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be positive infinity. Actual:<NaN>");
        }
        try {
            initialize(Raw.floatAssertion(), Float.NaN, "Message").isPositiveInfinity();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be positive infinity. Actual:<NaN>");
        }
        try {
            initialize(Raw.floatAssertion(), Float.NEGATIVE_INFINITY).isPositiveInfinity();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be positive infinity. Actual:<-Infinity>");
        }
        try {
            initialize(Raw.floatAssertion(), Float.NEGATIVE_INFINITY, "Message").isPositiveInfinity();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be positive infinity. Actual:<-Infinity>");
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
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), null, "Message").isNegativeInfinity();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), 0.0f).isNegativeInfinity();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be negative infinity. Actual:<0.0>");
        }
        try {
            initialize(Raw.floatAssertion(), 0.0f, "Message").isNegativeInfinity();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be negative infinity. Actual:<0.0>");
        }
        try {
            initialize(Raw.floatAssertion(), -10.0f).isNegativeInfinity();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be negative infinity. Actual:<-10.0>");
        }
        try {
            initialize(Raw.floatAssertion(), -10.0f, "Message").isNegativeInfinity();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be negative infinity. Actual:<-10.0>");
        }
        try {
            initialize(Raw.floatAssertion(), Float.NaN).isNegativeInfinity();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be negative infinity. Actual:<NaN>");
        }
        try {
            initialize(Raw.floatAssertion(), Float.NaN, "Message").isNegativeInfinity();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be negative infinity. Actual:<NaN>");
        }
        try {
            initialize(Raw.floatAssertion(), Float.POSITIVE_INFINITY).isNegativeInfinity();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be negative infinity. Actual:<Infinity>");
        }
        try {
            initialize(Raw.floatAssertion(), Float.POSITIVE_INFINITY, "Message").isNegativeInfinity();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be negative infinity. Actual:<Infinity>");
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
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), null, "Message").isInfinity();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), 0.0f).isInfinity();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be infinity. Actual:<0.0>");
        }
        try {
            initialize(Raw.floatAssertion(), 0.0f, "Message").isInfinity();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be infinity. Actual:<0.0>");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f).isInfinity();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be infinity. Actual:<10.0>");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f, "Message").isInfinity();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be infinity. Actual:<10.0>");
        }
        try {
            initialize(Raw.floatAssertion(), -10.0f).isInfinity();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be infinity. Actual:<-10.0>");
        }
        try {
            initialize(Raw.floatAssertion(), -10.0f, "Message").isInfinity();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be infinity. Actual:<-10.0>");
        }
        try {
            initialize(Raw.floatAssertion(), Float.NaN).isInfinity();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be infinity. Actual:<NaN>");
        }
        try {
            initialize(Raw.floatAssertion(), Float.NaN, "Message").isInfinity();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be infinity. Actual:<NaN>");
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
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), null, "Message").isNaN();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), 0.0f).isNaN();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be NaN. Actual:<0.0>");
        }
        try {
            initialize(Raw.floatAssertion(), 0.0f, "Message").isNaN();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be NaN. Actual:<0.0>");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f).isNaN();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be NaN. Actual:<10.0>");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f, "Message").isNaN();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be NaN. Actual:<10.0>");
        }
        try {
            initialize(Raw.floatAssertion(), -10.0f).isNaN();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be NaN. Actual:<-10.0>");
        }
        try {
            initialize(Raw.floatAssertion(), -10.0f, "Message").isNaN();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be NaN. Actual:<-10.0>");
        }
        try {
            initialize(Raw.floatAssertion(), Float.POSITIVE_INFINITY).isNaN();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be NaN. Actual:<Infinity>");
        }
        try {
            initialize(Raw.floatAssertion(), Float.POSITIVE_INFINITY, "Message").isNaN();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be NaN. Actual:<Infinity>");
        }
        try {
            initialize(Raw.floatAssertion(), Float.NEGATIVE_INFINITY).isNaN();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be NaN. Actual:<-Infinity>");
        }
        try {
            initialize(Raw.floatAssertion(), Float.NEGATIVE_INFINITY, "Message").isNaN();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be NaN. Actual:<-Infinity>");
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
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), null, "Message").isNotNaN();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), Float.NaN).isNotNaN();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be NaN.");
        }
        try {
            initialize(Raw.floatAssertion(), Float.NaN, "Message").isNotNaN();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be NaN.");
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
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), null, "Message").isFinite();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), Float.NaN).isFinite();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be finite. Actual:<NaN>");
        }
        try {
            initialize(Raw.floatAssertion(), Float.NaN, "Message").isFinite();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be finite. Actual:<NaN>");
        }
        try {
            initialize(Raw.floatAssertion(), Float.POSITIVE_INFINITY).isFinite();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be finite. Actual:<Infinity>");
        }
        try {
            initialize(Raw.floatAssertion(), Float.POSITIVE_INFINITY, "Message").isFinite();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be finite. Actual:<Infinity>");
        }
        try {
            initialize(Raw.floatAssertion(), Float.NEGATIVE_INFINITY).isFinite();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be finite. Actual:<-Infinity>");
        }
        try {
            initialize(Raw.floatAssertion(), Float.NEGATIVE_INFINITY, "Message").isFinite();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be finite. Actual:<-Infinity>");
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
            Assertions.assertThat(ex).hasMessage("Value should be null. Actual:<10.0>");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f, "Message").isNull();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be null. Actual:<10.0>");
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
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<10000.0> but was:<10000.0>");
        }
        try {
            initialize(Raw.floatAssertion(), value, "Message").isSameAs(10000.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<10000.0> but was:<10000.0>");
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
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<10000.0>");
        }
        try {
            initialize(Raw.floatAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be different. Actual:<10000.0>");
        }
    }

    /**
     * {@link FloatAssertion} class test.
     */
    @Test
    public void asStringTest() {
        try {
            Assertions.assertThat(initialize(Raw.floatAssertion(), 10.0f).asString(null));
            Assertions.fail("FloatAssertion test fail");
        } catch (NullPointerException ex) {
            Assertions.assertThat(ex).isNotNull();
        }
        Assertions.assertThat(initialize(Raw.floatAssertion(), 10.0f).asString(5.0f)).isEqualTo("5.0");
        Assertions.assertThat(initialize(Raw.floatAssertion(), 10.0f).asString(60.0f)).isEqualTo("60.0");
        Assertions.assertThat(initialize(Raw.floatAssertion(), 10.0f).asString(244.0f)).isEqualTo("244.0");
        Assertions.assertThat(initialize(Raw.floatAssertion(), 10.0f).asString("test")).isEqualTo("test");
    }

}
