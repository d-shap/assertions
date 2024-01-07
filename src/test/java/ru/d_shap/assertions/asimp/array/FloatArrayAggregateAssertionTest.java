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
package ru.d_shap.assertions.asimp.array;

import org.hamcrest.Matchers;
import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link FloatArrayAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class FloatArrayAggregateAssertionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public FloatArrayAggregateAssertionTest() {
        super();
    }

    /**
     * {@link FloatArrayAssertion} class test.
     */
    @Test
    public void toMinTest() {
        initialize(Raw.floatArrayAssertion(), new float[]{}).toMin().isNull();
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f}).toMin().isEqualTo(1.0f);
        initialize(Raw.floatArrayAssertion(), new float[]{10.0f, 1.0f, 15.0f, 25.0f}).toMin().isEqualTo(1.0f);
        initialize(Raw.floatArrayAssertion(), new float[]{-Float.MAX_VALUE, 100.0f, -100.0f, 100.0f, 100.0f}).toMin().isEqualTo(-Float.MAX_VALUE);
        initialize(Raw.floatArrayAssertion(), new float[]{100.0f, -100.0f, 100.0f, 100.0f, -Float.MAX_VALUE}).toMin().isEqualTo(-Float.MAX_VALUE);
        initialize(Raw.floatArrayAssertion(), new float[]{100.0f, -100.0f, -Float.MAX_VALUE, 100.0f, 100.0f}).toMin().isEqualTo(-Float.MAX_VALUE);
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f}).isNotNull().toMin().isEqualTo(1.0f);

        try {
            Raw.floatArrayAssertion().toMin();
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null).toMin();
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null, "Message").toMin();
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).toMin()).isEqualTo(0.0f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}, "Message").toMin()).isEqualTo(0.0f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).toMin().isEqualTo(4.0f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0f±1.0E-5f> but was:<1.0f>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}, "Message").toMin().isEqualTo(4.0f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0f±1.0E-5f> but was:<1.0f>");
        }
    }

    /**
     * {@link FloatArrayAssertion} class test.
     */
    @Test
    public void toMinMatcherTest() {
        initialize(Raw.floatArrayAssertion(), new float[]{}).toMin(Matchers.nullValue());
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f}).toMin(Matchers.is(Matchers.equalTo(1.0f)));
        initialize(Raw.floatArrayAssertion(), new float[]{10.0f, 1.0f, 15.0f, 25.0f}).toMin(Matchers.is(Matchers.equalTo(1.0f)));
        initialize(Raw.floatArrayAssertion(), new float[]{-Float.MAX_VALUE, 100.0f, -100.0f, 100.0f, 100.0f}).toMin(Matchers.is(Matchers.equalTo(-Float.MAX_VALUE)));
        initialize(Raw.floatArrayAssertion(), new float[]{100.0f, -100.0f, 100.0f, 100.0f, -Float.MAX_VALUE}).toMin(Matchers.is(Matchers.equalTo(-Float.MAX_VALUE)));
        initialize(Raw.floatArrayAssertion(), new float[]{100.0f, -100.0f, -Float.MAX_VALUE, 100.0f, 100.0f}).toMin(Matchers.is(Matchers.equalTo(-Float.MAX_VALUE)));
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f}).isNotNull().toMin(Matchers.is(Matchers.equalTo(1.0f))).isInstanceOf(float[].class);

        try {
            Raw.floatArrayAssertion().toMin(Matchers.equalTo(0.0f));
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null).toMin(Matchers.equalTo(0.0f));
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null, "Message").toMin(Matchers.equalTo(0.0f));
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null).toMin(null);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null, "Message").toMin(null);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{}).toMin(null);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{}, "Message").toMin(null);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).toMin(Matchers.equalTo(4.0f));
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\nExpected: <4.0F>\n     but: was <1.0F>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}, "Message").toMin(Matchers.equalTo(4.0f));
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\nExpected: <4.0F>\n     but: was <1.0F>");
        }
    }

    /**
     * {@link FloatArrayAssertion} class test.
     */
    @Test
    public void hasMinDefaultDeltaPrimitiveTest() {
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f}).hasMin(1.0f);
        initialize(Raw.floatArrayAssertion(), new float[]{10.0f, 1.0f, 15.0f, 25.0f}).hasMin(1.0f);
        initialize(Raw.floatArrayAssertion(), new float[]{-Float.MAX_VALUE, 100.0f, -100.0f, 100.0f, 100.0f}).hasMin(-Float.MAX_VALUE);
        initialize(Raw.floatArrayAssertion(), new float[]{100.0f, -100.0f, 100.0f, 100.0f, -Float.MAX_VALUE}).hasMin(-Float.MAX_VALUE);
        initialize(Raw.floatArrayAssertion(), new float[]{100.0f, -100.0f, -Float.MAX_VALUE, 100.0f, 100.0f}).hasMin(-Float.MAX_VALUE);
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f}).isNotNull().hasMin(1.0f).isInstanceOf(float[].class);

        try {
            Raw.floatArrayAssertion().hasMin(0.0f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null).hasMin(0.0f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null, "Message").hasMin(0.0f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).hasMin(4.0f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0f±1.0E-5f> but was:<1.0f>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}, "Message").hasMin(4.0f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0f±1.0E-5f> but was:<1.0f>");
        }
    }

    /**
     * {@link FloatArrayAssertion} class test.
     */
    @Test
    public void hasMinDefaultDeltaObjectTest() {
        initialize(Raw.floatArrayAssertion(), new float[]{}).hasMin(null);
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f}).hasMin(Float.valueOf(1.0f));
        initialize(Raw.floatArrayAssertion(), new float[]{10.0f, 1.0f, 15.0f, 25.0f}).hasMin(Float.valueOf(1.0f));
        initialize(Raw.floatArrayAssertion(), new float[]{-Float.MAX_VALUE, 100.0f, -100.0f, 100.0f, 100.0f}).hasMin(Float.valueOf(-Float.MAX_VALUE));
        initialize(Raw.floatArrayAssertion(), new float[]{100.0f, -100.0f, 100.0f, 100.0f, -Float.MAX_VALUE}).hasMin(Float.valueOf(-Float.MAX_VALUE));
        initialize(Raw.floatArrayAssertion(), new float[]{100.0f, -100.0f, -Float.MAX_VALUE, 100.0f, 100.0f}).hasMin(Float.valueOf(-Float.MAX_VALUE));
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f}).isNotNull().hasMin(Float.valueOf(1.0f)).isInstanceOf(float[].class);

        try {
            Raw.floatArrayAssertion().hasMin(Float.valueOf(0.0f));
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null).hasMin(Float.valueOf(0.0f));
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null, "Message").hasMin(Float.valueOf(0.0f));
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null).hasMin(null);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null, "Message").hasMin(null);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f}).hasMin(null);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual value should be null.\n\tActual:<1.0f>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f}, "Message").hasMin(null);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual value should be null.\n\tActual:<1.0f>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).hasMin(Float.valueOf(4.0f));
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0f±1.0E-5f> but was:<1.0f>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}, "Message").hasMin(Float.valueOf(4.0f));
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0f±1.0E-5f> but was:<1.0f>");
        }
    }

    /**
     * {@link FloatArrayAssertion} class test.
     */
    @Test
    public void hasMinSpecifiedDeltaPrimitiveTest() {
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f}).hasMin(1.0f, 0.1f);
        initialize(Raw.floatArrayAssertion(), new float[]{10.0f, 1.0f, 15.0f, 25.0f}).hasMin(1.0f, 0.1f);
        initialize(Raw.floatArrayAssertion(), new float[]{10.0f, 1.0f, 15.0f, 25.0f}).hasMin(0.95f, 0.1f);
        initialize(Raw.floatArrayAssertion(), new float[]{10.0f, 1.0f, 15.0f, 25.0f}).hasMin(1.05f, 0.1f);
        initialize(Raw.floatArrayAssertion(), new float[]{-Float.MAX_VALUE, 100.0f, -100.0f, 100.0f, 100.0f}).hasMin(-Float.MAX_VALUE, 0.1f);
        initialize(Raw.floatArrayAssertion(), new float[]{100.0f, -100.0f, 100.0f, 100.0f, -Float.MAX_VALUE}).hasMin(-Float.MAX_VALUE, 0.1f);
        initialize(Raw.floatArrayAssertion(), new float[]{100.0f, -100.0f, -Float.MAX_VALUE, 100.0f, 100.0f}).hasMin(-Float.MAX_VALUE, 0.1f);
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f}).isNotNull().hasMin(1.0f, 0.1f).isInstanceOf(float[].class);

        try {
            Raw.floatArrayAssertion().hasMin(0.0f, 0.1f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null).hasMin(0.0f, 0.1f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null, "Message").hasMin(0.0f, 0.1f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).hasMin(4.0f, 0.1f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0f±0.1f> but was:<1.0f>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}, "Message").hasMin(4.0f, 0.1f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0f±0.1f> but was:<1.0f>");
        }
    }

    /**
     * {@link FloatArrayAssertion} class test.
     */
    @Test
    public void hasMinSpecifiedDeltaObjectTest() {
        initialize(Raw.floatArrayAssertion(), new float[]{}).hasMin(null, 0.1f);
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f}).hasMin(Float.valueOf(1.0f), 0.1f);
        initialize(Raw.floatArrayAssertion(), new float[]{10.0f, 1.0f, 15.0f, 25.0f}).hasMin(Float.valueOf(1.0f), 0.1f);
        initialize(Raw.floatArrayAssertion(), new float[]{10.0f, 1.0f, 15.0f, 25.0f}).hasMin(Float.valueOf(0.95f), 0.1f);
        initialize(Raw.floatArrayAssertion(), new float[]{10.0f, 1.0f, 15.0f, 25.0f}).hasMin(Float.valueOf(1.05f), 0.1f);
        initialize(Raw.floatArrayAssertion(), new float[]{-Float.MAX_VALUE, 100.0f, -100.0f, 100.0f, 100.0f}).hasMin(Float.valueOf(-Float.MAX_VALUE), 0.1f);
        initialize(Raw.floatArrayAssertion(), new float[]{100.0f, -100.0f, 100.0f, 100.0f, -Float.MAX_VALUE}).hasMin(Float.valueOf(-Float.MAX_VALUE), 0.1f);
        initialize(Raw.floatArrayAssertion(), new float[]{100.0f, -100.0f, -Float.MAX_VALUE, 100.0f, 100.0f}).hasMin(Float.valueOf(-Float.MAX_VALUE), 0.1f);
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f}).isNotNull().hasMin(Float.valueOf(1.0f), 0.1f).isInstanceOf(float[].class);

        try {
            Raw.floatArrayAssertion().hasMin(Float.valueOf(0.0f), 0.1f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null).hasMin(Float.valueOf(0.0f), 0.1f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null, "Message").hasMin(Float.valueOf(0.0f), 0.1f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null).hasMin(null, 0.1f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null, "Message").hasMin(null, 0.1f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f}).hasMin(null, 0.1f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual value should be null.\n\tActual:<1.0f>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f}, "Message").hasMin(null, 0.1f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual value should be null.\n\tActual:<1.0f>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).hasMin(Float.valueOf(4.0f), 0.1f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0f±0.1f> but was:<1.0f>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}, "Message").hasMin(Float.valueOf(4.0f), 0.1f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0f±0.1f> but was:<1.0f>");
        }
    }

    /**
     * {@link FloatArrayAssertion} class test.
     */
    @Test
    public void toMaxTest() {
        initialize(Raw.floatArrayAssertion(), new float[]{}).toMax().isNull();
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f}).toMax().isEqualTo(1.0f);
        initialize(Raw.floatArrayAssertion(), new float[]{10.0f, 1.0f, 15.0f, 25.0f}).toMax().isEqualTo(25.0f);
        initialize(Raw.floatArrayAssertion(), new float[]{Float.MAX_VALUE, 100.0f, -100.0f, 100.0f, 100.0f}).toMax().isEqualTo(Float.MAX_VALUE);
        initialize(Raw.floatArrayAssertion(), new float[]{100.0f, -100.0f, 100.0f, 100.0f, Float.MAX_VALUE}).toMax().isEqualTo(Float.MAX_VALUE);
        initialize(Raw.floatArrayAssertion(), new float[]{100.0f, -100.0f, Float.MAX_VALUE, 100.0f, 100.0f}).toMax().isEqualTo(Float.MAX_VALUE);
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f}).isNotNull().toMax().isEqualTo(1.0f);

        try {
            Raw.floatArrayAssertion().toMax();
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null).toMax();
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null, "Message").toMax();
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).toMax()).isEqualTo(0.0f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}, "Message").toMax()).isEqualTo(0.0f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).toMax().isEqualTo(4.0f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0f±1.0E-5f> but was:<2.0f>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}, "Message").toMax().isEqualTo(4.0f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0f±1.0E-5f> but was:<2.0f>");
        }
    }

    /**
     * {@link FloatArrayAssertion} class test.
     */
    @Test
    public void toMaxMatcherTest() {
        initialize(Raw.floatArrayAssertion(), new float[]{}).toMax(Matchers.nullValue());
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f}).toMax(Matchers.is(Matchers.equalTo(1.0f)));
        initialize(Raw.floatArrayAssertion(), new float[]{10.0f, 1.0f, 15.0f, 25.0f}).toMax(Matchers.is(Matchers.equalTo(25.0f)));
        initialize(Raw.floatArrayAssertion(), new float[]{Float.MAX_VALUE, 100.0f, -100.0f, 100.0f, 100.0f}).toMax(Matchers.is(Matchers.equalTo(Float.MAX_VALUE)));
        initialize(Raw.floatArrayAssertion(), new float[]{100.0f, -100.0f, 100.0f, 100.0f, Float.MAX_VALUE}).toMax(Matchers.is(Matchers.equalTo(Float.MAX_VALUE)));
        initialize(Raw.floatArrayAssertion(), new float[]{100.0f, -100.0f, Float.MAX_VALUE, 100.0f, 100.0f}).toMax(Matchers.is(Matchers.equalTo(Float.MAX_VALUE)));
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f}).isNotNull().toMax(Matchers.is(Matchers.equalTo(1.0f))).isInstanceOf(float[].class);

        try {
            Raw.floatArrayAssertion().toMax(Matchers.equalTo(0.0f));
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null).toMax(Matchers.equalTo(0.0f));
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null, "Message").toMax(Matchers.equalTo(0.0f));
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null).toMax(null);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null, "Message").toMax(null);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{}).toMax(null);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{}, "Message").toMax(null);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).toMax(Matchers.equalTo(4.0f));
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\nExpected: <4.0F>\n     but: was <2.0F>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}, "Message").toMax(Matchers.equalTo(4.0f));
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\nExpected: <4.0F>\n     but: was <2.0F>");
        }
    }

    /**
     * {@link FloatArrayAssertion} class test.
     */
    @Test
    public void hasMaxDefaultDeltaPrimitiveTest() {
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f}).hasMax(1.0f);
        initialize(Raw.floatArrayAssertion(), new float[]{10.0f, 1.0f, 15.0f, 25.0f}).hasMax(25.0f);
        initialize(Raw.floatArrayAssertion(), new float[]{Float.MAX_VALUE, 100.0f, -100.0f, 100.0f, 100.0f}).hasMax(Float.MAX_VALUE);
        initialize(Raw.floatArrayAssertion(), new float[]{100.0f, -100.0f, 100.0f, 100.0f, Float.MAX_VALUE}).hasMax(Float.MAX_VALUE);
        initialize(Raw.floatArrayAssertion(), new float[]{100.0f, -100.0f, Float.MAX_VALUE, 100.0f, 100.0f}).hasMax(Float.MAX_VALUE);
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f}).isNotNull().hasMax(1.0f).isInstanceOf(float[].class);

        try {
            Raw.floatArrayAssertion().hasMax(0.0f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null).hasMax(0.0f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null, "Message").hasMax(0.0f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).hasMax(4.0f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0f±1.0E-5f> but was:<2.0f>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}, "Message").hasMax(4.0f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0f±1.0E-5f> but was:<2.0f>");
        }
    }

    /**
     * {@link FloatArrayAssertion} class test.
     */
    @Test
    public void hasMaxDefaultDeltaObjectTest() {
        initialize(Raw.floatArrayAssertion(), new float[]{}).hasMax(null);
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f}).hasMax(Float.valueOf(1.0f));
        initialize(Raw.floatArrayAssertion(), new float[]{10.0f, 1.0f, 15.0f, 25.0f}).hasMax(Float.valueOf(25.0f));
        initialize(Raw.floatArrayAssertion(), new float[]{Float.MAX_VALUE, 100.0f, -100.0f, 100.0f, 100.0f}).hasMax(Float.valueOf(Float.MAX_VALUE));
        initialize(Raw.floatArrayAssertion(), new float[]{100.0f, -100.0f, 100.0f, 100.0f, Float.MAX_VALUE}).hasMax(Float.valueOf(Float.MAX_VALUE));
        initialize(Raw.floatArrayAssertion(), new float[]{100.0f, -100.0f, Float.MAX_VALUE, 100.0f, 100.0f}).hasMax(Float.valueOf(Float.MAX_VALUE));
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f}).isNotNull().hasMax(Float.valueOf(1.0f)).isInstanceOf(float[].class);

        try {
            Raw.floatArrayAssertion().hasMax(Float.valueOf(0.0f));
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null).hasMax(Float.valueOf(0.0f));
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null, "Message").hasMax(Float.valueOf(0.0f));
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null).hasMax(null);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null, "Message").hasMax(null);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f}).hasMax(null);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual value should be null.\n\tActual:<1.0f>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f}, "Message").hasMax(null);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual value should be null.\n\tActual:<1.0f>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).hasMax(Float.valueOf(4.0f));
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0f±1.0E-5f> but was:<2.0f>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}, "Message").hasMax(Float.valueOf(4.0f));
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0f±1.0E-5f> but was:<2.0f>");
        }
    }

    /**
     * {@link FloatArrayAssertion} class test.
     */
    @Test
    public void hasMaxSpecifiedDeltaPrimitiveTest() {
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f}).hasMax(1.0f, 0.1f);
        initialize(Raw.floatArrayAssertion(), new float[]{10.0f, 1.0f, 15.0f, 25.0f}).hasMax(25.0f, 0.1f);
        initialize(Raw.floatArrayAssertion(), new float[]{10.0f, 1.0f, 15.0f, 25.0f}).hasMax(24.95f, 0.1f);
        initialize(Raw.floatArrayAssertion(), new float[]{10.0f, 1.0f, 15.0f, 25.0f}).hasMax(25.05f, 0.1f);
        initialize(Raw.floatArrayAssertion(), new float[]{Float.MAX_VALUE, 100.0f, -100.0f, 100.0f, 100.0f}).hasMax(Float.MAX_VALUE, 0.1f);
        initialize(Raw.floatArrayAssertion(), new float[]{100.0f, -100.0f, 100.0f, 100.0f, Float.MAX_VALUE}).hasMax(Float.MAX_VALUE, 0.1f);
        initialize(Raw.floatArrayAssertion(), new float[]{100.0f, -100.0f, Float.MAX_VALUE, 100.0f, 100.0f}).hasMax(Float.MAX_VALUE, 0.1f);
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f}).isNotNull().hasMax(1.0f, 0.1f).isInstanceOf(float[].class);

        try {
            Raw.floatArrayAssertion().hasMax(0.0f, 0.1f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null).hasMax(0.0f, 0.1f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null, "Message").hasMax(0.0f, 0.1f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).hasMax(4.0f, 0.1f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0f±0.1f> but was:<2.0f>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}, "Message").hasMax(4.0f, 0.1f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0f±0.1f> but was:<2.0f>");
        }
    }

    /**
     * {@link FloatArrayAssertion} class test.
     */
    @Test
    public void hasMaxSpecifiedDeltaObjectTest() {
        initialize(Raw.floatArrayAssertion(), new float[]{}).hasMax(null, 0.1f);
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f}).hasMax(Float.valueOf(1.0f), 0.1f);
        initialize(Raw.floatArrayAssertion(), new float[]{10.0f, 1.0f, 15.0f, 25.0f}).hasMax(Float.valueOf(25.0f), 0.1f);
        initialize(Raw.floatArrayAssertion(), new float[]{10.0f, 1.0f, 15.0f, 25.0f}).hasMax(Float.valueOf(24.95f), 0.1f);
        initialize(Raw.floatArrayAssertion(), new float[]{10.0f, 1.0f, 15.0f, 25.0f}).hasMax(Float.valueOf(25.05f), 0.1f);
        initialize(Raw.floatArrayAssertion(), new float[]{Float.MAX_VALUE, 100.0f, -100.0f, 100.0f, 100.0f}).hasMax(Float.valueOf(Float.MAX_VALUE), 0.1f);
        initialize(Raw.floatArrayAssertion(), new float[]{100.0f, -100.0f, 100.0f, 100.0f, Float.MAX_VALUE}).hasMax(Float.valueOf(Float.MAX_VALUE), 0.1f);
        initialize(Raw.floatArrayAssertion(), new float[]{100.0f, -100.0f, Float.MAX_VALUE, 100.0f, 100.0f}).hasMax(Float.valueOf(Float.MAX_VALUE), 0.1f);
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f}).isNotNull().hasMax(Float.valueOf(1.0f), 0.1f).isInstanceOf(float[].class);

        try {
            Raw.floatArrayAssertion().hasMax(Float.valueOf(0.0f), 0.1f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null).hasMax(Float.valueOf(0.0f), 0.1f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null, "Message").hasMax(Float.valueOf(0.0f), 0.1f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null).hasMax(null, 0.1f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null, "Message").hasMax(null, 0.1f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f}).hasMax(null, 0.1f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual value should be null.\n\tActual:<1.0f>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f}, "Message").hasMax(null, 0.1f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual value should be null.\n\tActual:<1.0f>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).hasMax(Float.valueOf(4.0f), 0.1f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0f±0.1f> but was:<2.0f>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}, "Message").hasMax(Float.valueOf(4.0f), 0.1f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0f±0.1f> but was:<2.0f>");
        }
    }

}
