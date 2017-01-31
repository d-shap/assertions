///////////////////////////////////////////////////////////////////////////////////////////////////
// Assertions framework provides facilities for unit testing.
// Copyright (C) 2017 Dmitry Shapovalov.
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
 * Tests for {@link FloatAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class FloatAssertionTest {

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
    public void isEqualToTest() {
        new FloatAssertion(10.0f, null).isEqualTo(10.0f, 0.01f);
        new FloatAssertion(10.0f, null).isEqualTo(9.999f, 0.01f);
        new FloatAssertion(10.0f, null).isEqualTo(10.001f, 0.01f);
        new FloatAssertion(0.0f, null).isEqualTo(0.0f, 0.01f);
        new FloatAssertion(Float.MAX_VALUE, null).isEqualTo(Float.MAX_VALUE, 0.01f);
        new FloatAssertion(-0.0f, null).isEqualTo(+0.0f, 0.0f);
        new FloatAssertion(+0.0f, null).isEqualTo(-0.0f, 0.0f);

        try {
            new FloatAssertion(10.0f, null).isEqualTo(10.01f, 0.001f);
            Assertions.fail("Float assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<10.01> but was:<10.0>");
        }
        try {
            new FloatAssertion(10.0f, null).isEqualTo(9.99f, 0.001f);
            Assertions.fail("Float assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<9.99> but was:<10.0>");
        }
        try {
            new FloatAssertion(10.0f, null).isEqualTo(20.0f, 0.0f);
            Assertions.fail("Float assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<20.0> but was:<10.0>");
        }
    }

    /**
     * {@link FloatAssertion} class test.
     */
    @Test
    public void isNotEqualToTest() {
        new FloatAssertion(10.0f, null).isNotEqualTo(10.01f, 0.001f);
        new FloatAssertion(10.0f, null).isNotEqualTo(9.99f, 0.001f);
        new FloatAssertion(10.0f, null).isNotEqualTo(20.0f, 0.0f);

        try {
            new FloatAssertion(10.0f, null).isNotEqualTo(10.001f, 0.01f);
            Assertions.fail("Float assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<10.0>");
        }
        try {
            new FloatAssertion(10.0f, null).isNotEqualTo(9.999f, 0.01f);
            Assertions.fail("Float assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<10.0>");
        }
        try {
            new FloatAssertion(10.0f, null).isNotEqualTo(10.0f, 0.01f);
            Assertions.fail("Float assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<10.0>");
        }
        try {
            new FloatAssertion(+0.0f, null).isNotEqualTo(-0.0f, 0.0f);
            Assertions.fail("Float assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<0.0>");
        }
        try {
            new FloatAssertion(-0.0f, null).isNotEqualTo(+0.0f, 0.0f);
            Assertions.fail("Float assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<-0.0>");
        }
    }

    /**
     * {@link FloatAssertion} class test.
     */
    @Test
    public void isGreaterThanTest() {
        new FloatAssertion(10.0f, null).isGreaterThan(9.0f);
        new FloatAssertion(10.0f, null).isGreaterThan(8.0f);
        new FloatAssertion(10.0f, null).isGreaterThan(-1.0f);

        try {
            new FloatAssertion(10.0f, null).isGreaterThan(10.0f);
            Assertions.fail("Float assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then the expected. Expected:<10.0> but was:<10.0>");
        }
        try {
            new FloatAssertion(10.0f, null).isGreaterThan(11.0f);
            Assertions.fail("Float assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then the expected. Expected:<11.0> but was:<10.0>");
        }
    }

    /**
     * {@link FloatAssertion} class test.
     */
    @Test
    public void isGreaterThanOrEqualToTest() {
        new FloatAssertion(10.0f, null).isGreaterThanOrEqualTo(9.0f);
        new FloatAssertion(10.0f, null).isGreaterThanOrEqualTo(10.0f);
        new FloatAssertion(10.0f, null).isGreaterThanOrEqualTo(-1.0f);

        try {
            new FloatAssertion(10.0f, null).isGreaterThanOrEqualTo(11.0f);
            Assertions.fail("Float assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then or equal to the expected. Expected:<11.0> but was:<10.0>");
        }
    }

    /**
     * {@link FloatAssertion} class test.
     */
    @Test
    public void isLessThanTest() {
        new FloatAssertion(10.0f, null).isLessThan(11.0f);
        new FloatAssertion(10.0f, null).isLessThan(12.0f);
        new FloatAssertion(10.0f, null).isLessThan(100.0f);

        try {
            new FloatAssertion(10.0f, null).isLessThan(10.0f);
            Assertions.fail("Float assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then the expected. Expected:<10.0> but was:<10.0>");
        }
        try {
            new FloatAssertion(10.0f, null).isLessThan(9.0f);
            Assertions.fail("Float assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then the expected. Expected:<9.0> but was:<10.0>");
        }
    }

    /**
     * {@link FloatAssertion} class test.
     */
    @Test
    public void isLessThanOrEqualToTest() {
        new FloatAssertion(10.0f, null).isLessThanOrEqualTo(11.0f);
        new FloatAssertion(10.0f, null).isLessThanOrEqualTo(10.0f);
        new FloatAssertion(10.0f, null).isLessThanOrEqualTo(100.0f);

        try {
            new FloatAssertion(10.0f, null).isLessThanOrEqualTo(9.0f);
            Assertions.fail("Float assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then or equal to the expected. Expected:<9.0> but was:<10.0>");
        }
    }

    /**
     * {@link FloatAssertion} class test.
     */
    @Test
    public void isInRangeTest() {
        new FloatAssertion(5.0f, null).isInRange(4.0f, 6.0f);
        new FloatAssertion(5.0f, null).isInRange(5.0f, 6.0f);
        new FloatAssertion(5.0f, null).isInRange(1.0f, 10.0f);

        try {
            new FloatAssertion(5.0f, null).isInRange(1.0f, 5.0f);
            Assertions.fail("Float assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<1.0:5.0> but was:<5.0>");
        }
        try {
            new FloatAssertion(5.0f, null).isInRange(6.0f, 10.0f);
            Assertions.fail("Float assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<6.0:10.0> but was:<5.0>");
        }
        try {
            new FloatAssertion(5.0f, null).isInRange(8.0f, 9.0f);
            Assertions.fail("Float assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<8.0:9.0> but was:<5.0>");
        }
    }

    /**
     * {@link FloatAssertion} class test.
     */
    @Test
    public void isNotInRangeTest() {
        new FloatAssertion(5.0f, null).isNotInRange(1.0f, 5.0f);
        new FloatAssertion(5.0f, null).isNotInRange(6.0f, 10.0f);
        new FloatAssertion(5.0f, null).isNotInRange(8.0f, 9.0f);

        try {
            new FloatAssertion(5.0f, null).isNotInRange(4.0f, 6.0f);
            Assertions.fail("Float assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<4.0:6.0> but was:<5.0>");
        }
        try {
            new FloatAssertion(5.0f, null).isNotInRange(5.0f, 6.0f);
            Assertions.fail("Float assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<5.0:6.0> but was:<5.0>");
        }
        try {
            new FloatAssertion(5.0f, null).isNotInRange(1.0f, 10.0f);
            Assertions.fail("Float assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<1.0:10.0> but was:<5.0>");
        }
    }

    /**
     * {@link FloatAssertion} class test.
     */
    @Test
    public void isZeroTest() {
        new FloatAssertion(0.0f, null).isZero();
        new FloatAssertion(+0.0f, null).isZero();
        new FloatAssertion(-0.0f, null).isZero();

        try {
            new FloatAssertion(10.0f, null).isZero();
            Assertions.fail("Float assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be zero. Actual:<10.0>");
        }
    }

    /**
     * {@link FloatAssertion} class test.
     */
    @Test
    public void isNonZeroTest() {
        new FloatAssertion(10.0f, null).isNonZero();
        new FloatAssertion(-10.0f, null).isNonZero();
        new FloatAssertion(Float.POSITIVE_INFINITY, null).isNonZero();
        new FloatAssertion(Float.NEGATIVE_INFINITY, null).isNonZero();
        new FloatAssertion(Float.NaN, null).isNonZero();

        try {
            new FloatAssertion(0.0f, null).isNonZero();
            Assertions.fail("Float assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be zero.");
        }
        try {
            new FloatAssertion(+0.0f, null).isNonZero();
            Assertions.fail("Float assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be zero.");
        }
        try {
            new FloatAssertion(-0.0f, null).isNonZero();
            Assertions.fail("Float assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be zero.");
        }
    }

    /**
     * {@link FloatAssertion} class test.
     */
    @Test
    public void isPositiveInfinityTest() {
        new FloatAssertion(Float.POSITIVE_INFINITY, null).isPositiveInfinity();
        float val = 0.0f;
        new FloatAssertion(1.0f / val, null).isPositiveInfinity();

        try {
            new FloatAssertion(0.0f, null).isPositiveInfinity();
            Assertions.fail("Float assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be positive infinity. Actual:<0.0>");
        }
        try {
            new FloatAssertion(10.0f, null).isPositiveInfinity();
            Assertions.fail("Float assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be positive infinity. Actual:<10.0>");
        }
        try {
            new FloatAssertion(Float.NaN, null).isPositiveInfinity();
            Assertions.fail("Float assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be positive infinity. Actual:<NaN>");
        }
        try {
            new FloatAssertion(Float.NEGATIVE_INFINITY, null).isPositiveInfinity();
            Assertions.fail("Float assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be positive infinity. Actual:<-Infinity>");
        }
    }

    /**
     * {@link FloatAssertion} class test.
     */
    @Test
    public void isNegativeInfinityTest() {
        new FloatAssertion(Float.NEGATIVE_INFINITY, null).isNegativeInfinity();
        float val = 0.0f;
        new FloatAssertion(-1.0f / val, null).isNegativeInfinity();

        try {
            new FloatAssertion(0.0f, null).isNegativeInfinity();
            Assertions.fail("Float assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be negative infinity. Actual:<0.0>");
        }
        try {
            new FloatAssertion(-10.0f, null).isNegativeInfinity();
            Assertions.fail("Float assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be negative infinity. Actual:<-10.0>");
        }
        try {
            new FloatAssertion(Float.NaN, null).isNegativeInfinity();
            Assertions.fail("Float assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be negative infinity. Actual:<NaN>");
        }
        try {
            new FloatAssertion(Float.POSITIVE_INFINITY, null).isNegativeInfinity();
            Assertions.fail("Float assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be negative infinity. Actual:<Infinity>");
        }
    }

    /**
     * {@link FloatAssertion} class test.
     */
    @Test
    public void isInfinityTest() {
        new FloatAssertion(Float.POSITIVE_INFINITY, null).isInfinity();
        new FloatAssertion(Float.NEGATIVE_INFINITY, null).isInfinity();
        float val = 0.0f;
        new FloatAssertion(1.0f / val, null).isInfinity();
        new FloatAssertion(-1.0f / val, null).isInfinity();

        try {
            new FloatAssertion(0.0f, null).isInfinity();
            Assertions.fail("Float assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be infinity. Actual:<0.0>");
        }
        try {
            new FloatAssertion(10.0f, null).isInfinity();
            Assertions.fail("Float assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be infinity. Actual:<10.0>");
        }
        try {
            new FloatAssertion(-10.0f, null).isInfinity();
            Assertions.fail("Float assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be infinity. Actual:<-10.0>");
        }
        try {
            new FloatAssertion(Float.NaN, null).isInfinity();
            Assertions.fail("Float assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be infinity. Actual:<NaN>");
        }
    }

    /**
     * {@link FloatAssertion} class test.
     */
    @Test
    public void isNaNTest() {
        new FloatAssertion(Float.NaN, null).isNaN();
        new FloatAssertion(0.0f / 0.0f, null).isNaN();
        new FloatAssertion(Float.POSITIVE_INFINITY / Float.NEGATIVE_INFINITY, null).isNaN();

        try {
            new FloatAssertion(0.0f, null).isNaN();
            Assertions.fail("Float assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be NaN. Actual:<0.0>");
        }
        try {
            new FloatAssertion(10.0f, null).isNaN();
            Assertions.fail("Float assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be NaN. Actual:<10.0>");
        }
        try {
            new FloatAssertion(-10.0f, null).isNaN();
            Assertions.fail("Float assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be NaN. Actual:<-10.0>");
        }
        try {
            new FloatAssertion(Float.POSITIVE_INFINITY, null).isNaN();
            Assertions.fail("Float assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be NaN. Actual:<Infinity>");
        }
        try {
            new FloatAssertion(Float.NEGATIVE_INFINITY, null).isNaN();
            Assertions.fail("Float assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be NaN. Actual:<-Infinity>");
        }
    }

    /**
     * {@link FloatAssertion} class test.
     */
    @Test
    public void isNotNaNTest() {
        new FloatAssertion(0.0f, null).isNotNaN();
        new FloatAssertion(10.0f, null).isNotNaN();
        new FloatAssertion(-10.0f, null).isNotNaN();
        new FloatAssertion(Float.POSITIVE_INFINITY, null).isNotNaN();
        new FloatAssertion(Float.NEGATIVE_INFINITY, null).isNotNaN();

        try {
            new FloatAssertion(Float.NaN, null).isNotNaN();
            Assertions.fail("Float assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be NaN.");
        }
    }

    /**
     * {@link FloatAssertion} class test.
     */
    @Test
    public void isFiniteTest() {
        new FloatAssertion(0.0f, null).isFinite();
        new FloatAssertion(10.0f, null).isFinite();
        new FloatAssertion(-10.0f, null).isFinite();

        try {
            new FloatAssertion(Float.NaN, null).isFinite();
            Assertions.fail("Float assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be finite. Actual:<NaN>");
        }
        try {
            new FloatAssertion(Float.POSITIVE_INFINITY, null).isFinite();
            Assertions.fail("Float assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be finite. Actual:<Infinity>");
        }
        try {
            new FloatAssertion(Float.NEGATIVE_INFINITY, null).isFinite();
            Assertions.fail("Float assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be finite. Actual:<-Infinity>");
        }
    }

    /**
     * {@link FloatAssertion} class test.
     */
    @Test
    public void asStringTest() {
        Assertions.assertThat(new FloatAssertion(10.0f, null).asString(null)).isNull();
        Assertions.assertThat(new FloatAssertion(10.0f, null).asString(5.0f)).isEqualTo("5.0");
        Assertions.assertThat(new FloatAssertion(10.0f, null).asString(60.0f)).isEqualTo("60.0");
        Assertions.assertThat(new FloatAssertion(10.0f, null).asString(244.0f)).isEqualTo("244.0");
        Assertions.assertThat(new FloatAssertion(10.0f, null).asString("test")).isEqualTo("test");
    }

}
