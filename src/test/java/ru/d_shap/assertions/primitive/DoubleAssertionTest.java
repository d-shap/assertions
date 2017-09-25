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

import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.FailDescription;

/**
 * Tests for {@link DoubleAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class DoubleAssertionTest {

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
    public void isEqualToTest() {
        new DoubleAssertion(10.0, new FailDescription()).isEqualTo(10.0, 0.01);
        new DoubleAssertion(10.0, new FailDescription()).isEqualTo(9.999, 0.01);
        new DoubleAssertion(10.0, new FailDescription()).isEqualTo(10.001, 0.01);
        new DoubleAssertion(0.0, new FailDescription()).isEqualTo(0.0, 0.01);
        new DoubleAssertion(Double.MAX_VALUE, new FailDescription()).isEqualTo(Double.MAX_VALUE, 0.01);
        new DoubleAssertion(-0.0, new FailDescription()).isEqualTo(+0.0, 0.0);
        new DoubleAssertion(+0.0, new FailDescription()).isEqualTo(-0.0, 0.0);

        try {
            new DoubleAssertion(10.0, new FailDescription()).isEqualTo(10.01, 0.001);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<10.01> but was:<10.0>.");
        }
        try {
            new DoubleAssertion(10.0, new FailDescription().addMessage("Message")).isEqualTo(10.01, 0.001);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<10.01> but was:<10.0>.");
        }
        try {
            new DoubleAssertion(10.0, new FailDescription()).isEqualTo(9.99, 0.001);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<9.99> but was:<10.0>.");
        }
        try {
            new DoubleAssertion(10.0, new FailDescription().addMessage("Message")).isEqualTo(9.99, 0.001);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<9.99> but was:<10.0>.");
        }
        try {
            new DoubleAssertion(10.0, new FailDescription()).isEqualTo(20.0, 0.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<20.0> but was:<10.0>.");
        }
        try {
            new DoubleAssertion(10.0, new FailDescription().addMessage("Message")).isEqualTo(20.0, 0.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<20.0> but was:<10.0>.");
        }
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void isNotEqualToTest() {
        new DoubleAssertion(10.0, new FailDescription()).isNotEqualTo(10.01, 0.001);
        new DoubleAssertion(10.0, new FailDescription()).isNotEqualTo(9.99, 0.001);
        new DoubleAssertion(10.0, new FailDescription()).isNotEqualTo(20.0, 0.0);

        try {
            new DoubleAssertion(10.0, new FailDescription()).isNotEqualTo(10.001, 0.01);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<10.0>.");
        }
        try {
            new DoubleAssertion(10.0, new FailDescription().addMessage("Message")).isNotEqualTo(10.001, 0.01);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be different. Actual:<10.0>.");
        }
        try {
            new DoubleAssertion(10.0, new FailDescription()).isNotEqualTo(9.999, 0.01);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<10.0>.");
        }
        try {
            new DoubleAssertion(10.0, new FailDescription().addMessage("Message")).isNotEqualTo(9.999, 0.01);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be different. Actual:<10.0>.");
        }
        try {
            new DoubleAssertion(10.0, new FailDescription()).isNotEqualTo(10.0, 0.01);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<10.0>.");
        }
        try {
            new DoubleAssertion(10.0, new FailDescription().addMessage("Message")).isNotEqualTo(10.0, 0.01);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be different. Actual:<10.0>.");
        }
        try {
            new DoubleAssertion(+0.0, new FailDescription()).isNotEqualTo(-0.0, 0.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<0.0>.");
        }
        try {
            new DoubleAssertion(+0.0, new FailDescription().addMessage("Message")).isNotEqualTo(-0.0, 0.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be different. Actual:<0.0>.");
        }
        try {
            new DoubleAssertion(-0.0, new FailDescription()).isNotEqualTo(+0.0, 0.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<-0.0>.");
        }
        try {
            new DoubleAssertion(-0.0, new FailDescription().addMessage("Message")).isNotEqualTo(+0.0, 0.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be different. Actual:<-0.0>.");
        }
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void isGreaterThanTest() {
        new DoubleAssertion(10.0, new FailDescription()).isGreaterThan(9.0);
        new DoubleAssertion(10.0, new FailDescription()).isGreaterThan(8.0);
        new DoubleAssertion(10.0, new FailDescription()).isGreaterThan(-1.0);

        try {
            new DoubleAssertion(10.0, new FailDescription()).isGreaterThan(10.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then the expected. Expected:<10.0> but was:<10.0>.");
        }
        try {
            new DoubleAssertion(10.0, new FailDescription().addMessage("Message")).isGreaterThan(10.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be greater then the expected. Expected:<10.0> but was:<10.0>.");
        }
        try {
            new DoubleAssertion(10.0, new FailDescription()).isGreaterThan(11.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then the expected. Expected:<11.0> but was:<10.0>.");
        }
        try {
            new DoubleAssertion(10.0, new FailDescription().addMessage("Message")).isGreaterThan(11.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be greater then the expected. Expected:<11.0> but was:<10.0>.");
        }
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void isGreaterThanOrEqualToTest() {
        new DoubleAssertion(10.0, new FailDescription()).isGreaterThanOrEqualTo(9.0);
        new DoubleAssertion(10.0, new FailDescription()).isGreaterThanOrEqualTo(10.0);
        new DoubleAssertion(10.0, new FailDescription()).isGreaterThanOrEqualTo(-1.0);

        try {
            new DoubleAssertion(10.0, new FailDescription()).isGreaterThanOrEqualTo(11.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then or equal to the expected. Expected:<11.0> but was:<10.0>.");
        }
        try {
            new DoubleAssertion(10.0, new FailDescription().addMessage("Message")).isGreaterThanOrEqualTo(11.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be greater then or equal to the expected. Expected:<11.0> but was:<10.0>.");
        }
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void isLessThanTest() {
        new DoubleAssertion(10.0, new FailDescription()).isLessThan(11.0);
        new DoubleAssertion(10.0, new FailDescription()).isLessThan(12.0);
        new DoubleAssertion(10.0, new FailDescription()).isLessThan(100.0);

        try {
            new DoubleAssertion(10.0, new FailDescription()).isLessThan(10.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then the expected. Expected:<10.0> but was:<10.0>.");
        }
        try {
            new DoubleAssertion(10.0, new FailDescription().addMessage("Message")).isLessThan(10.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be less then the expected. Expected:<10.0> but was:<10.0>.");
        }
        try {
            new DoubleAssertion(10.0, new FailDescription()).isLessThan(9.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then the expected. Expected:<9.0> but was:<10.0>.");
        }
        try {
            new DoubleAssertion(10.0, new FailDescription().addMessage("Message")).isLessThan(9.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be less then the expected. Expected:<9.0> but was:<10.0>.");
        }
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void isLessThanOrEqualToTest() {
        new DoubleAssertion(10.0, new FailDescription()).isLessThanOrEqualTo(11.0);
        new DoubleAssertion(10.0, new FailDescription()).isLessThanOrEqualTo(10.0);
        new DoubleAssertion(10.0, new FailDescription()).isLessThanOrEqualTo(100.0);

        try {
            new DoubleAssertion(10.0, new FailDescription()).isLessThanOrEqualTo(9.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then or equal to the expected. Expected:<9.0> but was:<10.0>.");
        }
        try {
            new DoubleAssertion(10.0, new FailDescription().addMessage("Message")).isLessThanOrEqualTo(9.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be less then or equal to the expected. Expected:<9.0> but was:<10.0>.");
        }
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void isInRangeTest() {
        new DoubleAssertion(5.0, new FailDescription()).isInRange(4.0, 6.0);
        new DoubleAssertion(5.0, new FailDescription()).isInRange(5.0, 6.0);
        new DoubleAssertion(5.0, new FailDescription()).isInRange(1.0, 10.0);

        try {
            new DoubleAssertion(5.0, new FailDescription()).isInRange(1.0, 5.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<1.0:5.0> but was:<5.0>.");
        }
        try {
            new DoubleAssertion(5.0, new FailDescription().addMessage("Message")).isInRange(1.0, 5.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be in the expected range. Expected:<1.0:5.0> but was:<5.0>.");
        }
        try {
            new DoubleAssertion(5.0, new FailDescription()).isInRange(6.0, 10.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<6.0:10.0> but was:<5.0>.");
        }
        try {
            new DoubleAssertion(5.0, new FailDescription().addMessage("Message")).isInRange(6.0, 10.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be in the expected range. Expected:<6.0:10.0> but was:<5.0>.");
        }
        try {
            new DoubleAssertion(5.0, new FailDescription()).isInRange(8.0, 9.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<8.0:9.0> but was:<5.0>.");
        }
        try {
            new DoubleAssertion(5.0, new FailDescription().addMessage("Message")).isInRange(8.0, 9.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be in the expected range. Expected:<8.0:9.0> but was:<5.0>.");
        }
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void isNotInRangeTest() {
        new DoubleAssertion(5.0, new FailDescription()).isNotInRange(1.0, 5.0);
        new DoubleAssertion(5.0, new FailDescription()).isNotInRange(6.0, 10.0);
        new DoubleAssertion(5.0, new FailDescription()).isNotInRange(8.0, 9.0);

        try {
            new DoubleAssertion(5.0, new FailDescription()).isNotInRange(4.0, 6.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<4.0:6.0> but was:<5.0>.");
        }
        try {
            new DoubleAssertion(5.0, new FailDescription().addMessage("Message")).isNotInRange(4.0, 6.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be in the expected range. Expected:<4.0:6.0> but was:<5.0>.");
        }
        try {
            new DoubleAssertion(5.0, new FailDescription()).isNotInRange(5.0, 6.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<5.0:6.0> but was:<5.0>.");
        }
        try {
            new DoubleAssertion(5.0, new FailDescription().addMessage("Message")).isNotInRange(5.0, 6.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be in the expected range. Expected:<5.0:6.0> but was:<5.0>.");
        }
        try {
            new DoubleAssertion(5.0, new FailDescription()).isNotInRange(1.0, 10.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<1.0:10.0> but was:<5.0>.");
        }
        try {
            new DoubleAssertion(5.0, new FailDescription().addMessage("Message")).isNotInRange(1.0, 10.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be in the expected range. Expected:<1.0:10.0> but was:<5.0>.");
        }
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void isZeroTest() {
        new DoubleAssertion(0.0, new FailDescription()).isZero();
        new DoubleAssertion(+0.0, new FailDescription()).isZero();
        new DoubleAssertion(-0.0, new FailDescription()).isZero();

        try {
            new DoubleAssertion(10.0, new FailDescription()).isZero();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be zero. Actual:<10.0>.");
        }
        try {
            new DoubleAssertion(10.0, new FailDescription().addMessage("Message")).isZero();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be zero. Actual:<10.0>.");
        }
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void isNonZeroTest() {
        new DoubleAssertion(10.0, new FailDescription()).isNonZero();
        new DoubleAssertion(-10.0, new FailDescription()).isNonZero();
        new DoubleAssertion(Double.POSITIVE_INFINITY, new FailDescription()).isNonZero();
        new DoubleAssertion(Double.NEGATIVE_INFINITY, new FailDescription()).isNonZero();
        new DoubleAssertion(Double.NaN, new FailDescription()).isNonZero();

        try {
            new DoubleAssertion(0.0, new FailDescription()).isNonZero();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be zero.");
        }
        try {
            new DoubleAssertion(0.0, new FailDescription().addMessage("Message")).isNonZero();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be zero.");
        }
        try {
            new DoubleAssertion(+0.0, new FailDescription()).isNonZero();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be zero.");
        }
        try {
            new DoubleAssertion(+0.0, new FailDescription().addMessage("Message")).isNonZero();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be zero.");
        }
        try {
            new DoubleAssertion(-0.0, new FailDescription()).isNonZero();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be zero.");
        }
        try {
            new DoubleAssertion(-0.0, new FailDescription().addMessage("Message")).isNonZero();
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
        new DoubleAssertion(Double.POSITIVE_INFINITY, new FailDescription()).isPositiveInfinity();
        double val = 0.0;
        new DoubleAssertion(1.0 / val, new FailDescription()).isPositiveInfinity();

        try {
            new DoubleAssertion(0.0, new FailDescription()).isPositiveInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be positive infinity. Actual:<0.0>.");
        }
        try {
            new DoubleAssertion(0.0, new FailDescription().addMessage("Message")).isPositiveInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be positive infinity. Actual:<0.0>.");
        }
        try {
            new DoubleAssertion(10.0, new FailDescription()).isPositiveInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be positive infinity. Actual:<10.0>.");
        }
        try {
            new DoubleAssertion(10.0, new FailDescription().addMessage("Message")).isPositiveInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be positive infinity. Actual:<10.0>.");
        }
        try {
            new DoubleAssertion(Double.NaN, new FailDescription()).isPositiveInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be positive infinity. Actual:<NaN>.");
        }
        try {
            new DoubleAssertion(Double.NaN, new FailDescription().addMessage("Message")).isPositiveInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be positive infinity. Actual:<NaN>.");
        }
        try {
            new DoubleAssertion(Double.NEGATIVE_INFINITY, new FailDescription()).isPositiveInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be positive infinity. Actual:<-Infinity>.");
        }
        try {
            new DoubleAssertion(Double.NEGATIVE_INFINITY, new FailDescription().addMessage("Message")).isPositiveInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be positive infinity. Actual:<-Infinity>.");
        }
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void isNegativeInfinityTest() {
        new DoubleAssertion(Double.NEGATIVE_INFINITY, new FailDescription()).isNegativeInfinity();
        double val = 0.0;
        new DoubleAssertion(-1.0 / val, new FailDescription()).isNegativeInfinity();

        try {
            new DoubleAssertion(0.0, new FailDescription()).isNegativeInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be negative infinity. Actual:<0.0>.");
        }
        try {
            new DoubleAssertion(0.0, new FailDescription().addMessage("Message")).isNegativeInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be negative infinity. Actual:<0.0>.");
        }
        try {
            new DoubleAssertion(-10.0, new FailDescription()).isNegativeInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be negative infinity. Actual:<-10.0>.");
        }
        try {
            new DoubleAssertion(-10.0, new FailDescription().addMessage("Message")).isNegativeInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be negative infinity. Actual:<-10.0>.");
        }
        try {
            new DoubleAssertion(Double.NaN, new FailDescription()).isNegativeInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be negative infinity. Actual:<NaN>.");
        }
        try {
            new DoubleAssertion(Double.NaN, new FailDescription().addMessage("Message")).isNegativeInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be negative infinity. Actual:<NaN>.");
        }
        try {
            new DoubleAssertion(Double.POSITIVE_INFINITY, new FailDescription()).isNegativeInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be negative infinity. Actual:<Infinity>.");
        }
        try {
            new DoubleAssertion(Double.POSITIVE_INFINITY, new FailDescription().addMessage("Message")).isNegativeInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be negative infinity. Actual:<Infinity>.");
        }
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void isInfinityTest() {
        new DoubleAssertion(Double.POSITIVE_INFINITY, new FailDescription()).isInfinity();
        new DoubleAssertion(Double.NEGATIVE_INFINITY, new FailDescription()).isInfinity();
        double val = 0.0;
        new DoubleAssertion(1.0 / val, new FailDescription()).isInfinity();
        new DoubleAssertion(-1.0 / val, new FailDescription()).isInfinity();

        try {
            new DoubleAssertion(0.0, new FailDescription()).isInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be infinity. Actual:<0.0>.");
        }
        try {
            new DoubleAssertion(0.0, new FailDescription().addMessage("Message")).isInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be infinity. Actual:<0.0>.");
        }
        try {
            new DoubleAssertion(10.0, new FailDescription()).isInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be infinity. Actual:<10.0>.");
        }
        try {
            new DoubleAssertion(10.0, new FailDescription().addMessage("Message")).isInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be infinity. Actual:<10.0>.");
        }
        try {
            new DoubleAssertion(-10.0, new FailDescription()).isInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be infinity. Actual:<-10.0>.");
        }
        try {
            new DoubleAssertion(-10.0, new FailDescription().addMessage("Message")).isInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be infinity. Actual:<-10.0>.");
        }
        try {
            new DoubleAssertion(Double.NaN, new FailDescription()).isInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be infinity. Actual:<NaN>.");
        }
        try {
            new DoubleAssertion(Double.NaN, new FailDescription().addMessage("Message")).isInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be infinity. Actual:<NaN>.");
        }
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void isNaNTest() {
        new DoubleAssertion(Double.NaN, new FailDescription()).isNaN();
        new DoubleAssertion(0.0 / 0.0, new FailDescription()).isNaN();
        new DoubleAssertion(Double.POSITIVE_INFINITY / Double.NEGATIVE_INFINITY, new FailDescription()).isNaN();

        try {
            new DoubleAssertion(0.0, new FailDescription()).isNaN();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be NaN. Actual:<0.0>.");
        }
        try {
            new DoubleAssertion(0.0, new FailDescription().addMessage("Message")).isNaN();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be NaN. Actual:<0.0>.");
        }
        try {
            new DoubleAssertion(10.0, new FailDescription()).isNaN();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be NaN. Actual:<10.0>.");
        }
        try {
            new DoubleAssertion(10.0, new FailDescription().addMessage("Message")).isNaN();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be NaN. Actual:<10.0>.");
        }
        try {
            new DoubleAssertion(-10.0, new FailDescription()).isNaN();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be NaN. Actual:<-10.0>.");
        }
        try {
            new DoubleAssertion(-10.0, new FailDescription().addMessage("Message")).isNaN();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be NaN. Actual:<-10.0>.");
        }
        try {
            new DoubleAssertion(Double.POSITIVE_INFINITY, new FailDescription()).isNaN();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be NaN. Actual:<Infinity>.");
        }
        try {
            new DoubleAssertion(Double.POSITIVE_INFINITY, new FailDescription().addMessage("Message")).isNaN();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be NaN. Actual:<Infinity>.");
        }
        try {
            new DoubleAssertion(Double.NEGATIVE_INFINITY, new FailDescription()).isNaN();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be NaN. Actual:<-Infinity>.");
        }
        try {
            new DoubleAssertion(Double.NEGATIVE_INFINITY, new FailDescription().addMessage("Message")).isNaN();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be NaN. Actual:<-Infinity>.");
        }
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void isNotNaNTest() {
        new DoubleAssertion(0.0, new FailDescription()).isNotNaN();
        new DoubleAssertion(10.0, new FailDescription()).isNotNaN();
        new DoubleAssertion(-10.0, new FailDescription()).isNotNaN();
        new DoubleAssertion(Double.POSITIVE_INFINITY, new FailDescription()).isNotNaN();
        new DoubleAssertion(Double.NEGATIVE_INFINITY, new FailDescription()).isNotNaN();

        try {
            new DoubleAssertion(Double.NaN, new FailDescription()).isNotNaN();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be NaN.");
        }
        try {
            new DoubleAssertion(Double.NaN, new FailDescription().addMessage("Message")).isNotNaN();
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
        new DoubleAssertion(0.0, new FailDescription()).isFinite();
        new DoubleAssertion(10.0, new FailDescription()).isFinite();
        new DoubleAssertion(-10.0, new FailDescription()).isFinite();

        try {
            new DoubleAssertion(Double.NaN, new FailDescription()).isFinite();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be finite. Actual:<NaN>.");
        }
        try {
            new DoubleAssertion(Double.NaN, new FailDescription().addMessage("Message")).isFinite();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be finite. Actual:<NaN>.");
        }
        try {
            new DoubleAssertion(Double.POSITIVE_INFINITY, new FailDescription()).isFinite();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be finite. Actual:<Infinity>.");
        }
        try {
            new DoubleAssertion(Double.POSITIVE_INFINITY, new FailDescription().addMessage("Message")).isFinite();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be finite. Actual:<Infinity>.");
        }
        try {
            new DoubleAssertion(Double.NEGATIVE_INFINITY, new FailDescription()).isFinite();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be finite. Actual:<-Infinity>.");
        }
        try {
            new DoubleAssertion(Double.NEGATIVE_INFINITY, new FailDescription().addMessage("Message")).isFinite();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be finite. Actual:<-Infinity>.");
        }
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void asStringTest() {
        Assertions.assertThat(new DoubleAssertion(10.0, new FailDescription()).asString(null)).isNull();
        Assertions.assertThat(new DoubleAssertion(10.0, new FailDescription()).asString(5.0)).isEqualTo("5.0");
        Assertions.assertThat(new DoubleAssertion(10.0, new FailDescription()).asString(60.0)).isEqualTo("60.0");
        Assertions.assertThat(new DoubleAssertion(10.0, new FailDescription()).asString(244.0)).isEqualTo("244.0");
        Assertions.assertThat(new DoubleAssertion(10.0, new FailDescription()).asString("test")).isEqualTo("test");
    }

}
