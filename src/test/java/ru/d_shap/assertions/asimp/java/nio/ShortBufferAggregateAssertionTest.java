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

import java.nio.ShortBuffer;

import org.hamcrest.Matchers;
import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link ShortBufferAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class ShortBufferAggregateAssertionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public ShortBufferAggregateAssertionTest() {
        super();
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void toMinTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).toMin().isNull();
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1})).toMin().isEqualTo(1);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{10, 1, 15, 25})).toMin().isEqualTo(1);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{Short.MIN_VALUE, 100, -100, 100, 100})).toMin().isEqualTo(Short.MIN_VALUE);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{100, -100, 100, 100, Short.MIN_VALUE})).toMin().isEqualTo(Short.MIN_VALUE);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{100, -100, Short.MIN_VALUE, 100, 100})).toMin().isEqualTo(Short.MIN_VALUE);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 10, 2, 15, 25}, 1)).toMin().isEqualTo(2);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 10, 2, 15, 25}, 2)).toMin().isEqualTo(2);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 10, 2, 15, 25}, 3)).toMin().isEqualTo(15);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1})).isNotNull().toMin().isEqualTo(1);

        try {
            Raw.shortBufferAssertion().toMin();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).toMin();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").toMin();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toMin()).isEqualTo(0);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").toMin()).isEqualTo(0);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toMin().isEqualTo(4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4s> but was:<1s>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").toMin().isEqualTo(4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4s> but was:<1s>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}, 1)).toMin().isEqualTo(4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4s> but was:<2s>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}, 1), "Message").toMin().isEqualTo(4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4s> but was:<2s>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void toMinMatcherTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).toMin(Matchers.nullValue());
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1})).toMin(Matchers.is(Matchers.equalTo((short) 1)));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{10, 1, 15, 25})).toMin(Matchers.is(Matchers.equalTo((short) 1)));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{Short.MIN_VALUE, 100, -100, 100, 100})).toMin(Matchers.is(Matchers.equalTo(Short.MIN_VALUE)));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{100, -100, 100, 100, Short.MIN_VALUE})).toMin(Matchers.is(Matchers.equalTo(Short.MIN_VALUE)));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{100, -100, Short.MIN_VALUE, 100, 100})).toMin(Matchers.is(Matchers.equalTo(Short.MIN_VALUE)));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 10, 2, 15, 25}, 1)).toMin(Matchers.is(Matchers.equalTo((short) 2)));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 10, 2, 15, 25}, 2)).toMin(Matchers.is(Matchers.equalTo((short) 2)));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 10, 2, 15, 25}, 3)).toMin(Matchers.is(Matchers.equalTo((short) 15)));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1})).isNotNull().toMin(Matchers.is(Matchers.equalTo((short) 1))).isInstanceOf(ShortBuffer.class);

        try {
            Raw.shortBufferAssertion().toMin(Matchers.equalTo((short) 0));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).toMin(Matchers.equalTo((short) 0));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").toMin(Matchers.equalTo((short) 0));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).toMin(null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").toMin(null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).toMin(null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").toMin(null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toMin(Matchers.equalTo((short) 4));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\nExpected: <4s>\n     but: was <1s>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").toMin(Matchers.equalTo((short) 4));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\nExpected: <4s>\n     but: was <1s>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}, 1)).toMin(Matchers.equalTo((short) 4));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\nExpected: <4s>\n     but: was <2s>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}, 1), "Message").toMin(Matchers.equalTo((short) 4));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\nExpected: <4s>\n     but: was <2s>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void toRewindAndMinTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).toRewindAndMin().isNull();
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1})).toRewindAndMin().isEqualTo(1);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{10, 1, 15, 25})).toRewindAndMin().isEqualTo(1);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{Short.MIN_VALUE, 100, -100, 100, 100})).toRewindAndMin().isEqualTo(Short.MIN_VALUE);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{100, -100, 100, 100, Short.MIN_VALUE})).toRewindAndMin().isEqualTo(Short.MIN_VALUE);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{100, -100, Short.MIN_VALUE, 100, 100})).toRewindAndMin().isEqualTo(Short.MIN_VALUE);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 10, 2, 15, 25}, 1)).toRewindAndMin().isEqualTo(1);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 10, 2, 15, 25}, 2)).toRewindAndMin().isEqualTo(1);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 10, 2, 15, 25}, 3)).toRewindAndMin().isEqualTo(1);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1})).isNotNull().toRewindAndMin().isEqualTo(1);

        try {
            Raw.shortBufferAssertion().toRewindAndMin();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).toRewindAndMin();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").toRewindAndMin();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toRewindAndMin()).isEqualTo(0);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").toRewindAndMin()).isEqualTo(0);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toRewindAndMin().isEqualTo(4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4s> but was:<1s>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").toRewindAndMin().isEqualTo(4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4s> but was:<1s>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}, 1)).toRewindAndMin().isEqualTo(4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4s> but was:<1s>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}, 1), "Message").toRewindAndMin().isEqualTo(4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4s> but was:<1s>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void toRewindAndMinMatcherTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).toRewindAndMin(Matchers.nullValue());
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1})).toRewindAndMin(Matchers.is(Matchers.equalTo((short) 1)));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{10, 1, 15, 25})).toRewindAndMin(Matchers.is(Matchers.equalTo((short) 1)));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{Short.MIN_VALUE, 100, -100, 100, 100})).toRewindAndMin(Matchers.is(Matchers.equalTo(Short.MIN_VALUE)));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{100, -100, 100, 100, Short.MIN_VALUE})).toRewindAndMin(Matchers.is(Matchers.equalTo(Short.MIN_VALUE)));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{100, -100, Short.MIN_VALUE, 100, 100})).toRewindAndMin(Matchers.is(Matchers.equalTo(Short.MIN_VALUE)));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 10, 2, 15, 25}, 1)).toRewindAndMin(Matchers.is(Matchers.equalTo((short) 1)));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 10, 2, 15, 25}, 2)).toRewindAndMin(Matchers.is(Matchers.equalTo((short) 1)));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 10, 2, 15, 25}, 3)).toRewindAndMin(Matchers.is(Matchers.equalTo((short) 1)));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1})).isNotNull().toRewindAndMin(Matchers.is(Matchers.equalTo((short) 1))).isInstanceOf(ShortBuffer.class);

        try {
            Raw.shortBufferAssertion().toRewindAndMin(Matchers.equalTo((short) 0));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).toRewindAndMin(Matchers.equalTo((short) 0));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").toRewindAndMin(Matchers.equalTo((short) 0));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).toRewindAndMin(null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").toRewindAndMin(null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).toRewindAndMin(null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").toRewindAndMin(null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toRewindAndMin(Matchers.equalTo((short) 4));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\nExpected: <4s>\n     but: was <1s>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").toRewindAndMin(Matchers.equalTo((short) 4));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\nExpected: <4s>\n     but: was <1s>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}, 1)).toRewindAndMin(Matchers.equalTo((short) 4));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\nExpected: <4s>\n     but: was <1s>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}, 1), "Message").toRewindAndMin(Matchers.equalTo((short) 4));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\nExpected: <4s>\n     but: was <1s>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void hasMinPrimitiveTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1})).hasMin(1);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{10, 1, 15, 25})).hasMin(1);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{Short.MIN_VALUE, 100, -100, 100, 100})).hasMin(Short.MIN_VALUE);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{100, -100, 100, 100, Short.MIN_VALUE})).hasMin(Short.MIN_VALUE);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{100, -100, Short.MIN_VALUE, 100, 100})).hasMin(Short.MIN_VALUE);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 10, 2, 15, 25}, 1)).hasMin(2);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 10, 2, 15, 25}, 2)).hasMin(2);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 10, 2, 15, 25}, 3)).hasMin(15);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1})).isNotNull().hasMin(1).isInstanceOf(ShortBuffer.class);

        try {
            Raw.shortBufferAssertion().hasMin(0);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).hasMin(0);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").hasMin(0);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).hasMin(4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4s> but was:<1s>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").hasMin(4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4s> but was:<1s>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}, 1)).hasMin(4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4s> but was:<2s>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}, 1), "Message").hasMin(4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4s> but was:<2s>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void hasMinObjectTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).hasMin(null);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1})).hasMin(Short.valueOf("1"));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{10, 1, 15, 25})).hasMin(Short.valueOf("1"));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{Short.MIN_VALUE, 100, -100, 100, 100})).hasMin(Short.valueOf("-32768"));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{100, -100, 100, 100, Short.MIN_VALUE})).hasMin(Short.valueOf("-32768"));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{100, -100, Short.MIN_VALUE, 100, 100})).hasMin(Short.valueOf("-32768"));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 10, 2, 15, 25}, 1)).hasMin(Short.valueOf("2"));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 10, 2, 15, 25}, 2)).hasMin(Short.valueOf("2"));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 10, 2, 15, 25}, 3)).hasMin(Short.valueOf("15"));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1})).isNotNull().hasMin(Short.valueOf("1")).isInstanceOf(ShortBuffer.class);

        try {
            Raw.shortBufferAssertion().hasMin(Short.valueOf("0"));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).hasMin(Short.valueOf("0"));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").hasMin(Short.valueOf("0"));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).hasMin(null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").hasMin(null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1})).hasMin(null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual value should be null.\n\tActual:<1s>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1}), "Message").hasMin(null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual value should be null.\n\tActual:<1s>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).hasMin(Short.valueOf("4"));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4s> but was:<1s>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").hasMin(Short.valueOf("4"));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4s> but was:<1s>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}, 1)).hasMin(Short.valueOf("4"));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4s> but was:<2s>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}, 1), "Message").hasMin(Short.valueOf("4"));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4s> but was:<2s>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void hasRewindAndMinPrimitiveTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1})).hasRewindAndMin(1);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{10, 1, 15, 25})).hasRewindAndMin(1);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{Short.MIN_VALUE, 100, -100, 100, 100})).hasRewindAndMin(Short.MIN_VALUE);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{100, -100, 100, 100, Short.MIN_VALUE})).hasRewindAndMin(Short.MIN_VALUE);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{100, -100, Short.MIN_VALUE, 100, 100})).hasRewindAndMin(Short.MIN_VALUE);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 10, 2, 15, 25}, 1)).hasRewindAndMin(1);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 10, 2, 15, 25}, 2)).hasRewindAndMin(1);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 10, 2, 15, 25}, 3)).hasRewindAndMin(1);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1})).isNotNull().hasRewindAndMin(1).isInstanceOf(ShortBuffer.class);

        try {
            Raw.shortBufferAssertion().hasRewindAndMin(0);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).hasRewindAndMin(0);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").hasRewindAndMin(0);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).hasRewindAndMin(4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4s> but was:<1s>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").hasRewindAndMin(4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4s> but was:<1s>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}, 1)).hasRewindAndMin(4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4s> but was:<1s>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}, 1), "Message").hasRewindAndMin(4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4s> but was:<1s>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void hasRewindAndMinObjectTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).hasRewindAndMin(null);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1})).hasRewindAndMin(Short.valueOf("1"));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{10, 1, 15, 25})).hasRewindAndMin(Short.valueOf("1"));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{Short.MIN_VALUE, 100, -100, 100, 100})).hasRewindAndMin(Short.valueOf("-32768"));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{100, -100, 100, 100, Short.MIN_VALUE})).hasRewindAndMin(Short.valueOf("-32768"));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{100, -100, Short.MIN_VALUE, 100, 100})).hasRewindAndMin(Short.valueOf("-32768"));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 10, 2, 15, 25}, 1)).hasRewindAndMin(Short.valueOf("1"));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 10, 2, 15, 25}, 2)).hasRewindAndMin(Short.valueOf("1"));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 10, 2, 15, 25}, 3)).hasRewindAndMin(Short.valueOf("1"));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1})).isNotNull().hasRewindAndMin(Short.valueOf("1")).isInstanceOf(ShortBuffer.class);

        try {
            Raw.shortBufferAssertion().hasRewindAndMin(Short.valueOf("0"));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).hasRewindAndMin(Short.valueOf("0"));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").hasRewindAndMin(Short.valueOf("0"));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).hasRewindAndMin(null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").hasRewindAndMin(null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1})).hasRewindAndMin(null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual value should be null.\n\tActual:<1s>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1}), "Message").hasRewindAndMin(null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual value should be null.\n\tActual:<1s>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).hasRewindAndMin(Short.valueOf("4"));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4s> but was:<1s>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").hasRewindAndMin(Short.valueOf("4"));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4s> but was:<1s>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}, 1)).hasRewindAndMin(Short.valueOf("4"));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4s> but was:<1s>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}, 1), "Message").hasRewindAndMin(Short.valueOf("4"));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4s> but was:<1s>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void toMaxTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).toMax().isNull();
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1})).toMax().isEqualTo(1);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{15, 25, 10, 1})).toMax().isEqualTo(25);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{Short.MAX_VALUE, 100, -100, 100, 100})).toMax().isEqualTo(Short.MAX_VALUE);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{100, -100, 100, 100, Short.MAX_VALUE})).toMax().isEqualTo(Short.MAX_VALUE);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{100, -100, Short.MAX_VALUE, 100, 100})).toMax().isEqualTo(Short.MAX_VALUE);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{30, 15, 25, 10, 1}, 1)).toMax().isEqualTo(25);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{30, 15, 25, 10, 1}, 2)).toMax().isEqualTo(25);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{30, 15, 25, 10, 1}, 3)).toMax().isEqualTo(10);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1})).isNotNull().toMax().isEqualTo(1);

        try {
            Raw.shortBufferAssertion().toMax();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).toMax();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").toMax();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{2, 1})).toMax()).isEqualTo(0);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{2, 1}), "Message").toMax()).isEqualTo(0);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{2, 1})).toMax().isEqualTo(4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4s> but was:<2s>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{2, 1}), "Message").toMax().isEqualTo(4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4s> but was:<2s>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{2, 1}, 1)).toMax().isEqualTo(4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4s> but was:<1s>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{2, 1}, 1), "Message").toMax().isEqualTo(4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4s> but was:<1s>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void toMaxMatcherTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).toMax(Matchers.nullValue());
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1})).toMax(Matchers.is(Matchers.equalTo((short) 1)));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{15, 25, 10, 1})).toMax(Matchers.is(Matchers.equalTo((short) 25)));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{Short.MAX_VALUE, 100, -100, 100, 100})).toMax(Matchers.is(Matchers.equalTo(Short.MAX_VALUE)));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{100, -100, 100, 100, Short.MAX_VALUE})).toMax(Matchers.is(Matchers.equalTo(Short.MAX_VALUE)));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{100, -100, Short.MAX_VALUE, 100, 100})).toMax(Matchers.is(Matchers.equalTo(Short.MAX_VALUE)));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{30, 15, 25, 10, 1}, 1)).toMax(Matchers.is(Matchers.equalTo((short) 25)));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{30, 15, 25, 10, 1}, 2)).toMax(Matchers.is(Matchers.equalTo((short) 25)));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{30, 15, 25, 10, 1}, 3)).toMax(Matchers.is(Matchers.equalTo((short) 10)));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1})).isNotNull().toMax(Matchers.is(Matchers.equalTo((short) 1))).isInstanceOf(ShortBuffer.class);

        try {
            Raw.shortBufferAssertion().toMax(Matchers.equalTo((short) 0));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).toMax(Matchers.equalTo((short) 0));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").toMax(Matchers.equalTo((short) 0));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).toMax(null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").toMax(null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).toMax(null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").toMax(null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{2, 1})).toMax(Matchers.equalTo((short) 4));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\nExpected: <4s>\n     but: was <2s>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{2, 1}), "Message").toMax(Matchers.equalTo((short) 4));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\nExpected: <4s>\n     but: was <2s>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{2, 1}, 1)).toMax(Matchers.equalTo((short) 4));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\nExpected: <4s>\n     but: was <1s>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{2, 1}, 1), "Message").toMax(Matchers.equalTo((short) 4));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\nExpected: <4s>\n     but: was <1s>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void toRewindAndMaxTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).toRewindAndMax().isNull();
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1})).toRewindAndMax().isEqualTo(1);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{15, 25, 10, 1})).toRewindAndMax().isEqualTo(25);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{Short.MAX_VALUE, 100, -100, 100, 100})).toRewindAndMax().isEqualTo(Short.MAX_VALUE);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{100, -100, 100, 100, Short.MAX_VALUE})).toRewindAndMax().isEqualTo(Short.MAX_VALUE);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{100, -100, Short.MAX_VALUE, 100, 100})).toRewindAndMax().isEqualTo(Short.MAX_VALUE);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{30, 15, 25, 10, 1}, 1)).toRewindAndMax().isEqualTo(30);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{30, 15, 25, 10, 1}, 2)).toRewindAndMax().isEqualTo(30);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{30, 15, 25, 10, 1}, 3)).toRewindAndMax().isEqualTo(30);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1})).isNotNull().toRewindAndMax().isEqualTo(1);

        try {
            Raw.shortBufferAssertion().toRewindAndMax();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).toRewindAndMax();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").toRewindAndMax();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{2, 1})).toRewindAndMax()).isEqualTo(0);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{2, 1}), "Message").toRewindAndMax()).isEqualTo(0);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{2, 1})).toRewindAndMax().isEqualTo(4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4s> but was:<2s>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{2, 1}), "Message").toRewindAndMax().isEqualTo(4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4s> but was:<2s>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{2, 1}, 1)).toRewindAndMax().isEqualTo(4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4s> but was:<2s>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{2, 1}, 1), "Message").toRewindAndMax().isEqualTo(4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4s> but was:<2s>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void toRewindAndMaxMatcherTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).toRewindAndMax(Matchers.nullValue());
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1})).toRewindAndMax(Matchers.is(Matchers.equalTo((short) 1)));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{15, 25, 10, 1})).toRewindAndMax(Matchers.is(Matchers.equalTo((short) 25)));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{Short.MAX_VALUE, 100, -100, 100, 100})).toRewindAndMax(Matchers.is(Matchers.equalTo(Short.MAX_VALUE)));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{100, -100, 100, 100, Short.MAX_VALUE})).toRewindAndMax(Matchers.is(Matchers.equalTo(Short.MAX_VALUE)));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{100, -100, Short.MAX_VALUE, 100, 100})).toRewindAndMax(Matchers.is(Matchers.equalTo(Short.MAX_VALUE)));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{30, 15, 25, 10, 1}, 1)).toRewindAndMax(Matchers.is(Matchers.equalTo((short) 30)));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{30, 15, 25, 10, 1}, 2)).toRewindAndMax(Matchers.is(Matchers.equalTo((short) 30)));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{30, 15, 25, 10, 1}, 3)).toRewindAndMax(Matchers.is(Matchers.equalTo((short) 30)));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1})).isNotNull().toRewindAndMax(Matchers.is(Matchers.equalTo((short) 1))).isInstanceOf(ShortBuffer.class);

        try {
            Raw.shortBufferAssertion().toRewindAndMax(Matchers.equalTo((short) 0));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).toRewindAndMax(Matchers.equalTo((short) 0));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").toRewindAndMax(Matchers.equalTo((short) 0));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).toRewindAndMax(null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").toRewindAndMax(null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1})).toRewindAndMax(null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1}), "Message").toRewindAndMax(null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{2, 1})).toRewindAndMax(Matchers.equalTo((short) 4));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\nExpected: <4s>\n     but: was <2s>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{2, 1}), "Message").toRewindAndMax(Matchers.equalTo((short) 4));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\nExpected: <4s>\n     but: was <2s>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{2, 1}, 1)).toRewindAndMax(Matchers.equalTo((short) 4));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\nExpected: <4s>\n     but: was <2s>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{2, 1}, 1), "Message").toRewindAndMax(Matchers.equalTo((short) 4));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\nExpected: <4s>\n     but: was <2s>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void hasMaxPrimitiveTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1})).hasMax(1);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{15, 25, 10, 1})).hasMax(25);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{Short.MAX_VALUE, 100, -100, 100, 100})).hasMax(Short.MAX_VALUE);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{100, -100, 100, 100, Short.MAX_VALUE})).hasMax(Short.MAX_VALUE);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{100, -100, Short.MAX_VALUE, 100, 100})).hasMax(Short.MAX_VALUE);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{30, 15, 25, 10, 1}, 1)).hasMax(25);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{30, 15, 25, 10, 1}, 2)).hasMax(25);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{30, 15, 25, 10, 1}, 3)).hasMax(10);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1})).isNotNull().hasMax(1).isInstanceOf(ShortBuffer.class);

        try {
            Raw.shortBufferAssertion().hasMax(0);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).hasMax(0);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").hasMax(0);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{2, 1})).hasMax(4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4s> but was:<2s>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{2, 1}), "Message").hasMax(4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4s> but was:<2s>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{2, 1}, 1)).hasMax(4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4s> but was:<1s>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{2, 1}, 1), "Message").hasMax(4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4s> but was:<1s>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void hasMaxObjectTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).hasMax(null);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1})).hasMax(Short.valueOf("1"));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{15, 25, 10, 1})).hasMax(Short.valueOf("25"));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{Short.MAX_VALUE, 100, -100, 100, 100})).hasMax(Short.valueOf("32767"));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{100, -100, 100, 100, Short.MAX_VALUE})).hasMax(Short.valueOf("32767"));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{100, -100, Short.MAX_VALUE, 100, 100})).hasMax(Short.valueOf("32767"));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{30, 15, 25, 10, 1}, 1)).hasMax(Short.valueOf("25"));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{30, 15, 25, 10, 1}, 2)).hasMax(Short.valueOf("25"));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{30, 15, 25, 10, 1}, 3)).hasMax(Short.valueOf("10"));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1})).isNotNull().hasMax(Short.valueOf("1")).isInstanceOf(ShortBuffer.class);

        try {
            Raw.shortBufferAssertion().hasMax(Short.valueOf("0"));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).hasMax(Short.valueOf("0"));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").hasMax(Short.valueOf("0"));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).hasMax(null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").hasMax(null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1})).hasMax(null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual value should be null.\n\tActual:<1s>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1}), "Message").hasMax(null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual value should be null.\n\tActual:<1s>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{2, 1})).hasMax(Short.valueOf("4"));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4s> but was:<2s>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{2, 1}), "Message").hasMax(Short.valueOf("4"));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4s> but was:<2s>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{2, 1}, 1)).hasMax(Short.valueOf("4"));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4s> but was:<1s>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{2, 1}, 1), "Message").hasMax(Short.valueOf("4"));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4s> but was:<1s>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void hasRewindAndMaxPrimitiveTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1})).hasRewindAndMax(1);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{15, 25, 10, 1})).hasRewindAndMax(25);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{Short.MAX_VALUE, 100, -100, 100, 100})).hasRewindAndMax(Short.MAX_VALUE);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{100, -100, 100, 100, Short.MAX_VALUE})).hasRewindAndMax(Short.MAX_VALUE);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{100, -100, Short.MAX_VALUE, 100, 100})).hasRewindAndMax(Short.MAX_VALUE);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{30, 15, 25, 10, 1}, 1)).hasRewindAndMax(30);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{30, 15, 25, 10, 1}, 2)).hasRewindAndMax(30);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{30, 15, 25, 10, 1}, 3)).hasRewindAndMax(30);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1})).isNotNull().hasRewindAndMax(1).isInstanceOf(ShortBuffer.class);

        try {
            Raw.shortBufferAssertion().hasRewindAndMax(0);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).hasRewindAndMax(0);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").hasRewindAndMax(0);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{2, 1})).hasRewindAndMax(4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4s> but was:<2s>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{2, 1}), "Message").hasRewindAndMax(4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4s> but was:<2s>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{2, 1}, 1)).hasRewindAndMax(4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4s> but was:<2s>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{2, 1}, 1), "Message").hasRewindAndMax(4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4s> but was:<2s>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void hasRewindAndMaxObjectTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).hasRewindAndMax(null);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1})).hasRewindAndMax(Short.valueOf("1"));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{15, 25, 10, 1})).hasRewindAndMax(Short.valueOf("25"));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{Short.MAX_VALUE, 100, -100, 100, 100})).hasRewindAndMax(Short.valueOf("32767"));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{100, -100, 100, 100, Short.MAX_VALUE})).hasRewindAndMax(Short.valueOf("32767"));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{100, -100, Short.MAX_VALUE, 100, 100})).hasRewindAndMax(Short.valueOf("32767"));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{30, 15, 25, 10, 1}, 1)).hasRewindAndMax(Short.valueOf("30"));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{30, 15, 25, 10, 1}, 2)).hasRewindAndMax(Short.valueOf("30"));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{30, 15, 25, 10, 1}, 3)).hasRewindAndMax(Short.valueOf("30"));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1})).isNotNull().hasRewindAndMax(Short.valueOf("1")).isInstanceOf(ShortBuffer.class);

        try {
            Raw.shortBufferAssertion().hasRewindAndMax(Short.valueOf("0"));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).hasRewindAndMax(Short.valueOf("0"));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").hasRewindAndMax(Short.valueOf("0"));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).hasRewindAndMax(null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").hasRewindAndMax(null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1})).hasRewindAndMax(null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual value should be null.\n\tActual:<1s>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1}), "Message").hasRewindAndMax(null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual value should be null.\n\tActual:<1s>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{2, 1})).hasRewindAndMax(Short.valueOf("4"));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4s> but was:<2s>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{2, 1}), "Message").hasRewindAndMax(Short.valueOf("4"));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4s> but was:<2s>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{2, 1}, 1)).hasRewindAndMax(Short.valueOf("4"));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4s> but was:<2s>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{2, 1}, 1), "Message").hasRewindAndMax(Short.valueOf("4"));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4s> but was:<2s>");
        }
    }

}
