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
    public void isEqualToDefaultDeltaPrimitiveTest() {
        initialize(Raw.floatAssertion(), Float.NaN).isEqualTo(Float.NaN);
        initialize(Raw.floatAssertion(), Float.POSITIVE_INFINITY).isEqualTo(Float.POSITIVE_INFINITY);
        initialize(Raw.floatAssertion(), Float.NEGATIVE_INFINITY).isEqualTo(Float.NEGATIVE_INFINITY);
        initialize(Raw.floatAssertion(), 10.1f).isEqualTo(10.1f);
        initialize(Raw.floatAssertion(), 10.01f).isEqualTo(10.01f);
        initialize(Raw.floatAssertion(), 10.001f).isEqualTo(10.001f);
        initialize(Raw.floatAssertion(), 10.0001f).isEqualTo(10.0001f);
        initialize(Raw.floatAssertion(), 10.00001f).isEqualTo(10.00001f);
        initialize(Raw.floatAssertion(), 10.000011f).isEqualTo(10.000012f);
        initialize(Raw.floatAssertion(), 10.000001f).isEqualTo(10.000002f);
        initialize(Raw.floatAssertion(), 10.0000001f).isEqualTo(10.0000002f);
        initialize(Raw.floatAssertion(), 10.1f).isNotNull().isEqualTo(10.1f).isInstanceOf(Float.class);

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
            initialize(Raw.floatAssertion(), null).isEqualTo(Float.NaN);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), null).isEqualTo(Float.POSITIVE_INFINITY);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), null).isEqualTo(Float.NEGATIVE_INFINITY);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), 1.0f).isEqualTo(Float.NaN);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be NaN.\n\tActual:<1.0f>");
        }
        try {
            initialize(Raw.floatAssertion(), 1.0f).isEqualTo(Float.POSITIVE_INFINITY);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be positive infinity.\n\tActual:<1.0f>");
        }
        try {
            initialize(Raw.floatAssertion(), 1.0f).isEqualTo(Float.NEGATIVE_INFINITY);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be negative infinity.\n\tActual:<1.0f>");
        }
        try {
            initialize(Raw.floatAssertion(), Float.NaN).isEqualTo(1.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be finite.\n\tActual:<NaN>");
        }
        try {
            initialize(Raw.floatAssertion(), Float.NaN).isEqualTo(Float.POSITIVE_INFINITY);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be positive infinity.\n\tActual:<NaN>");
        }
        try {
            initialize(Raw.floatAssertion(), Float.NaN).isEqualTo(Float.NEGATIVE_INFINITY);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be negative infinity.\n\tActual:<NaN>");
        }
        try {
            initialize(Raw.floatAssertion(), Float.POSITIVE_INFINITY).isEqualTo(1.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be finite.\n\tActual:<Infinity>");
        }
        try {
            initialize(Raw.floatAssertion(), Float.POSITIVE_INFINITY).isEqualTo(Float.NaN);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be NaN.\n\tActual:<Infinity>");
        }
        try {
            initialize(Raw.floatAssertion(), Float.POSITIVE_INFINITY).isEqualTo(Float.NEGATIVE_INFINITY);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be negative infinity.\n\tActual:<Infinity>");
        }
        try {
            initialize(Raw.floatAssertion(), Float.NEGATIVE_INFINITY).isEqualTo(1.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be finite.\n\tActual:<-Infinity>");
        }
        try {
            initialize(Raw.floatAssertion(), Float.NEGATIVE_INFINITY).isEqualTo(Float.NaN);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be NaN.\n\tActual:<-Infinity>");
        }
        try {
            initialize(Raw.floatAssertion(), Float.NEGATIVE_INFINITY).isEqualTo(Float.POSITIVE_INFINITY);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be positive infinity.\n\tActual:<-Infinity>");
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
    public void isEqualToDefaultDeltaObjectTest() {
        initialize(Raw.floatAssertion(), null).isEqualTo(null);
        initialize(Raw.floatAssertion(), Float.NaN).isEqualTo(Float.valueOf("NaN"));
        initialize(Raw.floatAssertion(), Float.POSITIVE_INFINITY).isEqualTo(Float.valueOf("Infinity"));
        initialize(Raw.floatAssertion(), Float.NEGATIVE_INFINITY).isEqualTo(Float.valueOf("-Infinity"));
        initialize(Raw.floatAssertion(), 10.1f).isEqualTo(Float.valueOf("10.1"));
        initialize(Raw.floatAssertion(), 10.01f).isEqualTo(Float.valueOf("10.01"));
        initialize(Raw.floatAssertion(), 10.001f).isEqualTo(Float.valueOf("10.001"));
        initialize(Raw.floatAssertion(), 10.0001f).isEqualTo(Float.valueOf("10.0001"));
        initialize(Raw.floatAssertion(), 10.00001f).isEqualTo(Float.valueOf("10.00001"));
        initialize(Raw.floatAssertion(), 10.000011f).isEqualTo(Float.valueOf("10.000012"));
        initialize(Raw.floatAssertion(), 10.000001f).isEqualTo(Float.valueOf("10.000002"));
        initialize(Raw.floatAssertion(), 10.0000001f).isEqualTo(Float.valueOf("10.0000002"));
        initialize(Raw.floatAssertion(), 10.1f).isNotNull().isEqualTo(Float.valueOf("10.1")).isInstanceOf(Float.class);

        try {
            Raw.floatAssertion().isEqualTo(Float.valueOf("1.0"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatAssertion(), null).isEqualTo(Float.valueOf("1.0"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), null, "Message").isEqualTo(Float.valueOf("1.0"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), null).isEqualTo(Float.valueOf("NaN"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), null).isEqualTo(Float.valueOf("Infinity"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), null).isEqualTo(Float.valueOf("-Infinity"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), 1.0f).isEqualTo(null);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null.\n\tActual:<1.0f>");
        }
        try {
            initialize(Raw.floatAssertion(), 1.0f, "Message").isEqualTo(null);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null.\n\tActual:<1.0f>");
        }
        try {
            initialize(Raw.floatAssertion(), 1.0f).isEqualTo(Float.valueOf("NaN"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be NaN.\n\tActual:<1.0f>");
        }
        try {
            initialize(Raw.floatAssertion(), 1.0f).isEqualTo(Float.valueOf("Infinity"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be positive infinity.\n\tActual:<1.0f>");
        }
        try {
            initialize(Raw.floatAssertion(), 1.0f).isEqualTo(Float.valueOf("-Infinity"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be negative infinity.\n\tActual:<1.0f>");
        }
        try {
            initialize(Raw.floatAssertion(), Float.NaN).isEqualTo(null);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null.\n\tActual:<NaN>");
        }
        try {
            initialize(Raw.floatAssertion(), Float.NaN).isEqualTo(Float.valueOf("1.0"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be finite.\n\tActual:<NaN>");
        }
        try {
            initialize(Raw.floatAssertion(), Float.NaN).isEqualTo(Float.valueOf("Infinity"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be positive infinity.\n\tActual:<NaN>");
        }
        try {
            initialize(Raw.floatAssertion(), Float.NaN).isEqualTo(Float.valueOf("-Infinity"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be negative infinity.\n\tActual:<NaN>");
        }
        try {
            initialize(Raw.floatAssertion(), Float.POSITIVE_INFINITY).isEqualTo(null);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null.\n\tActual:<Infinity>");
        }
        try {
            initialize(Raw.floatAssertion(), Float.POSITIVE_INFINITY).isEqualTo(Float.valueOf("1.0"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be finite.\n\tActual:<Infinity>");
        }
        try {
            initialize(Raw.floatAssertion(), Float.POSITIVE_INFINITY).isEqualTo(Float.valueOf("NaN"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be NaN.\n\tActual:<Infinity>");
        }
        try {
            initialize(Raw.floatAssertion(), Float.POSITIVE_INFINITY).isEqualTo(Float.valueOf("-Infinity"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be negative infinity.\n\tActual:<Infinity>");
        }
        try {
            initialize(Raw.floatAssertion(), Float.NEGATIVE_INFINITY).isEqualTo(null);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null.\n\tActual:<-Infinity>");
        }
        try {
            initialize(Raw.floatAssertion(), Float.NEGATIVE_INFINITY).isEqualTo(Float.valueOf("1.0"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be finite.\n\tActual:<-Infinity>");
        }
        try {
            initialize(Raw.floatAssertion(), Float.NEGATIVE_INFINITY).isEqualTo(Float.valueOf("NaN"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be NaN.\n\tActual:<-Infinity>");
        }
        try {
            initialize(Raw.floatAssertion(), Float.NEGATIVE_INFINITY).isEqualTo(Float.valueOf("Infinity"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be positive infinity.\n\tActual:<-Infinity>");
        }
        try {
            initialize(Raw.floatAssertion(), 10.00001f).isEqualTo(Float.valueOf("10.00002"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<10.00002f±1.0E-5f> but was:<10.00001f>");
        }
        try {
            initialize(Raw.floatAssertion(), 10.00001f, "Message").isEqualTo(Float.valueOf("10.00002"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<10.00002f±1.0E-5f> but was:<10.00001f>");
        }
    }

    /**
     * {@link FloatAssertion} class test.
     */
    @Test
    public void isEqualToSpecifiedDeltaPrimitiveTest() {
        initialize(Raw.floatAssertion(), 10.0f).isEqualTo(10.0f, 0.01f);
        initialize(Raw.floatAssertion(), 10.0f).isEqualTo(9.999f, 0.01f);
        initialize(Raw.floatAssertion(), 10.0f).isEqualTo(10.001f, 0.01f);
        initialize(Raw.floatAssertion(), 0.0f).isEqualTo(0.0f, 0.01f);
        initialize(Raw.floatAssertion(), Float.MAX_VALUE).isEqualTo(Float.MAX_VALUE, 0.01f);
        initialize(Raw.floatAssertion(), -0.0f).isEqualTo(+0.0f, 0.0f);
        initialize(Raw.floatAssertion(), +0.0f).isEqualTo(-0.0f, 0.0f);
        initialize(Raw.floatAssertion(), 10.0f).isNotNull().isEqualTo(10.0f, 0.01f).isInstanceOf(Float.class);

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
    public void isEqualToSpecifiedDeltaObjectTest() {
        initialize(Raw.floatAssertion(), null).isEqualTo(null, 0.01f);
        initialize(Raw.floatAssertion(), 10.0f).isEqualTo(Float.valueOf("10.0"), 0.01f);
        initialize(Raw.floatAssertion(), 10.0f).isEqualTo(Float.valueOf("9.999"), 0.01f);
        initialize(Raw.floatAssertion(), 10.0f).isEqualTo(Float.valueOf("10.001"), 0.01f);
        initialize(Raw.floatAssertion(), 0.0f).isEqualTo(Float.valueOf("0.0"), 0.01f);
        initialize(Raw.floatAssertion(), Float.MAX_VALUE).isEqualTo(Float.valueOf(Float.MAX_VALUE), 0.01f);
        initialize(Raw.floatAssertion(), 10.0f).isNotNull().isEqualTo(Float.valueOf("10.0"), 0.01f).isInstanceOf(Float.class);

        try {
            Raw.floatAssertion().isEqualTo(Float.valueOf("1.0"), 0.01f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatAssertion(), null).isEqualTo(Float.valueOf("1.0"), 0.01f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), null, "Message").isEqualTo(Float.valueOf("1.0"), 0.01f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), 1.0f).isEqualTo(null, 0.01f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null.\n\tActual:<1.0f>");
        }
        try {
            initialize(Raw.floatAssertion(), 1.0f, "Message").isEqualTo(null, 0.01f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null.\n\tActual:<1.0f>");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f).isEqualTo(Float.valueOf("10.01"), 0.001f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<10.01f±0.001f> but was:<10.0f>");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f, "Message").isEqualTo(Float.valueOf("10.01"), 0.001f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<10.01f±0.001f> but was:<10.0f>");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f).isEqualTo(Float.valueOf("9.99"), 0.001f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<9.99f±0.001f> but was:<10.0f>");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f, "Message").isEqualTo(Float.valueOf("9.99"), 0.001f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<9.99f±0.001f> but was:<10.0f>");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f).isEqualTo(Float.valueOf("20.0"), 0.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<20.0f±0.0f> but was:<10.0f>");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f, "Message").isEqualTo(Float.valueOf("20.0"), 0.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<20.0f±0.0f> but was:<10.0f>");
        }
    }

    /**
     * {@link FloatAssertion} class test.
     */
    @Test
    public void isNotEqualToDefaultDeltaPrimitiveTest() {
        initialize(Raw.floatAssertion(), null).isNotEqualTo(1.0f);
        initialize(Raw.floatAssertion(), null).isNotEqualTo(Float.NaN);
        initialize(Raw.floatAssertion(), null).isNotEqualTo(Float.POSITIVE_INFINITY);
        initialize(Raw.floatAssertion(), null).isNotEqualTo(Float.NEGATIVE_INFINITY);
        initialize(Raw.floatAssertion(), 1.0f).isNotEqualTo(Float.NaN);
        initialize(Raw.floatAssertion(), 1.0f).isNotEqualTo(Float.POSITIVE_INFINITY);
        initialize(Raw.floatAssertion(), 1.0f).isNotEqualTo(Float.NEGATIVE_INFINITY);
        initialize(Raw.floatAssertion(), Float.NaN).isNotEqualTo(1.0f);
        initialize(Raw.floatAssertion(), Float.NaN).isNotEqualTo(Float.POSITIVE_INFINITY);
        initialize(Raw.floatAssertion(), Float.NaN).isNotEqualTo(Float.NEGATIVE_INFINITY);
        initialize(Raw.floatAssertion(), Float.POSITIVE_INFINITY).isNotEqualTo(1.0f);
        initialize(Raw.floatAssertion(), Float.POSITIVE_INFINITY).isNotEqualTo(Float.NaN);
        initialize(Raw.floatAssertion(), Float.POSITIVE_INFINITY).isNotEqualTo(Float.NEGATIVE_INFINITY);
        initialize(Raw.floatAssertion(), Float.NEGATIVE_INFINITY).isNotEqualTo(1.0f);
        initialize(Raw.floatAssertion(), Float.NEGATIVE_INFINITY).isNotEqualTo(Float.NaN);
        initialize(Raw.floatAssertion(), Float.NEGATIVE_INFINITY).isNotEqualTo(Float.POSITIVE_INFINITY);
        initialize(Raw.floatAssertion(), 10.1f).isNotEqualTo(10.2f);
        initialize(Raw.floatAssertion(), 10.01f).isNotEqualTo(10.02f);
        initialize(Raw.floatAssertion(), 10.001f).isNotEqualTo(10.002f);
        initialize(Raw.floatAssertion(), 10.0001f).isNotEqualTo(10.0002f);
        initialize(Raw.floatAssertion(), 10.00001f).isNotEqualTo(10.00002f);
        initialize(Raw.floatAssertion(), 10.1f).isNotNull().isNotEqualTo(10.2f).isInstanceOf(Float.class);

        try {
            Raw.floatAssertion().isNotEqualTo(1.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatAssertion(), Float.NaN).isNotEqualTo(Float.NaN);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be NaN.");
        }
        try {
            initialize(Raw.floatAssertion(), Float.POSITIVE_INFINITY).isNotEqualTo(Float.POSITIVE_INFINITY);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be positive infinity.");
        }
        try {
            initialize(Raw.floatAssertion(), Float.NEGATIVE_INFINITY).isNotEqualTo(Float.NEGATIVE_INFINITY);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be negative infinity.");
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
    public void isNotEqualToDefaultDeltaObjectTest() {
        initialize(Raw.floatAssertion(), null).isNotEqualTo(Float.valueOf("1.0"));
        initialize(Raw.floatAssertion(), null).isNotEqualTo(Float.valueOf("NaN"));
        initialize(Raw.floatAssertion(), null).isNotEqualTo(Float.valueOf("Infinity"));
        initialize(Raw.floatAssertion(), null).isNotEqualTo(Float.valueOf("-Infinity"));
        initialize(Raw.floatAssertion(), 1.0f).isNotEqualTo(null);
        initialize(Raw.floatAssertion(), 1.0f).isNotEqualTo(Float.valueOf("NaN"));
        initialize(Raw.floatAssertion(), 1.0f).isNotEqualTo(Float.valueOf("Infinity"));
        initialize(Raw.floatAssertion(), 1.0f).isNotEqualTo(Float.valueOf("-Infinity"));
        initialize(Raw.floatAssertion(), Float.NaN).isNotEqualTo(null);
        initialize(Raw.floatAssertion(), Float.NaN).isNotEqualTo(Float.valueOf("1.0"));
        initialize(Raw.floatAssertion(), Float.NaN).isNotEqualTo(Float.valueOf("Infinity"));
        initialize(Raw.floatAssertion(), Float.NaN).isNotEqualTo(Float.valueOf("-Infinity"));
        initialize(Raw.floatAssertion(), Float.POSITIVE_INFINITY).isNotEqualTo(null);
        initialize(Raw.floatAssertion(), Float.POSITIVE_INFINITY).isNotEqualTo(Float.valueOf("1.0"));
        initialize(Raw.floatAssertion(), Float.POSITIVE_INFINITY).isNotEqualTo(Float.valueOf("NaN"));
        initialize(Raw.floatAssertion(), Float.POSITIVE_INFINITY).isNotEqualTo(Float.valueOf("-Infinity"));
        initialize(Raw.floatAssertion(), Float.NEGATIVE_INFINITY).isNotEqualTo(null);
        initialize(Raw.floatAssertion(), Float.NEGATIVE_INFINITY).isNotEqualTo(Float.valueOf("1.0"));
        initialize(Raw.floatAssertion(), Float.NEGATIVE_INFINITY).isNotEqualTo(Float.valueOf("NaN"));
        initialize(Raw.floatAssertion(), Float.NEGATIVE_INFINITY).isNotEqualTo(Float.valueOf("Infinity"));
        initialize(Raw.floatAssertion(), 10.1f).isNotEqualTo(Float.valueOf("10.2"));
        initialize(Raw.floatAssertion(), 10.01f).isNotEqualTo(Float.valueOf("10.02"));
        initialize(Raw.floatAssertion(), 10.001f).isNotEqualTo(Float.valueOf("10.002"));
        initialize(Raw.floatAssertion(), 10.0001f).isNotEqualTo(Float.valueOf("10.0002"));
        initialize(Raw.floatAssertion(), 10.00001f).isNotEqualTo(Float.valueOf("10.00002"));
        initialize(Raw.floatAssertion(), 10.1f).isNotNull().isNotEqualTo(Float.valueOf("10.2")).isInstanceOf(Float.class);

        try {
            Raw.floatAssertion().isNotEqualTo(Float.valueOf("1.0"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatAssertion(), null).isNotEqualTo(null);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), null, "Message").isNotEqualTo(null);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), Float.NaN).isNotEqualTo(Float.valueOf("NaN"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be NaN.");
        }
        try {
            initialize(Raw.floatAssertion(), Float.POSITIVE_INFINITY).isNotEqualTo(Float.valueOf("Infinity"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be positive infinity.");
        }
        try {
            initialize(Raw.floatAssertion(), Float.NEGATIVE_INFINITY).isNotEqualTo(Float.valueOf("-Infinity"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be negative infinity.");
        }
        try {
            initialize(Raw.floatAssertion(), 10.000001f).isNotEqualTo(Float.valueOf("10.000002"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<10.000001f±1.0E-5f>");
        }
        try {
            initialize(Raw.floatAssertion(), 10.000001f, "Message").isNotEqualTo(Float.valueOf("10.000002"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<10.000001f±1.0E-5f>");
        }
    }

    /**
     * {@link FloatAssertion} class test.
     */
    @Test
    public void isNotEqualToSpecifiedDeltaPrimitiveTest() {
        initialize(Raw.floatAssertion(), 10.0f).isNotEqualTo(10.01f, 0.001f);
        initialize(Raw.floatAssertion(), 10.0f).isNotEqualTo(9.99f, 0.001f);
        initialize(Raw.floatAssertion(), 10.0f).isNotEqualTo(20.0f, 0.0f);
        initialize(Raw.floatAssertion(), 10.0f).isNotNull().isNotEqualTo(10.01f, 0.001f).isInstanceOf(Float.class);

        try {
            Raw.floatAssertion().isNotEqualTo(1.0f, 0.001f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
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
    public void isNotEqualToSpecifiedDeltaObjectTest() {
        initialize(Raw.floatAssertion(), null).isNotEqualTo(Float.valueOf("5.0"), 0.001f);
        initialize(Raw.floatAssertion(), 5.0f).isNotEqualTo(null, 0.001f);
        initialize(Raw.floatAssertion(), 10.0f).isNotEqualTo(Float.valueOf("10.01"), 0.001f);
        initialize(Raw.floatAssertion(), 10.0f).isNotEqualTo(Float.valueOf("9.99"), 0.001f);
        initialize(Raw.floatAssertion(), 10.0f).isNotEqualTo(Float.valueOf("20.0"), 0.0f);
        initialize(Raw.floatAssertion(), 10.0f).isNotNull().isNotEqualTo(Float.valueOf("10.01"), 0.001f).isInstanceOf(Float.class);

        try {
            Raw.floatAssertion().isNotEqualTo(Float.valueOf("1.0"), 0.001f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatAssertion(), null).isNotEqualTo(null, 0.001f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), null, "Message").isNotEqualTo(null, 0.001f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f).isNotEqualTo(Float.valueOf("10.001"), 0.01f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<10.0f±0.01f>");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f, "Message").isNotEqualTo(Float.valueOf("10.001"), 0.01f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<10.0f±0.01f>");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f).isNotEqualTo(Float.valueOf("9.999"), 0.01f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<10.0f±0.01f>");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f, "Message").isNotEqualTo(Float.valueOf("9.999"), 0.01f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<10.0f±0.01f>");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f).isNotEqualTo(Float.valueOf("10.0"), 0.01f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<10.0f±0.01f>");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f, "Message").isNotEqualTo(Float.valueOf("10.0"), 0.01f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<10.0f±0.01f>");
        }
    }

    /**
     * {@link FloatAssertion} class test.
     */
    @Test
    public void isGreaterThanPrimitiveTest() {
        initialize(Raw.floatAssertion(), 10.0f).isGreaterThan(9.0f);
        initialize(Raw.floatAssertion(), 10.0f).isGreaterThan(8.0f);
        initialize(Raw.floatAssertion(), 10.0f).isGreaterThan(-1.0f);
        initialize(Raw.floatAssertion(), 10.0f).isNotNull().isGreaterThan(9.0f).isInstanceOf(Float.class);

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
            initialize(Raw.floatAssertion(), Float.NaN).isGreaterThan(1.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be finite.\n\tActual:<NaN>");
        }
        try {
            initialize(Raw.floatAssertion(), Float.NaN, "Message").isGreaterThan(1.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be finite.\n\tActual:<NaN>");
        }
        try {
            initialize(Raw.floatAssertion(), 1.0f).isGreaterThan(Float.NaN);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be finite: expected.");
        }
        try {
            initialize(Raw.floatAssertion(), 1.0f, "Message").isGreaterThan(Float.NaN);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be finite: expected.");
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
    public void isGreaterThanObjectTest() {
        initialize(Raw.floatAssertion(), 10.0f).isGreaterThan(Float.valueOf("9.0"));
        initialize(Raw.floatAssertion(), 10.0f).isGreaterThan(Float.valueOf("8.0"));
        initialize(Raw.floatAssertion(), 10.0f).isGreaterThan(Float.valueOf("-1.0"));
        initialize(Raw.floatAssertion(), 10.0f).isNotNull().isGreaterThan(Float.valueOf("9.0")).isInstanceOf(Float.class);

        try {
            Raw.floatAssertion().isGreaterThan(Float.valueOf("1.0"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatAssertion(), null).isGreaterThan(Float.valueOf("1.0"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), null, "Message").isGreaterThan(Float.valueOf("1.0"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), Float.NaN).isGreaterThan(Float.valueOf("1.0"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be finite.\n\tActual:<NaN>");
        }
        try {
            initialize(Raw.floatAssertion(), Float.NaN, "Message").isGreaterThan(Float.valueOf("1.0"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be finite.\n\tActual:<NaN>");
        }
        try {
            initialize(Raw.floatAssertion(), null).isGreaterThan(null);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), null, "Message").isGreaterThan(null);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), 1.0f).isGreaterThan(null);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.floatAssertion(), 1.0f, "Message").isGreaterThan(null);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.floatAssertion(), 1.0f).isGreaterThan(Float.valueOf("NaN"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be finite: expected.");
        }
        try {
            initialize(Raw.floatAssertion(), 1.0f, "Message").isGreaterThan(Float.valueOf("NaN"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be finite: expected.");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f).isGreaterThan(Float.valueOf("10.0"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater than the expected.\n\tExpected:<10.0f> but was:<10.0f>");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f, "Message").isGreaterThan(Float.valueOf("10.0"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be greater than the expected.\n\tExpected:<10.0f> but was:<10.0f>");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f).isGreaterThan(Float.valueOf("11.0"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater than the expected.\n\tExpected:<11.0f> but was:<10.0f>");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f, "Message").isGreaterThan(Float.valueOf("11.0"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be greater than the expected.\n\tExpected:<11.0f> but was:<10.0f>");
        }
    }

    /**
     * {@link FloatAssertion} class test.
     */
    @Test
    public void isGreaterThanOrEqualToPrimitiveTest() {
        initialize(Raw.floatAssertion(), 10.0f).isGreaterThanOrEqualTo(9.0f);
        initialize(Raw.floatAssertion(), 10.0f).isGreaterThanOrEqualTo(10.0f);
        initialize(Raw.floatAssertion(), 10.0f).isGreaterThanOrEqualTo(-1.0f);
        initialize(Raw.floatAssertion(), 10.0f).isNotNull().isGreaterThanOrEqualTo(9.0f).isInstanceOf(Float.class);

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
            initialize(Raw.floatAssertion(), Float.NaN).isGreaterThanOrEqualTo(1.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be finite.\n\tActual:<NaN>");
        }
        try {
            initialize(Raw.floatAssertion(), Float.NaN, "Message").isGreaterThanOrEqualTo(1.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be finite.\n\tActual:<NaN>");
        }
        try {
            initialize(Raw.floatAssertion(), 1.0f).isGreaterThanOrEqualTo(Float.NaN);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be finite: expected.");
        }
        try {
            initialize(Raw.floatAssertion(), 1.0f, "Message").isGreaterThanOrEqualTo(Float.NaN);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be finite: expected.");
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
    public void isGreaterThanOrEqualToObjectTest() {
        initialize(Raw.floatAssertion(), 10.0f).isGreaterThanOrEqualTo(Float.valueOf("9.0"));
        initialize(Raw.floatAssertion(), 10.0f).isGreaterThanOrEqualTo(Float.valueOf("10.0"));
        initialize(Raw.floatAssertion(), 10.0f).isGreaterThanOrEqualTo(Float.valueOf("-1.0"));
        initialize(Raw.floatAssertion(), 10.0f).isNotNull().isGreaterThanOrEqualTo(Float.valueOf("9.0")).isInstanceOf(Float.class);

        try {
            Raw.floatAssertion().isGreaterThanOrEqualTo(Float.valueOf("1.0"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatAssertion(), null).isGreaterThanOrEqualTo(Float.valueOf("1.0"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), null, "Message").isGreaterThanOrEqualTo(Float.valueOf("1.0"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), Float.NaN).isGreaterThanOrEqualTo(Float.valueOf("1.0"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be finite.\n\tActual:<NaN>");
        }
        try {
            initialize(Raw.floatAssertion(), Float.NaN, "Message").isGreaterThanOrEqualTo(Float.valueOf("1.0"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be finite.\n\tActual:<NaN>");
        }
        try {
            initialize(Raw.floatAssertion(), null).isGreaterThanOrEqualTo(null);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), null, "Message").isGreaterThanOrEqualTo(null);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), 1.0f).isGreaterThanOrEqualTo(null);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.floatAssertion(), 1.0f, "Message").isGreaterThanOrEqualTo(null);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.floatAssertion(), 1.0f).isGreaterThanOrEqualTo(Float.valueOf("NaN"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be finite: expected.");
        }
        try {
            initialize(Raw.floatAssertion(), 1.0f, "Message").isGreaterThanOrEqualTo(Float.valueOf("NaN"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be finite: expected.");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f).isGreaterThanOrEqualTo(Float.valueOf("11.0"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater than or equal to the expected.\n\tExpected:<11.0f> but was:<10.0f>");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f, "Message").isGreaterThanOrEqualTo(Float.valueOf("11.0"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be greater than or equal to the expected.\n\tExpected:<11.0f> but was:<10.0f>");
        }
    }

    /**
     * {@link FloatAssertion} class test.
     */
    @Test
    public void isLessThanPrimitiveTest() {
        initialize(Raw.floatAssertion(), 10.0f).isLessThan(11.0f);
        initialize(Raw.floatAssertion(), 10.0f).isLessThan(12.0f);
        initialize(Raw.floatAssertion(), 10.0f).isLessThan(100.0f);
        initialize(Raw.floatAssertion(), 10.0f).isNotNull().isLessThan(11.0f).isInstanceOf(Float.class);

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
            initialize(Raw.floatAssertion(), Float.NaN).isLessThan(1.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be finite.\n\tActual:<NaN>");
        }
        try {
            initialize(Raw.floatAssertion(), Float.NaN, "Message").isLessThan(1.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be finite.\n\tActual:<NaN>");
        }
        try {
            initialize(Raw.floatAssertion(), 1.0f).isLessThan(Float.NaN);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be finite: expected.");
        }
        try {
            initialize(Raw.floatAssertion(), 1.0f, "Message").isLessThan(Float.NaN);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be finite: expected.");
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
    public void isLessThanObjectTest() {
        initialize(Raw.floatAssertion(), 10.0f).isLessThan(Float.valueOf("11.0"));
        initialize(Raw.floatAssertion(), 10.0f).isLessThan(Float.valueOf("12.0"));
        initialize(Raw.floatAssertion(), 10.0f).isLessThan(Float.valueOf("100.0"));
        initialize(Raw.floatAssertion(), 10.0f).isNotNull().isLessThan(Float.valueOf("11.0")).isInstanceOf(Float.class);

        try {
            Raw.floatAssertion().isLessThan(Float.valueOf("1.0"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatAssertion(), null).isLessThan(Float.valueOf("1.0"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), null, "Message").isLessThan(Float.valueOf("1.0"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), Float.NaN).isLessThan(Float.valueOf("1.0"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be finite.\n\tActual:<NaN>");
        }
        try {
            initialize(Raw.floatAssertion(), Float.NaN, "Message").isLessThan(Float.valueOf("1.0"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be finite.\n\tActual:<NaN>");
        }
        try {
            initialize(Raw.floatAssertion(), null).isLessThan(null);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), null, "Message").isLessThan(null);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), 1.0f).isLessThan(null);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.floatAssertion(), 1.0f, "Message").isLessThan(null);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.floatAssertion(), 1.0f).isLessThan(Float.valueOf("NaN"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be finite: expected.");
        }
        try {
            initialize(Raw.floatAssertion(), 1.0f, "Message").isLessThan(Float.valueOf("NaN"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be finite: expected.");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f).isLessThan(Float.valueOf("10.0"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than the expected.\n\tExpected:<10.0f> but was:<10.0f>");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f, "Message").isLessThan(Float.valueOf("10.0"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be less than the expected.\n\tExpected:<10.0f> but was:<10.0f>");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f).isLessThan(Float.valueOf("9.0"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than the expected.\n\tExpected:<9.0f> but was:<10.0f>");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f, "Message").isLessThan(Float.valueOf("9.0"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be less than the expected.\n\tExpected:<9.0f> but was:<10.0f>");
        }
    }

    /**
     * {@link FloatAssertion} class test.
     */
    @Test
    public void isLessThanOrEqualToPrimitiveTest() {
        initialize(Raw.floatAssertion(), 10.0f).isLessThanOrEqualTo(11.0f);
        initialize(Raw.floatAssertion(), 10.0f).isLessThanOrEqualTo(10.0f);
        initialize(Raw.floatAssertion(), 10.0f).isLessThanOrEqualTo(100.0f);
        initialize(Raw.floatAssertion(), 10.0f).isNotNull().isLessThanOrEqualTo(11.0f).isInstanceOf(Float.class);

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
            initialize(Raw.floatAssertion(), Float.NaN).isLessThanOrEqualTo(1.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be finite.\n\tActual:<NaN>");
        }
        try {
            initialize(Raw.floatAssertion(), Float.NaN, "Message").isLessThanOrEqualTo(1.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be finite.\n\tActual:<NaN>");
        }
        try {
            initialize(Raw.floatAssertion(), 1.0f).isLessThanOrEqualTo(Float.NaN);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be finite: expected.");
        }
        try {
            initialize(Raw.floatAssertion(), 1.0f, "Message").isLessThanOrEqualTo(Float.NaN);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be finite: expected.");
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
    public void isLessThanOrEqualToObjectTest() {
        initialize(Raw.floatAssertion(), 10.0f).isLessThanOrEqualTo(Float.valueOf("11.0"));
        initialize(Raw.floatAssertion(), 10.0f).isLessThanOrEqualTo(Float.valueOf("10.0"));
        initialize(Raw.floatAssertion(), 10.0f).isLessThanOrEqualTo(Float.valueOf("100.0"));
        initialize(Raw.floatAssertion(), 10.0f).isNotNull().isLessThanOrEqualTo(Float.valueOf("11.0")).isInstanceOf(Float.class);

        try {
            Raw.floatAssertion().isLessThanOrEqualTo(Float.valueOf("1.0"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatAssertion(), null).isLessThanOrEqualTo(Float.valueOf("1.0"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), null, "Message").isLessThanOrEqualTo(Float.valueOf("1.0"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), Float.NaN).isLessThanOrEqualTo(Float.valueOf("1.0"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be finite.\n\tActual:<NaN>");
        }
        try {
            initialize(Raw.floatAssertion(), Float.NaN, "Message").isLessThanOrEqualTo(Float.valueOf("1.0"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be finite.\n\tActual:<NaN>");
        }
        try {
            initialize(Raw.floatAssertion(), null).isLessThanOrEqualTo(null);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), null, "Message").isLessThanOrEqualTo(null);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), 1.0f).isLessThanOrEqualTo(null);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.floatAssertion(), 1.0f, "Message").isLessThanOrEqualTo(null);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.floatAssertion(), 1.0f).isLessThanOrEqualTo(Float.valueOf("NaN"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be finite: expected.");
        }
        try {
            initialize(Raw.floatAssertion(), 1.0f, "Message").isLessThanOrEqualTo(Float.valueOf("NaN"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be finite: expected.");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f).isLessThanOrEqualTo(Float.valueOf("9.0"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than or equal to the expected.\n\tExpected:<9.0f> but was:<10.0f>");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f, "Message").isLessThanOrEqualTo(Float.valueOf("9.0"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be less than or equal to the expected.\n\tExpected:<9.0f> but was:<10.0f>");
        }
    }

    /**
     * {@link FloatAssertion} class test.
     */
    @Test
    public void isInRangePrimitiveTest() {
        initialize(Raw.floatAssertion(), 5.0f).isInRange(4.0f, 6.0f);
        initialize(Raw.floatAssertion(), 5.0f).isInRange(5.0f, 6.0f);
        initialize(Raw.floatAssertion(), 5.0f).isInRange(1.0f, 10.0f);
        initialize(Raw.floatAssertion(), 5.0f).isNotNull().isInRange(4.0f, 6.0f).isInstanceOf(Float.class);

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
            initialize(Raw.floatAssertion(), Float.NaN).isInRange(1.0f, 1.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be finite.\n\tActual:<NaN>");
        }
        try {
            initialize(Raw.floatAssertion(), Float.NaN, "Message").isInRange(1.0f, 1.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be finite.\n\tActual:<NaN>");
        }
        try {
            initialize(Raw.floatAssertion(), 1.0f).isInRange(Float.NaN, 1.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be finite: expectedFrom.");
        }
        try {
            initialize(Raw.floatAssertion(), 1.0f, "Message").isInRange(Float.NaN, 1.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be finite: expectedFrom.");
        }
        try {
            initialize(Raw.floatAssertion(), 1.0f).isInRange(1.0f, Float.NaN);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be finite: expectedTo.");
        }
        try {
            initialize(Raw.floatAssertion(), 1.0f, "Message").isInRange(1.0f, Float.NaN);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be finite: expectedTo.");
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
    public void isInRangeObjectTest() {
        initialize(Raw.floatAssertion(), 5.0f).isInRange(Float.valueOf("4.0"), Float.valueOf("6.0"));
        initialize(Raw.floatAssertion(), 5.0f).isInRange(Float.valueOf("5.0"), Float.valueOf("6.0"));
        initialize(Raw.floatAssertion(), 5.0f).isInRange(Float.valueOf("1.0"), Float.valueOf("10.0"));
        initialize(Raw.floatAssertion(), 5.0f).isNotNull().isInRange(Float.valueOf("4.0"), Float.valueOf("6.0")).isInstanceOf(Float.class);

        try {
            Raw.floatAssertion().isInRange(Float.valueOf("1.0"), Float.valueOf("1.0"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatAssertion(), null).isInRange(Float.valueOf("1.0"), Float.valueOf("1.0"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), null, "Message").isInRange(Float.valueOf("1.0"), Float.valueOf("1.0"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), Float.NaN).isInRange(Float.valueOf("1.0"), Float.valueOf("1.0"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be finite.\n\tActual:<NaN>");
        }
        try {
            initialize(Raw.floatAssertion(), Float.NaN, "Message").isInRange(Float.valueOf("1.0"), Float.valueOf("1.0"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be finite.\n\tActual:<NaN>");
        }
        try {
            initialize(Raw.floatAssertion(), null).isInRange(null, Float.valueOf("1.0"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), null, "Message").isInRange(null, Float.valueOf("1.0"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), 1.0f).isInRange(null, Float.valueOf("1.0"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.floatAssertion(), 1.0f, "Message").isInRange(null, Float.valueOf("1.0"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.floatAssertion(), 1.0f).isInRange(Float.valueOf("NaN"), Float.valueOf("1.0"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be finite: expectedFrom.");
        }
        try {
            initialize(Raw.floatAssertion(), 1.0f, "Message").isInRange(Float.valueOf("NaN"), Float.valueOf("1.0"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be finite: expectedFrom.");
        }
        try {
            initialize(Raw.floatAssertion(), 1.0f).isInRange(null, null);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.floatAssertion(), 1.0f, "Message").isInRange(null, null);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.floatAssertion(), 1.0f).isInRange(Float.valueOf("1.0"), null);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedTo.");
        }
        try {
            initialize(Raw.floatAssertion(), 1.0f, "Message").isInRange(Float.valueOf("1.0"), null);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedTo.");
        }
        try {
            initialize(Raw.floatAssertion(), 1.0f).isInRange(Float.valueOf("1.0"), Float.valueOf("NaN"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be finite: expectedTo.");
        }
        try {
            initialize(Raw.floatAssertion(), 1.0f, "Message").isInRange(Float.valueOf("1.0"), Float.valueOf("NaN"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be finite: expectedTo.");
        }
        try {
            initialize(Raw.floatAssertion(), 5.0f).isInRange(Float.valueOf("1.0"), Float.valueOf("5.0"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be in the expected range.\n\tExpected:<1.0f:5.0f> but was:<5.0f>");
        }
        try {
            initialize(Raw.floatAssertion(), 5.0f, "Message").isInRange(Float.valueOf("1.0"), Float.valueOf("5.0"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be in the expected range.\n\tExpected:<1.0f:5.0f> but was:<5.0f>");
        }
        try {
            initialize(Raw.floatAssertion(), 5.0f).isInRange(Float.valueOf("6.0"), Float.valueOf("10.0"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be in the expected range.\n\tExpected:<6.0f:10.0f> but was:<5.0f>");
        }
        try {
            initialize(Raw.floatAssertion(), 5.0f, "Message").isInRange(Float.valueOf("6.0"), Float.valueOf("10.0"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be in the expected range.\n\tExpected:<6.0f:10.0f> but was:<5.0f>");
        }
        try {
            initialize(Raw.floatAssertion(), 5.0f).isInRange(Float.valueOf("8.0"), Float.valueOf("9.0"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be in the expected range.\n\tExpected:<8.0f:9.0f> but was:<5.0f>");
        }
        try {
            initialize(Raw.floatAssertion(), 5.0f, "Message").isInRange(Float.valueOf("8.0"), Float.valueOf("9.0"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be in the expected range.\n\tExpected:<8.0f:9.0f> but was:<5.0f>");
        }
    }

    /**
     * {@link FloatAssertion} class test.
     */
    @Test
    public void isNotInRangePrimitiveTest() {
        initialize(Raw.floatAssertion(), 5.0f).isNotInRange(1.0f, 5.0f);
        initialize(Raw.floatAssertion(), 5.0f).isNotInRange(6.0f, 10.0f);
        initialize(Raw.floatAssertion(), 5.0f).isNotInRange(8.0f, 9.0f);
        initialize(Raw.floatAssertion(), 5.0f).isNotNull().isNotInRange(1.0f, 5.0f).isInstanceOf(Float.class);

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
            initialize(Raw.floatAssertion(), Float.NaN).isNotInRange(1.0f, 1.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be finite.\n\tActual:<NaN>");
        }
        try {
            initialize(Raw.floatAssertion(), Float.NaN, "Message").isNotInRange(1.0f, 1.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be finite.\n\tActual:<NaN>");
        }
        try {
            initialize(Raw.floatAssertion(), 1.0f).isNotInRange(Float.NaN, 1.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be finite: expectedFrom.");
        }
        try {
            initialize(Raw.floatAssertion(), 1.0f, "Message").isNotInRange(Float.NaN, 1.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be finite: expectedFrom.");
        }
        try {
            initialize(Raw.floatAssertion(), 1.0f).isNotInRange(1.0f, Float.NaN);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be finite: expectedTo.");
        }
        try {
            initialize(Raw.floatAssertion(), 1.0f, "Message").isNotInRange(1.0f, Float.NaN);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be finite: expectedTo.");
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
    public void isNotInRangeObjectTest() {
        initialize(Raw.floatAssertion(), 5.0f).isNotInRange(Float.valueOf("1.0"), Float.valueOf("5.0"));
        initialize(Raw.floatAssertion(), 5.0f).isNotInRange(Float.valueOf("6.0"), Float.valueOf("10.0"));
        initialize(Raw.floatAssertion(), 5.0f).isNotInRange(Float.valueOf("8.0"), Float.valueOf("9.0"));
        initialize(Raw.floatAssertion(), 5.0f).isNotNull().isNotInRange(Float.valueOf("1.0"), Float.valueOf("5.0")).isInstanceOf(Float.class);

        try {
            Raw.floatAssertion().isNotInRange(Float.valueOf("1.0"), Float.valueOf("1.0"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatAssertion(), null).isNotInRange(Float.valueOf("1.0"), Float.valueOf("1.0"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), null, "Message").isNotInRange(Float.valueOf("1.0"), Float.valueOf("1.0"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), Float.NaN).isNotInRange(Float.valueOf("1.0"), Float.valueOf("1.0"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be finite.\n\tActual:<NaN>");
        }
        try {
            initialize(Raw.floatAssertion(), Float.NaN, "Message").isNotInRange(Float.valueOf("1.0"), Float.valueOf("1.0"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be finite.\n\tActual:<NaN>");
        }
        try {
            initialize(Raw.floatAssertion(), null).isNotInRange(null, Float.valueOf("1.0"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), null, "Message").isNotInRange(null, Float.valueOf("1.0"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), 1.0f).isNotInRange(null, Float.valueOf("1.0"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.floatAssertion(), 1.0f, "Message").isNotInRange(null, Float.valueOf("1.0"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.floatAssertion(), 1.0f).isNotInRange(Float.valueOf("NaN"), Float.valueOf("1.0"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be finite: expectedFrom.");
        }
        try {
            initialize(Raw.floatAssertion(), 1.0f, "Message").isNotInRange(Float.valueOf("NaN"), Float.valueOf("1.0"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be finite: expectedFrom.");
        }
        try {
            initialize(Raw.floatAssertion(), 1.0f).isNotInRange(null, null);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.floatAssertion(), 1.0f, "Message").isNotInRange(null, null);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.floatAssertion(), 1.0f).isNotInRange(Float.valueOf("1.0"), null);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedTo.");
        }
        try {
            initialize(Raw.floatAssertion(), 1.0f, "Message").isNotInRange(Float.valueOf("1.0"), null);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedTo.");
        }
        try {
            initialize(Raw.floatAssertion(), 1.0f).isNotInRange(Float.valueOf("1.0"), Float.valueOf("NaN"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be finite: expectedTo.");
        }
        try {
            initialize(Raw.floatAssertion(), 1.0f, "Message").isNotInRange(Float.valueOf("1.0"), Float.valueOf("NaN"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be finite: expectedTo.");
        }
        try {
            initialize(Raw.floatAssertion(), 5.0f).isNotInRange(Float.valueOf("4.0"), Float.valueOf("6.0"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be in the expected range.\n\tExpected:<4.0f:6.0f> but was:<5.0f>");
        }
        try {
            initialize(Raw.floatAssertion(), 5.0f, "Message").isNotInRange(Float.valueOf("4.0"), Float.valueOf("6.0"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be in the expected range.\n\tExpected:<4.0f:6.0f> but was:<5.0f>");
        }
        try {
            initialize(Raw.floatAssertion(), 5.0f).isNotInRange(Float.valueOf("5.0"), Float.valueOf("6.0"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be in the expected range.\n\tExpected:<5.0f:6.0f> but was:<5.0f>");
        }
        try {
            initialize(Raw.floatAssertion(), 5.0f, "Message").isNotInRange(Float.valueOf("5.0"), Float.valueOf("6.0"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be in the expected range.\n\tExpected:<5.0f:6.0f> but was:<5.0f>");
        }
        try {
            initialize(Raw.floatAssertion(), 5.0f).isNotInRange(Float.valueOf("1.0"), Float.valueOf("10.0"));
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be in the expected range.\n\tExpected:<1.0f:10.0f> but was:<5.0f>");
        }
        try {
            initialize(Raw.floatAssertion(), 5.0f, "Message").isNotInRange(Float.valueOf("1.0"), Float.valueOf("10.0"));
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
        initialize(Raw.floatAssertion(), 0.0f).isNotNull().isZero().isInstanceOf(Float.class);

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
        try {
            initialize(Raw.floatAssertion(), Float.POSITIVE_INFINITY).isZero();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be zero.\n\tActual:<Infinity>");
        }
        try {
            initialize(Raw.floatAssertion(), Float.POSITIVE_INFINITY, "Message").isZero();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be zero.\n\tActual:<Infinity>");
        }
        try {
            initialize(Raw.floatAssertion(), Float.NEGATIVE_INFINITY).isZero();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be zero.\n\tActual:<-Infinity>");
        }
        try {
            initialize(Raw.floatAssertion(), Float.NEGATIVE_INFINITY, "Message").isZero();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be zero.\n\tActual:<-Infinity>");
        }
        try {
            initialize(Raw.floatAssertion(), Float.NaN).isZero();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be zero.\n\tActual:<NaN>");
        }
        try {
            initialize(Raw.floatAssertion(), Float.NaN, "Message").isZero();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be zero.\n\tActual:<NaN>");
        }
    }

    /**
     * {@link FloatAssertion} class test.
     */
    @Test
    public void isNotZeroTest() {
        initialize(Raw.floatAssertion(), 10.0f).isNotZero();
        initialize(Raw.floatAssertion(), -10.0f).isNotZero();
        initialize(Raw.floatAssertion(), Float.POSITIVE_INFINITY).isNotZero();
        initialize(Raw.floatAssertion(), Float.NEGATIVE_INFINITY).isNotZero();
        initialize(Raw.floatAssertion(), Float.NaN).isNotZero();
        initialize(Raw.floatAssertion(), 10.0f).isNotNull().isNotZero().isInstanceOf(Float.class);

        try {
            Raw.floatAssertion().isNotZero();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatAssertion(), null).isNotZero();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), null, "Message").isNotZero();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), 0.0f).isNotZero();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be zero.");
        }
        try {
            initialize(Raw.floatAssertion(), 0.0f, "Message").isNotZero();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be zero.");
        }
        try {
            initialize(Raw.floatAssertion(), +0.0f).isNotZero();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be zero.");
        }
        try {
            initialize(Raw.floatAssertion(), +0.0f, "Message").isNotZero();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be zero.");
        }
        try {
            initialize(Raw.floatAssertion(), -0.0f).isNotZero();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be zero.");
        }
        try {
            initialize(Raw.floatAssertion(), -0.0f, "Message").isNotZero();
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
        float val = getZero();
        initialize(Raw.floatAssertion(), 1.0f / val).isPositiveInfinity();
        initialize(Raw.floatAssertion(), Float.POSITIVE_INFINITY).isNotNull().isPositiveInfinity().isInstanceOf(Float.class);

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
    public void isNotPositiveInfinityTest() {
        initialize(Raw.floatAssertion(), 0.0f).isNotPositiveInfinity();
        initialize(Raw.floatAssertion(), 10.0f).isNotPositiveInfinity();
        initialize(Raw.floatAssertion(), Float.NaN).isNotPositiveInfinity();
        initialize(Raw.floatAssertion(), Float.NEGATIVE_INFINITY).isNotPositiveInfinity();
        initialize(Raw.floatAssertion(), 0.0f).isNotNull().isNotPositiveInfinity().isInstanceOf(Float.class);

        try {
            Raw.floatAssertion().isNotPositiveInfinity();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatAssertion(), null).isNotPositiveInfinity();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), null, "Message").isNotPositiveInfinity();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), Float.POSITIVE_INFINITY).isNotPositiveInfinity();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be positive infinity.");
        }
        try {
            initialize(Raw.floatAssertion(), Float.POSITIVE_INFINITY, "Message").isNotPositiveInfinity();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be positive infinity.");
        }
    }

    /**
     * {@link FloatAssertion} class test.
     */
    @Test
    public void isNegativeInfinityTest() {
        initialize(Raw.floatAssertion(), Float.NEGATIVE_INFINITY).isNegativeInfinity();
        float val = getZero();
        initialize(Raw.floatAssertion(), -1.0f / val).isNegativeInfinity();
        initialize(Raw.floatAssertion(), Float.NEGATIVE_INFINITY).isNotNull().isNegativeInfinity().isInstanceOf(Float.class);

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
    public void isNotNegativeInfinityTest() {
        initialize(Raw.floatAssertion(), 0.0f).isNotNegativeInfinity();
        initialize(Raw.floatAssertion(), 10.0f).isNotNegativeInfinity();
        initialize(Raw.floatAssertion(), Float.NaN).isNotNegativeInfinity();
        initialize(Raw.floatAssertion(), Float.POSITIVE_INFINITY).isNotNegativeInfinity();
        initialize(Raw.floatAssertion(), 0.0f).isNotNull().isNotNegativeInfinity().isInstanceOf(Float.class);

        try {
            Raw.floatAssertion().isNotNegativeInfinity();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatAssertion(), null).isNotNegativeInfinity();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), null, "Message").isNotNegativeInfinity();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), Float.NEGATIVE_INFINITY).isNotNegativeInfinity();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be negative infinity.");
        }
        try {
            initialize(Raw.floatAssertion(), Float.NEGATIVE_INFINITY, "Message").isNotNegativeInfinity();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be negative infinity.");
        }
    }

    /**
     * {@link FloatAssertion} class test.
     */
    @Test
    public void isInfinityTest() {
        initialize(Raw.floatAssertion(), Float.POSITIVE_INFINITY).isInfinity();
        initialize(Raw.floatAssertion(), Float.NEGATIVE_INFINITY).isInfinity();
        float val = getZero();
        initialize(Raw.floatAssertion(), 1.0f / val).isInfinity();
        initialize(Raw.floatAssertion(), -1.0f / val).isInfinity();
        initialize(Raw.floatAssertion(), Float.POSITIVE_INFINITY).isNotNull().isInfinity().isInstanceOf(Float.class);

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
    public void isNotInfinityTest() {
        initialize(Raw.floatAssertion(), 0.0f).isNotInfinity();
        initialize(Raw.floatAssertion(), 10.0f).isNotInfinity();
        initialize(Raw.floatAssertion(), -10.0f).isNotInfinity();
        initialize(Raw.floatAssertion(), Float.NaN).isNotInfinity();
        initialize(Raw.floatAssertion(), 0.0f).isNotNull().isNotInfinity().isInstanceOf(Float.class);

        try {
            Raw.floatAssertion().isNotInfinity();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatAssertion(), null).isNotInfinity();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), null, "Message").isNotInfinity();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), Float.POSITIVE_INFINITY).isNotInfinity();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be infinity.\n\tActual:<Infinity>");
        }
        try {
            initialize(Raw.floatAssertion(), Float.POSITIVE_INFINITY, "Message").isNotInfinity();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be infinity.\n\tActual:<Infinity>");
        }
        try {
            initialize(Raw.floatAssertion(), Float.NEGATIVE_INFINITY).isNotInfinity();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be infinity.\n\tActual:<-Infinity>");
        }
        try {
            initialize(Raw.floatAssertion(), Float.NEGATIVE_INFINITY, "Message").isNotInfinity();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be infinity.\n\tActual:<-Infinity>");
        }
    }

    /**
     * {@link FloatAssertion} class test.
     */
    @Test
    public void isNaNTest() {
        initialize(Raw.floatAssertion(), Float.NaN).isNaN();
        initialize(Raw.floatAssertion(), (float) Math.sqrt(-2.0f)).isNaN();
        initialize(Raw.floatAssertion(), Float.POSITIVE_INFINITY / Float.NEGATIVE_INFINITY).isNaN();
        initialize(Raw.floatAssertion(), Float.NaN).isNotNull().isNaN().isInstanceOf(Float.class);

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
        initialize(Raw.floatAssertion(), 0.0f).isNotNull().isNotNaN().isInstanceOf(Float.class);

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
        initialize(Raw.floatAssertion(), 0.0f).isNotNull().isFinite().isInstanceOf(Float.class);

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
    public void isNotFiniteTest() {
        initialize(Raw.floatAssertion(), Float.NaN).isNotFinite();
        initialize(Raw.floatAssertion(), Float.POSITIVE_INFINITY).isNotFinite();
        initialize(Raw.floatAssertion(), Float.NEGATIVE_INFINITY).isNotFinite();
        initialize(Raw.floatAssertion(), Float.NaN).isNotNull().isNotFinite().isInstanceOf(Float.class);

        try {
            Raw.floatAssertion().isNotFinite();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatAssertion(), null).isNotFinite();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), null, "Message").isNotFinite();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatAssertion(), 0.0f).isNotFinite();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be finite.\n\tActual:<0.0f>");
        }
        try {
            initialize(Raw.floatAssertion(), 0.0f, "Message").isNotFinite();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be finite.\n\tActual:<0.0f>");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f).isNotFinite();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be finite.\n\tActual:<10.0f>");
        }
        try {
            initialize(Raw.floatAssertion(), 10.0f, "Message").isNotFinite();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be finite.\n\tActual:<10.0f>");
        }
        try {
            initialize(Raw.floatAssertion(), -10.0f).isNotFinite();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be finite.\n\tActual:<-10.0f>");
        }
        try {
            initialize(Raw.floatAssertion(), -10.0f, "Message").isNotFinite();
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be finite.\n\tActual:<-10.0f>");
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
            Assertions.assertThat(ex).hasMessage("Actual and expected values should point to the same object.\n\tExpected:<10000.0f> but was:<10000.0f>");
        }
        try {
            initialize(Raw.floatAssertion(), value, "Message").isSameAs(10000.0f);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should point to the same object.\n\tExpected:<10000.0f> but was:<10000.0f>");
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
            Assertions.assertThat(ex).hasMessage("Actual and expected values should point to the different objects.\n\tActual:<10000.0f>");
        }
        try {
            initialize(Raw.floatAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail("FloatAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should point to the different objects.\n\tActual:<10000.0f>");
        }
    }

    private float getZero() {
        return 0.0f;
    }

}
