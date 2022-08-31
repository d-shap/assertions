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

import java.nio.ByteBuffer;

import org.hamcrest.Matchers;
import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link ByteBufferAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class ByteBufferAggregateAssertionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public ByteBufferAggregateAssertionTest() {
        super();
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void toMinTest() {
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).toMin().isNull();
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1})).toMin().isEqualTo(1);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{10, 1, 15, 25})).toMin().isEqualTo(1);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{Byte.MIN_VALUE, 100, -100, 100, 100})).toMin().isEqualTo(Byte.MIN_VALUE);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{100, -100, 100, 100, Byte.MIN_VALUE})).toMin().isEqualTo(Byte.MIN_VALUE);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{100, -100, Byte.MIN_VALUE, 100, 100})).toMin().isEqualTo(Byte.MIN_VALUE);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 10, 2, 15, 25}, 1)).toMin().isEqualTo(2);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 10, 2, 15, 25}, 2)).toMin().isEqualTo(2);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 10, 2, 15, 25}, 3)).toMin().isEqualTo(15);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1})).isNotNull().toMin().isEqualTo(1);

        try {
            Raw.byteBufferAssertion().toMin();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).toMin();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").toMin();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).toMin()).isEqualTo(0);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}), "Message").toMin()).isEqualTo(0);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).toMin().isEqualTo(4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4b> but was:<1b>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}), "Message").toMin().isEqualTo(4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4b> but was:<1b>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}, 1)).toMin().isEqualTo(4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4b> but was:<2b>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}, 1), "Message").toMin().isEqualTo(4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4b> but was:<2b>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void toMinMatcherTest() {
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).toMin(Matchers.nullValue());
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1})).toMin(Matchers.is(Matchers.equalTo((byte) 1)));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{10, 1, 15, 25})).toMin(Matchers.is(Matchers.equalTo((byte) 1)));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{Byte.MIN_VALUE, 100, -100, 100, 100})).toMin(Matchers.is(Matchers.equalTo(Byte.MIN_VALUE)));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{100, -100, 100, 100, Byte.MIN_VALUE})).toMin(Matchers.is(Matchers.equalTo(Byte.MIN_VALUE)));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{100, -100, Byte.MIN_VALUE, 100, 100})).toMin(Matchers.is(Matchers.equalTo(Byte.MIN_VALUE)));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 10, 2, 15, 25}, 1)).toMin(Matchers.is(Matchers.equalTo((byte) 2)));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 10, 2, 15, 25}, 2)).toMin(Matchers.is(Matchers.equalTo((byte) 2)));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 10, 2, 15, 25}, 3)).toMin(Matchers.is(Matchers.equalTo((byte) 15)));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1})).isNotNull().toMin(Matchers.is(Matchers.equalTo((byte) 1))).isInstanceOf(ByteBuffer.class);

        try {
            Raw.byteBufferAssertion().toMin(Matchers.equalTo((byte) 0));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).toMin(Matchers.equalTo((byte) 0));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").toMin(Matchers.equalTo((byte) 0));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).toMin(null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").toMin(null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).toMin(null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{}), "Message").toMin(null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).toMin(Matchers.equalTo((byte) 4));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\nExpected: <4>\n     but: was <1>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}), "Message").toMin(Matchers.equalTo((byte) 4));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\nExpected: <4>\n     but: was <1>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}, 1)).toMin(Matchers.equalTo((byte) 4));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\nExpected: <4>\n     but: was <2>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}, 1), "Message").toMin(Matchers.equalTo((byte) 4));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\nExpected: <4>\n     but: was <2>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void toRewindAndMinTest() {
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).toRewindAndMin().isNull();
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1})).toRewindAndMin().isEqualTo(1);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{10, 1, 15, 25})).toRewindAndMin().isEqualTo(1);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{Byte.MIN_VALUE, 100, -100, 100, 100})).toRewindAndMin().isEqualTo(Byte.MIN_VALUE);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{100, -100, 100, 100, Byte.MIN_VALUE})).toRewindAndMin().isEqualTo(Byte.MIN_VALUE);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{100, -100, Byte.MIN_VALUE, 100, 100})).toRewindAndMin().isEqualTo(Byte.MIN_VALUE);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 10, 2, 15, 25}, 1)).toRewindAndMin().isEqualTo(1);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 10, 2, 15, 25}, 2)).toRewindAndMin().isEqualTo(1);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 10, 2, 15, 25}, 3)).toRewindAndMin().isEqualTo(1);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1})).isNotNull().toRewindAndMin().isEqualTo(1);

        try {
            Raw.byteBufferAssertion().toRewindAndMin();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).toRewindAndMin();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").toRewindAndMin();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).toRewindAndMin()).isEqualTo(0);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}), "Message").toRewindAndMin()).isEqualTo(0);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).toRewindAndMin().isEqualTo(4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4b> but was:<1b>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}), "Message").toRewindAndMin().isEqualTo(4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4b> but was:<1b>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}, 1)).toRewindAndMin().isEqualTo(4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4b> but was:<1b>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}, 1), "Message").toRewindAndMin().isEqualTo(4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4b> but was:<1b>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void toRewindAndMinMatcherTest() {
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).toRewindAndMin(Matchers.nullValue());
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1})).toRewindAndMin(Matchers.is(Matchers.equalTo((byte) 1)));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{10, 1, 15, 25})).toRewindAndMin(Matchers.is(Matchers.equalTo((byte) 1)));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{Byte.MIN_VALUE, 100, -100, 100, 100})).toRewindAndMin(Matchers.is(Matchers.equalTo(Byte.MIN_VALUE)));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{100, -100, 100, 100, Byte.MIN_VALUE})).toRewindAndMin(Matchers.is(Matchers.equalTo(Byte.MIN_VALUE)));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{100, -100, Byte.MIN_VALUE, 100, 100})).toRewindAndMin(Matchers.is(Matchers.equalTo(Byte.MIN_VALUE)));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 10, 2, 15, 25}, 1)).toRewindAndMin(Matchers.is(Matchers.equalTo((byte) 1)));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 10, 2, 15, 25}, 2)).toRewindAndMin(Matchers.is(Matchers.equalTo((byte) 1)));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 10, 2, 15, 25}, 3)).toRewindAndMin(Matchers.is(Matchers.equalTo((byte) 1)));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1})).isNotNull().toRewindAndMin(Matchers.is(Matchers.equalTo((byte) 1))).isInstanceOf(ByteBuffer.class);

        try {
            Raw.byteBufferAssertion().toRewindAndMin(Matchers.equalTo((byte) 0));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).toRewindAndMin(Matchers.equalTo((byte) 0));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").toRewindAndMin(Matchers.equalTo((byte) 0));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).toRewindAndMin(null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").toRewindAndMin(null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).toRewindAndMin(null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{}), "Message").toRewindAndMin(null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).toRewindAndMin(Matchers.equalTo((byte) 4));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\nExpected: <4>\n     but: was <1>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}), "Message").toRewindAndMin(Matchers.equalTo((byte) 4));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\nExpected: <4>\n     but: was <1>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}, 1)).toRewindAndMin(Matchers.equalTo((byte) 4));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\nExpected: <4>\n     but: was <1>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}, 1), "Message").toRewindAndMin(Matchers.equalTo((byte) 4));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\nExpected: <4>\n     but: was <1>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void hasMinPrimitiveTest() {
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1})).hasMin(1);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{10, 1, 15, 25})).hasMin(1);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{Byte.MIN_VALUE, 100, -100, 100, 100})).hasMin(Byte.MIN_VALUE);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{100, -100, 100, 100, Byte.MIN_VALUE})).hasMin(Byte.MIN_VALUE);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{100, -100, Byte.MIN_VALUE, 100, 100})).hasMin(Byte.MIN_VALUE);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 10, 2, 15, 25}, 1)).hasMin(2);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 10, 2, 15, 25}, 2)).hasMin(2);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 10, 2, 15, 25}, 3)).hasMin(15);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1})).isNotNull().hasMin(1).isInstanceOf(ByteBuffer.class);

        try {
            Raw.byteBufferAssertion().hasMin(0);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).hasMin(0);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").hasMin(0);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).hasMin(4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4b> but was:<1b>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}), "Message").hasMin(4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4b> but was:<1b>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}, 1)).hasMin(4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4b> but was:<2b>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}, 1), "Message").hasMin(4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4b> but was:<2b>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void hasMinObjectTest() {
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).hasMin(null);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1})).hasMin(Byte.valueOf("1"));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{10, 1, 15, 25})).hasMin(Byte.valueOf("1"));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{Byte.MIN_VALUE, 100, -100, 100, 100})).hasMin(Byte.valueOf("-128"));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{100, -100, 100, 100, Byte.MIN_VALUE})).hasMin(Byte.valueOf("-128"));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{100, -100, Byte.MIN_VALUE, 100, 100})).hasMin(Byte.valueOf("-128"));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 10, 2, 15, 25}, 1)).hasMin(Byte.valueOf("2"));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 10, 2, 15, 25}, 2)).hasMin(Byte.valueOf("2"));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 10, 2, 15, 25}, 3)).hasMin(Byte.valueOf("15"));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1})).isNotNull().hasMin(Byte.valueOf("1")).isInstanceOf(ByteBuffer.class);

        try {
            Raw.byteBufferAssertion().hasMin(Byte.valueOf("0"));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).hasMin(Byte.valueOf("0"));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").hasMin(Byte.valueOf("0"));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).hasMin(null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").hasMin(null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1})).hasMin(null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual value should be null.\n\tActual:<1b>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1}), "Message").hasMin(null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual value should be null.\n\tActual:<1b>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).hasMin(Byte.valueOf("4"));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4b> but was:<1b>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}), "Message").hasMin(Byte.valueOf("4"));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4b> but was:<1b>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}, 1)).hasMin(Byte.valueOf("4"));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4b> but was:<2b>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}, 1), "Message").hasMin(Byte.valueOf("4"));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4b> but was:<2b>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void hasRewindAndMinPrimitiveTest() {
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1})).hasRewindAndMin(1);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{10, 1, 15, 25})).hasRewindAndMin(1);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{Byte.MIN_VALUE, 100, -100, 100, 100})).hasRewindAndMin(Byte.MIN_VALUE);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{100, -100, 100, 100, Byte.MIN_VALUE})).hasRewindAndMin(Byte.MIN_VALUE);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{100, -100, Byte.MIN_VALUE, 100, 100})).hasRewindAndMin(Byte.MIN_VALUE);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 10, 2, 15, 25}, 1)).hasRewindAndMin(1);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 10, 2, 15, 25}, 2)).hasRewindAndMin(1);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 10, 2, 15, 25}, 3)).hasRewindAndMin(1);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1})).isNotNull().hasRewindAndMin(1).isInstanceOf(ByteBuffer.class);

        try {
            Raw.byteBufferAssertion().hasRewindAndMin(0);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).hasRewindAndMin(0);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").hasRewindAndMin(0);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).hasRewindAndMin(4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4b> but was:<1b>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}), "Message").hasRewindAndMin(4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4b> but was:<1b>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}, 1)).hasRewindAndMin(4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4b> but was:<1b>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}, 1), "Message").hasRewindAndMin(4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4b> but was:<1b>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void hasRewindAndMinObjectTest() {
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).hasRewindAndMin(null);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1})).hasRewindAndMin(Byte.valueOf("1"));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{10, 1, 15, 25})).hasRewindAndMin(Byte.valueOf("1"));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{Byte.MIN_VALUE, 100, -100, 100, 100})).hasRewindAndMin(Byte.valueOf("-128"));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{100, -100, 100, 100, Byte.MIN_VALUE})).hasRewindAndMin(Byte.valueOf("-128"));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{100, -100, Byte.MIN_VALUE, 100, 100})).hasRewindAndMin(Byte.valueOf("-128"));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 10, 2, 15, 25}, 1)).hasRewindAndMin(Byte.valueOf("1"));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 10, 2, 15, 25}, 2)).hasRewindAndMin(Byte.valueOf("1"));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 10, 2, 15, 25}, 3)).hasRewindAndMin(Byte.valueOf("1"));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1})).isNotNull().hasRewindAndMin(Byte.valueOf("1")).isInstanceOf(ByteBuffer.class);

        try {
            Raw.byteBufferAssertion().hasRewindAndMin(Byte.valueOf("0"));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).hasRewindAndMin(Byte.valueOf("0"));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").hasRewindAndMin(Byte.valueOf("0"));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).hasRewindAndMin(null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").hasRewindAndMin(null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1})).hasRewindAndMin(null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual value should be null.\n\tActual:<1b>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1}), "Message").hasRewindAndMin(null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual value should be null.\n\tActual:<1b>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).hasRewindAndMin(Byte.valueOf("4"));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4b> but was:<1b>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}), "Message").hasRewindAndMin(Byte.valueOf("4"));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4b> but was:<1b>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}, 1)).hasRewindAndMin(Byte.valueOf("4"));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4b> but was:<1b>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}, 1), "Message").hasRewindAndMin(Byte.valueOf("4"));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4b> but was:<1b>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void toMaxTest() {
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).toMax().isNull();
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1})).toMax().isEqualTo(1);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{15, 25, 10, 1})).toMax().isEqualTo(25);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{Byte.MAX_VALUE, 100, -100, 100, 100})).toMax().isEqualTo(Byte.MAX_VALUE);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{100, -100, 100, 100, Byte.MAX_VALUE})).toMax().isEqualTo(Byte.MAX_VALUE);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{100, -100, Byte.MAX_VALUE, 100, 100})).toMax().isEqualTo(Byte.MAX_VALUE);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{30, 15, 25, 10, 1}, 1)).toMax().isEqualTo(25);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{30, 15, 25, 10, 1}, 2)).toMax().isEqualTo(25);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{30, 15, 25, 10, 1}, 3)).toMax().isEqualTo(10);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1})).isNotNull().toMax().isEqualTo(1);

        try {
            Raw.byteBufferAssertion().toMax();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).toMax();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").toMax();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{2, 1})).toMax()).isEqualTo(0);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{2, 1}), "Message").toMax()).isEqualTo(0);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{2, 1})).toMax().isEqualTo(4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4b> but was:<2b>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{2, 1}), "Message").toMax().isEqualTo(4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4b> but was:<2b>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{2, 1}, 1)).toMax().isEqualTo(4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4b> but was:<1b>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{2, 1}, 1), "Message").toMax().isEqualTo(4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4b> but was:<1b>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void toMaxMatcherTest() {
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).toMax(Matchers.nullValue());
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1})).toMax(Matchers.is(Matchers.equalTo((byte) 1)));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{15, 25, 10, 1})).toMax(Matchers.is(Matchers.equalTo((byte) 25)));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{Byte.MAX_VALUE, 100, -100, 100, 100})).toMax(Matchers.is(Matchers.equalTo(Byte.MAX_VALUE)));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{100, -100, 100, 100, Byte.MAX_VALUE})).toMax(Matchers.is(Matchers.equalTo(Byte.MAX_VALUE)));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{100, -100, Byte.MAX_VALUE, 100, 100})).toMax(Matchers.is(Matchers.equalTo(Byte.MAX_VALUE)));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{30, 15, 25, 10, 1}, 1)).toMax(Matchers.is(Matchers.equalTo((byte) 25)));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{30, 15, 25, 10, 1}, 2)).toMax(Matchers.is(Matchers.equalTo((byte) 25)));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{30, 15, 25, 10, 1}, 3)).toMax(Matchers.is(Matchers.equalTo((byte) 10)));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1})).isNotNull().toMax(Matchers.is(Matchers.equalTo((byte) 1))).isInstanceOf(ByteBuffer.class);

        try {
            Raw.byteBufferAssertion().toMax(Matchers.equalTo((byte) 0));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).toMax(Matchers.equalTo((byte) 0));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").toMax(Matchers.equalTo((byte) 0));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).toMax(null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").toMax(null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).toMax(null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{}), "Message").toMax(null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{2, 1})).toMax(Matchers.equalTo((byte) 4));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\nExpected: <4>\n     but: was <2>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{2, 1}), "Message").toMax(Matchers.equalTo((byte) 4));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\nExpected: <4>\n     but: was <2>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{2, 1}, 1)).toMax(Matchers.equalTo((byte) 4));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\nExpected: <4>\n     but: was <1>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{2, 1}, 1), "Message").toMax(Matchers.equalTo((byte) 4));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\nExpected: <4>\n     but: was <1>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void toRewindAndMaxTest() {
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).toRewindAndMax().isNull();
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1})).toRewindAndMax().isEqualTo(1);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{15, 25, 10, 1})).toRewindAndMax().isEqualTo(25);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{Byte.MAX_VALUE, 100, -100, 100, 100})).toRewindAndMax().isEqualTo(Byte.MAX_VALUE);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{100, -100, 100, 100, Byte.MAX_VALUE})).toRewindAndMax().isEqualTo(Byte.MAX_VALUE);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{100, -100, Byte.MAX_VALUE, 100, 100})).toRewindAndMax().isEqualTo(Byte.MAX_VALUE);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{30, 15, 25, 10, 1}, 1)).toRewindAndMax().isEqualTo(30);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{30, 15, 25, 10, 1}, 2)).toRewindAndMax().isEqualTo(30);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{30, 15, 25, 10, 1}, 3)).toRewindAndMax().isEqualTo(30);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1})).isNotNull().toRewindAndMax().isEqualTo(1);

        try {
            Raw.byteBufferAssertion().toRewindAndMax();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).toRewindAndMax();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").toRewindAndMax();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{2, 1})).toRewindAndMax()).isEqualTo(0);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{2, 1}), "Message").toRewindAndMax()).isEqualTo(0);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{2, 1})).toRewindAndMax().isEqualTo(4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4b> but was:<2b>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{2, 1}), "Message").toRewindAndMax().isEqualTo(4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4b> but was:<2b>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{2, 1}, 1)).toRewindAndMax().isEqualTo(4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4b> but was:<2b>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{2, 1}, 1), "Message").toRewindAndMax().isEqualTo(4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4b> but was:<2b>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void toRewindAndMaxMatcherTest() {
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).toRewindAndMax(Matchers.nullValue());
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1})).toRewindAndMax(Matchers.is(Matchers.equalTo((byte) 1)));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{15, 25, 10, 1})).toRewindAndMax(Matchers.is(Matchers.equalTo((byte) 25)));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{Byte.MAX_VALUE, 100, -100, 100, 100})).toRewindAndMax(Matchers.is(Matchers.equalTo(Byte.MAX_VALUE)));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{100, -100, 100, 100, Byte.MAX_VALUE})).toRewindAndMax(Matchers.is(Matchers.equalTo(Byte.MAX_VALUE)));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{100, -100, Byte.MAX_VALUE, 100, 100})).toRewindAndMax(Matchers.is(Matchers.equalTo(Byte.MAX_VALUE)));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{30, 15, 25, 10, 1}, 1)).toRewindAndMax(Matchers.is(Matchers.equalTo((byte) 30)));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{30, 15, 25, 10, 1}, 2)).toRewindAndMax(Matchers.is(Matchers.equalTo((byte) 30)));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{30, 15, 25, 10, 1}, 3)).toRewindAndMax(Matchers.is(Matchers.equalTo((byte) 30)));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1})).isNotNull().toRewindAndMax(Matchers.is(Matchers.equalTo((byte) 1))).isInstanceOf(ByteBuffer.class);

        try {
            Raw.byteBufferAssertion().toRewindAndMax(Matchers.equalTo((byte) 0));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).toRewindAndMax(Matchers.equalTo((byte) 0));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").toRewindAndMax(Matchers.equalTo((byte) 0));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).toRewindAndMax(null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").toRewindAndMax(null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1})).toRewindAndMax(null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1}), "Message").toRewindAndMax(null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{2, 1})).toRewindAndMax(Matchers.equalTo((byte) 4));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\nExpected: <4>\n     but: was <2>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{2, 1}), "Message").toRewindAndMax(Matchers.equalTo((byte) 4));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\nExpected: <4>\n     but: was <2>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{2, 1}, 1)).toRewindAndMax(Matchers.equalTo((byte) 4));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\nExpected: <4>\n     but: was <2>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{2, 1}, 1), "Message").toRewindAndMax(Matchers.equalTo((byte) 4));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\nExpected: <4>\n     but: was <2>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void hasMaxPrimitiveTest() {
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1})).hasMax(1);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{15, 25, 10, 1})).hasMax(25);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{Byte.MAX_VALUE, 100, -100, 100, 100})).hasMax(Byte.MAX_VALUE);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{100, -100, 100, 100, Byte.MAX_VALUE})).hasMax(Byte.MAX_VALUE);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{100, -100, Byte.MAX_VALUE, 100, 100})).hasMax(Byte.MAX_VALUE);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{30, 15, 25, 10, 1}, 1)).hasMax(25);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{30, 15, 25, 10, 1}, 2)).hasMax(25);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{30, 15, 25, 10, 1}, 3)).hasMax(10);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1})).isNotNull().hasMax(1).isInstanceOf(ByteBuffer.class);

        try {
            Raw.byteBufferAssertion().hasMax(0);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).hasMax(0);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").hasMax(0);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{2, 1})).hasMax(4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4b> but was:<2b>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{2, 1}), "Message").hasMax(4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4b> but was:<2b>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{2, 1}, 1)).hasMax(4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4b> but was:<1b>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{2, 1}, 1), "Message").hasMax(4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4b> but was:<1b>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void hasMaxObjectTest() {
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).hasMax(null);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1})).hasMax(Byte.valueOf("1"));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{15, 25, 10, 1})).hasMax(Byte.valueOf("25"));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{Byte.MAX_VALUE, 100, -100, 100, 100})).hasMax(Byte.valueOf("127"));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{100, -100, 100, 100, Byte.MAX_VALUE})).hasMax(Byte.valueOf("127"));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{100, -100, Byte.MAX_VALUE, 100, 100})).hasMax(Byte.valueOf("127"));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{30, 15, 25, 10, 1}, 1)).hasMax(Byte.valueOf("25"));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{30, 15, 25, 10, 1}, 2)).hasMax(Byte.valueOf("25"));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{30, 15, 25, 10, 1}, 3)).hasMax(Byte.valueOf("10"));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1})).isNotNull().hasMax(Byte.valueOf("1")).isInstanceOf(ByteBuffer.class);

        try {
            Raw.byteBufferAssertion().hasMax(Byte.valueOf("0"));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).hasMax(Byte.valueOf("0"));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").hasMax(Byte.valueOf("0"));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).hasMax(null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").hasMax(null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1})).hasMax(null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual value should be null.\n\tActual:<1b>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1}), "Message").hasMax(null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual value should be null.\n\tActual:<1b>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{2, 1})).hasMax(Byte.valueOf("4"));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4b> but was:<2b>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{2, 1}), "Message").hasMax(Byte.valueOf("4"));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4b> but was:<2b>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{2, 1}, 1)).hasMax(Byte.valueOf("4"));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4b> but was:<1b>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{2, 1}, 1), "Message").hasMax(Byte.valueOf("4"));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4b> but was:<1b>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void hasRewindAndMaxPrimitiveTest() {
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1})).hasRewindAndMax(1);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{15, 25, 10, 1})).hasRewindAndMax(25);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{Byte.MAX_VALUE, 100, -100, 100, 100})).hasRewindAndMax(Byte.MAX_VALUE);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{100, -100, 100, 100, Byte.MAX_VALUE})).hasRewindAndMax(Byte.MAX_VALUE);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{100, -100, Byte.MAX_VALUE, 100, 100})).hasRewindAndMax(Byte.MAX_VALUE);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{30, 15, 25, 10, 1}, 1)).hasRewindAndMax(30);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{30, 15, 25, 10, 1}, 2)).hasRewindAndMax(30);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{30, 15, 25, 10, 1}, 3)).hasRewindAndMax(30);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1})).isNotNull().hasRewindAndMax(1).isInstanceOf(ByteBuffer.class);

        try {
            Raw.byteBufferAssertion().hasRewindAndMax(0);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).hasRewindAndMax(0);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").hasRewindAndMax(0);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{2, 1})).hasRewindAndMax(4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4b> but was:<2b>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{2, 1}), "Message").hasRewindAndMax(4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4b> but was:<2b>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{2, 1}, 1)).hasRewindAndMax(4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4b> but was:<2b>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{2, 1}, 1), "Message").hasRewindAndMax(4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4b> but was:<2b>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void hasRewindAndMaxObjectTest() {
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).hasRewindAndMax(null);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1})).hasRewindAndMax(Byte.valueOf("1"));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{15, 25, 10, 1})).hasRewindAndMax(Byte.valueOf("25"));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{Byte.MAX_VALUE, 100, -100, 100, 100})).hasRewindAndMax(Byte.valueOf("127"));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{100, -100, 100, 100, Byte.MAX_VALUE})).hasRewindAndMax(Byte.valueOf("127"));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{100, -100, Byte.MAX_VALUE, 100, 100})).hasRewindAndMax(Byte.valueOf("127"));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{30, 15, 25, 10, 1}, 1)).hasRewindAndMax(Byte.valueOf("30"));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{30, 15, 25, 10, 1}, 2)).hasRewindAndMax(Byte.valueOf("30"));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{30, 15, 25, 10, 1}, 3)).hasRewindAndMax(Byte.valueOf("30"));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1})).isNotNull().hasRewindAndMax(Byte.valueOf("1")).isInstanceOf(ByteBuffer.class);

        try {
            Raw.byteBufferAssertion().hasRewindAndMax(Byte.valueOf("0"));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).hasRewindAndMax(Byte.valueOf("0"));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").hasRewindAndMax(Byte.valueOf("0"));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).hasRewindAndMax(null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").hasRewindAndMax(null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1})).hasRewindAndMax(null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual value should be null.\n\tActual:<1b>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1}), "Message").hasRewindAndMax(null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual value should be null.\n\tActual:<1b>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{2, 1})).hasRewindAndMax(Byte.valueOf("4"));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4b> but was:<2b>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{2, 1}), "Message").hasRewindAndMax(Byte.valueOf("4"));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4b> but was:<2b>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{2, 1}, 1)).hasRewindAndMax(Byte.valueOf("4"));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4b> but was:<2b>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{2, 1}, 1), "Message").hasRewindAndMax(Byte.valueOf("4"));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4b> but was:<2b>");
        }
    }

}
