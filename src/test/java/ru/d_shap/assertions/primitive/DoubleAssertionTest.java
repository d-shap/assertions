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
            initialize(Raw.doubleAssertion(), new Object());
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should match the assertion.");
        }
        try {
            initialize(Raw.doubleAssertion(), new Object(), "Message");
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should match the assertion.");
        }
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void isEqualToTest() {
        initialize(Raw.doubleAssertion(), 10.0).isEqualTo(10.0, 0.01);
        initialize(Raw.doubleAssertion(), 10.0).isEqualTo(9.999, 0.01);
        initialize(Raw.doubleAssertion(), 10.0).isEqualTo(10.001, 0.01);
        initialize(Raw.doubleAssertion(), 0.0).isEqualTo(0.0, 0.01);
        initialize(Raw.doubleAssertion(), Double.MAX_VALUE).isEqualTo(Double.MAX_VALUE, 0.01);
        initialize(Raw.doubleAssertion(), -0.0).isEqualTo(+0.0, 0.0);
        initialize(Raw.doubleAssertion(), +0.0).isEqualTo(-0.0, 0.0);

        try {
            Raw.doubleAssertion().isEqualTo(10.0, 0.01);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleAssertion(), null).isEqualTo(10.0, 0.01);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), null, "Message").isEqualTo(10.0, 0.01);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0).isEqualTo(10.01, 0.001);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<10.01> but was:<10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0, "Message").isEqualTo(10.01, 0.001);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<10.01> but was:<10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0).isEqualTo(9.99, 0.001);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<9.99> but was:<10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0, "Message").isEqualTo(9.99, 0.001);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<9.99> but was:<10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0).isEqualTo(20.0, 0.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<20.0> but was:<10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0, "Message").isEqualTo(20.0, 0.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<20.0> but was:<10.0>");
        }
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void isNotEqualToTest() {
        initialize(Raw.doubleAssertion(), 10.0).isNotEqualTo(10.01, 0.001);
        initialize(Raw.doubleAssertion(), 10.0).isNotEqualTo(9.99, 0.001);
        initialize(Raw.doubleAssertion(), 10.0).isNotEqualTo(20.0, 0.0);

        try {
            Raw.doubleAssertion().isNotEqualTo(10.01, 0.001);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleAssertion(), null).isNotEqualTo(10.01, 0.001);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), null, "Message").isNotEqualTo(10.01, 0.001);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0).isNotEqualTo(10.001, 0.01);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0, "Message").isNotEqualTo(10.001, 0.01);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be different. Actual:<10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0).isNotEqualTo(9.999, 0.01);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0, "Message").isNotEqualTo(9.999, 0.01);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be different. Actual:<10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0).isNotEqualTo(10.0, 0.01);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0, "Message").isNotEqualTo(10.0, 0.01);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be different. Actual:<10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), +0.0).isNotEqualTo(-0.0, 0.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<0.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), +0.0, "Message").isNotEqualTo(-0.0, 0.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be different. Actual:<0.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), -0.0).isNotEqualTo(+0.0, 0.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<-0.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), -0.0, "Message").isNotEqualTo(+0.0, 0.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be different. Actual:<-0.0>");
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
            Raw.doubleAssertion().isGreaterThan(9.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleAssertion(), null).isGreaterThan(9.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), null, "Message").isGreaterThan(9.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0).isGreaterThan(10.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then the expected. Expected:<10.0> but was:<10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0, "Message").isGreaterThan(10.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be greater then the expected. Expected:<10.0> but was:<10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0).isGreaterThan(11.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then the expected. Expected:<11.0> but was:<10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0, "Message").isGreaterThan(11.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be greater then the expected. Expected:<11.0> but was:<10.0>");
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
            Raw.doubleAssertion().isGreaterThanOrEqualTo(9.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleAssertion(), null).isGreaterThanOrEqualTo(9.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), null, "Message").isGreaterThanOrEqualTo(9.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0).isGreaterThanOrEqualTo(11.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then or equal to the expected. Expected:<11.0> but was:<10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0, "Message").isGreaterThanOrEqualTo(11.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be greater then or equal to the expected. Expected:<11.0> but was:<10.0>");
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
            Raw.doubleAssertion().isLessThan(11.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleAssertion(), null).isLessThan(11.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), null, "Message").isLessThan(11.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0).isLessThan(10.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then the expected. Expected:<10.0> but was:<10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0, "Message").isLessThan(10.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be less then the expected. Expected:<10.0> but was:<10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0).isLessThan(9.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then the expected. Expected:<9.0> but was:<10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0, "Message").isLessThan(9.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be less then the expected. Expected:<9.0> but was:<10.0>");
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
            Raw.doubleAssertion().isLessThanOrEqualTo(11.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleAssertion(), null).isLessThanOrEqualTo(11.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), null, "Message").isLessThanOrEqualTo(11.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0).isLessThanOrEqualTo(9.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then or equal to the expected. Expected:<9.0> but was:<10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0, "Message").isLessThanOrEqualTo(9.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be less then or equal to the expected. Expected:<9.0> but was:<10.0>");
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
            Raw.doubleAssertion().isInRange(4.0, 6.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleAssertion(), null).isInRange(4.0, 6.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), null, "Message").isInRange(4.0, 6.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), 5.0).isInRange(1.0, 5.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<1.0:5.0> but was:<5.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 5.0, "Message").isInRange(1.0, 5.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be in the expected range. Expected:<1.0:5.0> but was:<5.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 5.0).isInRange(6.0, 10.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<6.0:10.0> but was:<5.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 5.0, "Message").isInRange(6.0, 10.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be in the expected range. Expected:<6.0:10.0> but was:<5.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 5.0).isInRange(8.0, 9.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<8.0:9.0> but was:<5.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 5.0, "Message").isInRange(8.0, 9.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be in the expected range. Expected:<8.0:9.0> but was:<5.0>");
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
            Raw.doubleAssertion().isNotInRange(1.0, 5.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleAssertion(), null).isNotInRange(1.0, 5.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), null, "Message").isNotInRange(1.0, 5.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), 5.0).isNotInRange(4.0, 6.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<4.0:6.0> but was:<5.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 5.0, "Message").isNotInRange(4.0, 6.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be in the expected range. Expected:<4.0:6.0> but was:<5.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 5.0).isNotInRange(5.0, 6.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<5.0:6.0> but was:<5.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 5.0, "Message").isNotInRange(5.0, 6.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be in the expected range. Expected:<5.0:6.0> but was:<5.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 5.0).isNotInRange(1.0, 10.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<1.0:10.0> but was:<5.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 5.0, "Message").isNotInRange(1.0, 10.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be in the expected range. Expected:<1.0:10.0> but was:<5.0>");
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
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), null, "Message").isZero();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0).isZero();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be zero. Actual:<10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0, "Message").isZero();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be zero. Actual:<10.0>");
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
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), null, "Message").isNonZero();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), 0.0).isNonZero();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be zero.");
        }
        try {
            initialize(Raw.doubleAssertion(), 0.0, "Message").isNonZero();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be zero.");
        }
        try {
            initialize(Raw.doubleAssertion(), +0.0).isNonZero();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be zero.");
        }
        try {
            initialize(Raw.doubleAssertion(), +0.0, "Message").isNonZero();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be zero.");
        }
        try {
            initialize(Raw.doubleAssertion(), -0.0).isNonZero();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be zero.");
        }
        try {
            initialize(Raw.doubleAssertion(), -0.0, "Message").isNonZero();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be zero.");
        }
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void isPositiveInfinityTest() {
        initialize(Raw.doubleAssertion(), Double.POSITIVE_INFINITY).isPositiveInfinity();
        double val = 0.0;
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
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), null, "Message").isPositiveInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), 0.0).isPositiveInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be positive infinity. Actual:<0.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 0.0, "Message").isPositiveInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be positive infinity. Actual:<0.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0).isPositiveInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be positive infinity. Actual:<10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0, "Message").isPositiveInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be positive infinity. Actual:<10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), Double.NaN).isPositiveInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be positive infinity. Actual:<NaN>");
        }
        try {
            initialize(Raw.doubleAssertion(), Double.NaN, "Message").isPositiveInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be positive infinity. Actual:<NaN>");
        }
        try {
            initialize(Raw.doubleAssertion(), Double.NEGATIVE_INFINITY).isPositiveInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be positive infinity. Actual:<-Infinity>");
        }
        try {
            initialize(Raw.doubleAssertion(), Double.NEGATIVE_INFINITY, "Message").isPositiveInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be positive infinity. Actual:<-Infinity>");
        }
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void isNegativeInfinityTest() {
        initialize(Raw.doubleAssertion(), Double.NEGATIVE_INFINITY).isNegativeInfinity();
        double val = 0.0;
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
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), null, "Message").isNegativeInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), 0.0).isNegativeInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be negative infinity. Actual:<0.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 0.0, "Message").isNegativeInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be negative infinity. Actual:<0.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), -10.0).isNegativeInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be negative infinity. Actual:<-10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), -10.0, "Message").isNegativeInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be negative infinity. Actual:<-10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), Double.NaN).isNegativeInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be negative infinity. Actual:<NaN>");
        }
        try {
            initialize(Raw.doubleAssertion(), Double.NaN, "Message").isNegativeInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be negative infinity. Actual:<NaN>");
        }
        try {
            initialize(Raw.doubleAssertion(), Double.POSITIVE_INFINITY).isNegativeInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be negative infinity. Actual:<Infinity>");
        }
        try {
            initialize(Raw.doubleAssertion(), Double.POSITIVE_INFINITY, "Message").isNegativeInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be negative infinity. Actual:<Infinity>");
        }
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void isInfinityTest() {
        initialize(Raw.doubleAssertion(), Double.POSITIVE_INFINITY).isInfinity();
        initialize(Raw.doubleAssertion(), Double.NEGATIVE_INFINITY).isInfinity();
        double val = 0.0;
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
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), null, "Message").isInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), 0.0).isInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be infinity. Actual:<0.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 0.0, "Message").isInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be infinity. Actual:<0.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0).isInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be infinity. Actual:<10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0, "Message").isInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be infinity. Actual:<10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), -10.0).isInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be infinity. Actual:<-10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), -10.0, "Message").isInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be infinity. Actual:<-10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), Double.NaN).isInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be infinity. Actual:<NaN>");
        }
        try {
            initialize(Raw.doubleAssertion(), Double.NaN, "Message").isInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be infinity. Actual:<NaN>");
        }
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void isNaNTest() {
        initialize(Raw.doubleAssertion(), Double.NaN).isNaN();
        initialize(Raw.doubleAssertion(), 0.0 / 0.0).isNaN();
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
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), null, "Message").isNaN();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), 0.0).isNaN();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be NaN. Actual:<0.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 0.0, "Message").isNaN();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be NaN. Actual:<0.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0).isNaN();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be NaN. Actual:<10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0, "Message").isNaN();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be NaN. Actual:<10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), -10.0).isNaN();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be NaN. Actual:<-10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), -10.0, "Message").isNaN();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be NaN. Actual:<-10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), Double.POSITIVE_INFINITY).isNaN();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be NaN. Actual:<Infinity>");
        }
        try {
            initialize(Raw.doubleAssertion(), Double.POSITIVE_INFINITY, "Message").isNaN();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be NaN. Actual:<Infinity>");
        }
        try {
            initialize(Raw.doubleAssertion(), Double.NEGATIVE_INFINITY).isNaN();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be NaN. Actual:<-Infinity>");
        }
        try {
            initialize(Raw.doubleAssertion(), Double.NEGATIVE_INFINITY, "Message").isNaN();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be NaN. Actual:<-Infinity>");
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
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), null, "Message").isNotNaN();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), Double.NaN).isNotNaN();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be NaN.");
        }
        try {
            initialize(Raw.doubleAssertion(), Double.NaN, "Message").isNotNaN();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be NaN.");
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
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), null, "Message").isFinite();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), Double.NaN).isFinite();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be finite. Actual:<NaN>");
        }
        try {
            initialize(Raw.doubleAssertion(), Double.NaN, "Message").isFinite();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be finite. Actual:<NaN>");
        }
        try {
            initialize(Raw.doubleAssertion(), Double.POSITIVE_INFINITY).isFinite();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be finite. Actual:<Infinity>");
        }
        try {
            initialize(Raw.doubleAssertion(), Double.POSITIVE_INFINITY, "Message").isFinite();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be finite. Actual:<Infinity>");
        }
        try {
            initialize(Raw.doubleAssertion(), Double.NEGATIVE_INFINITY).isFinite();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be finite. Actual:<-Infinity>");
        }
        try {
            initialize(Raw.doubleAssertion(), Double.NEGATIVE_INFINITY, "Message").isFinite();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be finite. Actual:<-Infinity>");
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
            Assertions.assertThat(ex).hasMessage("Value should be null. Actual:<10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0, "Message").isNull();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be null. Actual:<10.0>");
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
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<10000.0> but was:<10000.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), value, "Message").isSameAs(10000.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<10000.0> but was:<10000.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), value).isSameAs("test");
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<test> but was:<10000.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), value, "Message").isSameAs("test");
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<test> but was:<10000.0>");
        }
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        Double value = 10000.0;
        initialize(Raw.doubleAssertion(), value).isNotSameAs(10000.0);
        initialize(Raw.doubleAssertion(), value).isNotSameAs("test");

        try {
            initialize(Raw.doubleAssertion(), value).isNotSameAs(value);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<10000.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be different. Actual:<10000.0>");
        }
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void asStringTest() {
        try {
            Assertions.assertThat(initialize(Raw.doubleAssertion(), 10.0).asString(null));
            Assertions.fail("DoubleAssertion test fail");
        } catch (NullPointerException ex) {
            Assertions.assertThat(ex).isNotNull();
        }
        Assertions.assertThat(initialize(Raw.doubleAssertion(), 10.0).asString(5.0)).isEqualTo("5.0");
        Assertions.assertThat(initialize(Raw.doubleAssertion(), 10.0).asString(60.0)).isEqualTo("60.0");
        Assertions.assertThat(initialize(Raw.doubleAssertion(), 10.0).asString(244.0)).isEqualTo("244.0");
        Assertions.assertThat(initialize(Raw.doubleAssertion(), 10.0).asString("test")).isEqualTo("test");
    }

}
