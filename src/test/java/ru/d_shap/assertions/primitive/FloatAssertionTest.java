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
        new FloatAssertion(10.0f, new FailDescription()).isEqualTo(10.0f, 0.01f);
        new FloatAssertion(10.0f, new FailDescription()).isEqualTo(9.999f, 0.01f);
        new FloatAssertion(10.0f, new FailDescription()).isEqualTo(10.001f, 0.01f);
        new FloatAssertion(0.0f, new FailDescription()).isEqualTo(0.0f, 0.01f);
        new FloatAssertion(Float.MAX_VALUE, new FailDescription()).isEqualTo(Float.MAX_VALUE, 0.01f);
        new FloatAssertion(-0.0f, new FailDescription()).isEqualTo(+0.0f, 0.0f);
        new FloatAssertion(+0.0f, new FailDescription()).isEqualTo(-0.0f, 0.0f);

        try {
            new FloatAssertion(10.0f, new FailDescription()).isEqualTo(10.01f, 0.001f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<10.01> but was:<10.0>.");
        }
        try {
            new FloatAssertion(10.0f, new FailDescription()).isEqualTo(9.99f, 0.001f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<9.99> but was:<10.0>.");
        }
        try {
            new FloatAssertion(10.0f, new FailDescription()).isEqualTo(20.0f, 0.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<20.0> but was:<10.0>.");
        }
    }

    /**
     * {@link FloatAssertion} class test.
     */
    @Test
    public void isNotEqualToTest() {
        new FloatAssertion(10.0f, new FailDescription()).isNotEqualTo(10.01f, 0.001f);
        new FloatAssertion(10.0f, new FailDescription()).isNotEqualTo(9.99f, 0.001f);
        new FloatAssertion(10.0f, new FailDescription()).isNotEqualTo(20.0f, 0.0f);

        try {
            new FloatAssertion(10.0f, new FailDescription()).isNotEqualTo(10.001f, 0.01f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<10.0>.");
        }
        try {
            new FloatAssertion(10.0f, new FailDescription()).isNotEqualTo(9.999f, 0.01f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<10.0>.");
        }
        try {
            new FloatAssertion(10.0f, new FailDescription()).isNotEqualTo(10.0f, 0.01f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<10.0>.");
        }
        try {
            new FloatAssertion(+0.0f, new FailDescription()).isNotEqualTo(-0.0f, 0.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<0.0>.");
        }
        try {
            new FloatAssertion(-0.0f, new FailDescription()).isNotEqualTo(+0.0f, 0.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<-0.0>.");
        }
    }

    /**
     * {@link FloatAssertion} class test.
     */
    @Test
    public void isGreaterThanTest() {
        new FloatAssertion(10.0f, new FailDescription()).isGreaterThan(9.0f);
        new FloatAssertion(10.0f, new FailDescription()).isGreaterThan(8.0f);
        new FloatAssertion(10.0f, new FailDescription()).isGreaterThan(-1.0f);

        try {
            new FloatAssertion(10.0f, new FailDescription()).isGreaterThan(10.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then the expected. Expected:<10.0> but was:<10.0>.");
        }
        try {
            new FloatAssertion(10.0f, new FailDescription()).isGreaterThan(11.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then the expected. Expected:<11.0> but was:<10.0>.");
        }
    }

    /**
     * {@link FloatAssertion} class test.
     */
    @Test
    public void isGreaterThanOrEqualToTest() {
        new FloatAssertion(10.0f, new FailDescription()).isGreaterThanOrEqualTo(9.0f);
        new FloatAssertion(10.0f, new FailDescription()).isGreaterThanOrEqualTo(10.0f);
        new FloatAssertion(10.0f, new FailDescription()).isGreaterThanOrEqualTo(-1.0f);

        try {
            new FloatAssertion(10.0f, new FailDescription()).isGreaterThanOrEqualTo(11.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then or equal to the expected. Expected:<11.0> but was:<10.0>.");
        }
    }

    /**
     * {@link FloatAssertion} class test.
     */
    @Test
    public void isLessThanTest() {
        new FloatAssertion(10.0f, new FailDescription()).isLessThan(11.0f);
        new FloatAssertion(10.0f, new FailDescription()).isLessThan(12.0f);
        new FloatAssertion(10.0f, new FailDescription()).isLessThan(100.0f);

        try {
            new FloatAssertion(10.0f, new FailDescription()).isLessThan(10.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then the expected. Expected:<10.0> but was:<10.0>.");
        }
        try {
            new FloatAssertion(10.0f, new FailDescription()).isLessThan(9.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then the expected. Expected:<9.0> but was:<10.0>.");
        }
    }

    /**
     * {@link FloatAssertion} class test.
     */
    @Test
    public void isLessThanOrEqualToTest() {
        new FloatAssertion(10.0f, new FailDescription()).isLessThanOrEqualTo(11.0f);
        new FloatAssertion(10.0f, new FailDescription()).isLessThanOrEqualTo(10.0f);
        new FloatAssertion(10.0f, new FailDescription()).isLessThanOrEqualTo(100.0f);

        try {
            new FloatAssertion(10.0f, new FailDescription()).isLessThanOrEqualTo(9.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then or equal to the expected. Expected:<9.0> but was:<10.0>.");
        }
    }

    /**
     * {@link FloatAssertion} class test.
     */
    @Test
    public void isInRangeTest() {
        new FloatAssertion(5.0f, new FailDescription()).isInRange(4.0f, 6.0f);
        new FloatAssertion(5.0f, new FailDescription()).isInRange(5.0f, 6.0f);
        new FloatAssertion(5.0f, new FailDescription()).isInRange(1.0f, 10.0f);

        try {
            new FloatAssertion(5.0f, new FailDescription()).isInRange(1.0f, 5.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<1.0:5.0> but was:<5.0>.");
        }
        try {
            new FloatAssertion(5.0f, new FailDescription()).isInRange(6.0f, 10.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<6.0:10.0> but was:<5.0>.");
        }
        try {
            new FloatAssertion(5.0f, new FailDescription()).isInRange(8.0f, 9.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<8.0:9.0> but was:<5.0>.");
        }
    }

    /**
     * {@link FloatAssertion} class test.
     */
    @Test
    public void isNotInRangeTest() {
        new FloatAssertion(5.0f, new FailDescription()).isNotInRange(1.0f, 5.0f);
        new FloatAssertion(5.0f, new FailDescription()).isNotInRange(6.0f, 10.0f);
        new FloatAssertion(5.0f, new FailDescription()).isNotInRange(8.0f, 9.0f);

        try {
            new FloatAssertion(5.0f, new FailDescription()).isNotInRange(4.0f, 6.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<4.0:6.0> but was:<5.0>.");
        }
        try {
            new FloatAssertion(5.0f, new FailDescription()).isNotInRange(5.0f, 6.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<5.0:6.0> but was:<5.0>.");
        }
        try {
            new FloatAssertion(5.0f, new FailDescription()).isNotInRange(1.0f, 10.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<1.0:10.0> but was:<5.0>.");
        }
    }

    /**
     * {@link FloatAssertion} class test.
     */
    @Test
    public void isZeroTest() {
        new FloatAssertion(0.0f, new FailDescription()).isZero();
        new FloatAssertion(+0.0f, new FailDescription()).isZero();
        new FloatAssertion(-0.0f, new FailDescription()).isZero();

        try {
            new FloatAssertion(10.0f, new FailDescription()).isZero();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be zero. Actual:<10.0>.");
        }
    }

    /**
     * {@link FloatAssertion} class test.
     */
    @Test
    public void isNonZeroTest() {
        new FloatAssertion(10.0f, new FailDescription()).isNonZero();
        new FloatAssertion(-10.0f, new FailDescription()).isNonZero();
        new FloatAssertion(Float.POSITIVE_INFINITY, new FailDescription()).isNonZero();
        new FloatAssertion(Float.NEGATIVE_INFINITY, new FailDescription()).isNonZero();
        new FloatAssertion(Float.NaN, new FailDescription()).isNonZero();

        try {
            new FloatAssertion(0.0f, new FailDescription()).isNonZero();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be zero.");
        }
        try {
            new FloatAssertion(+0.0f, new FailDescription()).isNonZero();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be zero.");
        }
        try {
            new FloatAssertion(-0.0f, new FailDescription()).isNonZero();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be zero.");
        }
    }

    /**
     * {@link FloatAssertion} class test.
     */
    @Test
    public void isPositiveInfinityTest() {
        new FloatAssertion(Float.POSITIVE_INFINITY, new FailDescription()).isPositiveInfinity();
        float val = 0.0f;
        new FloatAssertion(1.0f / val, new FailDescription()).isPositiveInfinity();

        try {
            new FloatAssertion(0.0f, new FailDescription()).isPositiveInfinity();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be positive infinity. Actual:<0.0>.");
        }
        try {
            new FloatAssertion(10.0f, new FailDescription()).isPositiveInfinity();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be positive infinity. Actual:<10.0>.");
        }
        try {
            new FloatAssertion(Float.NaN, new FailDescription()).isPositiveInfinity();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be positive infinity. Actual:<NaN>.");
        }
        try {
            new FloatAssertion(Float.NEGATIVE_INFINITY, new FailDescription()).isPositiveInfinity();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be positive infinity. Actual:<-Infinity>.");
        }
    }

    /**
     * {@link FloatAssertion} class test.
     */
    @Test
    public void isNegativeInfinityTest() {
        new FloatAssertion(Float.NEGATIVE_INFINITY, new FailDescription()).isNegativeInfinity();
        float val = 0.0f;
        new FloatAssertion(-1.0f / val, new FailDescription()).isNegativeInfinity();

        try {
            new FloatAssertion(0.0f, new FailDescription()).isNegativeInfinity();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be negative infinity. Actual:<0.0>.");
        }
        try {
            new FloatAssertion(-10.0f, new FailDescription()).isNegativeInfinity();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be negative infinity. Actual:<-10.0>.");
        }
        try {
            new FloatAssertion(Float.NaN, new FailDescription()).isNegativeInfinity();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be negative infinity. Actual:<NaN>.");
        }
        try {
            new FloatAssertion(Float.POSITIVE_INFINITY, new FailDescription()).isNegativeInfinity();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be negative infinity. Actual:<Infinity>.");
        }
    }

    /**
     * {@link FloatAssertion} class test.
     */
    @Test
    public void isInfinityTest() {
        new FloatAssertion(Float.POSITIVE_INFINITY, new FailDescription()).isInfinity();
        new FloatAssertion(Float.NEGATIVE_INFINITY, new FailDescription()).isInfinity();
        float val = 0.0f;
        new FloatAssertion(1.0f / val, new FailDescription()).isInfinity();
        new FloatAssertion(-1.0f / val, new FailDescription()).isInfinity();

        try {
            new FloatAssertion(0.0f, new FailDescription()).isInfinity();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be infinity. Actual:<0.0>.");
        }
        try {
            new FloatAssertion(10.0f, new FailDescription()).isInfinity();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be infinity. Actual:<10.0>.");
        }
        try {
            new FloatAssertion(-10.0f, new FailDescription()).isInfinity();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be infinity. Actual:<-10.0>.");
        }
        try {
            new FloatAssertion(Float.NaN, new FailDescription()).isInfinity();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be infinity. Actual:<NaN>.");
        }
    }

    /**
     * {@link FloatAssertion} class test.
     */
    @Test
    public void isNaNTest() {
        new FloatAssertion(Float.NaN, new FailDescription()).isNaN();
        new FloatAssertion(0.0f / 0.0f, new FailDescription()).isNaN();
        new FloatAssertion(Float.POSITIVE_INFINITY / Float.NEGATIVE_INFINITY, new FailDescription()).isNaN();

        try {
            new FloatAssertion(0.0f, new FailDescription()).isNaN();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be NaN. Actual:<0.0>.");
        }
        try {
            new FloatAssertion(10.0f, new FailDescription()).isNaN();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be NaN. Actual:<10.0>.");
        }
        try {
            new FloatAssertion(-10.0f, new FailDescription()).isNaN();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be NaN. Actual:<-10.0>.");
        }
        try {
            new FloatAssertion(Float.POSITIVE_INFINITY, new FailDescription()).isNaN();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be NaN. Actual:<Infinity>.");
        }
        try {
            new FloatAssertion(Float.NEGATIVE_INFINITY, new FailDescription()).isNaN();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be NaN. Actual:<-Infinity>.");
        }
    }

    /**
     * {@link FloatAssertion} class test.
     */
    @Test
    public void isNotNaNTest() {
        new FloatAssertion(0.0f, new FailDescription()).isNotNaN();
        new FloatAssertion(10.0f, new FailDescription()).isNotNaN();
        new FloatAssertion(-10.0f, new FailDescription()).isNotNaN();
        new FloatAssertion(Float.POSITIVE_INFINITY, new FailDescription()).isNotNaN();
        new FloatAssertion(Float.NEGATIVE_INFINITY, new FailDescription()).isNotNaN();

        try {
            new FloatAssertion(Float.NaN, new FailDescription()).isNotNaN();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be NaN.");
        }
    }

    /**
     * {@link FloatAssertion} class test.
     */
    @Test
    public void isFiniteTest() {
        new FloatAssertion(0.0f, new FailDescription()).isFinite();
        new FloatAssertion(10.0f, new FailDescription()).isFinite();
        new FloatAssertion(-10.0f, new FailDescription()).isFinite();

        try {
            new FloatAssertion(Float.NaN, new FailDescription()).isFinite();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be finite. Actual:<NaN>.");
        }
        try {
            new FloatAssertion(Float.POSITIVE_INFINITY, new FailDescription()).isFinite();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be finite. Actual:<Infinity>.");
        }
        try {
            new FloatAssertion(Float.NEGATIVE_INFINITY, new FailDescription()).isFinite();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be finite. Actual:<-Infinity>.");
        }
    }

    /**
     * {@link FloatAssertion} class test.
     */
    @Test
    public void asStringTest() {
        Assertions.assertThat(new FloatAssertion(10.0f, new FailDescription()).asString(null)).isEqualTo("null");
        Assertions.assertThat(new FloatAssertion(10.0f, new FailDescription()).asString(5.0f)).isEqualTo("5.0");
        Assertions.assertThat(new FloatAssertion(10.0f, new FailDescription()).asString(60.0f)).isEqualTo("60.0");
        Assertions.assertThat(new FloatAssertion(10.0f, new FailDescription()).asString(244.0f)).isEqualTo("244.0");
        Assertions.assertThat(new FloatAssertion(10.0f, new FailDescription()).asString("test")).isEqualTo("test");
    }

}
