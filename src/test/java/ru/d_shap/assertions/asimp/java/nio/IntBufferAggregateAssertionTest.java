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

import java.nio.IntBuffer;

import org.hamcrest.Matchers;
import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link IntBufferAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class IntBufferAggregateAssertionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public IntBufferAggregateAssertionTest() {
        super();
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void toMinTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{})).toMin().isNull();
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1})).toMin().isEqualTo(1);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{10, 1, 15, 25})).toMin().isEqualTo(1);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{Integer.MIN_VALUE, 100, -100, 100, 100})).toMin().isEqualTo(Integer.MIN_VALUE);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{100, -100, 100, 100, Integer.MIN_VALUE})).toMin().isEqualTo(Integer.MIN_VALUE);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{100, -100, Integer.MIN_VALUE, 100, 100})).toMin().isEqualTo(Integer.MIN_VALUE);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 10, 2, 15, 25}, 1)).toMin().isEqualTo(2);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 10, 2, 15, 25}, 2)).toMin().isEqualTo(2);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 10, 2, 15, 25}, 3)).toMin().isEqualTo(15);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1})).isNotNull().toMin().isEqualTo(1);

        try {
            Raw.intBufferAssertion().toMin();
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).toMin();
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").toMin();
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toMin()).isEqualTo(0);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").toMin()).isEqualTo(0);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toMin().isEqualTo(4);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<1>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").toMin().isEqualTo(4);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<1>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}, 1)).toMin().isEqualTo(4);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<2>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}, 1), "Message").toMin().isEqualTo(4);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<2>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void toMinMatcherTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{})).toMin(Matchers.nullValue());
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1})).toMin(Matchers.is(Matchers.equalTo(1)));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{10, 1, 15, 25})).toMin(Matchers.is(Matchers.equalTo(1)));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{Integer.MIN_VALUE, 100, -100, 100, 100})).toMin(Matchers.is(Matchers.equalTo(Integer.MIN_VALUE)));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{100, -100, 100, 100, Integer.MIN_VALUE})).toMin(Matchers.is(Matchers.equalTo(Integer.MIN_VALUE)));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{100, -100, Integer.MIN_VALUE, 100, 100})).toMin(Matchers.is(Matchers.equalTo(Integer.MIN_VALUE)));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 10, 2, 15, 25}, 1)).toMin(Matchers.is(Matchers.equalTo(2)));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 10, 2, 15, 25}, 2)).toMin(Matchers.is(Matchers.equalTo(2)));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 10, 2, 15, 25}, 3)).toMin(Matchers.is(Matchers.equalTo(15)));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1})).isNotNull().toMin(Matchers.is(Matchers.equalTo(1))).isInstanceOf(IntBuffer.class);

        try {
            Raw.intBufferAssertion().toMin(Matchers.equalTo(0));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).toMin(Matchers.equalTo(0));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").toMin(Matchers.equalTo(0));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).toMin(null);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").toMin(null);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{})).toMin(null);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{}), "Message").toMin(null);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toMin(Matchers.equalTo(4));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\nExpected: <4>\n     but: was <1>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").toMin(Matchers.equalTo(4));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\nExpected: <4>\n     but: was <1>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}, 1)).toMin(Matchers.equalTo(4));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\nExpected: <4>\n     but: was <2>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}, 1), "Message").toMin(Matchers.equalTo(4));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\nExpected: <4>\n     but: was <2>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void toRewindAndMinTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{})).toRewindAndMin().isNull();
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1})).toRewindAndMin().isEqualTo(1);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{10, 1, 15, 25})).toRewindAndMin().isEqualTo(1);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{Integer.MIN_VALUE, 100, -100, 100, 100})).toRewindAndMin().isEqualTo(Integer.MIN_VALUE);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{100, -100, 100, 100, Integer.MIN_VALUE})).toRewindAndMin().isEqualTo(Integer.MIN_VALUE);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{100, -100, Integer.MIN_VALUE, 100, 100})).toRewindAndMin().isEqualTo(Integer.MIN_VALUE);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 10, 2, 15, 25}, 1)).toRewindAndMin().isEqualTo(1);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 10, 2, 15, 25}, 2)).toRewindAndMin().isEqualTo(1);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 10, 2, 15, 25}, 3)).toRewindAndMin().isEqualTo(1);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1})).isNotNull().toRewindAndMin().isEqualTo(1);

        try {
            Raw.intBufferAssertion().toRewindAndMin();
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).toRewindAndMin();
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").toRewindAndMin();
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toRewindAndMin()).isEqualTo(0);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").toRewindAndMin()).isEqualTo(0);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toRewindAndMin().isEqualTo(4);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<1>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").toRewindAndMin().isEqualTo(4);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<1>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}, 1)).toRewindAndMin().isEqualTo(4);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<1>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}, 1), "Message").toRewindAndMin().isEqualTo(4);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<1>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void toRewindAndMinMatcherTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{})).toRewindAndMin(Matchers.nullValue());
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1})).toRewindAndMin(Matchers.is(Matchers.equalTo(1)));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{10, 1, 15, 25})).toRewindAndMin(Matchers.is(Matchers.equalTo(1)));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{Integer.MIN_VALUE, 100, -100, 100, 100})).toRewindAndMin(Matchers.is(Matchers.equalTo(Integer.MIN_VALUE)));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{100, -100, 100, 100, Integer.MIN_VALUE})).toRewindAndMin(Matchers.is(Matchers.equalTo(Integer.MIN_VALUE)));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{100, -100, Integer.MIN_VALUE, 100, 100})).toRewindAndMin(Matchers.is(Matchers.equalTo(Integer.MIN_VALUE)));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 10, 2, 15, 25}, 1)).toRewindAndMin(Matchers.is(Matchers.equalTo(1)));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 10, 2, 15, 25}, 2)).toRewindAndMin(Matchers.is(Matchers.equalTo(1)));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 10, 2, 15, 25}, 3)).toRewindAndMin(Matchers.is(Matchers.equalTo(1)));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1})).isNotNull().toRewindAndMin(Matchers.is(Matchers.equalTo(1))).isInstanceOf(IntBuffer.class);

        try {
            Raw.intBufferAssertion().toRewindAndMin(Matchers.equalTo(0));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).toRewindAndMin(Matchers.equalTo(0));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").toRewindAndMin(Matchers.equalTo(0));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).toRewindAndMin(null);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").toRewindAndMin(null);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{})).toRewindAndMin(null);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{}), "Message").toRewindAndMin(null);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toRewindAndMin(Matchers.equalTo(4));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\nExpected: <4>\n     but: was <1>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").toRewindAndMin(Matchers.equalTo(4));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\nExpected: <4>\n     but: was <1>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}, 1)).toRewindAndMin(Matchers.equalTo(4));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\nExpected: <4>\n     but: was <1>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}, 1), "Message").toRewindAndMin(Matchers.equalTo(4));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\nExpected: <4>\n     but: was <1>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void hasMinPrimitiveTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1})).hasMin(1);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{10, 1, 15, 25})).hasMin(1);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{Integer.MIN_VALUE, 100, -100, 100, 100})).hasMin(Integer.MIN_VALUE);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{100, -100, 100, 100, Integer.MIN_VALUE})).hasMin(Integer.MIN_VALUE);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{100, -100, Integer.MIN_VALUE, 100, 100})).hasMin(Integer.MIN_VALUE);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 10, 2, 15, 25}, 1)).hasMin(2);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 10, 2, 15, 25}, 2)).hasMin(2);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 10, 2, 15, 25}, 3)).hasMin(15);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1})).isNotNull().hasMin(1).isInstanceOf(IntBuffer.class);

        try {
            Raw.intBufferAssertion().hasMin(0);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).hasMin(0);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").hasMin(0);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).hasMin(4);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<1>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").hasMin(4);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<1>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}, 1)).hasMin(4);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<2>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}, 1), "Message").hasMin(4);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<2>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void hasMinObjectTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{})).hasMin(null);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1})).hasMin(Integer.valueOf("1"));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{10, 1, 15, 25})).hasMin(Integer.valueOf("1"));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{Integer.MIN_VALUE, 100, -100, 100, 100})).hasMin(Integer.valueOf("-2147483648"));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{100, -100, 100, 100, Integer.MIN_VALUE})).hasMin(Integer.valueOf("-2147483648"));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{100, -100, Integer.MIN_VALUE, 100, 100})).hasMin(Integer.valueOf("-2147483648"));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 10, 2, 15, 25}, 1)).hasMin(Integer.valueOf("2"));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 10, 2, 15, 25}, 2)).hasMin(Integer.valueOf("2"));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 10, 2, 15, 25}, 3)).hasMin(Integer.valueOf("15"));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1})).isNotNull().hasMin(Integer.valueOf("1")).isInstanceOf(IntBuffer.class);

        try {
            Raw.intBufferAssertion().hasMin(Integer.valueOf("0"));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).hasMin(Integer.valueOf("0"));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").hasMin(Integer.valueOf("0"));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).hasMin(null);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").hasMin(null);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1})).hasMin(null);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual value should be null.\n\tActual:<1>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1}), "Message").hasMin(null);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual value should be null.\n\tActual:<1>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).hasMin(Integer.valueOf("4"));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<1>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").hasMin(Integer.valueOf("4"));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<1>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}, 1)).hasMin(Integer.valueOf("4"));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<2>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}, 1), "Message").hasMin(Integer.valueOf("4"));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<2>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void hasRewindAndMinPrimitiveTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1})).hasRewindAndMin(1);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{10, 1, 15, 25})).hasRewindAndMin(1);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{Integer.MIN_VALUE, 100, -100, 100, 100})).hasRewindAndMin(Integer.MIN_VALUE);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{100, -100, 100, 100, Integer.MIN_VALUE})).hasRewindAndMin(Integer.MIN_VALUE);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{100, -100, Integer.MIN_VALUE, 100, 100})).hasRewindAndMin(Integer.MIN_VALUE);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 10, 2, 15, 25}, 1)).hasRewindAndMin(1);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 10, 2, 15, 25}, 2)).hasRewindAndMin(1);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 10, 2, 15, 25}, 3)).hasRewindAndMin(1);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1})).isNotNull().hasRewindAndMin(1).isInstanceOf(IntBuffer.class);

        try {
            Raw.intBufferAssertion().hasRewindAndMin(0);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).hasRewindAndMin(0);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").hasRewindAndMin(0);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).hasRewindAndMin(4);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<1>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").hasRewindAndMin(4);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<1>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}, 1)).hasRewindAndMin(4);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<1>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}, 1), "Message").hasRewindAndMin(4);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<1>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void hasRewindAndMinObjectTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{})).hasRewindAndMin(null);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1})).hasRewindAndMin(Integer.valueOf("1"));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{10, 1, 15, 25})).hasRewindAndMin(Integer.valueOf("1"));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{Integer.MIN_VALUE, 100, -100, 100, 100})).hasRewindAndMin(Integer.valueOf("-2147483648"));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{100, -100, 100, 100, Integer.MIN_VALUE})).hasRewindAndMin(Integer.valueOf("-2147483648"));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{100, -100, Integer.MIN_VALUE, 100, 100})).hasRewindAndMin(Integer.valueOf("-2147483648"));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 10, 2, 15, 25}, 1)).hasRewindAndMin(Integer.valueOf("1"));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 10, 2, 15, 25}, 2)).hasRewindAndMin(Integer.valueOf("1"));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 10, 2, 15, 25}, 3)).hasRewindAndMin(Integer.valueOf("1"));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1})).isNotNull().hasRewindAndMin(Integer.valueOf("1")).isInstanceOf(IntBuffer.class);

        try {
            Raw.intBufferAssertion().hasRewindAndMin(Integer.valueOf("0"));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).hasRewindAndMin(Integer.valueOf("0"));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").hasRewindAndMin(Integer.valueOf("0"));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).hasRewindAndMin(null);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").hasRewindAndMin(null);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1})).hasRewindAndMin(null);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual value should be null.\n\tActual:<1>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1}), "Message").hasRewindAndMin(null);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual value should be null.\n\tActual:<1>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).hasRewindAndMin(Integer.valueOf("4"));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<1>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").hasRewindAndMin(Integer.valueOf("4"));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<1>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}, 1)).hasRewindAndMin(Integer.valueOf("4"));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<1>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}, 1), "Message").hasRewindAndMin(Integer.valueOf("4"));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<1>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void toMaxTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{})).toMax().isNull();
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1})).toMax().isEqualTo(1);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{15, 25, 10, 1})).toMax().isEqualTo(25);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{Integer.MAX_VALUE, 100, -100, 100, 100})).toMax().isEqualTo(Integer.MAX_VALUE);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{100, -100, 100, 100, Integer.MAX_VALUE})).toMax().isEqualTo(Integer.MAX_VALUE);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{100, -100, Integer.MAX_VALUE, 100, 100})).toMax().isEqualTo(Integer.MAX_VALUE);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{30, 15, 25, 10, 1}, 1)).toMax().isEqualTo(25);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{30, 15, 25, 10, 1}, 2)).toMax().isEqualTo(25);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{30, 15, 25, 10, 1}, 3)).toMax().isEqualTo(10);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1})).isNotNull().toMax().isEqualTo(1);

        try {
            Raw.intBufferAssertion().toMax();
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).toMax();
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").toMax();
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{2, 1})).toMax()).isEqualTo(0);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{2, 1}), "Message").toMax()).isEqualTo(0);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{2, 1})).toMax().isEqualTo(4);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<2>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{2, 1}), "Message").toMax().isEqualTo(4);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<2>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{2, 1}, 1)).toMax().isEqualTo(4);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<1>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{2, 1}, 1), "Message").toMax().isEqualTo(4);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<1>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void toMaxMatcherTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{})).toMax(Matchers.nullValue());
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1})).toMax(Matchers.is(Matchers.equalTo(1)));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{15, 25, 10, 1})).toMax(Matchers.is(Matchers.equalTo(25)));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{Integer.MAX_VALUE, 100, -100, 100, 100})).toMax(Matchers.is(Matchers.equalTo(Integer.MAX_VALUE)));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{100, -100, 100, 100, Integer.MAX_VALUE})).toMax(Matchers.is(Matchers.equalTo(Integer.MAX_VALUE)));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{100, -100, Integer.MAX_VALUE, 100, 100})).toMax(Matchers.is(Matchers.equalTo(Integer.MAX_VALUE)));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{30, 15, 25, 10, 1}, 1)).toMax(Matchers.is(Matchers.equalTo(25)));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{30, 15, 25, 10, 1}, 2)).toMax(Matchers.is(Matchers.equalTo(25)));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{30, 15, 25, 10, 1}, 3)).toMax(Matchers.is(Matchers.equalTo(10)));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1})).isNotNull().toMax(Matchers.is(Matchers.equalTo(1))).isInstanceOf(IntBuffer.class);

        try {
            Raw.intBufferAssertion().toMax(Matchers.equalTo(0));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).toMax(Matchers.equalTo(0));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").toMax(Matchers.equalTo(0));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).toMax(null);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").toMax(null);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{})).toMax(null);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{}), "Message").toMax(null);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{2, 1})).toMax(Matchers.equalTo(4));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\nExpected: <4>\n     but: was <2>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{2, 1}), "Message").toMax(Matchers.equalTo(4));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\nExpected: <4>\n     but: was <2>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{2, 1}, 1)).toMax(Matchers.equalTo(4));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\nExpected: <4>\n     but: was <1>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{2, 1}, 1), "Message").toMax(Matchers.equalTo(4));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\nExpected: <4>\n     but: was <1>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void toRewindAndMaxTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{})).toRewindAndMax().isNull();
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1})).toRewindAndMax().isEqualTo(1);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{15, 25, 10, 1})).toRewindAndMax().isEqualTo(25);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{Integer.MAX_VALUE, 100, -100, 100, 100})).toRewindAndMax().isEqualTo(Integer.MAX_VALUE);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{100, -100, 100, 100, Integer.MAX_VALUE})).toRewindAndMax().isEqualTo(Integer.MAX_VALUE);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{100, -100, Integer.MAX_VALUE, 100, 100})).toRewindAndMax().isEqualTo(Integer.MAX_VALUE);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{30, 15, 25, 10, 1}, 1)).toRewindAndMax().isEqualTo(30);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{30, 15, 25, 10, 1}, 2)).toRewindAndMax().isEqualTo(30);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{30, 15, 25, 10, 1}, 3)).toRewindAndMax().isEqualTo(30);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1})).isNotNull().toRewindAndMax().isEqualTo(1);

        try {
            Raw.intBufferAssertion().toRewindAndMax();
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).toRewindAndMax();
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").toRewindAndMax();
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{2, 1})).toRewindAndMax()).isEqualTo(0);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{2, 1}), "Message").toRewindAndMax()).isEqualTo(0);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{2, 1})).toRewindAndMax().isEqualTo(4);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<2>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{2, 1}), "Message").toRewindAndMax().isEqualTo(4);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<2>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{2, 1}, 1)).toRewindAndMax().isEqualTo(4);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<2>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{2, 1}, 1), "Message").toRewindAndMax().isEqualTo(4);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<2>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void toRewindAndMaxMatcherTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{})).toRewindAndMax(Matchers.nullValue());
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1})).toRewindAndMax(Matchers.is(Matchers.equalTo(1)));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{15, 25, 10, 1})).toRewindAndMax(Matchers.is(Matchers.equalTo(25)));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{Integer.MAX_VALUE, 100, -100, 100, 100})).toRewindAndMax(Matchers.is(Matchers.equalTo(Integer.MAX_VALUE)));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{100, -100, 100, 100, Integer.MAX_VALUE})).toRewindAndMax(Matchers.is(Matchers.equalTo(Integer.MAX_VALUE)));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{100, -100, Integer.MAX_VALUE, 100, 100})).toRewindAndMax(Matchers.is(Matchers.equalTo(Integer.MAX_VALUE)));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{30, 15, 25, 10, 1}, 1)).toRewindAndMax(Matchers.is(Matchers.equalTo(30)));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{30, 15, 25, 10, 1}, 2)).toRewindAndMax(Matchers.is(Matchers.equalTo(30)));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{30, 15, 25, 10, 1}, 3)).toRewindAndMax(Matchers.is(Matchers.equalTo(30)));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1})).isNotNull().toRewindAndMax(Matchers.is(Matchers.equalTo(1))).isInstanceOf(IntBuffer.class);

        try {
            Raw.intBufferAssertion().toRewindAndMax(Matchers.equalTo(0));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).toRewindAndMax(Matchers.equalTo(0));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").toRewindAndMax(Matchers.equalTo(0));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).toRewindAndMax(null);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").toRewindAndMax(null);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1})).toRewindAndMax(null);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1}), "Message").toRewindAndMax(null);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{2, 1})).toRewindAndMax(Matchers.equalTo(4));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\nExpected: <4>\n     but: was <2>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{2, 1}), "Message").toRewindAndMax(Matchers.equalTo(4));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\nExpected: <4>\n     but: was <2>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{2, 1}, 1)).toRewindAndMax(Matchers.equalTo(4));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\nExpected: <4>\n     but: was <2>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{2, 1}, 1), "Message").toRewindAndMax(Matchers.equalTo(4));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\nExpected: <4>\n     but: was <2>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void hasMaxPrimitiveTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1})).hasMax(1);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{15, 25, 10, 1})).hasMax(25);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{Integer.MAX_VALUE, 100, -100, 100, 100})).hasMax(Integer.MAX_VALUE);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{100, -100, 100, 100, Integer.MAX_VALUE})).hasMax(Integer.MAX_VALUE);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{100, -100, Integer.MAX_VALUE, 100, 100})).hasMax(Integer.MAX_VALUE);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{30, 15, 25, 10, 1}, 1)).hasMax(25);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{30, 15, 25, 10, 1}, 2)).hasMax(25);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{30, 15, 25, 10, 1}, 3)).hasMax(10);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1})).isNotNull().hasMax(1).isInstanceOf(IntBuffer.class);

        try {
            Raw.intBufferAssertion().hasMax(0);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).hasMax(0);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").hasMax(0);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{2, 1})).hasMax(4);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<2>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{2, 1}), "Message").hasMax(4);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<2>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{2, 1}, 1)).hasMax(4);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<1>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{2, 1}, 1), "Message").hasMax(4);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<1>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void hasMaxObjectTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{})).hasMax(null);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1})).hasMax(Integer.valueOf("1"));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{15, 25, 10, 1})).hasMax(Integer.valueOf("25"));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{Integer.MAX_VALUE, 100, -100, 100, 100})).hasMax(Integer.valueOf("2147483647"));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{100, -100, 100, 100, Integer.MAX_VALUE})).hasMax(Integer.valueOf("2147483647"));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{100, -100, Integer.MAX_VALUE, 100, 100})).hasMax(Integer.valueOf("2147483647"));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{30, 15, 25, 10, 1}, 1)).hasMax(Integer.valueOf("25"));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{30, 15, 25, 10, 1}, 2)).hasMax(Integer.valueOf("25"));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{30, 15, 25, 10, 1}, 3)).hasMax(Integer.valueOf("10"));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1})).isNotNull().hasMax(Integer.valueOf("1")).isInstanceOf(IntBuffer.class);

        try {
            Raw.intBufferAssertion().hasMax(Integer.valueOf("0"));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).hasMax(Integer.valueOf("0"));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").hasMax(Integer.valueOf("0"));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).hasMax(null);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").hasMax(null);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1})).hasMax(null);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual value should be null.\n\tActual:<1>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1}), "Message").hasMax(null);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual value should be null.\n\tActual:<1>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{2, 1})).hasMax(Integer.valueOf("4"));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<2>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{2, 1}), "Message").hasMax(Integer.valueOf("4"));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<2>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{2, 1}, 1)).hasMax(Integer.valueOf("4"));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<1>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{2, 1}, 1), "Message").hasMax(Integer.valueOf("4"));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<1>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void hasRewindAndMaxPrimitiveTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1})).hasRewindAndMax(1);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{15, 25, 10, 1})).hasRewindAndMax(25);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{Integer.MAX_VALUE, 100, -100, 100, 100})).hasRewindAndMax(Integer.MAX_VALUE);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{100, -100, 100, 100, Integer.MAX_VALUE})).hasRewindAndMax(Integer.MAX_VALUE);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{100, -100, Integer.MAX_VALUE, 100, 100})).hasRewindAndMax(Integer.MAX_VALUE);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{30, 15, 25, 10, 1}, 1)).hasRewindAndMax(30);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{30, 15, 25, 10, 1}, 2)).hasRewindAndMax(30);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{30, 15, 25, 10, 1}, 3)).hasRewindAndMax(30);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1})).isNotNull().hasRewindAndMax(1).isInstanceOf(IntBuffer.class);

        try {
            Raw.intBufferAssertion().hasRewindAndMax(0);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).hasRewindAndMax(0);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").hasRewindAndMax(0);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{2, 1})).hasRewindAndMax(4);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<2>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{2, 1}), "Message").hasRewindAndMax(4);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<2>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{2, 1}, 1)).hasRewindAndMax(4);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<2>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{2, 1}, 1), "Message").hasRewindAndMax(4);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<2>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void hasRewindAndMaxObjectTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{})).hasRewindAndMax(null);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1})).hasRewindAndMax(Integer.valueOf("1"));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{15, 25, 10, 1})).hasRewindAndMax(Integer.valueOf("25"));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{Integer.MAX_VALUE, 100, -100, 100, 100})).hasRewindAndMax(Integer.valueOf("2147483647"));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{100, -100, 100, 100, Integer.MAX_VALUE})).hasRewindAndMax(Integer.valueOf("2147483647"));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{100, -100, Integer.MAX_VALUE, 100, 100})).hasRewindAndMax(Integer.valueOf("2147483647"));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{30, 15, 25, 10, 1}, 1)).hasRewindAndMax(Integer.valueOf("30"));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{30, 15, 25, 10, 1}, 2)).hasRewindAndMax(Integer.valueOf("30"));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{30, 15, 25, 10, 1}, 3)).hasRewindAndMax(Integer.valueOf("30"));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1})).isNotNull().hasRewindAndMax(Integer.valueOf("1")).isInstanceOf(IntBuffer.class);

        try {
            Raw.intBufferAssertion().hasRewindAndMax(Integer.valueOf("0"));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).hasRewindAndMax(Integer.valueOf("0"));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").hasRewindAndMax(Integer.valueOf("0"));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).hasRewindAndMax(null);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").hasRewindAndMax(null);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1})).hasRewindAndMax(null);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual value should be null.\n\tActual:<1>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1}), "Message").hasRewindAndMax(null);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual value should be null.\n\tActual:<1>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{2, 1})).hasRewindAndMax(Integer.valueOf("4"));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<2>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{2, 1}), "Message").hasRewindAndMax(Integer.valueOf("4"));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<2>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{2, 1}, 1)).hasRewindAndMax(Integer.valueOf("4"));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<2>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{2, 1}, 1), "Message").hasRewindAndMax(Integer.valueOf("4"));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<2>");
        }
    }

}
