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
package ru.d_shap.assertions.asimp.java.nio;

import java.nio.FloatBuffer;

import org.hamcrest.Matchers;
import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link FloatBufferAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class FloatBufferAggregateAssertionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public FloatBufferAggregateAssertionTest() {
        super();
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void toMinTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{})).toMin().isNull();
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f})).toMin().isEqualTo(1.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{10.0f, 1.0f, 15.0f, 25.0f})).toMin().isEqualTo(1.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{-Float.MAX_VALUE, 100.0f, -100.0f, 100.0f, 100.0f})).toMin().isEqualTo(-Float.MAX_VALUE);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{100.0f, -100.0f, 100.0f, 100.0f, -Float.MAX_VALUE})).toMin().isEqualTo(-Float.MAX_VALUE);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{100.0f, -100.0f, -Float.MAX_VALUE, 100.0f, 100.0f})).toMin().isEqualTo(-Float.MAX_VALUE);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 10.0f, 2.0f, 15.0f, 25.0f}, 1)).toMin().isEqualTo(2.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 10.0f, 2.0f, 15.0f, 25.0f}, 2)).toMin().isEqualTo(2.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 10.0f, 2.0f, 15.0f, 25.0f}, 3)).toMin().isEqualTo(15.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f})).isNotNull().toMin().isEqualTo(1.0f);

        try {
            Raw.floatBufferAssertion().toMin();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).toMin();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").toMin();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).toMin()).isEqualTo(0.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").toMin()).isEqualTo(0.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).toMin().isEqualTo(4.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0f±1.0E-5f> but was:<1.0f>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").toMin().isEqualTo(4.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0f±1.0E-5f> but was:<1.0f>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}, 1)).toMin().isEqualTo(4.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0f±1.0E-5f> but was:<2.0f>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}, 1), "Message").toMin().isEqualTo(4.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0f±1.0E-5f> but was:<2.0f>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void toMinMatcherTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{})).toMin(Matchers.nullValue());
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f})).toMin(Matchers.is(Matchers.equalTo(1.0f)));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{10.0f, 1.0f, 15.0f, 25.0f})).toMin(Matchers.is(Matchers.equalTo(1.0f)));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{-Float.MAX_VALUE, 100.0f, -100.0f, 100.0f, 100.0f})).toMin(Matchers.is(Matchers.equalTo(-Float.MAX_VALUE)));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{100.0f, -100.0f, 100.0f, 100.0f, -Float.MAX_VALUE})).toMin(Matchers.is(Matchers.equalTo(-Float.MAX_VALUE)));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{100.0f, -100.0f, -Float.MAX_VALUE, 100.0f, 100.0f})).toMin(Matchers.is(Matchers.equalTo(-Float.MAX_VALUE)));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 10.0f, 2.0f, 15.0f, 25.0f}, 1)).toMin(Matchers.is(Matchers.equalTo(2.0f)));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 10.0f, 2.0f, 15.0f, 25.0f}, 2)).toMin(Matchers.is(Matchers.equalTo(2.0f)));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 10.0f, 2.0f, 15.0f, 25.0f}, 3)).toMin(Matchers.is(Matchers.equalTo(15.0f)));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f})).isNotNull().toMin(Matchers.is(Matchers.equalTo(1.0f))).isInstanceOf(FloatBuffer.class);

        try {
            Raw.floatBufferAssertion().toMin(Matchers.equalTo(0.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).toMin(Matchers.equalTo(0.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").toMin(Matchers.equalTo(0.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).toMin(null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").toMin(null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{})).toMin(null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{}), "Message").toMin(null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).toMin(Matchers.equalTo(4.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\nExpected: <4.0F>\n     but: was <1.0F>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").toMin(Matchers.equalTo(4.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\nExpected: <4.0F>\n     but: was <1.0F>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}, 1)).toMin(Matchers.equalTo(4.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\nExpected: <4.0F>\n     but: was <2.0F>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}, 1), "Message").toMin(Matchers.equalTo(4.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\nExpected: <4.0F>\n     but: was <2.0F>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void toRewindAndMinTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{})).toRewindAndMin().isNull();
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f})).toRewindAndMin().isEqualTo(1.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{10.0f, 1.0f, 15.0f, 25.0f})).toRewindAndMin().isEqualTo(1.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{-Float.MAX_VALUE, 100.0f, -100.0f, 100.0f, 100.0f})).toRewindAndMin().isEqualTo(-Float.MAX_VALUE);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{100.0f, -100.0f, 100.0f, 100.0f, -Float.MAX_VALUE})).toRewindAndMin().isEqualTo(-Float.MAX_VALUE);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{100.0f, -100.0f, -Float.MAX_VALUE, 100.0f, 100.0f})).toRewindAndMin().isEqualTo(-Float.MAX_VALUE);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 10.0f, 2.0f, 15.0f, 25.0f}, 1)).toRewindAndMin().isEqualTo(1.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 10.0f, 2.0f, 15.0f, 25.0f}, 2)).toRewindAndMin().isEqualTo(1.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 10.0f, 2.0f, 15.0f, 25.0f}, 3)).toRewindAndMin().isEqualTo(1.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f})).isNotNull().toRewindAndMin().isEqualTo(1.0f);

        try {
            Raw.floatBufferAssertion().toRewindAndMin();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).toRewindAndMin();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").toRewindAndMin();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).toRewindAndMin()).isEqualTo(0.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").toRewindAndMin()).isEqualTo(0.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).toRewindAndMin().isEqualTo(4.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0f±1.0E-5f> but was:<1.0f>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").toRewindAndMin().isEqualTo(4.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0f±1.0E-5f> but was:<1.0f>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}, 1)).toRewindAndMin().isEqualTo(4.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0f±1.0E-5f> but was:<1.0f>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}, 1), "Message").toRewindAndMin().isEqualTo(4.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0f±1.0E-5f> but was:<1.0f>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void toRewindAndMinMatcherTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{})).toRewindAndMin(Matchers.nullValue());
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f})).toRewindAndMin(Matchers.is(Matchers.equalTo(1.0f)));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{10.0f, 1.0f, 15.0f, 25.0f})).toRewindAndMin(Matchers.is(Matchers.equalTo(1.0f)));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{-Float.MAX_VALUE, 100.0f, -100.0f, 100.0f, 100.0f})).toRewindAndMin(Matchers.is(Matchers.equalTo(-Float.MAX_VALUE)));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{100.0f, -100.0f, 100.0f, 100.0f, -Float.MAX_VALUE})).toRewindAndMin(Matchers.is(Matchers.equalTo(-Float.MAX_VALUE)));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{100.0f, -100.0f, -Float.MAX_VALUE, 100.0f, 100.0f})).toRewindAndMin(Matchers.is(Matchers.equalTo(-Float.MAX_VALUE)));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 10.0f, 2.0f, 15.0f, 25.0f}, 1)).toRewindAndMin(Matchers.is(Matchers.equalTo(1.0f)));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 10.0f, 2.0f, 15.0f, 25.0f}, 2)).toRewindAndMin(Matchers.is(Matchers.equalTo(1.0f)));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 10.0f, 2.0f, 15.0f, 25.0f}, 3)).toRewindAndMin(Matchers.is(Matchers.equalTo(1.0f)));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f})).isNotNull().toRewindAndMin(Matchers.is(Matchers.equalTo(1.0f))).isInstanceOf(FloatBuffer.class);

        try {
            Raw.floatBufferAssertion().toRewindAndMin(Matchers.equalTo(0.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).toRewindAndMin(Matchers.equalTo(0.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").toRewindAndMin(Matchers.equalTo(0.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).toRewindAndMin(null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").toRewindAndMin(null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{})).toRewindAndMin(null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{}), "Message").toRewindAndMin(null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).toRewindAndMin(Matchers.equalTo(4.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\nExpected: <4.0F>\n     but: was <1.0F>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").toRewindAndMin(Matchers.equalTo(4.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\nExpected: <4.0F>\n     but: was <1.0F>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}, 1)).toRewindAndMin(Matchers.equalTo(4.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\nExpected: <4.0F>\n     but: was <1.0F>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}, 1), "Message").toRewindAndMin(Matchers.equalTo(4.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\nExpected: <4.0F>\n     but: was <1.0F>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void hasMinPrimitiveTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f})).hasMin(1.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{10.0f, 1.0f, 15.0f, 25.0f})).hasMin(1.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{-Float.MAX_VALUE, 100.0f, -100.0f, 100.0f, 100.0f})).hasMin(-Float.MAX_VALUE);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{100.0f, -100.0f, 100.0f, 100.0f, -Float.MAX_VALUE})).hasMin(-Float.MAX_VALUE);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{100.0f, -100.0f, -Float.MAX_VALUE, 100.0f, 100.0f})).hasMin(-Float.MAX_VALUE);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 10.0f, 2.0f, 15.0f, 25.0f}, 1)).hasMin(2.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 10.0f, 2.0f, 15.0f, 25.0f}, 2)).hasMin(2.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 10.0f, 2.0f, 15.0f, 25.0f}, 3)).hasMin(15.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f})).isNotNull().hasMin(1.0f).isInstanceOf(FloatBuffer.class);

        try {
            Raw.floatBufferAssertion().hasMin(0.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).hasMin(0.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").hasMin(0.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).hasMin(4.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0f±1.0E-5f> but was:<1.0f>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").hasMin(4.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0f±1.0E-5f> but was:<1.0f>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}, 1)).hasMin(4.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0f±1.0E-5f> but was:<2.0f>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}, 1), "Message").hasMin(4.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0f±1.0E-5f> but was:<2.0f>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void hasMinObjectTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{})).hasMin(null);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f})).hasMin(Float.valueOf(1.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{10.0f, 1.0f, 15.0f, 25.0f})).hasMin(Float.valueOf(1.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{-Float.MAX_VALUE, 100.0f, -100.0f, 100.0f, 100.0f})).hasMin(Float.valueOf(-Float.MAX_VALUE));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{100.0f, -100.0f, 100.0f, 100.0f, -Float.MAX_VALUE})).hasMin(Float.valueOf(-Float.MAX_VALUE));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{100.0f, -100.0f, -Float.MAX_VALUE, 100.0f, 100.0f})).hasMin(Float.valueOf(-Float.MAX_VALUE));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 10.0f, 2.0f, 15.0f, 25.0f}, 1)).hasMin(Float.valueOf(2.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 10.0f, 2.0f, 15.0f, 25.0f}, 2)).hasMin(Float.valueOf(2.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 10.0f, 2.0f, 15.0f, 25.0f}, 3)).hasMin(Float.valueOf(15.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f})).isNotNull().hasMin(Float.valueOf(1.0f)).isInstanceOf(FloatBuffer.class);

        try {
            Raw.floatBufferAssertion().hasMin(Float.valueOf(0.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).hasMin(Float.valueOf(0.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").hasMin(Float.valueOf(0.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).hasMin(null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").hasMin(null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f})).hasMin(null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual value should be null.\n\tActual:<1.0f>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f}), "Message").hasMin(null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual value should be null.\n\tActual:<1.0f>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).hasMin(Float.valueOf(4.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0f±1.0E-5f> but was:<1.0f>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").hasMin(Float.valueOf(4.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0f±1.0E-5f> but was:<1.0f>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}, 1)).hasMin(Float.valueOf(4.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0f±1.0E-5f> but was:<2.0f>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}, 1), "Message").hasMin(Float.valueOf(4.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0f±1.0E-5f> but was:<2.0f>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void hasRewindAndMinPrimitiveTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f})).hasRewindAndMin(1.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{10.0f, 1.0f, 15.0f, 25.0f})).hasRewindAndMin(1.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{-Float.MAX_VALUE, 100.0f, -100.0f, 100.0f, 100.0f})).hasRewindAndMin(-Float.MAX_VALUE);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{100.0f, -100.0f, 100.0f, 100.0f, -Float.MAX_VALUE})).hasRewindAndMin(-Float.MAX_VALUE);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{100.0f, -100.0f, -Float.MAX_VALUE, 100.0f, 100.0f})).hasRewindAndMin(-Float.MAX_VALUE);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 10.0f, 2.0f, 15.0f, 25.0f}, 1)).hasRewindAndMin(1.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 10.0f, 2.0f, 15.0f, 25.0f}, 2)).hasRewindAndMin(1.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 10.0f, 2.0f, 15.0f, 25.0f}, 3)).hasRewindAndMin(1.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f})).isNotNull().hasRewindAndMin(1.0f).isInstanceOf(FloatBuffer.class);

        try {
            Raw.floatBufferAssertion().hasRewindAndMin(0.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).hasRewindAndMin(0.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").hasRewindAndMin(0.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).hasRewindAndMin(4.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0f±1.0E-5f> but was:<1.0f>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").hasRewindAndMin(4.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0f±1.0E-5f> but was:<1.0f>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}, 1)).hasRewindAndMin(4.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0f±1.0E-5f> but was:<1.0f>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}, 1), "Message").hasRewindAndMin(4.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0f±1.0E-5f> but was:<1.0f>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void hasRewindAndMinObjectTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{})).hasRewindAndMin(null);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f})).hasRewindAndMin(Float.valueOf(1.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{10.0f, 1.0f, 15.0f, 25.0f})).hasRewindAndMin(Float.valueOf(1.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{-Float.MAX_VALUE, 100.0f, -100.0f, 100.0f, 100.0f})).hasRewindAndMin(Float.valueOf(-Float.MAX_VALUE));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{100.0f, -100.0f, 100.0f, 100.0f, -Float.MAX_VALUE})).hasRewindAndMin(Float.valueOf(-Float.MAX_VALUE));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{100.0f, -100.0f, -Float.MAX_VALUE, 100.0f, 100.0f})).hasRewindAndMin(Float.valueOf(-Float.MAX_VALUE));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 10.0f, 2.0f, 15.0f, 25.0f}, 1)).hasRewindAndMin(Float.valueOf(1.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 10.0f, 2.0f, 15.0f, 25.0f}, 2)).hasRewindAndMin(Float.valueOf(1.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 10.0f, 2.0f, 15.0f, 25.0f}, 3)).hasRewindAndMin(Float.valueOf(1.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f})).isNotNull().hasRewindAndMin(Float.valueOf(1.0f)).isInstanceOf(FloatBuffer.class);

        try {
            Raw.floatBufferAssertion().hasRewindAndMin(Float.valueOf(0.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).hasRewindAndMin(Float.valueOf(0.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").hasRewindAndMin(Float.valueOf(0.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).hasRewindAndMin(null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").hasRewindAndMin(null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f})).hasRewindAndMin(null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual value should be null.\n\tActual:<1.0f>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f}), "Message").hasRewindAndMin(null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual value should be null.\n\tActual:<1.0f>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).hasRewindAndMin(Float.valueOf(4.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0f±1.0E-5f> but was:<1.0f>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").hasRewindAndMin(Float.valueOf(4.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0f±1.0E-5f> but was:<1.0f>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}, 1)).hasRewindAndMin(Float.valueOf(4.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0f±1.0E-5f> but was:<1.0f>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}, 1), "Message").hasRewindAndMin(Float.valueOf(4.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0f±1.0E-5f> but was:<1.0f>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void toMaxTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{})).toMax().isNull();
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f})).toMax().isEqualTo(1.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{15.0f, 25.0f, 10.0f, 1.0f})).toMax().isEqualTo(25.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{Float.MAX_VALUE, 100.0f, -100.0f, 100.0f, 100.0f})).toMax().isEqualTo(Float.MAX_VALUE);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{100.0f, -100.0f, 100.0f, 100.0f, Float.MAX_VALUE})).toMax().isEqualTo(Float.MAX_VALUE);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{100.0f, -100.0f, Float.MAX_VALUE, 100.0f, 100.0f})).toMax().isEqualTo(Float.MAX_VALUE);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{30.0f, 15.0f, 25.0f, 10.0f, 1.0f}, 1)).toMax().isEqualTo(25.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{30.0f, 15.0f, 25.0f, 10.0f, 1.0f}, 2)).toMax().isEqualTo(25.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{30.0f, 15.0f, 25.0f, 10.0f, 1.0f}, 3)).toMax().isEqualTo(10.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f})).isNotNull().toMax().isEqualTo(1.0f);

        try {
            Raw.floatBufferAssertion().toMax();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).toMax();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").toMax();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{2.0f, 1.0f})).toMax()).isEqualTo(0.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{2.0f, 1.0f}), "Message").toMax()).isEqualTo(0.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{2.0f, 1.0f})).toMax().isEqualTo(4.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0f±1.0E-5f> but was:<2.0f>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{2.0f, 1.0f}), "Message").toMax().isEqualTo(4.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0f±1.0E-5f> but was:<2.0f>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{2.0f, 1.0f}, 1)).toMax().isEqualTo(4.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0f±1.0E-5f> but was:<1.0f>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{2.0f, 1.0f}, 1), "Message").toMax().isEqualTo(4.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0f±1.0E-5f> but was:<1.0f>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void toMaxMatcherTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{})).toMax(Matchers.nullValue());
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f})).toMax(Matchers.is(Matchers.equalTo(1.0f)));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{15.0f, 25.0f, 10.0f, 1.0f})).toMax(Matchers.is(Matchers.equalTo(25.0f)));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{Float.MAX_VALUE, 100.0f, -100.0f, 100.0f, 100.0f})).toMax(Matchers.is(Matchers.equalTo(Float.MAX_VALUE)));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{100.0f, -100.0f, 100.0f, 100.0f, Float.MAX_VALUE})).toMax(Matchers.is(Matchers.equalTo(Float.MAX_VALUE)));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{100.0f, -100.0f, Float.MAX_VALUE, 100.0f, 100.0f})).toMax(Matchers.is(Matchers.equalTo(Float.MAX_VALUE)));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{30.0f, 15.0f, 25.0f, 10.0f, 1.0f}, 1)).toMax(Matchers.is(Matchers.equalTo(25.0f)));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{30.0f, 15.0f, 25.0f, 10.0f, 1.0f}, 2)).toMax(Matchers.is(Matchers.equalTo(25.0f)));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{30.0f, 15.0f, 25.0f, 10.0f, 1.0f}, 3)).toMax(Matchers.is(Matchers.equalTo(10.0f)));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f})).isNotNull().toMax(Matchers.is(Matchers.equalTo(1.0f))).isInstanceOf(FloatBuffer.class);

        try {
            Raw.floatBufferAssertion().toMax(Matchers.equalTo(0.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).toMax(Matchers.equalTo(0.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").toMax(Matchers.equalTo(0.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).toMax(null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").toMax(null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{})).toMax(null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{}), "Message").toMax(null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{2.0f, 1.0f})).toMax(Matchers.equalTo(4.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\nExpected: <4.0F>\n     but: was <2.0F>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{2.0f, 1.0f}), "Message").toMax(Matchers.equalTo(4.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\nExpected: <4.0F>\n     but: was <2.0F>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{2.0f, 1.0f}, 1)).toMax(Matchers.equalTo(4.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\nExpected: <4.0F>\n     but: was <1.0F>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{2.0f, 1.0f}, 1), "Message").toMax(Matchers.equalTo(4.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\nExpected: <4.0F>\n     but: was <1.0F>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void toRewindAndMaxTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{})).toRewindAndMax().isNull();
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f})).toRewindAndMax().isEqualTo(1.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{15.0f, 25.0f, 10.0f, 1.0f})).toRewindAndMax().isEqualTo(25.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{Float.MAX_VALUE, 100.0f, -100.0f, 100.0f, 100.0f})).toRewindAndMax().isEqualTo(Float.MAX_VALUE);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{100.0f, -100.0f, 100.0f, 100.0f, Float.MAX_VALUE})).toRewindAndMax().isEqualTo(Float.MAX_VALUE);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{100.0f, -100.0f, Float.MAX_VALUE, 100.0f, 100.0f})).toRewindAndMax().isEqualTo(Float.MAX_VALUE);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{30.0f, 15.0f, 25.0f, 10.0f, 1.0f}, 1)).toRewindAndMax().isEqualTo(30.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{30.0f, 15.0f, 25.0f, 10.0f, 1.0f}, 2)).toRewindAndMax().isEqualTo(30.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{30.0f, 15.0f, 25.0f, 10.0f, 1.0f}, 3)).toRewindAndMax().isEqualTo(30.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f})).isNotNull().toRewindAndMax().isEqualTo(1.0f);

        try {
            Raw.floatBufferAssertion().toRewindAndMax();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).toRewindAndMax();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").toRewindAndMax();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{2.0f, 1.0f})).toRewindAndMax()).isEqualTo(0.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{2.0f, 1.0f}), "Message").toRewindAndMax()).isEqualTo(0.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{2.0f, 1.0f})).toRewindAndMax().isEqualTo(4.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0f±1.0E-5f> but was:<2.0f>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{2.0f, 1.0f}), "Message").toRewindAndMax().isEqualTo(4.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0f±1.0E-5f> but was:<2.0f>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{2.0f, 1.0f}, 1)).toRewindAndMax().isEqualTo(4.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0f±1.0E-5f> but was:<2.0f>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{2.0f, 1.0f}, 1), "Message").toRewindAndMax().isEqualTo(4.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0f±1.0E-5f> but was:<2.0f>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void toRewindAndMaxMatcherTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{})).toRewindAndMax(Matchers.nullValue());
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f})).toRewindAndMax(Matchers.is(Matchers.equalTo(1.0f)));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{15.0f, 25.0f, 10.0f, 1.0f})).toRewindAndMax(Matchers.is(Matchers.equalTo(25.0f)));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{Float.MAX_VALUE, 100.0f, -100.0f, 100.0f, 100.0f})).toRewindAndMax(Matchers.is(Matchers.equalTo(Float.MAX_VALUE)));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{100.0f, -100.0f, 100.0f, 100.0f, Float.MAX_VALUE})).toRewindAndMax(Matchers.is(Matchers.equalTo(Float.MAX_VALUE)));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{100.0f, -100.0f, Float.MAX_VALUE, 100.0f, 100.0f})).toRewindAndMax(Matchers.is(Matchers.equalTo(Float.MAX_VALUE)));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{30.0f, 15.0f, 25.0f, 10.0f, 1.0f}, 1)).toRewindAndMax(Matchers.is(Matchers.equalTo(30.0f)));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{30.0f, 15.0f, 25.0f, 10.0f, 1.0f}, 2)).toRewindAndMax(Matchers.is(Matchers.equalTo(30.0f)));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{30.0f, 15.0f, 25.0f, 10.0f, 1.0f}, 3)).toRewindAndMax(Matchers.is(Matchers.equalTo(30.0f)));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f})).isNotNull().toRewindAndMax(Matchers.is(Matchers.equalTo(1.0f))).isInstanceOf(FloatBuffer.class);

        try {
            Raw.floatBufferAssertion().toRewindAndMax(Matchers.equalTo(0.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).toRewindAndMax(Matchers.equalTo(0.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").toRewindAndMax(Matchers.equalTo(0.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).toRewindAndMax(null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").toRewindAndMax(null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f})).toRewindAndMax(null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f}), "Message").toRewindAndMax(null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{2.0f, 1.0f})).toRewindAndMax(Matchers.equalTo(4.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\nExpected: <4.0F>\n     but: was <2.0F>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{2.0f, 1.0f}), "Message").toRewindAndMax(Matchers.equalTo(4.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\nExpected: <4.0F>\n     but: was <2.0F>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{2.0f, 1.0f}, 1)).toRewindAndMax(Matchers.equalTo(4.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\nExpected: <4.0F>\n     but: was <2.0F>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{2.0f, 1.0f}, 1), "Message").toRewindAndMax(Matchers.equalTo(4.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\nExpected: <4.0F>\n     but: was <2.0F>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void hasMaxPrimitiveTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f})).hasMax(1.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{15.0f, 25.0f, 10.0f, 1.0f})).hasMax(25.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{Float.MAX_VALUE, 100.0f, -100.0f, 100.0f, 100.0f})).hasMax(Float.MAX_VALUE);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{100.0f, -100.0f, 100.0f, 100.0f, Float.MAX_VALUE})).hasMax(Float.MAX_VALUE);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{100.0f, -100.0f, Float.MAX_VALUE, 100.0f, 100.0f})).hasMax(Float.MAX_VALUE);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{30.0f, 15.0f, 25.0f, 10.0f, 1.0f}, 1)).hasMax(25.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{30.0f, 15.0f, 25.0f, 10.0f, 1.0f}, 2)).hasMax(25.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{30.0f, 15.0f, 25.0f, 10.0f, 1.0f}, 3)).hasMax(10.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f})).isNotNull().hasMax(1.0f).isInstanceOf(FloatBuffer.class);

        try {
            Raw.floatBufferAssertion().hasMax(0.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).hasMax(0.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").hasMax(0.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{2.0f, 1.0f})).hasMax(4.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0f±1.0E-5f> but was:<2.0f>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{2.0f, 1.0f}), "Message").hasMax(4.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0f±1.0E-5f> but was:<2.0f>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{2.0f, 1.0f}, 1)).hasMax(4.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0f±1.0E-5f> but was:<1.0f>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{2.0f, 1.0f}, 1), "Message").hasMax(4.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0f±1.0E-5f> but was:<1.0f>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void hasMaxObjectTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{})).hasMax(null);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f})).hasMax(Float.valueOf(1.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{15.0f, 25.0f, 10.0f, 1.0f})).hasMax(Float.valueOf(25.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{Float.MAX_VALUE, 100.0f, -100.0f, 100.0f, 100.0f})).hasMax(Float.valueOf(Float.MAX_VALUE));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{100.0f, -100.0f, 100.0f, 100.0f, Float.MAX_VALUE})).hasMax(Float.valueOf(Float.MAX_VALUE));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{100.0f, -100.0f, Float.MAX_VALUE, 100.0f, 100.0f})).hasMax(Float.valueOf(Float.MAX_VALUE));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{30.0f, 15.0f, 25.0f, 10.0f, 1.0f}, 1)).hasMax(Float.valueOf(25.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{30.0f, 15.0f, 25.0f, 10.0f, 1.0f}, 2)).hasMax(Float.valueOf(25.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{30.0f, 15.0f, 25.0f, 10.0f, 1.0f}, 3)).hasMax(Float.valueOf(10.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f})).isNotNull().hasMax(Float.valueOf(1.0f)).isInstanceOf(FloatBuffer.class);

        try {
            Raw.floatBufferAssertion().hasMax(Float.valueOf(0.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).hasMax(Float.valueOf(0.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").hasMax(Float.valueOf(0.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).hasMax(null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").hasMax(null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f})).hasMax(null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual value should be null.\n\tActual:<1.0f>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f}), "Message").hasMax(null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual value should be null.\n\tActual:<1.0f>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{2.0f, 1.0f})).hasMax(Float.valueOf(4.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0f±1.0E-5f> but was:<2.0f>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{2.0f, 1.0f}), "Message").hasMax(Float.valueOf(4.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0f±1.0E-5f> but was:<2.0f>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{2.0f, 1.0f}, 1)).hasMax(Float.valueOf(4.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0f±1.0E-5f> but was:<1.0f>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{2.0f, 1.0f}, 1), "Message").hasMax(Float.valueOf(4.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0f±1.0E-5f> but was:<1.0f>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void hasRewindAndMaxPrimitiveTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f})).hasRewindAndMax(1.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{15.0f, 25.0f, 10.0f, 1.0f})).hasRewindAndMax(25.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{Float.MAX_VALUE, 100.0f, -100.0f, 100.0f, 100.0f})).hasRewindAndMax(Float.MAX_VALUE);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{100.0f, -100.0f, 100.0f, 100.0f, Float.MAX_VALUE})).hasRewindAndMax(Float.MAX_VALUE);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{100.0f, -100.0f, Float.MAX_VALUE, 100.0f, 100.0f})).hasRewindAndMax(Float.MAX_VALUE);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{30.0f, 15.0f, 25.0f, 10.0f, 1.0f}, 1)).hasRewindAndMax(30.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{30.0f, 15.0f, 25.0f, 10.0f, 1.0f}, 2)).hasRewindAndMax(30.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{30.0f, 15.0f, 25.0f, 10.0f, 1.0f}, 3)).hasRewindAndMax(30.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f})).isNotNull().hasRewindAndMax(1.0f).isInstanceOf(FloatBuffer.class);

        try {
            Raw.floatBufferAssertion().hasRewindAndMax(0.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).hasRewindAndMax(0.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").hasRewindAndMax(0.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{2.0f, 1.0f})).hasRewindAndMax(4.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0f±1.0E-5f> but was:<2.0f>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{2.0f, 1.0f}), "Message").hasRewindAndMax(4.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0f±1.0E-5f> but was:<2.0f>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{2.0f, 1.0f}, 1)).hasRewindAndMax(4.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0f±1.0E-5f> but was:<2.0f>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{2.0f, 1.0f}, 1), "Message").hasRewindAndMax(4.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0f±1.0E-5f> but was:<2.0f>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void hasRewindAndMaxObjectTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{})).hasRewindAndMax(null);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f})).hasRewindAndMax(Float.valueOf(1.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{15.0f, 25.0f, 10.0f, 1.0f})).hasRewindAndMax(Float.valueOf(25.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{Float.MAX_VALUE, 100.0f, -100.0f, 100.0f, 100.0f})).hasRewindAndMax(Float.valueOf(Float.MAX_VALUE));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{100.0f, -100.0f, 100.0f, 100.0f, Float.MAX_VALUE})).hasRewindAndMax(Float.valueOf(Float.MAX_VALUE));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{100.0f, -100.0f, Float.MAX_VALUE, 100.0f, 100.0f})).hasRewindAndMax(Float.valueOf(Float.MAX_VALUE));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{30.0f, 15.0f, 25.0f, 10.0f, 1.0f}, 1)).hasRewindAndMax(Float.valueOf(30.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{30.0f, 15.0f, 25.0f, 10.0f, 1.0f}, 2)).hasRewindAndMax(Float.valueOf(30.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{30.0f, 15.0f, 25.0f, 10.0f, 1.0f}, 3)).hasRewindAndMax(Float.valueOf(30.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f})).isNotNull().hasRewindAndMax(Float.valueOf(1.0f)).isInstanceOf(FloatBuffer.class);

        try {
            Raw.floatBufferAssertion().hasRewindAndMax(Float.valueOf(0.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).hasRewindAndMax(Float.valueOf(0.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").hasRewindAndMax(Float.valueOf(0.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).hasRewindAndMax(null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").hasRewindAndMax(null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f})).hasRewindAndMax(null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual value should be null.\n\tActual:<1.0f>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f}), "Message").hasRewindAndMax(null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual value should be null.\n\tActual:<1.0f>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{2.0f, 1.0f})).hasRewindAndMax(Float.valueOf(4.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0f±1.0E-5f> but was:<2.0f>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{2.0f, 1.0f}), "Message").hasRewindAndMax(Float.valueOf(4.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0f±1.0E-5f> but was:<2.0f>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{2.0f, 1.0f}, 1)).hasRewindAndMax(Float.valueOf(4.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0f±1.0E-5f> but was:<2.0f>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{2.0f, 1.0f}, 1), "Message").hasRewindAndMax(Float.valueOf(4.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0f±1.0E-5f> but was:<2.0f>");
        }
    }

}
