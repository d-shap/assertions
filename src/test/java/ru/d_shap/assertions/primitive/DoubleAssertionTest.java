///////////////////////////////////////////////////////////////////////////////////////////////////
// Assertions framework provides facilities for unit testing.
// Copyright (C) 2016 Dmitry Shapovalov.
//
// This file is part of Assertions framework.
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
        new DoubleAssertion(10.0, null).isEqualTo(10.0, 0.01);
        new DoubleAssertion(10.0, null).isEqualTo(9.999, 0.01);
        new DoubleAssertion(10.0, null).isEqualTo(10.001, 0.01);
        new DoubleAssertion(0.0, null).isEqualTo(0.0, 0.01);
        new DoubleAssertion(Double.MAX_VALUE, null).isEqualTo(Double.MAX_VALUE, 0.01);
        new DoubleAssertion(-0.0, null).isEqualTo(+0.0, 0.0);
        new DoubleAssertion(+0.0, null).isEqualTo(-0.0, 0.0);

        try {
            new DoubleAssertion(10.0, null).isEqualTo(10.01, 0.001);
            Assertions.fail("Double assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<10.01> but was:<10.0>");
        }
        try {
            new DoubleAssertion(10.0, null).isEqualTo(9.99, 0.001);
            Assertions.fail("Double assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<9.99> but was:<10.0>");
        }
        try {
            new DoubleAssertion(10.0, null).isEqualTo(20.0, 0.0);
            Assertions.fail("Double assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<20.0> but was:<10.0>");
        }
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void isNotEqualToTest() {
        new DoubleAssertion(10.0, null).isNotEqualTo(10.01, 0.001);
        new DoubleAssertion(10.0, null).isNotEqualTo(9.99, 0.001);
        new DoubleAssertion(10.0, null).isNotEqualTo(20.0, 0.0);

        try {
            new DoubleAssertion(10.0, null).isNotEqualTo(10.001, 0.01);
            Assertions.fail("Double assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<10.0>");
        }
        try {
            new DoubleAssertion(10.0, null).isNotEqualTo(9.999, 0.01);
            Assertions.fail("Double assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<10.0>");
        }
        try {
            new DoubleAssertion(10.0, null).isNotEqualTo(10.0, 0.01);
            Assertions.fail("Double assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<10.0>");
        }
        try {
            new DoubleAssertion(+0.0, null).isNotEqualTo(-0.0, 0.0);
            Assertions.fail("Double assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<0.0>");
        }
        try {
            new DoubleAssertion(-0.0, null).isNotEqualTo(+0.0, 0.0);
            Assertions.fail("Double assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<-0.0>");
        }
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void isGreaterThanTest() {
        new DoubleAssertion(10.0, null).isGreaterThan(9.0);
        new DoubleAssertion(10.0, null).isGreaterThan(8.0);
        new DoubleAssertion(10.0, null).isGreaterThan(-1.0);

        try {
            new DoubleAssertion(10.0, null).isGreaterThan(10.0);
            Assertions.fail("Double assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then the expected. Expected:<10.0> but was:<10.0>");
        }
        try {
            new DoubleAssertion(10.0, null).isGreaterThan(11.0);
            Assertions.fail("Double assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then the expected. Expected:<11.0> but was:<10.0>");
        }
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void isGreaterThanOrEqualToTest() {
        new DoubleAssertion(10.0, null).isGreaterThanOrEqualTo(9.0);
        new DoubleAssertion(10.0, null).isGreaterThanOrEqualTo(10.0);
        new DoubleAssertion(10.0, null).isGreaterThanOrEqualTo(-1.0);

        try {
            new DoubleAssertion(10.0, null).isGreaterThanOrEqualTo(11.0);
            Assertions.fail("Double assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then or equal to the expected. Expected:<11.0> but was:<10.0>");
        }
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void isLessThanTest() {
        new DoubleAssertion(10.0, null).isLessThan(11.0);
        new DoubleAssertion(10.0, null).isLessThan(12.0);
        new DoubleAssertion(10.0, null).isLessThan(100.0);

        try {
            new DoubleAssertion(10.0, null).isLessThan(10.0);
            Assertions.fail("Double assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then the expected. Expected:<10.0> but was:<10.0>");
        }
        try {
            new DoubleAssertion(10.0, null).isLessThan(9.0);
            Assertions.fail("Double assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then the expected. Expected:<9.0> but was:<10.0>");
        }
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void isLessThanOrEqualToTest() {
        new DoubleAssertion(10.0, null).isLessThanOrEqualTo(11.0);
        new DoubleAssertion(10.0, null).isLessThanOrEqualTo(10.0);
        new DoubleAssertion(10.0, null).isLessThanOrEqualTo(100.0);

        try {
            new DoubleAssertion(10.0, null).isLessThanOrEqualTo(9.0);
            Assertions.fail("Double assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then or equal to the expected. Expected:<9.0> but was:<10.0>");
        }
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void isZeroTest() {
        new DoubleAssertion(0.0, null).isZero();
        new DoubleAssertion(+0.0, null).isZero();
        new DoubleAssertion(-0.0, null).isZero();

        try {
            new DoubleAssertion(10.0, null).isZero();
            Assertions.fail("Double assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be zero. Actual:<10.0>");
        }
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void isNonZeroTest() {
        new DoubleAssertion(10.0, null).isNonZero();
        new DoubleAssertion(-10.0, null).isNonZero();
        new DoubleAssertion(Double.POSITIVE_INFINITY, null).isNonZero();
        new DoubleAssertion(Double.NEGATIVE_INFINITY, null).isNonZero();
        new DoubleAssertion(Double.NaN, null).isNonZero();

        try {
            new DoubleAssertion(0.0, null).isNonZero();
            Assertions.fail("Double assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be zero.");
        }
        try {
            new DoubleAssertion(+0.0, null).isNonZero();
            Assertions.fail("Double assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be zero.");
        }
        try {
            new DoubleAssertion(-0.0, null).isNonZero();
            Assertions.fail("Double assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be zero.");
        }
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void isPositiveInfinityTest() {
        new DoubleAssertion(Double.POSITIVE_INFINITY, null).isPositiveInfinity();
        double val = 0.0;
        new DoubleAssertion(1.0 / val, null).isPositiveInfinity();

        try {
            new DoubleAssertion(0.0, null).isPositiveInfinity();
            Assertions.fail("Double assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be positive infinity. Actual:<0.0>");
        }
        try {
            new DoubleAssertion(10.0, null).isPositiveInfinity();
            Assertions.fail("Double assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be positive infinity. Actual:<10.0>");
        }
        try {
            new DoubleAssertion(Double.NaN, null).isPositiveInfinity();
            Assertions.fail("Double assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be positive infinity. Actual:<NaN>");
        }
        try {
            new DoubleAssertion(Double.NEGATIVE_INFINITY, null).isPositiveInfinity();
            Assertions.fail("Double assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be positive infinity. Actual:<-Infinity>");
        }
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void isNegativeInfinityTest() {
        new DoubleAssertion(Double.NEGATIVE_INFINITY, null).isNegativeInfinity();
        double val = 0.0;
        new DoubleAssertion(-1.0 / val, null).isNegativeInfinity();

        try {
            new DoubleAssertion(0.0, null).isNegativeInfinity();
            Assertions.fail("Double assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be negative infinity. Actual:<0.0>");
        }
        try {
            new DoubleAssertion(-10.0, null).isNegativeInfinity();
            Assertions.fail("Double assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be negative infinity. Actual:<-10.0>");
        }
        try {
            new DoubleAssertion(Double.NaN, null).isNegativeInfinity();
            Assertions.fail("Double assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be negative infinity. Actual:<NaN>");
        }
        try {
            new DoubleAssertion(Double.POSITIVE_INFINITY, null).isNegativeInfinity();
            Assertions.fail("Double assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be negative infinity. Actual:<Infinity>");
        }
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void isInfinityTest() {
        new DoubleAssertion(Double.POSITIVE_INFINITY, null).isInfinity();
        new DoubleAssertion(Double.NEGATIVE_INFINITY, null).isInfinity();
        double val = 0.0;
        new DoubleAssertion(1.0 / val, null).isInfinity();
        new DoubleAssertion(-1.0 / val, null).isInfinity();

        try {
            new DoubleAssertion(0.0, null).isInfinity();
            Assertions.fail("Double assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be infinity. Actual:<0.0>");
        }
        try {
            new DoubleAssertion(10.0, null).isInfinity();
            Assertions.fail("Double assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be infinity. Actual:<10.0>");
        }
        try {
            new DoubleAssertion(-10.0, null).isInfinity();
            Assertions.fail("Double assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be infinity. Actual:<-10.0>");
        }
        try {
            new DoubleAssertion(Double.NaN, null).isInfinity();
            Assertions.fail("Double assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be infinity. Actual:<NaN>");
        }
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void isNaNTest() {
        new DoubleAssertion(Double.NaN, null).isNaN();
        new DoubleAssertion(0.0 / 0.0, null).isNaN();
        new DoubleAssertion(Double.POSITIVE_INFINITY / Double.NEGATIVE_INFINITY, null).isNaN();

        try {
            new DoubleAssertion(0.0, null).isNaN();
            Assertions.fail("Double assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be NaN. Actual:<0.0>");
        }
        try {
            new DoubleAssertion(10.0, null).isNaN();
            Assertions.fail("Double assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be NaN. Actual:<10.0>");
        }
        try {
            new DoubleAssertion(-10.0, null).isNaN();
            Assertions.fail("Double assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be NaN. Actual:<-10.0>");
        }
        try {
            new DoubleAssertion(Double.POSITIVE_INFINITY, null).isNaN();
            Assertions.fail("Double assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be NaN. Actual:<Infinity>");
        }
        try {
            new DoubleAssertion(Double.NEGATIVE_INFINITY, null).isNaN();
            Assertions.fail("Double assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be NaN. Actual:<-Infinity>");
        }
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void isNotNaNTest() {
        new DoubleAssertion(0.0, null).isNotNaN();
        new DoubleAssertion(10.0, null).isNotNaN();
        new DoubleAssertion(-10.0, null).isNotNaN();
        new DoubleAssertion(Double.POSITIVE_INFINITY, null).isNotNaN();
        new DoubleAssertion(Double.NEGATIVE_INFINITY, null).isNotNaN();

        try {
            new DoubleAssertion(Double.NaN, null).isNotNaN();
            Assertions.fail("Double assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be NaN.");
        }
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void isFiniteTest() {
        new DoubleAssertion(0.0, null).isFinite();
        new DoubleAssertion(10.0, null).isFinite();
        new DoubleAssertion(-10.0, null).isFinite();

        try {
            new DoubleAssertion(Double.NaN, null).isFinite();
            Assertions.fail("Double assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be finite. Actual:<NaN>");
        }
        try {
            new DoubleAssertion(Double.POSITIVE_INFINITY, null).isFinite();
            Assertions.fail("Double assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be finite. Actual:<Infinity>");
        }
        try {
            new DoubleAssertion(Double.NEGATIVE_INFINITY, null).isFinite();
            Assertions.fail("Double assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be finite. Actual:<-Infinity>");
        }
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void asStringTest() {
        Assertions.assertThat(new DoubleAssertion(10.0, null).asString(5.0)).isEqualTo("5.0");
        Assertions.assertThat(new DoubleAssertion(10.0, null).asString(60.0)).isEqualTo("60.0");
        Assertions.assertThat(new DoubleAssertion(10.0, null).asString(244.0)).isEqualTo("244.0");
    }

}
